package com.p2g.mybatis.dao.generator;

import com.p2g.mybatis.model.generator.TaskScheduler;
import java.util.List;

public interface TaskSchedulerMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task_scheduler
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer schedulerId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task_scheduler
     *
     * @mbggenerated
     */
    int insert(TaskScheduler record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task_scheduler
     *
     * @mbggenerated
     */
    TaskScheduler selectByPrimaryKey(Integer schedulerId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task_scheduler
     *
     * @mbggenerated
     */
    List<TaskScheduler> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task_scheduler
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(TaskScheduler record);
}