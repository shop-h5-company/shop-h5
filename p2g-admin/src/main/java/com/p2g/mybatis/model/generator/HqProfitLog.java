package com.p2g.mybatis.model.generator;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class HqProfitLog implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hq_profit_log.hq_profit_log_id
     *
     * @mbggenerated
     */
    private Long hqProfitLogId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hq_profit_log.user_id
     *
     * @mbggenerated
     */
    private Long userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hq_profit_log.balance_amt
     *
     * @mbggenerated
     */
    private BigDecimal balanceAmt;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hq_profit_log.profit_date
     *
     * @mbggenerated
     */
    private String profitDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hq_profit_log.profit_amt
     *
     * @mbggenerated
     */
    private BigDecimal profitAmt;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hq_profit_log.base_rates
     *
     * @mbggenerated
     */
    private BigDecimal baseRates;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hq_profit_log.active_rates
     *
     * @mbggenerated
     */
    private BigDecimal activeRates;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hq_profit_log.create_time
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hq_profit_log.status
     *
     * @mbggenerated
     */
    private String status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hq_profit_log.float_rate
     *
     * @mbggenerated
     */
    private BigDecimal floatRate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hq_profit_log.update_time
     *
     * @mbggenerated
     */
    private Date updateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table hq_profit_log
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hq_profit_log.hq_profit_log_id
     *
     * @return the value of hq_profit_log.hq_profit_log_id
     *
     * @mbggenerated
     */
    public Long getHqProfitLogId() {
        return hqProfitLogId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hq_profit_log.hq_profit_log_id
     *
     * @param hqProfitLogId the value for hq_profit_log.hq_profit_log_id
     *
     * @mbggenerated
     */
    public void setHqProfitLogId(Long hqProfitLogId) {
        this.hqProfitLogId = hqProfitLogId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hq_profit_log.user_id
     *
     * @return the value of hq_profit_log.user_id
     *
     * @mbggenerated
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hq_profit_log.user_id
     *
     * @param userId the value for hq_profit_log.user_id
     *
     * @mbggenerated
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hq_profit_log.balance_amt
     *
     * @return the value of hq_profit_log.balance_amt
     *
     * @mbggenerated
     */
    public BigDecimal getBalanceAmt() {
        return balanceAmt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hq_profit_log.balance_amt
     *
     * @param balanceAmt the value for hq_profit_log.balance_amt
     *
     * @mbggenerated
     */
    public void setBalanceAmt(BigDecimal balanceAmt) {
        this.balanceAmt = balanceAmt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hq_profit_log.profit_date
     *
     * @return the value of hq_profit_log.profit_date
     *
     * @mbggenerated
     */
    public String getProfitDate() {
        return profitDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hq_profit_log.profit_date
     *
     * @param profitDate the value for hq_profit_log.profit_date
     *
     * @mbggenerated
     */
    public void setProfitDate(String profitDate) {
        this.profitDate = profitDate == null ? null : profitDate.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hq_profit_log.profit_amt
     *
     * @return the value of hq_profit_log.profit_amt
     *
     * @mbggenerated
     */
    public BigDecimal getProfitAmt() {
        return profitAmt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hq_profit_log.profit_amt
     *
     * @param profitAmt the value for hq_profit_log.profit_amt
     *
     * @mbggenerated
     */
    public void setProfitAmt(BigDecimal profitAmt) {
        this.profitAmt = profitAmt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hq_profit_log.base_rates
     *
     * @return the value of hq_profit_log.base_rates
     *
     * @mbggenerated
     */
    public BigDecimal getBaseRates() {
        return baseRates;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hq_profit_log.base_rates
     *
     * @param baseRates the value for hq_profit_log.base_rates
     *
     * @mbggenerated
     */
    public void setBaseRates(BigDecimal baseRates) {
        this.baseRates = baseRates;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hq_profit_log.active_rates
     *
     * @return the value of hq_profit_log.active_rates
     *
     * @mbggenerated
     */
    public BigDecimal getActiveRates() {
        return activeRates;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hq_profit_log.active_rates
     *
     * @param activeRates the value for hq_profit_log.active_rates
     *
     * @mbggenerated
     */
    public void setActiveRates(BigDecimal activeRates) {
        this.activeRates = activeRates;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hq_profit_log.create_time
     *
     * @return the value of hq_profit_log.create_time
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hq_profit_log.create_time
     *
     * @param createTime the value for hq_profit_log.create_time
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hq_profit_log.status
     *
     * @return the value of hq_profit_log.status
     *
     * @mbggenerated
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hq_profit_log.status
     *
     * @param status the value for hq_profit_log.status
     *
     * @mbggenerated
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hq_profit_log.float_rate
     *
     * @return the value of hq_profit_log.float_rate
     *
     * @mbggenerated
     */
    public BigDecimal getFloatRate() {
        return floatRate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hq_profit_log.float_rate
     *
     * @param floatRate the value for hq_profit_log.float_rate
     *
     * @mbggenerated
     */
    public void setFloatRate(BigDecimal floatRate) {
        this.floatRate = floatRate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hq_profit_log.update_time
     *
     * @return the value of hq_profit_log.update_time
     *
     * @mbggenerated
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hq_profit_log.update_time
     *
     * @param updateTime the value for hq_profit_log.update_time
     *
     * @mbggenerated
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hq_profit_log
     *
     * @mbggenerated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", hqProfitLogId=").append(hqProfitLogId);
        sb.append(", userId=").append(userId);
        sb.append(", balanceAmt=").append(balanceAmt);
        sb.append(", profitDate=").append(profitDate);
        sb.append(", profitAmt=").append(profitAmt);
        sb.append(", baseRates=").append(baseRates);
        sb.append(", activeRates=").append(activeRates);
        sb.append(", createTime=").append(createTime);
        sb.append(", status=").append(status);
        sb.append(", floatRate=").append(floatRate);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hq_profit_log
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
        HqProfitLog other = (HqProfitLog) that;
        return (this.getHqProfitLogId() == null ? other.getHqProfitLogId() == null : this.getHqProfitLogId().equals(other.getHqProfitLogId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getBalanceAmt() == null ? other.getBalanceAmt() == null : this.getBalanceAmt().equals(other.getBalanceAmt()))
            && (this.getProfitDate() == null ? other.getProfitDate() == null : this.getProfitDate().equals(other.getProfitDate()))
            && (this.getProfitAmt() == null ? other.getProfitAmt() == null : this.getProfitAmt().equals(other.getProfitAmt()))
            && (this.getBaseRates() == null ? other.getBaseRates() == null : this.getBaseRates().equals(other.getBaseRates()))
            && (this.getActiveRates() == null ? other.getActiveRates() == null : this.getActiveRates().equals(other.getActiveRates()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getFloatRate() == null ? other.getFloatRate() == null : this.getFloatRate().equals(other.getFloatRate()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hq_profit_log
     *
     * @mbggenerated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getHqProfitLogId() == null) ? 0 : getHqProfitLogId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getBalanceAmt() == null) ? 0 : getBalanceAmt().hashCode());
        result = prime * result + ((getProfitDate() == null) ? 0 : getProfitDate().hashCode());
        result = prime * result + ((getProfitAmt() == null) ? 0 : getProfitAmt().hashCode());
        result = prime * result + ((getBaseRates() == null) ? 0 : getBaseRates().hashCode());
        result = prime * result + ((getActiveRates() == null) ? 0 : getActiveRates().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getFloatRate() == null) ? 0 : getFloatRate().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }
}