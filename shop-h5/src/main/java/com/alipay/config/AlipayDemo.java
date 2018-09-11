package com.alipay.config;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeWapPayModel;
import com.alipay.api.request.AlipayTradeWapPayRequest;
import com.alipay.api.response.AlipayTradeWapPayResponse;
/**
 * 支付宝提供的支付demo
 * @author admin
 *
 */
public class AlipayDemo {
	// 商户appid （应用名称：应用2.0签约。。。）
	public static String APPID = "2018042760052343";
	// 私钥 pkcs8格式的
	//public static String RSA_PRIVATE_KEY = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQC3HtVXR7kqnkaxnPwNP5oyqkuUTgC5kuG5BJEknllZQV5yPTK4iNnrshRtsapvB5ZO2EOEQJDMWpmd8pKQ0y78lZZEb2gs5i4y9xsWlyVALu5Z3jrvn//rqesmFQB3w2Bhz3gIwtbjX05sljbPBOOLRqQ0k+jkI4nrtRKyhBILkKuxwOvuvINMfoAuxmtStt36rB0uyxrLKYrkHA/ZTbKCEn5mLrslUlFDwlTvVAVM7pmKq7AXDvRmko25RvmV2JFTPhQm7GOvvn4CRP638ns2CpbnxcsieKyDN2RDG5Gba+2SfB6w16bEA74bE0r5PK/oRjB5k7ofVLclomz1w1XXAgMBAAECggEAJYz2FJrJlrq0JnHZoeHb/e275+KC9YrwLJ+KH+c0zT/BXU29W+f8P//ZfpEDMRduNCbW2YTf7Hfbrm7yrS4RIYyPLuNlimd9K8hOTriZ0+qLx/PxQ/gcY7gJV1rRKL3wwr3nkGxb4m5Fx7CZ9qO7AXFv9LQr+rRq8OHFvsOka6hbFrjoBlLo4W8Z2TfiVpmMPbScFpy3bHZdG7mxmxpTXYM0reOHwywuq743YiYw8uIjbKG3XQTdb2H1WIDF1g3hwuo+Iq9Jbs4Aay/hIkY+383FstRCGeyVPYWtV8ozM0wdRzfn0hOMejcfDEPyuyh1ff04HHdBBp5E1blxEwXcAQKBgQDjFE37nz7fX0H3WMb/daA/PEfsmaJpQck723oig0mAUmKsiI35PwYrkOKX60hGOjS2pfFsmSbMe4QsK82jINRbJYFlewTyz4qOdoV+TCQ0pHuzAGQYxFItyFzN211DgDMxxMMhD5uf58woifNz/+9GHskOCwXJhHSaDFj+m0371wKBgQDOcUscq9xeB3yDzQfeVtBZ6is8sZCWFWQDLcNLcS5+uneaOMEqnijo1qZ0mnv2Xv8uSz8wGt3XfQpd7K3F9FOXrO1opgxHjoMoCq9mKypHmKaxJU+VGuAMbwVubnUUrt1dDB+u8EfsAW1zLQ9TBOZOtbiuDFmGzx8P5d5D2Jo2AQKBgDfcdNqjcBoPGvE4G6wYSZWExMTFfpiaIGDjOwZmeZxhp/h9lz9ra58oAzYQITV1eCY+aEeo3UyMThV3qRyqJNNPRKesPalluNYW/fv1yypQFEYSoI0fLoAou/vALQ8/6Fgj6USmzEfoA+ctGIC+wyPiyt7zgzbxqKWEyBfKKML9AoGAc3xhXnqt3lQlzb2G51R9Xa9n3J4gmjUBK94P4EZCklZRzg5t0R+FFyvtFlHNgveFnSovAQQmkgO7JuveEl0p3jG45c/uEqGgsWe401jWYBL/PR34NRtBtvLsgOh9ysI/x2ue1chJE7eAuOu+JN0a0XFLDOKPuqBnagdXnXCwZAECgYEA4aoqXKkpEkO9bsPUnGFlw/rp0KXss4WRVJaHw4IJmMY0aZtpj/obof5L78HDTNsN5WBKxRX+H4WTjt9tho+axzQ+cdPgtpX6Slrnb10osEQWlE82nFxcUVI2WmomgDnKFnRQRichYNQ9nVY8nahP1SFhVcA2gt1yIonloWMQpgI=";
	//public static String APP_PRIVATE_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAtx7VV0e5Kp5GsZz8DT+aMqpLlE4AuZLhuQSRJJ5ZWUFecj0yuIjZ67IUbbGqbweWTthDhECQzFqZnfKSkNMu/JWWRG9oLOYuMvcbFpclQC7uWd4675//66nrJhUAd8NgYc94CMLW419ObJY2zwTji0akNJPo5COJ67USsoQSC5CrscDr7ryDTH6ALsZrUrbd+qwdLssayymK5BwP2U2yghJ+Zi67JVJRQ8JU71QFTO6ZiquwFw70ZpKNuUb5ldiRUz4UJuxjr75+AkT+t/J7NgqW58XLInisgzdkQxuRm2vtknwesNemxAO+GxNK+Tyv6EYweZO6H1S3JaJs9cNV1wIDAQAB";
	public static String APP_PRIVATE_KEY = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQC3HtVXR7kqnkaxnPwNP5oyqkuUTgC5kuG5BJEknllZQV5yPTK4iNnrshRtsapvB5ZO2EOEQJDMWpmd8pKQ0y78lZZEb2gs5i4y9xsWlyVALu5Z3jrvn//rqesmFQB3w2Bhz3gIwtbjX05sljbPBOOLRqQ0k+jkI4nrtRKyhBILkKuxwOvuvINMfoAuxmtStt36rB0uyxrLKYrkHA/ZTbKCEn5mLrslUlFDwlTvVAVM7pmKq7AXDvRmko25RvmV2JFTPhQm7GOvvn4CRP638ns2CpbnxcsieKyDN2RDG5Gba+2SfB6w16bEA74bE0r5PK/oRjB5k7ofVLclomz1w1XXAgMBAAECggEAJYz2FJrJlrq0JnHZoeHb/e275+KC9YrwLJ+KH+c0zT/BXU29W+f8P//ZfpEDMRduNCbW2YTf7Hfbrm7yrS4RIYyPLuNlimd9K8hOTriZ0+qLx/PxQ/gcY7gJV1rRKL3wwr3nkGxb4m5Fx7CZ9qO7AXFv9LQr+rRq8OHFvsOka6hbFrjoBlLo4W8Z2TfiVpmMPbScFpy3bHZdG7mxmxpTXYM0reOHwywuq743YiYw8uIjbKG3XQTdb2H1WIDF1g3hwuo+Iq9Jbs4Aay/hIkY+383FstRCGeyVPYWtV8ozM0wdRzfn0hOMejcfDEPyuyh1ff04HHdBBp5E1blxEwXcAQKBgQDjFE37nz7fX0H3WMb/daA/PEfsmaJpQck723oig0mAUmKsiI35PwYrkOKX60hGOjS2pfFsmSbMe4QsK82jINRbJYFlewTyz4qOdoV+TCQ0pHuzAGQYxFItyFzN211DgDMxxMMhD5uf58woifNz/+9GHskOCwXJhHSaDFj+m0371wKBgQDOcUscq9xeB3yDzQfeVtBZ6is8sZCWFWQDLcNLcS5+uneaOMEqnijo1qZ0mnv2Xv8uSz8wGt3XfQpd7K3F9FOXrO1opgxHjoMoCq9mKypHmKaxJU+VGuAMbwVubnUUrt1dDB+u8EfsAW1zLQ9TBOZOtbiuDFmGzx8P5d5D2Jo2AQKBgDfcdNqjcBoPGvE4G6wYSZWExMTFfpiaIGDjOwZmeZxhp/h9lz9ra58oAzYQITV1eCY+aEeo3UyMThV3qRyqJNNPRKesPalluNYW/fv1yypQFEYSoI0fLoAou/vALQ8/6Fgj6USmzEfoA+ctGIC+wyPiyt7zgzbxqKWEyBfKKML9AoGAc3xhXnqt3lQlzb2G51R9Xa9n3J4gmjUBK94P4EZCklZRzg5t0R+FFyvtFlHNgveFnSovAQQmkgO7JuveEl0p3jG45c/uEqGgsWe401jWYBL/PR34NRtBtvLsgOh9ysI/x2ue1chJE7eAuOu+JN0a0XFLDOKPuqBnagdXnXCwZAECgYEA4aoqXKkpEkO9bsPUnGFlw/rp0KXss4WRVJaHw4IJmMY0aZtpj/obof5L78HDTNsN5WBKxRX+H4WTjt9tho+axzQ+cdPgtpX6Slrnb10osEQWlE82nFxcUVI2WmomgDnKFnRQRichYNQ9nVY8nahP1SFhVcA2gt1yIonloWMQpgI=";
	// 编码
	public static String CHARSET = "UTF-8";
	//这是支付宝公钥
	public static String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAtZj0Rsm/WLWT260yoU11uX3i/VOWANaRQ0NRTd90hV+8gbVKoH6K14dEcMVGJIEtkX9AX+bVXAY91J+SI3yVK6bvklT1EECngbQ7FcBi3K2Z5QvbJinZX/h8UlJBafeer5uw4yAYOVdmSdT/4QamCvTVCi6JLkxe5J/XLar2OrIm7JS0kad/7qwcwP96ngZKYFjPAYq5XdMndJ4EXcZJ72xmX8ZvdDH6n3xImYnxZr/McakFR9luFCDsk/0TBJki4GOGoobSDFBdc2JfEIKzIgC+goKuGpzGShu0Doce/OI34otzGkhhxGiBq329SBu5NtTCu5RdwmWXP0v9pTNs7QIDAQAB";
	//这是应用公钥
	//public static String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAtx7VV0e5Kp5GsZz8DT+aMqpLlE4AuZLhuQSRJJ5ZWUFecj0yuIjZ67IUbbGqbweWTthDhECQzFqZnfKSkNMu/JWWRG9oLOYuMvcbFpclQC7uWd4675//66nrJhUAd8NgYc94CMLW419ObJY2zwTji0akNJPo5COJ67USsoQSC5CrscDr7ryDTH6ALsZrUrbd+qwdLssayymK5BwP2U2yghJ+Zi67JVJRQ8JU71QFTO6ZiquwFw70ZpKNuUb5ldiRUz4UJuxjr75+AkT+t/J7NgqW58XLInisgzdkQxuRm2vtknwesNemxAO+GxNK+Tyv6EYweZO6H1S3JaJs9cNV1wIDAQAB";
	public static void main(String[] args) throws AlipayApiException {
	    /**********************/
	    // SDK 公共请求类，包含公共请求参数，以及封装了签名与验签，开发者无需关注签名与验签     
	    //调用RSA签名方式
	    AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.URL, AlipayConfig.APPID, AlipayConfig.RSA_PRIVATE_KEY, AlipayConfig.FORMAT, AlipayConfig.CHARSET, AlipayConfig.ALIPAY_PUBLIC_KEY,AlipayConfig.SIGNTYPE);
	    //AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.URL, AlipayConfig.APPID, APP_PRIVATE_KEY, AlipayConfig.FORMAT, AlipayConfig.CHARSET, ALIPAY_PUBLIC_KEY,AlipayConfig.SIGNTYPE);
	    AlipayTradeWapPayRequest alipay_request=new AlipayTradeWapPayRequest();
	    
	    // 封装请求支付信息
	    AlipayTradeWapPayModel model=new AlipayTradeWapPayModel();
	    model.setOutTradeNo("");// 商户订单号，商户网站订单系统中唯一订单号，必填
	    model.setSubject("");// 订单名称，必填
	    model.setTotalAmount("0.01");// 付款金额，必填
	    model.setBody("");// 商品描述，可空
	    model.setTimeoutExpress("");// 超时时间 可空
	    model.setProductCode("");// 销售产品码 必填 String product_code="QUICK_WAP_WAY";
	    alipay_request.setBizModel(model);
	    // 设置异步通知地址
	    alipay_request.setNotifyUrl(AlipayConfig.notify_url);
	    // 设置同步地址
	    alipay_request.setReturnUrl(AlipayConfig.return_url);   
	    AlipayTradeWapPayResponse res = alipayClient.execute(alipay_request);
	    System.out.println(res.toString());
	    System.out.println(res.getBody());
	}
}