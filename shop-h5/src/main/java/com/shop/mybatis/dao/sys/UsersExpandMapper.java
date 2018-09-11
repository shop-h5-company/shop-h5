package com.shop.mybatis.dao.sys;

import java.util.List;
import java.util.Map;

import com.p2g.core.base.BaseMapper;
import com.shop.mybatis.model.generator.Users;

/**
 * Created on 2016-07-04 12:08.
 *
 * @author FanShukui
 */
public interface UsersExpandMapper extends BaseMapper {
	void updateUserPwd(Users users);
	
	int updateById(Users users);

	Users queryByWeixin(String weixin);

	void updateBindWeiXin(Users users);
	
	long queryCount(Map<String,Object> map);

	List<Users> queryAllById(long id);
	
	/**
	 * 通过点击的用户id获取上级用户信息
	 * @param currentUserId
	 * @return
	 */
	Users querySuperiorId(Long currentUserId);

	/**
	 * 查询上级id 为当前登陆id的所有用户！！！！！！
	 * @param id
	 * @return
	 */
	List<Users> querySubordinateIdList(Long id);
	
    //全表查询，看该用户：id，拥有多少个下线。
	Integer queryBySuperiorId(long id);

	void updateCountById(Users user);

	List<Users> queryListBySuperiorId(Long id);
}
