package com.ext.portlet.model;

import com.liferay.portal.model.ModelWrapper;

/**
 * <p>
 * This class is a wrapper for {@link PlanToPlan}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       PlanToPlan
 * @generated
 */
public class PlanToPlanWrapper implements PlanToPlan, ModelWrapper<PlanToPlan> {
    private PlanToPlan _planToPlan;

    public PlanToPlanWrapper(PlanToPlan planToPlan) {
        _planToPlan = planToPlan;
    }

    public Class<?> getModelClass() {
        return PlanToPlan.class;
    }

    public String getModelClassName() {
        return PlanToPlan.class.getName();
    }

    /**
    * Returns the primary key of this plan to plan.
    *
    * @return the primary key of this plan to plan
    */
    public com.ext.portlet.service.persistence.PlanToPlanPK getPrimaryKey() {
        return _planToPlan.getPrimaryKey();
    }

    /**
    * Sets the primary key of this plan to plan.
    *
    * @param primaryKey the primary key of this plan to plan
    */
    public void setPrimaryKey(
        com.ext.portlet.service.persistence.PlanToPlanPK primaryKey) {
        _planToPlan.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the from plan ID of this plan to plan.
    *
    * @return the from plan ID of this plan to plan
    */
    public long getFromPlanId() {
        return _planToPlan.getFromPlanId();
    }

    /**
    * Sets the from plan ID of this plan to plan.
    *
    * @param fromPlanId the from plan ID of this plan to plan
    */
    public void setFromPlanId(long fromPlanId) {
        _planToPlan.setFromPlanId(fromPlanId);
    }

    /**
    * Returns the to plan ID of this plan to plan.
    *
    * @return the to plan ID of this plan to plan
    */
    public long getToPlanId() {
        return _planToPlan.getToPlanId();
    }

    /**
    * Sets the to plan ID of this plan to plan.
    *
    * @param toPlanId the to plan ID of this plan to plan
    */
    public void setToPlanId(long toPlanId) {
        _planToPlan.setToPlanId(toPlanId);
    }

    /**
    * Returns the reference count of this plan to plan.
    *
    * @return the reference count of this plan to plan
    */
    public int getReferenceCount() {
        return _planToPlan.getReferenceCount();
    }

    /**
    * Sets the reference count of this plan to plan.
    *
    * @param referenceCount the reference count of this plan to plan
    */
    public void setReferenceCount(int referenceCount) {
        _planToPlan.setReferenceCount(referenceCount);
    }

    public boolean isNew() {
        return _planToPlan.isNew();
    }

    public void setNew(boolean n) {
        _planToPlan.setNew(n);
    }

    public boolean isCachedModel() {
        return _planToPlan.isCachedModel();
    }

    public void setCachedModel(boolean cachedModel) {
        _planToPlan.setCachedModel(cachedModel);
    }

    public boolean isEscapedModel() {
        return _planToPlan.isEscapedModel();
    }

    public java.io.Serializable getPrimaryKeyObj() {
        return _planToPlan.getPrimaryKeyObj();
    }

    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _planToPlan.setPrimaryKeyObj(primaryKeyObj);
    }

    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _planToPlan.getExpandoBridge();
    }

    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _planToPlan.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new PlanToPlanWrapper((PlanToPlan) _planToPlan.clone());
    }

    public int compareTo(PlanToPlan planToPlan) {
        return _planToPlan.compareTo(planToPlan);
    }

    @Override
    public int hashCode() {
        return _planToPlan.hashCode();
    }

    public com.liferay.portal.model.CacheModel<PlanToPlan> toCacheModel() {
        return _planToPlan.toCacheModel();
    }

    public PlanToPlan toEscapedModel() {
        return new PlanToPlanWrapper(_planToPlan.toEscapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _planToPlan.toString();
    }

    public java.lang.String toXmlString() {
        return _planToPlan.toXmlString();
    }

    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _planToPlan.persist();
    }

    /**
     * @deprecated Renamed to {@link #getWrappedModel}
     */
    public PlanToPlan getWrappedPlanToPlan() {
        return _planToPlan;
    }

    public PlanToPlan getWrappedModel() {
        return _planToPlan;
    }

    public void resetOriginalValues() {
        _planToPlan.resetOriginalValues();
    }
}
