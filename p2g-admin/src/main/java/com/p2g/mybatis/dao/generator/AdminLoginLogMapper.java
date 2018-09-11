package com.p2g.mybatis.dao.generator;

import com.p2g.mybatis.model.generator.AdminLoginLog;
import java.util.List;

public interface AdminLoginLogMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_login_log
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer adminLoginLogId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_login_log
     *
     * @mbggenerated
     */
    int insert(AdminLoginLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_login_log
     *
     * @mbggenerated
     */
    AdminLoginLog selectByPrimaryKey(Integer adminLoginLogId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_login_log
     *
     * @mbggenerated
     */
    List<AdminLoginLog> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_login_log
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(AdminLoginLog record);
}