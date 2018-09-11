package com.p2g.vo;

import java.io.Serializable;
import java.util.Date;

public class UserLoginLogDto extends PageDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String loginMode;
	private Date loginTime;
	public String getLoginMode() {
		return loginMode;
	}
	public void setLoginMode(String loginMode) {
		this.loginMode = loginMode;
	}
	public Date getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}
	
}
