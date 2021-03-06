package com.p2g.mybatis.dao.generator;

import com.p2g.mybatis.model.generator.AdminRolePermission;
import java.util.List;

public interface AdminRolePermissionMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_role_permission
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer rolePermissionId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_role_permission
     *
     * @mbggenerated
     */
    int insert(AdminRolePermission record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_role_permission
     *
     * @mbggenerated
     */
    AdminRolePermission selectByPrimaryKey(Integer rolePermissionId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_role_permission
     *
     * @mbggenerated
     */
    List<AdminRolePermission> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_role_permission
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(AdminRolePermission record);
}