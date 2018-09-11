package com.shop.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
import com.p2g.core.base.BaseServiceImpl;
import com.shop.mybatis.dao.generator.PrizeMapper;
import com.shop.mybatis.dao.sys.PrizeExpandMapper;
import com.shop.mybatis.model.generator.Prize;
import com.shop.service.PrizeService;
/**
 * Created on 2016-07-04 11:55.
 *
 * @author FanShukui
 */
@Service
public class PrizeServiceImpl extends BaseServiceImpl<Prize> implements PrizeService {
    @Autowired
    PrizeMapper prizeMapper;

    @Autowired
    PrizeExpandMapper prizeExpandMapper;


    @Override
    public PageInfo<Prize> query(Map<String, Object> map) {
    	if(map.get("orderBy")==null){
    		map.put("orderBy","user_id desc");
    	}
        this.startPage(map);
        return getPage(prizeExpandMapper.query(map));
    }


	@Override
	protected Object getMapper() {
		return prizeMapper;
	}

	
	
	@Override
	public List<Prize> queryAllById(Long id) {
		return prizeExpandMapper.queryAllById(id);
	}


	@Override
	public int updateById(Prize prize) {
		return prizeExpandMapper.updateById(prize);
	}


	@Override
	public void insertSelective(Prize prize) {
		prizeExpandMapper.insertSelective(prize);
	}


	@Override
	public List<Prize> queryAllByCurrentUserId(Long userId) {
		List<Prize> prizes = prizeExpandMapper.queryAllByCurrentId(userId);
		return prizes;
	}

}
