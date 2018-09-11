package com.shop.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
import com.p2g.core.base.BaseServiceImpl;
import com.shop.mybatis.dao.generator.PrizeconfigMapper;
import com.shop.mybatis.dao.sys.PrizeconfigExpandMapper;
import com.shop.mybatis.model.generator.Prizeconfig;
import com.shop.service.PrizeconfigService;
/**
 * Created on 2016-07-04 11:55.
 *
 * @author FanShukui
 */
@Service
public class PrizeconfigServiceImpl extends BaseServiceImpl<Prizeconfig> implements PrizeconfigService {
    @Autowired
    PrizeconfigMapper prizeconfigMapper;

    @Autowired
    PrizeconfigExpandMapper prizeconfigExpandMapper;


    @Override
    public PageInfo<Prizeconfig> query(Map<String, Object> map) {
    	if(map.get("orderBy")==null){
    		map.put("orderBy","user_id desc");
    	}
        this.startPage(map);
        return getPage(prizeconfigExpandMapper.query(map));
    }


	@Override
	protected Object getMapper() {
		return prizeconfigMapper;
	}


	@Override
	public List<Prizeconfig> queryAllByTopLevelId(Long topLevel) {
		return prizeconfigExpandMapper.queryAllByTopLevelId(topLevel);
	}


	@Override
	public void updateById(Prizeconfig prizeconfig) {
		prizeconfigMapper.updateByPrimaryKey(prizeconfig);
	}
/*	@Override
	public void updateById(Prizeconfig prizeconfig) {
		prizeconfigExpandMapper.updateById(prizeconfig);
	}
*/

	@Override
	public Prizeconfig queryBySequence(String sequence) {
		List<Prizeconfig> list = prizeconfigExpandMapper.queryBySequence(sequence);
		if(!list.isEmpty()){
			return list.get(0);
		}
		return null;
	}


	@Override
	public Prizeconfig queryBy(String sequence, Long id) {
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("sequence", sequence);
		map.put("id", id);
		List<Prizeconfig> list = prizeconfigExpandMapper.queryBy(map);
		if(!list.isEmpty()){
			return list.get(0);
		}
		return null;
	}


	@Override
	public void updatePrizeNum(Long prizeId) {
		prizeconfigExpandMapper.updatePrizeNum(prizeId);
	}
	@Override
	public void insertSelective(Prizeconfig prizeconfig) {
		prizeconfigExpandMapper.insert(prizeconfig);
	}


}
