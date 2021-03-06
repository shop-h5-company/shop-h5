package com.shop.mybatis.dao.generator;

import com.shop.mybatis.model.generator.AlipayRecord;
import com.shop.mybatis.model.generator.AlipayRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface AlipayRecordMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table alipayrecord
     *
     * @mbggenerated Fri May 18 15:06:38 CST 2018
     */
    int countByExample(AlipayRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table alipayrecord
     *
     * @mbggenerated Fri May 18 15:06:38 CST 2018
     */
    int deleteByExample(AlipayRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table alipayrecord
     *
     * @mbggenerated Fri May 18 15:06:38 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table alipayrecord
     *
     * @mbggenerated Fri May 18 15:06:38 CST 2018
     */
    int insert(AlipayRecord record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table alipayrecord
     *
     * @mbggenerated Fri May 18 15:06:38 CST 2018
     */
    int insertSelective(AlipayRecord record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table alipayrecord
     *
     * @mbggenerated Fri May 18 15:06:38 CST 2018
     */
    List<AlipayRecord> selectByExample(AlipayRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table alipayrecord
     *
     * @mbggenerated Fri May 18 15:06:38 CST 2018
     */
    AlipayRecord selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table alipayrecord
     *
     * @mbggenerated Fri May 18 15:06:38 CST 2018
     */
    int updateByExampleSelective(@Param("record") AlipayRecord record, @Param("example") AlipayRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table alipayrecord
     *
     * @mbggenerated Fri May 18 15:06:38 CST 2018
     */
    int updateByExample(@Param("record") AlipayRecord record, @Param("example") AlipayRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table alipayrecord
     *
     * @mbggenerated Fri May 18 15:06:38 CST 2018
     */
    int updateByPrimaryKeySelective(AlipayRecord record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table alipayrecord
     *
     * @mbggenerated Fri May 18 15:06:38 CST 2018
     */
    int updateByPrimaryKey(AlipayRecord record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table alipayrecord
     *
     * @mbggenerated Fri May 18 15:06:38 CST 2018
     */
    List<AlipayRecord> selectByExample(AlipayRecordExample example, RowBounds rowBounds);
}