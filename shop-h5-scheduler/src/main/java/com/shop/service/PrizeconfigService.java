package com.shop.service;

import java.util.List;

import com.p2g.core.base.BaseService;
import com.shop.mybatis.model.generator.Prizeconfig;

/**
 * Created on 2016-07-04 11:53.
 *
 * @author FanShukui
 */
public interface PrizeconfigService extends BaseService<Prizeconfig> {

	/**
	 * 通过顶级代理商id查询所有奖品
	 * @param topLevel
	 * @return
	 */
	List<Prizeconfig> queryAllByTopLevelId(Long topLevel);

	/**
	 * 修改数据
	 * @param prizeConfig
	 * @return
	 */
	void updateById(Prizeconfig prizeconfig);

	Prizeconfig queryBySequence(String sequence);

	Prizeconfig queryBy(String sequence, Long id);
	/**
	 * 根据主键修改奖品数量减一
	 * @param prizeId
	 */
	void updatePrizeNum(Long prizeId);
	
}
