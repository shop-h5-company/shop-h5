package com.p2g.mybatis.dao.generator;

import com.p2g.mybatis.model.generator.CmHomeTuijian;
import java.util.List;

public interface CmHomeTuijianMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cm_home_tuijian
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long cmHomeTuijianId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cm_home_tuijian
     *
     * @mbggenerated
     */
    int insert(CmHomeTuijian record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cm_home_tuijian
     *
     * @mbggenerated
     */
    CmHomeTuijian selectByPrimaryKey(Long cmHomeTuijianId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cm_home_tuijian
     *
     * @mbggenerated
     */
    List<CmHomeTuijian> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cm_home_tuijian
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(CmHomeTuijian record);
}