package com.p2g.mybatis.dao.sys;

import com.p2g.core.base.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * Created on 2016-06-23 11:09.
 *
 * @author FanShukui
 */
public interface AdminPermissionExpandMapper extends BaseMapper {
    Integer getPermissionByAdminId(@Param("adminId") Integer adminId, @Param("url") String url);
    Integer getPermission(@Param("adminId") Integer adminId, @Param("permissionId") Integer permissionId);
}
