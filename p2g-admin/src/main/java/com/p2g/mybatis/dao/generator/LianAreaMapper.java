package com.p2g.mybatis.dao.generator;

import com.p2g.mybatis.model.generator.LianArea;
import java.util.List;

public interface LianAreaMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lian_area
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String lianAreaCode);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lian_area
     *
     * @mbggenerated
     */
    int insert(LianArea record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lian_area
     *
     * @mbggenerated
     */
    LianArea selectByPrimaryKey(String lianAreaCode);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lian_area
     *
     * @mbggenerated
     */
    List<LianArea> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lian_area
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(LianArea record);
}