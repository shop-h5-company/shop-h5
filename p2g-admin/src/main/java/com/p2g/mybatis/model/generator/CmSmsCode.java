package com.p2g.mybatis.model.generator;

import java.io.Serializable;
import java.util.Date;

public class CmSmsCode implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cm_sms_code.cm_sms_code_id
     *
     * @mbggenerated
     */
    private Long cmSmsCodeId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cm_sms_code.trans_no
     *
     * @mbggenerated
     */
    private String transNo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cm_sms_code.mobile
     *
     * @mbggenerated
     */
    private String mobile;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cm_sms_code.verify_code
     *
     * @mbggenerated
     */
    private String verifyCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cm_sms_code.create_time
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cm_sms_code.model_code
     *
     * @mbggenerated
     */
    private String modelCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table cm_sms_code
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_sms_code.cm_sms_code_id
     *
     * @return the value of cm_sms_code.cm_sms_code_id
     *
     * @mbggenerated
     */
    public Long getCmSmsCodeId() {
        return cmSmsCodeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_sms_code.cm_sms_code_id
     *
     * @param cmSmsCodeId the value for cm_sms_code.cm_sms_code_id
     *
     * @mbggenerated
     */
    public void setCmSmsCodeId(Long cmSmsCodeId) {
        this.cmSmsCodeId = cmSmsCodeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_sms_code.trans_no
     *
     * @return the value of cm_sms_code.trans_no
     *
     * @mbggenerated
     */
    public String getTransNo() {
        return transNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_sms_code.trans_no
     *
     * @param transNo the value for cm_sms_code.trans_no
     *
     * @mbggenerated
     */
    public void setTransNo(String transNo) {
        this.transNo = transNo == null ? null : transNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_sms_code.mobile
     *
     * @return the value of cm_sms_code.mobile
     *
     * @mbggenerated
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_sms_code.mobile
     *
     * @param mobile the value for cm_sms_code.mobile
     *
     * @mbggenerated
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_sms_code.verify_code
     *
     * @return the value of cm_sms_code.verify_code
     *
     * @mbggenerated
     */
    public String getVerifyCode() {
        return verifyCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_sms_code.verify_code
     *
     * @param verifyCode the value for cm_sms_code.verify_code
     *
     * @mbggenerated
     */
    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode == null ? null : verifyCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_sms_code.create_time
     *
     * @return the value of cm_sms_code.create_time
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_sms_code.create_time
     *
     * @param createTime the value for cm_sms_code.create_time
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_sms_code.model_code
     *
     * @return the value of cm_sms_code.model_code
     *
     * @mbggenerated
     */
    public String getModelCode() {
        return modelCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_sms_code.model_code
     *
     * @param modelCode the value for cm_sms_code.model_code
     *
     * @mbggenerated
     */
    public void setModelCode(String modelCode) {
        this.modelCode = modelCode == null ? null : modelCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cm_sms_code
     *
     * @mbggenerated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", cmSmsCodeId=").append(cmSmsCodeId);
        sb.append(", transNo=").append(transNo);
        sb.append(", mobile=").append(mobile);
        sb.append(", verifyCode=").append(verifyCode);
        sb.append(", createTime=").append(createTime);
        sb.append(", modelCode=").append(modelCode);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cm_sms_code
     *
     * @mbggenerated
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        CmSmsCode other = (CmSmsCode) that;
        return (this.getCmSmsCodeId() == null ? other.getCmSmsCodeId() == null : this.getCmSmsCodeId().equals(other.getCmSmsCodeId()))
            && (this.getTransNo() == null ? other.getTransNo() == null : this.getTransNo().equals(other.getTransNo()))
            && (this.getMobile() == null ? other.getMobile() == null : this.getMobile().equals(other.getMobile()))
            && (this.getVerifyCode() == null ? other.getVerifyCode() == null : this.getVerifyCode().equals(other.getVerifyCode()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getModelCode() == null ? other.getModelCode() == null : this.getModelCode().equals(other.getModelCode()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cm_sms_code
     *
     * @mbggenerated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCmSmsCodeId() == null) ? 0 : getCmSmsCodeId().hashCode());
        result = prime * result + ((getTransNo() == null) ? 0 : getTransNo().hashCode());
        result = prime * result + ((getMobile() == null) ? 0 : getMobile().hashCode());
        result = prime * result + ((getVerifyCode() == null) ? 0 : getVerifyCode().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getModelCode() == null) ? 0 : getModelCode().hashCode());
        return result;
    }
}