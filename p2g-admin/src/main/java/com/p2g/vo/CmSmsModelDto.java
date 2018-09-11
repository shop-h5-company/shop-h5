package com.p2g.vo;

import java.io.Serializable;
import java.util.Date;

public class CmSmsModelDto extends PageDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String modelCode;
	private Date updateTime;
	public String getModelCode() {
		return modelCode;
	}
	public void setModelCode(String modelCode) {
		this.modelCode = modelCode;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
}