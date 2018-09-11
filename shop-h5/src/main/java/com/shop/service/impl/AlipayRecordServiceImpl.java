package com.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.mybatis.dao.generator.AlipayRecordMapper;
import com.shop.mybatis.model.generator.AlipayRecord;
import com.shop.mybatis.model.generator.AlipayRecordExample;
import com.shop.service.AlipayRecordService;
@Service
public class AlipayRecordServiceImpl implements AlipayRecordService{
	
	@Autowired
	private AlipayRecordMapper alipayRecordMapper;
	@Override
	public void save(AlipayRecord alipayRecord) {
		alipayRecordMapper.insertSelective(alipayRecord);
	}
	@Override
	public AlipayRecord findByOutTradeNo(String out_trade_no) {
		AlipayRecordExample e = new AlipayRecordExample();
		e.createCriteria().andOutTradeNoEqualTo(out_trade_no);
		List<AlipayRecord> list = alipayRecordMapper.selectByExample(e);
		if(!list.isEmpty()){
			return list.get(0);
		}
		return null;
	}
	@Override
	public void updateById(AlipayRecord alipayRecord2) {
		alipayRecordMapper.updateByPrimaryKeySelective(alipayRecord2);
	}
	@Override
	public int ifFirstBuy(Long userId, String status) {
		AlipayRecordExample e = new AlipayRecordExample();
		e.createCriteria().andUserIdEqualTo(userId).andStatusEqualTo(status);
		return alipayRecordMapper.countByExample(e);
	}

}
