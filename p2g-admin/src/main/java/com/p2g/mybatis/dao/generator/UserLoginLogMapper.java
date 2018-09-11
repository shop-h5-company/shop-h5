package com.p2g.mybatis.dao.generator;

import com.p2g.mybatis.model.generator.UserLoginLog;
import java.util.List;

public interface UserLoginLogMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_login_log
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long userLoginLogId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_login_log
     *
     * @mbggenerated
     */
    int insert(UserLoginLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_login_log
     *
     * @mbggenerated
     */
    UserLoginLog selectByPrimaryKey(Long userLoginLogId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_login_log
     *
     * @mbggenerated
     */
    List<UserLoginLog> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_login_log
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(UserLoginLog record);
}