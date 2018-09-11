package com.shop.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;

import xframe.codec.MdUtils;
import xframe.kit.HttpKit;
import xframe.kit.MapKit;
import xframe.trans.TransResponse;

import com.alibaba.fastjson.JSON;
import com.p2g.core.Constants;
import com.p2g.core.base.BaseController;
import com.p2g.core.support.HttpCode;
import com.p2g.core.support.exception.BaseException;
import com.p2g.core.support.exception.IllegalParameterException;
import com.p2g.core.util.RedisUtil;
import com.shop.util.AuthUtils;
import com.shop.util.StringReplaceUtil;

/**
 * Created on 2016-06-30 11:44.
 *
 * @author FanShukui
 */
public class MyBaseController extends BaseController {

    protected static final String JSP_404 = "common/404";
    protected static final String JSP_500 = "common/500";


    @Value("#{configProperties['h5.url']}")
    protected String myUrl;

    @Value("#{configProperties['svr.url']}")
    protected String svrUrl;
    @Value("#{configProperties['svr.sign.key']}")
    protected String svrSignKey;

    @Value("#{configProperties['openid.cookie.name']}")
    protected String openidCookieName;

    @Value("#{configProperties['cookie.domain']}")
    protected String cookieDomain;


    @Value("#{configProperties['weixin.url']}")
    protected String weixinUrl;
    @Value("#{configProperties['weixin.sign.key']}")
    protected String weixinSignKey;

    @Value("#{configProperties['weixin.share.img']}")
    protected String wxShareImg;
    
    @Value("#{configProperties['weixin.share.xjhb.img']}")
    protected String wxShareXjHbImg;

    @Value("#{configProperties['weixin.share.title']}")
    protected String wxShareTitle;

    @Value("#{configProperties['weixin.share.link']}")
    protected String wxShareLink;

    @Value("#{configProperties['weixin.share.desc']}")
    protected String wxShareDesc;
    
    protected Long getMyCurrUser() {
        Object res = this.getCurrUser();
        return res != null?(Long)res:null;
    }

    protected ResponseEntity<TransResponse> setSuccessResponse(Map<String,Object> paramsMap){
        TransResponse transResponse = new TransResponse();
        transResponse.setRet("0000");
        transResponse.setMsg("成功");
        transResponse.setValue(JSON.toJSONString(paramsMap));
        return ResponseEntity.ok(transResponse);
    }

    protected ResponseEntity<TransResponse> setErrorResponse(String errorCode,String msg){
        return setErrorResponse(errorCode,msg,null);
    }

    protected ResponseEntity<TransResponse> setErrorResponse(String errorCode,String msg,Map<String,Object> paramsMap){
        TransResponse transResponse = new TransResponse();
        transResponse.setRet(errorCode);
        transResponse.setMsg(msg);
        if(paramsMap != null && !paramsMap.isEmpty())
            transResponse.setValue(JSON.toJSONString(paramsMap));
        return ResponseEntity.ok(transResponse);
    }

    /** 异常处理 */
    @ExceptionHandler(RuntimeException.class)
    @Override
    public void exceptionHandler(HttpServletResponse response, Exception ex) throws Exception {
        logger.error(Constants.Exception_Head, ex);
        ModelMap modelMap = new ModelMap();
        if (ex instanceof BaseException) {
            ((BaseException) ex).handler(modelMap);
        } else if (ex instanceof IllegalArgumentException) {
            new IllegalParameterException(ex.getMessage()).handler(modelMap);
        } else {
            setModelMap(modelMap, HttpCode.INTERNAL_SERVER_ERROR);
        }
        logger.info("异常处理返回内容："+JSON.toJSONString(modelMap));
		response.sendRedirect("/login/err500");
    }

    protected void writerStr(HttpServletResponse response, String jsonStr)
            throws IOException {
        response.setCharacterEncoding("UTF-8");

        response.getWriter().write(jsonStr);
        response.getWriter().flush();
    }

    /**
     * 微信分享初始数据
     * @param request
     * @param modelMap
     */
    protected void initWxShare(HttpServletRequest request,ModelMap modelMap){
        initWxShare(request,modelMap,myUrl+wxShareLink,wxShareTitle,wxShareDesc);
    }

    /**
     * 微信分享初始数据
     * @param request
     * @param modelMap
     */
    protected void initWxShare(HttpServletRequest request,ModelMap modelMap,String link){
        initWxShare(request,modelMap,link,wxShareTitle,wxShareDesc);
    }

    /**
     * 微信分享初始数据
     * @param request
     * @param modelMap
     */
    protected void initWxShare(HttpServletRequest request,ModelMap modelMap,String link,String title,String desc){
        initWxShare(request,modelMap,link,title,desc,myUrl+wxShareImg);
    }

    /**
     * 微信分享初始数据
     * @param request
     * @param modelMap
     */
    protected void initWxShare(HttpServletRequest request,ModelMap modelMap,String link,String title,String desc,String imgUrl){
        try {
            String url = weixinUrl + "/api/wxShareParams";
            Map<String, String> params = new HashMap<>();
            params.put("reqUrl", getLink(request));
            String signStr = MapKit.sortMap(params);
            String sign = MdUtils.md5(signStr + "&key=" + weixinSignKey);
            params.put("sign", sign);
            String res = HttpKit.get(url, params);
            logger.debug("微信分享初始数据："+res);
            Map map = JSON.parseObject(res,Map.class);

            modelMap.addAttribute("appId", map.get("appId"));
            modelMap.addAttribute("timestamp", map.get("timestamp"));
            modelMap.addAttribute("noncestr", map.get("noncestr"));
            modelMap.addAttribute("signature", map.get("signature"));
            modelMap.addAttribute("link", link);
            modelMap.addAttribute("title", title);
            modelMap.addAttribute("imgUrl", imgUrl);
            modelMap.addAttribute("desc", desc);
        }catch (Exception e){
            logger.error("微信分享初始数据异常",e);
        }
    }

    /**
     * 获取当前访问地址
     * @param request
     * @return
     */
    protected String getLink(HttpServletRequest request)
    {
        String qs = request.getQueryString();
        String target = request.getRequestURI();
        String link = qs == null ? target : target + "?" + qs;
        String res = myUrl+link;
        logger.debug("获取当前访问地址："+res);
        return res;
    }

    /**
     * 获取用户微信信息
     * @param openId
     * @return
     */
    protected Map<String, Object> getWxInfo(String openId){
    	Map<String, Object> wxUsrMap = new HashMap<>();
        //获取unionId
        Map<String, String> params = new HashMap<>();
        params.put("openId", openId);
        String signStr = MapKit.sortMap(params);
        try {
            String sign = MdUtils.md5(signStr + "&key=" + weixinSignKey);
            params.put("sign", sign);
            String infoRes = HttpKit.get(weixinUrl + "/wxUser/info", params);
            Map<String, String> infoMap = (Map<String, String>) JSON.parse(infoRes);
            String unionId = infoMap.get("unionId");
            if (StringUtils.isNoneBlank(unionId)) wxUsrMap.put("unionId", unionId);
            String nickName = infoMap.get("nickName");
            wxUsrMap.put("nickName", StringReplaceUtil.clearSpeChar(nickName));
            String headImgUrl = infoMap.get("headImgUrl");
            wxUsrMap.put("headImgUrl", headImgUrl);
        } catch (Exception e) {
            logger.error("异常", e);
        }
        return wxUsrMap;
    }

    /**
     * 把openId对应key存入cookie，微信信息存入redis
     * @param response
     * @param wxUsrMap
     */
    protected void addOpenIdCookie(HttpServletResponse response,Map wxUsrMap){
        //把openId对应key存入cookie
        try {
            String openidKey = com.shop.common.Constants.OPENIDKEY + RandomStringUtils.randomNumeric(10);
            Cookie cookie = AuthUtils.createtCookie(openidCookieName, cookieDomain, 3600, openidKey);
            response.addCookie(cookie);
            //存入缓存
            RedisUtil.setex(openidKey, 3600, JSON.toJSONString(wxUsrMap));
//                    String redisOpenidKey = WebUtil.getCookieValue(request,openidCookieName,"default");
//                    String jsonStr = RedisUtil.get(redisOpenidKey,5);

        } catch (Exception e) {
            logger.error("把openId对应key存入cookie异常，", e);
        }
    }
    
}
