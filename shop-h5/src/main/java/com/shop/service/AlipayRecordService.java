package com.shop.service;

import com.shop.mybatis.model.generator.AlipayRecord;

public interface AlipayRecordService {

	void save(AlipayRecord alipayRecord);

	AlipayRecord findByOutTradeNo(String out_trade_no);

	void updateById(AlipayRecord alipayRecord2);

	int ifFirstBuy(Long userId, String status);

}
