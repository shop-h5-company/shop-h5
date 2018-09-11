package com.p2g.mybatis.dao.sys;

import java.math.BigDecimal;
import java.util.Map;

import com.p2g.core.base.BaseMapper;

/**
 * 
* @ClassName: FundAccountExpandMapper 
* @Description: 资金账户
* @author xujianwei 
* @date 2016年6月27日 上午10:46:30 
*
 */
public interface FundAccountExpandMapper extends BaseMapper {
	public BigDecimal querySum(Map<String, Object> map);
}
