package com.p2g.mybatis.dao.generator;

import com.p2g.mybatis.model.generator.AdminMenu;
import java.util.List;

public interface AdminMenuMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_menu
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer adminMenuId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_menu
     *
     * @mbggenerated
     */
    int insert(AdminMenu record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_menu
     *
     * @mbggenerated
     */
    AdminMenu selectByPrimaryKey(Integer adminMenuId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_menu
     *
     * @mbggenerated
     */
    List<AdminMenu> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_menu
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(AdminMenu record);
}