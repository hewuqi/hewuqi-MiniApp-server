package com.hewuqi.auth2.model;

import java.util.ArrayList;
import java.util.List;

public class PermissionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PermissionExample() {
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

        public Criteria andResourceCodeIsNull() {
            addCriterion("resource_code is null");
            return (Criteria) this;
        }

        public Criteria andResourceCodeIsNotNull() {
            addCriterion("resource_code is not null");
            return (Criteria) this;
        }

        public Criteria andResourceCodeEqualTo(String value) {
            addCriterion("resource_code =", value, "resourceCode");
            return (Criteria) this;
        }

        public Criteria andResourceCodeNotEqualTo(String value) {
            addCriterion("resource_code <>", value, "resourceCode");
            return (Criteria) this;
        }

        public Criteria andResourceCodeGreaterThan(String value) {
            addCriterion("resource_code >", value, "resourceCode");
            return (Criteria) this;
        }

        public Criteria andResourceCodeGreaterThanOrEqualTo(String value) {
            addCriterion("resource_code >=", value, "resourceCode");
            return (Criteria) this;
        }

        public Criteria andResourceCodeLessThan(String value) {
            addCriterion("resource_code <", value, "resourceCode");
            return (Criteria) this;
        }

        public Criteria andResourceCodeLessThanOrEqualTo(String value) {
            addCriterion("resource_code <=", value, "resourceCode");
            return (Criteria) this;
        }

        public Criteria andResourceCodeLike(String value) {
            addCriterion("resource_code like", value, "resourceCode");
            return (Criteria) this;
        }

        public Criteria andResourceCodeNotLike(String value) {
            addCriterion("resource_code not like", value, "resourceCode");
            return (Criteria) this;
        }

        public Criteria andResourceCodeIn(List<String> values) {
            addCriterion("resource_code in", values, "resourceCode");
            return (Criteria) this;
        }

        public Criteria andResourceCodeNotIn(List<String> values) {
            addCriterion("resource_code not in", values, "resourceCode");
            return (Criteria) this;
        }

        public Criteria andResourceCodeBetween(String value1, String value2) {
            addCriterion("resource_code between", value1, value2, "resourceCode");
            return (Criteria) this;
        }

        public Criteria andResourceCodeNotBetween(String value1, String value2) {
            addCriterion("resource_code not between", value1, value2, "resourceCode");
            return (Criteria) this;
        }

        public Criteria andResorceNameIsNull() {
            addCriterion("resorce_name is null");
            return (Criteria) this;
        }

        public Criteria andResorceNameIsNotNull() {
            addCriterion("resorce_name is not null");
            return (Criteria) this;
        }

        public Criteria andResorceNameEqualTo(String value) {
            addCriterion("resorce_name =", value, "resorceName");
            return (Criteria) this;
        }

        public Criteria andResorceNameNotEqualTo(String value) {
            addCriterion("resorce_name <>", value, "resorceName");
            return (Criteria) this;
        }

        public Criteria andResorceNameGreaterThan(String value) {
            addCriterion("resorce_name >", value, "resorceName");
            return (Criteria) this;
        }

        public Criteria andResorceNameGreaterThanOrEqualTo(String value) {
            addCriterion("resorce_name >=", value, "resorceName");
            return (Criteria) this;
        }

        public Criteria andResorceNameLessThan(String value) {
            addCriterion("resorce_name <", value, "resorceName");
            return (Criteria) this;
        }

        public Criteria andResorceNameLessThanOrEqualTo(String value) {
            addCriterion("resorce_name <=", value, "resorceName");
            return (Criteria) this;
        }

        public Criteria andResorceNameLike(String value) {
            addCriterion("resorce_name like", value, "resorceName");
            return (Criteria) this;
        }

        public Criteria andResorceNameNotLike(String value) {
            addCriterion("resorce_name not like", value, "resorceName");
            return (Criteria) this;
        }

        public Criteria andResorceNameIn(List<String> values) {
            addCriterion("resorce_name in", values, "resorceName");
            return (Criteria) this;
        }

        public Criteria andResorceNameNotIn(List<String> values) {
            addCriterion("resorce_name not in", values, "resorceName");
            return (Criteria) this;
        }

        public Criteria andResorceNameBetween(String value1, String value2) {
            addCriterion("resorce_name between", value1, value2, "resorceName");
            return (Criteria) this;
        }

        public Criteria andResorceNameNotBetween(String value1, String value2) {
            addCriterion("resorce_name not between", value1, value2, "resorceName");
            return (Criteria) this;
        }

        public Criteria andPermissionCodeIsNull() {
            addCriterion("permission_code is null");
            return (Criteria) this;
        }

        public Criteria andPermissionCodeIsNotNull() {
            addCriterion("permission_code is not null");
            return (Criteria) this;
        }

        public Criteria andPermissionCodeEqualTo(String value) {
            addCriterion("permission_code =", value, "permissionCode");
            return (Criteria) this;
        }

        public Criteria andPermissionCodeNotEqualTo(String value) {
            addCriterion("permission_code <>", value, "permissionCode");
            return (Criteria) this;
        }

        public Criteria andPermissionCodeGreaterThan(String value) {
            addCriterion("permission_code >", value, "permissionCode");
            return (Criteria) this;
        }

        public Criteria andPermissionCodeGreaterThanOrEqualTo(String value) {
            addCriterion("permission_code >=", value, "permissionCode");
            return (Criteria) this;
        }

        public Criteria andPermissionCodeLessThan(String value) {
            addCriterion("permission_code <", value, "permissionCode");
            return (Criteria) this;
        }

        public Criteria andPermissionCodeLessThanOrEqualTo(String value) {
            addCriterion("permission_code <=", value, "permissionCode");
            return (Criteria) this;
        }

        public Criteria andPermissionCodeLike(String value) {
            addCriterion("permission_code like", value, "permissionCode");
            return (Criteria) this;
        }

        public Criteria andPermissionCodeNotLike(String value) {
            addCriterion("permission_code not like", value, "permissionCode");
            return (Criteria) this;
        }

        public Criteria andPermissionCodeIn(List<String> values) {
            addCriterion("permission_code in", values, "permissionCode");
            return (Criteria) this;
        }

        public Criteria andPermissionCodeNotIn(List<String> values) {
            addCriterion("permission_code not in", values, "permissionCode");
            return (Criteria) this;
        }

        public Criteria andPermissionCodeBetween(String value1, String value2) {
            addCriterion("permission_code between", value1, value2, "permissionCode");
            return (Criteria) this;
        }

        public Criteria andPermissionCodeNotBetween(String value1, String value2) {
            addCriterion("permission_code not between", value1, value2, "permissionCode");
            return (Criteria) this;
        }

        public Criteria andPermissionNameIsNull() {
            addCriterion("permission_name is null");
            return (Criteria) this;
        }

        public Criteria andPermissionNameIsNotNull() {
            addCriterion("permission_name is not null");
            return (Criteria) this;
        }

        public Criteria andPermissionNameEqualTo(String value) {
            addCriterion("permission_name =", value, "permissionName");
            return (Criteria) this;
        }

        public Criteria andPermissionNameNotEqualTo(String value) {
            addCriterion("permission_name <>", value, "permissionName");
            return (Criteria) this;
        }

        public Criteria andPermissionNameGreaterThan(String value) {
            addCriterion("permission_name >", value, "permissionName");
            return (Criteria) this;
        }

        public Criteria andPermissionNameGreaterThanOrEqualTo(String value) {
            addCriterion("permission_name >=", value, "permissionName");
            return (Criteria) this;
        }

        public Criteria andPermissionNameLessThan(String value) {
            addCriterion("permission_name <", value, "permissionName");
            return (Criteria) this;
        }

        public Criteria andPermissionNameLessThanOrEqualTo(String value) {
            addCriterion("permission_name <=", value, "permissionName");
            return (Criteria) this;
        }

        public Criteria andPermissionNameLike(String value) {
            addCriterion("permission_name like", value, "permissionName");
            return (Criteria) this;
        }

        public Criteria andPermissionNameNotLike(String value) {
            addCriterion("permission_name not like", value, "permissionName");
            return (Criteria) this;
        }

        public Criteria andPermissionNameIn(List<String> values) {
            addCriterion("permission_name in", values, "permissionName");
            return (Criteria) this;
        }

        public Criteria andPermissionNameNotIn(List<String> values) {
            addCriterion("permission_name not in", values, "permissionName");
            return (Criteria) this;
        }

        public Criteria andPermissionNameBetween(String value1, String value2) {
            addCriterion("permission_name between", value1, value2, "permissionName");
            return (Criteria) this;
        }

        public Criteria andPermissionNameNotBetween(String value1, String value2) {
            addCriterion("permission_name not between", value1, value2, "permissionName");
            return (Criteria) this;
        }

        public Criteria andRequiredPermissionIsNull() {
            addCriterion("required_permission is null");
            return (Criteria) this;
        }

        public Criteria andRequiredPermissionIsNotNull() {
            addCriterion("required_permission is not null");
            return (Criteria) this;
        }

        public Criteria andRequiredPermissionEqualTo(Long value) {
            addCriterion("required_permission =", value, "requiredPermission");
            return (Criteria) this;
        }

        public Criteria andRequiredPermissionNotEqualTo(Long value) {
            addCriterion("required_permission <>", value, "requiredPermission");
            return (Criteria) this;
        }

        public Criteria andRequiredPermissionGreaterThan(Long value) {
            addCriterion("required_permission >", value, "requiredPermission");
            return (Criteria) this;
        }

        public Criteria andRequiredPermissionGreaterThanOrEqualTo(Long value) {
            addCriterion("required_permission >=", value, "requiredPermission");
            return (Criteria) this;
        }

        public Criteria andRequiredPermissionLessThan(Long value) {
            addCriterion("required_permission <", value, "requiredPermission");
            return (Criteria) this;
        }

        public Criteria andRequiredPermissionLessThanOrEqualTo(Long value) {
            addCriterion("required_permission <=", value, "requiredPermission");
            return (Criteria) this;
        }

        public Criteria andRequiredPermissionIn(List<Long> values) {
            addCriterion("required_permission in", values, "requiredPermission");
            return (Criteria) this;
        }

        public Criteria andRequiredPermissionNotIn(List<Long> values) {
            addCriterion("required_permission not in", values, "requiredPermission");
            return (Criteria) this;
        }

        public Criteria andRequiredPermissionBetween(Long value1, Long value2) {
            addCriterion("required_permission between", value1, value2, "requiredPermission");
            return (Criteria) this;
        }

        public Criteria andRequiredPermissionNotBetween(Long value1, Long value2) {
            addCriterion("required_permission not between", value1, value2, "requiredPermission");
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