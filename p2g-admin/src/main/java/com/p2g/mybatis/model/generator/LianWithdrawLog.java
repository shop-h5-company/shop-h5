package com.p2g.mybatis.model.generator;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class LianWithdrawLog implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lian_withdraw_log.lian_withdraw_log_id
     *
     * @mbggenerated
     */
    private Long lianWithdrawLogId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lian_withdraw_log.user_id
     *
     * @mbggenerated
     */
    private Long userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lian_withdraw_log.order_no
     *
     * @mbggenerated
     */
    private String orderNo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lian_withdraw_log.order_date
     *
     * @mbggenerated
     */
    private String orderDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lian_withdraw_log.amount
     *
     * @mbggenerated
     */
    private BigDecimal amount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lian_withdraw_log.bank_card
     *
     * @mbggenerated
     */
    private String bankCard;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lian_withdraw_log.lian_bank_code
     *
     * @mbggenerated
     */
    private String lianBankCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lian_withdraw_log.bank_name
     *
     * @mbggenerated
     */
    private String bankName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lian_withdraw_log.order_info
     *
     * @mbggenerated
     */
    private String orderInfo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lian_withdraw_log.create_time
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lian_withdraw_log.sync_ret_code
     *
     * @mbggenerated
     */
    private String syncRetCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lian_withdraw_log.sync_ret_msg
     *
     * @mbggenerated
     */
    private String syncRetMsg;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lian_withdraw_log.asyn_ret_time
     *
     * @mbggenerated
     */
    private Date asynRetTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lian_withdraw_log.asyn_ret_code
     *
     * @mbggenerated
     */
    private String asynRetCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lian_withdraw_log.lian_pay_no
     *
     * @mbggenerated
     */
    private String lianPayNo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lian_withdraw_log.settle_date
     *
     * @mbggenerated
     */
    private String settleDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lian_withdraw_log.status
     *
     * @mbggenerated
     */
    private String status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lian_withdraw_log.province_code
     *
     * @mbggenerated
     */
    private String provinceCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lian_withdraw_log.city_code
     *
     * @mbggenerated
     */
    private String cityCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lian_withdraw_log.brabank_name
     *
     * @mbggenerated
     */
    private String brabankName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lian_withdraw_log.verify_status
     *
     * @mbggenerated
     */
    private String verifyStatus;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lian_withdraw_log.notify_url
     *
     * @mbggenerated
     */
    private String notifyUrl;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table lian_withdraw_log
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lian_withdraw_log.lian_withdraw_log_id
     *
     * @return the value of lian_withdraw_log.lian_withdraw_log_id
     *
     * @mbggenerated
     */
    public Long getLianWithdrawLogId() {
        return lianWithdrawLogId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lian_withdraw_log.lian_withdraw_log_id
     *
     * @param lianWithdrawLogId the value for lian_withdraw_log.lian_withdraw_log_id
     *
     * @mbggenerated
     */
    public void setLianWithdrawLogId(Long lianWithdrawLogId) {
        this.lianWithdrawLogId = lianWithdrawLogId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lian_withdraw_log.user_id
     *
     * @return the value of lian_withdraw_log.user_id
     *
     * @mbggenerated
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lian_withdraw_log.user_id
     *
     * @param userId the value for lian_withdraw_log.user_id
     *
     * @mbggenerated
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lian_withdraw_log.order_no
     *
     * @return the value of lian_withdraw_log.order_no
     *
     * @mbggenerated
     */
    public String getOrderNo() {
        return orderNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lian_withdraw_log.order_no
     *
     * @param orderNo the value for lian_withdraw_log.order_no
     *
     * @mbggenerated
     */
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lian_withdraw_log.order_date
     *
     * @return the value of lian_withdraw_log.order_date
     *
     * @mbggenerated
     */
    public String getOrderDate() {
        return orderDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lian_withdraw_log.order_date
     *
     * @param orderDate the value for lian_withdraw_log.order_date
     *
     * @mbggenerated
     */
    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate == null ? null : orderDate.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lian_withdraw_log.amount
     *
     * @return the value of lian_withdraw_log.amount
     *
     * @mbggenerated
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lian_withdraw_log.amount
     *
     * @param amount the value for lian_withdraw_log.amount
     *
     * @mbggenerated
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lian_withdraw_log.bank_card
     *
     * @return the value of lian_withdraw_log.bank_card
     *
     * @mbggenerated
     */
    public String getBankCard() {
        return bankCard;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lian_withdraw_log.bank_card
     *
     * @param bankCard the value for lian_withdraw_log.bank_card
     *
     * @mbggenerated
     */
    public void setBankCard(String bankCard) {
        this.bankCard = bankCard == null ? null : bankCard.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lian_withdraw_log.lian_bank_code
     *
     * @return the value of lian_withdraw_log.lian_bank_code
     *
     * @mbggenerated
     */
    public String getLianBankCode() {
        return lianBankCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lian_withdraw_log.lian_bank_code
     *
     * @param lianBankCode the value for lian_withdraw_log.lian_bank_code
     *
     * @mbggenerated
     */
    public void setLianBankCode(String lianBankCode) {
        this.lianBankCode = lianBankCode == null ? null : lianBankCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lian_withdraw_log.bank_name
     *
     * @return the value of lian_withdraw_log.bank_name
     *
     * @mbggenerated
     */
    public String getBankName() {
        return bankName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lian_withdraw_log.bank_name
     *
     * @param bankName the value for lian_withdraw_log.bank_name
     *
     * @mbggenerated
     */
    public void setBankName(String bankName) {
        this.bankName = bankName == null ? null : bankName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lian_withdraw_log.order_info
     *
     * @return the value of lian_withdraw_log.order_info
     *
     * @mbggenerated
     */
    public String getOrderInfo() {
        return orderInfo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lian_withdraw_log.order_info
     *
     * @param orderInfo the value for lian_withdraw_log.order_info
     *
     * @mbggenerated
     */
    public void setOrderInfo(String orderInfo) {
        this.orderInfo = orderInfo == null ? null : orderInfo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lian_withdraw_log.create_time
     *
     * @return the value of lian_withdraw_log.create_time
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lian_withdraw_log.create_time
     *
     * @param createTime the value for lian_withdraw_log.create_time
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lian_withdraw_log.sync_ret_code
     *
     * @return the value of lian_withdraw_log.sync_ret_code
     *
     * @mbggenerated
     */
    public String getSyncRetCode() {
        return syncRetCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lian_withdraw_log.sync_ret_code
     *
     * @param syncRetCode the value for lian_withdraw_log.sync_ret_code
     *
     * @mbggenerated
     */
    public void setSyncRetCode(String syncRetCode) {
        this.syncRetCode = syncRetCode == null ? null : syncRetCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lian_withdraw_log.sync_ret_msg
     *
     * @return the value of lian_withdraw_log.sync_ret_msg
     *
     * @mbggenerated
     */
    public String getSyncRetMsg() {
        return syncRetMsg;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lian_withdraw_log.sync_ret_msg
     *
     * @param syncRetMsg the value for lian_withdraw_log.sync_ret_msg
     *
     * @mbggenerated
     */
    public void setSyncRetMsg(String syncRetMsg) {
        this.syncRetMsg = syncRetMsg == null ? null : syncRetMsg.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lian_withdraw_log.asyn_ret_time
     *
     * @return the value of lian_withdraw_log.asyn_ret_time
     *
     * @mbggenerated
     */
    public Date getAsynRetTime() {
        return asynRetTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lian_withdraw_log.asyn_ret_time
     *
     * @param asynRetTime the value for lian_withdraw_log.asyn_ret_time
     *
     * @mbggenerated
     */
    public void setAsynRetTime(Date asynRetTime) {
        this.asynRetTime = asynRetTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lian_withdraw_log.asyn_ret_code
     *
     * @return the value of lian_withdraw_log.asyn_ret_code
     *
     * @mbggenerated
     */
    public String getAsynRetCode() {
        return asynRetCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lian_withdraw_log.asyn_ret_code
     *
     * @param asynRetCode the value for lian_withdraw_log.asyn_ret_code
     *
     * @mbggenerated
     */
    public void setAsynRetCode(String asynRetCode) {
        this.asynRetCode = asynRetCode == null ? null : asynRetCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lian_withdraw_log.lian_pay_no
     *
     * @return the value of lian_withdraw_log.lian_pay_no
     *
     * @mbggenerated
     */
    public String getLianPayNo() {
        return lianPayNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lian_withdraw_log.lian_pay_no
     *
     * @param lianPayNo the value for lian_withdraw_log.lian_pay_no
     *
     * @mbggenerated
     */
    public void setLianPayNo(String lianPayNo) {
        this.lianPayNo = lianPayNo == null ? null : lianPayNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lian_withdraw_log.settle_date
     *
     * @return the value of lian_withdraw_log.settle_date
     *
     * @mbggenerated
     */
    public String getSettleDate() {
        return settleDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lian_withdraw_log.settle_date
     *
     * @param settleDate the value for lian_withdraw_log.settle_date
     *
     * @mbggenerated
     */
    public void setSettleDate(String settleDate) {
        this.settleDate = settleDate == null ? null : settleDate.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lian_withdraw_log.status
     *
     * @return the value of lian_withdraw_log.status
     *
     * @mbggenerated
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lian_withdraw_log.status
     *
     * @param status the value for lian_withdraw_log.status
     *
     * @mbggenerated
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lian_withdraw_log.province_code
     *
     * @return the value of lian_withdraw_log.province_code
     *
     * @mbggenerated
     */
    public String getProvinceCode() {
        return provinceCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lian_withdraw_log.province_code
     *
     * @param provinceCode the value for lian_withdraw_log.province_code
     *
     * @mbggenerated
     */
    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode == null ? null : provinceCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lian_withdraw_log.city_code
     *
     * @return the value of lian_withdraw_log.city_code
     *
     * @mbggenerated
     */
    public String getCityCode() {
        return cityCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lian_withdraw_log.city_code
     *
     * @param cityCode the value for lian_withdraw_log.city_code
     *
     * @mbggenerated
     */
    public void setCityCode(String cityCode) {
        this.cityCode = cityCode == null ? null : cityCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lian_withdraw_log.brabank_name
     *
     * @return the value of lian_withdraw_log.brabank_name
     *
     * @mbggenerated
     */
    public String getBrabankName() {
        return brabankName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lian_withdraw_log.brabank_name
     *
     * @param brabankName the value for lian_withdraw_log.brabank_name
     *
     * @mbggenerated
     */
    public void setBrabankName(String brabankName) {
        this.brabankName = brabankName == null ? null : brabankName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lian_withdraw_log.verify_status
     *
     * @return the value of lian_withdraw_log.verify_status
     *
     * @mbggenerated
     */
    public String getVerifyStatus() {
        return verifyStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lian_withdraw_log.verify_status
     *
     * @param verifyStatus the value for lian_withdraw_log.verify_status
     *
     * @mbggenerated
     */
    public void setVerifyStatus(String verifyStatus) {
        this.verifyStatus = verifyStatus == null ? null : verifyStatus.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lian_withdraw_log.notify_url
     *
     * @return the value of lian_withdraw_log.notify_url
     *
     * @mbggenerated
     */
    public String getNotifyUrl() {
        return notifyUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lian_withdraw_log.notify_url
     *
     * @param notifyUrl the value for lian_withdraw_log.notify_url
     *
     * @mbggenerated
     */
    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl == null ? null : notifyUrl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lian_withdraw_log
     *
     * @mbggenerated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", lianWithdrawLogId=").append(lianWithdrawLogId);
        sb.append(", userId=").append(userId);
        sb.append(", orderNo=").append(orderNo);
        sb.append(", orderDate=").append(orderDate);
        sb.append(", amount=").append(amount);
        sb.append(", bankCard=").append(bankCard);
        sb.append(", lianBankCode=").append(lianBankCode);
        sb.append(", bankName=").append(bankName);
        sb.append(", orderInfo=").append(orderInfo);
        sb.append(", createTime=").append(createTime);
        sb.append(", syncRetCode=").append(syncRetCode);
        sb.append(", syncRetMsg=").append(syncRetMsg);
        sb.append(", asynRetTime=").append(asynRetTime);
        sb.append(", asynRetCode=").append(asynRetCode);
        sb.append(", lianPayNo=").append(lianPayNo);
        sb.append(", settleDate=").append(settleDate);
        sb.append(", status=").append(status);
        sb.append(", provinceCode=").append(provinceCode);
        sb.append(", cityCode=").append(cityCode);
        sb.append(", brabankName=").append(brabankName);
        sb.append(", verifyStatus=").append(verifyStatus);
        sb.append(", notifyUrl=").append(notifyUrl);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lian_withdraw_log
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
        LianWithdrawLog other = (LianWithdrawLog) that;
        return (this.getLianWithdrawLogId() == null ? other.getLianWithdrawLogId() == null : this.getLianWithdrawLogId().equals(other.getLianWithdrawLogId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getOrderNo() == null ? other.getOrderNo() == null : this.getOrderNo().equals(other.getOrderNo()))
            && (this.getOrderDate() == null ? other.getOrderDate() == null : this.getOrderDate().equals(other.getOrderDate()))
            && (this.getAmount() == null ? other.getAmount() == null : this.getAmount().equals(other.getAmount()))
            && (this.getBankCard() == null ? other.getBankCard() == null : this.getBankCard().equals(other.getBankCard()))
            && (this.getLianBankCode() == null ? other.getLianBankCode() == null : this.getLianBankCode().equals(other.getLianBankCode()))
            && (this.getBankName() == null ? other.getBankName() == null : this.getBankName().equals(other.getBankName()))
            && (this.getOrderInfo() == null ? other.getOrderInfo() == null : this.getOrderInfo().equals(other.getOrderInfo()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getSyncRetCode() == null ? other.getSyncRetCode() == null : this.getSyncRetCode().equals(other.getSyncRetCode()))
            && (this.getSyncRetMsg() == null ? other.getSyncRetMsg() == null : this.getSyncRetMsg().equals(other.getSyncRetMsg()))
            && (this.getAsynRetTime() == null ? other.getAsynRetTime() == null : this.getAsynRetTime().equals(other.getAsynRetTime()))
            && (this.getAsynRetCode() == null ? other.getAsynRetCode() == null : this.getAsynRetCode().equals(other.getAsynRetCode()))
            && (this.getLianPayNo() == null ? other.getLianPayNo() == null : this.getLianPayNo().equals(other.getLianPayNo()))
            && (this.getSettleDate() == null ? other.getSettleDate() == null : this.getSettleDate().equals(other.getSettleDate()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getProvinceCode() == null ? other.getProvinceCode() == null : this.getProvinceCode().equals(other.getProvinceCode()))
            && (this.getCityCode() == null ? other.getCityCode() == null : this.getCityCode().equals(other.getCityCode()))
            && (this.getBrabankName() == null ? other.getBrabankName() == null : this.getBrabankName().equals(other.getBrabankName()))
            && (this.getVerifyStatus() == null ? other.getVerifyStatus() == null : this.getVerifyStatus().equals(other.getVerifyStatus()))
            && (this.getNotifyUrl() == null ? other.getNotifyUrl() == null : this.getNotifyUrl().equals(other.getNotifyUrl()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lian_withdraw_log
     *
     * @mbggenerated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getLianWithdrawLogId() == null) ? 0 : getLianWithdrawLogId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getOrderNo() == null) ? 0 : getOrderNo().hashCode());
        result = prime * result + ((getOrderDate() == null) ? 0 : getOrderDate().hashCode());
        result = prime * result + ((getAmount() == null) ? 0 : getAmount().hashCode());
        result = prime * result + ((getBankCard() == null) ? 0 : getBankCard().hashCode());
        result = prime * result + ((getLianBankCode() == null) ? 0 : getLianBankCode().hashCode());
        result = prime * result + ((getBankName() == null) ? 0 : getBankName().hashCode());
        result = prime * result + ((getOrderInfo() == null) ? 0 : getOrderInfo().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getSyncRetCode() == null) ? 0 : getSyncRetCode().hashCode());
        result = prime * result + ((getSyncRetMsg() == null) ? 0 : getSyncRetMsg().hashCode());
        result = prime * result + ((getAsynRetTime() == null) ? 0 : getAsynRetTime().hashCode());
        result = prime * result + ((getAsynRetCode() == null) ? 0 : getAsynRetCode().hashCode());
        result = prime * result + ((getLianPayNo() == null) ? 0 : getLianPayNo().hashCode());
        result = prime * result + ((getSettleDate() == null) ? 0 : getSettleDate().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getProvinceCode() == null) ? 0 : getProvinceCode().hashCode());
        result = prime * result + ((getCityCode() == null) ? 0 : getCityCode().hashCode());
        result = prime * result + ((getBrabankName() == null) ? 0 : getBrabankName().hashCode());
        result = prime * result + ((getVerifyStatus() == null) ? 0 : getVerifyStatus().hashCode());
        result = prime * result + ((getNotifyUrl() == null) ? 0 : getNotifyUrl().hashCode());
        return result;
    }
}