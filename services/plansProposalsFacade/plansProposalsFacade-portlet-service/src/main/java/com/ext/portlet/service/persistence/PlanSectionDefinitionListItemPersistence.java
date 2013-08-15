package com.ext.portlet.service.persistence;

import com.ext.portlet.model.PlanSectionDefinitionListItem;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the plan section definition list item service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PlanSectionDefinitionListItemPersistenceImpl
 * @see PlanSectionDefinitionListItemUtil
 * @generated
 */
public interface PlanSectionDefinitionListItemPersistence
    extends BasePersistence<PlanSectionDefinitionListItem> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link PlanSectionDefinitionListItemUtil} to access the plan section definition list item persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Caches the plan section definition list item in the entity cache if it is enabled.
    *
    * @param planSectionDefinitionListItem the plan section definition list item
    */
    public void cacheResult(
        com.ext.portlet.model.PlanSectionDefinitionListItem planSectionDefinitionListItem);

    /**
    * Caches the plan section definition list items in the entity cache if it is enabled.
    *
    * @param planSectionDefinitionListItems the plan section definition list items
    */
    public void cacheResult(
        java.util.List<com.ext.portlet.model.PlanSectionDefinitionListItem> planSectionDefinitionListItems);

    /**
    * Creates a new plan section definition list item with the primary key. Does not add the plan section definition list item to the database.
    *
    * @param id the primary key for the new plan section definition list item
    * @return the new plan section definition list item
    */
    public com.ext.portlet.model.PlanSectionDefinitionListItem create(long id);

    /**
    * Removes the plan section definition list item with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the plan section definition list item
    * @return the plan section definition list item that was removed
    * @throws com.ext.portlet.NoSuchPlanSectionDefinitionListItemException if a plan section definition list item with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.ext.portlet.model.PlanSectionDefinitionListItem remove(long id)
        throws com.ext.portlet.NoSuchPlanSectionDefinitionListItemException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.ext.portlet.model.PlanSectionDefinitionListItem updateImpl(
        com.ext.portlet.model.PlanSectionDefinitionListItem planSectionDefinitionListItem,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the plan section definition list item with the primary key or throws a {@link com.ext.portlet.NoSuchPlanSectionDefinitionListItemException} if it could not be found.
    *
    * @param id the primary key of the plan section definition list item
    * @return the plan section definition list item
    * @throws com.ext.portlet.NoSuchPlanSectionDefinitionListItemException if a plan section definition list item with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.ext.portlet.model.PlanSectionDefinitionListItem findByPrimaryKey(
        long id)
        throws com.ext.portlet.NoSuchPlanSectionDefinitionListItemException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the plan section definition list item with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the plan section definition list item
    * @return the plan section definition list item, or <code>null</code> if a plan section definition list item with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.ext.portlet.model.PlanSectionDefinitionListItem fetchByPrimaryKey(
        long id) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the plan section definition list items where sectionDefinitionId = &#63; and type = &#63;.
    *
    * @param sectionDefinitionId the section definition ID
    * @param type the type
    * @return the matching plan section definition list items
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.ext.portlet.model.PlanSectionDefinitionListItem> findByPlanSectionDefinitionIdType(
        long sectionDefinitionId, java.lang.String type)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the plan section definition list items where sectionDefinitionId = &#63; and type = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param sectionDefinitionId the section definition ID
    * @param type the type
    * @param start the lower bound of the range of plan section definition list items
    * @param end the upper bound of the range of plan section definition list items (not inclusive)
    * @return the range of matching plan section definition list items
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.ext.portlet.model.PlanSectionDefinitionListItem> findByPlanSectionDefinitionIdType(
        long sectionDefinitionId, java.lang.String type, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the plan section definition list items where sectionDefinitionId = &#63; and type = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param sectionDefinitionId the section definition ID
    * @param type the type
    * @param start the lower bound of the range of plan section definition list items
    * @param end the upper bound of the range of plan section definition list items (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching plan section definition list items
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.ext.portlet.model.PlanSectionDefinitionListItem> findByPlanSectionDefinitionIdType(
        long sectionDefinitionId, java.lang.String type, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first plan section definition list item in the ordered set where sectionDefinitionId = &#63; and type = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param sectionDefinitionId the section definition ID
    * @param type the type
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching plan section definition list item
    * @throws com.ext.portlet.NoSuchPlanSectionDefinitionListItemException if a matching plan section definition list item could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.ext.portlet.model.PlanSectionDefinitionListItem findByPlanSectionDefinitionIdType_First(
        long sectionDefinitionId, java.lang.String type,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.ext.portlet.NoSuchPlanSectionDefinitionListItemException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last plan section definition list item in the ordered set where sectionDefinitionId = &#63; and type = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param sectionDefinitionId the section definition ID
    * @param type the type
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching plan section definition list item
    * @throws com.ext.portlet.NoSuchPlanSectionDefinitionListItemException if a matching plan section definition list item could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.ext.portlet.model.PlanSectionDefinitionListItem findByPlanSectionDefinitionIdType_Last(
        long sectionDefinitionId, java.lang.String type,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.ext.portlet.NoSuchPlanSectionDefinitionListItemException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the plan section definition list items before and after the current plan section definition list item in the ordered set where sectionDefinitionId = &#63; and type = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param id the primary key of the current plan section definition list item
    * @param sectionDefinitionId the section definition ID
    * @param type the type
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next plan section definition list item
    * @throws com.ext.portlet.NoSuchPlanSectionDefinitionListItemException if a plan section definition list item with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.ext.portlet.model.PlanSectionDefinitionListItem[] findByPlanSectionDefinitionIdType_PrevAndNext(
        long id, long sectionDefinitionId, java.lang.String type,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.ext.portlet.NoSuchPlanSectionDefinitionListItemException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the plan section definition list items.
    *
    * @return the plan section definition list items
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.ext.portlet.model.PlanSectionDefinitionListItem> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the plan section definition list items.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of plan section definition list items
    * @param end the upper bound of the range of plan section definition list items (not inclusive)
    * @return the range of plan section definition list items
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.ext.portlet.model.PlanSectionDefinitionListItem> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the plan section definition list items.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of plan section definition list items
    * @param end the upper bound of the range of plan section definition list items (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of plan section definition list items
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.ext.portlet.model.PlanSectionDefinitionListItem> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the plan section definition list items where sectionDefinitionId = &#63; and type = &#63; from the database.
    *
    * @param sectionDefinitionId the section definition ID
    * @param type the type
    * @throws SystemException if a system exception occurred
    */
    public void removeByPlanSectionDefinitionIdType(long sectionDefinitionId,
        java.lang.String type)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the plan section definition list items from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of plan section definition list items where sectionDefinitionId = &#63; and type = &#63;.
    *
    * @param sectionDefinitionId the section definition ID
    * @param type the type
    * @return the number of matching plan section definition list items
    * @throws SystemException if a system exception occurred
    */
    public int countByPlanSectionDefinitionIdType(long sectionDefinitionId,
        java.lang.String type)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of plan section definition list items.
    *
    * @return the number of plan section definition list items
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
