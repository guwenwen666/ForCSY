package com.csy.module.xtpz.entity;

import java.util.ArrayList;
import java.util.List;

public class BXtpzDmxExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BXtpzDmxExample() {
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

        public Criteria andDmxywmIsNull() {
            addCriterion("dmxywm is null");
            return (Criteria) this;
        }

        public Criteria andDmxywmIsNotNull() {
            addCriterion("dmxywm is not null");
            return (Criteria) this;
        }

        public Criteria andDmxywmEqualTo(String value) {
            addCriterion("dmxywm =", value, "dmxywm");
            return (Criteria) this;
        }

        public Criteria andDmxywmNotEqualTo(String value) {
            addCriterion("dmxywm <>", value, "dmxywm");
            return (Criteria) this;
        }

        public Criteria andDmxywmGreaterThan(String value) {
            addCriterion("dmxywm >", value, "dmxywm");
            return (Criteria) this;
        }

        public Criteria andDmxywmGreaterThanOrEqualTo(String value) {
            addCriterion("dmxywm >=", value, "dmxywm");
            return (Criteria) this;
        }

        public Criteria andDmxywmLessThan(String value) {
            addCriterion("dmxywm <", value, "dmxywm");
            return (Criteria) this;
        }

        public Criteria andDmxywmLessThanOrEqualTo(String value) {
            addCriterion("dmxywm <=", value, "dmxywm");
            return (Criteria) this;
        }

        public Criteria andDmxywmLike(String value) {
            addCriterion("dmxywm like", value, "dmxywm");
            return (Criteria) this;
        }

        public Criteria andDmxywmNotLike(String value) {
            addCriterion("dmxywm not like", value, "dmxywm");
            return (Criteria) this;
        }

        public Criteria andDmxywmIn(List<String> values) {
            addCriterion("dmxywm in", values, "dmxywm");
            return (Criteria) this;
        }

        public Criteria andDmxywmNotIn(List<String> values) {
            addCriterion("dmxywm not in", values, "dmxywm");
            return (Criteria) this;
        }

        public Criteria andDmxywmBetween(String value1, String value2) {
            addCriterion("dmxywm between", value1, value2, "dmxywm");
            return (Criteria) this;
        }

        public Criteria andDmxywmNotBetween(String value1, String value2) {
            addCriterion("dmxywm not between", value1, value2, "dmxywm");
            return (Criteria) this;
        }

        public Criteria andDmxzwmIsNull() {
            addCriterion("dmxzwm is null");
            return (Criteria) this;
        }

        public Criteria andDmxzwmIsNotNull() {
            addCriterion("dmxzwm is not null");
            return (Criteria) this;
        }

        public Criteria andDmxzwmEqualTo(String value) {
            addCriterion("dmxzwm =", value, "dmxzwm");
            return (Criteria) this;
        }

        public Criteria andDmxzwmNotEqualTo(String value) {
            addCriterion("dmxzwm <>", value, "dmxzwm");
            return (Criteria) this;
        }

        public Criteria andDmxzwmGreaterThan(String value) {
            addCriterion("dmxzwm >", value, "dmxzwm");
            return (Criteria) this;
        }

        public Criteria andDmxzwmGreaterThanOrEqualTo(String value) {
            addCriterion("dmxzwm >=", value, "dmxzwm");
            return (Criteria) this;
        }

        public Criteria andDmxzwmLessThan(String value) {
            addCriterion("dmxzwm <", value, "dmxzwm");
            return (Criteria) this;
        }

        public Criteria andDmxzwmLessThanOrEqualTo(String value) {
            addCriterion("dmxzwm <=", value, "dmxzwm");
            return (Criteria) this;
        }

        public Criteria andDmxzwmLike(String value) {
            addCriterion("dmxzwm like", value, "dmxzwm");
            return (Criteria) this;
        }

        public Criteria andDmxzwmNotLike(String value) {
            addCriterion("dmxzwm not like", value, "dmxzwm");
            return (Criteria) this;
        }

        public Criteria andDmxzwmIn(List<String> values) {
            addCriterion("dmxzwm in", values, "dmxzwm");
            return (Criteria) this;
        }

        public Criteria andDmxzwmNotIn(List<String> values) {
            addCriterion("dmxzwm not in", values, "dmxzwm");
            return (Criteria) this;
        }

        public Criteria andDmxzwmBetween(String value1, String value2) {
            addCriterion("dmxzwm between", value1, value2, "dmxzwm");
            return (Criteria) this;
        }

        public Criteria andDmxzwmNotBetween(String value1, String value2) {
            addCriterion("dmxzwm not between", value1, value2, "dmxzwm");
            return (Criteria) this;
        }

        public Criteria andDmxzIsNull() {
            addCriterion("dmxz is null");
            return (Criteria) this;
        }

        public Criteria andDmxzIsNotNull() {
            addCriterion("dmxz is not null");
            return (Criteria) this;
        }

        public Criteria andDmxzEqualTo(String value) {
            addCriterion("dmxz =", value, "dmxz");
            return (Criteria) this;
        }

        public Criteria andDmxzNotEqualTo(String value) {
            addCriterion("dmxz <>", value, "dmxz");
            return (Criteria) this;
        }

        public Criteria andDmxzGreaterThan(String value) {
            addCriterion("dmxz >", value, "dmxz");
            return (Criteria) this;
        }

        public Criteria andDmxzGreaterThanOrEqualTo(String value) {
            addCriterion("dmxz >=", value, "dmxz");
            return (Criteria) this;
        }

        public Criteria andDmxzLessThan(String value) {
            addCriterion("dmxz <", value, "dmxz");
            return (Criteria) this;
        }

        public Criteria andDmxzLessThanOrEqualTo(String value) {
            addCriterion("dmxz <=", value, "dmxz");
            return (Criteria) this;
        }

        public Criteria andDmxzLike(String value) {
            addCriterion("dmxz like", value, "dmxz");
            return (Criteria) this;
        }

        public Criteria andDmxzNotLike(String value) {
            addCriterion("dmxz not like", value, "dmxz");
            return (Criteria) this;
        }

        public Criteria andDmxzIn(List<String> values) {
            addCriterion("dmxz in", values, "dmxz");
            return (Criteria) this;
        }

        public Criteria andDmxzNotIn(List<String> values) {
            addCriterion("dmxz not in", values, "dmxz");
            return (Criteria) this;
        }

        public Criteria andDmxzBetween(String value1, String value2) {
            addCriterion("dmxz between", value1, value2, "dmxz");
            return (Criteria) this;
        }

        public Criteria andDmxzNotBetween(String value1, String value2) {
            addCriterion("dmxz not between", value1, value2, "dmxz");
            return (Criteria) this;
        }

        public Criteria andPDmxywmIsNull() {
            addCriterion("p_dmxywm is null");
            return (Criteria) this;
        }

        public Criteria andPDmxywmIsNotNull() {
            addCriterion("p_dmxywm is not null");
            return (Criteria) this;
        }

        public Criteria andPDmxywmEqualTo(String value) {
            addCriterion("p_dmxywm =", value, "pDmxywm");
            return (Criteria) this;
        }

        public Criteria andPDmxywmNotEqualTo(String value) {
            addCriterion("p_dmxywm <>", value, "pDmxywm");
            return (Criteria) this;
        }

        public Criteria andPDmxywmGreaterThan(String value) {
            addCriterion("p_dmxywm >", value, "pDmxywm");
            return (Criteria) this;
        }

        public Criteria andPDmxywmGreaterThanOrEqualTo(String value) {
            addCriterion("p_dmxywm >=", value, "pDmxywm");
            return (Criteria) this;
        }

        public Criteria andPDmxywmLessThan(String value) {
            addCriterion("p_dmxywm <", value, "pDmxywm");
            return (Criteria) this;
        }

        public Criteria andPDmxywmLessThanOrEqualTo(String value) {
            addCriterion("p_dmxywm <=", value, "pDmxywm");
            return (Criteria) this;
        }

        public Criteria andPDmxywmLike(String value) {
            addCriterion("p_dmxywm like", value, "pDmxywm");
            return (Criteria) this;
        }

        public Criteria andPDmxywmNotLike(String value) {
            addCriterion("p_dmxywm not like", value, "pDmxywm");
            return (Criteria) this;
        }

        public Criteria andPDmxywmIn(List<String> values) {
            addCriterion("p_dmxywm in", values, "pDmxywm");
            return (Criteria) this;
        }

        public Criteria andPDmxywmNotIn(List<String> values) {
            addCriterion("p_dmxywm not in", values, "pDmxywm");
            return (Criteria) this;
        }

        public Criteria andPDmxywmBetween(String value1, String value2) {
            addCriterion("p_dmxywm between", value1, value2, "pDmxywm");
            return (Criteria) this;
        }

        public Criteria andPDmxywmNotBetween(String value1, String value2) {
            addCriterion("p_dmxywm not between", value1, value2, "pDmxywm");
            return (Criteria) this;
        }

        public Criteria andSfxsIsNull() {
            addCriterion("sfxs is null");
            return (Criteria) this;
        }

        public Criteria andSfxsIsNotNull() {
            addCriterion("sfxs is not null");
            return (Criteria) this;
        }

        public Criteria andSfxsEqualTo(Integer value) {
            addCriterion("sfxs =", value, "sfxs");
            return (Criteria) this;
        }

        public Criteria andSfxsNotEqualTo(Integer value) {
            addCriterion("sfxs <>", value, "sfxs");
            return (Criteria) this;
        }

        public Criteria andSfxsGreaterThan(Integer value) {
            addCriterion("sfxs >", value, "sfxs");
            return (Criteria) this;
        }

        public Criteria andSfxsGreaterThanOrEqualTo(Integer value) {
            addCriterion("sfxs >=", value, "sfxs");
            return (Criteria) this;
        }

        public Criteria andSfxsLessThan(Integer value) {
            addCriterion("sfxs <", value, "sfxs");
            return (Criteria) this;
        }

        public Criteria andSfxsLessThanOrEqualTo(Integer value) {
            addCriterion("sfxs <=", value, "sfxs");
            return (Criteria) this;
        }

        public Criteria andSfxsIn(List<Integer> values) {
            addCriterion("sfxs in", values, "sfxs");
            return (Criteria) this;
        }

        public Criteria andSfxsNotIn(List<Integer> values) {
            addCriterion("sfxs not in", values, "sfxs");
            return (Criteria) this;
        }

        public Criteria andSfxsBetween(Integer value1, Integer value2) {
            addCriterion("sfxs between", value1, value2, "sfxs");
            return (Criteria) this;
        }

        public Criteria andSfxsNotBetween(Integer value1, Integer value2) {
            addCriterion("sfxs not between", value1, value2, "sfxs");
            return (Criteria) this;
        }

        public Criteria andSfkyIsNull() {
            addCriterion("sfky is null");
            return (Criteria) this;
        }

        public Criteria andSfkyIsNotNull() {
            addCriterion("sfky is not null");
            return (Criteria) this;
        }

        public Criteria andSfkyEqualTo(Integer value) {
            addCriterion("sfky =", value, "sfky");
            return (Criteria) this;
        }

        public Criteria andSfkyNotEqualTo(Integer value) {
            addCriterion("sfky <>", value, "sfky");
            return (Criteria) this;
        }

        public Criteria andSfkyGreaterThan(Integer value) {
            addCriterion("sfky >", value, "sfky");
            return (Criteria) this;
        }

        public Criteria andSfkyGreaterThanOrEqualTo(Integer value) {
            addCriterion("sfky >=", value, "sfky");
            return (Criteria) this;
        }

        public Criteria andSfkyLessThan(Integer value) {
            addCriterion("sfky <", value, "sfky");
            return (Criteria) this;
        }

        public Criteria andSfkyLessThanOrEqualTo(Integer value) {
            addCriterion("sfky <=", value, "sfky");
            return (Criteria) this;
        }

        public Criteria andSfkyIn(List<Integer> values) {
            addCriterion("sfky in", values, "sfky");
            return (Criteria) this;
        }

        public Criteria andSfkyNotIn(List<Integer> values) {
            addCriterion("sfky not in", values, "sfky");
            return (Criteria) this;
        }

        public Criteria andSfkyBetween(Integer value1, Integer value2) {
            addCriterion("sfky between", value1, value2, "sfky");
            return (Criteria) this;
        }

        public Criteria andSfkyNotBetween(Integer value1, Integer value2) {
            addCriterion("sfky not between", value1, value2, "sfky");
            return (Criteria) this;
        }

        public Criteria andSfmrIsNull() {
            addCriterion("sfmr is null");
            return (Criteria) this;
        }

        public Criteria andSfmrIsNotNull() {
            addCriterion("sfmr is not null");
            return (Criteria) this;
        }

        public Criteria andSfmrEqualTo(Integer value) {
            addCriterion("sfmr =", value, "sfmr");
            return (Criteria) this;
        }

        public Criteria andSfmrNotEqualTo(Integer value) {
            addCriterion("sfmr <>", value, "sfmr");
            return (Criteria) this;
        }

        public Criteria andSfmrGreaterThan(Integer value) {
            addCriterion("sfmr >", value, "sfmr");
            return (Criteria) this;
        }

        public Criteria andSfmrGreaterThanOrEqualTo(Integer value) {
            addCriterion("sfmr >=", value, "sfmr");
            return (Criteria) this;
        }

        public Criteria andSfmrLessThan(Integer value) {
            addCriterion("sfmr <", value, "sfmr");
            return (Criteria) this;
        }

        public Criteria andSfmrLessThanOrEqualTo(Integer value) {
            addCriterion("sfmr <=", value, "sfmr");
            return (Criteria) this;
        }

        public Criteria andSfmrIn(List<Integer> values) {
            addCriterion("sfmr in", values, "sfmr");
            return (Criteria) this;
        }

        public Criteria andSfmrNotIn(List<Integer> values) {
            addCriterion("sfmr not in", values, "sfmr");
            return (Criteria) this;
        }

        public Criteria andSfmrBetween(Integer value1, Integer value2) {
            addCriterion("sfmr between", value1, value2, "sfmr");
            return (Criteria) this;
        }

        public Criteria andSfmrNotBetween(Integer value1, Integer value2) {
            addCriterion("sfmr not between", value1, value2, "sfmr");
            return (Criteria) this;
        }

        public Criteria andXssxIsNull() {
            addCriterion("xssx is null");
            return (Criteria) this;
        }

        public Criteria andXssxIsNotNull() {
            addCriterion("xssx is not null");
            return (Criteria) this;
        }

        public Criteria andXssxEqualTo(Integer value) {
            addCriterion("xssx =", value, "xssx");
            return (Criteria) this;
        }

        public Criteria andXssxNotEqualTo(Integer value) {
            addCriterion("xssx <>", value, "xssx");
            return (Criteria) this;
        }

        public Criteria andXssxGreaterThan(Integer value) {
            addCriterion("xssx >", value, "xssx");
            return (Criteria) this;
        }

        public Criteria andXssxGreaterThanOrEqualTo(Integer value) {
            addCriterion("xssx >=", value, "xssx");
            return (Criteria) this;
        }

        public Criteria andXssxLessThan(Integer value) {
            addCriterion("xssx <", value, "xssx");
            return (Criteria) this;
        }

        public Criteria andXssxLessThanOrEqualTo(Integer value) {
            addCriterion("xssx <=", value, "xssx");
            return (Criteria) this;
        }

        public Criteria andXssxIn(List<Integer> values) {
            addCriterion("xssx in", values, "xssx");
            return (Criteria) this;
        }

        public Criteria andXssxNotIn(List<Integer> values) {
            addCriterion("xssx not in", values, "xssx");
            return (Criteria) this;
        }

        public Criteria andXssxBetween(Integer value1, Integer value2) {
            addCriterion("xssx between", value1, value2, "xssx");
            return (Criteria) this;
        }

        public Criteria andXssxNotBetween(Integer value1, Integer value2) {
            addCriterion("xssx not between", value1, value2, "xssx");
            return (Criteria) this;
        }

        public Criteria andDmxmsIsNull() {
            addCriterion("dmxms is null");
            return (Criteria) this;
        }

        public Criteria andDmxmsIsNotNull() {
            addCriterion("dmxms is not null");
            return (Criteria) this;
        }

        public Criteria andDmxmsEqualTo(String value) {
            addCriterion("dmxms =", value, "dmxms");
            return (Criteria) this;
        }

        public Criteria andDmxmsNotEqualTo(String value) {
            addCriterion("dmxms <>", value, "dmxms");
            return (Criteria) this;
        }

        public Criteria andDmxmsGreaterThan(String value) {
            addCriterion("dmxms >", value, "dmxms");
            return (Criteria) this;
        }

        public Criteria andDmxmsGreaterThanOrEqualTo(String value) {
            addCriterion("dmxms >=", value, "dmxms");
            return (Criteria) this;
        }

        public Criteria andDmxmsLessThan(String value) {
            addCriterion("dmxms <", value, "dmxms");
            return (Criteria) this;
        }

        public Criteria andDmxmsLessThanOrEqualTo(String value) {
            addCriterion("dmxms <=", value, "dmxms");
            return (Criteria) this;
        }

        public Criteria andDmxmsLike(String value) {
            addCriterion("dmxms like", value, "dmxms");
            return (Criteria) this;
        }

        public Criteria andDmxmsNotLike(String value) {
            addCriterion("dmxms not like", value, "dmxms");
            return (Criteria) this;
        }

        public Criteria andDmxmsIn(List<String> values) {
            addCriterion("dmxms in", values, "dmxms");
            return (Criteria) this;
        }

        public Criteria andDmxmsNotIn(List<String> values) {
            addCriterion("dmxms not in", values, "dmxms");
            return (Criteria) this;
        }

        public Criteria andDmxmsBetween(String value1, String value2) {
            addCriterion("dmxms between", value1, value2, "dmxms");
            return (Criteria) this;
        }

        public Criteria andDmxmsNotBetween(String value1, String value2) {
            addCriterion("dmxms not between", value1, value2, "dmxms");
            return (Criteria) this;
        }

        public Criteria andDmxkzIsNull() {
            addCriterion("dmxkz is null");
            return (Criteria) this;
        }

        public Criteria andDmxkzIsNotNull() {
            addCriterion("dmxkz is not null");
            return (Criteria) this;
        }

        public Criteria andDmxkzEqualTo(String value) {
            addCriterion("dmxkz =", value, "dmxkz");
            return (Criteria) this;
        }

        public Criteria andDmxkzNotEqualTo(String value) {
            addCriterion("dmxkz <>", value, "dmxkz");
            return (Criteria) this;
        }

        public Criteria andDmxkzGreaterThan(String value) {
            addCriterion("dmxkz >", value, "dmxkz");
            return (Criteria) this;
        }

        public Criteria andDmxkzGreaterThanOrEqualTo(String value) {
            addCriterion("dmxkz >=", value, "dmxkz");
            return (Criteria) this;
        }

        public Criteria andDmxkzLessThan(String value) {
            addCriterion("dmxkz <", value, "dmxkz");
            return (Criteria) this;
        }

        public Criteria andDmxkzLessThanOrEqualTo(String value) {
            addCriterion("dmxkz <=", value, "dmxkz");
            return (Criteria) this;
        }

        public Criteria andDmxkzLike(String value) {
            addCriterion("dmxkz like", value, "dmxkz");
            return (Criteria) this;
        }

        public Criteria andDmxkzNotLike(String value) {
            addCriterion("dmxkz not like", value, "dmxkz");
            return (Criteria) this;
        }

        public Criteria andDmxkzIn(List<String> values) {
            addCriterion("dmxkz in", values, "dmxkz");
            return (Criteria) this;
        }

        public Criteria andDmxkzNotIn(List<String> values) {
            addCriterion("dmxkz not in", values, "dmxkz");
            return (Criteria) this;
        }

        public Criteria andDmxkzBetween(String value1, String value2) {
            addCriterion("dmxkz between", value1, value2, "dmxkz");
            return (Criteria) this;
        }

        public Criteria andDmxkzNotBetween(String value1, String value2) {
            addCriterion("dmxkz not between", value1, value2, "dmxkz");
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