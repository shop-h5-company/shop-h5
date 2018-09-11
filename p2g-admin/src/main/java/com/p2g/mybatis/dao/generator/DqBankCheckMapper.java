package com.p2g.mybatis.dao.generator;

import com.p2g.mybatis.model.generator.DqBankCheck;
import java.util.List;

public interface DqBankCheckMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dq_bank_check
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long depositBankCheckId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dq_bank_check
     *
     * @mbggenerated
     */
    int insert(DqBankCheck record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dq_bank_check
     *
     * @mbggenerated
     */
    DqBankCheck selectByPrimaryKey(Long depositBankCheckId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dq_bank_check
     *
     * @mbggenerated
     */
    List<DqBankCheck> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dq_bank_check
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(DqBankCheck record);
}