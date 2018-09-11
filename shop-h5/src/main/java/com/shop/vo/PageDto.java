package com.shop.vo;

import org.apache.commons.lang3.StringUtils;

/**
 * 
 * @ClassName: PageDto
 * @Description:分页对象
 * @author xujianwei
 * @date 2016年6月30日 上午11:31:45
 *
 */
public class PageDto {
	/**
	 * 当前页码
	 */
	private Integer pageCurrent;

	/**
	 * 需要排序字段
	 */
	private String orderField;
	/**
	 * 排序方向
	 */
	private String orderDirection;

	/**
	 * 每页显示多少条
	 */
	private Integer pageSize = 10;

	private Integer pageNum;

	private String orderBy;

	public Integer getPageCurrent() {
		return pageCurrent;
	}

	public void setPageCurrent(Integer pageCurrent) {
		this.pageCurrent = pageCurrent;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public String getOrderField() {
		return orderField;
	}

	public void setOrderField(String orderField) {
		this.orderField = orderField;
	}

	public String getOrderDirection() {
		return orderDirection;
	}

	public void setOrderDirection(String orderDirection) {
		this.orderDirection = orderDirection;
	}

	public String getOrderBy() {
		if (StringUtils.isNotBlank(this.orderField)
				&& StringUtils.isNotBlank(this.orderDirection)) {
			this.orderBy = this.orderField + " " + this.orderDirection;
		}
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	public Integer getPageNum() {
		if(pageNum == null) return this.pageCurrent;
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}
}
