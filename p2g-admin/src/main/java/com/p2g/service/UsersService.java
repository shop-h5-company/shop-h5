package com.p2g.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.p2g.core.base.BaseService;
import com.p2g.mybatis.model.generator.Users;

public interface UsersService extends BaseService<Users>{

	PageInfo<Users> queryCount(Users users);
	
	List<String> queryRegisterCount(String regDate);
	List<String> queryInvestmentCount(String regDate);
}
