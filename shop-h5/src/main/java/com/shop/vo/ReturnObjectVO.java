package com.shop.vo;

import java.util.HashMap;
/**
 * 通用返还值
 * 
 * @author zhaozizhen
 *
 */
public class ReturnObjectVO extends HashMap<String,Object>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8645900824350549932L;
	private String msg;//失败原因
	private int code;//0:失败  1：成功  99：重复提交 其他数据可以自定义
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.put("msg", msg);
		this.msg = msg;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.put("code", code);
		this.code = code;
	}

	public static ReturnObjectVO  success() {
		ReturnObjectVO res = new ReturnObjectVO();
		res.put("code", 1);
		res.put("msg", "成功");
		return res;
	}
	public static ReturnObjectVO  error(String errMsg) {
		ReturnObjectVO res = new ReturnObjectVO();
		res.put("code", 0);
		res.put("msg", errMsg);
		return res;
	}
	public static ReturnObjectVO  other(Integer code,String errMsg) {
		ReturnObjectVO res = new ReturnObjectVO();
		res.put("code", code);
		res.put("msg", errMsg);
		return res;
	}
}
