package com.p2g.mybatis.dao.sys;

import java.math.BigDecimal;
import java.util.Map;

import com.p2g.core.base.BaseMapper;

/**
 * 
 * @ClassName: HqProfitLogExpandMapper 
 * @Description: 活期收益
 * @author xujianwei 
 * @date 2016年7月5日 下午3:40:35 
 *
 */
public interface HqProfitLogExpandMapper extends BaseMapper {
	public BigDecimal querySum(Map<String, Object> map);

}
