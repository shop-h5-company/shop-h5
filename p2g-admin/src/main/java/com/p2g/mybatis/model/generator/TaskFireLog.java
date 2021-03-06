package com.p2g.mybatis.model.generator;

import java.io.Serializable;
import java.util.Date;

public class TaskFireLog implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task_fire_log.fire_log_id
     *
     * @mbggenerated
     */
    private Long fireLogId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task_fire_log.group_name
     *
     * @mbggenerated
     */
    private String groupName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task_fire_log.task_name
     *
     * @mbggenerated
     */
    private String taskName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task_fire_log.start_time
     *
     * @mbggenerated
     */
    private Date startTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task_fire_log.end_time
     *
     * @mbggenerated
     */
    private Date endTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task_fire_log.status
     *
     * @mbggenerated
     */
    private String status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task_fire_log.fire_info
     *
     * @mbggenerated
     */
    private String fireInfo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table task_fire_log
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task_fire_log.fire_log_id
     *
     * @return the value of task_fire_log.fire_log_id
     *
     * @mbggenerated
     */
    public Long getFireLogId() {
        return fireLogId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column task_fire_log.fire_log_id
     *
     * @param fireLogId the value for task_fire_log.fire_log_id
     *
     * @mbggenerated
     */
    public void setFireLogId(Long fireLogId) {
        this.fireLogId = fireLogId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task_fire_log.group_name
     *
     * @return the value of task_fire_log.group_name
     *
     * @mbggenerated
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column task_fire_log.group_name
     *
     * @param groupName the value for task_fire_log.group_name
     *
     * @mbggenerated
     */
    public void setGroupName(String groupName) {
        this.groupName = groupName == null ? null : groupName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task_fire_log.task_name
     *
     * @return the value of task_fire_log.task_name
     *
     * @mbggenerated
     */
    public String getTaskName() {
        return taskName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column task_fire_log.task_name
     *
     * @param taskName the value for task_fire_log.task_name
     *
     * @mbggenerated
     */
    public void setTaskName(String taskName) {
        this.taskName = taskName == null ? null : taskName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task_fire_log.start_time
     *
     * @return the value of task_fire_log.start_time
     *
     * @mbggenerated
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column task_fire_log.start_time
     *
     * @param startTime the value for task_fire_log.start_time
     *
     * @mbggenerated
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task_fire_log.end_time
     *
     * @return the value of task_fire_log.end_time
     *
     * @mbggenerated
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column task_fire_log.end_time
     *
     * @param endTime the value for task_fire_log.end_time
     *
     * @mbggenerated
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task_fire_log.status
     *
     * @return the value of task_fire_log.status
     *
     * @mbggenerated
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column task_fire_log.status
     *
     * @param status the value for task_fire_log.status
     *
     * @mbggenerated
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task_fire_log.fire_info
     *
     * @return the value of task_fire_log.fire_info
     *
     * @mbggenerated
     */
    public String getFireInfo() {
        return fireInfo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column task_fire_log.fire_info
     *
     * @param fireInfo the value for task_fire_log.fire_info
     *
     * @mbggenerated
     */
    public void setFireInfo(String fireInfo) {
        this.fireInfo = fireInfo == null ? null : fireInfo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task_fire_log
     *
     * @mbggenerated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", fireLogId=").append(fireLogId);
        sb.append(", groupName=").append(groupName);
        sb.append(", taskName=").append(taskName);
        sb.append(", startTime=").append(startTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", status=").append(status);
        sb.append(", fireInfo=").append(fireInfo);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task_fire_log
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
        TaskFireLog other = (TaskFireLog) that;
        return (this.getFireLogId() == null ? other.getFireLogId() == null : this.getFireLogId().equals(other.getFireLogId()))
            && (this.getGroupName() == null ? other.getGroupName() == null : this.getGroupName().equals(other.getGroupName()))
            && (this.getTaskName() == null ? other.getTaskName() == null : this.getTaskName().equals(other.getTaskName()))
            && (this.getStartTime() == null ? other.getStartTime() == null : this.getStartTime().equals(other.getStartTime()))
            && (this.getEndTime() == null ? other.getEndTime() == null : this.getEndTime().equals(other.getEndTime()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getFireInfo() == null ? other.getFireInfo() == null : this.getFireInfo().equals(other.getFireInfo()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task_fire_log
     *
     * @mbggenerated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getFireLogId() == null) ? 0 : getFireLogId().hashCode());
        result = prime * result + ((getGroupName() == null) ? 0 : getGroupName().hashCode());
        result = prime * result + ((getTaskName() == null) ? 0 : getTaskName().hashCode());
        result = prime * result + ((getStartTime() == null) ? 0 : getStartTime().hashCode());
        result = prime * result + ((getEndTime() == null) ? 0 : getEndTime().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getFireInfo() == null) ? 0 : getFireInfo().hashCode());
        return result;
    }
}