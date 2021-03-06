package com.p2g.mybatis.model.generator;

import java.io.Serializable;
import java.util.Date;

public class LianAccount implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lian_account.user_id
     *
     * @mbggenerated
     */
    private Long userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lian_account.agree_no
     *
     * @mbggenerated
     */
    private String agreeNo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lian_account.lian_bank_code
     *
     * @mbggenerated
     */
    private String lianBankCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lian_account.bank_card
     *
     * @mbggenerated
     */
    private String bankCard;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lian_account.province_code
     *
     * @mbggenerated
     */
    private String provinceCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lian_account.city_code
     *
     * @mbggenerated
     */
    private String cityCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lian_account.brabank_name
     *
     * @mbggenerated
     */
    private String brabankName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lian_account.create_time
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lian_account.update_time
     *
     * @mbggenerated
     */
    private Date updateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table lian_account
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lian_account.user_id
     *
     * @return the value of lian_account.user_id
     *
     * @mbggenerated
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lian_account.user_id
     *
     * @param userId the value for lian_account.user_id
     *
     * @mbggenerated
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lian_account.agree_no
     *
     * @return the value of lian_account.agree_no
     *
     * @mbggenerated
     */
    public String getAgreeNo() {
        return agreeNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lian_account.agree_no
     *
     * @param agreeNo the value for lian_account.agree_no
     *
     * @mbggenerated
     */
    public void setAgreeNo(String agreeNo) {
        this.agreeNo = agreeNo == null ? null : agreeNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lian_account.lian_bank_code
     *
     * @return the value of lian_account.lian_bank_code
     *
     * @mbggenerated
     */
    public String getLianBankCode() {
        return lianBankCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lian_account.lian_bank_code
     *
     * @param lianBankCode the value for lian_account.lian_bank_code
     *
     * @mbggenerated
     */
    public void setLianBankCode(String lianBankCode) {
        this.lianBankCode = lianBankCode == null ? null : lianBankCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lian_account.bank_card
     *
     * @return the value of lian_account.bank_card
     *
     * @mbggenerated
     */
    public String getBankCard() {
        return bankCard;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lian_account.bank_card
     *
     * @param bankCard the value for lian_account.bank_card
     *
     * @mbggenerated
     */
    public void setBankCard(String bankCard) {
        this.bankCard = bankCard == null ? null : bankCard.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lian_account.province_code
     *
     * @return the value of lian_account.province_code
     *
     * @mbggenerated
     */
    public String getProvinceCode() {
        return provinceCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lian_account.province_code
     *
     * @param provinceCode the value for lian_account.province_code
     *
     * @mbggenerated
     */
    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode == null ? null : provinceCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lian_account.city_code
     *
     * @return the value of lian_account.city_code
     *
     * @mbggenerated
     */
    public String getCityCode() {
        return cityCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lian_account.city_code
     *
     * @param cityCode the value for lian_account.city_code
     *
     * @mbggenerated
     */
    public void setCityCode(String cityCode) {
        this.cityCode = cityCode == null ? null : cityCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lian_account.brabank_name
     *
     * @return the value of lian_account.brabank_name
     *
     * @mbggenerated
     */
    public String getBrabankName() {
        return brabankName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lian_account.brabank_name
     *
     * @param brabankName the value for lian_account.brabank_name
     *
     * @mbggenerated
     */
    public void setBrabankName(String brabankName) {
        this.brabankName = brabankName == null ? null : brabankName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lian_account.create_time
     *
     * @return the value of lian_account.create_time
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lian_account.create_time
     *
     * @param createTime the value for lian_account.create_time
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lian_account.update_time
     *
     * @return the value of lian_account.update_time
     *
     * @mbggenerated
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lian_account.update_time
     *
     * @param updateTime the value for lian_account.update_time
     *
     * @mbggenerated
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lian_account
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
        sb.append(", agreeNo=").append(agreeNo);
        sb.append(", lianBankCode=").append(lianBankCode);
        sb.append(", bankCard=").append(bankCard);
        sb.append(", provinceCode=").append(provinceCode);
        sb.append(", cityCode=").append(cityCode);
        sb.append(", brabankName=").append(brabankName);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lian_account
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
        LianAccount other = (LianAccount) that;
        return (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getAgreeNo() == null ? other.getAgreeNo() == null : this.getAgreeNo().equals(other.getAgreeNo()))
            && (this.getLianBankCode() == null ? other.getLianBankCode() == null : this.getLianBankCode().equals(other.getLianBankCode()))
            && (this.getBankCard() == null ? other.getBankCard() == null : this.getBankCard().equals(other.getBankCard()))
            && (this.getProvinceCode() == null ? other.getProvinceCode() == null : this.getProvinceCode().equals(other.getProvinceCode()))
            && (this.getCityCode() == null ? other.getCityCode() == null : this.getCityCode().equals(other.getCityCode()))
            && (this.getBrabankName() == null ? other.getBrabankName() == null : this.getBrabankName().equals(other.getBrabankName()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lian_account
     *
     * @mbggenerated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getAgreeNo() == null) ? 0 : getAgreeNo().hashCode());
        result = prime * result + ((getLianBankCode() == null) ? 0 : getLianBankCode().hashCode());
        result = prime * result + ((getBankCard() == null) ? 0 : getBankCard().hashCode());
        result = prime * result + ((getProvinceCode() == null) ? 0 : getProvinceCode().hashCode());
        result = prime * result + ((getCityCode() == null) ? 0 : getCityCode().hashCode());
        result = prime * result + ((getBrabankName() == null) ? 0 : getBrabankName().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }
}