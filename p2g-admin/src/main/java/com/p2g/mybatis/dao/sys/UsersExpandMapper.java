package com.p2g.mybatis.dao.sys;
import java.util.List;

import com.github.pagehelper.PageInfo;
import com.p2g.core.base.BaseMapper;
import com.p2g.mybatis.model.generator.Users;

public interface UsersExpandMapper extends BaseMapper{

	PageInfo<Users> queryCount(Users users);
	
	List<String> queryRegisterCount( String regDate);

	List<String> queryInvestmentCount(String regDate);
}
