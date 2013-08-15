package com.ext.portlet.service.persistence;

import com.ext.portlet.model.PlanSectionDefinitionListItem;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the plan section definition list item service. This utility wraps {@link PlanSectionDefinitionListItemPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PlanSectionDefinitionListItemPersistence
 * @see PlanSectionDefinitionListItemPersistenceImpl
 * @generated
 */
public class PlanSectionDefinitionListItemUtil {
    private static PlanSectionDefinitionListItemPersistence _persistence;

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
    public static void clearCache(
        PlanSectionDefinitionListItem planSectionDefinitionListItem) {
        getPersistence().clearCache(planSectionDefinitionListItem);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
     */
    public long countWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().countWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
     */
    public static List<PlanSectionDefinitionListItem> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<PlanSectionDefinitionListItem> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<PlanSectionDefinitionListItem> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
     */
    public static PlanSectionDefinitionListItem update(
        PlanSectionDefinitionListItem planSectionDefinitionListItem,
        boolean merge) throws SystemException {
        return getPersistence().update(planSectionDefinitionListItem, merge);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
     */
    public static PlanSectionDefinitionListItem update(
        PlanSectionDefinitionListItem planSectionDefinitionListItem,
        boolean merge, ServiceContext serviceContext) throws SystemException {
        return getPersistence()
                   .update(planSectionDefinitionListItem, merge, serviceContext);
    }

    /**
    * Caches the plan section definition list item in the entity cache if it is enabled.
    *
    * @param planSectionDefinitionListItem the plan section definition list item
    */
    public static void cacheResult(
        com.ext.portlet.model.PlanSectionDefinitionListItem planSectionDefinitionListItem) {
        getPersistence().cacheResult(planSectionDefinitionListItem);
    }

    /**
    * Caches the plan section definition list items in the entity cache if it is enabled.
    *
    * @param planSectionDefinitionListItems the plan section definition list items
    */
    public static void cacheResult(
        java.util.List<com.ext.portlet.model.PlanSectionDefinitionListItem> planSectionDefinitionListItems) {
        getPersistence().cacheResult(planSectionDefinitionListItems);
    }

    /**
    * Creates a new plan section definition list item with the primary key. Does not add the plan section definition list item to the database.
    *
    * @param id the primary key for the new plan section definition list item
    * @return the new plan section definition list item
    */
    public static com.ext.portlet.model.PlanSectionDefinitionListItem create(
        long id) {
        return getPersistence().create(id);
    }

    /**
    * Removes the plan section definition list item with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the plan section definition list item
    * @return the plan section definition list item that was removed
    * @throws com.ext.portlet.NoSuchPlanSectionDefinitionListItemException if a plan section definition list item with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.ext.portlet.model.PlanSectionDefinitionListItem remove(
        long id)
        throws com.ext.portlet.NoSuchPlanSectionDefinitionListItemException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(id);
    }

    public static com.ext.portlet.model.PlanSectionDefinitionListItem updateImpl(
        com.ext.portlet.model.PlanSectionDefinitionListItem planSectionDefinitionListItem,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(planSectionDefinitionListItem, merge);
    }

    /**
    * Returns the plan section definition list item with the primary key or throws a {@link com.ext.portlet.NoSuchPlanSectionDefinitionListItemException} if it could not be found.
    *
    * @param id the primary key of the plan section definition list item
    * @return the plan section definition list item
    * @throws com.ext.portlet.NoSuchPlanSectionDefinitionListItemException if a plan section definition list item with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.ext.portlet.model.PlanSectionDefinitionListItem findByPrimaryKey(
        long id)
        throws com.ext.portlet.NoSuchPlanSectionDefinitionListItemException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(id);
    }

    /**
    * Returns the plan section definition list item with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the plan section definition list item
    * @return the plan section definition list item, or <code>null</code> if a plan section definition list item with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.ext.portlet.model.PlanSectionDefinitionListItem fetchByPrimaryKey(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(id);
    }

    /**
    * Returns all the plan section definition list items where sectionDefinitionId = &#63; and type = &#63;.
    *
    * @param sectionDefinitionId the section definition ID
    * @param type the type
    * @return the matching plan section definition list items
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.ext.portlet.model.PlanSectionDefinitionListItem> findByPlanSectionDefinitionIdType(
        long sectionDefinitionId, java.lang.String type)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByPlanSectionDefinitionIdType(sectionDefinitionId, type);
    }

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
    public static java.util.List<com.ext.portlet.model.PlanSectionDefinitionListItem> findByPlanSectionDefinitionIdType(
        long sectionDefinitionId, java.lang.String type, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByPlanSectionDefinitionIdType(sectionDefinitionId,
            type, start, end);
    }

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
    public static java.util.List<com.ext.portlet.model.PlanSectionDefinitionListItem> findByPlanSectionDefinitionIdType(
        long sectionDefinitionId, java.lang.String type, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByPlanSectionDefinitionIdType(sectionDefinitionId,
            type, start, end, orderByComparator);
    }

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
    public static com.ext.portlet.model.PlanSectionDefinitionListItem findByPlanSectionDefinitionIdType_First(
        long sectionDefinitionId, java.lang.String type,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.ext.portlet.NoSuchPlanSectionDefinitionListItemException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByPlanSectionDefinitionIdType_First(sectionDefinitionId,
            type, orderByComparator);
    }

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
    public static com.ext.portlet.model.PlanSectionDefinitionListItem findByPlanSectionDefinitionIdType_Last(
        long sectionDefinitionId, java.lang.String type,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.ext.portlet.NoSuchPlanSectionDefinitionListItemException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByPlanSectionDefinitionIdType_Last(sectionDefinitionId,
            type, orderByComparator);
    }

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
    public static com.ext.portlet.model.PlanSectionDefinitionListItem[] findByPlanSectionDefinitionIdType_PrevAndNext(
        long id, long sectionDefinitionId, java.lang.String type,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.ext.portlet.NoSuchPlanSectionDefinitionListItemException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByPlanSectionDefinitionIdType_PrevAndNext(id,
            sectionDefinitionId, type, orderByComparator);
    }

    /**
    * Returns all the plan section definition list items.
    *
    * @return the plan section definition list items
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.ext.portlet.model.PlanSectionDefinitionListItem> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

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
    public static java.util.List<com.ext.portlet.model.PlanSectionDefinitionListItem> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

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
    public static java.util.List<com.ext.portlet.model.PlanSectionDefinitionListItem> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the plan section definition list items where sectionDefinitionId = &#63; and type = &#63; from the database.
    *
    * @param sectionDefinitionId the section definition ID
    * @param type the type
    * @throws SystemException if a system exception occurred
    */
    public static void removeByPlanSectionDefinitionIdType(
        long sectionDefinitionId, java.lang.String type)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence()
            .removeByPlanSectionDefinitionIdType(sectionDefinitionId, type);
    }

    /**
    * Removes all the plan section definition list items from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of plan section definition list items where sectionDefinitionId = &#63; and type = &#63;.
    *
    * @param sectionDefinitionId the section definition ID
    * @param type the type
    * @return the number of matching plan section definition list items
    * @throws SystemException if a system exception occurred
    */
    public static int countByPlanSectionDefinitionIdType(
        long sectionDefinitionId, java.lang.String type)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .countByPlanSectionDefinitionIdType(sectionDefinitionId, type);
    }

    /**
    * Returns the number of plan section definition list items.
    *
    * @return the number of plan section definition list items
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static PlanSectionDefinitionListItemPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (PlanSectionDefinitionListItemPersistence) PortletBeanLocatorUtil.locate(com.ext.portlet.service.ClpSerializer.getServletContextName(),
                    PlanSectionDefinitionListItemPersistence.class.getName());

            ReferenceRegistry.registerReference(PlanSectionDefinitionListItemUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    public void setPersistence(
        PlanSectionDefinitionListItemPersistence persistence) {
        _persistence = persistence;

        ReferenceRegistry.registerReference(PlanSectionDefinitionListItemUtil.class,
            "_persistence");
    }
}
