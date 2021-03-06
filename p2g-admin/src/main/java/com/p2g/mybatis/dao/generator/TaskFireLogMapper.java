package com.p2g.mybatis.dao.generator;

import com.p2g.mybatis.model.generator.TaskFireLog;
import java.util.List;

public interface TaskFireLogMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task_fire_log
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long fireLogId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task_fire_log
     *
     * @mbggenerated
     */
    int insert(TaskFireLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task_fire_log
     *
     * @mbggenerated
     */
    TaskFireLog selectByPrimaryKey(Long fireLogId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task_fire_log
     *
     * @mbggenerated
     */
    List<TaskFireLog> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task_fire_log
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(TaskFireLog record);
}