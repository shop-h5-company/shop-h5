package com.p2g.mybatis.dao.generator;

import com.p2g.mybatis.model.generator.LianBank;
import java.util.List;

public interface LianBankMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lian_bank
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String lianBankCode);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lian_bank
     *
     * @mbggenerated
     */
    int insert(LianBank record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lian_bank
     *
     * @mbggenerated
     */
    LianBank selectByPrimaryKey(String lianBankCode);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lian_bank
     *
     * @mbggenerated
     */
    List<LianBank> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lian_bank
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(LianBank record);
}