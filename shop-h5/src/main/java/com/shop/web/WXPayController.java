package com.shop.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringWriter;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.BasicHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.github.wxpay.sdk.WXPayConstants.SignType;
import com.github.wxpay.sdk.WXPayUtil;
import com.shop.mybatis.model.generator.InviteAuthorityCode;
import com.shop.mybatis.model.generator.Users;
import com.shop.mybatis.model.generator.WxpayRecord;
import com.shop.service.InviteAuthorityCodeService;
import com.shop.service.UserService;
import com.shop.service.WxpayRecordService;
import com.shop.util.HttpClientUtil;

@Controller
@RequestMapping(value="/wxpay")
public class WXPayController extends MyBaseController{
	protected static Logger logger = Logger.getLogger(WXPayController.class);
	static String appid = "wxcf91fa4d9f461854";
	static String secret = "f0086d27504ee3c789cc3bfaa90ffa4a";//appSecret、api密钥都是这个值。
	static String mch_id = "1503400121";
	
	@Autowired
    UserService userService;
	@Autowired
	WxpayRecordService wxpayRecordService;
    @Autowired
    InviteAuthorityCodeService inviteAuthorityCodeService;
	
	@SuppressWarnings("null")
	@RequestMapping(value="getOpenid")
	@ResponseBody
	public void getOpenid(String code,HttpServletRequest req) throws Exception{
		//code说明 ： code作为换取access_token的票据，每次用户授权带上的code将不一样，code只能使用一次，5分钟未被使用自动过期。
		/** res：
		 * {"access_token":"11_psT5ZlpRnDfdJlIYAweCEnDxRbCmKn-hnwj3u0PLwVVL_oSwq4NtmnIxkYfxza957TtYg8-ZwqktlWSW6qvvY5MrqjPV7IxfImvMO1qD_UM",
		 * "expires_in":7200,
		 * "refresh_token":"11_yOhbTpEPlovuI1uM8JhcahKHfyI3O3cJZMl0I4fc41PhW7mGX2wl9kqFbsO4zH2S8nbkaD2CJbvfzGFBopxV5w91stNdfxF0TQbSMyxsTfM",
		 * "openid":"oVkme0VvLMU1fvwO3zzbrpKetuCA",
		 * "scope":"snsapi_base"}
		 */
		Long id = getMyCurrUser();
		Users user = userService.getById(id);
		//获取openid
		String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid="+appid+"&secret="+secret+"&code="+code+"&grant_type=authorization_code";
		String res = HttpClientUtil.getInstance().httpGet(url);
		JSONObject json = JSONObject.parseObject(res);
		String openid = json.getString("openid");
		//存储openid（同一个应用短时间内多次请求openid，不会返回了）
		if(openid != null || !openid.equals("")){
			Users user2 = new Users(); //存储openid
			user2.setUserId(user.getUserId());
			user2.setUnionId(openid);
			userService.updateSelectiveById(user2);
		}
		
	}
	/**
	 * 微信统一下单（只是可以调起微信软件）
	 * @param realPay 单位：元
	 * @throws Exception
	 */
	@RequestMapping(value="weixinBuy")
	@ResponseBody
	public Map<String, String> buy2(String typePay ,Integer buyNumber,String realPay,String ifHaveActivity,HttpServletRequest req) throws Exception{
    	ifHaveActivity = "0"; //没有活动
    	Long userId = getMyCurrUser();
    	if(userId == null){ //没登录访问
    		return null;
    	}
        // 付款金额，必填
    	int a = (Integer.parseInt(typePay))*buyNumber;
    	int b = Integer.parseInt(realPay);
    	if(a != b){
    		logger.error("微信购买，选项金额*购买数量与总金额不符，依次为："+typePay+","+buyNumber+","+realPay);
    		return null;//不予支付。（另：实际支付权限码时，也以微信返回的金额为准，防止恶意修改）
    	}
    	
		//准备统一下单参数
		String out_trade_no = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 30);
		String nonce_str = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 30);
		Users user = userService.getById(userId);
		Map<String, String> reqData = new HashMap<String, String>();
		reqData.put("appid", appid);
		reqData.put("mch_id", mch_id);
		reqData.put("out_trade_no", out_trade_no);
		reqData.put("trade_type", "JSAPI");
		reqData.put("nonce_str", nonce_str);
		reqData.put("body", "购买邀请权限码");
		//float moneyFloat = Float.parseFloat(money);
		//String total_fee = String.valueOf(moneyFloat*100);
		reqData.put("total_fee", realPay+"00");//微信支付单位是分
		//reqData.put("total_fee", "1");//微信支付单位是分
		reqData.put("spbill_create_ip", req.getRemoteAddr());
		logger.error("clientIp:"+req.getRemoteAddr());
		reqData.put("notify_url", "http://www.vbuyy.com/wxpay/callback");
        reqData.put("openid", user.getUnionId());
        reqData.put("sign_type", "MD5");
        reqData.put("sign", generateSignature(reqData, secret, SignType.MD5));
        String reqBody = mapToXml(reqData);
        
    	//生成待支付订单
    	WxpayRecord alipayRecord = new WxpayRecord();
    	alipayRecord.setMoney(realPay+".00");//项目中没有角分的零钱。(单位：元)
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
    	wxpayRecordService.save(alipayRecord);
        
        //统一下单
        String res = requestOnce("https://api.mch.weixin.qq.com/pay/unifiedorder", reqBody, 6*1000, 6*1000, false);
        Map<String, String> resMp = WXPayUtil.xmlToMap(res);
        Map<String, String> map2 = new HashMap<String, String>();
        map2.put("appId", appid);
        map2.put("nonceStr", resMp.get("nonce_str"));//可以用统一下单返回的
        map2.put("signType", "MD5");
        map2.put("timeStamp", new Date().getTime()/1000+"");//时间精确到秒
        map2.put("package", "prepay_id="+resMp.get("prepay_id"));//只能用统一下单返回的
        map2.put("paySign", generateSignature(map2, secret, SignType.MD5));//需要再次加密
        return map2;
	}
    @RequestMapping(value="21callback3333",method=RequestMethod.POST,produces="application/json")
    public String callback(HttpServletRequest req) throws IOException{
    	
    	logger.error("微信回调返回值：");
    	BufferedReader reader = req.getReader();
    	String res = "";
    	if((res=reader.readLine()) != null){
    		logger.error("微信回调返回值："+res);
    	};
    	
    	return "redirect:/user/index";//重定向到我的首页
    }
    
    /**
	 * 异步回调接口
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value="/callback",method=RequestMethod.POST,produces="text/html;charset=utf-8") //流
	@ResponseBody
	public String WeixinParentNotifyPage(HttpServletRequest request,HttpServletResponse response) throws Exception{
		ServletInputStream instream = request.getInputStream();
		StringBuffer sb = new StringBuffer();
		int len = -1;
		byte[] buffer = new byte[1024];
		while((len = instream.read(buffer)) != -1){
			sb.append(new String(buffer,0,len));
		}
		logger.error("支付通知回调结果："+sb);
		instream.close();
		Map<String,String> resMap = WXPayUtil.xmlToMap(sb.toString());
		Map<String,String> return_data = new HashMap<String,String>();
			if(resMap.get("return_code").toString().equals("FAIL")){//支付失败
				return_data.put("return_code", "FAIL");
				return_data.put("result_code", "FAIL");
				return_data.put("return_msg", resMap.get("return_msg"));
			}else if(resMap.get("return_code").toString().equals("SUCCESS")){//支付成功
					return_data.put("result_code", resMap.get("result_code"));
					return_data.put("return_code", resMap.get("return_code"));
					return_data.put("return_msg", resMap.get("return_msg"));
					String total_fee = resMap.get("total_fee").toString(); //返回的总金额（单位：分）
					String out_trade_no = resMap.get("out_trade_no").toString();//返回的订单号
					//获取该交易单号
					WxpayRecord wxpayRecord = wxpayRecordService.findByOutTradeNo(out_trade_no);
					if(wxpayRecord.getStatus().equals("0")){//1：微信大概会有5次回调。
						String money = wxpayRecord.getMoney().replace(".", "");
						if(!(money).equals(total_fee)){//2：保证支付金额和回调金额一致，防止恶意修改
							logger.error("微信支付回调出错："+new Date()+";金额不一致");
							return "";
						}
						/**根据付费价格，给用户发放邀请权限码。1、根据金额次数，生成邀请权限码记录。2、同时该条记录的购买者设置为该用户
						 * 备注：首次购买，赠送当前购买次数一半的权限邀请码
						 * 活动：买一送一
						 */
						try {
							Long userId = wxpayRecord.getUserId();
							String ifHaveActivity = wxpayRecord.getIfHaveActivity();//是否有活动
							Users user = userService.queryById(userId);
							int cishu = wxpayRecordService.ifFirstBuy(userId,"1");//返回0则是首次用微信购买
							boolean ifFirstBuy = (cishu == 0)?true:false;
							
							String type = wxpayRecord.getType();//购买的商品类型（1）
							Integer buyNumber = wxpayRecord.getBuyNumber();//该商品购买的数量（2）
							//生成权限码记录
							createCode(ifFirstBuy, ifHaveActivity, buyNumber, type, user);
							//最后，修改该订单的支付状态
							if(wxpayRecord != null && wxpayRecord.getStatus().equals("0")){
								WxpayRecord temp = new WxpayRecord();
								temp.setId(wxpayRecord.getId());
								temp.setStatus("1");//已支付
								temp.setTime(new Date());
								wxpayRecordService.updateById(temp);
							}
						} catch (Exception e) {
							e.printStackTrace();
							logger.error("微信支付后，生成权限码日期："+new Date()+";出错信息:", e);
						}
						
					}
			}
		String xml = WXPayUtil.mapToXml(return_data);
		return xml;
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
					Integer InvitePersonNum = 20+20/2;//初次微信购买，赠送一半
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
    
	/**
	 * 备注：此方法一下都是微信提供的方法
	 */
	
    /** 
     * 生成签名. 注意，若含有sign_type字段，必须和signType参数保持一致。
     * @param data 待签名数据
     * @param key API密钥
     * @param signType 签名方式
     * @return 签名
     */
    public static String generateSignature(final Map<String, String> data, String key, SignType signType) throws Exception {
        Set<String> keySet = data.keySet();
        String[] keyArray = keySet.toArray(new String[keySet.size()]);
        Arrays.sort(keyArray);
        StringBuilder sb = new StringBuilder();
        for (String k : keyArray) {
            if (k.equals("sign")) {
                continue;
            }
            if (data.get(k).trim().length() > 0) // 参数值为空，则不参与签名
                sb.append(k).append("=").append(data.get(k).trim()).append("&");
        }
        sb.append("key=").append(key);
        if (SignType.MD5.equals(signType)) {
            return MD5(sb.toString()).toUpperCase();
        }  else {
            throw new Exception(String.format("Invalid sign_type: %s", signType));
        }
    }
    /**
     * 将Map转换为XML格式的字符串
     *
     * @param data Map类型数据
     * @return XML格式的字符串
     * @throws Exception
     */
    public static String mapToXml(Map<String, String> data) throws Exception {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder= documentBuilderFactory.newDocumentBuilder();
        org.w3c.dom.Document document = documentBuilder.newDocument();
        org.w3c.dom.Element root = document.createElement("xml");
        document.appendChild(root);
        for (String key: data.keySet()) {
            String value = data.get(key);
            if (value == null) {
                value = "";
            }
            value = value.trim();
            org.w3c.dom.Element filed = document.createElement(key);
            filed.appendChild(document.createTextNode(value));
            root.appendChild(filed);
        }
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();
        DOMSource source = new DOMSource(document);
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        StringWriter writer = new StringWriter();
        StreamResult result = new StreamResult(writer);
        transformer.transform(source, result);
        String output = writer.getBuffer().toString(); //.replaceAll("\n|\r", "");
        try {
            writer.close();
        }
        catch (Exception ex) {
        }
        return output;
    }
    /**
     * 生成 MD5
     *
     * @param data 待处理数据
     * @return MD5结果
     */
    public static String MD5(String data) throws Exception {
        java.security.MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] array = md.digest(data.getBytes("UTF-8"));
        StringBuilder sb = new StringBuilder();
        for (byte item : array) {
            sb.append(Integer.toHexString((item & 0xFF) | 0x100).substring(1, 3));
        }
        return sb.toString().toUpperCase();
    }
    /**
     * 请求
     * @param url
     * @param data
     * @param connectTimeoutMs
     * @param readTimeoutMs
     * @param useCert
     * @return
     * @throws Exception
     */
    private static String requestOnce(final String url, String data, int connectTimeoutMs, int readTimeoutMs, boolean useCert) throws Exception {
        BasicHttpClientConnectionManager connManager;
            connManager = new BasicHttpClientConnectionManager(
                    RegistryBuilder.<ConnectionSocketFactory>create()
                            .register("http", PlainConnectionSocketFactory.getSocketFactory())
                            .register("https", SSLConnectionSocketFactory.getSocketFactory())
                            .build(),
                    null,
                    null,
                    null
            );

        HttpClient httpClient = HttpClientBuilder.create()
                .setConnectionManager(connManager)
                .build();

        HttpPost httpPost = new HttpPost(url);

        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(readTimeoutMs).setConnectTimeout(connectTimeoutMs).build();
        httpPost.setConfig(requestConfig);

        StringEntity postEntity = new StringEntity(data, "UTF-8");
        httpPost.addHeader("Content-Type", "text/xml");
        httpPost.addHeader("User-Agent", "wxpay sdk java v1.0 " + mch_id);  // TODO: 很重要，用来检测 sdk 的使用情况，要不要加上商户信息？
        httpPost.setEntity(postEntity);

        HttpResponse httpResponse = httpClient.execute(httpPost);
        HttpEntity httpEntity = httpResponse.getEntity();
        return EntityUtils.toString(httpEntity, "UTF-8");

    }
}
