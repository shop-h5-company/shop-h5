package com.shop.vo;

import java.io.Serializable;
/**
 * 通用返还值
 * 
 * @author zhaozizhen
 *
 */
public class ReturnSerializableVO implements Serializable{

	private String code;//0:失败  1：成功  99：重复提交 其他数据可以自定义
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
}
