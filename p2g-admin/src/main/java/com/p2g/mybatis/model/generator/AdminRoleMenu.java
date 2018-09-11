package com.p2g.mybatis.model.generator;

import java.io.Serializable;
import java.util.Date;

public class AdminRoleMenu implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin_role_menu.admin_role_menu_id
     *
     * @mbggenerated
     */
    private Integer adminRoleMenuId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin_role_menu.role_id
     *
     * @mbggenerated
     */
    private Integer roleId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin_role_menu.menu_id
     *
     * @mbggenerated
     */
    private Integer menuId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin_role_menu.create_time
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table admin_role_menu
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column admin_role_menu.admin_role_menu_id
     *
     * @return the value of admin_role_menu.admin_role_menu_id
     *
     * @mbggenerated
     */
    public Integer getAdminRoleMenuId() {
        return adminRoleMenuId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column admin_role_menu.admin_role_menu_id
     *
     * @param adminRoleMenuId the value for admin_role_menu.admin_role_menu_id
     *
     * @mbggenerated
     */
    public void setAdminRoleMenuId(Integer adminRoleMenuId) {
        this.adminRoleMenuId = adminRoleMenuId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column admin_role_menu.role_id
     *
     * @return the value of admin_role_menu.role_id
     *
     * @mbggenerated
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column admin_role_menu.role_id
     *
     * @param roleId the value for admin_role_menu.role_id
     *
     * @mbggenerated
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column admin_role_menu.menu_id
     *
     * @return the value of admin_role_menu.menu_id
     *
     * @mbggenerated
     */
    public Integer getMenuId() {
        return menuId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column admin_role_menu.menu_id
     *
     * @param menuId the value for admin_role_menu.menu_id
     *
     * @mbggenerated
     */
    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column admin_role_menu.create_time
     *
     * @return the value of admin_role_menu.create_time
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column admin_role_menu.create_time
     *
     * @param createTime the value for admin_role_menu.create_time
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_role_menu
     *
     * @mbggenerated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", adminRoleMenuId=").append(adminRoleMenuId);
        sb.append(", roleId=").append(roleId);
        sb.append(", menuId=").append(menuId);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_role_menu
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
        AdminRoleMenu other = (AdminRoleMenu) that;
        return (this.getAdminRoleMenuId() == null ? other.getAdminRoleMenuId() == null : this.getAdminRoleMenuId().equals(other.getAdminRoleMenuId()))
            && (this.getRoleId() == null ? other.getRoleId() == null : this.getRoleId().equals(other.getRoleId()))
            && (this.getMenuId() == null ? other.getMenuId() == null : this.getMenuId().equals(other.getMenuId()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_role_menu
     *
     * @mbggenerated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getAdminRoleMenuId() == null) ? 0 : getAdminRoleMenuId().hashCode());
        result = prime * result + ((getRoleId() == null) ? 0 : getRoleId().hashCode());
        result = prime * result + ((getMenuId() == null) ? 0 : getMenuId().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        return result;
    }
}