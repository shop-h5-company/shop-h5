package com.p2g.core.base;

import com.github.pagehelper.Page;

import java.util.Map;

/**
 * @author FanShukui
 * @version 2016年6月3日 下午2:30:14
 */
public interface BaseMapper {
	/** 条件分页查询 */
	Page<Object> query(Map<String, Object> params);
}
