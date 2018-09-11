package com.p2g.mybatis.dao.sys;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.p2g.core.base.BaseMapper;

/**
 * 
 * @ClassName: AdminUserPermissionExpandMapper
 * @Description: 用户权限表
 * @author xujianwei
 * @date 2016年7月5日 上午9:30:01
 *
 */
public interface AdminUserPermissionExpandMapper extends BaseMapper {
	/**
	 * 
	 * @Title: queryPermissionIdsByAdminId
	 * @Description: 根据adminId查询用户已绑定权限
	 * @param adminId
	 * @return
	 * 
	 * @throws
	 */
	List<Integer> queryPermissionIdsByAdminId(@Param("adminId") Integer adminId);

	/**
	 * 
	 * @Title: deleteByAdminId
	 * @Description: 根据adminId进行删除
	 * @param adminId
	 * 
	 * @throws
	 */
	void deleteByAdminId(@Param("adminId") Integer adminId);
}
