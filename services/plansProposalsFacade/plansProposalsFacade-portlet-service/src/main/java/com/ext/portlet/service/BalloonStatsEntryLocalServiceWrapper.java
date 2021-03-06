package com.ext.portlet.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link BalloonStatsEntryLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see BalloonStatsEntryLocalService
 * @generated
 */
public class BalloonStatsEntryLocalServiceWrapper
    implements BalloonStatsEntryLocalService,
        ServiceWrapper<BalloonStatsEntryLocalService> {
    private BalloonStatsEntryLocalService _balloonStatsEntryLocalService;

    public BalloonStatsEntryLocalServiceWrapper(
        BalloonStatsEntryLocalService balloonStatsEntryLocalService) {
        _balloonStatsEntryLocalService = balloonStatsEntryLocalService;
    }

    /**
    * Adds the balloon stats entry to the database. Also notifies the appropriate model listeners.
    *
    * @param balloonStatsEntry the balloon stats entry
    * @return the balloon stats entry that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.ext.portlet.model.BalloonStatsEntry addBalloonStatsEntry(
        com.ext.portlet.model.BalloonStatsEntry balloonStatsEntry)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _balloonStatsEntryLocalService.addBalloonStatsEntry(balloonStatsEntry);
    }

    /**
    * Creates a new balloon stats entry with the primary key. Does not add the balloon stats entry to the database.
    *
    * @param id the primary key for the new balloon stats entry
    * @return the new balloon stats entry
    */
    @Override
    public com.ext.portlet.model.BalloonStatsEntry createBalloonStatsEntry(
        long id) {
        return _balloonStatsEntryLocalService.createBalloonStatsEntry(id);
    }

    /**
    * Deletes the balloon stats entry with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the balloon stats entry
    * @return the balloon stats entry that was removed
    * @throws PortalException if a balloon stats entry with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.ext.portlet.model.BalloonStatsEntry deleteBalloonStatsEntry(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _balloonStatsEntryLocalService.deleteBalloonStatsEntry(id);
    }

    /**
    * Deletes the balloon stats entry from the database. Also notifies the appropriate model listeners.
    *
    * @param balloonStatsEntry the balloon stats entry
    * @return the balloon stats entry that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.ext.portlet.model.BalloonStatsEntry deleteBalloonStatsEntry(
        com.ext.portlet.model.BalloonStatsEntry balloonStatsEntry)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _balloonStatsEntryLocalService.deleteBalloonStatsEntry(balloonStatsEntry);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _balloonStatsEntryLocalService.dynamicQuery();
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
        return _balloonStatsEntryLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ext.portlet.model.impl.BalloonStatsEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _balloonStatsEntryLocalService.dynamicQuery(dynamicQuery, start,
            end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ext.portlet.model.impl.BalloonStatsEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _balloonStatsEntryLocalService.dynamicQuery(dynamicQuery, start,
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
        return _balloonStatsEntryLocalService.dynamicQueryCount(dynamicQuery);
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
        return _balloonStatsEntryLocalService.dynamicQueryCount(dynamicQuery,
            projection);
    }

    @Override
    public com.ext.portlet.model.BalloonStatsEntry fetchBalloonStatsEntry(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return _balloonStatsEntryLocalService.fetchBalloonStatsEntry(id);
    }

    /**
    * Returns the balloon stats entry with the primary key.
    *
    * @param id the primary key of the balloon stats entry
    * @return the balloon stats entry
    * @throws PortalException if a balloon stats entry with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.ext.portlet.model.BalloonStatsEntry getBalloonStatsEntry(long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _balloonStatsEntryLocalService.getBalloonStatsEntry(id);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _balloonStatsEntryLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the balloon stats entries.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ext.portlet.model.impl.BalloonStatsEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of balloon stats entries
    * @param end the upper bound of the range of balloon stats entries (not inclusive)
    * @return the range of balloon stats entries
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<com.ext.portlet.model.BalloonStatsEntry> getBalloonStatsEntries(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _balloonStatsEntryLocalService.getBalloonStatsEntries(start, end);
    }

    /**
    * Returns the number of balloon stats entries.
    *
    * @return the number of balloon stats entries
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getBalloonStatsEntriesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _balloonStatsEntryLocalService.getBalloonStatsEntriesCount();
    }

    /**
    * Updates the balloon stats entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param balloonStatsEntry the balloon stats entry
    * @return the balloon stats entry that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.ext.portlet.model.BalloonStatsEntry updateBalloonStatsEntry(
        com.ext.portlet.model.BalloonStatsEntry balloonStatsEntry)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _balloonStatsEntryLocalService.updateBalloonStatsEntry(balloonStatsEntry);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _balloonStatsEntryLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _balloonStatsEntryLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _balloonStatsEntryLocalService.invokeMethod(name,
            parameterTypes, arguments);
    }

    @Override
    public com.ext.portlet.model.BalloonStatsEntry store(
        com.ext.portlet.model.BalloonStatsEntry entry)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _balloonStatsEntryLocalService.store(entry);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public BalloonStatsEntryLocalService getWrappedBalloonStatsEntryLocalService() {
        return _balloonStatsEntryLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedBalloonStatsEntryLocalService(
        BalloonStatsEntryLocalService balloonStatsEntryLocalService) {
        _balloonStatsEntryLocalService = balloonStatsEntryLocalService;
    }

    @Override
    public BalloonStatsEntryLocalService getWrappedService() {
        return _balloonStatsEntryLocalService;
    }

    @Override
    public void setWrappedService(
        BalloonStatsEntryLocalService balloonStatsEntryLocalService) {
        _balloonStatsEntryLocalService = balloonStatsEntryLocalService;
    }
}
