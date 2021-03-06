package com.ext.portlet.service.persistence;

import com.ext.portlet.model.PlansUserSettings;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the plans user settings service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PlansUserSettingsPersistenceImpl
 * @see PlansUserSettingsUtil
 * @generated
 */
public interface PlansUserSettingsPersistence extends BasePersistence<PlansUserSettings> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link PlansUserSettingsUtil} to access the plans user settings persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns the plans user settings where userId = &#63; and planTypeId = &#63; or throws a {@link com.ext.portlet.NoSuchPlansUserSettingsException} if it could not be found.
    *
    * @param userId the user ID
    * @param planTypeId the plan type ID
    * @return the matching plans user settings
    * @throws com.ext.portlet.NoSuchPlansUserSettingsException if a matching plans user settings could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.ext.portlet.model.PlansUserSettings findByuserIdPlanTypeId(
        long userId, long planTypeId)
        throws com.ext.portlet.NoSuchPlansUserSettingsException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the plans user settings where userId = &#63; and planTypeId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param userId the user ID
    * @param planTypeId the plan type ID
    * @return the matching plans user settings, or <code>null</code> if a matching plans user settings could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.ext.portlet.model.PlansUserSettings fetchByuserIdPlanTypeId(
        long userId, long planTypeId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the plans user settings where userId = &#63; and planTypeId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param userId the user ID
    * @param planTypeId the plan type ID
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching plans user settings, or <code>null</code> if a matching plans user settings could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.ext.portlet.model.PlansUserSettings fetchByuserIdPlanTypeId(
        long userId, long planTypeId, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the plans user settings where userId = &#63; and planTypeId = &#63; from the database.
    *
    * @param userId the user ID
    * @param planTypeId the plan type ID
    * @return the plans user settings that was removed
    * @throws SystemException if a system exception occurred
    */
    public com.ext.portlet.model.PlansUserSettings removeByuserIdPlanTypeId(
        long userId, long planTypeId)
        throws com.ext.portlet.NoSuchPlansUserSettingsException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of plans user settingses where userId = &#63; and planTypeId = &#63;.
    *
    * @param userId the user ID
    * @param planTypeId the plan type ID
    * @return the number of matching plans user settingses
    * @throws SystemException if a system exception occurred
    */
    public int countByuserIdPlanTypeId(long userId, long planTypeId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the plans user settings in the entity cache if it is enabled.
    *
    * @param plansUserSettings the plans user settings
    */
    public void cacheResult(
        com.ext.portlet.model.PlansUserSettings plansUserSettings);

    /**
    * Caches the plans user settingses in the entity cache if it is enabled.
    *
    * @param plansUserSettingses the plans user settingses
    */
    public void cacheResult(
        java.util.List<com.ext.portlet.model.PlansUserSettings> plansUserSettingses);

    /**
    * Creates a new plans user settings with the primary key. Does not add the plans user settings to the database.
    *
    * @param planUserSettingsId the primary key for the new plans user settings
    * @return the new plans user settings
    */
    public com.ext.portlet.model.PlansUserSettings create(
        long planUserSettingsId);

    /**
    * Removes the plans user settings with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param planUserSettingsId the primary key of the plans user settings
    * @return the plans user settings that was removed
    * @throws com.ext.portlet.NoSuchPlansUserSettingsException if a plans user settings with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.ext.portlet.model.PlansUserSettings remove(
        long planUserSettingsId)
        throws com.ext.portlet.NoSuchPlansUserSettingsException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.ext.portlet.model.PlansUserSettings updateImpl(
        com.ext.portlet.model.PlansUserSettings plansUserSettings)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the plans user settings with the primary key or throws a {@link com.ext.portlet.NoSuchPlansUserSettingsException} if it could not be found.
    *
    * @param planUserSettingsId the primary key of the plans user settings
    * @return the plans user settings
    * @throws com.ext.portlet.NoSuchPlansUserSettingsException if a plans user settings with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.ext.portlet.model.PlansUserSettings findByPrimaryKey(
        long planUserSettingsId)
        throws com.ext.portlet.NoSuchPlansUserSettingsException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the plans user settings with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param planUserSettingsId the primary key of the plans user settings
    * @return the plans user settings, or <code>null</code> if a plans user settings with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.ext.portlet.model.PlansUserSettings fetchByPrimaryKey(
        long planUserSettingsId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the plans user settingses.
    *
    * @return the plans user settingses
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.ext.portlet.model.PlansUserSettings> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.ext.portlet.model.PlansUserSettings> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.ext.portlet.model.PlansUserSettings> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the plans user settingses from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of plans user settingses.
    *
    * @return the number of plans user settingses
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
