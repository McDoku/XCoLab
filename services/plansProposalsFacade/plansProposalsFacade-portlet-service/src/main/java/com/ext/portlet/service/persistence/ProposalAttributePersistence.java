package com.ext.portlet.service.persistence;

import com.ext.portlet.model.ProposalAttribute;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the proposal attribute service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProposalAttributePersistenceImpl
 * @see ProposalAttributeUtil
 * @generated
 */
public interface ProposalAttributePersistence extends BasePersistence<ProposalAttribute> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link ProposalAttributeUtil} to access the proposal attribute persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns all the proposal attributes where proposalId = &#63; and version = &#63;.
    *
    * @param proposalId the proposal ID
    * @param version the version
    * @return the matching proposal attributes
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.ext.portlet.model.ProposalAttribute> findByProposalIdVersion(
        long proposalId, int version)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the proposal attributes where proposalId = &#63; and version = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ext.portlet.model.impl.ProposalAttributeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param proposalId the proposal ID
    * @param version the version
    * @param start the lower bound of the range of proposal attributes
    * @param end the upper bound of the range of proposal attributes (not inclusive)
    * @return the range of matching proposal attributes
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.ext.portlet.model.ProposalAttribute> findByProposalIdVersion(
        long proposalId, int version, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the proposal attributes where proposalId = &#63; and version = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ext.portlet.model.impl.ProposalAttributeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param proposalId the proposal ID
    * @param version the version
    * @param start the lower bound of the range of proposal attributes
    * @param end the upper bound of the range of proposal attributes (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching proposal attributes
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.ext.portlet.model.ProposalAttribute> findByProposalIdVersion(
        long proposalId, int version, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first proposal attribute in the ordered set where proposalId = &#63; and version = &#63;.
    *
    * @param proposalId the proposal ID
    * @param version the version
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching proposal attribute
    * @throws com.ext.portlet.NoSuchProposalAttributeException if a matching proposal attribute could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.ext.portlet.model.ProposalAttribute findByProposalIdVersion_First(
        long proposalId, int version,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.ext.portlet.NoSuchProposalAttributeException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first proposal attribute in the ordered set where proposalId = &#63; and version = &#63;.
    *
    * @param proposalId the proposal ID
    * @param version the version
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching proposal attribute, or <code>null</code> if a matching proposal attribute could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.ext.portlet.model.ProposalAttribute fetchByProposalIdVersion_First(
        long proposalId, int version,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last proposal attribute in the ordered set where proposalId = &#63; and version = &#63;.
    *
    * @param proposalId the proposal ID
    * @param version the version
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching proposal attribute
    * @throws com.ext.portlet.NoSuchProposalAttributeException if a matching proposal attribute could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.ext.portlet.model.ProposalAttribute findByProposalIdVersion_Last(
        long proposalId, int version,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.ext.portlet.NoSuchProposalAttributeException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last proposal attribute in the ordered set where proposalId = &#63; and version = &#63;.
    *
    * @param proposalId the proposal ID
    * @param version the version
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching proposal attribute, or <code>null</code> if a matching proposal attribute could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.ext.portlet.model.ProposalAttribute fetchByProposalIdVersion_Last(
        long proposalId, int version,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the proposal attributes before and after the current proposal attribute in the ordered set where proposalId = &#63; and version = &#63;.
    *
    * @param id the primary key of the current proposal attribute
    * @param proposalId the proposal ID
    * @param version the version
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next proposal attribute
    * @throws com.ext.portlet.NoSuchProposalAttributeException if a proposal attribute with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.ext.portlet.model.ProposalAttribute[] findByProposalIdVersion_PrevAndNext(
        long id, long proposalId, int version,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.ext.portlet.NoSuchProposalAttributeException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the proposal attributes where proposalId = &#63; and version = &#63; from the database.
    *
    * @param proposalId the proposal ID
    * @param version the version
    * @throws SystemException if a system exception occurred
    */
    public void removeByProposalIdVersion(long proposalId, int version)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of proposal attributes where proposalId = &#63; and version = &#63;.
    *
    * @param proposalId the proposal ID
    * @param version the version
    * @return the number of matching proposal attributes
    * @throws SystemException if a system exception occurred
    */
    public int countByProposalIdVersion(long proposalId, int version)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the proposal attributes where proposalId = &#63; and version &ge; &#63; and versionWhenCreated &le; &#63;.
    *
    * @param proposalId the proposal ID
    * @param version the version
    * @param versionWhenCreated the version when created
    * @return the matching proposal attributes
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.ext.portlet.model.ProposalAttribute> findByProposalId_VersionGreaterEqual_VersionWhenCreatedLesserEqual(
        long proposalId, int version, int versionWhenCreated)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the proposal attributes where proposalId = &#63; and version &ge; &#63; and versionWhenCreated &le; &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ext.portlet.model.impl.ProposalAttributeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param proposalId the proposal ID
    * @param version the version
    * @param versionWhenCreated the version when created
    * @param start the lower bound of the range of proposal attributes
    * @param end the upper bound of the range of proposal attributes (not inclusive)
    * @return the range of matching proposal attributes
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.ext.portlet.model.ProposalAttribute> findByProposalId_VersionGreaterEqual_VersionWhenCreatedLesserEqual(
        long proposalId, int version, int versionWhenCreated, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the proposal attributes where proposalId = &#63; and version &ge; &#63; and versionWhenCreated &le; &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ext.portlet.model.impl.ProposalAttributeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param proposalId the proposal ID
    * @param version the version
    * @param versionWhenCreated the version when created
    * @param start the lower bound of the range of proposal attributes
    * @param end the upper bound of the range of proposal attributes (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching proposal attributes
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.ext.portlet.model.ProposalAttribute> findByProposalId_VersionGreaterEqual_VersionWhenCreatedLesserEqual(
        long proposalId, int version, int versionWhenCreated, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first proposal attribute in the ordered set where proposalId = &#63; and version &ge; &#63; and versionWhenCreated &le; &#63;.
    *
    * @param proposalId the proposal ID
    * @param version the version
    * @param versionWhenCreated the version when created
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching proposal attribute
    * @throws com.ext.portlet.NoSuchProposalAttributeException if a matching proposal attribute could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.ext.portlet.model.ProposalAttribute findByProposalId_VersionGreaterEqual_VersionWhenCreatedLesserEqual_First(
        long proposalId, int version, int versionWhenCreated,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.ext.portlet.NoSuchProposalAttributeException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first proposal attribute in the ordered set where proposalId = &#63; and version &ge; &#63; and versionWhenCreated &le; &#63;.
    *
    * @param proposalId the proposal ID
    * @param version the version
    * @param versionWhenCreated the version when created
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching proposal attribute, or <code>null</code> if a matching proposal attribute could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.ext.portlet.model.ProposalAttribute fetchByProposalId_VersionGreaterEqual_VersionWhenCreatedLesserEqual_First(
        long proposalId, int version, int versionWhenCreated,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last proposal attribute in the ordered set where proposalId = &#63; and version &ge; &#63; and versionWhenCreated &le; &#63;.
    *
    * @param proposalId the proposal ID
    * @param version the version
    * @param versionWhenCreated the version when created
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching proposal attribute
    * @throws com.ext.portlet.NoSuchProposalAttributeException if a matching proposal attribute could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.ext.portlet.model.ProposalAttribute findByProposalId_VersionGreaterEqual_VersionWhenCreatedLesserEqual_Last(
        long proposalId, int version, int versionWhenCreated,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.ext.portlet.NoSuchProposalAttributeException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last proposal attribute in the ordered set where proposalId = &#63; and version &ge; &#63; and versionWhenCreated &le; &#63;.
    *
    * @param proposalId the proposal ID
    * @param version the version
    * @param versionWhenCreated the version when created
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching proposal attribute, or <code>null</code> if a matching proposal attribute could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.ext.portlet.model.ProposalAttribute fetchByProposalId_VersionGreaterEqual_VersionWhenCreatedLesserEqual_Last(
        long proposalId, int version, int versionWhenCreated,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the proposal attributes before and after the current proposal attribute in the ordered set where proposalId = &#63; and version &ge; &#63; and versionWhenCreated &le; &#63;.
    *
    * @param id the primary key of the current proposal attribute
    * @param proposalId the proposal ID
    * @param version the version
    * @param versionWhenCreated the version when created
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next proposal attribute
    * @throws com.ext.portlet.NoSuchProposalAttributeException if a proposal attribute with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.ext.portlet.model.ProposalAttribute[] findByProposalId_VersionGreaterEqual_VersionWhenCreatedLesserEqual_PrevAndNext(
        long id, long proposalId, int version, int versionWhenCreated,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.ext.portlet.NoSuchProposalAttributeException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the proposal attributes where proposalId = &#63; and version &ge; &#63; and versionWhenCreated &le; &#63; from the database.
    *
    * @param proposalId the proposal ID
    * @param version the version
    * @param versionWhenCreated the version when created
    * @throws SystemException if a system exception occurred
    */
    public void removeByProposalId_VersionGreaterEqual_VersionWhenCreatedLesserEqual(
        long proposalId, int version, int versionWhenCreated)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of proposal attributes where proposalId = &#63; and version &ge; &#63; and versionWhenCreated &le; &#63;.
    *
    * @param proposalId the proposal ID
    * @param version the version
    * @param versionWhenCreated the version when created
    * @return the number of matching proposal attributes
    * @throws SystemException if a system exception occurred
    */
    public int countByProposalId_VersionGreaterEqual_VersionWhenCreatedLesserEqual(
        long proposalId, int version, int versionWhenCreated)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the proposal attribute where proposalId = &#63; and version = &#63; and name = &#63; and additionalId = &#63; or throws a {@link com.ext.portlet.NoSuchProposalAttributeException} if it could not be found.
    *
    * @param proposalId the proposal ID
    * @param version the version
    * @param name the name
    * @param additionalId the additional ID
    * @return the matching proposal attribute
    * @throws com.ext.portlet.NoSuchProposalAttributeException if a matching proposal attribute could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.ext.portlet.model.ProposalAttribute findByProposalIdVersionNameAdditionalId(
        long proposalId, int version, java.lang.String name, long additionalId)
        throws com.ext.portlet.NoSuchProposalAttributeException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the proposal attribute where proposalId = &#63; and version = &#63; and name = &#63; and additionalId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param proposalId the proposal ID
    * @param version the version
    * @param name the name
    * @param additionalId the additional ID
    * @return the matching proposal attribute, or <code>null</code> if a matching proposal attribute could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.ext.portlet.model.ProposalAttribute fetchByProposalIdVersionNameAdditionalId(
        long proposalId, int version, java.lang.String name, long additionalId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the proposal attribute where proposalId = &#63; and version = &#63; and name = &#63; and additionalId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param proposalId the proposal ID
    * @param version the version
    * @param name the name
    * @param additionalId the additional ID
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching proposal attribute, or <code>null</code> if a matching proposal attribute could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.ext.portlet.model.ProposalAttribute fetchByProposalIdVersionNameAdditionalId(
        long proposalId, int version, java.lang.String name, long additionalId,
        boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the proposal attribute where proposalId = &#63; and version = &#63; and name = &#63; and additionalId = &#63; from the database.
    *
    * @param proposalId the proposal ID
    * @param version the version
    * @param name the name
    * @param additionalId the additional ID
    * @return the proposal attribute that was removed
    * @throws SystemException if a system exception occurred
    */
    public com.ext.portlet.model.ProposalAttribute removeByProposalIdVersionNameAdditionalId(
        long proposalId, int version, java.lang.String name, long additionalId)
        throws com.ext.portlet.NoSuchProposalAttributeException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of proposal attributes where proposalId = &#63; and version = &#63; and name = &#63; and additionalId = &#63;.
    *
    * @param proposalId the proposal ID
    * @param version the version
    * @param name the name
    * @param additionalId the additional ID
    * @return the number of matching proposal attributes
    * @throws SystemException if a system exception occurred
    */
    public int countByProposalIdVersionNameAdditionalId(long proposalId,
        int version, java.lang.String name, long additionalId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the proposal attributes where proposalId = &#63; and version &ge; &#63; and versionWhenCreated &le; &#63; and name = &#63; and additionalId = &#63;.
    *
    * @param proposalId the proposal ID
    * @param version the version
    * @param versionWhenCreated the version when created
    * @param name the name
    * @param additionalId the additional ID
    * @return the matching proposal attributes
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.ext.portlet.model.ProposalAttribute> findByProposalId_VersionGreaterEqual_VersionWhenCreatedLesserEqual_NameAdditionalId(
        long proposalId, int version, int versionWhenCreated,
        java.lang.String name, long additionalId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the proposal attributes where proposalId = &#63; and version &ge; &#63; and versionWhenCreated &le; &#63; and name = &#63; and additionalId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ext.portlet.model.impl.ProposalAttributeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param proposalId the proposal ID
    * @param version the version
    * @param versionWhenCreated the version when created
    * @param name the name
    * @param additionalId the additional ID
    * @param start the lower bound of the range of proposal attributes
    * @param end the upper bound of the range of proposal attributes (not inclusive)
    * @return the range of matching proposal attributes
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.ext.portlet.model.ProposalAttribute> findByProposalId_VersionGreaterEqual_VersionWhenCreatedLesserEqual_NameAdditionalId(
        long proposalId, int version, int versionWhenCreated,
        java.lang.String name, long additionalId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the proposal attributes where proposalId = &#63; and version &ge; &#63; and versionWhenCreated &le; &#63; and name = &#63; and additionalId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ext.portlet.model.impl.ProposalAttributeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param proposalId the proposal ID
    * @param version the version
    * @param versionWhenCreated the version when created
    * @param name the name
    * @param additionalId the additional ID
    * @param start the lower bound of the range of proposal attributes
    * @param end the upper bound of the range of proposal attributes (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching proposal attributes
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.ext.portlet.model.ProposalAttribute> findByProposalId_VersionGreaterEqual_VersionWhenCreatedLesserEqual_NameAdditionalId(
        long proposalId, int version, int versionWhenCreated,
        java.lang.String name, long additionalId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first proposal attribute in the ordered set where proposalId = &#63; and version &ge; &#63; and versionWhenCreated &le; &#63; and name = &#63; and additionalId = &#63;.
    *
    * @param proposalId the proposal ID
    * @param version the version
    * @param versionWhenCreated the version when created
    * @param name the name
    * @param additionalId the additional ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching proposal attribute
    * @throws com.ext.portlet.NoSuchProposalAttributeException if a matching proposal attribute could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.ext.portlet.model.ProposalAttribute findByProposalId_VersionGreaterEqual_VersionWhenCreatedLesserEqual_NameAdditionalId_First(
        long proposalId, int version, int versionWhenCreated,
        java.lang.String name, long additionalId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.ext.portlet.NoSuchProposalAttributeException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first proposal attribute in the ordered set where proposalId = &#63; and version &ge; &#63; and versionWhenCreated &le; &#63; and name = &#63; and additionalId = &#63;.
    *
    * @param proposalId the proposal ID
    * @param version the version
    * @param versionWhenCreated the version when created
    * @param name the name
    * @param additionalId the additional ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching proposal attribute, or <code>null</code> if a matching proposal attribute could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.ext.portlet.model.ProposalAttribute fetchByProposalId_VersionGreaterEqual_VersionWhenCreatedLesserEqual_NameAdditionalId_First(
        long proposalId, int version, int versionWhenCreated,
        java.lang.String name, long additionalId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last proposal attribute in the ordered set where proposalId = &#63; and version &ge; &#63; and versionWhenCreated &le; &#63; and name = &#63; and additionalId = &#63;.
    *
    * @param proposalId the proposal ID
    * @param version the version
    * @param versionWhenCreated the version when created
    * @param name the name
    * @param additionalId the additional ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching proposal attribute
    * @throws com.ext.portlet.NoSuchProposalAttributeException if a matching proposal attribute could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.ext.portlet.model.ProposalAttribute findByProposalId_VersionGreaterEqual_VersionWhenCreatedLesserEqual_NameAdditionalId_Last(
        long proposalId, int version, int versionWhenCreated,
        java.lang.String name, long additionalId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.ext.portlet.NoSuchProposalAttributeException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last proposal attribute in the ordered set where proposalId = &#63; and version &ge; &#63; and versionWhenCreated &le; &#63; and name = &#63; and additionalId = &#63;.
    *
    * @param proposalId the proposal ID
    * @param version the version
    * @param versionWhenCreated the version when created
    * @param name the name
    * @param additionalId the additional ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching proposal attribute, or <code>null</code> if a matching proposal attribute could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.ext.portlet.model.ProposalAttribute fetchByProposalId_VersionGreaterEqual_VersionWhenCreatedLesserEqual_NameAdditionalId_Last(
        long proposalId, int version, int versionWhenCreated,
        java.lang.String name, long additionalId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the proposal attributes before and after the current proposal attribute in the ordered set where proposalId = &#63; and version &ge; &#63; and versionWhenCreated &le; &#63; and name = &#63; and additionalId = &#63;.
    *
    * @param id the primary key of the current proposal attribute
    * @param proposalId the proposal ID
    * @param version the version
    * @param versionWhenCreated the version when created
    * @param name the name
    * @param additionalId the additional ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next proposal attribute
    * @throws com.ext.portlet.NoSuchProposalAttributeException if a proposal attribute with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.ext.portlet.model.ProposalAttribute[] findByProposalId_VersionGreaterEqual_VersionWhenCreatedLesserEqual_NameAdditionalId_PrevAndNext(
        long id, long proposalId, int version, int versionWhenCreated,
        java.lang.String name, long additionalId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.ext.portlet.NoSuchProposalAttributeException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the proposal attributes where proposalId = &#63; and version &ge; &#63; and versionWhenCreated &le; &#63; and name = &#63; and additionalId = &#63; from the database.
    *
    * @param proposalId the proposal ID
    * @param version the version
    * @param versionWhenCreated the version when created
    * @param name the name
    * @param additionalId the additional ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByProposalId_VersionGreaterEqual_VersionWhenCreatedLesserEqual_NameAdditionalId(
        long proposalId, int version, int versionWhenCreated,
        java.lang.String name, long additionalId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of proposal attributes where proposalId = &#63; and version &ge; &#63; and versionWhenCreated &le; &#63; and name = &#63; and additionalId = &#63;.
    *
    * @param proposalId the proposal ID
    * @param version the version
    * @param versionWhenCreated the version when created
    * @param name the name
    * @param additionalId the additional ID
    * @return the number of matching proposal attributes
    * @throws SystemException if a system exception occurred
    */
    public int countByProposalId_VersionGreaterEqual_VersionWhenCreatedLesserEqual_NameAdditionalId(
        long proposalId, int version, int versionWhenCreated,
        java.lang.String name, long additionalId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the proposal attribute in the entity cache if it is enabled.
    *
    * @param proposalAttribute the proposal attribute
    */
    public void cacheResult(
        com.ext.portlet.model.ProposalAttribute proposalAttribute);

    /**
    * Caches the proposal attributes in the entity cache if it is enabled.
    *
    * @param proposalAttributes the proposal attributes
    */
    public void cacheResult(
        java.util.List<com.ext.portlet.model.ProposalAttribute> proposalAttributes);

    /**
    * Creates a new proposal attribute with the primary key. Does not add the proposal attribute to the database.
    *
    * @param id the primary key for the new proposal attribute
    * @return the new proposal attribute
    */
    public com.ext.portlet.model.ProposalAttribute create(long id);

    /**
    * Removes the proposal attribute with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the proposal attribute
    * @return the proposal attribute that was removed
    * @throws com.ext.portlet.NoSuchProposalAttributeException if a proposal attribute with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.ext.portlet.model.ProposalAttribute remove(long id)
        throws com.ext.portlet.NoSuchProposalAttributeException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.ext.portlet.model.ProposalAttribute updateImpl(
        com.ext.portlet.model.ProposalAttribute proposalAttribute)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the proposal attribute with the primary key or throws a {@link com.ext.portlet.NoSuchProposalAttributeException} if it could not be found.
    *
    * @param id the primary key of the proposal attribute
    * @return the proposal attribute
    * @throws com.ext.portlet.NoSuchProposalAttributeException if a proposal attribute with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.ext.portlet.model.ProposalAttribute findByPrimaryKey(long id)
        throws com.ext.portlet.NoSuchProposalAttributeException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the proposal attribute with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the proposal attribute
    * @return the proposal attribute, or <code>null</code> if a proposal attribute with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.ext.portlet.model.ProposalAttribute fetchByPrimaryKey(long id)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the proposal attributes.
    *
    * @return the proposal attributes
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.ext.portlet.model.ProposalAttribute> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the proposal attributes.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ext.portlet.model.impl.ProposalAttributeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of proposal attributes
    * @param end the upper bound of the range of proposal attributes (not inclusive)
    * @return the range of proposal attributes
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.ext.portlet.model.ProposalAttribute> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the proposal attributes.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ext.portlet.model.impl.ProposalAttributeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of proposal attributes
    * @param end the upper bound of the range of proposal attributes (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of proposal attributes
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.ext.portlet.model.ProposalAttribute> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the proposal attributes from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of proposal attributes.
    *
    * @return the number of proposal attributes
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
