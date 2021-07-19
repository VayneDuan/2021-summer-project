package com.example.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class GymClassExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GymClassExample() {
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

        protected void addCriterionForJDBCTime(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Time(value.getTime()), property);
        }

        protected void addCriterionForJDBCTime(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Time> timeList = new ArrayList<java.sql.Time>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                timeList.add(new java.sql.Time(iter.next().getTime()));
            }
            addCriterion(condition, timeList, property);
        }

        protected void addCriterionForJDBCTime(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Time(value1.getTime()), new java.sql.Time(value2.getTime()), property);
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

        public Criteria andGymClassNameIsNull() {
            addCriterion("gym_class_name is null");
            return (Criteria) this;
        }

        public Criteria andGymClassNameIsNotNull() {
            addCriterion("gym_class_name is not null");
            return (Criteria) this;
        }

        public Criteria andGymClassNameEqualTo(String value) {
            addCriterion("gym_class_name =", value, "gymClassName");
            return (Criteria) this;
        }

        public Criteria andGymClassNameNotEqualTo(String value) {
            addCriterion("gym_class_name <>", value, "gymClassName");
            return (Criteria) this;
        }

        public Criteria andGymClassNameGreaterThan(String value) {
            addCriterion("gym_class_name >", value, "gymClassName");
            return (Criteria) this;
        }

        public Criteria andGymClassNameGreaterThanOrEqualTo(String value) {
            addCriterion("gym_class_name >=", value, "gymClassName");
            return (Criteria) this;
        }

        public Criteria andGymClassNameLessThan(String value) {
            addCriterion("gym_class_name <", value, "gymClassName");
            return (Criteria) this;
        }

        public Criteria andGymClassNameLessThanOrEqualTo(String value) {
            addCriterion("gym_class_name <=", value, "gymClassName");
            return (Criteria) this;
        }

        public Criteria andGymClassNameLike(String value) {
            addCriterion("gym_class_name like", value, "gymClassName");
            return (Criteria) this;
        }

        public Criteria andGymClassNameNotLike(String value) {
            addCriterion("gym_class_name not like", value, "gymClassName");
            return (Criteria) this;
        }

        public Criteria andGymClassNameIn(List<String> values) {
            addCriterion("gym_class_name in", values, "gymClassName");
            return (Criteria) this;
        }

        public Criteria andGymClassNameNotIn(List<String> values) {
            addCriterion("gym_class_name not in", values, "gymClassName");
            return (Criteria) this;
        }

        public Criteria andGymClassNameBetween(String value1, String value2) {
            addCriterion("gym_class_name between", value1, value2, "gymClassName");
            return (Criteria) this;
        }

        public Criteria andGymClassNameNotBetween(String value1, String value2) {
            addCriterion("gym_class_name not between", value1, value2, "gymClassName");
            return (Criteria) this;
        }

        public Criteria andDetailsIsNull() {
            addCriterion("details is null");
            return (Criteria) this;
        }

        public Criteria andDetailsIsNotNull() {
            addCriterion("details is not null");
            return (Criteria) this;
        }

        public Criteria andDetailsEqualTo(String value) {
            addCriterion("details =", value, "details");
            return (Criteria) this;
        }

        public Criteria andDetailsNotEqualTo(String value) {
            addCriterion("details <>", value, "details");
            return (Criteria) this;
        }

        public Criteria andDetailsGreaterThan(String value) {
            addCriterion("details >", value, "details");
            return (Criteria) this;
        }

        public Criteria andDetailsGreaterThanOrEqualTo(String value) {
            addCriterion("details >=", value, "details");
            return (Criteria) this;
        }

        public Criteria andDetailsLessThan(String value) {
            addCriterion("details <", value, "details");
            return (Criteria) this;
        }

        public Criteria andDetailsLessThanOrEqualTo(String value) {
            addCriterion("details <=", value, "details");
            return (Criteria) this;
        }

        public Criteria andDetailsLike(String value) {
            addCriterion("details like", value, "details");
            return (Criteria) this;
        }

        public Criteria andDetailsNotLike(String value) {
            addCriterion("details not like", value, "details");
            return (Criteria) this;
        }

        public Criteria andDetailsIn(List<String> values) {
            addCriterion("details in", values, "details");
            return (Criteria) this;
        }

        public Criteria andDetailsNotIn(List<String> values) {
            addCriterion("details not in", values, "details");
            return (Criteria) this;
        }

        public Criteria andDetailsBetween(String value1, String value2) {
            addCriterion("details between", value1, value2, "details");
            return (Criteria) this;
        }

        public Criteria andDetailsNotBetween(String value1, String value2) {
            addCriterion("details not between", value1, value2, "details");
            return (Criteria) this;
        }

        public Criteria andChooseReasonIsNull() {
            addCriterion("choose_reason is null");
            return (Criteria) this;
        }

        public Criteria andChooseReasonIsNotNull() {
            addCriterion("choose_reason is not null");
            return (Criteria) this;
        }

        public Criteria andChooseReasonEqualTo(String value) {
            addCriterion("choose_reason =", value, "chooseReason");
            return (Criteria) this;
        }

        public Criteria andChooseReasonNotEqualTo(String value) {
            addCriterion("choose_reason <>", value, "chooseReason");
            return (Criteria) this;
        }

        public Criteria andChooseReasonGreaterThan(String value) {
            addCriterion("choose_reason >", value, "chooseReason");
            return (Criteria) this;
        }

        public Criteria andChooseReasonGreaterThanOrEqualTo(String value) {
            addCriterion("choose_reason >=", value, "chooseReason");
            return (Criteria) this;
        }

        public Criteria andChooseReasonLessThan(String value) {
            addCriterion("choose_reason <", value, "chooseReason");
            return (Criteria) this;
        }

        public Criteria andChooseReasonLessThanOrEqualTo(String value) {
            addCriterion("choose_reason <=", value, "chooseReason");
            return (Criteria) this;
        }

        public Criteria andChooseReasonLike(String value) {
            addCriterion("choose_reason like", value, "chooseReason");
            return (Criteria) this;
        }

        public Criteria andChooseReasonNotLike(String value) {
            addCriterion("choose_reason not like", value, "chooseReason");
            return (Criteria) this;
        }

        public Criteria andChooseReasonIn(List<String> values) {
            addCriterion("choose_reason in", values, "chooseReason");
            return (Criteria) this;
        }

        public Criteria andChooseReasonNotIn(List<String> values) {
            addCriterion("choose_reason not in", values, "chooseReason");
            return (Criteria) this;
        }

        public Criteria andChooseReasonBetween(String value1, String value2) {
            addCriterion("choose_reason between", value1, value2, "chooseReason");
            return (Criteria) this;
        }

        public Criteria andChooseReasonNotBetween(String value1, String value2) {
            addCriterion("choose_reason not between", value1, value2, "chooseReason");
            return (Criteria) this;
        }

        public Criteria andClassWeekIsNull() {
            addCriterion("class_week is null");
            return (Criteria) this;
        }

        public Criteria andClassWeekIsNotNull() {
            addCriterion("class_week is not null");
            return (Criteria) this;
        }

        public Criteria andClassWeekEqualTo(Integer value) {
            addCriterion("class_week =", value, "classWeek");
            return (Criteria) this;
        }

        public Criteria andClassWeekNotEqualTo(Integer value) {
            addCriterion("class_week <>", value, "classWeek");
            return (Criteria) this;
        }

        public Criteria andClassWeekGreaterThan(Integer value) {
            addCriterion("class_week >", value, "classWeek");
            return (Criteria) this;
        }

        public Criteria andClassWeekGreaterThanOrEqualTo(Integer value) {
            addCriterion("class_week >=", value, "classWeek");
            return (Criteria) this;
        }

        public Criteria andClassWeekLessThan(Integer value) {
            addCriterion("class_week <", value, "classWeek");
            return (Criteria) this;
        }

        public Criteria andClassWeekLessThanOrEqualTo(Integer value) {
            addCriterion("class_week <=", value, "classWeek");
            return (Criteria) this;
        }

        public Criteria andClassWeekIn(List<Integer> values) {
            addCriterion("class_week in", values, "classWeek");
            return (Criteria) this;
        }

        public Criteria andClassWeekNotIn(List<Integer> values) {
            addCriterion("class_week not in", values, "classWeek");
            return (Criteria) this;
        }

        public Criteria andClassWeekBetween(Integer value1, Integer value2) {
            addCriterion("class_week between", value1, value2, "classWeek");
            return (Criteria) this;
        }

        public Criteria andClassWeekNotBetween(Integer value1, Integer value2) {
            addCriterion("class_week not between", value1, value2, "classWeek");
            return (Criteria) this;
        }

        public Criteria andBegintimeIsNull() {
            addCriterion("beginTime is null");
            return (Criteria) this;
        }

        public Criteria andBegintimeIsNotNull() {
            addCriterion("beginTime is not null");
            return (Criteria) this;
        }

        public Criteria andBegintimeEqualTo(Date value) {
            addCriterionForJDBCTime("beginTime =", value, "begintime");
            return (Criteria) this;
        }

        public Criteria andBegintimeNotEqualTo(Date value) {
            addCriterionForJDBCTime("beginTime <>", value, "begintime");
            return (Criteria) this;
        }

        public Criteria andBegintimeGreaterThan(Date value) {
            addCriterionForJDBCTime("beginTime >", value, "begintime");
            return (Criteria) this;
        }

        public Criteria andBegintimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("beginTime >=", value, "begintime");
            return (Criteria) this;
        }

        public Criteria andBegintimeLessThan(Date value) {
            addCriterionForJDBCTime("beginTime <", value, "begintime");
            return (Criteria) this;
        }

        public Criteria andBegintimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("beginTime <=", value, "begintime");
            return (Criteria) this;
        }

        public Criteria andBegintimeIn(List<Date> values) {
            addCriterionForJDBCTime("beginTime in", values, "begintime");
            return (Criteria) this;
        }

        public Criteria andBegintimeNotIn(List<Date> values) {
            addCriterionForJDBCTime("beginTime not in", values, "begintime");
            return (Criteria) this;
        }

        public Criteria andBegintimeBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("beginTime between", value1, value2, "begintime");
            return (Criteria) this;
        }

        public Criteria andBegintimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("beginTime not between", value1, value2, "begintime");
            return (Criteria) this;
        }

        public Criteria andEndtimeIsNull() {
            addCriterion("endTime is null");
            return (Criteria) this;
        }

        public Criteria andEndtimeIsNotNull() {
            addCriterion("endTime is not null");
            return (Criteria) this;
        }

        public Criteria andEndtimeEqualTo(Date value) {
            addCriterionForJDBCTime("endTime =", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotEqualTo(Date value) {
            addCriterionForJDBCTime("endTime <>", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeGreaterThan(Date value) {
            addCriterionForJDBCTime("endTime >", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("endTime >=", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLessThan(Date value) {
            addCriterionForJDBCTime("endTime <", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("endTime <=", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeIn(List<Date> values) {
            addCriterionForJDBCTime("endTime in", values, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotIn(List<Date> values) {
            addCriterionForJDBCTime("endTime not in", values, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("endTime between", value1, value2, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("endTime not between", value1, value2, "endtime");
            return (Criteria) this;
        }

        public Criteria andEmpIdIsNull() {
            addCriterion("emp_id is null");
            return (Criteria) this;
        }

        public Criteria andEmpIdIsNotNull() {
            addCriterion("emp_id is not null");
            return (Criteria) this;
        }

        public Criteria andEmpIdEqualTo(Long value) {
            addCriterion("emp_id =", value, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdNotEqualTo(Long value) {
            addCriterion("emp_id <>", value, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdGreaterThan(Long value) {
            addCriterion("emp_id >", value, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdGreaterThanOrEqualTo(Long value) {
            addCriterion("emp_id >=", value, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdLessThan(Long value) {
            addCriterion("emp_id <", value, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdLessThanOrEqualTo(Long value) {
            addCriterion("emp_id <=", value, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdIn(List<Long> values) {
            addCriterion("emp_id in", values, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdNotIn(List<Long> values) {
            addCriterion("emp_id not in", values, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdBetween(Long value1, Long value2) {
            addCriterion("emp_id between", value1, value2, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdNotBetween(Long value1, Long value2) {
            addCriterion("emp_id not between", value1, value2, "empId");
            return (Criteria) this;
        }

        public Criteria andImg1urlIsNull() {
            addCriterion("img1Url is null");
            return (Criteria) this;
        }

        public Criteria andImg1urlIsNotNull() {
            addCriterion("img1Url is not null");
            return (Criteria) this;
        }

        public Criteria andImg1urlEqualTo(String value) {
            addCriterion("img1Url =", value, "img1url");
            return (Criteria) this;
        }

        public Criteria andImg1urlNotEqualTo(String value) {
            addCriterion("img1Url <>", value, "img1url");
            return (Criteria) this;
        }

        public Criteria andImg1urlGreaterThan(String value) {
            addCriterion("img1Url >", value, "img1url");
            return (Criteria) this;
        }

        public Criteria andImg1urlGreaterThanOrEqualTo(String value) {
            addCriterion("img1Url >=", value, "img1url");
            return (Criteria) this;
        }

        public Criteria andImg1urlLessThan(String value) {
            addCriterion("img1Url <", value, "img1url");
            return (Criteria) this;
        }

        public Criteria andImg1urlLessThanOrEqualTo(String value) {
            addCriterion("img1Url <=", value, "img1url");
            return (Criteria) this;
        }

        public Criteria andImg1urlLike(String value) {
            addCriterion("img1Url like", value, "img1url");
            return (Criteria) this;
        }

        public Criteria andImg1urlNotLike(String value) {
            addCriterion("img1Url not like", value, "img1url");
            return (Criteria) this;
        }

        public Criteria andImg1urlIn(List<String> values) {
            addCriterion("img1Url in", values, "img1url");
            return (Criteria) this;
        }

        public Criteria andImg1urlNotIn(List<String> values) {
            addCriterion("img1Url not in", values, "img1url");
            return (Criteria) this;
        }

        public Criteria andImg1urlBetween(String value1, String value2) {
            addCriterion("img1Url between", value1, value2, "img1url");
            return (Criteria) this;
        }

        public Criteria andImg1urlNotBetween(String value1, String value2) {
            addCriterion("img1Url not between", value1, value2, "img1url");
            return (Criteria) this;
        }

        public Criteria andImg2urlIsNull() {
            addCriterion("img2Url is null");
            return (Criteria) this;
        }

        public Criteria andImg2urlIsNotNull() {
            addCriterion("img2Url is not null");
            return (Criteria) this;
        }

        public Criteria andImg2urlEqualTo(String value) {
            addCriterion("img2Url =", value, "img2url");
            return (Criteria) this;
        }

        public Criteria andImg2urlNotEqualTo(String value) {
            addCriterion("img2Url <>", value, "img2url");
            return (Criteria) this;
        }

        public Criteria andImg2urlGreaterThan(String value) {
            addCriterion("img2Url >", value, "img2url");
            return (Criteria) this;
        }

        public Criteria andImg2urlGreaterThanOrEqualTo(String value) {
            addCriterion("img2Url >=", value, "img2url");
            return (Criteria) this;
        }

        public Criteria andImg2urlLessThan(String value) {
            addCriterion("img2Url <", value, "img2url");
            return (Criteria) this;
        }

        public Criteria andImg2urlLessThanOrEqualTo(String value) {
            addCriterion("img2Url <=", value, "img2url");
            return (Criteria) this;
        }

        public Criteria andImg2urlLike(String value) {
            addCriterion("img2Url like", value, "img2url");
            return (Criteria) this;
        }

        public Criteria andImg2urlNotLike(String value) {
            addCriterion("img2Url not like", value, "img2url");
            return (Criteria) this;
        }

        public Criteria andImg2urlIn(List<String> values) {
            addCriterion("img2Url in", values, "img2url");
            return (Criteria) this;
        }

        public Criteria andImg2urlNotIn(List<String> values) {
            addCriterion("img2Url not in", values, "img2url");
            return (Criteria) this;
        }

        public Criteria andImg2urlBetween(String value1, String value2) {
            addCriterion("img2Url between", value1, value2, "img2url");
            return (Criteria) this;
        }

        public Criteria andImg2urlNotBetween(String value1, String value2) {
            addCriterion("img2Url not between", value1, value2, "img2url");
            return (Criteria) this;
        }

        public Criteria andImg3urlIsNull() {
            addCriterion("img3Url is null");
            return (Criteria) this;
        }

        public Criteria andImg3urlIsNotNull() {
            addCriterion("img3Url is not null");
            return (Criteria) this;
        }

        public Criteria andImg3urlEqualTo(String value) {
            addCriterion("img3Url =", value, "img3url");
            return (Criteria) this;
        }

        public Criteria andImg3urlNotEqualTo(String value) {
            addCriterion("img3Url <>", value, "img3url");
            return (Criteria) this;
        }

        public Criteria andImg3urlGreaterThan(String value) {
            addCriterion("img3Url >", value, "img3url");
            return (Criteria) this;
        }

        public Criteria andImg3urlGreaterThanOrEqualTo(String value) {
            addCriterion("img3Url >=", value, "img3url");
            return (Criteria) this;
        }

        public Criteria andImg3urlLessThan(String value) {
            addCriterion("img3Url <", value, "img3url");
            return (Criteria) this;
        }

        public Criteria andImg3urlLessThanOrEqualTo(String value) {
            addCriterion("img3Url <=", value, "img3url");
            return (Criteria) this;
        }

        public Criteria andImg3urlLike(String value) {
            addCriterion("img3Url like", value, "img3url");
            return (Criteria) this;
        }

        public Criteria andImg3urlNotLike(String value) {
            addCriterion("img3Url not like", value, "img3url");
            return (Criteria) this;
        }

        public Criteria andImg3urlIn(List<String> values) {
            addCriterion("img3Url in", values, "img3url");
            return (Criteria) this;
        }

        public Criteria andImg3urlNotIn(List<String> values) {
            addCriterion("img3Url not in", values, "img3url");
            return (Criteria) this;
        }

        public Criteria andImg3urlBetween(String value1, String value2) {
            addCriterion("img3Url between", value1, value2, "img3url");
            return (Criteria) this;
        }

        public Criteria andImg3urlNotBetween(String value1, String value2) {
            addCriterion("img3Url not between", value1, value2, "img3url");
            return (Criteria) this;
        }

        public Criteria andImg4urlIsNull() {
            addCriterion("img4Url is null");
            return (Criteria) this;
        }

        public Criteria andImg4urlIsNotNull() {
            addCriterion("img4Url is not null");
            return (Criteria) this;
        }

        public Criteria andImg4urlEqualTo(String value) {
            addCriterion("img4Url =", value, "img4url");
            return (Criteria) this;
        }

        public Criteria andImg4urlNotEqualTo(String value) {
            addCriterion("img4Url <>", value, "img4url");
            return (Criteria) this;
        }

        public Criteria andImg4urlGreaterThan(String value) {
            addCriterion("img4Url >", value, "img4url");
            return (Criteria) this;
        }

        public Criteria andImg4urlGreaterThanOrEqualTo(String value) {
            addCriterion("img4Url >=", value, "img4url");
            return (Criteria) this;
        }

        public Criteria andImg4urlLessThan(String value) {
            addCriterion("img4Url <", value, "img4url");
            return (Criteria) this;
        }

        public Criteria andImg4urlLessThanOrEqualTo(String value) {
            addCriterion("img4Url <=", value, "img4url");
            return (Criteria) this;
        }

        public Criteria andImg4urlLike(String value) {
            addCriterion("img4Url like", value, "img4url");
            return (Criteria) this;
        }

        public Criteria andImg4urlNotLike(String value) {
            addCriterion("img4Url not like", value, "img4url");
            return (Criteria) this;
        }

        public Criteria andImg4urlIn(List<String> values) {
            addCriterion("img4Url in", values, "img4url");
            return (Criteria) this;
        }

        public Criteria andImg4urlNotIn(List<String> values) {
            addCriterion("img4Url not in", values, "img4url");
            return (Criteria) this;
        }

        public Criteria andImg4urlBetween(String value1, String value2) {
            addCriterion("img4Url between", value1, value2, "img4url");
            return (Criteria) this;
        }

        public Criteria andImg4urlNotBetween(String value1, String value2) {
            addCriterion("img4Url not between", value1, value2, "img4url");
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