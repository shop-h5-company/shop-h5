package com.p2g.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
import com.p2g.core.base.BaseCacheServiceImpl;
import com.p2g.mybatis.dao.generator.CmConfigMapper;
import com.p2g.mybatis.dao.sys.CmConfigExpandMapper;
import com.p2g.mybatis.model.generator.CmConfig;
import com.p2g.service.CmConfigService;

@Service("CmConfigService")
@CacheConfig(cacheNames = "cmConfig")
public class CmConfigServiceImpl extends BaseCacheServiceImpl<CmConfig> implements CmConfigService{
	@Autowired
	CmConfigMapper cmConfigMapper;
	@Autowired
	CmConfigExpandMapper cmConfigExpandMapper;

	@Override
    protected Object getMapper() {
        return cmConfigMapper;
    }

	@Override
	public PageInfo<CmConfig> query(Map<String, Object> map) {
		if (map.get("orderBy") == null) {
			map.put("orderBy","update_time desc");
		}
        this.startPage(map);
        return getPage(cmConfigExpandMapper.query(map));
	}

	@Override
	protected Object getExpandMapper() {
		// TODO Auto-generated method stub
		return null;
	}


}
