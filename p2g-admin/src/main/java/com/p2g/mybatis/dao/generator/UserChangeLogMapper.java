package com.p2g.mybatis.dao.generator;

import com.p2g.mybatis.model.generator.UserChangeLog;
import java.util.List;

public interface UserChangeLogMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_change_log
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long userChangeLogId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_change_log
     *
     * @mbggenerated
     */
    int insert(UserChangeLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_change_log
     *
     * @mbggenerated
     */
    UserChangeLog selectByPrimaryKey(Long userChangeLogId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_change_log
     *
     * @mbggenerated
     */
    List<UserChangeLog> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_change_log
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(UserChangeLog record);
}