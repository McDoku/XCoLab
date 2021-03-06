package com.ext.portlet.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link PlanAttributeLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see PlanAttributeLocalService
 * @generated
 */
public class PlanAttributeLocalServiceWrapper
    implements PlanAttributeLocalService,
        ServiceWrapper<PlanAttributeLocalService> {
    private PlanAttributeLocalService _planAttributeLocalService;

    public PlanAttributeLocalServiceWrapper(
        PlanAttributeLocalService planAttributeLocalService) {
        _planAttributeLocalService = planAttributeLocalService;
    }

    /**
    * Adds the plan attribute to the database. Also notifies the appropriate model listeners.
    *
    * @param planAttribute the plan attribute
    * @return the plan attribute that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.ext.portlet.model.PlanAttribute addPlanAttribute(
        com.ext.portlet.model.PlanAttribute planAttribute)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _planAttributeLocalService.addPlanAttribute(planAttribute);
    }

    /**
    * Creates a new plan attribute with the primary key. Does not add the plan attribute to the database.
    *
    * @param attributeId the primary key for the new plan attribute
    * @return the new plan attribute
    */
    @Override
    public com.ext.portlet.model.PlanAttribute createPlanAttribute(
        long attributeId) {
        return _planAttributeLocalService.createPlanAttribute(attributeId);
    }

    /**
    * Deletes the plan attribute with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param attributeId the primary key of the plan attribute
    * @return the plan attribute that was removed
    * @throws PortalException if a plan attribute with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.ext.portlet.model.PlanAttribute deletePlanAttribute(
        long attributeId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _planAttributeLocalService.deletePlanAttribute(attributeId);
    }

    /**
    * Deletes the plan attribute from the database. Also notifies the appropriate model listeners.
    *
    * @param planAttribute the plan attribute
    * @return the plan attribute that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.ext.portlet.model.PlanAttribute deletePlanAttribute(
        com.ext.portlet.model.PlanAttribute planAttribute)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _planAttributeLocalService.deletePlanAttribute(planAttribute);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _planAttributeLocalService.dynamicQuery();
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
        return _planAttributeLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ext.portlet.model.impl.PlanAttributeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _planAttributeLocalService.dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ext.portlet.model.impl.PlanAttributeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _planAttributeLocalService.dynamicQuery(dynamicQuery, start,
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
        return _planAttributeLocalService.dynamicQueryCount(dynamicQuery);
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
        return _planAttributeLocalService.dynamicQueryCount(dynamicQuery,
            projection);
    }

    @Override
    public com.ext.portlet.model.PlanAttribute fetchPlanAttribute(
        long attributeId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _planAttributeLocalService.fetchPlanAttribute(attributeId);
    }

    /**
    * Returns the plan attribute with the primary key.
    *
    * @param attributeId the primary key of the plan attribute
    * @return the plan attribute
    * @throws PortalException if a plan attribute with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.ext.portlet.model.PlanAttribute getPlanAttribute(
        long attributeId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _planAttributeLocalService.getPlanAttribute(attributeId);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _planAttributeLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the plan attributes.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ext.portlet.model.impl.PlanAttributeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of plan attributes
    * @param end the upper bound of the range of plan attributes (not inclusive)
    * @return the range of plan attributes
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<com.ext.portlet.model.PlanAttribute> getPlanAttributes(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _planAttributeLocalService.getPlanAttributes(start, end);
    }

    /**
    * Returns the number of plan attributes.
    *
    * @return the number of plan attributes
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getPlanAttributesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _planAttributeLocalService.getPlanAttributesCount();
    }

    /**
    * Updates the plan attribute in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param planAttribute the plan attribute
    * @return the plan attribute that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.ext.portlet.model.PlanAttribute updatePlanAttribute(
        com.ext.portlet.model.PlanAttribute planAttribute)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _planAttributeLocalService.updatePlanAttribute(planAttribute);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _planAttributeLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _planAttributeLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _planAttributeLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    @Override
    public void addPlanAttribute(long planId, java.lang.String attributeName,
        java.lang.String attributeValue)
        throws com.liferay.portal.kernel.exception.SystemException {
        _planAttributeLocalService.addPlanAttribute(planId, attributeName,
            attributeValue);
    }

    @Override
    public com.ext.portlet.model.PlanAttribute findPlanAttribute(long planId,
        java.lang.String attributeName)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _planAttributeLocalService.findPlanAttribute(planId,
            attributeName);
    }

    @Override
    public java.util.List<com.ext.portlet.model.PlanAttribute> getPlanAttributes(
        java.lang.Long planId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _planAttributeLocalService.getPlanAttributes(planId);
    }

    @Override
    public java.util.List<com.ext.portlet.model.PlanAttribute> getPlanAttributesByNameValue(
        java.lang.String attributeName, java.lang.String attributeValue)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _planAttributeLocalService.getPlanAttributesByNameValue(attributeName,
            attributeValue);
    }

    @Override
    public java.lang.Object getTypedValue(
        com.ext.portlet.model.PlanAttribute pa) {
        return _planAttributeLocalService.getTypedValue(pa);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public PlanAttributeLocalService getWrappedPlanAttributeLocalService() {
        return _planAttributeLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedPlanAttributeLocalService(
        PlanAttributeLocalService planAttributeLocalService) {
        _planAttributeLocalService = planAttributeLocalService;
    }

    @Override
    public PlanAttributeLocalService getWrappedService() {
        return _planAttributeLocalService;
    }

    @Override
    public void setWrappedService(
        PlanAttributeLocalService planAttributeLocalService) {
        _planAttributeLocalService = planAttributeLocalService;
    }
}
