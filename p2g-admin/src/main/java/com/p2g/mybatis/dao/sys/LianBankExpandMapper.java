package com.p2g.mybatis.dao.sys;

import com.p2g.core.base.BaseMapper;
import com.p2g.mybatis.model.generator.LianBank;

import java.util.List;

/**\
 * 
 * @ClassName: LianBankExtendMapper 
 * @Description:连连支持银行
 * @author xujianwei 
 * @date 2016年6月28日 上午10:56:32 
 *
 */
public interface LianBankExpandMapper extends BaseMapper {

    List<LianBank> queryNeedBanks();
}
