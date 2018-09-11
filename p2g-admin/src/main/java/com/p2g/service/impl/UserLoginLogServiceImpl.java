package com.p2g.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
import com.p2g.core.base.BaseServiceImpl;
import com.p2g.mybatis.dao.generator.UserLoginLogMapper;
import com.p2g.mybatis.dao.sys.UserLoginLogExpandMapper;
import com.p2g.mybatis.model.generator.UserLoginLog;
import com.p2g.service.UserLoginLogService;

@Service("UserLoginLogService")
public class UserLoginLogServiceImpl extends BaseServiceImpl<UserLoginLog> implements UserLoginLogService{
	@Autowired
	UserLoginLogMapper UserLoginLogMapper;
	@Autowired
	UserLoginLogExpandMapper UserLoginLogExpandMapper;

	@Override
    protected Object getMapper() {
        return UserLoginLogMapper;
    }

	@Override
	public PageInfo<UserLoginLog> query(Map<String, Object> map) {
		if (map.get("orderBy") == null) {
			map.put("orderBy","login_time desc");
		}
        this.startPage(map);
        return getPage(UserLoginLogExpandMapper.query(map));
	}

}
