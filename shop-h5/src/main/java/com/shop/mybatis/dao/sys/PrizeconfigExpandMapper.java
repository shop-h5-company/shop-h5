package com.shop.mybatis.dao.sys;

import java.util.List;
import java.util.Map;

import com.p2g.core.base.BaseMapper;
import com.shop.mybatis.model.generator.Prizeconfig;

/**
 * Created on 2016-07-04 12:08.
 *
 * @author FanShukui
 */
public interface PrizeconfigExpandMapper extends BaseMapper {
	
	/**
	 * 修改数据
	 * @param prizeConfig
	 * @return
	 */
	int updateById(Prizeconfig prizeConfig);
	
	/**
	 * 通过顶级代理商id查询所有奖品
	 * @param topLevel
	 * @return
	 */
	List<Prizeconfig> queryAllByTopLevelId(Long topLevel);
	
	List<Prizeconfig> queryBySequence(String sequence);

	//void updateById(Prizeconfig prizeconfig);

	List<Prizeconfig> queryBy(Map<String, Object> map);

	void updatePrizeNum(Long prizeId);

	void insert(Prizeconfig prizeconfig);
}
