package com.p2g.mybatis.model.generator;

import java.io.Serializable;
import java.util.Date;

public class AdminUserMenu implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin_user_menu.admin_user_menu_id
     *
     * @mbggenerated
     */
    private Integer adminUserMenuId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin_user_menu.admin_id
     *
     * @mbggenerated
     */
    private Integer adminId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin_user_menu.menu_id
     *
     * @mbggenerated
     */
    private Integer menuId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin_user_menu.create_time
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table admin_user_menu
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column admin_user_menu.admin_user_menu_id
     *
     * @return the value of admin_user_menu.admin_user_menu_id
     *
     * @mbggenerated
     */
    public Integer getAdminUserMenuId() {
        return adminUserMenuId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column admin_user_menu.admin_user_menu_id
     *
     * @param adminUserMenuId the value for admin_user_menu.admin_user_menu_id
     *
     * @mbggenerated
     */
    public void setAdminUserMenuId(Integer adminUserMenuId) {
        this.adminUserMenuId = adminUserMenuId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column admin_user_menu.admin_id
     *
     * @return the value of admin_user_menu.admin_id
     *
     * @mbggenerated
     */
    public Integer getAdminId() {
        return adminId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column admin_user_menu.admin_id
     *
     * @param adminId the value for admin_user_menu.admin_id
     *
     * @mbggenerated
     */
    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column admin_user_menu.menu_id
     *
     * @return the value of admin_user_menu.menu_id
     *
     * @mbggenerated
     */
    public Integer getMenuId() {
        return menuId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column admin_user_menu.menu_id
     *
     * @param menuId the value for admin_user_menu.menu_id
     *
     * @mbggenerated
     */
    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column admin_user_menu.create_time
     *
     * @return the value of admin_user_menu.create_time
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column admin_user_menu.create_time
     *
     * @param createTime the value for admin_user_menu.create_time
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_user_menu
     *
     * @mbggenerated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", adminUserMenuId=").append(adminUserMenuId);
        sb.append(", adminId=").append(adminId);
        sb.append(", menuId=").append(menuId);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_user_menu
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
        AdminUserMenu other = (AdminUserMenu) that;
        return (this.getAdminUserMenuId() == null ? other.getAdminUserMenuId() == null : this.getAdminUserMenuId().equals(other.getAdminUserMenuId()))
            && (this.getAdminId() == null ? other.getAdminId() == null : this.getAdminId().equals(other.getAdminId()))
            && (this.getMenuId() == null ? other.getMenuId() == null : this.getMenuId().equals(other.getMenuId()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_user_menu
     *
     * @mbggenerated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getAdminUserMenuId() == null) ? 0 : getAdminUserMenuId().hashCode());
        result = prime * result + ((getAdminId() == null) ? 0 : getAdminId().hashCode());
        result = prime * result + ((getMenuId() == null) ? 0 : getMenuId().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        return result;
    }
}