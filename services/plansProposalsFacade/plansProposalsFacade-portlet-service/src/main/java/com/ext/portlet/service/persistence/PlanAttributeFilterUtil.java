package com.ext.portlet.service.persistence;

import com.ext.portlet.model.PlanAttributeFilter;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the plan attribute filter service. This utility wraps {@link PlanAttributeFilterPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PlanAttributeFilterPersistence
 * @see PlanAttributeFilterPersistenceImpl
 * @generated
 */
public class PlanAttributeFilterUtil {
    private static PlanAttributeFilterPersistence _persistence;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
     */
    public static void clearCache() {
        getPersistence().clearCache();
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
     */
    public static void clearCache(PlanAttributeFilter planAttributeFilter) {
        getPersistence().clearCache(planAttributeFilter);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
     */
    public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().countWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
     */
    public static List<PlanAttributeFilter> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<PlanAttributeFilter> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<PlanAttributeFilter> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static PlanAttributeFilter update(
        PlanAttributeFilter planAttributeFilter) throws SystemException {
        return getPersistence().update(planAttributeFilter);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static PlanAttributeFilter update(
        PlanAttributeFilter planAttributeFilter, ServiceContext serviceContext)
        throws SystemException {
        return getPersistence().update(planAttributeFilter, serviceContext);
    }

    /**
    * Returns the plan attribute filter where planUserSettingsId = &#63; and attributeName = &#63; or throws a {@link com.ext.portlet.NoSuchPlanAttributeFilterException} if it could not be found.
    *
    * @param planUserSettingsId the plan user settings ID
    * @param attributeName the attribute name
    * @return the matching plan attribute filter
    * @throws com.ext.portlet.NoSuchPlanAttributeFilterException if a matching plan attribute filter could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.ext.portlet.model.PlanAttributeFilter findByPlanUserSettingsIdAttributeName(
        long planUserSettingsId, java.lang.String attributeName)
        throws com.ext.portlet.NoSuchPlanAttributeFilterException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByPlanUserSettingsIdAttributeName(planUserSettingsId,
            attributeName);
    }

    /**
    * Returns the plan attribute filter where planUserSettingsId = &#63; and attributeName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param planUserSettingsId the plan user settings ID
    * @param attributeName the attribute name
    * @return the matching plan attribute filter, or <code>null</code> if a matching plan attribute filter could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.ext.portlet.model.PlanAttributeFilter fetchByPlanUserSettingsIdAttributeName(
        long planUserSettingsId, java.lang.String attributeName)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByPlanUserSettingsIdAttributeName(planUserSettingsId,
            attributeName);
    }

    /**
    * Returns the plan attribute filter where planUserSettingsId = &#63; and attributeName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param planUserSettingsId the plan user settings ID
    * @param attributeName the attribute name
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching plan attribute filter, or <code>null</code> if a matching plan attribute filter could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.ext.portlet.model.PlanAttributeFilter fetchByPlanUserSettingsIdAttributeName(
        long planUserSettingsId, java.lang.String attributeName,
        boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByPlanUserSettingsIdAttributeName(planUserSettingsId,
            attributeName, retrieveFromCache);
    }

    /**
    * Removes the plan attribute filter where planUserSettingsId = &#63; and attributeName = &#63; from the database.
    *
    * @param planUserSettingsId the plan user settings ID
    * @param attributeName the attribute name
    * @return the plan attribute filter that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.ext.portlet.model.PlanAttributeFilter removeByPlanUserSettingsIdAttributeName(
        long planUserSettingsId, java.lang.String attributeName)
        throws com.ext.portlet.NoSuchPlanAttributeFilterException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .removeByPlanUserSettingsIdAttributeName(planUserSettingsId,
            attributeName);
    }

    /**
    * Returns the number of plan attribute filters where planUserSettingsId = &#63; and attributeName = &#63;.
    *
    * @param planUserSettingsId the plan user settings ID
    * @param attributeName the attribute name
    * @return the number of matching plan attribute filters
    * @throws SystemException if a system exception occurred
    */
    public static int countByPlanUserSettingsIdAttributeName(
        long planUserSettingsId, java.lang.String attributeName)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .countByPlanUserSettingsIdAttributeName(planUserSettingsId,
            attributeName);
    }

    /**
    * Caches the plan attribute filter in the entity cache if it is enabled.
    *
    * @param planAttributeFilter the plan attribute filter
    */
    public static void cacheResult(
        com.ext.portlet.model.PlanAttributeFilter planAttributeFilter) {
        getPersistence().cacheResult(planAttributeFilter);
    }

    /**
    * Caches the plan attribute filters in the entity cache if it is enabled.
    *
    * @param planAttributeFilters the plan attribute filters
    */
    public static void cacheResult(
        java.util.List<com.ext.portlet.model.PlanAttributeFilter> planAttributeFilters) {
        getPersistence().cacheResult(planAttributeFilters);
    }

    /**
    * Creates a new plan attribute filter with the primary key. Does not add the plan attribute filter to the database.
    *
    * @param planAttributeFilterId the primary key for the new plan attribute filter
    * @return the new plan attribute filter
    */
    public static com.ext.portlet.model.PlanAttributeFilter create(
        long planAttributeFilterId) {
        return getPersistence().create(planAttributeFilterId);
    }

    /**
    * Removes the plan attribute filter with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param planAttributeFilterId the primary key of the plan attribute filter
    * @return the plan attribute filter that was removed
    * @throws com.ext.portlet.NoSuchPlanAttributeFilterException if a plan attribute filter with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.ext.portlet.model.PlanAttributeFilter remove(
        long planAttributeFilterId)
        throws com.ext.portlet.NoSuchPlanAttributeFilterException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(planAttributeFilterId);
    }

    public static com.ext.portlet.model.PlanAttributeFilter updateImpl(
        com.ext.portlet.model.PlanAttributeFilter planAttributeFilter)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(planAttributeFilter);
    }

    /**
    * Returns the plan attribute filter with the primary key or throws a {@link com.ext.portlet.NoSuchPlanAttributeFilterException} if it could not be found.
    *
    * @param planAttributeFilterId the primary key of the plan attribute filter
    * @return the plan attribute filter
    * @throws com.ext.portlet.NoSuchPlanAttributeFilterException if a plan attribute filter with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.ext.portlet.model.PlanAttributeFilter findByPrimaryKey(
        long planAttributeFilterId)
        throws com.ext.portlet.NoSuchPlanAttributeFilterException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(planAttributeFilterId);
    }

    /**
    * Returns the plan attribute filter with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param planAttributeFilterId the primary key of the plan attribute filter
    * @return the plan attribute filter, or <code>null</code> if a plan attribute filter with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.ext.portlet.model.PlanAttributeFilter fetchByPrimaryKey(
        long planAttributeFilterId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(planAttributeFilterId);
    }

    /**
    * Returns all the plan attribute filters.
    *
    * @return the plan attribute filters
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.ext.portlet.model.PlanAttributeFilter> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the plan attribute filters.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ext.portlet.model.impl.PlanAttributeFilterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of plan attribute filters
    * @param end the upper bound of the range of plan attribute filters (not inclusive)
    * @return the range of plan attribute filters
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.ext.portlet.model.PlanAttributeFilter> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the plan attribute filters.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ext.portlet.model.impl.PlanAttributeFilterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of plan attribute filters
    * @param end the upper bound of the range of plan attribute filters (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of plan attribute filters
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.ext.portlet.model.PlanAttributeFilter> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the plan attribute filters from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of plan attribute filters.
    *
    * @return the number of plan attribute filters
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static PlanAttributeFilterPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (PlanAttributeFilterPersistence) PortletBeanLocatorUtil.locate(com.ext.portlet.service.ClpSerializer.getServletContextName(),
                    PlanAttributeFilterPersistence.class.getName());

            ReferenceRegistry.registerReference(PlanAttributeFilterUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(PlanAttributeFilterPersistence persistence) {
    }
}
