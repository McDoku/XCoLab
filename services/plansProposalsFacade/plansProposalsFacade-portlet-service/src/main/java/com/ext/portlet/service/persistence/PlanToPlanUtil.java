package com.ext.portlet.service.persistence;

import com.ext.portlet.model.PlanToPlan;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the plan to plan service. This utility wraps {@link PlanToPlanPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PlanToPlanPersistence
 * @see PlanToPlanPersistenceImpl
 * @generated
 */
public class PlanToPlanUtil {
    private static PlanToPlanPersistence _persistence;

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
    public static void clearCache(PlanToPlan planToPlan) {
        getPersistence().clearCache(planToPlan);
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
    public static List<PlanToPlan> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<PlanToPlan> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<PlanToPlan> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
     */
    public static PlanToPlan update(PlanToPlan planToPlan, boolean merge)
        throws SystemException {
        return getPersistence().update(planToPlan, merge);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
     */
    public static PlanToPlan update(PlanToPlan planToPlan, boolean merge,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(planToPlan, merge, serviceContext);
    }

    /**
    * Caches the plan to plan in the entity cache if it is enabled.
    *
    * @param planToPlan the plan to plan
    */
    public static void cacheResult(com.ext.portlet.model.PlanToPlan planToPlan) {
        getPersistence().cacheResult(planToPlan);
    }

    /**
    * Caches the plan to plans in the entity cache if it is enabled.
    *
    * @param planToPlans the plan to plans
    */
    public static void cacheResult(
        java.util.List<com.ext.portlet.model.PlanToPlan> planToPlans) {
        getPersistence().cacheResult(planToPlans);
    }

    /**
    * Creates a new plan to plan with the primary key. Does not add the plan to plan to the database.
    *
    * @param planToPlanPK the primary key for the new plan to plan
    * @return the new plan to plan
    */
    public static com.ext.portlet.model.PlanToPlan create(
        PlanToPlanPK planToPlanPK) {
        return getPersistence().create(planToPlanPK);
    }

    /**
    * Removes the plan to plan with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param planToPlanPK the primary key of the plan to plan
    * @return the plan to plan that was removed
    * @throws com.ext.portlet.NoSuchPlanToPlanException if a plan to plan with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.ext.portlet.model.PlanToPlan remove(
        PlanToPlanPK planToPlanPK)
        throws com.ext.portlet.NoSuchPlanToPlanException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(planToPlanPK);
    }

    public static com.ext.portlet.model.PlanToPlan updateImpl(
        com.ext.portlet.model.PlanToPlan planToPlan, boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(planToPlan, merge);
    }

    /**
    * Returns the plan to plan with the primary key or throws a {@link com.ext.portlet.NoSuchPlanToPlanException} if it could not be found.
    *
    * @param planToPlanPK the primary key of the plan to plan
    * @return the plan to plan
    * @throws com.ext.portlet.NoSuchPlanToPlanException if a plan to plan with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.ext.portlet.model.PlanToPlan findByPrimaryKey(
        PlanToPlanPK planToPlanPK)
        throws com.ext.portlet.NoSuchPlanToPlanException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(planToPlanPK);
    }

    /**
    * Returns the plan to plan with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param planToPlanPK the primary key of the plan to plan
    * @return the plan to plan, or <code>null</code> if a plan to plan with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.ext.portlet.model.PlanToPlan fetchByPrimaryKey(
        PlanToPlanPK planToPlanPK)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(planToPlanPK);
    }

    /**
    * Returns all the plan to plans where fromPlanId = &#63;.
    *
    * @param fromPlanId the from plan ID
    * @return the matching plan to plans
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.ext.portlet.model.PlanToPlan> findByFromPlanId(
        long fromPlanId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByFromPlanId(fromPlanId);
    }

    /**
    * Returns a range of all the plan to plans where fromPlanId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param fromPlanId the from plan ID
    * @param start the lower bound of the range of plan to plans
    * @param end the upper bound of the range of plan to plans (not inclusive)
    * @return the range of matching plan to plans
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.ext.portlet.model.PlanToPlan> findByFromPlanId(
        long fromPlanId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByFromPlanId(fromPlanId, start, end);
    }

    /**
    * Returns an ordered range of all the plan to plans where fromPlanId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param fromPlanId the from plan ID
    * @param start the lower bound of the range of plan to plans
    * @param end the upper bound of the range of plan to plans (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching plan to plans
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.ext.portlet.model.PlanToPlan> findByFromPlanId(
        long fromPlanId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByFromPlanId(fromPlanId, start, end, orderByComparator);
    }

    /**
    * Returns the first plan to plan in the ordered set where fromPlanId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param fromPlanId the from plan ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching plan to plan
    * @throws com.ext.portlet.NoSuchPlanToPlanException if a matching plan to plan could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.ext.portlet.model.PlanToPlan findByFromPlanId_First(
        long fromPlanId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.ext.portlet.NoSuchPlanToPlanException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByFromPlanId_First(fromPlanId, orderByComparator);
    }

    /**
    * Returns the last plan to plan in the ordered set where fromPlanId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param fromPlanId the from plan ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching plan to plan
    * @throws com.ext.portlet.NoSuchPlanToPlanException if a matching plan to plan could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.ext.portlet.model.PlanToPlan findByFromPlanId_Last(
        long fromPlanId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.ext.portlet.NoSuchPlanToPlanException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByFromPlanId_Last(fromPlanId, orderByComparator);
    }

    /**
    * Returns the plan to plans before and after the current plan to plan in the ordered set where fromPlanId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param planToPlanPK the primary key of the current plan to plan
    * @param fromPlanId the from plan ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next plan to plan
    * @throws com.ext.portlet.NoSuchPlanToPlanException if a plan to plan with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.ext.portlet.model.PlanToPlan[] findByFromPlanId_PrevAndNext(
        PlanToPlanPK planToPlanPK, long fromPlanId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.ext.portlet.NoSuchPlanToPlanException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByFromPlanId_PrevAndNext(planToPlanPK, fromPlanId,
            orderByComparator);
    }

    /**
    * Returns all the plan to plans where toPlanId = &#63;.
    *
    * @param toPlanId the to plan ID
    * @return the matching plan to plans
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.ext.portlet.model.PlanToPlan> findByToPlanId(
        long toPlanId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByToPlanId(toPlanId);
    }

    /**
    * Returns a range of all the plan to plans where toPlanId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param toPlanId the to plan ID
    * @param start the lower bound of the range of plan to plans
    * @param end the upper bound of the range of plan to plans (not inclusive)
    * @return the range of matching plan to plans
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.ext.portlet.model.PlanToPlan> findByToPlanId(
        long toPlanId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByToPlanId(toPlanId, start, end);
    }

    /**
    * Returns an ordered range of all the plan to plans where toPlanId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param toPlanId the to plan ID
    * @param start the lower bound of the range of plan to plans
    * @param end the upper bound of the range of plan to plans (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching plan to plans
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.ext.portlet.model.PlanToPlan> findByToPlanId(
        long toPlanId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByToPlanId(toPlanId, start, end, orderByComparator);
    }

    /**
    * Returns the first plan to plan in the ordered set where toPlanId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param toPlanId the to plan ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching plan to plan
    * @throws com.ext.portlet.NoSuchPlanToPlanException if a matching plan to plan could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.ext.portlet.model.PlanToPlan findByToPlanId_First(
        long toPlanId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.ext.portlet.NoSuchPlanToPlanException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByToPlanId_First(toPlanId, orderByComparator);
    }

    /**
    * Returns the last plan to plan in the ordered set where toPlanId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param toPlanId the to plan ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching plan to plan
    * @throws com.ext.portlet.NoSuchPlanToPlanException if a matching plan to plan could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.ext.portlet.model.PlanToPlan findByToPlanId_Last(
        long toPlanId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.ext.portlet.NoSuchPlanToPlanException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByToPlanId_Last(toPlanId, orderByComparator);
    }

    /**
    * Returns the plan to plans before and after the current plan to plan in the ordered set where toPlanId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param planToPlanPK the primary key of the current plan to plan
    * @param toPlanId the to plan ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next plan to plan
    * @throws com.ext.portlet.NoSuchPlanToPlanException if a plan to plan with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.ext.portlet.model.PlanToPlan[] findByToPlanId_PrevAndNext(
        PlanToPlanPK planToPlanPK, long toPlanId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.ext.portlet.NoSuchPlanToPlanException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByToPlanId_PrevAndNext(planToPlanPK, toPlanId,
            orderByComparator);
    }

    /**
    * Returns the plan to plan where fromPlanId = &#63; and toPlanId = &#63; or throws a {@link com.ext.portlet.NoSuchPlanToPlanException} if it could not be found.
    *
    * @param fromPlanId the from plan ID
    * @param toPlanId the to plan ID
    * @return the matching plan to plan
    * @throws com.ext.portlet.NoSuchPlanToPlanException if a matching plan to plan could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.ext.portlet.model.PlanToPlan findByFromPlanIdToPlanId(
        long fromPlanId, long toPlanId)
        throws com.ext.portlet.NoSuchPlanToPlanException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByFromPlanIdToPlanId(fromPlanId, toPlanId);
    }

    /**
    * Returns the plan to plan where fromPlanId = &#63; and toPlanId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param fromPlanId the from plan ID
    * @param toPlanId the to plan ID
    * @return the matching plan to plan, or <code>null</code> if a matching plan to plan could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.ext.portlet.model.PlanToPlan fetchByFromPlanIdToPlanId(
        long fromPlanId, long toPlanId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByFromPlanIdToPlanId(fromPlanId, toPlanId);
    }

    /**
    * Returns the plan to plan where fromPlanId = &#63; and toPlanId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param fromPlanId the from plan ID
    * @param toPlanId the to plan ID
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching plan to plan, or <code>null</code> if a matching plan to plan could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.ext.portlet.model.PlanToPlan fetchByFromPlanIdToPlanId(
        long fromPlanId, long toPlanId, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByFromPlanIdToPlanId(fromPlanId, toPlanId,
            retrieveFromCache);
    }

    /**
    * Returns all the plan to plans.
    *
    * @return the plan to plans
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.ext.portlet.model.PlanToPlan> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the plan to plans.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of plan to plans
    * @param end the upper bound of the range of plan to plans (not inclusive)
    * @return the range of plan to plans
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.ext.portlet.model.PlanToPlan> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the plan to plans.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of plan to plans
    * @param end the upper bound of the range of plan to plans (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of plan to plans
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.ext.portlet.model.PlanToPlan> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the plan to plans where fromPlanId = &#63; from the database.
    *
    * @param fromPlanId the from plan ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByFromPlanId(long fromPlanId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByFromPlanId(fromPlanId);
    }

    /**
    * Removes all the plan to plans where toPlanId = &#63; from the database.
    *
    * @param toPlanId the to plan ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByToPlanId(long toPlanId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByToPlanId(toPlanId);
    }

    /**
    * Removes the plan to plan where fromPlanId = &#63; and toPlanId = &#63; from the database.
    *
    * @param fromPlanId the from plan ID
    * @param toPlanId the to plan ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByFromPlanIdToPlanId(long fromPlanId, long toPlanId)
        throws com.ext.portlet.NoSuchPlanToPlanException,
            com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByFromPlanIdToPlanId(fromPlanId, toPlanId);
    }

    /**
    * Removes all the plan to plans from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of plan to plans where fromPlanId = &#63;.
    *
    * @param fromPlanId the from plan ID
    * @return the number of matching plan to plans
    * @throws SystemException if a system exception occurred
    */
    public static int countByFromPlanId(long fromPlanId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByFromPlanId(fromPlanId);
    }

    /**
    * Returns the number of plan to plans where toPlanId = &#63;.
    *
    * @param toPlanId the to plan ID
    * @return the number of matching plan to plans
    * @throws SystemException if a system exception occurred
    */
    public static int countByToPlanId(long toPlanId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByToPlanId(toPlanId);
    }

    /**
    * Returns the number of plan to plans where fromPlanId = &#63; and toPlanId = &#63;.
    *
    * @param fromPlanId the from plan ID
    * @param toPlanId the to plan ID
    * @return the number of matching plan to plans
    * @throws SystemException if a system exception occurred
    */
    public static int countByFromPlanIdToPlanId(long fromPlanId, long toPlanId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByFromPlanIdToPlanId(fromPlanId, toPlanId);
    }

    /**
    * Returns the number of plan to plans.
    *
    * @return the number of plan to plans
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static PlanToPlanPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (PlanToPlanPersistence) PortletBeanLocatorUtil.locate(com.ext.portlet.service.ClpSerializer.getServletContextName(),
                    PlanToPlanPersistence.class.getName());

            ReferenceRegistry.registerReference(PlanToPlanUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    public void setPersistence(PlanToPlanPersistence persistence) {
        _persistence = persistence;

        ReferenceRegistry.registerReference(PlanToPlanUtil.class, "_persistence");
    }
}
