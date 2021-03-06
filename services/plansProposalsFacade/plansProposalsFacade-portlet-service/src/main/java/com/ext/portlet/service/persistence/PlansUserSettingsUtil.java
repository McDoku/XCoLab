package com.ext.portlet.service.persistence;

import com.ext.portlet.model.PlansUserSettings;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the plans user settings service. This utility wraps {@link PlansUserSettingsPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PlansUserSettingsPersistence
 * @see PlansUserSettingsPersistenceImpl
 * @generated
 */
public class PlansUserSettingsUtil {
    private static PlansUserSettingsPersistence _persistence;

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
    public static void clearCache(PlansUserSettings plansUserSettings) {
        getPersistence().clearCache(plansUserSettings);
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
    public static List<PlansUserSettings> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<PlansUserSettings> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<PlansUserSettings> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static PlansUserSettings update(PlansUserSettings plansUserSettings)
        throws SystemException {
        return getPersistence().update(plansUserSettings);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static PlansUserSettings update(
        PlansUserSettings plansUserSettings, ServiceContext serviceContext)
        throws SystemException {
        return getPersistence().update(plansUserSettings, serviceContext);
    }

    /**
    * Returns the plans user settings where userId = &#63; and planTypeId = &#63; or throws a {@link com.ext.portlet.NoSuchPlansUserSettingsException} if it could not be found.
    *
    * @param userId the user ID
    * @param planTypeId the plan type ID
    * @return the matching plans user settings
    * @throws com.ext.portlet.NoSuchPlansUserSettingsException if a matching plans user settings could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.ext.portlet.model.PlansUserSettings findByuserIdPlanTypeId(
        long userId, long planTypeId)
        throws com.ext.portlet.NoSuchPlansUserSettingsException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByuserIdPlanTypeId(userId, planTypeId);
    }

    /**
    * Returns the plans user settings where userId = &#63; and planTypeId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param userId the user ID
    * @param planTypeId the plan type ID
    * @return the matching plans user settings, or <code>null</code> if a matching plans user settings could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.ext.portlet.model.PlansUserSettings fetchByuserIdPlanTypeId(
        long userId, long planTypeId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByuserIdPlanTypeId(userId, planTypeId);
    }

    /**
    * Returns the plans user settings where userId = &#63; and planTypeId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param userId the user ID
    * @param planTypeId the plan type ID
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching plans user settings, or <code>null</code> if a matching plans user settings could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.ext.portlet.model.PlansUserSettings fetchByuserIdPlanTypeId(
        long userId, long planTypeId, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByuserIdPlanTypeId(userId, planTypeId,
            retrieveFromCache);
    }

    /**
    * Removes the plans user settings where userId = &#63; and planTypeId = &#63; from the database.
    *
    * @param userId the user ID
    * @param planTypeId the plan type ID
    * @return the plans user settings that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.ext.portlet.model.PlansUserSettings removeByuserIdPlanTypeId(
        long userId, long planTypeId)
        throws com.ext.portlet.NoSuchPlansUserSettingsException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().removeByuserIdPlanTypeId(userId, planTypeId);
    }

    /**
    * Returns the number of plans user settingses where userId = &#63; and planTypeId = &#63;.
    *
    * @param userId the user ID
    * @param planTypeId the plan type ID
    * @return the number of matching plans user settingses
    * @throws SystemException if a system exception occurred
    */
    public static int countByuserIdPlanTypeId(long userId, long planTypeId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByuserIdPlanTypeId(userId, planTypeId);
    }

    /**
    * Caches the plans user settings in the entity cache if it is enabled.
    *
    * @param plansUserSettings the plans user settings
    */
    public static void cacheResult(
        com.ext.portlet.model.PlansUserSettings plansUserSettings) {
        getPersistence().cacheResult(plansUserSettings);
    }

    /**
    * Caches the plans user settingses in the entity cache if it is enabled.
    *
    * @param plansUserSettingses the plans user settingses
    */
    public static void cacheResult(
        java.util.List<com.ext.portlet.model.PlansUserSettings> plansUserSettingses) {
        getPersistence().cacheResult(plansUserSettingses);
    }

    /**
    * Creates a new plans user settings with the primary key. Does not add the plans user settings to the database.
    *
    * @param planUserSettingsId the primary key for the new plans user settings
    * @return the new plans user settings
    */
    public static com.ext.portlet.model.PlansUserSettings create(
        long planUserSettingsId) {
        return getPersistence().create(planUserSettingsId);
    }

    /**
    * Removes the plans user settings with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param planUserSettingsId the primary key of the plans user settings
    * @return the plans user settings that was removed
    * @throws com.ext.portlet.NoSuchPlansUserSettingsException if a plans user settings with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.ext.portlet.model.PlansUserSettings remove(
        long planUserSettingsId)
        throws com.ext.portlet.NoSuchPlansUserSettingsException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(planUserSettingsId);
    }

    public static com.ext.portlet.model.PlansUserSettings updateImpl(
        com.ext.portlet.model.PlansUserSettings plansUserSettings)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(plansUserSettings);
    }

    /**
    * Returns the plans user settings with the primary key or throws a {@link com.ext.portlet.NoSuchPlansUserSettingsException} if it could not be found.
    *
    * @param planUserSettingsId the primary key of the plans user settings
    * @return the plans user settings
    * @throws com.ext.portlet.NoSuchPlansUserSettingsException if a plans user settings with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.ext.portlet.model.PlansUserSettings findByPrimaryKey(
        long planUserSettingsId)
        throws com.ext.portlet.NoSuchPlansUserSettingsException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(planUserSettingsId);
    }

    /**
    * Returns the plans user settings with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param planUserSettingsId the primary key of the plans user settings
    * @return the plans user settings, or <code>null</code> if a plans user settings with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.ext.portlet.model.PlansUserSettings fetchByPrimaryKey(
        long planUserSettingsId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(planUserSettingsId);
    }

    /**
    * Returns all the plans user settingses.
    *
    * @return the plans user settingses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.ext.portlet.model.PlansUserSettings> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the plans user settingses.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ext.portlet.model.impl.PlansUserSettingsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of plans user settingses
    * @param end the upper bound of the range of plans user settingses (not inclusive)
    * @return the range of plans user settingses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.ext.portlet.model.PlansUserSettings> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the plans user settingses.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ext.portlet.model.impl.PlansUserSettingsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of plans user settingses
    * @param end the upper bound of the range of plans user settingses (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of plans user settingses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.ext.portlet.model.PlansUserSettings> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the plans user settingses from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of plans user settingses.
    *
    * @return the number of plans user settingses
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static PlansUserSettingsPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (PlansUserSettingsPersistence) PortletBeanLocatorUtil.locate(com.ext.portlet.service.ClpSerializer.getServletContextName(),
                    PlansUserSettingsPersistence.class.getName());

            ReferenceRegistry.registerReference(PlansUserSettingsUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(PlansUserSettingsPersistence persistence) {
    }
}
