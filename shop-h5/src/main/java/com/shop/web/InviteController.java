package com.shop.web;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import xframe.codec.MdUtils;
import xframe.kit.HttpKit;
import xframe.kit.MapKit;

import com.alibaba.fastjson.JSON;
import com.shop.mybatis.model.generator.InviteAuthorityCode;
import com.shop.mybatis.model.generator.Users;
import com.shop.service.InviteAuthorityCodeService;
import com.shop.service.UserService;
import com.shop.util.BeanUtil;
import com.shop.vo.ReturnObjectVO;
import com.shop.vo.WxUsrDto;
import com.swetake.util.Qrcode;

@Controller
@RequestMapping("/invite")
public class InviteController extends MyBaseController{
	
	protected static Logger logger = Logger.getLogger(InviteController.class);
	
	public static final String JSP_PATH = "invite/";
	ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();
    @Autowired
    private UserService userService;
    @Autowired
    InviteAuthorityCodeService inviteAuthorityCodeService;
    //进入去审核页面
    @RequestMapping("verify")
    public String verify(ModelMap modelMap){
    	Long id = getMyCurrUser();
    	List<Users> userList = userService.queryByTopLevel(id);//获取所有下级
    	int UnInvitedPerson = 0;
    	for(Users u:userList){
    		if(u.getAddFriend() == null || u.getAddFriend().equals("")){
    			UnInvitedPerson++;
    		}
    	}
    	modelMap.addAttribute("userList", userList);
    	modelMap.addAttribute("UnInvitedPerson", UnInvitedPerson);
    	return JSP_PATH + "verify";
    }
    //进入已邀请好友页面
    @RequestMapping("inviteList")
	public String friends(ModelMap modelMap, Long currentUserId){
    	Long id = getMyCurrUser();
    	if(null == currentUserId){
    		currentUserId = id;
    	}
		List<Users> userList = userService.queryListBySuperiorId(currentUserId);//这是获取下级
		//String level = "当前登陆人微信号";
    	int UninvitedPerson = 0;//未审核好友数量，包括下级的下级。（只有顶级代理能审核，就是确认加微信好友的意思。）
    	threadLocal.set(0);//防止重复进入该页面时，数据叠加的问题
    	UninvitedPerson = digui(userList);
		/**
		 *1、顶级代理商：两个按钮一个接受 一个拒绝	接受的就显示已审核、拒绝的就显示已拒绝
		 *2、普通用户其他人只能看到未审核、已审核、已拒绝（addFriend字段0是，1否。字段为null，则是未审核）
		 */
    	//顶级代理商他的字段top_level存的是空、并且权限是7
		Users user = userService.queryById(id);
		if(user.getJurisdiction().equals("7")){ //当前用户是顶级代理商
			for(Users u:userList){
				u.setUserType("1");
			}
		}else{//普通用户
			for(Users u:userList){
				u.setUserType("0");
			}
		}
		
		//审核好友的页面，显示用户手机号，隐藏中间的四位号码
		/*for(Users u:userList){
			String mobile = u.getMobile();
			String sub1 = mobile.substring(0, 3);
			String sub2 = mobile.substring(7, 11);
			u.setMobile(sub1+"****"+sub2);
		}*/
		modelMap.addAttribute("UninvitedPerson", UninvitedPerson);
		modelMap.addAttribute("userList", userList);
    	return JSP_PATH + "invite_list";
    }
    /**
     * 用户已经接收微信加好友
     */
    @RequestMapping("jieshou")
    @ResponseBody
    public ReturnObjectVO jieshou(ModelMap modelMap, Long userId){
    	ReturnObjectVO res = new ReturnObjectVO();
    	try {
    		Users users = userService.queryById(userId);
    		if(users.getAddFriend().equals("0")){//已经加了好友
    			return null;
    		}
    		/**
    		 * 积分那个  比如我下级的下级拉了一个人  他可获得10积分  
    		 *  那么我下级可获得10除2  我可获得10除2除2  不带小数点 进位那种  5除2等于3  3除2得1  1除2就直接得1 上级就加一
    		 */
			userService.updateAddFriendById(userId,"0");//0表示已加好友 （加了好友，立即获得50积分。注意：积分在实现方法中加上了）
			Users user = userService.queryById(userId);
			Users temp = userService.queryById(user.getSuperiorId());
			if(!temp.getJurisdiction().equals("7")){ //顶级代理不需要积分
				Users superUser = userService.queryById(user.getSuperiorId());//找到上级，上级加10积分
				superUser.setCount(10);
				userService.updateCountById(superUser);
			}
			res.put("result", true);
			res.put("msg", "操作成功");
			return res;
		} catch (Exception e) {
			res.put("result", false);
			res.put("msg", "操作失败");
			e.printStackTrace();
			return res;
		}
    }
    /**
     * 用户已经拒绝
     */
    @RequestMapping("jujue")
    @ResponseBody
    public ReturnObjectVO jujue(ModelMap modelMap, Long userId){
    	ReturnObjectVO res = new ReturnObjectVO();
    	try {
    		userService.updateAddFriendById(userId,"1");//1表示已经拒绝加好友
    		res.put("result", true);
    		res.put("msg", "操作成功");
    		return res;
    	} catch (Exception e) {
    		res.put("result", false);
    		res.put("msg", "操作失败");
    		e.printStackTrace();
    		return res;
    	}
    }
    /**
     * 提示用户可邀请人数不足时的，那个页面购买权限码的方法
     */
    @RequestMapping("activateAuthorityCode")
    @ResponseBody
    public ReturnObjectVO activateAuthorityCode(ModelMap modelMap, String inviteAuthorityCode){
    	ReturnObjectVO res = new ReturnObjectVO();
    	Long id = getMyCurrUser();
    	Users user = userService.queryById(id);
    	try {
    		
    		InviteAuthorityCode code = inviteAuthorityCodeService.getByCode(inviteAuthorityCode);
        	if(code !=null){ //确实存在这个邀请码
        		if(code.getUsed().equals("0")){ //该码未曾使用过。
        			InviteAuthorityCode code2 = new InviteAuthorityCode();
        			code2.setInviteCode(inviteAuthorityCode);
        			code2.setTelephoneUse(user.getMobile());
        			code2.setUsed("1");//该邀请权限码已使用
        			code2.setTimeUsed(new Date());
        			inviteAuthorityCodeService.updateByPrimaryKeySelective(code2);
        			//2、更新users表的可邀请人数。
        			//Users user = userService.selectByMobile(mobile);
        			Users user2 = new Users();
        			user2.setUserId(user.getUserId());
        			user2.setInvitePersonNum(code.getInvitePersonNum());
        			userService.updateInvitePersonNum(user2);
        			res.put("result", true);
            		res.put("msg", "邀请权限码激活成功");
            		return res;
        		}else if(code.getUsed().equals("1")){ //使用过，则看看该邀请码是否属于登陆者（算了，直接给出提示：该邀请权限码已被使用）
        			res.put("result", false);
            		res.put("msg", "该邀请权限码已被使用!");
            		return res;
        		}
        	}else{
        		res.put("result", false);
        		res.put("msg", "不存在该邀请权限码");
        		return res;
        	}
    	} catch (Exception e) {
    		res.put("result", false);
    		res.put("msg", "服务器异常");
    		e.printStackTrace();
    		logger.error("激活权限码失败：", e);
    		return res;
    	}
		return res;
    }
    
    public int digui(List<Users> userList){
    	//int UninvitedPerson = 0;//未审核好友数量，包括下级的下级。（只有顶级代理能审核，就是确认加微信好友的意思。）
		for(Users u:userList){
			String addFriend = u.getAddFriend();
			if(addFriend == null || addFriend.equals("")){
				//UninvitedPerson++;
				threadLocal.set(threadLocal.get()+1);
			}
			List<Users> userList2 = userService.queryListBySuperiorId(u.getUserId());//谁的superiorId是参数userId,即查询到该userId的下级列表。
			if(null != userList2 && !userList2.isEmpty()){
				digui(userList2);
			}else{//该用户没有下线了。
			}
		}
		//return UninvitedPerson;
		return threadLocal.get();
    }
    //进入已邀请好友页面  废弃
    @RequestMapping("inviteList2")
    public String friends2(ModelMap modelMap, Long currentUserId){
    	Long id = getMyCurrUser();
    	List<Users> userList = userService.querySubordinateIdList(id);
    	String level = "当前登陆人微信号";
    	int UninvitedPerson = 0;
    	//while一般用于 不清楚需要循环多少次的情况下
    	while(currentUserId != id && currentUserId != null){ //循环条件中直接为TRUE 
    		//循环获得未结算金额list
    		
    		//查询该代理商是否有下级
    		Users user = userService.querySuperiorId(currentUserId);
    		String currentUserIdString = "";
    		if (user != null) {
    			if(currentUserId == id){ //直到符合条件后跳出本循环 否则一直循环下去
    				break;
    			}
    			//获得下级代理商id
    			currentUserId = user.getUserId();
    			//获取微信名，微信号 拼接
    			currentUserIdString = "→"+user.getWxName()+"("+user.getWeixin()+"";
    		}
    		//拼接当前登陆人微信号→顏無心（顏無心）→双（shuang）字符串
    		level = level + currentUserIdString;
    	}
    	modelMap.addAttribute("level", level);
    	modelMap.addAttribute("UninvitedPerson", UninvitedPerson);
    	modelMap.addAttribute("userList", userList);
    	return JSP_PATH + "invite_list";
    }
    
	@RequestMapping("qrcode")
	public String qrcode(HttpServletRequest request,ModelMap modelMap) {
		Users users = userService.queryById(getMyCurrUser());
		String headImgUrl="";//微信头像
		String nickName="";//微信昵称
		String inviteCode="";
		if(users != null){
			headImgUrl = users.getHeadImgUrl();
			if(StringUtils.isBlank(headImgUrl)){
				headImgUrl="/res/image/invite/ps.png";
			}
			nickName = users.getNickName();
			if(StringUtils.isBlank(nickName)){
				nickName="小微";
			}
			inviteCode=users.getHisInviteCode();
		}
		//图片二维码
		String codeUrl=getQrCode(inviteCode);
		modelMap.addAttribute("headImgUrl",headImgUrl );
		modelMap.addAttribute("nickName",nickName );
		modelMap.addAttribute("codeUrl",codeUrl );
		modelMap.addAttribute("inviteCode",inviteCode );
		//微信初始化分享
        String link = myUrl+"/invite/share?inviteCode="+inviteCode;
        initWxShare(request, modelMap,link);
		return JSP_PATH + "qrcode";
	}

	@RequestMapping("notLogin")
	public String notLogin() {
		return JSP_PATH + "not_login";
	}
	/**
	 * 邀请好友
	 * @param request
	 * @param modelMap
	 * @return
	 */
	@RequestMapping("hasLogin")
	public String hasLogin(HttpServletRequest request,ModelMap modelMap,Long id) {
		//Long id = getMyCurrUser();
		//如果id有传参，则使用该参数。（使未登录用户也可以访问该方法）
		if(id == null){
			id = getMyCurrUser();
		}
		
    	String hisInviteCode = ""+id;
    	modelMap.addAttribute("hisInviteCode", hisInviteCode);//邀请码就是用户id
    	//图片二维码,见codeUrl方法
    	Users user = userService.queryById(id);
    	if(!user.getJurisdiction().equals("7")){ //普通用户邀请好友
    		
    		//并给出代理的微信号
    		Users top = userService.queryById(user.getTopLevel());
    		modelMap.put("weixin", top.getWeixin());//2018年5月23日13:49:18 这个字段前端没使用
    		
    		String addFriend = user.getAddFriend();
    		if(addFriend == null || addFriend.equals("") || addFriend.equals("1")){
    			return "common/302";
    		}
    	}else{//代理，如果未填写微信号，则提示 (代理可以获取邀请码，不用审核是否加了微商好友)
    		if(user.getWeixin() == null || user.getWeixin().equals("")){
    			modelMap.put("user", user);
    		}
    	}
    	modelMap.addAttribute("userId", id);
		return JSP_PATH + "has_login";
	}
	/**
	 * 邀请代理商
	 * @param request
	 * @param modelMap
	 * @return
	 */
	@RequestMapping("inviteAgent")
	public String inviteAgent(HttpServletRequest request,ModelMap modelMap,Long id) {
		//如果id有传参，则使用该参数。（使未登录用户也可以访问该方法）
		//Long id = getMyCurrUser();
		if(id == null){
			id = getMyCurrUser();
		}
		String hisInviteCode = ""+id;
		modelMap.addAttribute("hisInviteCode", hisInviteCode);//邀请码就是用户id
		//图片二维码,见codeUrl方法
		modelMap.addAttribute("userId", id);
		return JSP_PATH + "inviteAgent";
	}
	//生成图片二维码
	@RequestMapping("codeUrl")
	public void codeUrl(HttpServletRequest request,HttpServletResponse response,Long id) {
		//Long id = getMyCurrUser();//如果id有传参，则使用该参数。（使未登录用户也可以访问该方法）
		if(id == null){
			id = getMyCurrUser();
		}
	   //生成二维码中要存储的信息  
    	//我的邀请码 http://192.168.1.16:9991/login/toRegister?inviteCode=
		String url="http://www.vbuyy.com/login/toRegister?inviteCode=";
    	String hisInviteCode = url+id;
	   //String qrData = "http://www.baidu.com";
	   String qrData = hisInviteCode;  
	   Qrcode qrcode = new Qrcode();  
       qrcode.setQrcodeErrorCorrect('M');//纠错等级（分为L、M、H三个等级）  
       qrcode.setQrcodeEncodeMode('B');//N代表数字，A代表a-Z，B代表其它字符  
       qrcode.setQrcodeVersion(7);//版本  
       //设置一下二维码的像素  
       //int width = 300;  
       //int height = 300;  
       int width = 67+12*(7-1);  
       int height = 67+12*(7-1);  
       BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);  
       //绘图  
       Graphics2D gs = bufferedImage.createGraphics();  
       gs.setBackground(Color.WHITE);  
       gs.setColor(Color.BLACK);  
       gs.clearRect(0, 0, width, height);//清除下画板内容  
         
       //设置下偏移量,如果不加偏移量，有时会导致出错。  
       int pixoff = 2;  
         
       try {
		byte[] d = qrData.getBytes("gb2312");  
		   if(d.length > 0 && d.length <120){  
		       boolean[][] s = qrcode.calQrcode(d);  
		       for(int i=0;i<s.length;i++){  
		           for(int j=0;j<s.length;j++){  
		               if(s[j][i]){  
		                   gs.fillRect(j*3+pixoff, i*3+pixoff, 3, 3);  
		               }  
		           }  
		       }  
		   }
		   
		 //String logoPath = "C://Users//Joshua//Desktop//2.jpg";
			ServletContext servletContext = request.getSession().getServletContext();//私服程序根目录
			String realPath = servletContext.getRealPath("logo");//logo为根目录下文件夹
			String logoPath = realPath+File.separator+"logo.jpg";
			File file = new File(logoPath);
	         if(!file.exists()){
	             System.err.print("该文件不存在"+logoPath);
	         }
	         Image imgLogo = ImageIO.read(file);//logo的图片
	         //int width2 = imgLogo.getWidth(null);
	         //int height2 = imgLogo.getHeight(null);
	         int width2 = 40;
	         int height2 = 40;
	         Image imgLogo2 = imgLogo.getScaledInstance(width2, height2, Image.SCALE_SMOOTH);//logo的图片
	         
	         //插入logo
	         int x = (bufferedImage.getWidth() - width2) / 2;
	         int y = (bufferedImage.getHeight() - height2) / 2;
	         gs.drawImage(imgLogo2, x, y, width2, height2, null);//将logo图片，用二维码图片的画笔画到二维码中
	         Shape shape = new RoundRectangle2D.Float(x, y, width2, height2, 6, 6);
	         gs.setStroke(new BasicStroke(3f));
	         gs.draw(shape);//logo图片塑性
		   
		   gs.dispose();  
		   bufferedImage.flush();  
		   //ImageIO.write(bufferedImage, "png", new File("C:/Users/Joshua/Desktop/qrcode.png"));
		   ImageIO.write(bufferedImage, "png", response.getOutputStream());
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	//生成图片二维码,邀请代理人
	@RequestMapping("codeUrlForInviteAgent")
	public void codeUrlForInviteAgent(HttpServletRequest request,HttpServletResponse response,Long id) {
		//Long id = getMyCurrUser();//如果id有传参，则使用该参数。（使未登录用户也可以访问该方法）
		if(id == null){
			id = getMyCurrUser();
		}
		//生成二维码中要存储的信息  
		//我的邀请码 http://192.168.1.16:9991/login/toRegister?inviteCode=
		String url="http://www.vbuyy.com/login/toRegisterForInviteAgent?inviteCode=";
		String hisInviteCode = url+id;
		//String qrData = "http://www.baidu.com";
		String qrData = hisInviteCode;  
		Qrcode qrcode = new Qrcode();  
		qrcode.setQrcodeErrorCorrect('M');//纠错等级（分为L、M、H三个等级）  
		qrcode.setQrcodeEncodeMode('B');//N代表数字，A代表a-Z，B代表其它字符  
		qrcode.setQrcodeVersion(7);//版本  
		//设置一下二维码的像素  
		//int width = 300;  
		//int height = 300;  
		int width = 67+12*(7-1);//139  
		int height = 67+12*(7-1);
		
		BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);  
		//绘图  
		Graphics2D gs = bufferedImage.createGraphics();  
		gs.setBackground(Color.WHITE);  
		gs.setColor(Color.BLACK);  
		gs.clearRect(0, 0, width, height);//清除下画板内容  
		//设置下偏移量,如果不加偏移量，有时会导致出错。  
		int pixoff = 2;  
		
		try {
			byte[] d = qrData.getBytes("gb2312");
			if(d.length > 0 && d.length <120){  
				boolean[][] s = qrcode.calQrcode(d);  
				for(int i=0;i<s.length;i++){  
					for(int j=0;j<s.length;j++){  
						if(s[j][i]){  
							gs.fillRect(j*3+pixoff, i*3+pixoff, 3, 3);  
						}  
					}  
				}  
			}
			
			//String logoPath = "C://Users//Joshua//Desktop//2.jpg";
			ServletContext servletContext = request.getSession().getServletContext();//私服程序根目录
			String realPath = servletContext.getRealPath("logo");//logo为根目录下文件夹
			String logoPath = realPath+File.separator+"logo.jpg";
			File file = new File(logoPath);
	         if(!file.exists()){
	             System.err.print("该文件不存在"+logoPath);
	         }
	         Image imgLogo = ImageIO.read(file);//logo的图片
	         //int width2 = imgLogo.getWidth(null);
	         //int height2 = imgLogo.getHeight(null);
	         int width2 = 40;
	         int height2 = 40;
	         Image imgLogo2 = imgLogo.getScaledInstance(width2, height2, Image.SCALE_SMOOTH);//logo的图片
	         
	         //插入logo
	         int x = (bufferedImage.getWidth() - width2) / 2;
	         int y = (bufferedImage.getHeight() - height2) / 2;
	         gs.drawImage(imgLogo2, x, y, width2, height2, null);//将logo图片，用二维码图片的画笔画到二维码中
	         Shape shape = new RoundRectangle2D.Float(x, y, width2, height2, 6, 6);
	         gs.setStroke(new BasicStroke(3f));
	         gs.draw(shape);//logo图片塑性
			
			
			
			gs.dispose();  
			bufferedImage.flush();  
			//ImageIO.write(bufferedImage, "png", new File("C:/Users/Joshua/Desktop/qrcode.png"));
			ImageIO.write(bufferedImage, "png", response.getOutputStream());
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	@RequestMapping("share")
	public String share(HttpServletRequest request,ModelMap modelMap,String inviteCode) {
		modelMap.put("hisInviteCode", inviteCode);
		Users users = userService.queryOne(modelMap);
		String headImgUrl="";//微信头像
		String nickName="";//微信昵称
		if(users != null){
			headImgUrl = users.getHeadImgUrl();
			if(StringUtils.isBlank(headImgUrl)){
				headImgUrl="/res/image/invite/ps.png";
			}
			nickName = users.getNickName();
			if(StringUtils.isBlank(nickName)){
				nickName="小微";
			}
		}
		//图片二维码
		String codeUrl=getQrCode(inviteCode);
		modelMap.addAttribute("headImgUrl",headImgUrl );
		modelMap.addAttribute("nickName",nickName );
		modelMap.addAttribute("codeUrl",codeUrl );

		//微信初始化分享
        String link = myUrl+"/invite/share?inviteCode="+inviteCode;
		initWxShare(request, modelMap,link);
		return JSP_PATH + "share";
	}
	
    @RequestMapping("toInviteWx")
    public String toInviteWx(ModelMap modelMap) {
        String backUrl = myUrl + "/invite/backInviteWx";
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
    
    @RequestMapping("backInviteWx")
    public String backInviteWx(@RequestParam(value = "sign", required = true) String sign,
                               HttpServletRequest request,HttpServletResponse response,
                               WxUsrDto wxUsrDto,ModelMap modelMap) {

        Map<String,Object> wxUsrMap = BeanUtil.transBean2Map(wxUsrDto);
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
            if (users != null) {//跳转到 邀请已登陆页面
                String headImgUrl = users.getHeadImgUrl();
                if(StringUtils.isBlank(headImgUrl)){
                    //获取unionId
                	Map<String, Object> params = getWxInfo(openId);
                    wxUsrMap.putAll(params);
                    //把openId对应key存入cookie
                    addOpenIdCookie(response,wxUsrMap);
                }
            	//我的邀请码
            	String hisInviteCode = users.getHisInviteCode();
            	//图片二维码
            	String codeUrl = getQrCode(hisInviteCode);
            	modelMap.addAttribute("hisInviteCode", hisInviteCode);
            	modelMap.addAttribute("codeUrl", codeUrl);
                //微信初始化分享
                String link = myUrl+"/invite/share?inviteCode="+hisInviteCode;
                initWxShare(request, modelMap,link);
            	return JSP_PATH + "has_login";
            } else {
                //跳转到邀请未登录页面

                //获取微信信息
            	Map<String, Object> params = getWxInfo(openId);
                wxUsrMap.putAll(params);
                //把openId对应key存入cookie
                addOpenIdCookie(response,wxUsrMap);

                //微信初始化分享，默认
                initWxShare(request, modelMap);
                return JSP_PATH +"not_login";
            }
        } else {
            return JSP_500;
        }
    }
    
    /**
     * 
     * <p> 
     *  获取邀请图片二维码
     * <p>
     * @param hisInviteCode 邀请码
     * @return
     * 
     * @throws
     */
    public String getQrCode(String hisInviteCode){
    	String codeUrl="data:image/jpg;base64,";
    	
        try {
        	String url = weixinUrl+"/api/createTemporary";
        	Map<String, String> map = new HashMap<String,String>();
        	map.put("expireSeconds", "2592000");
        	map.put("sceneId", hisInviteCode);
			String param = MapKit.sortMap(map);
			String sign = MdUtils.md5(param + "&key=" + weixinSignKey);

			logger.debug("签名参数串："+sign);
			map.put("sign", sign);
			String qrUrl = HttpKit.get(url, map);
			if(StringUtils.isBlank(qrUrl)){
				qrUrl = HttpKit.get(url, map);
			}
			codeUrl+= qrUrl;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("获取图片二维码异常");
		}
		return codeUrl;
    }
    public static void main(String[] args){
    	String mobile = "15811112222";
		String sub1 = mobile.substring(0, 3);
		String sub2 = mobile.substring(7, 11);
		System.out.println(sub1);
		System.out.println(sub2);
    }
}
