package com.p2g.mybatis.dao.generator;

import com.p2g.mybatis.model.generator.HqProfitLog;
import java.util.List;

public interface HqProfitLogMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hq_profit_log
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long hqProfitLogId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hq_profit_log
     *
     * @mbggenerated
     */
    int insert(HqProfitLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hq_profit_log
     *
     * @mbggenerated
     */
    HqProfitLog selectByPrimaryKey(Long hqProfitLogId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hq_profit_log
     *
     * @mbggenerated
     */
    List<HqProfitLog> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hq_profit_log
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(HqProfitLog record);
}