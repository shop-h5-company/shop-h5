package com.shop.web;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xframe.codec.MdUtils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.shop.common.Constants;
import com.shop.common.RandomUtil;
import com.shop.mybatis.model.generator.Users;
import com.shop.service.UserService;
import com.shop.vo.ReturnObjectVO;

/**
 * Created on 2016-06-30 11:44.
 *
 * @author FanShukui
 */
@Controller
@RequestMapping("/user")
public class UserController extends MyBaseController {

	@Autowired
    UserService userService;
	
	ThreadLocal<Integer> totalInviteFriend = new ThreadLocal<Integer>();//总邀请人数
	ThreadLocal<Integer> VerifySuccessFriend = new ThreadLocal<Integer>();//已审核通过的人数（加了微信）
	ThreadLocal<Integer> noVerifyFriend = new ThreadLocal<Integer>();//未审核好友
	
	@Value("#{configProperties['svr.smsUrl']}")
    protected String smsUrl;

	public static final String JSP_PATH = "user/";

	@RequestMapping("index")
	public String index(ModelMap modelMap) {
		long userId =getMyCurrUser();
		Users users = userService.queryById(userId);
		String jurisdiction = "";
		jurisdiction = users.getJurisdiction();
		if (jurisdiction == null) {
			jurisdiction = "-1";
		}
		modelMap.put("jurisdiction",jurisdiction);
		
		List<Users> userList = userService.queryListBySuperiorId(userId);//这是获取下级
		//String level = "当前登陆人微信号";
    	int UninvitedPerson = 0;//未审核好友数量，包括下级的下级。（只有顶级代理能审核，就是确认加微信好友的意思。）
    	
    	totalInviteFriend.set(0);//防止重复进入该页面时，数据叠加的问题
    	VerifySuccessFriend.set(0);//防止重复进入该页面时，数据叠加的问题
    	noVerifyFriend.set(0);//防止重复进入该页面时，数据叠加的问题
    	digui(userList);
    	modelMap.put("totalInviteFriend",totalInviteFriend.get());
    	modelMap.put("VerifySuccessFriend",VerifySuccessFriend.get());
    	modelMap.put("noVerifyFriend",noVerifyFriend.get());
    	
    	modelMap.put("userId",userId);//给用户首页的邀请好友，传值(代码如果能执行到这儿，则userId有值)
		
		return JSP_PATH + "index";
	}
    public void digui(List<Users> userList){
    	//int UninvitedPerson = 0;//未审核好友数量，包括下级的下级。（只有顶级代理能审核，就是确认加微信好友的意思。）
		for(Users u:userList){
			totalInviteFriend.set(totalInviteFriend.get()+1);
			String addFriend = u.getAddFriend();
			if(addFriend == null || addFriend.equals("")){
				//UninvitedPerson++;
				noVerifyFriend.set(noVerifyFriend.get()+1);
			}else if(addFriend.equals("0")){//加了微信好友，审核通过的
				VerifySuccessFriend.set(VerifySuccessFriend.get()+1);
			}
			List<Users> userList2 = userService.queryListBySuperiorId(u.getUserId());//谁的superiorId是参数userId,即查询到该userId的下级列表。
			if(null != userList2 && !userList2.isEmpty()){
				digui(userList2);
			}else{//该用户没有下线了。
			}
		}
		//return UninvitedPerson;
		/*Map<String,Integer> map = new HashMap<String, Integer>();
		map.put("totalInviteFriend", totalInviteFriend.get());
		map.put("VerifySuccessFriend", VerifySuccessFriend.get());
		map.put("noVerifyFriend", noVerifyFriend.get());
		return map;*/
    }
	//进入个人设置页面
	@RequestMapping("personalSet")
	public String personalSet(ModelMap modelMap) {
		long id = getMyCurrUser();
		Users user = userService.queryById(id);
		modelMap.put("user", user);
		return JSP_PATH + "personal_set";
	}
	//修改微信昵称  用userName村粗微信昵称
	@RequestMapping("updateWeixinHao")
	@ResponseBody
	public ReturnObjectVO updateWeixinHao(ModelMap modelMap,String weixinHao) {
		ReturnObjectVO res = new ReturnObjectVO();
		long id = getMyCurrUser();
		Users user = new Users();
		user.setUserId(id);
		user.setWeixin(weixinHao);
		userService.updateSelectiveById(user);
		res.put("result", true);
		res.put("msg", "修改成功");
		return res;
	}
	//修改微信昵称  用userName村粗微信昵称
	@RequestMapping("updateWeixin")
	@ResponseBody
	public ReturnObjectVO updateWeixin(ModelMap modelMap,String weixin) {
		ReturnObjectVO res = new ReturnObjectVO();
		long id = getMyCurrUser();
		Users user = new Users();
		user.setUserId(id);
		user.setUserName(weixin);
		userService.updateSelectiveById(user);
		res.put("result", true);
		res.put("msg", "修改成功");
		return res;
	}
	
	//修改登录密码
	@RequestMapping("loginPwd")
	public String changeLoginPwd(ModelMap modelMap) {
		long id = getMyCurrUser();
		Users user =userService.getById(id);
		modelMap.addAttribute("mobile", user.getMobile());
		return JSP_PATH + "change_login_pwd";
	}
	
	//修改登录密码        应该未使用
	@RequestMapping("resetLoginPwd")
	public String resetLoginPwd() {
		return JSP_PATH + "reset_login_pwd";
	}
	
	/**
	 * 修改登陆密码
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping("changePwd")
	public String changePwd(
			@RequestParam(value = "oldPassword", required = true) String oldPassword,
			@RequestParam(value = "password", required = true) String password,String verifyCode) {
		System.out.println("verifyCode:"+verifyCode);
		ReturnObjectVO res = ReturnObjectVO.success();
		
		//验证手机验证码 测试阶段先关闭
		long id = getMyCurrUser();
		Users user2 =userService.getById(id);
    	if(verifyCode != null && verifyCode != ""){
    		String m = Constants.verifyMobile.get(user2.getMobile());
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
    	}
		
		//long id = getMyCurrUser();
		try {
			Users users = userService.queryById(id);
			String oldSalt = users.getLoginPasswordSalt();
			String oldPwdDb = users.getLoginPassword();
			oldPassword = userService.encryptPassword(oldPassword, oldSalt);
			if (!oldPassword.equals(oldPwdDb)) {
				res = ReturnObjectVO.error("旧密码输入错误，请重新输入！");
				return JSON.toJSONString(res);
			}
			
			String newPwd = userService.encryptPassword(password, oldSalt);
			if (oldPwdDb.equals(newPwd)) {
				res = ReturnObjectVO.error("旧密码和新密码相同，请重新输入！");
				return JSON.toJSONString(res);
			}
			
			Users user = new Users();
			String salt = MdUtils.sha1(RandomUtil.generateRandomNum(10));
			user.setMobile(users.getMobile());
        	user.setLoginPassword(userService.encryptPassword(password, salt));
        	user.setLoginPasswordSalt(salt);
        	user.setUpdateTime(new Date());
			userService.updateUserPwd(user);
		} catch (Exception e) {
			logger.error("修改登陆密码异常",e);
			res = ReturnObjectVO.error("修改登陆密码异常");
		}
		return JSON.toJSONString(res);
	}
	
	
	/**
	 * 重置登陆密码 用户权限是9时可显示
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping("resetPwd")
	public String resetPwd(
			@RequestParam(value = "mobile", required = true) String mobile) {
		ReturnObjectVO res = ReturnObjectVO.success();
		long id = getMyCurrUser();
		try {
			Users users = userService.queryById(id);
			String jurisdiction = "";
			jurisdiction = users.getJurisdiction();
			if (StringUtils.isBlank(mobile)) {
				res = ReturnObjectVO.error("手机号不能为空！");
				return JSON.toJSONString(res);
			}
			
			if (!jurisdiction.equals("9")) {
				res = ReturnObjectVO.error("权限不够，请联系管理员操作！");
				return JSON.toJSONString(res);
			}
			String password = "vv123456";
			Users user = new Users();
			String salt = MdUtils.sha1(RandomUtil.generateRandomNum(10));
			user.setMobile(mobile);
        	user.setLoginPassword(userService.encryptPassword(password, salt));
        	user.setLoginPasswordSalt(salt);
        	user.setUpdateTime(new Date());
			userService.updateUserPwd(user);
		} catch (Exception e) {
			logger.error("修改登陆密码异常",e);
			res = ReturnObjectVO.error("修改登陆密码异常");
		}
		return JSON.toJSONString(res);
	}
    /**
     * 修改密码时，获取手机验证码
     * @throws ClientException
     */
    @ResponseBody
    @RequestMapping("getVerifyCode")
    public ReturnObjectVO getVerifyCode(String mobile) throws ClientException {
    	System.out.println("mobile:"+mobile);
    	ReturnObjectVO res = ReturnObjectVO.success();
    	Map<String, Object> map = new HashMap<String, Object>();
        map.put("mobile",mobile);
        Users user = userService.queryOne(map);
        if(user == null){
        	res.put("flag", false);
        	res.put("msg", "不存在该用户");
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
}
