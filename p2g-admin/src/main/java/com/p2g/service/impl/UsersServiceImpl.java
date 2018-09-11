package com.p2g.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
import com.p2g.core.base.BaseServiceImpl;
import com.p2g.mybatis.dao.generator.UsersMapper;
import com.p2g.mybatis.dao.sys.UsersExpandMapper;
import com.p2g.mybatis.model.generator.Users;
import com.p2g.service.UsersService;

@Service("UsersService")
public class UsersServiceImpl extends BaseServiceImpl<Users> implements
		UsersService {
	@Autowired
	UsersMapper usersMapper;
	@Autowired
	UsersExpandMapper usersExpandMapper;

	@Override
	protected Object getMapper() {
		return usersMapper;
	}

	@Override
	public PageInfo<Users> query(Map<String, Object> map) {
		if (map.get("orderBy") == null) {
			map.put("orderBy", "reg_time desc");
		}
		this.startPage(map);
		return getPage(usersExpandMapper.query(map));
	}
	
	@Override
	public PageInfo<Users> queryCount(Users users) {
		return usersExpandMapper.queryCount(users);
	}
	
	public List<String> queryRegisterCount(String regDate){
		return usersExpandMapper.queryRegisterCount(regDate);
	}

	@Override
	public List<String> queryInvestmentCount(String regDate) {
		return usersExpandMapper.queryInvestmentCount(regDate);
	}

}
