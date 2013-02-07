package com.ext.portlet.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.PersistedModelLocalService;

/**
 * The interface for the messaging redirect link local service.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MessagingRedirectLinkLocalServiceUtil
 * @see com.ext.portlet.service.base.MessagingRedirectLinkLocalServiceBaseImpl
 * @see com.ext.portlet.service.impl.MessagingRedirectLinkLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface MessagingRedirectLinkLocalService
    extends PersistedModelLocalService {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link MessagingRedirectLinkLocalServiceUtil} to access the messaging redirect link local service. Add custom service methods to {@link com.ext.portlet.service.impl.MessagingRedirectLinkLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
     */

    /**
    * Adds the messaging redirect link to the database. Also notifies the appropriate model listeners.
    *
    * @param messagingRedirectLink the messaging redirect link
    * @return the messaging redirect link that was added
    * @throws SystemException if a system exception occurred
    */
    public com.ext.portlet.model.MessagingRedirectLink addMessagingRedirectLink(
        com.ext.portlet.model.MessagingRedirectLink messagingRedirectLink)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Creates a new messaging redirect link with the primary key. Does not add the messaging redirect link to the database.
    *
    * @param redirectId the primary key for the new messaging redirect link
    * @return the new messaging redirect link
    */
    public com.ext.portlet.model.MessagingRedirectLink createMessagingRedirectLink(
        long redirectId);

    /**
    * Deletes the messaging redirect link with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param redirectId the primary key of the messaging redirect link
    * @throws PortalException if a messaging redirect link with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public void deleteMessagingRedirectLink(long redirectId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Deletes the messaging redirect link from the database. Also notifies the appropriate model listeners.
    *
    * @param messagingRedirectLink the messaging redirect link
    * @throws SystemException if a system exception occurred
    */
    public void deleteMessagingRedirectLink(
        com.ext.portlet.model.MessagingRedirectLink messagingRedirectLink)
        throws com.liferay.portal.kernel.exception.SystemException;

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
        throws com.liferay.portal.kernel.exception.SystemException;

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
        int end) throws com.liferay.portal.kernel.exception.SystemException;

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
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.ext.portlet.model.MessagingRedirectLink fetchMessagingRedirectLink(
        long redirectId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the messaging redirect link with the primary key.
    *
    * @param redirectId the primary key of the messaging redirect link
    * @return the messaging redirect link
    * @throws PortalException if a messaging redirect link with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.ext.portlet.model.MessagingRedirectLink getMessagingRedirectLink(
        long redirectId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the messaging redirect links.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of messaging redirect links
    * @param end the upper bound of the range of messaging redirect links (not inclusive)
    * @return the range of messaging redirect links
    * @throws SystemException if a system exception occurred
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.ext.portlet.model.MessagingRedirectLink> getMessagingRedirectLinks(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of messaging redirect links.
    *
    * @return the number of messaging redirect links
    * @throws SystemException if a system exception occurred
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getMessagingRedirectLinksCount()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Updates the messaging redirect link in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param messagingRedirectLink the messaging redirect link
    * @return the messaging redirect link that was updated
    * @throws SystemException if a system exception occurred
    */
    public com.ext.portlet.model.MessagingRedirectLink updateMessagingRedirectLink(
        com.ext.portlet.model.MessagingRedirectLink messagingRedirectLink)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Updates the messaging redirect link in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param messagingRedirectLink the messaging redirect link
    * @param merge whether to merge the messaging redirect link with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
    * @return the messaging redirect link that was updated
    * @throws SystemException if a system exception occurred
    */
    public com.ext.portlet.model.MessagingRedirectLink updateMessagingRedirectLink(
        com.ext.portlet.model.MessagingRedirectLink messagingRedirectLink,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public java.lang.String getBeanIdentifier();

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public void setBeanIdentifier(java.lang.String beanIdentifier);
}
