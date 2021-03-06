package com.ext.portlet.service.persistence;

import com.ext.portlet.model.PlanPosition;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the plan position service. This utility wraps {@link PlanPositionPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PlanPositionPersistence
 * @see PlanPositionPersistenceImpl
 * @generated
 */
public class PlanPositionUtil {
    private static PlanPositionPersistence _persistence;

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
    public static void clearCache(PlanPosition planPosition) {
        getPersistence().clearCache(planPosition);
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
    public static List<PlanPosition> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<PlanPosition> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<PlanPosition> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static PlanPosition update(PlanPosition planPosition)
        throws SystemException {
        return getPersistence().update(planPosition);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static PlanPosition update(PlanPosition planPosition,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(planPosition, serviceContext);
    }

    /**
    * Returns all the plan positions where positionId = &#63;.
    *
    * @param positionId the position ID
    * @return the matching plan positions
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.ext.portlet.model.PlanPosition> findByPositionId(
        long positionId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPositionId(positionId);
    }

    /**
    * Returns a range of all the plan positions where positionId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ext.portlet.model.impl.PlanPositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param positionId the position ID
    * @param start the lower bound of the range of plan positions
    * @param end the upper bound of the range of plan positions (not inclusive)
    * @return the range of matching plan positions
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.ext.portlet.model.PlanPosition> findByPositionId(
        long positionId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPositionId(positionId, start, end);
    }

    /**
    * Returns an ordered range of all the plan positions where positionId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ext.portlet.model.impl.PlanPositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param positionId the position ID
    * @param start the lower bound of the range of plan positions
    * @param end the upper bound of the range of plan positions (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching plan positions
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.ext.portlet.model.PlanPosition> findByPositionId(
        long positionId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByPositionId(positionId, start, end, orderByComparator);
    }

    /**
    * Returns the first plan position in the ordered set where positionId = &#63;.
    *
    * @param positionId the position ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching plan position
    * @throws com.ext.portlet.NoSuchPlanPositionException if a matching plan position could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.ext.portlet.model.PlanPosition findByPositionId_First(
        long positionId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.ext.portlet.NoSuchPlanPositionException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByPositionId_First(positionId, orderByComparator);
    }

    /**
    * Returns the first plan position in the ordered set where positionId = &#63;.
    *
    * @param positionId the position ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching plan position, or <code>null</code> if a matching plan position could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.ext.portlet.model.PlanPosition fetchByPositionId_First(
        long positionId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByPositionId_First(positionId, orderByComparator);
    }

    /**
    * Returns the last plan position in the ordered set where positionId = &#63;.
    *
    * @param positionId the position ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching plan position
    * @throws com.ext.portlet.NoSuchPlanPositionException if a matching plan position could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.ext.portlet.model.PlanPosition findByPositionId_Last(
        long positionId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.ext.portlet.NoSuchPlanPositionException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByPositionId_Last(positionId, orderByComparator);
    }

    /**
    * Returns the last plan position in the ordered set where positionId = &#63;.
    *
    * @param positionId the position ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching plan position, or <code>null</code> if a matching plan position could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.ext.portlet.model.PlanPosition fetchByPositionId_Last(
        long positionId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByPositionId_Last(positionId, orderByComparator);
    }

    /**
    * Returns the plan positions before and after the current plan position in the ordered set where positionId = &#63;.
    *
    * @param planPositionPK the primary key of the current plan position
    * @param positionId the position ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next plan position
    * @throws com.ext.portlet.NoSuchPlanPositionException if a plan position with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.ext.portlet.model.PlanPosition[] findByPositionId_PrevAndNext(
        PlanPositionPK planPositionPK, long positionId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.ext.portlet.NoSuchPlanPositionException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByPositionId_PrevAndNext(planPositionPK, positionId,
            orderByComparator);
    }

    /**
    * Removes all the plan positions where positionId = &#63; from the database.
    *
    * @param positionId the position ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByPositionId(long positionId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByPositionId(positionId);
    }

    /**
    * Returns the number of plan positions where positionId = &#63;.
    *
    * @param positionId the position ID
    * @return the number of matching plan positions
    * @throws SystemException if a system exception occurred
    */
    public static int countByPositionId(long positionId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByPositionId(positionId);
    }

    /**
    * Caches the plan position in the entity cache if it is enabled.
    *
    * @param planPosition the plan position
    */
    public static void cacheResult(
        com.ext.portlet.model.PlanPosition planPosition) {
        getPersistence().cacheResult(planPosition);
    }

    /**
    * Caches the plan positions in the entity cache if it is enabled.
    *
    * @param planPositions the plan positions
    */
    public static void cacheResult(
        java.util.List<com.ext.portlet.model.PlanPosition> planPositions) {
        getPersistence().cacheResult(planPositions);
    }

    /**
    * Creates a new plan position with the primary key. Does not add the plan position to the database.
    *
    * @param planPositionPK the primary key for the new plan position
    * @return the new plan position
    */
    public static com.ext.portlet.model.PlanPosition create(
        PlanPositionPK planPositionPK) {
        return getPersistence().create(planPositionPK);
    }

    /**
    * Removes the plan position with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param planPositionPK the primary key of the plan position
    * @return the plan position that was removed
    * @throws com.ext.portlet.NoSuchPlanPositionException if a plan position with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.ext.portlet.model.PlanPosition remove(
        PlanPositionPK planPositionPK)
        throws com.ext.portlet.NoSuchPlanPositionException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(planPositionPK);
    }

    public static com.ext.portlet.model.PlanPosition updateImpl(
        com.ext.portlet.model.PlanPosition planPosition)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(planPosition);
    }

    /**
    * Returns the plan position with the primary key or throws a {@link com.ext.portlet.NoSuchPlanPositionException} if it could not be found.
    *
    * @param planPositionPK the primary key of the plan position
    * @return the plan position
    * @throws com.ext.portlet.NoSuchPlanPositionException if a plan position with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.ext.portlet.model.PlanPosition findByPrimaryKey(
        PlanPositionPK planPositionPK)
        throws com.ext.portlet.NoSuchPlanPositionException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(planPositionPK);
    }

    /**
    * Returns the plan position with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param planPositionPK the primary key of the plan position
    * @return the plan position, or <code>null</code> if a plan position with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.ext.portlet.model.PlanPosition fetchByPrimaryKey(
        PlanPositionPK planPositionPK)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(planPositionPK);
    }

    /**
    * Returns all the plan positions.
    *
    * @return the plan positions
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.ext.portlet.model.PlanPosition> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the plan positions.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ext.portlet.model.impl.PlanPositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of plan positions
    * @param end the upper bound of the range of plan positions (not inclusive)
    * @return the range of plan positions
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.ext.portlet.model.PlanPosition> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the plan positions.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ext.portlet.model.impl.PlanPositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of plan positions
    * @param end the upper bound of the range of plan positions (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of plan positions
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.ext.portlet.model.PlanPosition> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the plan positions from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of plan positions.
    *
    * @return the number of plan positions
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static PlanPositionPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (PlanPositionPersistence) PortletBeanLocatorUtil.locate(com.ext.portlet.service.ClpSerializer.getServletContextName(),
                    PlanPositionPersistence.class.getName());

            ReferenceRegistry.registerReference(PlanPositionUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(PlanPositionPersistence persistence) {
    }
}
