package com.csy.module.xtpz.entity;

import java.util.ArrayList;
import java.util.List;

public class BXtpzDmlxExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BXtpzDmlxExample() {
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andDmlxbhIsNull() {
            addCriterion("dmlxbh is null");
            return (Criteria) this;
        }

        public Criteria andDmlxbhIsNotNull() {
            addCriterion("dmlxbh is not null");
            return (Criteria) this;
        }

        public Criteria andDmlxbhEqualTo(Integer value) {
            addCriterion("dmlxbh =", value, "dmlxbh");
            return (Criteria) this;
        }

        public Criteria andDmlxbhNotEqualTo(Integer value) {
            addCriterion("dmlxbh <>", value, "dmlxbh");
            return (Criteria) this;
        }

        public Criteria andDmlxbhGreaterThan(Integer value) {
            addCriterion("dmlxbh >", value, "dmlxbh");
            return (Criteria) this;
        }

        public Criteria andDmlxbhGreaterThanOrEqualTo(Integer value) {
            addCriterion("dmlxbh >=", value, "dmlxbh");
            return (Criteria) this;
        }

        public Criteria andDmlxbhLessThan(Integer value) {
            addCriterion("dmlxbh <", value, "dmlxbh");
            return (Criteria) this;
        }

        public Criteria andDmlxbhLessThanOrEqualTo(Integer value) {
            addCriterion("dmlxbh <=", value, "dmlxbh");
            return (Criteria) this;
        }

        public Criteria andDmlxbhIn(List<Integer> values) {
            addCriterion("dmlxbh in", values, "dmlxbh");
            return (Criteria) this;
        }

        public Criteria andDmlxbhNotIn(List<Integer> values) {
            addCriterion("dmlxbh not in", values, "dmlxbh");
            return (Criteria) this;
        }

        public Criteria andDmlxbhBetween(Integer value1, Integer value2) {
            addCriterion("dmlxbh between", value1, value2, "dmlxbh");
            return (Criteria) this;
        }

        public Criteria andDmlxbhNotBetween(Integer value1, Integer value2) {
            addCriterion("dmlxbh not between", value1, value2, "dmlxbh");
            return (Criteria) this;
        }

        public Criteria andYwmIsNull() {
            addCriterion("ywm is null");
            return (Criteria) this;
        }

        public Criteria andYwmIsNotNull() {
            addCriterion("ywm is not null");
            return (Criteria) this;
        }

        public Criteria andYwmEqualTo(String value) {
            addCriterion("ywm =", value, "ywm");
            return (Criteria) this;
        }

        public Criteria andYwmNotEqualTo(String value) {
            addCriterion("ywm <>", value, "ywm");
            return (Criteria) this;
        }

        public Criteria andYwmGreaterThan(String value) {
            addCriterion("ywm >", value, "ywm");
            return (Criteria) this;
        }

        public Criteria andYwmGreaterThanOrEqualTo(String value) {
            addCriterion("ywm >=", value, "ywm");
            return (Criteria) this;
        }

        public Criteria andYwmLessThan(String value) {
            addCriterion("ywm <", value, "ywm");
            return (Criteria) this;
        }

        public Criteria andYwmLessThanOrEqualTo(String value) {
            addCriterion("ywm <=", value, "ywm");
            return (Criteria) this;
        }

        public Criteria andYwmLike(String value) {
            addCriterion("ywm like", value, "ywm");
            return (Criteria) this;
        }

        public Criteria andYwmNotLike(String value) {
            addCriterion("ywm not like", value, "ywm");
            return (Criteria) this;
        }

        public Criteria andYwmIn(List<String> values) {
            addCriterion("ywm in", values, "ywm");
            return (Criteria) this;
        }

        public Criteria andYwmNotIn(List<String> values) {
            addCriterion("ywm not in", values, "ywm");
            return (Criteria) this;
        }

        public Criteria andYwmBetween(String value1, String value2) {
            addCriterion("ywm between", value1, value2, "ywm");
            return (Criteria) this;
        }

        public Criteria andYwmNotBetween(String value1, String value2) {
            addCriterion("ywm not between", value1, value2, "ywm");
            return (Criteria) this;
        }

        public Criteria andZwmIsNull() {
            addCriterion("zwm is null");
            return (Criteria) this;
        }

        public Criteria andZwmIsNotNull() {
            addCriterion("zwm is not null");
            return (Criteria) this;
        }

        public Criteria andZwmEqualTo(String value) {
            addCriterion("zwm =", value, "zwm");
            return (Criteria) this;
        }

        public Criteria andZwmNotEqualTo(String value) {
            addCriterion("zwm <>", value, "zwm");
            return (Criteria) this;
        }

        public Criteria andZwmGreaterThan(String value) {
            addCriterion("zwm >", value, "zwm");
            return (Criteria) this;
        }

        public Criteria andZwmGreaterThanOrEqualTo(String value) {
            addCriterion("zwm >=", value, "zwm");
            return (Criteria) this;
        }

        public Criteria andZwmLessThan(String value) {
            addCriterion("zwm <", value, "zwm");
            return (Criteria) this;
        }

        public Criteria andZwmLessThanOrEqualTo(String value) {
            addCriterion("zwm <=", value, "zwm");
            return (Criteria) this;
        }

        public Criteria andZwmLike(String value) {
            addCriterion("zwm like", value, "zwm");
            return (Criteria) this;
        }

        public Criteria andZwmNotLike(String value) {
            addCriterion("zwm not like", value, "zwm");
            return (Criteria) this;
        }

        public Criteria andZwmIn(List<String> values) {
            addCriterion("zwm in", values, "zwm");
            return (Criteria) this;
        }

        public Criteria andZwmNotIn(List<String> values) {
            addCriterion("zwm not in", values, "zwm");
            return (Criteria) this;
        }

        public Criteria andZwmBetween(String value1, String value2) {
            addCriterion("zwm between", value1, value2, "zwm");
            return (Criteria) this;
        }

        public Criteria andZwmNotBetween(String value1, String value2) {
            addCriterion("zwm not between", value1, value2, "zwm");
            return (Criteria) this;
        }

        public Criteria andPYwmIsNull() {
            addCriterion("p_ywm is null");
            return (Criteria) this;
        }

        public Criteria andPYwmIsNotNull() {
            addCriterion("p_ywm is not null");
            return (Criteria) this;
        }

        public Criteria andPYwmEqualTo(String value) {
            addCriterion("p_ywm =", value, "pYwm");
            return (Criteria) this;
        }

        public Criteria andPYwmNotEqualTo(String value) {
            addCriterion("p_ywm <>", value, "pYwm");
            return (Criteria) this;
        }

        public Criteria andPYwmGreaterThan(String value) {
            addCriterion("p_ywm >", value, "pYwm");
            return (Criteria) this;
        }

        public Criteria andPYwmGreaterThanOrEqualTo(String value) {
            addCriterion("p_ywm >=", value, "pYwm");
            return (Criteria) this;
        }

        public Criteria andPYwmLessThan(String value) {
            addCriterion("p_ywm <", value, "pYwm");
            return (Criteria) this;
        }

        public Criteria andPYwmLessThanOrEqualTo(String value) {
            addCriterion("p_ywm <=", value, "pYwm");
            return (Criteria) this;
        }

        public Criteria andPYwmLike(String value) {
            addCriterion("p_ywm like", value, "pYwm");
            return (Criteria) this;
        }

        public Criteria andPYwmNotLike(String value) {
            addCriterion("p_ywm not like", value, "pYwm");
            return (Criteria) this;
        }

        public Criteria andPYwmIn(List<String> values) {
            addCriterion("p_ywm in", values, "pYwm");
            return (Criteria) this;
        }

        public Criteria andPYwmNotIn(List<String> values) {
            addCriterion("p_ywm not in", values, "pYwm");
            return (Criteria) this;
        }

        public Criteria andPYwmBetween(String value1, String value2) {
            addCriterion("p_ywm between", value1, value2, "pYwm");
            return (Criteria) this;
        }

        public Criteria andPYwmNotBetween(String value1, String value2) {
            addCriterion("p_ywm not between", value1, value2, "pYwm");
            return (Criteria) this;
        }

        public Criteria andDmlxmsIsNull() {
            addCriterion("dmlxms is null");
            return (Criteria) this;
        }

        public Criteria andDmlxmsIsNotNull() {
            addCriterion("dmlxms is not null");
            return (Criteria) this;
        }

        public Criteria andDmlxmsEqualTo(String value) {
            addCriterion("dmlxms =", value, "dmlxms");
            return (Criteria) this;
        }

        public Criteria andDmlxmsNotEqualTo(String value) {
            addCriterion("dmlxms <>", value, "dmlxms");
            return (Criteria) this;
        }

        public Criteria andDmlxmsGreaterThan(String value) {
            addCriterion("dmlxms >", value, "dmlxms");
            return (Criteria) this;
        }

        public Criteria andDmlxmsGreaterThanOrEqualTo(String value) {
            addCriterion("dmlxms >=", value, "dmlxms");
            return (Criteria) this;
        }

        public Criteria andDmlxmsLessThan(String value) {
            addCriterion("dmlxms <", value, "dmlxms");
            return (Criteria) this;
        }

        public Criteria andDmlxmsLessThanOrEqualTo(String value) {
            addCriterion("dmlxms <=", value, "dmlxms");
            return (Criteria) this;
        }

        public Criteria andDmlxmsLike(String value) {
            addCriterion("dmlxms like", value, "dmlxms");
            return (Criteria) this;
        }

        public Criteria andDmlxmsNotLike(String value) {
            addCriterion("dmlxms not like", value, "dmlxms");
            return (Criteria) this;
        }

        public Criteria andDmlxmsIn(List<String> values) {
            addCriterion("dmlxms in", values, "dmlxms");
            return (Criteria) this;
        }

        public Criteria andDmlxmsNotIn(List<String> values) {
            addCriterion("dmlxms not in", values, "dmlxms");
            return (Criteria) this;
        }

        public Criteria andDmlxmsBetween(String value1, String value2) {
            addCriterion("dmlxms between", value1, value2, "dmlxms");
            return (Criteria) this;
        }

        public Criteria andDmlxmsNotBetween(String value1, String value2) {
            addCriterion("dmlxms not between", value1, value2, "dmlxms");
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