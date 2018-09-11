package com.shop.mybatis.dao.sys;

import java.util.List;
import java.util.Map;

import com.p2g.core.base.BaseMapper;
import com.shop.mybatis.model.generator.Prize;
import com.shop.mybatis.model.generator.Prizeconfig;

/**
 * Created on 2016-07-04 12:08.
 *
 * @author FanShukui
 */
public interface PrizeExpandMapper extends BaseMapper {
	
	/**
	 * 顶级代理商点击派奖修改字段
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
	List<Prize> queryAllByCurrentId(Long userId);
	List<Prize> getByUserId(Long userId);
	List<Prize> getLastest(int num);
	

}
