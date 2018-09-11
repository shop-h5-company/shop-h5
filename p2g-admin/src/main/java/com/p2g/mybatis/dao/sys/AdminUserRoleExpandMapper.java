package com.p2g.mybatis.dao.sys;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.p2g.core.base.BaseMapper;

/**
 * 
 * @ClassName: AdminUserRoleExpandMapper
 * @Description: 用户角色表
 * @author xujianwei
 * @date 2016年7月4日 上午11:14:17
 *
 */
public interface AdminUserRoleExpandMapper extends BaseMapper {
	/**
	 * 
	 * @Title: queryRoleIdsByAdminId
	 * @Description: 根据adminId查询已绑定角色Id
	 * @param adminId
	 * @return
	 * 
	 * @throws
	 */
	List<Integer> queryRoleIdsByAdminId(@Param("adminId") Integer adminId);

	/**
	 * 
	 * @Title: deleteByAdminId
	 * @Description:根据adminId进行删除
	 * @param adminId
	 * 
	 * @throws
	 */
	void deleteByAdminId(@Param("adminId") Integer adminId);
}
