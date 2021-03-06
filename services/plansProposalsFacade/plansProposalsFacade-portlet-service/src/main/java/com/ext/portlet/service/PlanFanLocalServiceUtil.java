package com.ext.portlet.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for PlanFan. This utility wraps
 * {@link com.ext.portlet.service.impl.PlanFanLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see PlanFanLocalService
 * @see com.ext.portlet.service.base.PlanFanLocalServiceBaseImpl
 * @see com.ext.portlet.service.impl.PlanFanLocalServiceImpl
 * @generated
 */
public class PlanFanLocalServiceUtil {
    private static PlanFanLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.ext.portlet.service.impl.PlanFanLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the plan fan to the database. Also notifies the appropriate model listeners.
    *
    * @param planFan the plan fan
    * @return the plan fan that was added
    * @throws SystemException if a system exception occurred
    */
    public static com.ext.portlet.model.PlanFan addPlanFan(
        com.ext.portlet.model.PlanFan planFan)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addPlanFan(planFan);
    }

    /**
    * Creates a new plan fan with the primary key. Does not add the plan fan to the database.
    *
    * @param id the primary key for the new plan fan
    * @return the new plan fan
    */
    public static com.ext.portlet.model.PlanFan createPlanFan(long id) {
        return getService().createPlanFan(id);
    }

    /**
    * Deletes the plan fan with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the plan fan
    * @return the plan fan that was removed
    * @throws PortalException if a plan fan with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.ext.portlet.model.PlanFan deletePlanFan(long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deletePlanFan(id);
    }

    /**
    * Deletes the plan fan from the database. Also notifies the appropriate model listeners.
    *
    * @param planFan the plan fan
    * @return the plan fan that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.ext.portlet.model.PlanFan deletePlanFan(
        com.ext.portlet.model.PlanFan planFan)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deletePlanFan(planFan);
    }

    public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return getService().dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ext.portlet.model.impl.PlanFanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @return the range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ext.portlet.model.impl.PlanFanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @param projection the projection to apply to the query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
        com.liferay.portal.kernel.dao.orm.Projection projection)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery, projection);
    }

    public static com.ext.portlet.model.PlanFan fetchPlanFan(long id)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchPlanFan(id);
    }

    /**
    * Returns the plan fan with the primary key.
    *
    * @param id the primary key of the plan fan
    * @return the plan fan
    * @throws PortalException if a plan fan with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.ext.portlet.model.PlanFan getPlanFan(long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPlanFan(id);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the plan fans.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ext.portlet.model.impl.PlanFanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of plan fans
    * @param end the upper bound of the range of plan fans (not inclusive)
    * @return the range of plan fans
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.ext.portlet.model.PlanFan> getPlanFans(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getPlanFans(start, end);
    }

    /**
    * Returns the number of plan fans.
    *
    * @return the number of plan fans
    * @throws SystemException if a system exception occurred
    */
    public static int getPlanFansCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getPlanFansCount();
    }

    /**
    * Updates the plan fan in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param planFan the plan fan
    * @return the plan fan that was updated
    * @throws SystemException if a system exception occurred
    */
    public static com.ext.portlet.model.PlanFan updatePlanFan(
        com.ext.portlet.model.PlanFan planFan)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updatePlanFan(planFan);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public static java.lang.String getBeanIdentifier() {
        return getService().getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public static void setBeanIdentifier(java.lang.String beanIdentifier) {
        getService().setBeanIdentifier(beanIdentifier);
    }

    public static java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return getService().invokeMethod(name, parameterTypes, arguments);
    }

    public static java.util.List<com.ext.portlet.model.PlanFan> getPlanFansForPlan(
        java.lang.Long planId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getPlanFansForPlan(planId);
    }

    public static int countPlanFansForPlan(java.lang.Long planId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().countPlanFansForPlan(planId);
    }

    public static java.util.List<com.ext.portlet.model.PlanFan> getPlanFansForUser(
        java.lang.Long userId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getPlanFansForUser(userId);
    }

    public static com.ext.portlet.model.PlanFan addFan(java.lang.Long planId,
        java.lang.Long userId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addFan(planId, userId);
    }

    public static void removePlanFan(java.lang.Long planId,
        java.lang.Long userId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().removePlanFan(planId, userId);
    }

    public static com.ext.portlet.model.PlanFan getPlanFanByPlanIdUserId(
        java.lang.Long planId, java.lang.Long userId)
        throws com.ext.portlet.NoSuchPlanFanException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPlanFanByPlanIdUserId(planId, userId);
    }

    public static int countByUserId(java.lang.Long userId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().countByUserId(userId);
    }

    public static java.util.List<com.ext.portlet.model.PlanFan> getByUserId(
        java.lang.Long userId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getByUserId(userId, start, end);
    }

    public static void store(com.ext.portlet.model.PlanFan pf)
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().store(pf);
    }

    public static com.liferay.portal.model.User getUser(
        com.ext.portlet.model.PlanFan pf)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getUser(pf);
    }

    public static com.ext.portlet.model.PlanItem getPlan(
        com.ext.portlet.model.PlanFan pf)
        throws com.ext.portlet.NoSuchPlanItemException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPlan(pf);
    }

    public static void clearService() {
        _service = null;
    }

    public static PlanFanLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    PlanFanLocalService.class.getName());

            if (invokableLocalService instanceof PlanFanLocalService) {
                _service = (PlanFanLocalService) invokableLocalService;
            } else {
                _service = new PlanFanLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(PlanFanLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(PlanFanLocalService service) {
    }
}
