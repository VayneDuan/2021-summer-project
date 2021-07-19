package com.example.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GymEquipmentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GymEquipmentExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andDetailIsNull() {
            addCriterion("detail is null");
            return (Criteria) this;
        }

        public Criteria andDetailIsNotNull() {
            addCriterion("detail is not null");
            return (Criteria) this;
        }

        public Criteria andDetailEqualTo(String value) {
            addCriterion("detail =", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailNotEqualTo(String value) {
            addCriterion("detail <>", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailGreaterThan(String value) {
            addCriterion("detail >", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailGreaterThanOrEqualTo(String value) {
            addCriterion("detail >=", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailLessThan(String value) {
            addCriterion("detail <", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailLessThanOrEqualTo(String value) {
            addCriterion("detail <=", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailLike(String value) {
            addCriterion("detail like", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailNotLike(String value) {
            addCriterion("detail not like", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailIn(List<String> values) {
            addCriterion("detail in", values, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailNotIn(List<String> values) {
            addCriterion("detail not in", values, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailBetween(String value1, String value2) {
            addCriterion("detail between", value1, value2, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailNotBetween(String value1, String value2) {
            addCriterion("detail not between", value1, value2, "detail");
            return (Criteria) this;
        }

        public Criteria andTimeUsageHourIsNull() {
            addCriterion("time_usage_hour is null");
            return (Criteria) this;
        }

        public Criteria andTimeUsageHourIsNotNull() {
            addCriterion("time_usage_hour is not null");
            return (Criteria) this;
        }

        public Criteria andTimeUsageHourEqualTo(Long value) {
            addCriterion("time_usage_hour =", value, "timeUsageHour");
            return (Criteria) this;
        }

        public Criteria andTimeUsageHourNotEqualTo(Long value) {
            addCriterion("time_usage_hour <>", value, "timeUsageHour");
            return (Criteria) this;
        }

        public Criteria andTimeUsageHourGreaterThan(Long value) {
            addCriterion("time_usage_hour >", value, "timeUsageHour");
            return (Criteria) this;
        }

        public Criteria andTimeUsageHourGreaterThanOrEqualTo(Long value) {
            addCriterion("time_usage_hour >=", value, "timeUsageHour");
            return (Criteria) this;
        }

        public Criteria andTimeUsageHourLessThan(Long value) {
            addCriterion("time_usage_hour <", value, "timeUsageHour");
            return (Criteria) this;
        }

        public Criteria andTimeUsageHourLessThanOrEqualTo(Long value) {
            addCriterion("time_usage_hour <=", value, "timeUsageHour");
            return (Criteria) this;
        }

        public Criteria andTimeUsageHourIn(List<Long> values) {
            addCriterion("time_usage_hour in", values, "timeUsageHour");
            return (Criteria) this;
        }

        public Criteria andTimeUsageHourNotIn(List<Long> values) {
            addCriterion("time_usage_hour not in", values, "timeUsageHour");
            return (Criteria) this;
        }

        public Criteria andTimeUsageHourBetween(Long value1, Long value2) {
            addCriterion("time_usage_hour between", value1, value2, "timeUsageHour");
            return (Criteria) this;
        }

        public Criteria andTimeUsageHourNotBetween(Long value1, Long value2) {
            addCriterion("time_usage_hour not between", value1, value2, "timeUsageHour");
            return (Criteria) this;
        }

        public Criteria andLastUseIsNull() {
            addCriterion("last_use is null");
            return (Criteria) this;
        }

        public Criteria andLastUseIsNotNull() {
            addCriterion("last_use is not null");
            return (Criteria) this;
        }

        public Criteria andLastUseEqualTo(Date value) {
            addCriterion("last_use =", value, "lastUse");
            return (Criteria) this;
        }

        public Criteria andLastUseNotEqualTo(Date value) {
            addCriterion("last_use <>", value, "lastUse");
            return (Criteria) this;
        }

        public Criteria andLastUseGreaterThan(Date value) {
            addCriterion("last_use >", value, "lastUse");
            return (Criteria) this;
        }

        public Criteria andLastUseGreaterThanOrEqualTo(Date value) {
            addCriterion("last_use >=", value, "lastUse");
            return (Criteria) this;
        }

        public Criteria andLastUseLessThan(Date value) {
            addCriterion("last_use <", value, "lastUse");
            return (Criteria) this;
        }

        public Criteria andLastUseLessThanOrEqualTo(Date value) {
            addCriterion("last_use <=", value, "lastUse");
            return (Criteria) this;
        }

        public Criteria andLastUseIn(List<Date> values) {
            addCriterion("last_use in", values, "lastUse");
            return (Criteria) this;
        }

        public Criteria andLastUseNotIn(List<Date> values) {
            addCriterion("last_use not in", values, "lastUse");
            return (Criteria) this;
        }

        public Criteria andLastUseBetween(Date value1, Date value2) {
            addCriterion("last_use between", value1, value2, "lastUse");
            return (Criteria) this;
        }

        public Criteria andLastUseNotBetween(Date value1, Date value2) {
            addCriterion("last_use not between", value1, value2, "lastUse");
            return (Criteria) this;
        }

        public Criteria andMaintainIsNull() {
            addCriterion("maintain is null");
            return (Criteria) this;
        }

        public Criteria andMaintainIsNotNull() {
            addCriterion("maintain is not null");
            return (Criteria) this;
        }

        public Criteria andMaintainEqualTo(String value) {
            addCriterion("maintain =", value, "maintain");
            return (Criteria) this;
        }

        public Criteria andMaintainNotEqualTo(String value) {
            addCriterion("maintain <>", value, "maintain");
            return (Criteria) this;
        }

        public Criteria andMaintainGreaterThan(String value) {
            addCriterion("maintain >", value, "maintain");
            return (Criteria) this;
        }

        public Criteria andMaintainGreaterThanOrEqualTo(String value) {
            addCriterion("maintain >=", value, "maintain");
            return (Criteria) this;
        }

        public Criteria andMaintainLessThan(String value) {
            addCriterion("maintain <", value, "maintain");
            return (Criteria) this;
        }

        public Criteria andMaintainLessThanOrEqualTo(String value) {
            addCriterion("maintain <=", value, "maintain");
            return (Criteria) this;
        }

        public Criteria andMaintainLike(String value) {
            addCriterion("maintain like", value, "maintain");
            return (Criteria) this;
        }

        public Criteria andMaintainNotLike(String value) {
            addCriterion("maintain not like", value, "maintain");
            return (Criteria) this;
        }

        public Criteria andMaintainIn(List<String> values) {
            addCriterion("maintain in", values, "maintain");
            return (Criteria) this;
        }

        public Criteria andMaintainNotIn(List<String> values) {
            addCriterion("maintain not in", values, "maintain");
            return (Criteria) this;
        }

        public Criteria andMaintainBetween(String value1, String value2) {
            addCriterion("maintain between", value1, value2, "maintain");
            return (Criteria) this;
        }

        public Criteria andMaintainNotBetween(String value1, String value2) {
            addCriterion("maintain not between", value1, value2, "maintain");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

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