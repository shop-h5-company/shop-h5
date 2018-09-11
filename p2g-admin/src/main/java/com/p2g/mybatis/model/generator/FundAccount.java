package com.p2g.mybatis.model.generator;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class FundAccount implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column fund_account.user_id
     *
     * @mbggenerated
     */
    private Long userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column fund_account.password
     *
     * @mbggenerated
     */
    private String password;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column fund_account.password_salt
     *
     * @mbggenerated
     */
    private String passwordSalt;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column fund_account.lian_account_status
     *
     * @mbggenerated
     */
    private String lianAccountStatus;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column fund_account.has_invest
     *
     * @mbggenerated
     */
    private String hasInvest;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column fund_account.hq_balance_amt
     *
     * @mbggenerated
     */
    private BigDecimal hqBalanceAmt;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column fund_account.hq_not_acct_profit_amt
     *
     * @mbggenerated
     */
    private BigDecimal hqNotAcctProfitAmt;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column fund_account.hq_withdraw_freezing_amt
     *
     * @mbggenerated
     */
    private BigDecimal hqWithdrawFreezingAmt;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column fund_account.hq_total_recharge_amt
     *
     * @mbggenerated
     */
    private BigDecimal hqTotalRechargeAmt;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column fund_account.hq_total_withdraw_amt
     *
     * @mbggenerated
     */
    private BigDecimal hqTotalWithdrawAmt;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column fund_account.hq_total_profit_amt
     *
     * @mbggenerated
     */
    private BigDecimal hqTotalProfitAmt;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column fund_account.hq_last_recharge_time
     *
     * @mbggenerated
     */
    private Date hqLastRechargeTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column fund_account.hq_last_withdraw_time
     *
     * @mbggenerated
     */
    private Date hqLastWithdrawTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column fund_account.hq_last_profit_time
     *
     * @mbggenerated
     */
    private Date hqLastProfitTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column fund_account.hq_float_rates
     *
     * @mbggenerated
     */
    private BigDecimal hqFloatRates;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column fund_account.hq_coupon_rates
     *
     * @mbggenerated
     */
    private BigDecimal hqCouponRates;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column fund_account.hq_coupon_begin_time
     *
     * @mbggenerated
     */
    private Date hqCouponBeginTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column fund_account.hq_coupon_end_time
     *
     * @mbggenerated
     */
    private Date hqCouponEndTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column fund_account.hq_withdraw_flag
     *
     * @mbggenerated
     */
    private String hqWithdrawFlag;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column fund_account.hq_day_total_withdraw_amt
     *
     * @mbggenerated
     */
    private BigDecimal hqDayTotalWithdrawAmt;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column fund_account.hq_month_withdraw_count
     *
     * @mbggenerated
     */
    private Integer hqMonthWithdrawCount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column fund_account.coupons_id
     *
     * @mbggenerated
     */
    private Long couponsId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table fund_account
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column fund_account.user_id
     *
     * @return the value of fund_account.user_id
     *
     * @mbggenerated
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column fund_account.user_id
     *
     * @param userId the value for fund_account.user_id
     *
     * @mbggenerated
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column fund_account.password
     *
     * @return the value of fund_account.password
     *
     * @mbggenerated
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column fund_account.password
     *
     * @param password the value for fund_account.password
     *
     * @mbggenerated
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column fund_account.password_salt
     *
     * @return the value of fund_account.password_salt
     *
     * @mbggenerated
     */
    public String getPasswordSalt() {
        return passwordSalt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column fund_account.password_salt
     *
     * @param passwordSalt the value for fund_account.password_salt
     *
     * @mbggenerated
     */
    public void setPasswordSalt(String passwordSalt) {
        this.passwordSalt = passwordSalt == null ? null : passwordSalt.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column fund_account.lian_account_status
     *
     * @return the value of fund_account.lian_account_status
     *
     * @mbggenerated
     */
    public String getLianAccountStatus() {
        return lianAccountStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column fund_account.lian_account_status
     *
     * @param lianAccountStatus the value for fund_account.lian_account_status
     *
     * @mbggenerated
     */
    public void setLianAccountStatus(String lianAccountStatus) {
        this.lianAccountStatus = lianAccountStatus == null ? null : lianAccountStatus.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column fund_account.has_invest
     *
     * @return the value of fund_account.has_invest
     *
     * @mbggenerated
     */
    public String getHasInvest() {
        return hasInvest;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column fund_account.has_invest
     *
     * @param hasInvest the value for fund_account.has_invest
     *
     * @mbggenerated
     */
    public void setHasInvest(String hasInvest) {
        this.hasInvest = hasInvest == null ? null : hasInvest.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column fund_account.hq_balance_amt
     *
     * @return the value of fund_account.hq_balance_amt
     *
     * @mbggenerated
     */
    public BigDecimal getHqBalanceAmt() {
        return hqBalanceAmt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column fund_account.hq_balance_amt
     *
     * @param hqBalanceAmt the value for fund_account.hq_balance_amt
     *
     * @mbggenerated
     */
    public void setHqBalanceAmt(BigDecimal hqBalanceAmt) {
        this.hqBalanceAmt = hqBalanceAmt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column fund_account.hq_not_acct_profit_amt
     *
     * @return the value of fund_account.hq_not_acct_profit_amt
     *
     * @mbggenerated
     */
    public BigDecimal getHqNotAcctProfitAmt() {
        return hqNotAcctProfitAmt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column fund_account.hq_not_acct_profit_amt
     *
     * @param hqNotAcctProfitAmt the value for fund_account.hq_not_acct_profit_amt
     *
     * @mbggenerated
     */
    public void setHqNotAcctProfitAmt(BigDecimal hqNotAcctProfitAmt) {
        this.hqNotAcctProfitAmt = hqNotAcctProfitAmt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column fund_account.hq_withdraw_freezing_amt
     *
     * @return the value of fund_account.hq_withdraw_freezing_amt
     *
     * @mbggenerated
     */
    public BigDecimal getHqWithdrawFreezingAmt() {
        return hqWithdrawFreezingAmt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column fund_account.hq_withdraw_freezing_amt
     *
     * @param hqWithdrawFreezingAmt the value for fund_account.hq_withdraw_freezing_amt
     *
     * @mbggenerated
     */
    public void setHqWithdrawFreezingAmt(BigDecimal hqWithdrawFreezingAmt) {
        this.hqWithdrawFreezingAmt = hqWithdrawFreezingAmt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column fund_account.hq_total_recharge_amt
     *
     * @return the value of fund_account.hq_total_recharge_amt
     *
     * @mbggenerated
     */
    public BigDecimal getHqTotalRechargeAmt() {
        return hqTotalRechargeAmt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column fund_account.hq_total_recharge_amt
     *
     * @param hqTotalRechargeAmt the value for fund_account.hq_total_recharge_amt
     *
     * @mbggenerated
     */
    public void setHqTotalRechargeAmt(BigDecimal hqTotalRechargeAmt) {
        this.hqTotalRechargeAmt = hqTotalRechargeAmt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column fund_account.hq_total_withdraw_amt
     *
     * @return the value of fund_account.hq_total_withdraw_amt
     *
     * @mbggenerated
     */
    public BigDecimal getHqTotalWithdrawAmt() {
        return hqTotalWithdrawAmt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column fund_account.hq_total_withdraw_amt
     *
     * @param hqTotalWithdrawAmt the value for fund_account.hq_total_withdraw_amt
     *
     * @mbggenerated
     */
    public void setHqTotalWithdrawAmt(BigDecimal hqTotalWithdrawAmt) {
        this.hqTotalWithdrawAmt = hqTotalWithdrawAmt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column fund_account.hq_total_profit_amt
     *
     * @return the value of fund_account.hq_total_profit_amt
     *
     * @mbggenerated
     */
    public BigDecimal getHqTotalProfitAmt() {
        return hqTotalProfitAmt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column fund_account.hq_total_profit_amt
     *
     * @param hqTotalProfitAmt the value for fund_account.hq_total_profit_amt
     *
     * @mbggenerated
     */
    public void setHqTotalProfitAmt(BigDecimal hqTotalProfitAmt) {
        this.hqTotalProfitAmt = hqTotalProfitAmt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column fund_account.hq_last_recharge_time
     *
     * @return the value of fund_account.hq_last_recharge_time
     *
     * @mbggenerated
     */
    public Date getHqLastRechargeTime() {
        return hqLastRechargeTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column fund_account.hq_last_recharge_time
     *
     * @param hqLastRechargeTime the value for fund_account.hq_last_recharge_time
     *
     * @mbggenerated
     */
    public void setHqLastRechargeTime(Date hqLastRechargeTime) {
        this.hqLastRechargeTime = hqLastRechargeTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column fund_account.hq_last_withdraw_time
     *
     * @return the value of fund_account.hq_last_withdraw_time
     *
     * @mbggenerated
     */
    public Date getHqLastWithdrawTime() {
        return hqLastWithdrawTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column fund_account.hq_last_withdraw_time
     *
     * @param hqLastWithdrawTime the value for fund_account.hq_last_withdraw_time
     *
     * @mbggenerated
     */
    public void setHqLastWithdrawTime(Date hqLastWithdrawTime) {
        this.hqLastWithdrawTime = hqLastWithdrawTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column fund_account.hq_last_profit_time
     *
     * @return the value of fund_account.hq_last_profit_time
     *
     * @mbggenerated
     */
    public Date getHqLastProfitTime() {
        return hqLastProfitTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column fund_account.hq_last_profit_time
     *
     * @param hqLastProfitTime the value for fund_account.hq_last_profit_time
     *
     * @mbggenerated
     */
    public void setHqLastProfitTime(Date hqLastProfitTime) {
        this.hqLastProfitTime = hqLastProfitTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column fund_account.hq_float_rates
     *
     * @return the value of fund_account.hq_float_rates
     *
     * @mbggenerated
     */
    public BigDecimal getHqFloatRates() {
        return hqFloatRates;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column fund_account.hq_float_rates
     *
     * @param hqFloatRates the value for fund_account.hq_float_rates
     *
     * @mbggenerated
     */
    public void setHqFloatRates(BigDecimal hqFloatRates) {
        this.hqFloatRates = hqFloatRates;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column fund_account.hq_coupon_rates
     *
     * @return the value of fund_account.hq_coupon_rates
     *
     * @mbggenerated
     */
    public BigDecimal getHqCouponRates() {
        return hqCouponRates;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column fund_account.hq_coupon_rates
     *
     * @param hqCouponRates the value for fund_account.hq_coupon_rates
     *
     * @mbggenerated
     */
    public void setHqCouponRates(BigDecimal hqCouponRates) {
        this.hqCouponRates = hqCouponRates;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column fund_account.hq_coupon_begin_time
     *
     * @return the value of fund_account.hq_coupon_begin_time
     *
     * @mbggenerated
     */
    public Date getHqCouponBeginTime() {
        return hqCouponBeginTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column fund_account.hq_coupon_begin_time
     *
     * @param hqCouponBeginTime the value for fund_account.hq_coupon_begin_time
     *
     * @mbggenerated
     */
    public void setHqCouponBeginTime(Date hqCouponBeginTime) {
        this.hqCouponBeginTime = hqCouponBeginTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column fund_account.hq_coupon_end_time
     *
     * @return the value of fund_account.hq_coupon_end_time
     *
     * @mbggenerated
     */
    public Date getHqCouponEndTime() {
        return hqCouponEndTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column fund_account.hq_coupon_end_time
     *
     * @param hqCouponEndTime the value for fund_account.hq_coupon_end_time
     *
     * @mbggenerated
     */
    public void setHqCouponEndTime(Date hqCouponEndTime) {
        this.hqCouponEndTime = hqCouponEndTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column fund_account.hq_withdraw_flag
     *
     * @return the value of fund_account.hq_withdraw_flag
     *
     * @mbggenerated
     */
    public String getHqWithdrawFlag() {
        return hqWithdrawFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column fund_account.hq_withdraw_flag
     *
     * @param hqWithdrawFlag the value for fund_account.hq_withdraw_flag
     *
     * @mbggenerated
     */
    public void setHqWithdrawFlag(String hqWithdrawFlag) {
        this.hqWithdrawFlag = hqWithdrawFlag == null ? null : hqWithdrawFlag.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column fund_account.hq_day_total_withdraw_amt
     *
     * @return the value of fund_account.hq_day_total_withdraw_amt
     *
     * @mbggenerated
     */
    public BigDecimal getHqDayTotalWithdrawAmt() {
        return hqDayTotalWithdrawAmt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column fund_account.hq_day_total_withdraw_amt
     *
     * @param hqDayTotalWithdrawAmt the value for fund_account.hq_day_total_withdraw_amt
     *
     * @mbggenerated
     */
    public void setHqDayTotalWithdrawAmt(BigDecimal hqDayTotalWithdrawAmt) {
        this.hqDayTotalWithdrawAmt = hqDayTotalWithdrawAmt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column fund_account.hq_month_withdraw_count
     *
     * @return the value of fund_account.hq_month_withdraw_count
     *
     * @mbggenerated
     */
    public Integer getHqMonthWithdrawCount() {
        return hqMonthWithdrawCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column fund_account.hq_month_withdraw_count
     *
     * @param hqMonthWithdrawCount the value for fund_account.hq_month_withdraw_count
     *
     * @mbggenerated
     */
    public void setHqMonthWithdrawCount(Integer hqMonthWithdrawCount) {
        this.hqMonthWithdrawCount = hqMonthWithdrawCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column fund_account.coupons_id
     *
     * @return the value of fund_account.coupons_id
     *
     * @mbggenerated
     */
    public Long getCouponsId() {
        return couponsId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column fund_account.coupons_id
     *
     * @param couponsId the value for fund_account.coupons_id
     *
     * @mbggenerated
     */
    public void setCouponsId(Long couponsId) {
        this.couponsId = couponsId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fund_account
     *
     * @mbggenerated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userId=").append(userId);
        sb.append(", password=").append(password);
        sb.append(", passwordSalt=").append(passwordSalt);
        sb.append(", lianAccountStatus=").append(lianAccountStatus);
        sb.append(", hasInvest=").append(hasInvest);
        sb.append(", hqBalanceAmt=").append(hqBalanceAmt);
        sb.append(", hqNotAcctProfitAmt=").append(hqNotAcctProfitAmt);
        sb.append(", hqWithdrawFreezingAmt=").append(hqWithdrawFreezingAmt);
        sb.append(", hqTotalRechargeAmt=").append(hqTotalRechargeAmt);
        sb.append(", hqTotalWithdrawAmt=").append(hqTotalWithdrawAmt);
        sb.append(", hqTotalProfitAmt=").append(hqTotalProfitAmt);
        sb.append(", hqLastRechargeTime=").append(hqLastRechargeTime);
        sb.append(", hqLastWithdrawTime=").append(hqLastWithdrawTime);
        sb.append(", hqLastProfitTime=").append(hqLastProfitTime);
        sb.append(", hqFloatRates=").append(hqFloatRates);
        sb.append(", hqCouponRates=").append(hqCouponRates);
        sb.append(", hqCouponBeginTime=").append(hqCouponBeginTime);
        sb.append(", hqCouponEndTime=").append(hqCouponEndTime);
        sb.append(", hqWithdrawFlag=").append(hqWithdrawFlag);
        sb.append(", hqDayTotalWithdrawAmt=").append(hqDayTotalWithdrawAmt);
        sb.append(", hqMonthWithdrawCount=").append(hqMonthWithdrawCount);
        sb.append(", couponsId=").append(couponsId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fund_account
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
        FundAccount other = (FundAccount) that;
        return (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
            && (this.getPasswordSalt() == null ? other.getPasswordSalt() == null : this.getPasswordSalt().equals(other.getPasswordSalt()))
            && (this.getLianAccountStatus() == null ? other.getLianAccountStatus() == null : this.getLianAccountStatus().equals(other.getLianAccountStatus()))
            && (this.getHasInvest() == null ? other.getHasInvest() == null : this.getHasInvest().equals(other.getHasInvest()))
            && (this.getHqBalanceAmt() == null ? other.getHqBalanceAmt() == null : this.getHqBalanceAmt().equals(other.getHqBalanceAmt()))
            && (this.getHqNotAcctProfitAmt() == null ? other.getHqNotAcctProfitAmt() == null : this.getHqNotAcctProfitAmt().equals(other.getHqNotAcctProfitAmt()))
            && (this.getHqWithdrawFreezingAmt() == null ? other.getHqWithdrawFreezingAmt() == null : this.getHqWithdrawFreezingAmt().equals(other.getHqWithdrawFreezingAmt()))
            && (this.getHqTotalRechargeAmt() == null ? other.getHqTotalRechargeAmt() == null : this.getHqTotalRechargeAmt().equals(other.getHqTotalRechargeAmt()))
            && (this.getHqTotalWithdrawAmt() == null ? other.getHqTotalWithdrawAmt() == null : this.getHqTotalWithdrawAmt().equals(other.getHqTotalWithdrawAmt()))
            && (this.getHqTotalProfitAmt() == null ? other.getHqTotalProfitAmt() == null : this.getHqTotalProfitAmt().equals(other.getHqTotalProfitAmt()))
            && (this.getHqLastRechargeTime() == null ? other.getHqLastRechargeTime() == null : this.getHqLastRechargeTime().equals(other.getHqLastRechargeTime()))
            && (this.getHqLastWithdrawTime() == null ? other.getHqLastWithdrawTime() == null : this.getHqLastWithdrawTime().equals(other.getHqLastWithdrawTime()))
            && (this.getHqLastProfitTime() == null ? other.getHqLastProfitTime() == null : this.getHqLastProfitTime().equals(other.getHqLastProfitTime()))
            && (this.getHqFloatRates() == null ? other.getHqFloatRates() == null : this.getHqFloatRates().equals(other.getHqFloatRates()))
            && (this.getHqCouponRates() == null ? other.getHqCouponRates() == null : this.getHqCouponRates().equals(other.getHqCouponRates()))
            && (this.getHqCouponBeginTime() == null ? other.getHqCouponBeginTime() == null : this.getHqCouponBeginTime().equals(other.getHqCouponBeginTime()))
            && (this.getHqCouponEndTime() == null ? other.getHqCouponEndTime() == null : this.getHqCouponEndTime().equals(other.getHqCouponEndTime()))
            && (this.getHqWithdrawFlag() == null ? other.getHqWithdrawFlag() == null : this.getHqWithdrawFlag().equals(other.getHqWithdrawFlag()))
            && (this.getHqDayTotalWithdrawAmt() == null ? other.getHqDayTotalWithdrawAmt() == null : this.getHqDayTotalWithdrawAmt().equals(other.getHqDayTotalWithdrawAmt()))
            && (this.getHqMonthWithdrawCount() == null ? other.getHqMonthWithdrawCount() == null : this.getHqMonthWithdrawCount().equals(other.getHqMonthWithdrawCount()))
            && (this.getCouponsId() == null ? other.getCouponsId() == null : this.getCouponsId().equals(other.getCouponsId()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fund_account
     *
     * @mbggenerated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getPasswordSalt() == null) ? 0 : getPasswordSalt().hashCode());
        result = prime * result + ((getLianAccountStatus() == null) ? 0 : getLianAccountStatus().hashCode());
        result = prime * result + ((getHasInvest() == null) ? 0 : getHasInvest().hashCode());
        result = prime * result + ((getHqBalanceAmt() == null) ? 0 : getHqBalanceAmt().hashCode());
        result = prime * result + ((getHqNotAcctProfitAmt() == null) ? 0 : getHqNotAcctProfitAmt().hashCode());
        result = prime * result + ((getHqWithdrawFreezingAmt() == null) ? 0 : getHqWithdrawFreezingAmt().hashCode());
        result = prime * result + ((getHqTotalRechargeAmt() == null) ? 0 : getHqTotalRechargeAmt().hashCode());
        result = prime * result + ((getHqTotalWithdrawAmt() == null) ? 0 : getHqTotalWithdrawAmt().hashCode());
        result = prime * result + ((getHqTotalProfitAmt() == null) ? 0 : getHqTotalProfitAmt().hashCode());
        result = prime * result + ((getHqLastRechargeTime() == null) ? 0 : getHqLastRechargeTime().hashCode());
        result = prime * result + ((getHqLastWithdrawTime() == null) ? 0 : getHqLastWithdrawTime().hashCode());
        result = prime * result + ((getHqLastProfitTime() == null) ? 0 : getHqLastProfitTime().hashCode());
        result = prime * result + ((getHqFloatRates() == null) ? 0 : getHqFloatRates().hashCode());
        result = prime * result + ((getHqCouponRates() == null) ? 0 : getHqCouponRates().hashCode());
        result = prime * result + ((getHqCouponBeginTime() == null) ? 0 : getHqCouponBeginTime().hashCode());
        result = prime * result + ((getHqCouponEndTime() == null) ? 0 : getHqCouponEndTime().hashCode());
        result = prime * result + ((getHqWithdrawFlag() == null) ? 0 : getHqWithdrawFlag().hashCode());
        result = prime * result + ((getHqDayTotalWithdrawAmt() == null) ? 0 : getHqDayTotalWithdrawAmt().hashCode());
        result = prime * result + ((getHqMonthWithdrawCount() == null) ? 0 : getHqMonthWithdrawCount().hashCode());
        result = prime * result + ((getCouponsId() == null) ? 0 : getCouponsId().hashCode());
        return result;
    }
}