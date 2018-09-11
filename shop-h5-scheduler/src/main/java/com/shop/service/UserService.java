package com.shop.service;

import java.util.List;
import java.util.Map;

import com.p2g.core.base.BaseService;
import com.shop.mybatis.model.generator.Users;

/**
 * Created on 2016-07-04 11:53.
 *
 * @author FanShukui
 */
public interface UserService extends BaseService<Users> {
    public String encryptPassword(String password,String salt);

    public boolean verifyPassword(String password,String saltDb,String pwdDb);

    boolean isExist(String mobile);
    
    void updateUserPwd(Users users);
    
	public int updateById(Users users);

    public Users queryByWeixin(String weixin);

    Users queryOne(Map<String, Object> map);

    void updateBindWeiXin(Users users);
    
    public List<Users> queryAll();
    
    public long queryCount(Map<String,Object> map);

	public List<Users> queryAllById(long id);

	/**
	 * 通过点击的用户id获取上级用户信息
	 * @param currentUserId
	 * @return
	 */
	public Users querySuperiorId(Long currentUserId);
	
	/**
	 * 通过上级id为顶级代理商id的获取下级用户信息
	 * 查询上级id 为当前登陆id的所有用户！！！！！！
	 * @param currentUserId
	 * @return
	 */
	List<Users> querySubordinateIdList(Long id);
	/**
	 * 全表查询，看该用户拥有多少下线
	 * @param id
	 * @return
	 */
	public Integer queryBySuperiorId(long id);
	//更新已抽奖次数
	public void updateCountById(Users user);
    
}
