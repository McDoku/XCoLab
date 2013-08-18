package com.ext.portlet.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link PlanToPlanLocalService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       PlanToPlanLocalService
 * @generated
 */
public class PlanToPlanLocalServiceWrapper implements PlanToPlanLocalService,
    ServiceWrapper<PlanToPlanLocalService> {
    private PlanToPlanLocalService _planToPlanLocalService;

    public PlanToPlanLocalServiceWrapper(
        PlanToPlanLocalService planToPlanLocalService) {
        _planToPlanLocalService = planToPlanLocalService;
    }

    /**
    * Adds the plan to plan to the database. Also notifies the appropriate model listeners.
    *
    * @param planToPlan the plan to plan
    * @return the plan to plan that was added
    * @throws SystemException if a system exception occurred
    */
    public com.ext.portlet.model.PlanToPlan addPlanToPlan(
        com.ext.portlet.model.PlanToPlan planToPlan)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _planToPlanLocalService.addPlanToPlan(planToPlan);
    }

    /**
    * Creates a new plan to plan with the primary key. Does not add the plan to plan to the database.
    *
    * @param planToPlanPK the primary key for the new plan to plan
    * @return the new plan to plan
    */
    public com.ext.portlet.model.PlanToPlan createPlanToPlan(
        com.ext.portlet.service.persistence.PlanToPlanPK planToPlanPK) {
        return _planToPlanLocalService.createPlanToPlan(planToPlanPK);
    }

    /**
    * Deletes the plan to plan with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param planToPlanPK the primary key of the plan to plan
    * @throws PortalException if a plan to plan with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public void deletePlanToPlan(
        com.ext.portlet.service.persistence.PlanToPlanPK planToPlanPK)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        _planToPlanLocalService.deletePlanToPlan(planToPlanPK);
    }

    /**
    * Deletes the plan to plan from the database. Also notifies the appropriate model listeners.
    *
    * @param planToPlan the plan to plan
    * @throws SystemException if a system exception occurred
    */
    public void deletePlanToPlan(com.ext.portlet.model.PlanToPlan planToPlan)
        throws com.liferay.portal.kernel.exception.SystemException {
        _planToPlanLocalService.deletePlanToPlan(planToPlan);
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _planToPlanLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @return the range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return _planToPlanLocalService.dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _planToPlanLocalService.dynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _planToPlanLocalService.dynamicQueryCount(dynamicQuery);
    }

    public com.ext.portlet.model.PlanToPlan fetchPlanToPlan(
        com.ext.portlet.service.persistence.PlanToPlanPK planToPlanPK)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _planToPlanLocalService.fetchPlanToPlan(planToPlanPK);
    }

    /**
    * Returns the plan to plan with the primary key.
    *
    * @param planToPlanPK the primary key of the plan to plan
    * @return the plan to plan
    * @throws PortalException if a plan to plan with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.ext.portlet.model.PlanToPlan getPlanToPlan(
        com.ext.portlet.service.persistence.PlanToPlanPK planToPlanPK)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _planToPlanLocalService.getPlanToPlan(planToPlanPK);
    }

    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _planToPlanLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the plan to plans.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of plan to plans
    * @param end the upper bound of the range of plan to plans (not inclusive)
    * @return the range of plan to plans
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.ext.portlet.model.PlanToPlan> getPlanToPlans(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _planToPlanLocalService.getPlanToPlans(start, end);
    }

    /**
    * Returns the number of plan to plans.
    *
    * @return the number of plan to plans
    * @throws SystemException if a system exception occurred
    */
    public int getPlanToPlansCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _planToPlanLocalService.getPlanToPlansCount();
    }

    /**
    * Updates the plan to plan in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param planToPlan the plan to plan
    * @return the plan to plan that was updated
    * @throws SystemException if a system exception occurred
    */
    public com.ext.portlet.model.PlanToPlan updatePlanToPlan(
        com.ext.portlet.model.PlanToPlan planToPlan)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _planToPlanLocalService.updatePlanToPlan(planToPlan);
    }

    /**
    * Updates the plan to plan in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param planToPlan the plan to plan
    * @param merge whether to merge the plan to plan with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
    * @return the plan to plan that was updated
    * @throws SystemException if a system exception occurred
    */
    public com.ext.portlet.model.PlanToPlan updatePlanToPlan(
        com.ext.portlet.model.PlanToPlan planToPlan, boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _planToPlanLocalService.updatePlanToPlan(planToPlan, merge);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public java.lang.String getBeanIdentifier() {
        return _planToPlanLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _planToPlanLocalService.setBeanIdentifier(beanIdentifier);
    }

    /**
    * Update reference counter for given pair of proposals (we form directed graph with weights)
    *
    * @param fromPlanId plan that references other plan
    * @param toPlanId referenced plan
    * @param value number of detected references, represents a change in references count, (can be either positive
    - new references added or negative - references count decreased)
    * @throws SystemException
    */
    public void updateReference(java.lang.Long fromPlanId,
        java.lang.Long toPlanId, int value)
        throws com.liferay.portal.kernel.exception.SystemException {
        _planToPlanLocalService.updateReference(fromPlanId, toPlanId, value);
    }

    /**
    * Returns list of plan ids referenced by a given plan
    *
    * @param fromPlanId id of a plan for which references are to be returned
    * @return list of plan ids referenced by a given plan
    * @throws SystemException
    */
    public java.util.List<java.lang.Long> getReferencedPlansList(
        java.lang.Long fromPlanId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _planToPlanLocalService.getReferencedPlansList(fromPlanId);
    }

    /**
    * Returns list of plan ids that are referencing a given plan
    *
    * @param toPlanId id of a plan for which referencing plans should be found
    * @return list of plan ids referencing given plan
    * @throws SystemException
    */
    public java.util.List<java.lang.Long> getReferencingPlansList(
        java.lang.Long toPlanId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _planToPlanLocalService.getReferencingPlansList(toPlanId);
    }

    /**
    * Stores enitity.
    *
    * @param ptp
    * @throws SystemException
    */
    public void store(com.ext.portlet.model.PlanToPlan ptp)
        throws com.liferay.portal.kernel.exception.SystemException {
        _planToPlanLocalService.store(ptp);
    }

    /**
    * Removes references made from given plan
    *
    * @param fromPlanId plan from which references should be removed
    * @throws SystemException
    */
    public void removeReferences(java.lang.Long fromPlanId)
        throws com.liferay.portal.kernel.exception.SystemException {
        _planToPlanLocalService.removeReferences(fromPlanId);
    }

    /**
     * @deprecated Renamed to {@link #getWrappedService}
     */
    public PlanToPlanLocalService getWrappedPlanToPlanLocalService() {
        return _planToPlanLocalService;
    }

    /**
     * @deprecated Renamed to {@link #setWrappedService}
     */
    public void setWrappedPlanToPlanLocalService(
        PlanToPlanLocalService planToPlanLocalService) {
        _planToPlanLocalService = planToPlanLocalService;
    }

    public PlanToPlanLocalService getWrappedService() {
        return _planToPlanLocalService;
    }

    public void setWrappedService(PlanToPlanLocalService planToPlanLocalService) {
        _planToPlanLocalService = planToPlanLocalService;
    }
}
