package com.p2g.vo;

import java.io.Serializable;
import java.util.Date;

public class UsersDto extends PageDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String mobile;
	private String userName;
	private String regDate;
	private Date regTime;
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public Date getRegTime() {
		return regTime;
	}
	public void setRegTime(Date regTime) {
		this.regTime = regTime;
	}
	
}
