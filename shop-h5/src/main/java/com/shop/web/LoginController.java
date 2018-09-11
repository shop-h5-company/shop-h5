package com.shop.web;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.util.SavedRequest;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import xframe.codec.MdUtils;
import xframe.kit.MapKit;
import xframe.kit.ServletKit;
import xframe.trans.TransResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeWapPayModel;
import com.alipay.api.request.AlipayTradeWapPayRequest;
import com.alipay.config.AlipayConfig;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.github.pagehelper.PageInfo;
import com.p2g.core.support.Assert;
import com.p2g.core.support.login.LoginHelper;
import com.p2g.core.util.DataUtil;
import com.shop.common.Constants;
import com.shop.common.RandomUtil;
import com.shop.mybatis.model.generator.AlipayRecord;
import com.shop.mybatis.model.generator.InviteAuthorityCode;
import com.shop.mybatis.model.generator.Users;
import com.shop.service.AlipayRecordService;
import com.shop.service.InviteAuthorityCodeService;
import com.shop.service.UserService;
import com.shop.util.BeanUtil;
import com.shop.util.CaptchaUtil;
import com.shop.vo.ReturnObjectVO;
import com.shop.vo.WxUsrDto;

/**
 * 
  * LoginController
  * TODO 登录
  * @author xujianwei
  * @date 2017年9月20日 下午1:10:20
  *
 */
@Controller
@RequestMapping("/login")
public class LoginController extends MyBaseController {
	
	protected static Logger logger = Logger.getLogger(LoginController.class);
	
    public static final String JSP_PATH = "login/";
    
    @Autowired
    UserService userService;
    @Autowired
    InviteAuthorityCodeService inviteAuthorityCodeService;
    @Autowired
    AlipayRecordService alipayRecordService;

    @RequestMapping("toLogin")
    public String toLogin(HttpServletRequest request, ModelMap modelMap, String backUrl) {
        if(StringUtils.isNoneBlank(backUrl)){
            modelMap.addAttribute("backUrl", backUrl);
        }else {
            SavedRequest savedRequest = WebUtils.getSavedRequest(request);
            if (savedRequest != null) {
                backUrl = savedRequest.getRequestURI();
                modelMap.addAttribute("backUrl", backUrl);
            }
        }
        SecurityUtils.getSubject().logout();
        
        return JSP_PATH + "login";
    }

    
    /**
     * 登录
     *
     * @param mobile
     * @param password inviteAuthorityCode
     * @return
     */
    @ResponseBody
    @RequestMapping("loginSubmit")
    public String loginSubmit(HttpServletRequest request,HttpSession session,
                              @RequestParam(value = "mobile", required = true) String mobile,
                              @RequestParam(value = "password", required = true) String password,
                              @RequestParam(value = "inviteAuthorityCode", required = true) String inviteAuthorityCode) {
        Assert.notNull(mobile, "MOBILE");
        Assert.notNull(password, "PASSWORD");
        TransResponse transResponse = new TransResponse();
        if (DataUtil.isEmpty(mobile)) {
            transResponse.setRet("5");
            transResponse.setMsg("手机号不能为空请输入!");
            return JSON.toJSONString(transResponse);
        }
        if (!isPhone(mobile)) {
            transResponse.setRet("3");
            transResponse.setMsg("您的手机号有误，请重新输入！");
            logger.debug("您的手机号有误，请重新输入！");
            return JSON.toJSONString(transResponse);
        }

        if (StringUtils.isBlank(password)) {
            transResponse.setRet("6");
            transResponse.setMsg("密码不能为空请输入!");
            return JSON.toJSONString(transResponse);
        }

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("countSql", 0);
        params.put("mobile", mobile);
        params.put("status", "enabled");
        PageInfo<Users> pageInfo = userService.query(params);
        if (pageInfo.getSize() == 1) {
            Users users = pageInfo.getList().get(0);
            try {
                if (LoginHelper.login(mobile, userService.encryptPassword(password, users.getLoginPasswordSalt()))) {
                	//saveSession(request, users.getUserId(),"wap");
                    transResponse.setRet("0");
                    transResponse.setMsg("登录成功!");
                    String weixin = users.getWeixin();
                    if(null == weixin){ //如果该用户未设置微信名，则影响部分功能
                    	//transResponse.setWeixin("");
                    }
                    /*if (StringUtils.isBlank(weixin)) {
                        String redisOpenidKey = WebUtil.getCookieValue(request, openidCookieName, "default");
                        String jsonStr = RedisUtil.get(redisOpenidKey);
                        if (StringUtils.isNoneBlank(jsonStr)) {
                            JSONObject jsonObject = JSONObject.parseObject(jsonStr);
                            String openId = Objects.toString(jsonObject.get("openId"), "");
                            Users wxUser = userService.queryByWeixin(openId);
                            if(wxUser == null) {
                                String unionId = Objects.toString(jsonObject.get("unionId"), "");
                                String nickName = Objects.toString(jsonObject.get("nickName"), "");
                                String headImgUrl = Objects.toString(jsonObject.get("headImgUrl"), "");
                                users.setWeixin(openId);
                                users.setUnionId(unionId);
                                users.setNickName(nickName);
                                users.setHeadImgUrl(headImgUrl);
                                users.setWeixinBindTime(new Date());
                                userService.update(users);
                            }else{
                                logger.debug("该微信已开启自动登陆");
                            }
                        }
                    }*/
                    if(users.getJurisdiction().equals("7")){ //查看代理的可邀请人数
                    	transResponse.setMsg("7");
                    	transResponse.setValue(users.getInvitePersonNum().toString());
                    }else{
                    	transResponse.setMsg("0");//用户、仓管
                    }
                    //如果邀请码不为null，并且确实存在。则1、更新邀请码表的手机号  
                    if(!inviteAuthorityCode.isEmpty() && users.getJurisdiction().equals("7")){
                    	InviteAuthorityCode code = inviteAuthorityCodeService.getByCode(inviteAuthorityCode);
                    	if(code !=null){ //确实存在这个邀请码
                    		if(code.getUsed().equals("0")){ //该码未曾使用过。
                    			InviteAuthorityCode code2 = new InviteAuthorityCode();
                    			code2.setInviteCode(inviteAuthorityCode);
                    			//code2.setTelephone(mobile);
                    			code2.setTelephoneUse(mobile);
                    			code2.setUsed("1");//该邀请权限码已使用
                    			inviteAuthorityCodeService.updateByPrimaryKeySelective(code2);
                    			//2、更新users表的可邀请人数。
                    			Users user = userService.selectByMobile(mobile);
                    			Users user2 = new Users();
                    			user2.setUserId(user.getUserId());
                    			user2.setInvitePersonNum(code.getInvitePersonNum());
                    			userService.updateInvitePersonNum(user2);
                    		}else if(code.getUsed().equals("1")){ //使用过，则看看该邀请码是否属于登陆者（算了，直接给出提示：该邀请权限码已被使用）
                    			transResponse.setRet("-1");
                                transResponse.setMsg("该邀请权限码已被使用!");
                                return JSON.toJSONString(transResponse);
                    	}
                    }
                   }
                    //登录成功设置session时间
                    session.setMaxInactiveInterval(1000*60*20);//20分钟
                  }
            } catch (Exception e) {
                logger.error("用户登录异常", e);
            }
        } else {
            transResponse.setRet("-1");
            transResponse.setMsg("该手机号未注册，赶紧去注册吧!");
        }
        /*logger.debug("登录成功！测试日志文件debug");
        logger.error("登录成功！测试日志文件error"); //日志只记录error，减小压力。
        logger.info("登录成功！测试日志文件info");*/
        return JSON.toJSONString(transResponse);
    }
    /**
     * 进入购买权限邀请码页面
     * @param inviteNum 可邀请人数（给代理提示可邀请人数不足）
     * @return
     */
    @RequestMapping("inviteAuthorityCode")
    public Object inviteAuthorityCode(HttpServletRequest request,Integer inviteNum,ModelMap modelMap) {
    	
    	if(null == inviteNum){
    		Long id = getMyCurrUser();
        	Users user = userService.queryById(id);
        	inviteNum = user.getInvitePersonNum();
    	}
    	
    	modelMap.put("inviteNum", inviteNum);
    	//return "redirect:/home/index";
    	return "/login/priceForm";
    }
    /**
     * 进入我的权限邀请码页面
     * @return
     */
    @RequestMapping("myInviteAuthorityCode")
    public Object myInviteAuthorityCode(ModelMap modelMap) {
		Long id = getMyCurrUser();
		Users user = userService.queryById(id);
		int inviteNum = user.getInvitePersonNum();
    	modelMap.put("inviteNum", inviteNum);//剩余可邀请人数
    	
    	List<InviteAuthorityCode> list = inviteAuthorityCodeService.findByTelephoneBuy(user.getMobile());
    	modelMap.put("inviteAuthorityCodes", list);//购买的邀请码列表
    	
    	//return "redirect:/home/index";
    	return "/login/myInviteAuthorityCode";
    }
    /**
     * 获取我的权限邀请码
     * @return
     */
    @RequestMapping("getMyInviteAuthorityCode")
    @ResponseBody
    public JSONObject getMyInviteAuthorityCode() {
    	JSONObject json = new JSONObject();
    	Long id = getMyCurrUser();
    	Users user = userService.queryById(id);
    	
    	List<InviteAuthorityCode> list = inviteAuthorityCodeService.findByTelephoneBuy(user.getMobile());
    	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	for(InviteAuthorityCode iac:list){
    		iac.setTimeBuyString(df.format(iac.getTimeBuy()));
    		if(iac.getTimeUsed() != null){
    			iac.setTimeUsedString(df.format(iac.getTimeUsed()));
    		}else{
    			iac.setTimeUsedString("未使用");
    		}
    		//iac.setUsedString(Integer.parseInt(iac.getUsed())==0?"未使用":"已使用");
    		iac.setTelephoneUse(iac.getTelephoneUse().equals("")?"未使用":iac.getTelephoneUse());
    	}
    	json.put("list", list);
    	//return "redirect:/home/index";
    	return json;
    }
    
    /**
     * 代理购买邀请权限码
     * @return
     */
    @RequestMapping("weixinBuy")
    public Object weixinBuy(HttpServletRequest request,Integer inviteNum,ModelMap modelMap) {
    	
    	if(null == inviteNum){
    		Long id = getMyCurrUser();
        	Users user = userService.queryById(id);
        	inviteNum = user.getInvitePersonNum();
    	}
    	
    	modelMap.put("inviteNum", inviteNum);
    	
    	return "/login/weixinBuy";
    }
   /**
    * 支付宝支付，调用手机支付宝软件。
    * @param typePay 所选radio的金额
    * @param buyNumber 购买数量
    * @param realPay 总支付金额(元)
    * 
    * @param ifHaveActivity  是否有活动（是否开展活动，不在前端通知后端，只在后端配置。）
    * @param response
    */
    @RequestMapping("aliPay")
    @ResponseBody
    public void aliBuy(String typePay ,Integer buyNumber,String realPay,String ifHaveActivity, HttpServletResponse response) {
    	
    	ifHaveActivity = "0"; //没有活动
    	
    	Long userId = getMyCurrUser();
    	if(userId == null){ //没登录访问
    		return;
    	}
    	//System.out.println("pay:"+pay); // 20/20次
    	// 商户订单号，商户网站订单系统中唯一订单号，必填
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String out_trade_no = df.format(new Date());//订单编号
    	// 订单名称，必填
        String subject = new String("购买邀请权限码");//订单名称
    	System.out.println(subject);
        // 付款金额，必填
    	int a = (Integer.parseInt(typePay))*buyNumber;
    	int b = Integer.parseInt(realPay);
    	if(a != b){
    		logger.error("选项金额*购买数量与总金额不符，依次为："+typePay+","+buyNumber+","+realPay);
    		return;//不予支付。（另：实际支付权限码时，也以支付宝返回的金额为准，防止恶意修改）
    	}
        //String total_amount="0.01";
        String total_amount=realPay;
        // 商品描述，可空
        String body = new String("测试支付");
        // 超时时间 可空
       String timeout_express="2m";
        // 销售产品码 必填
        String product_code="QUICK_WAP_WAY";
        /**********************/
        // SDK 公共请求类，包含公共请求参数，以及封装了签名与验签，开发者无需关注签名与验签     
        //调用RSA签名方式
        AlipayClient client = new DefaultAlipayClient(AlipayConfig.URL, 
										        		AlipayConfig.APPID, 
										        		AlipayConfig.RSA_PRIVATE_KEY, 
										        		AlipayConfig.FORMAT, 
										        		AlipayConfig.CHARSET, 
										        		AlipayConfig.ALIPAY_PUBLIC_KEY,
										        		AlipayConfig.SIGNTYPE);
        AlipayTradeWapPayRequest alipay_request=new AlipayTradeWapPayRequest();
        
        // 封装请求支付信息
        AlipayTradeWapPayModel model=new AlipayTradeWapPayModel();
        model.setOutTradeNo(out_trade_no);
        model.setSubject(subject);
        model.setTotalAmount(total_amount);
        model.setBody(body);
        model.setTimeoutExpress(timeout_express);
        model.setProductCode(product_code);
        alipay_request.setBizModel(model);
        // 设置异步通知地址
        //alipay_request.setNotifyUrl(AlipayConfig.notify_url);
        // 设置同步地址
        alipay_request.setReturnUrl(AlipayConfig.return_url);   
        
        // form表单生产
        String form = "";
    	try {
    		// 调用SDK生成表单
    		form = client.pageExecute(alipay_request).getBody();
    		response.setContentType("text/html;charset=" + AlipayConfig.CHARSET); 
    	    response.getWriter().write(form);//直接将完整的表单html输出到页面 
    	    response.getWriter().flush(); 
    	    response.getWriter().close();
    	} catch (AlipayApiException e) {
    		e.printStackTrace();
    	} catch (IOException e) {
			e.printStackTrace();
		}
    	//生成待支付订单
    	AlipayRecord alipayRecord = new AlipayRecord();
    	alipayRecord.setMoney(realPay+".00");//存储的金额带两位小数。项目中没有角分的零钱。
    	alipayRecord.setOutTradeNo(out_trade_no);
    	alipayRecord.setStatus("0");
    	alipayRecord.setUserId(userId);
    	alipayRecord.setTime(new Date());
    	alipayRecord.setBuyNumber(buyNumber);
    	alipayRecord.setIfHaveActivity(ifHaveActivity);
    	//（1）20元（20次）"（2）40元/50次" "（3）70元/100次" "（4）130元/200次" "（5）260元/500次" "（6）450元/1000次"
    	if(typePay.equals("20")){
    			alipayRecord.setType("1");
    	}else if(typePay.equals("40")){
    			alipayRecord.setType("2");
    	}else if(typePay.equals("70")){
    			alipayRecord.setType("3");
    	}else if(typePay.equals("130")){
    			alipayRecord.setType("4");
    	}else if(typePay.equals("260")){
    			alipayRecord.setType("5");
    	}else if(typePay.equals("450")){
    			alipayRecord.setType("6");
    	}
    	alipayRecordService.save(alipayRecord);
    }
    /**
     * 支付宝回调方法(支付宝用get方式请求)
     * @throws Exception 
     *  支付宝传的参数：
    	 * http://39.106.188.246:8080/alipay/return_url.jsp?
    	 * total_amount=0.01
    	 * &timestamp=2018-05-17+13%3A28%3A54
    	 * &sign=sfJOOoSC%2FwSfU73sjaG3SFuF4NrsXLG18xjDCvG5bxsf1APT5s4yss8Hiak%2F9lXrkA7WtGN%2FS%2BPKgtRIExPP6AG2NhngM%2Br6IK91GS%2BouJXy1QTveI3OtstBpJSnmIR%2B%2BC%2F%2Fhh46FnbWQyVTb2qxSVQz%2B3VHR6jCHWLbZEiImh7%2FCDnLsDZ5JicDRtG3N%2BLqHPXmiqXA2TQ5hrgurAV%2BRO1I3KTLYnW1ZfnYo9sVPM%2B6Aztg31lR6zqX1tbk27cdWrTG2Xb6zpK2qCkbPxD%2B3dMcukNORdF91IGhBkZMv9Wmexp9nECuZ1%2FJGevnys1zEh%2FFVFg3pHxKom3rvypjgQ%3D%3D
    	 * &trade_no=2018051721001004500571704224
    	 * &sign_type=RSA2
    	 * &auth_app_id=2018042760052343
    	 * &charset=UTF-8
    	 * &seller_id=2088702821544832
    	 * &method=alipay.trade.wap.pay.return
    	 * &app_id=2018042760052343
    	 * &out_trade_no=20180517132834583
    	 * &version=1.0
    	 * 
    	 * total_amount=20.00
    	 * &timestamp=2018-05-22+16%3A12%3A51&sign=lN3WgP8O9gMwTvWqhlYJtydDw2gNRwY1sn5dybkfEHKL3QEe7O49uOPvuVp7EYT0S140lf3IlR9U4T4bNaJ5axIyzi41MRb%2B%2FN0qj6iInRVfK2Kh8z4pS8yyWAxa1MFDInZhENAmWTOKXp9jhAtZUyZEqOksso4hlpLMuGiiqOSy6cp%2FuuSCduU7NqJ4jxMF%2F3Ba2wVNflJwtdSZQ83Zlw72JRm2KxrlnRl%2Bccxfudy2UyPGEfL%2BJP4HQwLv2Fb9konohECyMVOIR15dky9gqCO%2FlZe8dVjcE%2FVLJX6bPyB0dRqBNIO%2FoGGLvAW2BlNlkKqpxW6qSiA4XQNK4767mg%3D%3D
    	 * &trade_no=2018052221001004590299001268
    	 * &sign_type=RSA2
    	 * &auth_app_id=2018042760052343
    	 * &charset=UTF-8&seller_id=2088702821544832
    	 * &method=alipay.trade.wap.pay.return
    	 * &app_id=2018042760052343
    	 * &out_trade_no=20180522161114472
    	 * &version=1.0 HTTP/1.1" 302
     */
    @RequestMapping("callback")
    public String callback(String out_trade_no,String total_amount) throws Exception{
    	
    	AlipayRecord alipayRecord = alipayRecordService.findByOutTradeNo(out_trade_no);//启动支付宝软件时，存储的数据
    	Long userId = alipayRecord.getUserId();
    	String money = alipayRecord.getMoney();
		if(money.equals(total_amount) && alipayRecord.getStatus().equals("0")){ //确定本次订单的，用户选定金额、支付金额、支付宝回调金额，一致。（防止恶意修改支付金额）
			/**根据付费价格，给用户发放邀请权限码。1、根据金额次数，生成邀请权限码记录。2、同时该条记录的购买者设置为该用户
			 * 备注：首次购买，赠送当前购买次数一半的权限邀请码
			 * 活动：买一送一
			 */
			try {
				String ifHaveActivity = alipayRecord.getIfHaveActivity();//是否有活动
				Users user = userService.queryById(userId);
				int cishu = alipayRecordService.ifFirstBuy(userId,"1");//返回true则是首次用支付宝购买
				//logger.error("是否首次购买："+cishu);
				boolean ifFirstBuy =(cishu == 0)?true:false;
				String type = alipayRecord.getType();//购买的商品类型（1）
				Integer buyNumber = alipayRecord.getBuyNumber();//该商品购买的数量（2）
				//生成权限码记录
				createCode(ifFirstBuy, ifHaveActivity, buyNumber, type, user);
				//最后，修改该订单的支付状态
				if(alipayRecord != null && alipayRecord.getStatus().equals("0")){
					AlipayRecord alipayRecord2 = new AlipayRecord();
					alipayRecord2.setId(alipayRecord.getId());
					alipayRecord2.setStatus("1");//已支付
					alipayRecord2.setTime(new Date());
					alipayRecordService.updateById(alipayRecord2);
				}
			} catch (Exception e) {
				e.printStackTrace();
				logger.error("支付宝支付之后，生成权限码日期："+new Date()+";出错信息:", e);
			}
			
		}else{
			logger.error("支付宝支付回调出错："+new Date()+";金额不一致");
		}
		return "redirect:/user/index";//重定向到我的首页
    }
    /**生成权限码记录。
     * //（1）20元（20次）"（2）40元/50次" "（3）70元/100次" "（4）130元/200次" "（5）260元/500次" "（6）450元/1000次"
     * @param b
     * @param ifHaveActivity
     * @param buyNumber
     * @param type
     * @param user
     */
    public void createCode(boolean ifFirstBuy,String ifHaveActivity,Integer buyNumber,String type,Users user){
    	if(ifFirstBuy){//第一次购买
			/**
			 * 至此，1、只要根据商品类型生成权限码记录即可。2、数量决定记录条数。
			 */
			if(ifHaveActivity.equals("1")){//有活动，买一送一
				buyNumber=buyNumber*2;//有活动，买一送一
				if(type.equals("1")){
					Integer InvitePersonNum = 20+20/2;//初次支付宝购买，赠送一半
					insertBatch(user,buyNumber,InvitePersonNum);
				}else if(type.equals("2")){
					Integer InvitePersonNum = 50+50/2;
					insertBatch(user,buyNumber,InvitePersonNum);
				}else if(type.equals("3")){
					Integer InvitePersonNum = 100+100/2;
					insertBatch(user,buyNumber,InvitePersonNum);
				}else if(type.equals("4")){
					Integer InvitePersonNum = 200+200/2;
					insertBatch(user,buyNumber,InvitePersonNum);
				}else if(type.equals("5")){
					Integer InvitePersonNum = 500+500/2;
					insertBatch(user,buyNumber,InvitePersonNum);
				}else if(type.equals("6")){
					Integer InvitePersonNum = 1000+1000/2;
					insertBatch(user,buyNumber,InvitePersonNum);
				}
			}else{//初次购买，但没有活动
				if(type.equals("1")){
					Integer InvitePersonNum = 20+20/2;//初次支付宝购买，赠送一半
					insertBatch(user,buyNumber,InvitePersonNum);
				}else if(type.equals("2")){
					Integer InvitePersonNum = 50+50/2;
					insertBatch(user,buyNumber,InvitePersonNum);
				}else if(type.equals("3")){
					Integer InvitePersonNum = 100+100/2;
					insertBatch(user,buyNumber,InvitePersonNum);
				}else if(type.equals("4")){
					Integer InvitePersonNum = 200+200/2;
					insertBatch(user,buyNumber,InvitePersonNum);
				}else if(type.equals("5")){
					Integer InvitePersonNum = 500+500/2;
					insertBatch(user,buyNumber,InvitePersonNum);
				}else if(type.equals("6")){
					Integer InvitePersonNum = 1000+1000/2;
					insertBatch(user,buyNumber,InvitePersonNum);
				}
			}
		}else{//不是第一次购买了
			if(ifHaveActivity.equals("1")){//有活动，买一送一
				buyNumber=buyNumber*2;//有活动，买一送一
				if(type.equals("1")){
					Integer InvitePersonNum = 20;
					insertBatch(user,buyNumber,InvitePersonNum);
				}else if(type.equals("2")){
					Integer InvitePersonNum = 50;
					insertBatch(user,buyNumber,InvitePersonNum);
				}else if(type.equals("3")){
					Integer InvitePersonNum = 100;
					insertBatch(user,buyNumber,InvitePersonNum);
				}else if(type.equals("4")){
					Integer InvitePersonNum = 200;
					insertBatch(user,buyNumber,InvitePersonNum);
				}else if(type.equals("5")){
					Integer InvitePersonNum = 500;
					insertBatch(user,buyNumber,InvitePersonNum);
				}else if(type.equals("6")){
					Integer InvitePersonNum = 1000;
					insertBatch(user,buyNumber,InvitePersonNum);
				}
			}else{//没有活动
				if(type.equals("1")){
					Integer InvitePersonNum = 20;
					insertBatch(user,buyNumber,InvitePersonNum);
				}else if(type.equals("2")){
					Integer InvitePersonNum = 50;
					insertBatch(user,buyNumber,InvitePersonNum);
				}else if(type.equals("3")){
					Integer InvitePersonNum = 100;
					insertBatch(user,buyNumber,InvitePersonNum);
				}else if(type.equals("4")){
					Integer InvitePersonNum = 200;
					insertBatch(user,buyNumber,InvitePersonNum);
				}else if(type.equals("5")){
					Integer InvitePersonNum = 500;
					insertBatch(user,buyNumber,InvitePersonNum);
				}else if(type.equals("6")){
					Integer InvitePersonNum = 1000;
					insertBatch(user,buyNumber,InvitePersonNum);
				}
			}
		}
    }
    /**
     * 批量插入权限码
     * @param user
     * @param buyNumber
     * @param InvitePersonNum
     */
    public void insertBatch(Users user,Integer buyNumber,Integer InvitePersonNum){
    	SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");
    	Date timeBuy = new Date();
    	String batchNum = df.format(timeBuy);
    	
		List<InviteAuthorityCode> codes = new ArrayList<InviteAuthorityCode>();
		for(int i=0;i<buyNumber;i++){
			
			InviteAuthorityCode inviteAuthorityCode = new InviteAuthorityCode();
			inviteAuthorityCode.setTimeBuy(timeBuy);
			inviteAuthorityCode.setInvitePersonNum(InvitePersonNum);
			inviteAuthorityCode.setTelephoneBuy(user.getMobile());
			inviteAuthorityCode.setUsed("0");//未使用
			inviteAuthorityCode.setBatchNum(batchNum);//批次号
			
			String uuid = UUID.randomUUID().toString().replace("-", "");
			inviteAuthorityCode.setInviteCode(uuid.substring(0, 16));
			codes.add(inviteAuthorityCode);
		}
		inviteAuthorityCodeService.insertBatch(codes);
    }
    @RequestMapping("success")
    public Object loginSuccess(HttpServletRequest request) {
        String backUrl = request.getParameter("backUrl");
        logger.debug("登录回跳地址："+backUrl);
        if (StringUtils.isNoneBlank(backUrl)) {
            return "redirect:" + backUrl;
        }

        return "redirect:/home/index";
    }

    @RequestMapping(value = "captcha", method = RequestMethod.GET)
    @ResponseBody
    public void captcha(@RequestParam(value = "token", required = true) String token,
                        HttpServletResponse response) {
        try {
            logger.debug("获取图片验证码--token："+token);
			CaptchaUtil.setCaptchaName(CaptchaUtil.captchaName+token);
			CaptchaUtil.outputCaptcha(CaptchaUtil.CAPTCHANAME_PREFIX+token,response);
        } catch (Exception e) {

        }
    }

    @RequestMapping("toRegister")
    public String register(HttpServletRequest request,ModelMap modelMap,Long inviteCode) {
    	//所有普通用户必须填写邀请码，邀请码是上级id，存储到上级字段中。（选择代理、仓管即使填写了，也不做处理）
    	
    	modelMap.put("inviteCode", inviteCode);
        return JSP_PATH + "register";
    }
    @RequestMapping("toRegisterForInviteAgent")
    public String toRegisterForInviteAgent(HttpServletRequest request,ModelMap modelMap,Long inviteCode) {
    	//所有普通用户必须填写邀请码，邀请码是上级id，存储到上级字段中。（选择代理、仓管即使填写了，也不做处理）
    	
    	modelMap.put("inviteCode", inviteCode);
    	return JSP_PATH + "registerForInviteAgent";
    }

    @RequestMapping("forgetPwd")
    public String forgetPwd(HttpServletRequest request,ModelMap modelMap) {
        String token = RandomStringUtils.randomNumeric(8);
        modelMap.put("token",token);
        return JSP_PATH + "forget_pwd";
    }

    public static boolean isPhone(String phone) {
        Pattern pattern = Pattern.compile("^1\\d{10}$");
        return pattern.matcher(phone).matches();
    }

    /** 废弃  2018年5月23日15:18:03 
     * 注册 
     * 判断 邀请人是否存在、手机短信是否正确
     *
     * @param request
     * @param mobile
     * @param password
     * @param inviteCode
     * @param inviteMode
     * @param phoneCode
     * @param deviceSource
     * @return
     */
    @ResponseBody
    @RequestMapping("register22")
    public String register22(HttpServletRequest request, 
    					   @RequestParam(value = "mobile", required = true) String mobile,
    					   @RequestParam(value = "verifyCode", required = true) String verifyCode,
                           @RequestParam(value = "password", required = true) String password,
                           @RequestParam(value = "inviteCode", required = true) String inviteCode,
                           @RequestParam(value = "inviteMode", required = true) String inviteMode,
                           @RequestParam(value = "deviceSource", required = true) String deviceSource, String jurisdiction
    ) {
    	ReturnObjectVO res = ReturnObjectVO.success();
    	//验证手机验证码 测试阶段先关闭
    	/*if(verifyCode != null && verifyCode != ""){
    		String m = Constants.verifyMobile.get(mobile);
    		if(m != null){
    			String str = m.substring(0, 4);
    			if(!str.equals(verifyCode)){
    				res = ReturnObjectVO.error("手机验证码错误！");
    				return JSON.toJSONString(res);
    			}
    		}else{
    			res = ReturnObjectVO.error("您尚未获取手机验证码！");
				return JSON.toJSONString(res);
    		}
    	}*/
    	//首先验证该邀请码持有人的顶级代理，是否还有足够的邀请人数。
    	Users daili = null;
    	if(inviteCode != "" && inviteCode != null){
    		daili = userService.queryById(Long.parseLong(inviteCode));
    		if(daili == null){
    			res = ReturnObjectVO.error("该邀请码不存在！");
				return JSON.toJSONString(res);
    		}
    		if(daili.getJurisdiction().equals("7")){ //确实是代理，而不是代理的下级
    			if(daili!=null && daili.getInvitePersonNum().intValue() > 0){
    				//可以注册
    			}else{
    				res = ReturnObjectVO.error("该用户暂无邀请权限，请联系邀请人！");
    				return JSON.toJSONString(res);
    			}
    		}else{//代理的下级,那继续找代理
    			daili = userService.queryById(daili.getTopLevel());
    			if(daili!=null && daili.getInvitePersonNum().intValue() > 0){
    				//可以注册
    			}else{
    				res = ReturnObjectVO.error("该用户暂无邀请权限，请联系邀请人！");
    				return JSON.toJSONString(res);
    			}
    		}
    	}
    	
        logger.debug("开始注册 jsonStr  =========="  );
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("mobile",mobile);
        Users users = userService.queryOne(map);
        if (users == null) {
            try {
            	Users user = new Users();
            	String salt = MdUtils.sha1(RandomUtil.generateRandomNum(10));
            	if (StringUtils.isBlank(jurisdiction)) {
            		jurisdiction = "0";
				}
            	user.setMobile(mobile);
            	user.setLoginPassword(userService.encryptPassword(password, salt));
            	user.setLoginPasswordSalt(salt);
            	user.setDeviceSource(deviceSource);
            	user.setRegTime(new Date());
            	if(jurisdiction.equals("0")){//说明是普通用户。只有普通用户才有上级，
            		long id = Long.parseLong(inviteCode);
            		user.setSuperiorId(id);
            		//解决topLevel字段的问题。
            		Users userTemp = userService.queryById(id);//邀请码所属人
            		if(userTemp.getJurisdiction().equals("7")){//所属人是代理，则该注册人的顶级就是代理
            			user.setTopLevel(id);
            			user.setInvitePersonNum(0);
            		}else{ //所属人是普通用户，则该注册人的顶级就是所属人的顶级
            			user.setTopLevel(userTemp.getTopLevel());
            		}
            	}
            	user.setInvitePersonNum(0);
            	user.setJurisdiction(jurisdiction);
            	user.setInviteMode(inviteMode);
            	user.setIp(ServletKit.getIpAddr(request));
            	user.setCount(0); //用户积分，注册时设为0
            	userService.insert(user);
            	//用户注册成功之后，减少一次可邀请人数
            	if(daili != null){
            		Users u = new Users();
            		u.setUserId(daili.getUserId());
            		u.setInvitePersonNum(-1);
            		userService.updateInvitePersonNum(u);
            	}
            } catch (Exception e) {
                logger.error("用户注册异常", e);
            }
        } else {
        	res = ReturnObjectVO.error("该用户已注册，不可重复注册，赶快去登录吧！");
            return JSON.toJSONString(res);
        }

        return JSON.toJSONString(res);
    }
    /**
     * 注册，只提供普通用户注册
     * 判断 邀请人是否存在、手机短信是否正确
     *
     * @param request
     * @param mobile
     * @param password
     * @param inviteCode
     * @param inviteMode
     * @param phoneCode
     * @param deviceSource
     * @return
     */
    @ResponseBody
    @RequestMapping("register")
    public String register(HttpServletRequest request, 
    		@RequestParam(value = "mobile", required = true) String mobile,
    		@RequestParam(value = "verifyCode", required = false) String verifyCode,
    		@RequestParam(value = "password", required = true) String password,
    		@RequestParam(value = "inviteCode", required = true) String inviteCode,
    		@RequestParam(value = "inviteMode", required = true) String inviteMode,
    		@RequestParam(value = "deviceSource", required = true) String deviceSource
    		) {
    	ReturnObjectVO res = ReturnObjectVO.success();
    	//验证手机验证码 (测试阶段关闭)
    	/*if(verifyCode != null && verifyCode != ""){
    		String m = Constants.verifyMobile.get(mobile);
    		if(m != null){
    			String str = m.substring(0, 4);
    			if(!str.equals(verifyCode)){
    				res = ReturnObjectVO.error("手机验证码错误！");
    				return JSON.toJSONString(res);
    			}
    		}else{
    			res = ReturnObjectVO.error("您尚未获取手机验证码！");
				return JSON.toJSONString(res);
    		}
    	}*/
    	try {
    		//首先验证该邀请码持有人的顶级代理，是否还有足够的邀请人数。
	    	Users daili = null;
	    	if(inviteCode != "" && inviteCode != null){
	    		daili = userService.queryById(Long.parseLong(inviteCode));
	    		if(daili == null){
	    			res = ReturnObjectVO.error("该邀请码不存在！");
	    			return JSON.toJSONString(res);
	    		}
	    		if(daili.getJurisdiction().equals("7")){ //确实是代理，而不是代理的下级
	    			if(daili!=null && daili.getInvitePersonNum().intValue() > 0){
	    				//可以注册
	    			}else{
	    				res = ReturnObjectVO.error("该用户暂无邀请权限，请联系邀请人！");
	    				return JSON.toJSONString(res);
	    			}
	    		}else{//代理的下级,那继续找代理
	    			daili = userService.queryById(daili.getTopLevel());
	    			if(daili!=null && daili.getInvitePersonNum().intValue() > 0){
	    				//可以注册
	    			}else{
	    				res = ReturnObjectVO.error("该用户暂无邀请权限，请联系邀请人！");
	    				return JSON.toJSONString(res);
	    			}
	    		}
	    	}
	    	
	    	logger.error("普通用户开始注册 jsonStr  =========="  );
	    	Map<String, Object> map = new HashMap<String, Object>();
	    	map.put("mobile",mobile);
	    	Users users = userService.queryOne(map);
	    	if (users == null) {
    		
    			Users user = new Users();
    			String salt = MdUtils.sha1(RandomUtil.generateRandomNum(10));
    			/*if (StringUtils.isBlank(jurisdiction)) {
    				jurisdiction = "0";
    			}*/
    			user.setMobile(mobile);
    			user.setLoginPassword(userService.encryptPassword(password, salt));
    			user.setLoginPasswordSalt(salt);
    			user.setDeviceSource(deviceSource);
    			user.setRegTime(new Date());
    				long id = Long.parseLong(inviteCode);
    				user.setSuperiorId(id);
    				//解决topLevel字段的问题。
    				Users userTemp = userService.queryById(id);//邀请码所属人
    				if(userTemp.getJurisdiction().equals("7")){//所属人是代理，则该注册人的顶级就是代理
    					user.setTopLevel(id);
    				}else{ //所属人是普通用户，则该注册人的顶级，就是所属人的顶级
    					user.setTopLevel(userTemp.getTopLevel());
    				}
    			user.setInvitePersonNum(0);
    			user.setJurisdiction("0");
    			user.setInviteMode(inviteMode);
    			user.setIp(ServletKit.getIpAddr(request));
    			user.setCount(0); //用户积分，注册时设为0
    			user.setAddFriend("");
    			userService.insert(user);
    			//用户注册成功之后，减少一次可邀请人数
    			if(daili != null){
    				Users u = new Users();
    				u.setUserId(daili.getUserId());
    				u.setInvitePersonNum(-1);
    				userService.updateInvitePersonNum(u);
    			}
	    	} else {
	    		res = ReturnObjectVO.error("该用户已注册，不可重复注册，赶快去登录吧！");
	    		return JSON.toJSONString(res);
	    	}
    	} catch (Exception e) {
    		logger.error("普通用户注册异常"+new Date()+":", e);
    	}
    	
    	return JSON.toJSONString(res);
    }
    @ResponseBody
    @RequestMapping("registerForInviteAgent")
    public String registerForInviteAgent(HttpServletRequest request, 
    		@RequestParam(value = "mobile", required = true) String mobile,
    		@RequestParam(value = "verifyCode", required = false) String verifyCode,
    		@RequestParam(value = "password", required = true) String password,
    		@RequestParam(value = "inviteCode", required = true) String inviteCode,
    		@RequestParam(value = "inviteMode", required = true) String inviteMode,
    		@RequestParam(value = "deviceSource", required = true) String deviceSource, String jurisdiction
    		) {
    	ReturnObjectVO res = ReturnObjectVO.success();
    	//验证手机验证码 测试阶段关闭
    	/*if(verifyCode != null && verifyCode != ""){
    		String m = Constants.verifyMobile.get(mobile);
    		if(m != null){
    			String str = m.substring(0, 4);
    			if(!str.equals(verifyCode)){
    				res = ReturnObjectVO.error("手机验证码错误！");
    				return JSON.toJSONString(res);
    			}
    		}else{
    			res = ReturnObjectVO.error("您尚未获取手机验证码！");
				return JSON.toJSONString(res);
    		}
    	}*/
    	try {
	    	//首先验证该邀请码持有人的顶级代理，是否还有足够的邀请人数。
	    	Users daili = null;
	    	if(inviteCode != "" && inviteCode != null){
	    		daili = userService.queryById(Long.parseLong(inviteCode));
	    		if(daili == null){
	    			res = ReturnObjectVO.error("该邀请码不存在！");
	    			return JSON.toJSONString(res);
	    		}
	    		if(!daili.getJurisdiction().equals("7")){ //不是代理，不能邀请代理人
					res = ReturnObjectVO.error("该用户无邀请权限，请联系邀请人！");
					return JSON.toJSONString(res);
	    		}
	    	}
	    	logger.error("代理商开始注册 jsonStr  =========="  );
	    	Map<String, Object> map = new HashMap<String, Object>();
	    	map.put("mobile",mobile);
    	
	    	Users users = userService.queryOne(map);
	    	if (users == null) {//该手机号尚未注册
    			Users user = new Users();
    			
    			if (StringUtils.isBlank(jurisdiction)) {
            		jurisdiction = "7";
				}
            	user.setJurisdiction(jurisdiction);
    			String salt = MdUtils.sha1(RandomUtil.generateRandomNum(10));
    			user.setMobile(mobile);
    			user.setLoginPassword(userService.encryptPassword(password, salt));
    			user.setLoginPasswordSalt(salt);
    			user.setDeviceSource(deviceSource);
    			user.setRegTime(new Date());
    			user.setInvitePersonNum(0);
    			user.setInviteMode(inviteMode);
    			user.setIp(ServletKit.getIpAddr(request));
    			user.setCount(0); //用户积分，注册时设为0
    			user.setSuperiorAgentId(Long.parseLong(inviteCode));//设置上级代理的id
    			user.setCreateTime(new Date());
    			userService.insert(user);
	    	} else {
	    		res = ReturnObjectVO.error("该代理已注册，不可重复注册，赶快去登录吧！");
	    		return JSON.toJSONString(res);
	    	}
    	} catch (Exception e) {
    		logger.error("代理人注册异常"+new Date()+":", e);
    	}
    	
    	return JSON.toJSONString(res);
    }
    /**
     * 获取手机验证码
     * @throws ClientException 
     */
    @ResponseBody
    @RequestMapping("getVerifyCode")
    public ReturnObjectVO getVerifyCode(String mobile) throws ClientException {
    	ReturnObjectVO res = ReturnObjectVO.success();
    	Map<String, Object> map = new HashMap<String, Object>();
        map.put("mobile",mobile);
        Users user = userService.queryOne(map);
        if(user != null){
        	res.put("flag", false);
        	res.put("msg", "该用户已注册，不可重复注册");
        	return res;
        }
    		/**
    		 *  AccessKeyID：
    			LTAImhBRjZVFwCwA
    			AccessKeySecret：
    			xQWiRMWOrblZH8Q7tmZEAcV3eP6W5m
    		 */
    		//设置超时时间-可自行调整
    		System.setProperty("sun.net.client.defaultConnectTimeout", "1000");
    		System.setProperty("sun.net.client.defaultReadTimeout", "1000");
    		//初始化ascClient需要的几个参数
    		final String product = "Dysmsapi";//短信API产品名称（短信产品名固定，无需修改）
    		final String domain = "dysmsapi.aliyuncs.com";//短信API产品域名（接口地址固定，无需修改）
    		//替换成你的AK
    		//final String accessKeyId = "yourAccessKeyId";//你的accessKeyId,参考本文档步骤2
    		//final String accessKeySecret = "yourAccessKeySecret";//你的accessKeySecret，参考本文档步骤2
    		final String accessKeyId = "LTAImhBRjZVFwCwA";//你的accessKeyId,参考本文档步骤2
    		final String accessKeySecret = "xQWiRMWOrblZH8Q7tmZEAcV3eP6W5m";//你的accessKeySecret，参考本文档步骤2
    		//初始化ascClient,暂时不支持多region（请勿修改）
    		IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId,accessKeySecret);
    		DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
    		IAcsClient acsClient = new DefaultAcsClient(profile);
    		 //组装请求对象
    		 SendSmsRequest request = new SendSmsRequest();
    		 //使用post提交
    		 request.setMethod(MethodType.POST);
    		 //必填:待发送手机号。支持以逗号分隔的形式进行批量调用，批量上限为1000个手机号码,批量调用相对于单条调用及时性稍有延迟,验证码类型的短信推荐使用单条调用的方式
    		 request.setPhoneNumbers(mobile);
    		 //必填:短信签名-可在短信控制台中找到
    		 //request.setSignName("云通信");
    		 request.setSignName("微掌商");
    		 //必填:短信模板-可在短信控制台中找到
    		 //request.setTemplateCode("SMS_1000000");
    		 request.setTemplateCode("SMS_130917954");
    		 //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
    		 //友情提示:如果JSON中需要带换行符,请参照标准的JSON协议对换行符的要求,比如短信内容中包含\r\n的情况在JSON中需要表示成\\r\\n,否则会导致JSON在服务端解析失败
    		 //request.setTemplateParam("{\"name\":\"Tom\", \"code\":\"123\"}");
    		 //生成一个code，随机的四位数字
    		 StringBuffer strB = new StringBuffer();
    		 for(int i=0;i<4;i++){
    			 String c = Integer.toString((int)(Math.random()*10));
    			 strB.append(c);
    		 }
    		 //request.setTemplateParam("{\"code\":\"123456\"}");
    		 request.setTemplateParam("{\"code\":\""+strB+"\"}");
    		 //可选-上行短信扩展码(扩展码字段控制在7位或以下，无特殊需求用户请忽略此字段)
    		 //request.setSmsUpExtendCode("90997");
    		 //可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
    		 //request.setOutId("yourOutId");
    		//请求失败这里会抛ClientException异常
    		SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
    		if(sendSmsResponse.getCode() != null && sendSmsResponse.getCode().equals("OK")) {
    			//请求成功 [{"msg":"成功","code":1}]
    			System.out.println(sendSmsResponse.getMessage());
    			System.out.println(sendSmsResponse.getCode());
    			Date now = new Date();
    			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    			Constants.verifyMobile.put(mobile, strB.toString()+df.format(now));//时间是为了清理map中的数据
    		}
    		System.out.println(sendSmsResponse.getMessage());
			System.out.println(sendSmsResponse.getCode());
			logger.error(mobile+"获取短信验证码，时间："+new Date());
    		res.put("msg", sendSmsResponse.getMessage());
    		res.put("flag", true);
    		
    	return res;
    }

    @RequestMapping("regSuccess")
    public String regSuccess(@RequestParam(value = "mobile", required = true) String mobile,
                             @RequestParam(value = "password", required = true) String password,
                             HttpServletRequest request){
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("countSql", 0);
        params.put("mobile", mobile);
        params.put("status", "enabled");
        PageInfo<Users> pageInfo = userService.query(params);
        if (pageInfo.getSize() == 1) {
            Users users = pageInfo.getList().get(0);
            try {
                if (LoginHelper.login(mobile, userService.encryptPassword(password, users.getLoginPasswordSalt()))) {
                    logger.error("注册成功--直接登陆成功");
                    //saveSession(request, users.getUserId(),"wap");
                    return "redirect:/home/index";
                } else {
                    logger.error("注册成功--登录失败，手机号或密码错误!"+new Date());
                }
            } catch (Exception e) {
                logger.error("注册成功--用户登录异常"+new Date(), e);
            }
        } else {
            logger.error("注册成功--该手机号未注册，赶紧去注册吧!"+new Date());
        }
        logger.error("注册成功之后，登录失败，即将到登录页面"+new Date());
        return "redirect:/login/toLogin";
    }

    private boolean checkPassword(String password) {
        Pattern pattern = Pattern.compile("^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,16}$");
        return pattern.matcher(password).matches();
    }

    /**
     * 忘记密码
     *
     * @param mobile
     * @param password
     * @param phoneCode
     * @return
     */
    @ResponseBody
    @RequestMapping("retrievePwd")
    public String retrievePwd(@RequestParam(value = "mobile", required = true) String mobile,
                              @RequestParam(value = "password", required = true) String password,
                              @RequestParam(value = "phoneCode", required = true) String phoneCode
    ) {
        TransResponse transResponse = new TransResponse();
        return JSON.toJSONString(transResponse);
    }

    @RequestMapping("toWxLogin")
    public String toWxLogin(@RequestParam(value = "redirectUrl", required = false) String redirectUrl
            ,ModelMap modelMap) {
        String backUrl = myUrl + "/login/backWxLogin";
        if(StringUtils.isNoneBlank(redirectUrl))
            backUrl += "?redirectUrl="+redirectUrl;
        modelMap.put("backUrl", backUrl);
        String signStr = MapKit.sortMap(modelMap);
        try {
            String sign = MdUtils.md5(signStr + "&key=" + weixinSignKey);
            //URLEncoder.encode(backUrl,"utf-8")
            modelMap.put("sign", sign);
            modelMap.put("reqUrl", weixinUrl + "/wxUser/getOpenId");
            return JSP_PATH + "wx_login";
        } catch (Exception e) {
            logger.error("用户异常", e);
        }

        return JSP_500;
    }

    @RequestMapping("backWxLogin")
    public String backWxLogin(@RequestParam(value = "sign", required = true) String sign,
                              @RequestParam(value = "redirectUrl", required = false) String redirectUrl,
                              HttpServletResponse response, WxUsrDto wxUsrDto,HttpServletRequest request) {

        Map wxUsrMap = BeanUtil.transBean2Map(wxUsrDto);
        String signStr = MapKit.sortMap(wxUsrMap, true);
        logger.debug("签名参数串：" + signStr);
        try {
            String signRes = MdUtils.md5(signStr + "&key=" + weixinSignKey);
            if (!signRes.equals(sign)) {
                return JSP_500;
            }
        } catch (Exception e) {
            logger.error("异常", e);
        }

        String result = wxUsrDto.getResult();
        String openId = wxUsrDto.getOpenId();

        if ("success".equals(result)) {
            logger.debug("用户weixin:" + openId);
            //获取当前openId是否已绑定用户
            Users users = userService.queryByWeixin(openId);
            if (users != null) {
                //直接登陆
                String mobile = users.getMobile();
                String pwdDb = users.getLoginPassword();
                String headImgUrl = users.getHeadImgUrl();
                try {
                    if (LoginHelper.login(mobile, pwdDb)) {
                    	//saveSession(request, users.getUserId(),"weixin_auto");
                        if(StringUtils.isBlank(headImgUrl)){
                            //获取unionId
                            Map params = getWxInfo(openId);
                            users.setNickName(Objects.toString(params.get("nickName"),""));
                            users.setHeadImgUrl(Objects.toString(params.get("headImgUrl"),""));
                            userService.update(users);
                            wxUsrMap.put("headImgUrl", headImgUrl);
                            wxUsrMap.putAll(params);
                            //把openId对应key存入cookie
                            addOpenIdCookie(response,wxUsrMap);
                        }

                        logger.debug("重定向地址："+redirectUrl);
                        if(StringUtils.isNoneBlank(redirectUrl))
                            return "redirect:"+redirectUrl;

                        return "redirect:/home/index";
                    } else {
                        return JSP_500;
                    }
                } catch (Exception e) {
                    logger.error("微信登陆异常：", e);
                    return JSP_500;
                }
            } else {

                //获取微信信息
                Map params = getWxInfo(openId);
                wxUsrMap.putAll(params);
                //把openId对应key存入cookie
                addOpenIdCookie(response,wxUsrMap);

                logger.debug("未绑定微信，重定向地址："+redirectUrl);
                if(StringUtils.isNoneBlank(redirectUrl))
                    return "redirect:"+redirectUrl;

                return "redirect:/home/showIndex";
            }
        } else {
            return JSP_500;
        }
    }

    @RequestMapping("err500")
    public String err500() {
        return JSP_500;
    }

    @RequestMapping("err404")
    public String err404() {
        return JSP_404;
    }


    /*@Autowired
    SysCouponsService sysCouponsService;

    @RequestMapping("test")
    @ResponseBody
    public Object test(){
        Map<String,Object> map = new HashMap<>();
        map.put("userId",10182);
        return sysCouponsService.queryCustom(map);
    }*/
    public static void main21(String[] args) throws ClientException{
		/**
		 *  AccessKeyID：
			LTAImhBRjZVFwCwA
			AccessKeySecret：
			xQWiRMWOrblZH8Q7tmZEAcV3eP6W5m
		 */
		//设置超时时间-可自行调整
		System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
		System.setProperty("sun.net.client.defaultReadTimeout", "10000");
		//初始化ascClient需要的几个参数
		final String product = "Dysmsapi";//短信API产品名称（短信产品名固定，无需修改）
		final String domain = "dysmsapi.aliyuncs.com";//短信API产品域名（接口地址固定，无需修改）
		//替换成你的AK
		//final String accessKeyId = "yourAccessKeyId";//你的accessKeyId,参考本文档步骤2
		//final String accessKeySecret = "yourAccessKeySecret";//你的accessKeySecret，参考本文档步骤2
		final String accessKeyId = "LTAImhBRjZVFwCwA";//你的accessKeyId,参考本文档步骤2
		final String accessKeySecret = "xQWiRMWOrblZH8Q7tmZEAcV3eP6W5m";//你的accessKeySecret，参考本文档步骤2
		//初始化ascClient,暂时不支持多region（请勿修改）
		IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId,accessKeySecret);
		DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
		IAcsClient acsClient = new DefaultAcsClient(profile);
		 //组装请求对象
		 SendSmsRequest request = new SendSmsRequest();
		 //使用post提交
		 request.setMethod(MethodType.POST);
		 //必填:待发送手机号。支持以逗号分隔的形式进行批量调用，批量上限为1000个手机号码,批量调用相对于单条调用及时性稍有延迟,验证码类型的短信推荐使用单条调用的方式
		 request.setPhoneNumbers("13716424632");
		 //必填:短信签名-可在短信控制台中找到
		 //request.setSignName("云通信");
		 request.setSignName("微掌商");
		 //必填:短信模板-可在短信控制台中找到
		 //request.setTemplateCode("SMS_1000000");
		 request.setTemplateCode("SMS_130917954");
		 //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
		 //友情提示:如果JSON中需要带换行符,请参照标准的JSON协议对换行符的要求,比如短信内容中包含\r\n的情况在JSON中需要表示成\\r\\n,否则会导致JSON在服务端解析失败
		 //request.setTemplateParam("{\"name\":\"Tom\", \"code\":\"123\"}");
		 request.setTemplateParam("{\"code\":\"123456\"}");
		 //可选-上行短信扩展码(扩展码字段控制在7位或以下，无特殊需求用户请忽略此字段)
		 //request.setSmsUpExtendCode("90997");
		 //可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
		 //request.setOutId("yourOutId");
		//请求失败这里会抛ClientException异常
		SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
		if(sendSmsResponse.getCode() != null && sendSmsResponse.getCode().equals("OK")) {
		//请求成功
		}
	}
    public static void main(String[] args) {
    	for(int i=0;i<6;i++){
    		UUID u = UUID.randomUUID();
    		String uuid = u.toString();
    		String replace = uuid.replace("-", "");
    		System.out.println(replace.substring(0, 16));
    	}
	}
}
