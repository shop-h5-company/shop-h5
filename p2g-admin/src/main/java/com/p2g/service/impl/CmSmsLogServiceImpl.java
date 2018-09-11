package com.p2g.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
import com.p2g.core.base.BaseServiceImpl;
import com.p2g.mybatis.dao.generator.CmSmsLogMapper;
import com.p2g.mybatis.dao.sys.CmSmsLogExpandMapper;
import com.p2g.mybatis.model.generator.CmSmsLog;
import com.p2g.service.CmSmsLogService;

@Service("CmSmsLogService")
public class CmSmsLogServiceImpl extends BaseServiceImpl<CmSmsLog> implements CmSmsLogService{
	@Autowired
	CmSmsLogMapper cmSmsLogMapper;
	@Autowired
	CmSmsLogExpandMapper cmSmsLogExpandMapper;

	@Override
    protected Object getMapper() {
        return cmSmsLogMapper;
    }

	@Override
	public PageInfo<CmSmsLog> query(Map<String, Object> map) {
        this.startPage(map);
        return getPage(cmSmsLogExpandMapper.query(map));
	}

}
