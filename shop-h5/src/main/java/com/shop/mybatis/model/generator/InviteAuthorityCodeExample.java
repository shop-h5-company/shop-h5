package com.shop.mybatis.model.generator;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InviteAuthorityCodeExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table invite_authority_code
     *
     * @mbggenerated Mon May 21 17:26:34 CST 2018
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table invite_authority_code
     *
     * @mbggenerated Mon May 21 17:26:34 CST 2018
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table invite_authority_code
     *
     * @mbggenerated Mon May 21 17:26:34 CST 2018
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table invite_authority_code
     *
     * @mbggenerated Mon May 21 17:26:34 CST 2018
     */
    public InviteAuthorityCodeExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table invite_authority_code
     *
     * @mbggenerated Mon May 21 17:26:34 CST 2018
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table invite_authority_code
     *
     * @mbggenerated Mon May 21 17:26:34 CST 2018
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table invite_authority_code
     *
     * @mbggenerated Mon May 21 17:26:34 CST 2018
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table invite_authority_code
     *
     * @mbggenerated Mon May 21 17:26:34 CST 2018
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table invite_authority_code
     *
     * @mbggenerated Mon May 21 17:26:34 CST 2018
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table invite_authority_code
     *
     * @mbggenerated Mon May 21 17:26:34 CST 2018
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table invite_authority_code
     *
     * @mbggenerated Mon May 21 17:26:34 CST 2018
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table invite_authority_code
     *
     * @mbggenerated Mon May 21 17:26:34 CST 2018
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table invite_authority_code
     *
     * @mbggenerated Mon May 21 17:26:34 CST 2018
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table invite_authority_code
     *
     * @mbggenerated Mon May 21 17:26:34 CST 2018
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table invite_authority_code
     *
     * @mbggenerated Mon May 21 17:26:34 CST 2018
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andInviteCodeIsNull() {
            addCriterion("invite_code is null");
            return (Criteria) this;
        }

        public Criteria andInviteCodeIsNotNull() {
            addCriterion("invite_code is not null");
            return (Criteria) this;
        }

        public Criteria andInviteCodeEqualTo(String value) {
            addCriterion("invite_code =", value, "inviteCode");
            return (Criteria) this;
        }

        public Criteria andInviteCodeNotEqualTo(String value) {
            addCriterion("invite_code <>", value, "inviteCode");
            return (Criteria) this;
        }

        public Criteria andInviteCodeGreaterThan(String value) {
            addCriterion("invite_code >", value, "inviteCode");
            return (Criteria) this;
        }

        public Criteria andInviteCodeGreaterThanOrEqualTo(String value) {
            addCriterion("invite_code >=", value, "inviteCode");
            return (Criteria) this;
        }

        public Criteria andInviteCodeLessThan(String value) {
            addCriterion("invite_code <", value, "inviteCode");
            return (Criteria) this;
        }

        public Criteria andInviteCodeLessThanOrEqualTo(String value) {
            addCriterion("invite_code <=", value, "inviteCode");
            return (Criteria) this;
        }

        public Criteria andInviteCodeLike(String value) {
            addCriterion("invite_code like", value, "inviteCode");
            return (Criteria) this;
        }

        public Criteria andInviteCodeNotLike(String value) {
            addCriterion("invite_code not like", value, "inviteCode");
            return (Criteria) this;
        }

        public Criteria andInviteCodeIn(List<String> values) {
            addCriterion("invite_code in", values, "inviteCode");
            return (Criteria) this;
        }

        public Criteria andInviteCodeNotIn(List<String> values) {
            addCriterion("invite_code not in", values, "inviteCode");
            return (Criteria) this;
        }

        public Criteria andInviteCodeBetween(String value1, String value2) {
            addCriterion("invite_code between", value1, value2, "inviteCode");
            return (Criteria) this;
        }

        public Criteria andInviteCodeNotBetween(String value1, String value2) {
            addCriterion("invite_code not between", value1, value2, "inviteCode");
            return (Criteria) this;
        }

        public Criteria andInvitePersonNumIsNull() {
            addCriterion("invite_person_num is null");
            return (Criteria) this;
        }

        public Criteria andInvitePersonNumIsNotNull() {
            addCriterion("invite_person_num is not null");
            return (Criteria) this;
        }

        public Criteria andInvitePersonNumEqualTo(Integer value) {
            addCriterion("invite_person_num =", value, "invitePersonNum");
            return (Criteria) this;
        }

        public Criteria andInvitePersonNumNotEqualTo(Integer value) {
            addCriterion("invite_person_num <>", value, "invitePersonNum");
            return (Criteria) this;
        }

        public Criteria andInvitePersonNumGreaterThan(Integer value) {
            addCriterion("invite_person_num >", value, "invitePersonNum");
            return (Criteria) this;
        }

        public Criteria andInvitePersonNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("invite_person_num >=", value, "invitePersonNum");
            return (Criteria) this;
        }

        public Criteria andInvitePersonNumLessThan(Integer value) {
            addCriterion("invite_person_num <", value, "invitePersonNum");
            return (Criteria) this;
        }

        public Criteria andInvitePersonNumLessThanOrEqualTo(Integer value) {
            addCriterion("invite_person_num <=", value, "invitePersonNum");
            return (Criteria) this;
        }

        public Criteria andInvitePersonNumIn(List<Integer> values) {
            addCriterion("invite_person_num in", values, "invitePersonNum");
            return (Criteria) this;
        }

        public Criteria andInvitePersonNumNotIn(List<Integer> values) {
            addCriterion("invite_person_num not in", values, "invitePersonNum");
            return (Criteria) this;
        }

        public Criteria andInvitePersonNumBetween(Integer value1, Integer value2) {
            addCriterion("invite_person_num between", value1, value2, "invitePersonNum");
            return (Criteria) this;
        }

        public Criteria andInvitePersonNumNotBetween(Integer value1, Integer value2) {
            addCriterion("invite_person_num not between", value1, value2, "invitePersonNum");
            return (Criteria) this;
        }

        public Criteria andTelephoneBuyIsNull() {
            addCriterion("telephone_buy is null");
            return (Criteria) this;
        }

        public Criteria andTelephoneBuyIsNotNull() {
            addCriterion("telephone_buy is not null");
            return (Criteria) this;
        }

        public Criteria andTelephoneBuyEqualTo(String value) {
            addCriterion("telephone_buy =", value, "telephoneBuy");
            return (Criteria) this;
        }

        public Criteria andTelephoneBuyNotEqualTo(String value) {
            addCriterion("telephone_buy <>", value, "telephoneBuy");
            return (Criteria) this;
        }

        public Criteria andTelephoneBuyGreaterThan(String value) {
            addCriterion("telephone_buy >", value, "telephoneBuy");
            return (Criteria) this;
        }

        public Criteria andTelephoneBuyGreaterThanOrEqualTo(String value) {
            addCriterion("telephone_buy >=", value, "telephoneBuy");
            return (Criteria) this;
        }

        public Criteria andTelephoneBuyLessThan(String value) {
            addCriterion("telephone_buy <", value, "telephoneBuy");
            return (Criteria) this;
        }

        public Criteria andTelephoneBuyLessThanOrEqualTo(String value) {
            addCriterion("telephone_buy <=", value, "telephoneBuy");
            return (Criteria) this;
        }

        public Criteria andTelephoneBuyLike(String value) {
            addCriterion("telephone_buy like", value, "telephoneBuy");
            return (Criteria) this;
        }

        public Criteria andTelephoneBuyNotLike(String value) {
            addCriterion("telephone_buy not like", value, "telephoneBuy");
            return (Criteria) this;
        }

        public Criteria andTelephoneBuyIn(List<String> values) {
            addCriterion("telephone_buy in", values, "telephoneBuy");
            return (Criteria) this;
        }

        public Criteria andTelephoneBuyNotIn(List<String> values) {
            addCriterion("telephone_buy not in", values, "telephoneBuy");
            return (Criteria) this;
        }

        public Criteria andTelephoneBuyBetween(String value1, String value2) {
            addCriterion("telephone_buy between", value1, value2, "telephoneBuy");
            return (Criteria) this;
        }

        public Criteria andTelephoneBuyNotBetween(String value1, String value2) {
            addCriterion("telephone_buy not between", value1, value2, "telephoneBuy");
            return (Criteria) this;
        }

        public Criteria andTelephoneUseIsNull() {
            addCriterion("telephone_use is null");
            return (Criteria) this;
        }

        public Criteria andTelephoneUseIsNotNull() {
            addCriterion("telephone_use is not null");
            return (Criteria) this;
        }

        public Criteria andTelephoneUseEqualTo(String value) {
            addCriterion("telephone_use =", value, "telephoneUse");
            return (Criteria) this;
        }

        public Criteria andTelephoneUseNotEqualTo(String value) {
            addCriterion("telephone_use <>", value, "telephoneUse");
            return (Criteria) this;
        }

        public Criteria andTelephoneUseGreaterThan(String value) {
            addCriterion("telephone_use >", value, "telephoneUse");
            return (Criteria) this;
        }

        public Criteria andTelephoneUseGreaterThanOrEqualTo(String value) {
            addCriterion("telephone_use >=", value, "telephoneUse");
            return (Criteria) this;
        }

        public Criteria andTelephoneUseLessThan(String value) {
            addCriterion("telephone_use <", value, "telephoneUse");
            return (Criteria) this;
        }

        public Criteria andTelephoneUseLessThanOrEqualTo(String value) {
            addCriterion("telephone_use <=", value, "telephoneUse");
            return (Criteria) this;
        }

        public Criteria andTelephoneUseLike(String value) {
            addCriterion("telephone_use like", value, "telephoneUse");
            return (Criteria) this;
        }

        public Criteria andTelephoneUseNotLike(String value) {
            addCriterion("telephone_use not like", value, "telephoneUse");
            return (Criteria) this;
        }

        public Criteria andTelephoneUseIn(List<String> values) {
            addCriterion("telephone_use in", values, "telephoneUse");
            return (Criteria) this;
        }

        public Criteria andTelephoneUseNotIn(List<String> values) {
            addCriterion("telephone_use not in", values, "telephoneUse");
            return (Criteria) this;
        }

        public Criteria andTelephoneUseBetween(String value1, String value2) {
            addCriterion("telephone_use between", value1, value2, "telephoneUse");
            return (Criteria) this;
        }

        public Criteria andTelephoneUseNotBetween(String value1, String value2) {
            addCriterion("telephone_use not between", value1, value2, "telephoneUse");
            return (Criteria) this;
        }

        public Criteria andBatchNumIsNull() {
            addCriterion("batch_num is null");
            return (Criteria) this;
        }

        public Criteria andBatchNumIsNotNull() {
            addCriterion("batch_num is not null");
            return (Criteria) this;
        }

        public Criteria andBatchNumEqualTo(String value) {
            addCriterion("batch_num =", value, "batchNum");
            return (Criteria) this;
        }

        public Criteria andBatchNumNotEqualTo(String value) {
            addCriterion("batch_num <>", value, "batchNum");
            return (Criteria) this;
        }

        public Criteria andBatchNumGreaterThan(String value) {
            addCriterion("batch_num >", value, "batchNum");
            return (Criteria) this;
        }

        public Criteria andBatchNumGreaterThanOrEqualTo(String value) {
            addCriterion("batch_num >=", value, "batchNum");
            return (Criteria) this;
        }

        public Criteria andBatchNumLessThan(String value) {
            addCriterion("batch_num <", value, "batchNum");
            return (Criteria) this;
        }

        public Criteria andBatchNumLessThanOrEqualTo(String value) {
            addCriterion("batch_num <=", value, "batchNum");
            return (Criteria) this;
        }

        public Criteria andBatchNumLike(String value) {
            addCriterion("batch_num like", value, "batchNum");
            return (Criteria) this;
        }

        public Criteria andBatchNumNotLike(String value) {
            addCriterion("batch_num not like", value, "batchNum");
            return (Criteria) this;
        }

        public Criteria andBatchNumIn(List<String> values) {
            addCriterion("batch_num in", values, "batchNum");
            return (Criteria) this;
        }

        public Criteria andBatchNumNotIn(List<String> values) {
            addCriterion("batch_num not in", values, "batchNum");
            return (Criteria) this;
        }

        public Criteria andBatchNumBetween(String value1, String value2) {
            addCriterion("batch_num between", value1, value2, "batchNum");
            return (Criteria) this;
        }

        public Criteria andBatchNumNotBetween(String value1, String value2) {
            addCriterion("batch_num not between", value1, value2, "batchNum");
            return (Criteria) this;
        }

        public Criteria andTimeBuyIsNull() {
            addCriterion("time_buy is null");
            return (Criteria) this;
        }

        public Criteria andTimeBuyIsNotNull() {
            addCriterion("time_buy is not null");
            return (Criteria) this;
        }

        public Criteria andTimeBuyEqualTo(Date value) {
            addCriterion("time_buy =", value, "timeBuy");
            return (Criteria) this;
        }

        public Criteria andTimeBuyNotEqualTo(Date value) {
            addCriterion("time_buy <>", value, "timeBuy");
            return (Criteria) this;
        }

        public Criteria andTimeBuyGreaterThan(Date value) {
            addCriterion("time_buy >", value, "timeBuy");
            return (Criteria) this;
        }

        public Criteria andTimeBuyGreaterThanOrEqualTo(Date value) {
            addCriterion("time_buy >=", value, "timeBuy");
            return (Criteria) this;
        }

        public Criteria andTimeBuyLessThan(Date value) {
            addCriterion("time_buy <", value, "timeBuy");
            return (Criteria) this;
        }

        public Criteria andTimeBuyLessThanOrEqualTo(Date value) {
            addCriterion("time_buy <=", value, "timeBuy");
            return (Criteria) this;
        }

        public Criteria andTimeBuyIn(List<Date> values) {
            addCriterion("time_buy in", values, "timeBuy");
            return (Criteria) this;
        }

        public Criteria andTimeBuyNotIn(List<Date> values) {
            addCriterion("time_buy not in", values, "timeBuy");
            return (Criteria) this;
        }

        public Criteria andTimeBuyBetween(Date value1, Date value2) {
            addCriterion("time_buy between", value1, value2, "timeBuy");
            return (Criteria) this;
        }

        public Criteria andTimeBuyNotBetween(Date value1, Date value2) {
            addCriterion("time_buy not between", value1, value2, "timeBuy");
            return (Criteria) this;
        }

        public Criteria andTimeUsedIsNull() {
            addCriterion("time_used is null");
            return (Criteria) this;
        }

        public Criteria andTimeUsedIsNotNull() {
            addCriterion("time_used is not null");
            return (Criteria) this;
        }

        public Criteria andTimeUsedEqualTo(Date value) {
            addCriterion("time_used =", value, "timeUsed");
            return (Criteria) this;
        }

        public Criteria andTimeUsedNotEqualTo(Date value) {
            addCriterion("time_used <>", value, "timeUsed");
            return (Criteria) this;
        }

        public Criteria andTimeUsedGreaterThan(Date value) {
            addCriterion("time_used >", value, "timeUsed");
            return (Criteria) this;
        }

        public Criteria andTimeUsedGreaterThanOrEqualTo(Date value) {
            addCriterion("time_used >=", value, "timeUsed");
            return (Criteria) this;
        }

        public Criteria andTimeUsedLessThan(Date value) {
            addCriterion("time_used <", value, "timeUsed");
            return (Criteria) this;
        }

        public Criteria andTimeUsedLessThanOrEqualTo(Date value) {
            addCriterion("time_used <=", value, "timeUsed");
            return (Criteria) this;
        }

        public Criteria andTimeUsedIn(List<Date> values) {
            addCriterion("time_used in", values, "timeUsed");
            return (Criteria) this;
        }

        public Criteria andTimeUsedNotIn(List<Date> values) {
            addCriterion("time_used not in", values, "timeUsed");
            return (Criteria) this;
        }

        public Criteria andTimeUsedBetween(Date value1, Date value2) {
            addCriterion("time_used between", value1, value2, "timeUsed");
            return (Criteria) this;
        }

        public Criteria andTimeUsedNotBetween(Date value1, Date value2) {
            addCriterion("time_used not between", value1, value2, "timeUsed");
            return (Criteria) this;
        }

        public Criteria andUsedIsNull() {
            addCriterion("used is null");
            return (Criteria) this;
        }

        public Criteria andUsedIsNotNull() {
            addCriterion("used is not null");
            return (Criteria) this;
        }

        public Criteria andUsedEqualTo(String value) {
            addCriterion("used =", value, "used");
            return (Criteria) this;
        }

        public Criteria andUsedNotEqualTo(String value) {
            addCriterion("used <>", value, "used");
            return (Criteria) this;
        }

        public Criteria andUsedGreaterThan(String value) {
            addCriterion("used >", value, "used");
            return (Criteria) this;
        }

        public Criteria andUsedGreaterThanOrEqualTo(String value) {
            addCriterion("used >=", value, "used");
            return (Criteria) this;
        }

        public Criteria andUsedLessThan(String value) {
            addCriterion("used <", value, "used");
            return (Criteria) this;
        }

        public Criteria andUsedLessThanOrEqualTo(String value) {
            addCriterion("used <=", value, "used");
            return (Criteria) this;
        }

        public Criteria andUsedLike(String value) {
            addCriterion("used like", value, "used");
            return (Criteria) this;
        }

        public Criteria andUsedNotLike(String value) {
            addCriterion("used not like", value, "used");
            return (Criteria) this;
        }

        public Criteria andUsedIn(List<String> values) {
            addCriterion("used in", values, "used");
            return (Criteria) this;
        }

        public Criteria andUsedNotIn(List<String> values) {
            addCriterion("used not in", values, "used");
            return (Criteria) this;
        }

        public Criteria andUsedBetween(String value1, String value2) {
            addCriterion("used between", value1, value2, "used");
            return (Criteria) this;
        }

        public Criteria andUsedNotBetween(String value1, String value2) {
            addCriterion("used not between", value1, value2, "used");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table invite_authority_code
     *
     * @mbggenerated do_not_delete_during_merge Mon May 21 17:26:34 CST 2018
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table invite_authority_code
     *
     * @mbggenerated Mon May 21 17:26:34 CST 2018
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}