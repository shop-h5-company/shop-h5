package com.p2g.mybatis.model.generator;

import java.io.Serializable;
import java.util.Date;

public class AdminUserRole implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin_user_role.user_role_id
     *
     * @mbggenerated
     */
    private Integer userRoleId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin_user_role.role_id
     *
     * @mbggenerated
     */
    private Integer roleId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin_user_role.admin_id
     *
     * @mbggenerated
     */
    private Integer adminId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin_user_role.operate_id
     *
     * @mbggenerated
     */
    private Integer operateId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin_user_role.operate_time
     *
     * @mbggenerated
     */
    private Date operateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table admin_user_role
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column admin_user_role.user_role_id
     *
     * @return the value of admin_user_role.user_role_id
     *
     * @mbggenerated
     */
    public Integer getUserRoleId() {
        return userRoleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column admin_user_role.user_role_id
     *
     * @param userRoleId the value for admin_user_role.user_role_id
     *
     * @mbggenerated
     */
    public void setUserRoleId(Integer userRoleId) {
        this.userRoleId = userRoleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column admin_user_role.role_id
     *
     * @return the value of admin_user_role.role_id
     *
     * @mbggenerated
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column admin_user_role.role_id
     *
     * @param roleId the value for admin_user_role.role_id
     *
     * @mbggenerated
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column admin_user_role.admin_id
     *
     * @return the value of admin_user_role.admin_id
     *
     * @mbggenerated
     */
    public Integer getAdminId() {
        return adminId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column admin_user_role.admin_id
     *
     * @param adminId the value for admin_user_role.admin_id
     *
     * @mbggenerated
     */
    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column admin_user_role.operate_id
     *
     * @return the value of admin_user_role.operate_id
     *
     * @mbggenerated
     */
    public Integer getOperateId() {
        return operateId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column admin_user_role.operate_id
     *
     * @param operateId the value for admin_user_role.operate_id
     *
     * @mbggenerated
     */
    public void setOperateId(Integer operateId) {
        this.operateId = operateId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column admin_user_role.operate_time
     *
     * @return the value of admin_user_role.operate_time
     *
     * @mbggenerated
     */
    public Date getOperateTime() {
        return operateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column admin_user_role.operate_time
     *
     * @param operateTime the value for admin_user_role.operate_time
     *
     * @mbggenerated
     */
    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_user_role
     *
     * @mbggenerated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userRoleId=").append(userRoleId);
        sb.append(", roleId=").append(roleId);
        sb.append(", adminId=").append(adminId);
        sb.append(", operateId=").append(operateId);
        sb.append(", operateTime=").append(operateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_user_role
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
        AdminUserRole other = (AdminUserRole) that;
        return (this.getUserRoleId() == null ? other.getUserRoleId() == null : this.getUserRoleId().equals(other.getUserRoleId()))
            && (this.getRoleId() == null ? other.getRoleId() == null : this.getRoleId().equals(other.getRoleId()))
            && (this.getAdminId() == null ? other.getAdminId() == null : this.getAdminId().equals(other.getAdminId()))
            && (this.getOperateId() == null ? other.getOperateId() == null : this.getOperateId().equals(other.getOperateId()))
            && (this.getOperateTime() == null ? other.getOperateTime() == null : this.getOperateTime().equals(other.getOperateTime()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_user_role
     *
     * @mbggenerated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUserRoleId() == null) ? 0 : getUserRoleId().hashCode());
        result = prime * result + ((getRoleId() == null) ? 0 : getRoleId().hashCode());
        result = prime * result + ((getAdminId() == null) ? 0 : getAdminId().hashCode());
        result = prime * result + ((getOperateId() == null) ? 0 : getOperateId().hashCode());
        result = prime * result + ((getOperateTime() == null) ? 0 : getOperateTime().hashCode());
        return result;
    }
}