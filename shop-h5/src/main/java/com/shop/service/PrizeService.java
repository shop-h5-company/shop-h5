package com.shop.service;

import java.util.List;
import java.util.Map;

import com.p2g.core.base.BaseService;
import com.shop.mybatis.model.generator.Prize;

/**
 * Created on 2016-07-04 11:53.
 *
 * @author FanShukui
 */
public interface PrizeService extends BaseService<Prize> {

	/**
	 * 顶级代理商点击派奖修改字段（注：方法只能根据主键修改派奖时间）
	 * @param prize
	 * @return
	 */
	void updateById(Map<String,Object> map);
	/**
	 * 通过用户id查询所有奖品记录
	 * @param id
	 * @return
	 */
	List<Prize> queryAllById(Long id);
	void insertSelective(Prize prize);
	List<Prize> queryAllByCurrentUserId(Long userId);
	List<Prize> getByTopLevel(Long id);
	List<Prize> getByUserId(Long userId);
	/**
	 * 获取最近的num个奖品
	 */
	List<Prize> getLastest(int num);
}
