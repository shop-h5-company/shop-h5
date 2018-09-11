package com.shop.web;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeWapPayModel;
import com.alipay.api.request.AlipayTradeWapPayRequest;
import com.alipay.api.response.AlipayTradeWapPayResponse;
import com.alipay.config.AlipayConfig;
import com.shop.mybatis.model.generator.Users;
import com.shop.service.UserService;

/**
 * 
  * HomeController
  * 首页接口
  * @author xujianwei
  * @date 2017年9月20日 下午1:19:04
  *
 */
@Controller
@RequestMapping("/home")
public class HomeController extends MyBaseController {
	@Autowired
    UserService userService;
    public static final String JSP_PATH = "home/";

    @RequestMapping("index")
    public String index(HttpServletRequest request,ModelMap modelMap,String alert){
    	//普通用户登录时，给其提示代理的微信号、提示添加才可以抽奖
    	Long userId = getMyCurrUser();
        if(userId != null){
        	Users user = userService.queryById(userId);
        	modelMap.put("user", user);
        	if(user.getJurisdiction().equals("0")){//用户
        		if(user.getAddFriend() == null || !user.getAddFriend().equals("0")){//并且未审核、或审核拒绝的用户，才给这个提示
        			Users topUser = userService.queryById(user.getTopLevel());
        			modelMap.put("weixin", topUser.getWeixin());
        		}
        	}
        }
    	if(alert != null && alert.equals("noUserName")){ //用于未填写微信昵称时，跳转到首页，alert提示。
    		modelMap.put("alert", true);
    	}
        return JSP_PATH + "index";
    }
    /**
     * 测试调用支付宝支付
     * @param request
     * @param modelMap
     * @param alert
     * @return
     * @throws AlipayApiException 
     */
    @RequestMapping("ceshi")
    public String ceshi(HttpServletRequest request,ModelMap modelMap,String alert) throws AlipayApiException{
    	
		return "alipay/pay";
    }
    
    @RequestMapping("unbindWx")
    public String unbindWeixin(){
//        userChangeLogService.modifyUserWeixin(userId);

        SecurityUtils.getSubject().logout();
        return "redirect:"+myUrl+"/login/toWxLogin";
    }
    
    @RequestMapping("outLogin")
    public String outLogin(){
        SecurityUtils.getSubject().logout();
        return "redirect:"+myUrl+"/login/toLogin";
    }
}
