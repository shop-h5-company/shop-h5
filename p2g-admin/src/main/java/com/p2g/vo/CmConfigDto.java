package com.p2g.vo;

import java.io.Serializable;
import java.util.Date;

public class CmConfigDto extends PageDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String configCode;
	private String configValue;
	private Date createTime;
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getConfigCode() {
		return configCode;
	}
	public void setConfigCode(String configCode) {
		this.configCode = configCode;
	}
	public String getConfigValue() {
		return configValue;
	}
	public void setConfigValue(String configValue) {
		this.configValue = configValue;
	}
}