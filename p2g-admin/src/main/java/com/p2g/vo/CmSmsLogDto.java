package com.p2g.vo;

import java.io.Serializable;
import java.util.Date;

public class CmSmsLogDto extends PageDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String mobile;
	private Date createTime;
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
}