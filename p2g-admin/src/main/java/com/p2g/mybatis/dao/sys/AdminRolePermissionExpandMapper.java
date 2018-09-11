package com.p2g.mybatis.dao.sys;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.p2g.core.base.BaseMapper;

public interface AdminRolePermissionExpandMapper extends BaseMapper {
	/**
	 * 
	 * @Title: queryPermissionIdsByRoleId 
	 * @Description: 根据roleId查询已绑定权限
	 * @param roleId
	 * @return
	 * 
	 * @throws
	 */
	List<Integer> queryPermissionIdsByRoleId(@Param("roleId") Integer roleId);

	/**
	 * 
	 * @Title: deleteByRoleId 
	 * @Description: 根据roleId批量删除数据
	 * @param roleId
	 * 
	 * @throws
	 */
	void deleteByRoleId(@Param("roleId") Integer roleId);
}
