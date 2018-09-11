package com.p2g.mybatis.model.generator;

import java.io.Serializable;
import java.util.Date;

public class CmSmsLog implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cm_sms_log.cm_sms_log_id
     *
     * @mbggenerated
     */
    private Long cmSmsLogId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cm_sms_log.mobile
     *
     * @mbggenerated
     */
    private String mobile;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cm_sms_log.content
     *
     * @mbggenerated
     */
    private String content;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cm_sms_log.create_time
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cm_sms_log.sp_code
     *
     * @mbggenerated
     */
    private String spCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table cm_sms_log
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_sms_log.cm_sms_log_id
     *
     * @return the value of cm_sms_log.cm_sms_log_id
     *
     * @mbggenerated
     */
    public Long getCmSmsLogId() {
        return cmSmsLogId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_sms_log.cm_sms_log_id
     *
     * @param cmSmsLogId the value for cm_sms_log.cm_sms_log_id
     *
     * @mbggenerated
     */
    public void setCmSmsLogId(Long cmSmsLogId) {
        this.cmSmsLogId = cmSmsLogId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_sms_log.mobile
     *
     * @return the value of cm_sms_log.mobile
     *
     * @mbggenerated
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_sms_log.mobile
     *
     * @param mobile the value for cm_sms_log.mobile
     *
     * @mbggenerated
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_sms_log.content
     *
     * @return the value of cm_sms_log.content
     *
     * @mbggenerated
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_sms_log.content
     *
     * @param content the value for cm_sms_log.content
     *
     * @mbggenerated
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_sms_log.create_time
     *
     * @return the value of cm_sms_log.create_time
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_sms_log.create_time
     *
     * @param createTime the value for cm_sms_log.create_time
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_sms_log.sp_code
     *
     * @return the value of cm_sms_log.sp_code
     *
     * @mbggenerated
     */
    public String getSpCode() {
        return spCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_sms_log.sp_code
     *
     * @param spCode the value for cm_sms_log.sp_code
     *
     * @mbggenerated
     */
    public void setSpCode(String spCode) {
        this.spCode = spCode == null ? null : spCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cm_sms_log
     *
     * @mbggenerated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", cmSmsLogId=").append(cmSmsLogId);
        sb.append(", mobile=").append(mobile);
        sb.append(", content=").append(content);
        sb.append(", createTime=").append(createTime);
        sb.append(", spCode=").append(spCode);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cm_sms_log
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
        CmSmsLog other = (CmSmsLog) that;
        return (this.getCmSmsLogId() == null ? other.getCmSmsLogId() == null : this.getCmSmsLogId().equals(other.getCmSmsLogId()))
            && (this.getMobile() == null ? other.getMobile() == null : this.getMobile().equals(other.getMobile()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getSpCode() == null ? other.getSpCode() == null : this.getSpCode().equals(other.getSpCode()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cm_sms_log
     *
     * @mbggenerated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCmSmsLogId() == null) ? 0 : getCmSmsLogId().hashCode());
        result = prime * result + ((getMobile() == null) ? 0 : getMobile().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getSpCode() == null) ? 0 : getSpCode().hashCode());
        return result;
    }
}