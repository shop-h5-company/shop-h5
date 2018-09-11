package com.p2g.mybatis.model.generator;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class HqWithdrawCheck implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hq_withdraw_check.hq_withdraw_check_id
     *
     * @mbggenerated
     */
    private Long hqWithdrawCheckId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hq_withdraw_check.user_id
     *
     * @mbggenerated
     */
    private Long userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hq_withdraw_check.trans_no
     *
     * @mbggenerated
     */
    private String transNo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hq_withdraw_check.withdraw_amt
     *
     * @mbggenerated
     */
    private BigDecimal withdrawAmt;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hq_withdraw_check.withdraw_fee
     *
     * @mbggenerated
     */
    private BigDecimal withdrawFee;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hq_withdraw_check.create_time
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hq_withdraw_check.check_status
     *
     * @mbggenerated
     */
    private String checkStatus;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hq_withdraw_check.check_admin
     *
     * @mbggenerated
     */
    private String checkAdmin;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hq_withdraw_check.check_time
     *
     * @mbggenerated
     */
    private Date checkTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hq_withdraw_check.pay_status
     *
     * @mbggenerated
     */
    private String payStatus;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hq_withdraw_check.pay_admin
     *
     * @mbggenerated
     */
    private String payAdmin;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hq_withdraw_check.pay_time
     *
     * @mbggenerated
     */
    private Date payTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hq_withdraw_check.bank_code
     *
     * @mbggenerated
     */
    private String bankCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hq_withdraw_check.bank_name
     *
     * @mbggenerated
     */
    private String bankName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hq_withdraw_check.bank_card
     *
     * @mbggenerated
     */
    private String bankCard;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hq_withdraw_check.remark
     *
     * @mbggenerated
     */
    private String remark;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hq_withdraw_check.update_time
     *
     * @mbggenerated
     */
    private Date updateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table hq_withdraw_check
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hq_withdraw_check.hq_withdraw_check_id
     *
     * @return the value of hq_withdraw_check.hq_withdraw_check_id
     *
     * @mbggenerated
     */
    public Long getHqWithdrawCheckId() {
        return hqWithdrawCheckId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hq_withdraw_check.hq_withdraw_check_id
     *
     * @param hqWithdrawCheckId the value for hq_withdraw_check.hq_withdraw_check_id
     *
     * @mbggenerated
     */
    public void setHqWithdrawCheckId(Long hqWithdrawCheckId) {
        this.hqWithdrawCheckId = hqWithdrawCheckId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hq_withdraw_check.user_id
     *
     * @return the value of hq_withdraw_check.user_id
     *
     * @mbggenerated
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hq_withdraw_check.user_id
     *
     * @param userId the value for hq_withdraw_check.user_id
     *
     * @mbggenerated
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hq_withdraw_check.trans_no
     *
     * @return the value of hq_withdraw_check.trans_no
     *
     * @mbggenerated
     */
    public String getTransNo() {
        return transNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hq_withdraw_check.trans_no
     *
     * @param transNo the value for hq_withdraw_check.trans_no
     *
     * @mbggenerated
     */
    public void setTransNo(String transNo) {
        this.transNo = transNo == null ? null : transNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hq_withdraw_check.withdraw_amt
     *
     * @return the value of hq_withdraw_check.withdraw_amt
     *
     * @mbggenerated
     */
    public BigDecimal getWithdrawAmt() {
        return withdrawAmt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hq_withdraw_check.withdraw_amt
     *
     * @param withdrawAmt the value for hq_withdraw_check.withdraw_amt
     *
     * @mbggenerated
     */
    public void setWithdrawAmt(BigDecimal withdrawAmt) {
        this.withdrawAmt = withdrawAmt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hq_withdraw_check.withdraw_fee
     *
     * @return the value of hq_withdraw_check.withdraw_fee
     *
     * @mbggenerated
     */
    public BigDecimal getWithdrawFee() {
        return withdrawFee;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hq_withdraw_check.withdraw_fee
     *
     * @param withdrawFee the value for hq_withdraw_check.withdraw_fee
     *
     * @mbggenerated
     */
    public void setWithdrawFee(BigDecimal withdrawFee) {
        this.withdrawFee = withdrawFee;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hq_withdraw_check.create_time
     *
     * @return the value of hq_withdraw_check.create_time
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hq_withdraw_check.create_time
     *
     * @param createTime the value for hq_withdraw_check.create_time
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hq_withdraw_check.check_status
     *
     * @return the value of hq_withdraw_check.check_status
     *
     * @mbggenerated
     */
    public String getCheckStatus() {
        return checkStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hq_withdraw_check.check_status
     *
     * @param checkStatus the value for hq_withdraw_check.check_status
     *
     * @mbggenerated
     */
    public void setCheckStatus(String checkStatus) {
        this.checkStatus = checkStatus == null ? null : checkStatus.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hq_withdraw_check.check_admin
     *
     * @return the value of hq_withdraw_check.check_admin
     *
     * @mbggenerated
     */
    public String getCheckAdmin() {
        return checkAdmin;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hq_withdraw_check.check_admin
     *
     * @param checkAdmin the value for hq_withdraw_check.check_admin
     *
     * @mbggenerated
     */
    public void setCheckAdmin(String checkAdmin) {
        this.checkAdmin = checkAdmin == null ? null : checkAdmin.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hq_withdraw_check.check_time
     *
     * @return the value of hq_withdraw_check.check_time
     *
     * @mbggenerated
     */
    public Date getCheckTime() {
        return checkTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hq_withdraw_check.check_time
     *
     * @param checkTime the value for hq_withdraw_check.check_time
     *
     * @mbggenerated
     */
    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hq_withdraw_check.pay_status
     *
     * @return the value of hq_withdraw_check.pay_status
     *
     * @mbggenerated
     */
    public String getPayStatus() {
        return payStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hq_withdraw_check.pay_status
     *
     * @param payStatus the value for hq_withdraw_check.pay_status
     *
     * @mbggenerated
     */
    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus == null ? null : payStatus.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hq_withdraw_check.pay_admin
     *
     * @return the value of hq_withdraw_check.pay_admin
     *
     * @mbggenerated
     */
    public String getPayAdmin() {
        return payAdmin;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hq_withdraw_check.pay_admin
     *
     * @param payAdmin the value for hq_withdraw_check.pay_admin
     *
     * @mbggenerated
     */
    public void setPayAdmin(String payAdmin) {
        this.payAdmin = payAdmin == null ? null : payAdmin.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hq_withdraw_check.pay_time
     *
     * @return the value of hq_withdraw_check.pay_time
     *
     * @mbggenerated
     */
    public Date getPayTime() {
        return payTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hq_withdraw_check.pay_time
     *
     * @param payTime the value for hq_withdraw_check.pay_time
     *
     * @mbggenerated
     */
    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hq_withdraw_check.bank_code
     *
     * @return the value of hq_withdraw_check.bank_code
     *
     * @mbggenerated
     */
    public String getBankCode() {
        return bankCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hq_withdraw_check.bank_code
     *
     * @param bankCode the value for hq_withdraw_check.bank_code
     *
     * @mbggenerated
     */
    public void setBankCode(String bankCode) {
        this.bankCode = bankCode == null ? null : bankCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hq_withdraw_check.bank_name
     *
     * @return the value of hq_withdraw_check.bank_name
     *
     * @mbggenerated
     */
    public String getBankName() {
        return bankName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hq_withdraw_check.bank_name
     *
     * @param bankName the value for hq_withdraw_check.bank_name
     *
     * @mbggenerated
     */
    public void setBankName(String bankName) {
        this.bankName = bankName == null ? null : bankName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hq_withdraw_check.bank_card
     *
     * @return the value of hq_withdraw_check.bank_card
     *
     * @mbggenerated
     */
    public String getBankCard() {
        return bankCard;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hq_withdraw_check.bank_card
     *
     * @param bankCard the value for hq_withdraw_check.bank_card
     *
     * @mbggenerated
     */
    public void setBankCard(String bankCard) {
        this.bankCard = bankCard == null ? null : bankCard.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hq_withdraw_check.remark
     *
     * @return the value of hq_withdraw_check.remark
     *
     * @mbggenerated
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hq_withdraw_check.remark
     *
     * @param remark the value for hq_withdraw_check.remark
     *
     * @mbggenerated
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hq_withdraw_check.update_time
     *
     * @return the value of hq_withdraw_check.update_time
     *
     * @mbggenerated
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hq_withdraw_check.update_time
     *
     * @param updateTime the value for hq_withdraw_check.update_time
     *
     * @mbggenerated
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hq_withdraw_check
     *
     * @mbggenerated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", hqWithdrawCheckId=").append(hqWithdrawCheckId);
        sb.append(", userId=").append(userId);
        sb.append(", transNo=").append(transNo);
        sb.append(", withdrawAmt=").append(withdrawAmt);
        sb.append(", withdrawFee=").append(withdrawFee);
        sb.append(", createTime=").append(createTime);
        sb.append(", checkStatus=").append(checkStatus);
        sb.append(", checkAdmin=").append(checkAdmin);
        sb.append(", checkTime=").append(checkTime);
        sb.append(", payStatus=").append(payStatus);
        sb.append(", payAdmin=").append(payAdmin);
        sb.append(", payTime=").append(payTime);
        sb.append(", bankCode=").append(bankCode);
        sb.append(", bankName=").append(bankName);
        sb.append(", bankCard=").append(bankCard);
        sb.append(", remark=").append(remark);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hq_withdraw_check
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
        HqWithdrawCheck other = (HqWithdrawCheck) that;
        return (this.getHqWithdrawCheckId() == null ? other.getHqWithdrawCheckId() == null : this.getHqWithdrawCheckId().equals(other.getHqWithdrawCheckId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getTransNo() == null ? other.getTransNo() == null : this.getTransNo().equals(other.getTransNo()))
            && (this.getWithdrawAmt() == null ? other.getWithdrawAmt() == null : this.getWithdrawAmt().equals(other.getWithdrawAmt()))
            && (this.getWithdrawFee() == null ? other.getWithdrawFee() == null : this.getWithdrawFee().equals(other.getWithdrawFee()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getCheckStatus() == null ? other.getCheckStatus() == null : this.getCheckStatus().equals(other.getCheckStatus()))
            && (this.getCheckAdmin() == null ? other.getCheckAdmin() == null : this.getCheckAdmin().equals(other.getCheckAdmin()))
            && (this.getCheckTime() == null ? other.getCheckTime() == null : this.getCheckTime().equals(other.getCheckTime()))
            && (this.getPayStatus() == null ? other.getPayStatus() == null : this.getPayStatus().equals(other.getPayStatus()))
            && (this.getPayAdmin() == null ? other.getPayAdmin() == null : this.getPayAdmin().equals(other.getPayAdmin()))
            && (this.getPayTime() == null ? other.getPayTime() == null : this.getPayTime().equals(other.getPayTime()))
            && (this.getBankCode() == null ? other.getBankCode() == null : this.getBankCode().equals(other.getBankCode()))
            && (this.getBankName() == null ? other.getBankName() == null : this.getBankName().equals(other.getBankName()))
            && (this.getBankCard() == null ? other.getBankCard() == null : this.getBankCard().equals(other.getBankCard()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hq_withdraw_check
     *
     * @mbggenerated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getHqWithdrawCheckId() == null) ? 0 : getHqWithdrawCheckId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getTransNo() == null) ? 0 : getTransNo().hashCode());
        result = prime * result + ((getWithdrawAmt() == null) ? 0 : getWithdrawAmt().hashCode());
        result = prime * result + ((getWithdrawFee() == null) ? 0 : getWithdrawFee().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCheckStatus() == null) ? 0 : getCheckStatus().hashCode());
        result = prime * result + ((getCheckAdmin() == null) ? 0 : getCheckAdmin().hashCode());
        result = prime * result + ((getCheckTime() == null) ? 0 : getCheckTime().hashCode());
        result = prime * result + ((getPayStatus() == null) ? 0 : getPayStatus().hashCode());
        result = prime * result + ((getPayAdmin() == null) ? 0 : getPayAdmin().hashCode());
        result = prime * result + ((getPayTime() == null) ? 0 : getPayTime().hashCode());
        result = prime * result + ((getBankCode() == null) ? 0 : getBankCode().hashCode());
        result = prime * result + ((getBankName() == null) ? 0 : getBankName().hashCode());
        result = prime * result + ((getBankCard() == null) ? 0 : getBankCard().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }
}