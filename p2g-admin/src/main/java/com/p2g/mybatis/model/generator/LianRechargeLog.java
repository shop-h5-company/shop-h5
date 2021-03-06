package com.p2g.mybatis.model.generator;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class LianRechargeLog implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lian_recharge_log.lian_recharge_log_id
     *
     * @mbggenerated
     */
    private Long lianRechargeLogId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lian_recharge_log.user_id
     *
     * @mbggenerated
     */
    private Long userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lian_recharge_log.order_no
     *
     * @mbggenerated
     */
    private String orderNo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lian_recharge_log.order_date
     *
     * @mbggenerated
     */
    private String orderDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lian_recharge_log.amount
     *
     * @mbggenerated
     */
    private BigDecimal amount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lian_recharge_log.product_type
     *
     * @mbggenerated
     */
    private String productType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lian_recharge_log.bank_card
     *
     * @mbggenerated
     */
    private String bankCard;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lian_recharge_log.lian_bank_code
     *
     * @mbggenerated
     */
    private String lianBankCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lian_recharge_log.bank_name
     *
     * @mbggenerated
     */
    private String bankName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lian_recharge_log.name
     *
     * @mbggenerated
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lian_recharge_log.id_card
     *
     * @mbggenerated
     */
    private String idCard;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lian_recharge_log.agree_no
     *
     * @mbggenerated
     */
    private String agreeNo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lian_recharge_log.risk_item
     *
     * @mbggenerated
     */
    private String riskItem;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lian_recharge_log.return_url
     *
     * @mbggenerated
     */
    private String returnUrl;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lian_recharge_log.notify_url
     *
     * @mbggenerated
     */
    private String notifyUrl;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lian_recharge_log.status
     *
     * @mbggenerated
     */
    private String status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lian_recharge_log.yintong_pay_no
     *
     * @mbggenerated
     */
    private String yintongPayNo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lian_recharge_log.yintong_pay_result
     *
     * @mbggenerated
     */
    private String yintongPayResult;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lian_recharge_log.yintong_settle_date
     *
     * @mbggenerated
     */
    private String yintongSettleDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lian_recharge_log.create_time
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lian_recharge_log.update_time
     *
     * @mbggenerated
     */
    private Date updateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lian_recharge_log.verify_status
     *
     * @mbggenerated
     */
    private String verifyStatus;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table lian_recharge_log
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lian_recharge_log.lian_recharge_log_id
     *
     * @return the value of lian_recharge_log.lian_recharge_log_id
     *
     * @mbggenerated
     */
    public Long getLianRechargeLogId() {
        return lianRechargeLogId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lian_recharge_log.lian_recharge_log_id
     *
     * @param lianRechargeLogId the value for lian_recharge_log.lian_recharge_log_id
     *
     * @mbggenerated
     */
    public void setLianRechargeLogId(Long lianRechargeLogId) {
        this.lianRechargeLogId = lianRechargeLogId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lian_recharge_log.user_id
     *
     * @return the value of lian_recharge_log.user_id
     *
     * @mbggenerated
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lian_recharge_log.user_id
     *
     * @param userId the value for lian_recharge_log.user_id
     *
     * @mbggenerated
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lian_recharge_log.order_no
     *
     * @return the value of lian_recharge_log.order_no
     *
     * @mbggenerated
     */
    public String getOrderNo() {
        return orderNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lian_recharge_log.order_no
     *
     * @param orderNo the value for lian_recharge_log.order_no
     *
     * @mbggenerated
     */
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lian_recharge_log.order_date
     *
     * @return the value of lian_recharge_log.order_date
     *
     * @mbggenerated
     */
    public String getOrderDate() {
        return orderDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lian_recharge_log.order_date
     *
     * @param orderDate the value for lian_recharge_log.order_date
     *
     * @mbggenerated
     */
    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate == null ? null : orderDate.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lian_recharge_log.amount
     *
     * @return the value of lian_recharge_log.amount
     *
     * @mbggenerated
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lian_recharge_log.amount
     *
     * @param amount the value for lian_recharge_log.amount
     *
     * @mbggenerated
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lian_recharge_log.product_type
     *
     * @return the value of lian_recharge_log.product_type
     *
     * @mbggenerated
     */
    public String getProductType() {
        return productType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lian_recharge_log.product_type
     *
     * @param productType the value for lian_recharge_log.product_type
     *
     * @mbggenerated
     */
    public void setProductType(String productType) {
        this.productType = productType == null ? null : productType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lian_recharge_log.bank_card
     *
     * @return the value of lian_recharge_log.bank_card
     *
     * @mbggenerated
     */
    public String getBankCard() {
        return bankCard;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lian_recharge_log.bank_card
     *
     * @param bankCard the value for lian_recharge_log.bank_card
     *
     * @mbggenerated
     */
    public void setBankCard(String bankCard) {
        this.bankCard = bankCard == null ? null : bankCard.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lian_recharge_log.lian_bank_code
     *
     * @return the value of lian_recharge_log.lian_bank_code
     *
     * @mbggenerated
     */
    public String getLianBankCode() {
        return lianBankCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lian_recharge_log.lian_bank_code
     *
     * @param lianBankCode the value for lian_recharge_log.lian_bank_code
     *
     * @mbggenerated
     */
    public void setLianBankCode(String lianBankCode) {
        this.lianBankCode = lianBankCode == null ? null : lianBankCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lian_recharge_log.bank_name
     *
     * @return the value of lian_recharge_log.bank_name
     *
     * @mbggenerated
     */
    public String getBankName() {
        return bankName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lian_recharge_log.bank_name
     *
     * @param bankName the value for lian_recharge_log.bank_name
     *
     * @mbggenerated
     */
    public void setBankName(String bankName) {
        this.bankName = bankName == null ? null : bankName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lian_recharge_log.name
     *
     * @return the value of lian_recharge_log.name
     *
     * @mbggenerated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lian_recharge_log.name
     *
     * @param name the value for lian_recharge_log.name
     *
     * @mbggenerated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lian_recharge_log.id_card
     *
     * @return the value of lian_recharge_log.id_card
     *
     * @mbggenerated
     */
    public String getIdCard() {
        return idCard;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lian_recharge_log.id_card
     *
     * @param idCard the value for lian_recharge_log.id_card
     *
     * @mbggenerated
     */
    public void setIdCard(String idCard) {
        this.idCard = idCard == null ? null : idCard.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lian_recharge_log.agree_no
     *
     * @return the value of lian_recharge_log.agree_no
     *
     * @mbggenerated
     */
    public String getAgreeNo() {
        return agreeNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lian_recharge_log.agree_no
     *
     * @param agreeNo the value for lian_recharge_log.agree_no
     *
     * @mbggenerated
     */
    public void setAgreeNo(String agreeNo) {
        this.agreeNo = agreeNo == null ? null : agreeNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lian_recharge_log.risk_item
     *
     * @return the value of lian_recharge_log.risk_item
     *
     * @mbggenerated
     */
    public String getRiskItem() {
        return riskItem;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lian_recharge_log.risk_item
     *
     * @param riskItem the value for lian_recharge_log.risk_item
     *
     * @mbggenerated
     */
    public void setRiskItem(String riskItem) {
        this.riskItem = riskItem == null ? null : riskItem.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lian_recharge_log.return_url
     *
     * @return the value of lian_recharge_log.return_url
     *
     * @mbggenerated
     */
    public String getReturnUrl() {
        return returnUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lian_recharge_log.return_url
     *
     * @param returnUrl the value for lian_recharge_log.return_url
     *
     * @mbggenerated
     */
    public void setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl == null ? null : returnUrl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lian_recharge_log.notify_url
     *
     * @return the value of lian_recharge_log.notify_url
     *
     * @mbggenerated
     */
    public String getNotifyUrl() {
        return notifyUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lian_recharge_log.notify_url
     *
     * @param notifyUrl the value for lian_recharge_log.notify_url
     *
     * @mbggenerated
     */
    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl == null ? null : notifyUrl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lian_recharge_log.status
     *
     * @return the value of lian_recharge_log.status
     *
     * @mbggenerated
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lian_recharge_log.status
     *
     * @param status the value for lian_recharge_log.status
     *
     * @mbggenerated
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lian_recharge_log.yintong_pay_no
     *
     * @return the value of lian_recharge_log.yintong_pay_no
     *
     * @mbggenerated
     */
    public String getYintongPayNo() {
        return yintongPayNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lian_recharge_log.yintong_pay_no
     *
     * @param yintongPayNo the value for lian_recharge_log.yintong_pay_no
     *
     * @mbggenerated
     */
    public void setYintongPayNo(String yintongPayNo) {
        this.yintongPayNo = yintongPayNo == null ? null : yintongPayNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lian_recharge_log.yintong_pay_result
     *
     * @return the value of lian_recharge_log.yintong_pay_result
     *
     * @mbggenerated
     */
    public String getYintongPayResult() {
        return yintongPayResult;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lian_recharge_log.yintong_pay_result
     *
     * @param yintongPayResult the value for lian_recharge_log.yintong_pay_result
     *
     * @mbggenerated
     */
    public void setYintongPayResult(String yintongPayResult) {
        this.yintongPayResult = yintongPayResult == null ? null : yintongPayResult.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lian_recharge_log.yintong_settle_date
     *
     * @return the value of lian_recharge_log.yintong_settle_date
     *
     * @mbggenerated
     */
    public String getYintongSettleDate() {
        return yintongSettleDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lian_recharge_log.yintong_settle_date
     *
     * @param yintongSettleDate the value for lian_recharge_log.yintong_settle_date
     *
     * @mbggenerated
     */
    public void setYintongSettleDate(String yintongSettleDate) {
        this.yintongSettleDate = yintongSettleDate == null ? null : yintongSettleDate.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lian_recharge_log.create_time
     *
     * @return the value of lian_recharge_log.create_time
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lian_recharge_log.create_time
     *
     * @param createTime the value for lian_recharge_log.create_time
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lian_recharge_log.update_time
     *
     * @return the value of lian_recharge_log.update_time
     *
     * @mbggenerated
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lian_recharge_log.update_time
     *
     * @param updateTime the value for lian_recharge_log.update_time
     *
     * @mbggenerated
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lian_recharge_log.verify_status
     *
     * @return the value of lian_recharge_log.verify_status
     *
     * @mbggenerated
     */
    public String getVerifyStatus() {
        return verifyStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lian_recharge_log.verify_status
     *
     * @param verifyStatus the value for lian_recharge_log.verify_status
     *
     * @mbggenerated
     */
    public void setVerifyStatus(String verifyStatus) {
        this.verifyStatus = verifyStatus == null ? null : verifyStatus.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lian_recharge_log
     *
     * @mbggenerated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", lianRechargeLogId=").append(lianRechargeLogId);
        sb.append(", userId=").append(userId);
        sb.append(", orderNo=").append(orderNo);
        sb.append(", orderDate=").append(orderDate);
        sb.append(", amount=").append(amount);
        sb.append(", productType=").append(productType);
        sb.append(", bankCard=").append(bankCard);
        sb.append(", lianBankCode=").append(lianBankCode);
        sb.append(", bankName=").append(bankName);
        sb.append(", name=").append(name);
        sb.append(", idCard=").append(idCard);
        sb.append(", agreeNo=").append(agreeNo);
        sb.append(", riskItem=").append(riskItem);
        sb.append(", returnUrl=").append(returnUrl);
        sb.append(", notifyUrl=").append(notifyUrl);
        sb.append(", status=").append(status);
        sb.append(", yintongPayNo=").append(yintongPayNo);
        sb.append(", yintongPayResult=").append(yintongPayResult);
        sb.append(", yintongSettleDate=").append(yintongSettleDate);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", verifyStatus=").append(verifyStatus);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lian_recharge_log
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
        LianRechargeLog other = (LianRechargeLog) that;
        return (this.getLianRechargeLogId() == null ? other.getLianRechargeLogId() == null : this.getLianRechargeLogId().equals(other.getLianRechargeLogId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getOrderNo() == null ? other.getOrderNo() == null : this.getOrderNo().equals(other.getOrderNo()))
            && (this.getOrderDate() == null ? other.getOrderDate() == null : this.getOrderDate().equals(other.getOrderDate()))
            && (this.getAmount() == null ? other.getAmount() == null : this.getAmount().equals(other.getAmount()))
            && (this.getProductType() == null ? other.getProductType() == null : this.getProductType().equals(other.getProductType()))
            && (this.getBankCard() == null ? other.getBankCard() == null : this.getBankCard().equals(other.getBankCard()))
            && (this.getLianBankCode() == null ? other.getLianBankCode() == null : this.getLianBankCode().equals(other.getLianBankCode()))
            && (this.getBankName() == null ? other.getBankName() == null : this.getBankName().equals(other.getBankName()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getIdCard() == null ? other.getIdCard() == null : this.getIdCard().equals(other.getIdCard()))
            && (this.getAgreeNo() == null ? other.getAgreeNo() == null : this.getAgreeNo().equals(other.getAgreeNo()))
            && (this.getRiskItem() == null ? other.getRiskItem() == null : this.getRiskItem().equals(other.getRiskItem()))
            && (this.getReturnUrl() == null ? other.getReturnUrl() == null : this.getReturnUrl().equals(other.getReturnUrl()))
            && (this.getNotifyUrl() == null ? other.getNotifyUrl() == null : this.getNotifyUrl().equals(other.getNotifyUrl()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getYintongPayNo() == null ? other.getYintongPayNo() == null : this.getYintongPayNo().equals(other.getYintongPayNo()))
            && (this.getYintongPayResult() == null ? other.getYintongPayResult() == null : this.getYintongPayResult().equals(other.getYintongPayResult()))
            && (this.getYintongSettleDate() == null ? other.getYintongSettleDate() == null : this.getYintongSettleDate().equals(other.getYintongSettleDate()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getVerifyStatus() == null ? other.getVerifyStatus() == null : this.getVerifyStatus().equals(other.getVerifyStatus()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lian_recharge_log
     *
     * @mbggenerated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getLianRechargeLogId() == null) ? 0 : getLianRechargeLogId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getOrderNo() == null) ? 0 : getOrderNo().hashCode());
        result = prime * result + ((getOrderDate() == null) ? 0 : getOrderDate().hashCode());
        result = prime * result + ((getAmount() == null) ? 0 : getAmount().hashCode());
        result = prime * result + ((getProductType() == null) ? 0 : getProductType().hashCode());
        result = prime * result + ((getBankCard() == null) ? 0 : getBankCard().hashCode());
        result = prime * result + ((getLianBankCode() == null) ? 0 : getLianBankCode().hashCode());
        result = prime * result + ((getBankName() == null) ? 0 : getBankName().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getIdCard() == null) ? 0 : getIdCard().hashCode());
        result = prime * result + ((getAgreeNo() == null) ? 0 : getAgreeNo().hashCode());
        result = prime * result + ((getRiskItem() == null) ? 0 : getRiskItem().hashCode());
        result = prime * result + ((getReturnUrl() == null) ? 0 : getReturnUrl().hashCode());
        result = prime * result + ((getNotifyUrl() == null) ? 0 : getNotifyUrl().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getYintongPayNo() == null) ? 0 : getYintongPayNo().hashCode());
        result = prime * result + ((getYintongPayResult() == null) ? 0 : getYintongPayResult().hashCode());
        result = prime * result + ((getYintongSettleDate() == null) ? 0 : getYintongSettleDate().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getVerifyStatus() == null) ? 0 : getVerifyStatus().hashCode());
        return result;
    }
}