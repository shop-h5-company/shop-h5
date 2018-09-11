package com.shop.service;

import java.util.List;

import com.p2g.core.base.BaseService;
import com.shop.mybatis.model.generator.Orderform;

public interface OrderformService extends BaseService<Orderform> {

	List<Orderform> queryAllById(Long id);

	int updateById(Orderform orderform);
	/**
	 * 通过手机号或姓名查询单号
	 * @param phOrName
	 * @return
	 */
	List<Orderform> queryAllByPhOrName(String phOrName);

	/**
	 * 批量添加订单
	 * @param orderformList
	 * @return
	 */
	void insertList(List<Orderform> orderformList);
}
