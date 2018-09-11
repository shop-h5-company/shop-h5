package com.shop.service;

import com.shop.mybatis.model.generator.WxpayRecord;

public interface WxpayRecordService {

	void save(WxpayRecord alipayRecord);

	WxpayRecord findByOutTradeNo(String out_trade_no);

	void updateById(WxpayRecord wxpayRecord);

	int ifFirstBuy(Long userId, String status);

}
