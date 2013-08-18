package com.ext.portlet.service.persistence;

import com.ext.portlet.model.PlanToPlan;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the plan to plan service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PlanToPlanPersistenceImpl
 * @see PlanToPlanUtil
 * @generated
 */
public interface PlanToPlanPersistence extends BasePersistence<PlanToPlan> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link PlanToPlanUtil} to access the plan to plan persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Caches the plan to plan in the entity cache if it is enabled.
    *
    * @param planToPlan the plan to plan
    */
    public void cacheResult(com.ext.portlet.model.PlanToPlan planToPlan);

    /**
    * Caches the plan to plans in the entity cache if it is enabled.
    *
    * @param planToPlans the plan to plans
    */
    public void cacheResult(
        java.util.List<com.ext.portlet.model.PlanToPlan> planToPlans);

    /**
    * Creates a new plan to plan with the primary key. Does not add the plan to plan to the database.
    *
    * @param planToPlanPK the primary key for the new plan to plan
    * @return the new plan to plan
    */
    public com.ext.portlet.model.PlanToPlan create(PlanToPlanPK planToPlanPK);

    /**
    * Removes the plan to plan with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param planToPlanPK the primary key of the plan to plan
    * @return the plan to plan that was removed
    * @throws com.ext.portlet.NoSuchPlanToPlanException if a plan to plan with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.ext.portlet.model.PlanToPlan remove(PlanToPlanPK planToPlanPK)
        throws com.ext.portlet.NoSuchPlanToPlanException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.ext.portlet.model.PlanToPlan updateImpl(
        com.ext.portlet.model.PlanToPlan planToPlan, boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the plan to plan with the primary key or throws a {@link com.ext.portlet.NoSuchPlanToPlanException} if it could not be found.
    *
    * @param planToPlanPK the primary key of the plan to plan
    * @return the plan to plan
    * @throws com.ext.portlet.NoSuchPlanToPlanException if a plan to plan with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.ext.portlet.model.PlanToPlan findByPrimaryKey(
        PlanToPlanPK planToPlanPK)
        throws com.ext.portlet.NoSuchPlanToPlanException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the plan to plan with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param planToPlanPK the primary key of the plan to plan
    * @return the plan to plan, or <code>null</code> if a plan to plan with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.ext.portlet.model.PlanToPlan fetchByPrimaryKey(
        PlanToPlanPK planToPlanPK)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the plan to plans where fromPlanId = &#63;.
    *
    * @param fromPlanId the from plan ID
    * @return the matching plan to plans
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.ext.portlet.model.PlanToPlan> findByFromPlanId(
        long fromPlanId)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.ext.portlet.model.PlanToPlan> findByFromPlanId(
        long fromPlanId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.ext.portlet.model.PlanToPlan> findByFromPlanId(
        long fromPlanId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.ext.portlet.model.PlanToPlan findByFromPlanId_First(
        long fromPlanId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.ext.portlet.NoSuchPlanToPlanException,
            com.liferay.portal.kernel.exception.SystemException;

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
    public com.ext.portlet.model.PlanToPlan findByFromPlanId_Last(
        long fromPlanId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.ext.portlet.NoSuchPlanToPlanException,
            com.liferay.portal.kernel.exception.SystemException;

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
    public com.ext.portlet.model.PlanToPlan[] findByFromPlanId_PrevAndNext(
        PlanToPlanPK planToPlanPK, long fromPlanId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.ext.portlet.NoSuchPlanToPlanException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the plan to plans where toPlanId = &#63;.
    *
    * @param toPlanId the to plan ID
    * @return the matching plan to plans
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.ext.portlet.model.PlanToPlan> findByToPlanId(
        long toPlanId)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.ext.portlet.model.PlanToPlan> findByToPlanId(
        long toPlanId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.ext.portlet.model.PlanToPlan> findByToPlanId(
        long toPlanId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.ext.portlet.model.PlanToPlan findByToPlanId_First(
        long toPlanId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.ext.portlet.NoSuchPlanToPlanException,
            com.liferay.portal.kernel.exception.SystemException;

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
    public com.ext.portlet.model.PlanToPlan findByToPlanId_Last(long toPlanId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.ext.portlet.NoSuchPlanToPlanException,
            com.liferay.portal.kernel.exception.SystemException;

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
    public com.ext.portlet.model.PlanToPlan[] findByToPlanId_PrevAndNext(
        PlanToPlanPK planToPlanPK, long toPlanId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.ext.portlet.NoSuchPlanToPlanException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the plan to plan where fromPlanId = &#63; and toPlanId = &#63; or throws a {@link com.ext.portlet.NoSuchPlanToPlanException} if it could not be found.
    *
    * @param fromPlanId the from plan ID
    * @param toPlanId the to plan ID
    * @return the matching plan to plan
    * @throws com.ext.portlet.NoSuchPlanToPlanException if a matching plan to plan could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.ext.portlet.model.PlanToPlan findByFromPlanIdToPlanId(
        long fromPlanId, long toPlanId)
        throws com.ext.portlet.NoSuchPlanToPlanException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the plan to plan where fromPlanId = &#63; and toPlanId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param fromPlanId the from plan ID
    * @param toPlanId the to plan ID
    * @return the matching plan to plan, or <code>null</code> if a matching plan to plan could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.ext.portlet.model.PlanToPlan fetchByFromPlanIdToPlanId(
        long fromPlanId, long toPlanId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the plan to plan where fromPlanId = &#63; and toPlanId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param fromPlanId the from plan ID
    * @param toPlanId the to plan ID
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching plan to plan, or <code>null</code> if a matching plan to plan could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.ext.portlet.model.PlanToPlan fetchByFromPlanIdToPlanId(
        long fromPlanId, long toPlanId, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the plan to plans.
    *
    * @return the plan to plans
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.ext.portlet.model.PlanToPlan> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.ext.portlet.model.PlanToPlan> findAll(int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.ext.portlet.model.PlanToPlan> findAll(int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the plan to plans where fromPlanId = &#63; from the database.
    *
    * @param fromPlanId the from plan ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByFromPlanId(long fromPlanId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the plan to plans where toPlanId = &#63; from the database.
    *
    * @param toPlanId the to plan ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByToPlanId(long toPlanId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the plan to plan where fromPlanId = &#63; and toPlanId = &#63; from the database.
    *
    * @param fromPlanId the from plan ID
    * @param toPlanId the to plan ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByFromPlanIdToPlanId(long fromPlanId, long toPlanId)
        throws com.ext.portlet.NoSuchPlanToPlanException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the plan to plans from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of plan to plans where fromPlanId = &#63;.
    *
    * @param fromPlanId the from plan ID
    * @return the number of matching plan to plans
    * @throws SystemException if a system exception occurred
    */
    public int countByFromPlanId(long fromPlanId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of plan to plans where toPlanId = &#63;.
    *
    * @param toPlanId the to plan ID
    * @return the number of matching plan to plans
    * @throws SystemException if a system exception occurred
    */
    public int countByToPlanId(long toPlanId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of plan to plans where fromPlanId = &#63; and toPlanId = &#63;.
    *
    * @param fromPlanId the from plan ID
    * @param toPlanId the to plan ID
    * @return the number of matching plan to plans
    * @throws SystemException if a system exception occurred
    */
    public int countByFromPlanIdToPlanId(long fromPlanId, long toPlanId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of plan to plans.
    *
    * @return the number of plan to plans
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
