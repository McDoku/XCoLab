package com.ext.portlet.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link PlanDescriptionLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see PlanDescriptionLocalService
 * @generated
 */
public class PlanDescriptionLocalServiceWrapper
    implements PlanDescriptionLocalService,
        ServiceWrapper<PlanDescriptionLocalService> {
    private PlanDescriptionLocalService _planDescriptionLocalService;

    public PlanDescriptionLocalServiceWrapper(
        PlanDescriptionLocalService planDescriptionLocalService) {
        _planDescriptionLocalService = planDescriptionLocalService;
    }

    /**
    * Adds the plan description to the database. Also notifies the appropriate model listeners.
    *
    * @param planDescription the plan description
    * @return the plan description that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.ext.portlet.model.PlanDescription addPlanDescription(
        com.ext.portlet.model.PlanDescription planDescription)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _planDescriptionLocalService.addPlanDescription(planDescription);
    }

    /**
    * Creates a new plan description with the primary key. Does not add the plan description to the database.
    *
    * @param id the primary key for the new plan description
    * @return the new plan description
    */
    @Override
    public com.ext.portlet.model.PlanDescription createPlanDescription(long id) {
        return _planDescriptionLocalService.createPlanDescription(id);
    }

    /**
    * Deletes the plan description with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the plan description
    * @return the plan description that was removed
    * @throws PortalException if a plan description with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.ext.portlet.model.PlanDescription deletePlanDescription(long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _planDescriptionLocalService.deletePlanDescription(id);
    }

    /**
    * Deletes the plan description from the database. Also notifies the appropriate model listeners.
    *
    * @param planDescription the plan description
    * @return the plan description that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.ext.portlet.model.PlanDescription deletePlanDescription(
        com.ext.portlet.model.PlanDescription planDescription)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _planDescriptionLocalService.deletePlanDescription(planDescription);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _planDescriptionLocalService.dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _planDescriptionLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ext.portlet.model.impl.PlanDescriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @return the range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return _planDescriptionLocalService.dynamicQuery(dynamicQuery, start,
            end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ext.portlet.model.impl.PlanDescriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _planDescriptionLocalService.dynamicQuery(dynamicQuery, start,
            end, orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    @Override
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _planDescriptionLocalService.dynamicQueryCount(dynamicQuery);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @param projection the projection to apply to the query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    @Override
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
        com.liferay.portal.kernel.dao.orm.Projection projection)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _planDescriptionLocalService.dynamicQueryCount(dynamicQuery,
            projection);
    }

    @Override
    public com.ext.portlet.model.PlanDescription fetchPlanDescription(long id)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _planDescriptionLocalService.fetchPlanDescription(id);
    }

    /**
    * Returns the plan description with the primary key.
    *
    * @param id the primary key of the plan description
    * @return the plan description
    * @throws PortalException if a plan description with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.ext.portlet.model.PlanDescription getPlanDescription(long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _planDescriptionLocalService.getPlanDescription(id);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _planDescriptionLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the plan descriptions.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ext.portlet.model.impl.PlanDescriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of plan descriptions
    * @param end the upper bound of the range of plan descriptions (not inclusive)
    * @return the range of plan descriptions
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<com.ext.portlet.model.PlanDescription> getPlanDescriptions(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _planDescriptionLocalService.getPlanDescriptions(start, end);
    }

    /**
    * Returns the number of plan descriptions.
    *
    * @return the number of plan descriptions
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getPlanDescriptionsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _planDescriptionLocalService.getPlanDescriptionsCount();
    }

    /**
    * Updates the plan description in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param planDescription the plan description
    * @return the plan description that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.ext.portlet.model.PlanDescription updatePlanDescription(
        com.ext.portlet.model.PlanDescription planDescription)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _planDescriptionLocalService.updatePlanDescription(planDescription);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _planDescriptionLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _planDescriptionLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _planDescriptionLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    @Override
    public com.ext.portlet.model.PlanDescription createPlanDescription(
        com.ext.portlet.model.PlanItem plan, java.lang.String name)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _planDescriptionLocalService.createPlanDescription(plan, name);
    }

    @Override
    public com.ext.portlet.model.PlanDescription createPlanDescription(
        com.ext.portlet.model.PlanItem plan, java.lang.String name,
        boolean store)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _planDescriptionLocalService.createPlanDescription(plan, name,
            store);
    }

    @Override
    public com.ext.portlet.model.PlanDescription getCurrentForPlan(
        com.ext.portlet.model.PlanItem plan)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _planDescriptionLocalService.getCurrentForPlan(plan);
    }

    @Override
    public com.ext.portlet.model.PlanDescription getForPlan(
        com.ext.portlet.model.PlanItem plan)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _planDescriptionLocalService.getForPlan(plan);
    }

    @Override
    public java.util.List<com.ext.portlet.model.PlanDescription> getAllForPlan(
        com.ext.portlet.model.PlanItem plan)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _planDescriptionLocalService.getAllForPlan(plan);
    }

    @Override
    public com.ext.portlet.model.PlanDescription createNewVersionForPlan(
        com.ext.portlet.model.PlanItem plan)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _planDescriptionLocalService.createNewVersionForPlan(plan);
    }

    @Override
    public com.ext.portlet.model.PlanDescription createNewVersionForPlan(
        com.ext.portlet.model.PlanItem plan, boolean store)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _planDescriptionLocalService.createNewVersionForPlan(plan, store);
    }

    @Override
    public com.ext.portlet.model.PlanDescription createNewVersionForPlanFrom(
        com.ext.portlet.model.PlanItem plan,
        com.ext.portlet.model.PlanDescription from, boolean store)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _planDescriptionLocalService.createNewVersionForPlanFrom(plan,
            from, store);
    }

    @Override
    public void store(com.ext.portlet.model.PlanDescription pd)
        throws com.liferay.portal.kernel.exception.SystemException {
        _planDescriptionLocalService.store(pd);
    }

    @Override
    public com.liferay.portal.model.User getUpdateAuthor(
        com.ext.portlet.model.PlanDescription pd)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _planDescriptionLocalService.getUpdateAuthor(pd);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public PlanDescriptionLocalService getWrappedPlanDescriptionLocalService() {
        return _planDescriptionLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedPlanDescriptionLocalService(
        PlanDescriptionLocalService planDescriptionLocalService) {
        _planDescriptionLocalService = planDescriptionLocalService;
    }

    @Override
    public PlanDescriptionLocalService getWrappedService() {
        return _planDescriptionLocalService;
    }

    @Override
    public void setWrappedService(
        PlanDescriptionLocalService planDescriptionLocalService) {
        _planDescriptionLocalService = planDescriptionLocalService;
    }
}
