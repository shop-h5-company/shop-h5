package com.p2g.mybatis.model.generator;

import java.io.Serializable;
import java.util.Date;

public class CmConfig implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cm_config.cm_config_id
     *
     * @mbggenerated
     */
    private Integer cmConfigId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cm_config.config_code
     *
     * @mbggenerated
     */
    private String configCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cm_config.config_value
     *
     * @mbggenerated
     */
    private String configValue;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cm_config.config_remark
     *
     * @mbggenerated
     */
    private String configRemark;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cm_config.create_time
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cm_config.update_time
     *
     * @mbggenerated
     */
    private Date updateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table cm_config
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_config.cm_config_id
     *
     * @return the value of cm_config.cm_config_id
     *
     * @mbggenerated
     */
    public Integer getCmConfigId() {
        return cmConfigId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_config.cm_config_id
     *
     * @param cmConfigId the value for cm_config.cm_config_id
     *
     * @mbggenerated
     */
    public void setCmConfigId(Integer cmConfigId) {
        this.cmConfigId = cmConfigId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_config.config_code
     *
     * @return the value of cm_config.config_code
     *
     * @mbggenerated
     */
    public String getConfigCode() {
        return configCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_config.config_code
     *
     * @param configCode the value for cm_config.config_code
     *
     * @mbggenerated
     */
    public void setConfigCode(String configCode) {
        this.configCode = configCode == null ? null : configCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_config.config_value
     *
     * @return the value of cm_config.config_value
     *
     * @mbggenerated
     */
    public String getConfigValue() {
        return configValue;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_config.config_value
     *
     * @param configValue the value for cm_config.config_value
     *
     * @mbggenerated
     */
    public void setConfigValue(String configValue) {
        this.configValue = configValue == null ? null : configValue.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_config.config_remark
     *
     * @return the value of cm_config.config_remark
     *
     * @mbggenerated
     */
    public String getConfigRemark() {
        return configRemark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_config.config_remark
     *
     * @param configRemark the value for cm_config.config_remark
     *
     * @mbggenerated
     */
    public void setConfigRemark(String configRemark) {
        this.configRemark = configRemark == null ? null : configRemark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_config.create_time
     *
     * @return the value of cm_config.create_time
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_config.create_time
     *
     * @param createTime the value for cm_config.create_time
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_config.update_time
     *
     * @return the value of cm_config.update_time
     *
     * @mbggenerated
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_config.update_time
     *
     * @param updateTime the value for cm_config.update_time
     *
     * @mbggenerated
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cm_config
     *
     * @mbggenerated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", cmConfigId=").append(cmConfigId);
        sb.append(", configCode=").append(configCode);
        sb.append(", configValue=").append(configValue);
        sb.append(", configRemark=").append(configRemark);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cm_config
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
        CmConfig other = (CmConfig) that;
        return (this.getCmConfigId() == null ? other.getCmConfigId() == null : this.getCmConfigId().equals(other.getCmConfigId()))
            && (this.getConfigCode() == null ? other.getConfigCode() == null : this.getConfigCode().equals(other.getConfigCode()))
            && (this.getConfigValue() == null ? other.getConfigValue() == null : this.getConfigValue().equals(other.getConfigValue()))
            && (this.getConfigRemark() == null ? other.getConfigRemark() == null : this.getConfigRemark().equals(other.getConfigRemark()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cm_config
     *
     * @mbggenerated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCmConfigId() == null) ? 0 : getCmConfigId().hashCode());
        result = prime * result + ((getConfigCode() == null) ? 0 : getConfigCode().hashCode());
        result = prime * result + ((getConfigValue() == null) ? 0 : getConfigValue().hashCode());
        result = prime * result + ((getConfigRemark() == null) ? 0 : getConfigRemark().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }
}