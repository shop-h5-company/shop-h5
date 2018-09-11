package com.p2g.service.impl;

import java.util.Map;

import com.p2g.core.base.BaseCacheService;
import com.p2g.core.base.BaseCacheServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
import com.p2g.core.base.BaseServiceImpl;
import com.p2g.mybatis.dao.generator.CmSmsModelMapper;
import com.p2g.mybatis.dao.sys.CmSmsModelExpandMapper;
import com.p2g.mybatis.model.generator.CmSmsModel;
import com.p2g.service.CmSmsModelService;

@Service("CmSmsModelService")
@CacheConfig(cacheNames="cmSmsModel")
public class CmSmsModelServiceImpl extends BaseCacheServiceImpl<CmSmsModel> implements CmSmsModelService{
	@Autowired
	CmSmsModelMapper cmSmsModelMapper;
	@Autowired
	CmSmsModelExpandMapper cmSmsModelExpandMapper;

	@Override
    protected Object getMapper() {
        return cmSmsModelMapper;
    }

	@Override
	public PageInfo<CmSmsModel> query(Map<String, Object> map) {
		if (map.get("orderBy") == null) {
			map.put("orderBy","update_time desc");
		}
        this.startPage(map);
        return getPage(cmSmsModelExpandMapper.query(map));
	}

	@Override
	protected Object getExpandMapper() {
		// TODO Auto-generated method stub
		return null;
	}

}
