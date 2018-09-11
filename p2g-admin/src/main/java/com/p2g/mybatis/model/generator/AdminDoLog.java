package com.p2g.mybatis.model.generator;

import java.io.Serializable;
import java.util.Date;

public class AdminDoLog implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin_do_log.admin_do_log_id
     *
     * @mbggenerated
     */
    private Long adminDoLogId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin_do_log.admin_id
     *
     * @mbggenerated
     */
    private Integer adminId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin_do_log.admin_name
     *
     * @mbggenerated
     */
    private String adminName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin_do_log.admin_do_kind_code
     *
     * @mbggenerated
     */
    private String adminDoKindCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin_do_log.old_info
     *
     * @mbggenerated
     */
    private String oldInfo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin_do_log.new_info
     *
     * @mbggenerated
     */
    private String newInfo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin_do_log.do_time
     *
     * @mbggenerated
     */
    private Date doTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table admin_do_log
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column admin_do_log.admin_do_log_id
     *
     * @return the value of admin_do_log.admin_do_log_id
     *
     * @mbggenerated
     */
    public Long getAdminDoLogId() {
        return adminDoLogId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column admin_do_log.admin_do_log_id
     *
     * @param adminDoLogId the value for admin_do_log.admin_do_log_id
     *
     * @mbggenerated
     */
    public void setAdminDoLogId(Long adminDoLogId) {
        this.adminDoLogId = adminDoLogId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column admin_do_log.admin_id
     *
     * @return the value of admin_do_log.admin_id
     *
     * @mbggenerated
     */
    public Integer getAdminId() {
        return adminId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column admin_do_log.admin_id
     *
     * @param adminId the value for admin_do_log.admin_id
     *
     * @mbggenerated
     */
    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column admin_do_log.admin_name
     *
     * @return the value of admin_do_log.admin_name
     *
     * @mbggenerated
     */
    public String getAdminName() {
        return adminName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column admin_do_log.admin_name
     *
     * @param adminName the value for admin_do_log.admin_name
     *
     * @mbggenerated
     */
    public void setAdminName(String adminName) {
        this.adminName = adminName == null ? null : adminName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column admin_do_log.admin_do_kind_code
     *
     * @return the value of admin_do_log.admin_do_kind_code
     *
     * @mbggenerated
     */
    public String getAdminDoKindCode() {
        return adminDoKindCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column admin_do_log.admin_do_kind_code
     *
     * @param adminDoKindCode the value for admin_do_log.admin_do_kind_code
     *
     * @mbggenerated
     */
    public void setAdminDoKindCode(String adminDoKindCode) {
        this.adminDoKindCode = adminDoKindCode == null ? null : adminDoKindCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column admin_do_log.old_info
     *
     * @return the value of admin_do_log.old_info
     *
     * @mbggenerated
     */
    public String getOldInfo() {
        return oldInfo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column admin_do_log.old_info
     *
     * @param oldInfo the value for admin_do_log.old_info
     *
     * @mbggenerated
     */
    public void setOldInfo(String oldInfo) {
        this.oldInfo = oldInfo == null ? null : oldInfo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column admin_do_log.new_info
     *
     * @return the value of admin_do_log.new_info
     *
     * @mbggenerated
     */
    public String getNewInfo() {
        return newInfo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column admin_do_log.new_info
     *
     * @param newInfo the value for admin_do_log.new_info
     *
     * @mbggenerated
     */
    public void setNewInfo(String newInfo) {
        this.newInfo = newInfo == null ? null : newInfo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column admin_do_log.do_time
     *
     * @return the value of admin_do_log.do_time
     *
     * @mbggenerated
     */
    public Date getDoTime() {
        return doTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column admin_do_log.do_time
     *
     * @param doTime the value for admin_do_log.do_time
     *
     * @mbggenerated
     */
    public void setDoTime(Date doTime) {
        this.doTime = doTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_do_log
     *
     * @mbggenerated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", adminDoLogId=").append(adminDoLogId);
        sb.append(", adminId=").append(adminId);
        sb.append(", adminName=").append(adminName);
        sb.append(", adminDoKindCode=").append(adminDoKindCode);
        sb.append(", oldInfo=").append(oldInfo);
        sb.append(", newInfo=").append(newInfo);
        sb.append(", doTime=").append(doTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_do_log
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
        AdminDoLog other = (AdminDoLog) that;
        return (this.getAdminDoLogId() == null ? other.getAdminDoLogId() == null : this.getAdminDoLogId().equals(other.getAdminDoLogId()))
            && (this.getAdminId() == null ? other.getAdminId() == null : this.getAdminId().equals(other.getAdminId()))
            && (this.getAdminName() == null ? other.getAdminName() == null : this.getAdminName().equals(other.getAdminName()))
            && (this.getAdminDoKindCode() == null ? other.getAdminDoKindCode() == null : this.getAdminDoKindCode().equals(other.getAdminDoKindCode()))
            && (this.getOldInfo() == null ? other.getOldInfo() == null : this.getOldInfo().equals(other.getOldInfo()))
            && (this.getNewInfo() == null ? other.getNewInfo() == null : this.getNewInfo().equals(other.getNewInfo()))
            && (this.getDoTime() == null ? other.getDoTime() == null : this.getDoTime().equals(other.getDoTime()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_do_log
     *
     * @mbggenerated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getAdminDoLogId() == null) ? 0 : getAdminDoLogId().hashCode());
        result = prime * result + ((getAdminId() == null) ? 0 : getAdminId().hashCode());
        result = prime * result + ((getAdminName() == null) ? 0 : getAdminName().hashCode());
        result = prime * result + ((getAdminDoKindCode() == null) ? 0 : getAdminDoKindCode().hashCode());
        result = prime * result + ((getOldInfo() == null) ? 0 : getOldInfo().hashCode());
        result = prime * result + ((getNewInfo() == null) ? 0 : getNewInfo().hashCode());
        result = prime * result + ((getDoTime() == null) ? 0 : getDoTime().hashCode());
        return result;
    }
}