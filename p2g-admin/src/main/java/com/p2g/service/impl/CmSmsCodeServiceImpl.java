package com.p2g.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
import com.p2g.core.base.BaseServiceImpl;
import com.p2g.mybatis.dao.generator.CmSmsCodeMapper;
import com.p2g.mybatis.dao.sys.CmSmsCodeExpandMapper;
import com.p2g.mybatis.model.generator.CmSmsCode;
import com.p2g.service.CmSmsCodeService;

@Service("CmSmsCodeService")
public class CmSmsCodeServiceImpl extends BaseServiceImpl<CmSmsCode> implements CmSmsCodeService{
	@Autowired
	CmSmsCodeMapper cmSmsCodeMapper;
	@Autowired
	CmSmsCodeExpandMapper cmSmsCodeExpandMapper;

	@Override
    protected Object getMapper() {
        return cmSmsCodeMapper;
    }

	@Override
	public PageInfo<CmSmsCode> query(Map<String, Object> map) {
        this.startPage(map);
        return getPage(cmSmsCodeExpandMapper.query(map));
	}

}
