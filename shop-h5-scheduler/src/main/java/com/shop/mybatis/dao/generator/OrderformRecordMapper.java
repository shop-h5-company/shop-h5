package com.shop.mybatis.dao.generator;

import com.shop.mybatis.model.generator.OrderformRecord;
import java.util.List;

public interface OrderformRecordMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orderform_record
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orderform_record
     *
     * @mbggenerated
     */
    int insert(OrderformRecord record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orderform_record
     *
     * @mbggenerated
     */
    OrderformRecord selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orderform_record
     *
     * @mbggenerated
     */
    List<OrderformRecord> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orderform_record
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(OrderformRecord record);
}