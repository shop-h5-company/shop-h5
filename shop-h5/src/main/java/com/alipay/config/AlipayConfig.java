package com.alipay.config;


import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeCloseModel;
import com.alipay.api.request.AlipayTradeCloseRequest;
import com.alipay.api.response.AlipayTradeCloseResponse;

public class AlipayConfig {
	// 商户appid （应用名称：应用2.0签约。。。）
	public static String APPID = "2018042760052343";
	
	// 支付宝公钥
	public static String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAtZj0Rsm/WLWT260yoU11uX3i/VOWANaRQ0NRTd90hV+8gbVKoH6K14dEcMVGJIEtkX9AX+bVXAY91J+SI3yVK6bvklT1EECngbQ7FcBi3K2Z5QvbJinZX/h8UlJBafeer5uw4yAYOVdmSdT/4QamCvTVCi6JLkxe5J/XLar2OrIm7JS0kad/7qwcwP96ngZKYFjPAYq5XdMndJ4EXcZJ72xmX8ZvdDH6n3xImYnxZr/McakFR9luFCDsk/0TBJki4GOGoobSDFBdc2JfEIKzIgC+goKuGpzGShu0Doce/OI34otzGkhhxGiBq329SBu5NtTCu5RdwmWXP0v9pTNs7QIDAQAB";
	
	// 私钥 pkcs8格式的
	public static String RSA_PRIVATE_KEY = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQC3HtVXR7kqnkaxnPwNP5oyqkuUTgC5kuG5BJEknllZQV5yPTK4iNnrshRtsapvB5ZO2EOEQJDMWpmd8pKQ0y78lZZEb2gs5i4y9xsWlyVALu5Z3jrvn//rqesmFQB3w2Bhz3gIwtbjX05sljbPBOOLRqQ0k+jkI4nrtRKyhBILkKuxwOvuvINMfoAuxmtStt36rB0uyxrLKYrkHA/ZTbKCEn5mLrslUlFDwlTvVAVM7pmKq7AXDvRmko25RvmV2JFTPhQm7GOvvn4CRP638ns2CpbnxcsieKyDN2RDG5Gba+2SfB6w16bEA74bE0r5PK/oRjB5k7ofVLclomz1w1XXAgMBAAECggEAJYz2FJrJlrq0JnHZoeHb/e275+KC9YrwLJ+KH+c0zT/BXU29W+f8P//ZfpEDMRduNCbW2YTf7Hfbrm7yrS4RIYyPLuNlimd9K8hOTriZ0+qLx/PxQ/gcY7gJV1rRKL3wwr3nkGxb4m5Fx7CZ9qO7AXFv9LQr+rRq8OHFvsOka6hbFrjoBlLo4W8Z2TfiVpmMPbScFpy3bHZdG7mxmxpTXYM0reOHwywuq743YiYw8uIjbKG3XQTdb2H1WIDF1g3hwuo+Iq9Jbs4Aay/hIkY+383FstRCGeyVPYWtV8ozM0wdRzfn0hOMejcfDEPyuyh1ff04HHdBBp5E1blxEwXcAQKBgQDjFE37nz7fX0H3WMb/daA/PEfsmaJpQck723oig0mAUmKsiI35PwYrkOKX60hGOjS2pfFsmSbMe4QsK82jINRbJYFlewTyz4qOdoV+TCQ0pHuzAGQYxFItyFzN211DgDMxxMMhD5uf58woifNz/+9GHskOCwXJhHSaDFj+m0371wKBgQDOcUscq9xeB3yDzQfeVtBZ6is8sZCWFWQDLcNLcS5+uneaOMEqnijo1qZ0mnv2Xv8uSz8wGt3XfQpd7K3F9FOXrO1opgxHjoMoCq9mKypHmKaxJU+VGuAMbwVubnUUrt1dDB+u8EfsAW1zLQ9TBOZOtbiuDFmGzx8P5d5D2Jo2AQKBgDfcdNqjcBoPGvE4G6wYSZWExMTFfpiaIGDjOwZmeZxhp/h9lz9ra58oAzYQITV1eCY+aEeo3UyMThV3qRyqJNNPRKesPalluNYW/fv1yypQFEYSoI0fLoAou/vALQ8/6Fgj6USmzEfoA+ctGIC+wyPiyt7zgzbxqKWEyBfKKML9AoGAc3xhXnqt3lQlzb2G51R9Xa9n3J4gmjUBK94P4EZCklZRzg5t0R+FFyvtFlHNgveFnSovAQQmkgO7JuveEl0p3jG45c/uEqGgsWe401jWYBL/PR34NRtBtvLsgOh9ysI/x2ue1chJE7eAuOu+JN0a0XFLDOKPuqBnagdXnXCwZAECgYEA4aoqXKkpEkO9bsPUnGFlw/rp0KXss4WRVJaHw4IJmMY0aZtpj/obof5L78HDTNsN5WBKxRX+H4WTjt9tho+axzQ+cdPgtpX6Slrnb10osEQWlE82nFxcUVI2WmomgDnKFnRQRichYNQ9nVY8nahP1SFhVcA2gt1yIonloWMQpgI=";
	
	// 服务器异步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	//public static String notify_url = "http://商户网关地址/alipay.trade.wap.pay-JAVA-UTF-8/notify_url.jsp";
	public static String notify_url = "http://39.106.188.246:8080/alipay.trade.wap.pay-JAVA-UTF-8/notify_url.jsp";
	
	// 页面跳转同步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问 商户可以自定义同步跳转地址
	//1、阿里云会返回一些回调数据吗？写个控制器接收看看。
	//2、最终还需要跳转到一个页面。
	//public static String return_url = "http://39.106.188.246/login/callback";
	public static String return_url = "http://www.vbuyy.com/login/callback";
	//public static String return_url = "http://39.106.188.246:8080/alipay/return_url.jsp";
	
	// 请求网关地址
	public static String URL = "https://openapi.alipay.com/gateway.do";
	// 编码
	public static String CHARSET = "UTF-8";
	// 返回格式
	public static String FORMAT = "json";
	// 日志记录目录
	public static String log_path = "/log";
	// RSA2
	public static String SIGNTYPE = "RSA2";

}
