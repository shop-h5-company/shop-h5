package com.p2g.mybatis.dao.sys;

import com.p2g.core.base.BaseMapper;
import org.springframework.ui.ModelMap;

/**
 * Created by GJF on 2016/6/28.
 */
public interface DqBankCheckExpandMapper extends BaseMapper {

    void dqBankCheckById(ModelMap modelMap);
}
