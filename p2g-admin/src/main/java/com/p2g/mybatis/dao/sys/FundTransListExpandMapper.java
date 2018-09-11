package com.p2g.mybatis.dao.sys;

import java.math.BigDecimal;
import java.util.Map;

import com.p2g.core.base.BaseMapper;

/**
 * 
 * @ClassName: FundTransListExpandMapper 
 * @Description: 资金交易
 * @author xujianwei 
 * @date 2016年6月27日 下午2:20:37 
 *
 */
public interface FundTransListExpandMapper extends BaseMapper {
	public BigDecimal querySum(Map<String, Object> map);
}
