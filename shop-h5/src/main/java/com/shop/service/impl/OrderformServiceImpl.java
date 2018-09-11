package com.shop.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageInfo;
import com.p2g.core.base.BaseServiceImpl;
import com.shop.mybatis.dao.generator.OrderformMapper;
import com.shop.mybatis.dao.sys.OrderformExpandMapper;
import com.shop.mybatis.model.generator.Orderform;
import com.shop.service.OrderformService;
/**
 * Created on 2016-07-04 11:55.
 *
 * @author FanShukui
 */
@Service
public class OrderformServiceImpl extends BaseServiceImpl<Orderform> implements OrderformService {
    @Autowired
    OrderformMapper orderformMapper;

    @Autowired
    OrderformExpandMapper orderformExpandMapper;


    @Override
    public PageInfo<Orderform> query(Map<String, Object> map) {
    	if(map.get("orderBy")==null){
    		map.put("orderBy","user_id desc");
    	}
        this.startPage(map);
        return getPage(orderformExpandMapper.query(map));
    }


	@Override
	protected Object getMapper() {
		return orderformMapper;
	}

	
	
	@Override
	public List<Orderform> queryAllById(Long id) {
		return orderformExpandMapper.queryAllById(id);
	}


	@Override
	public int updateById(Orderform orderform) {
		return orderformExpandMapper.updateById(orderform);
	}


	@Override
	public List<Orderform> queryAllByPhOrName(String phOrName) {
		return orderformExpandMapper.queryAllByPhOrName(phOrName);
	}
	
	//批量新增数据
	@Transactional
	public void insertList(List<Orderform> orderformlist) {
    	for (int i = 0; i < orderformlist.size(); i++) {
    		orderformMapper.insert(orderformlist.get(i));
		}
    }

}
