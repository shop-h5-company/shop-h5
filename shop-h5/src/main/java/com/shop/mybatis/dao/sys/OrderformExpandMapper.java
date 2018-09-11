package com.shop.mybatis.dao.sys;

import java.util.List;

import com.p2g.core.base.BaseMapper;
import com.shop.mybatis.model.generator.Orderform;

/**
 * Created on 2016-07-04 12:08.
 *
 * @author FanShukui
 */
public interface OrderformExpandMapper extends BaseMapper {
	
	/**
	 * 
	 * @param orderform
	 * @return
	 */
	int updateById(Orderform orderform);
	/**
	 * 通过用户id查询所有
	 * @param id
	 * @return
	 */
	List<Orderform> queryAllById(Long id);
	/**
	 * 通过手机号或姓名查询单号
	 * @param phOrName
	 * @return
	 */
	List<Orderform> queryAllByPhOrName(String phOrName);
	
}
