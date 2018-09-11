package com.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.mybatis.dao.generator.WxpayRecordMapper;
import com.shop.mybatis.model.generator.WxpayRecord;
import com.shop.mybatis.model.generator.WxpayRecordExample;
import com.shop.service.WxpayRecordService;
@Service
public class WxpayRecordServiceImpl implements WxpayRecordService{
	
	@Autowired
	private WxpayRecordMapper wxpayRecordMapper;
	@Override
	public void save(WxpayRecord wxpayRecord) {
		wxpayRecordMapper.insertSelective(wxpayRecord);
	}
	@Override
	public WxpayRecord findByOutTradeNo(String out_trade_no) {
		WxpayRecordExample e = new WxpayRecordExample();
		e.createCriteria().andOutTradeNoEqualTo(out_trade_no);
		List<WxpayRecord> list = wxpayRecordMapper.selectByExample(e);
		if(!list.isEmpty()){
			return list.get(0);
		}
		return null;
	}
	@Override
	public void updateById(WxpayRecord wxpayRecord) {
		wxpayRecordMapper.updateByPrimaryKeySelective(wxpayRecord);
	}
	@Override
	public int ifFirstBuy(Long userId, String status) {
		WxpayRecordExample e = new WxpayRecordExample();
		e.createCriteria().andUserIdEqualTo(userId).andStatusEqualTo(status);
		return wxpayRecordMapper.countByExample(e);
	}

}
