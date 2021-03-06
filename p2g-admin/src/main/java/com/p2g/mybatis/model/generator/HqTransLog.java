package com.p2g.mybatis.model.generator;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class HqTransLog implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hq_trans_log.hq_trans_log_id
     *
     * @mbggenerated
     */
    private Long hqTransLogId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hq_trans_log.user_id
     *
     * @mbggenerated
     */
    private Long userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hq_trans_log.trans_no
     *
     * @mbggenerated
     */
    private String transNo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hq_trans_log.pay_no
     *
     * @mbggenerated
     */
    private String payNo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hq_trans_log.trans_amt
     *
     * @mbggenerated
     */
    private BigDecimal transAmt;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hq_trans_log.before_amt
     *
     * @mbggenerated
     */
    private BigDecimal beforeAmt;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hq_trans_log.after_amt
     *
     * @mbggenerated
     */
    private BigDecimal afterAmt;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hq_trans_log.trans_time
     *
     * @mbggenerated
     */
    private Date transTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hq_trans_log.trans_kind
     *
     * @mbggenerated
     */
    private String transKind;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hq_trans_log.balance_type
     *
     * @mbggenerated
     */
    private String balanceType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hq_trans_log.status
     *
     * @mbggenerated
     */
    private String status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hq_trans_log.withdraw_fee
     *
     * @mbggenerated
     */
    private BigDecimal withdrawFee;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hq_trans_log.bank_code
     *
     * @mbggenerated
     */
    private String bankCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hq_trans_log.bank_name
     *
     * @mbggenerated
     */
    private String bankName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hq_trans_log.bank_card
     *
     * @mbggenerated
     */
    private String bankCard;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hq_trans_log.update_time
     *
     * @mbggenerated
     */
    private Date updateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table hq_trans_log
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hq_trans_log.hq_trans_log_id
     *
     * @return the value of hq_trans_log.hq_trans_log_id
     *
     * @mbggenerated
     */
    public Long getHqTransLogId() {
        return hqTransLogId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hq_trans_log.hq_trans_log_id
     *
     * @param hqTransLogId the value for hq_trans_log.hq_trans_log_id
     *
     * @mbggenerated
     */
    public void setHqTransLogId(Long hqTransLogId) {
        this.hqTransLogId = hqTransLogId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hq_trans_log.user_id
     *
     * @return the value of hq_trans_log.user_id
     *
     * @mbggenerated
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hq_trans_log.user_id
     *
     * @param userId the value for hq_trans_log.user_id
     *
     * @mbggenerated
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hq_trans_log.trans_no
     *
     * @return the value of hq_trans_log.trans_no
     *
     * @mbggenerated
     */
    public String getTransNo() {
        return transNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hq_trans_log.trans_no
     *
     * @param transNo the value for hq_trans_log.trans_no
     *
     * @mbggenerated
     */
    public void setTransNo(String transNo) {
        this.transNo = transNo == null ? null : transNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hq_trans_log.pay_no
     *
     * @return the value of hq_trans_log.pay_no
     *
     * @mbggenerated
     */
    public String getPayNo() {
        return payNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hq_trans_log.pay_no
     *
     * @param payNo the value for hq_trans_log.pay_no
     *
     * @mbggenerated
     */
    public void setPayNo(String payNo) {
        this.payNo = payNo == null ? null : payNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hq_trans_log.trans_amt
     *
     * @return the value of hq_trans_log.trans_amt
     *
     * @mbggenerated
     */
    public BigDecimal getTransAmt() {
        return transAmt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hq_trans_log.trans_amt
     *
     * @param transAmt the value for hq_trans_log.trans_amt
     *
     * @mbggenerated
     */
    public void setTransAmt(BigDecimal transAmt) {
        this.transAmt = transAmt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hq_trans_log.before_amt
     *
     * @return the value of hq_trans_log.before_amt
     *
     * @mbggenerated
     */
    public BigDecimal getBeforeAmt() {
        return beforeAmt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hq_trans_log.before_amt
     *
     * @param beforeAmt the value for hq_trans_log.before_amt
     *
     * @mbggenerated
     */
    public void setBeforeAmt(BigDecimal beforeAmt) {
        this.beforeAmt = beforeAmt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hq_trans_log.after_amt
     *
     * @return the value of hq_trans_log.after_amt
     *
     * @mbggenerated
     */
    public BigDecimal getAfterAmt() {
        return afterAmt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hq_trans_log.after_amt
     *
     * @param afterAmt the value for hq_trans_log.after_amt
     *
     * @mbggenerated
     */
    public void setAfterAmt(BigDecimal afterAmt) {
        this.afterAmt = afterAmt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hq_trans_log.trans_time
     *
     * @return the value of hq_trans_log.trans_time
     *
     * @mbggenerated
     */
    public Date getTransTime() {
        return transTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hq_trans_log.trans_time
     *
     * @param transTime the value for hq_trans_log.trans_time
     *
     * @mbggenerated
     */
    public void setTransTime(Date transTime) {
        this.transTime = transTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hq_trans_log.trans_kind
     *
     * @return the value of hq_trans_log.trans_kind
     *
     * @mbggenerated
     */
    public String getTransKind() {
        return transKind;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hq_trans_log.trans_kind
     *
     * @param transKind the value for hq_trans_log.trans_kind
     *
     * @mbggenerated
     */
    public void setTransKind(String transKind) {
        this.transKind = transKind == null ? null : transKind.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hq_trans_log.balance_type
     *
     * @return the value of hq_trans_log.balance_type
     *
     * @mbggenerated
     */
    public String getBalanceType() {
        return balanceType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hq_trans_log.balance_type
     *
     * @param balanceType the value for hq_trans_log.balance_type
     *
     * @mbggenerated
     */
    public void setBalanceType(String balanceType) {
        this.balanceType = balanceType == null ? null : balanceType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hq_trans_log.status
     *
     * @return the value of hq_trans_log.status
     *
     * @mbggenerated
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hq_trans_log.status
     *
     * @param status the value for hq_trans_log.status
     *
     * @mbggenerated
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hq_trans_log.withdraw_fee
     *
     * @return the value of hq_trans_log.withdraw_fee
     *
     * @mbggenerated
     */
    public BigDecimal getWithdrawFee() {
        return withdrawFee;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hq_trans_log.withdraw_fee
     *
     * @param withdrawFee the value for hq_trans_log.withdraw_fee
     *
     * @mbggenerated
     */
    public void setWithdrawFee(BigDecimal withdrawFee) {
        this.withdrawFee = withdrawFee;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hq_trans_log.bank_code
     *
     * @return the value of hq_trans_log.bank_code
     *
     * @mbggenerated
     */
    public String getBankCode() {
        return bankCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hq_trans_log.bank_code
     *
     * @param bankCode the value for hq_trans_log.bank_code
     *
     * @mbggenerated
     */
    public void setBankCode(String bankCode) {
        this.bankCode = bankCode == null ? null : bankCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hq_trans_log.bank_name
     *
     * @return the value of hq_trans_log.bank_name
     *
     * @mbggenerated
     */
    public String getBankName() {
        return bankName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hq_trans_log.bank_name
     *
     * @param bankName the value for hq_trans_log.bank_name
     *
     * @mbggenerated
     */
    public void setBankName(String bankName) {
        this.bankName = bankName == null ? null : bankName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hq_trans_log.bank_card
     *
     * @return the value of hq_trans_log.bank_card
     *
     * @mbggenerated
     */
    public String getBankCard() {
        return bankCard;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hq_trans_log.bank_card
     *
     * @param bankCard the value for hq_trans_log.bank_card
     *
     * @mbggenerated
     */
    public void setBankCard(String bankCard) {
        this.bankCard = bankCard == null ? null : bankCard.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hq_trans_log.update_time
     *
     * @return the value of hq_trans_log.update_time
     *
     * @mbggenerated
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hq_trans_log.update_time
     *
     * @param updateTime the value for hq_trans_log.update_time
     *
     * @mbggenerated
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hq_trans_log
     *
     * @mbggenerated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", hqTransLogId=").append(hqTransLogId);
        sb.append(", userId=").append(userId);
        sb.append(", transNo=").append(transNo);
        sb.append(", payNo=").append(payNo);
        sb.append(", transAmt=").append(transAmt);
        sb.append(", beforeAmt=").append(beforeAmt);
        sb.append(", afterAmt=").append(afterAmt);
        sb.append(", transTime=").append(transTime);
        sb.append(", transKind=").append(transKind);
        sb.append(", balanceType=").append(balanceType);
        sb.append(", status=").append(status);
        sb.append(", withdrawFee=").append(withdrawFee);
        sb.append(", bankCode=").append(bankCode);
        sb.append(", bankName=").append(bankName);
        sb.append(", bankCard=").append(bankCard);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hq_trans_log
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
        HqTransLog other = (HqTransLog) that;
        return (this.getHqTransLogId() == null ? other.getHqTransLogId() == null : this.getHqTransLogId().equals(other.getHqTransLogId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getTransNo() == null ? other.getTransNo() == null : this.getTransNo().equals(other.getTransNo()))
            && (this.getPayNo() == null ? other.getPayNo() == null : this.getPayNo().equals(other.getPayNo()))
            && (this.getTransAmt() == null ? other.getTransAmt() == null : this.getTransAmt().equals(other.getTransAmt()))
            && (this.getBeforeAmt() == null ? other.getBeforeAmt() == null : this.getBeforeAmt().equals(other.getBeforeAmt()))
            && (this.getAfterAmt() == null ? other.getAfterAmt() == null : this.getAfterAmt().equals(other.getAfterAmt()))
            && (this.getTransTime() == null ? other.getTransTime() == null : this.getTransTime().equals(other.getTransTime()))
            && (this.getTransKind() == null ? other.getTransKind() == null : this.getTransKind().equals(other.getTransKind()))
            && (this.getBalanceType() == null ? other.getBalanceType() == null : this.getBalanceType().equals(other.getBalanceType()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getWithdrawFee() == null ? other.getWithdrawFee() == null : this.getWithdrawFee().equals(other.getWithdrawFee()))
            && (this.getBankCode() == null ? other.getBankCode() == null : this.getBankCode().equals(other.getBankCode()))
            && (this.getBankName() == null ? other.getBankName() == null : this.getBankName().equals(other.getBankName()))
            && (this.getBankCard() == null ? other.getBankCard() == null : this.getBankCard().equals(other.getBankCard()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hq_trans_log
     *
     * @mbggenerated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getHqTransLogId() == null) ? 0 : getHqTransLogId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getTransNo() == null) ? 0 : getTransNo().hashCode());
        result = prime * result + ((getPayNo() == null) ? 0 : getPayNo().hashCode());
        result = prime * result + ((getTransAmt() == null) ? 0 : getTransAmt().hashCode());
        result = prime * result + ((getBeforeAmt() == null) ? 0 : getBeforeAmt().hashCode());
        result = prime * result + ((getAfterAmt() == null) ? 0 : getAfterAmt().hashCode());
        result = prime * result + ((getTransTime() == null) ? 0 : getTransTime().hashCode());
        result = prime * result + ((getTransKind() == null) ? 0 : getTransKind().hashCode());
        result = prime * result + ((getBalanceType() == null) ? 0 : getBalanceType().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getWithdrawFee() == null) ? 0 : getWithdrawFee().hashCode());
        result = prime * result + ((getBankCode() == null) ? 0 : getBankCode().hashCode());
        result = prime * result + ((getBankName() == null) ? 0 : getBankName().hashCode());
        result = prime * result + ((getBankCard() == null) ? 0 : getBankCard().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }
}