package com.p2g.mybatis.dao.generator;

import com.p2g.mybatis.model.generator.AdminPermission;
import java.util.List;

public interface AdminPermissionMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_permission
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer permissionId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_permission
     *
     * @mbggenerated
     */
    int insert(AdminPermission record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_permission
     *
     * @mbggenerated
     */
    AdminPermission selectByPrimaryKey(Integer permissionId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_permission
     *
     * @mbggenerated
     */
    List<AdminPermission> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_permission
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(AdminPermission record);
}