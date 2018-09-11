package com.p2g.vo;

import java.io.Serializable;

import org.springframework.data.domain.jaxb.SpringDataJaxb.PageDto;

import com.p2g.mybatis.model.generator.CmAnnouncement;

public class CmAnnouncementDto extends PageDto implements Serializable {
	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = 1L;
	private String beginTime;
	private String endTime;
	private String announceTitle;

	public String getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getAnnounceTitle() {
		return announceTitle;
	}

	public void setAnnounceTitle(String announceTitle) {
		this.announceTitle = announceTitle;
	}

}
