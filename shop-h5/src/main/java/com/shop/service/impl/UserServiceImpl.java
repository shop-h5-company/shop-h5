package com.shop.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xframe.codec.MdUtils;

import com.github.pagehelper.PageInfo;
import com.p2g.core.base.BaseServiceImpl;
import com.shop.mybatis.dao.generator.UsersMapper;
import com.shop.mybatis.dao.sys.UsersExpandMapper;
import com.shop.mybatis.model.generator.Users;
import com.shop.mybatis.model.generator.UsersExample;
import com.shop.service.UserService;
/**
 * Created on 2016-07-04 11:55.
 *
 * @author FanShukui
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<Users> implements UserService {
    @Autowired
    UsersMapper usersMapper;

    @Autowired
    UsersExpandMapper usersExpandMapper;

    @Override
    public int updateById(Users users){
		return usersExpandMapper.updateById(users);
    }

    @Override
    public Users queryOne(Map<String, Object> map) {
        List<Users> usersList = getList(usersExpandMapper.query(map));
        if(usersList != null && usersList.size()>0){
        	return usersList.get(0);
        }
        return null;
    }

    @Override
    @Transactional
    public void updateBindWeiXin(Users users) {
        usersExpandMapper.updateBindWeiXin(users);
    }

    @Override
    public PageInfo<Users> query(Map<String, Object> map) {
    	if(map.get("orderBy")==null){
    		map.put("orderBy","user_id desc");
    	}
        this.startPage(map);
        return getPage(usersExpandMapper.query(map));
    }

    @Override
    public String encryptPassword(String password, String salt) {
        try {
            return MdUtils.sha1(password+salt);
        } catch (Exception e) {

        }
        return null;
    }

    @Override
    public boolean isExist(String mobile) {
        Map<String, Object> map=new HashMap<String,Object>();
        map.put("mobile",mobile);
        PageInfo<Users> usersPageInfo=this.query(map);
        if(usersPageInfo.getTotal()>0){
            return true;
        }
        return false;
    }

    @Override
    @Transactional
    public void updateUserPwd(Users users) {
        usersExpandMapper.updateUserPwd(users);
    }

    @Override
    protected Object getMapper() {
        return usersMapper;
    }

    @Override
    public Users queryByWeixin(String weixin) {
        return usersExpandMapper.queryByWeixin(weixin);
    }
    @Override
    public List<Users> queryAll() {
        return usersMapper.selectByExample(null);
    }
  /*
   * @Override
    public List<Users> queryAll() {
    	return usersMapper.selectAll();
    }*/
    /**
     *
     * @param password 新密码，明文
     * @param saltDb 库存密码随机串
     * @param pwdDb 库存加密密码
     * @return
     */
    @Override
    public boolean verifyPassword(String password, String saltDb, String pwdDb) {
        return pwdDb.equals(this.encryptPassword(password,saltDb));
    }

	@Override
	public long queryCount(Map<String,Object> map) {
		return usersExpandMapper.queryCount(map);
	}

	@Override
	public List<Users> queryAllById(long id) {
		return usersExpandMapper.queryAllById(id);
	}

	@Override
	public Users querySuperiorId(Long currentUserId) {
		return usersExpandMapper.querySuperiorId(currentUserId);
	}

	@Override
	public List<Users> querySubordinateIdList(Long id) {
		return usersExpandMapper.querySubordinateIdList(id);
	}
	//全表查询，看该用户拥有多少下线
	@Override
	public Integer queryBySuperiorId(long id) {
		return usersExpandMapper.queryBySuperiorId(id);
	}

	@Override
	public void updateCountById(Users user) {
		usersExpandMapper.updateCountById(user);
	}

	@Override
	public Users selectByMobile(String mobile) {
		UsersExample e = new UsersExample();
		e.createCriteria().andMobileEqualTo(mobile);
		List<Users> list = usersMapper.selectByExample(e);
		return list.get(0);
	}

	@Override
	public void updateInvitePersonNum(Users user2) {
		usersMapper.updateInvitePersonNum(user2);
	}

	@Override
	public List<Users> queryListBySuperiorId(Long id) {
		return usersExpandMapper.queryListBySuperiorId(id);
	}

	@Override
	public List<Users> queryByTopLevel(Long id) {
		UsersExample e = new UsersExample();
		e.createCriteria().andTopLevelEqualTo(id);
		e.setOrderByClause("add_Friend asc");//按照addFriend排序
		List<Users> list = usersMapper.selectByExample(e);
		return list;
	}

	@Override
	public void updateAddFriendById(Long userId, String addFriend) {
		Users user = new Users();
		user.setUserId(userId);
		user.setAddFriend(addFriend);
		if(addFriend.equals("0")){
			user.setCount(50);//审核通过的人，立即获得50积分。
		}
		usersMapper.updateCountAndFriendById(user);
	}

	@Override
	public void updateSelectiveById(Users user) {
		usersMapper.updateByPrimaryKeySelective(user);
	}

	@Override
	public Users getById(Long id) {
		UsersExample e = new UsersExample();
		e.createCriteria().andUserIdEqualTo(id);
		List<Users> list = usersMapper.selectByExample(e);
		return list.get(0);
	}

	@Override
	public List<Users> queryByIds(List<Long> userIds) {
		UsersExample e = new UsersExample();
		e.createCriteria().andUserIdIn(userIds);
		List<Users> list = usersMapper.selectByExample(e);
		return list;
	}

}
