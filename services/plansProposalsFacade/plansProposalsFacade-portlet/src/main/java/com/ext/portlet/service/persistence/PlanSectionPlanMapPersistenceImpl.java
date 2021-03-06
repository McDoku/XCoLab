package com.ext.portlet.service.persistence;

import com.ext.portlet.NoSuchPlanSectionPlanMapException;
import com.ext.portlet.model.PlanSectionPlanMap;
import com.ext.portlet.model.impl.PlanSectionPlanMapImpl;
import com.ext.portlet.model.impl.PlanSectionPlanMapModelImpl;
import com.ext.portlet.service.persistence.PlanSectionPlanMapPersistence;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the plan section plan map service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PlanSectionPlanMapPersistence
 * @see PlanSectionPlanMapUtil
 * @generated
 */
public class PlanSectionPlanMapPersistenceImpl extends BasePersistenceImpl<PlanSectionPlanMap>
    implements PlanSectionPlanMapPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link PlanSectionPlanMapUtil} to access the plan section plan map persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = PlanSectionPlanMapImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(PlanSectionPlanMapModelImpl.ENTITY_CACHE_ENABLED,
            PlanSectionPlanMapModelImpl.FINDER_CACHE_ENABLED,
            PlanSectionPlanMapImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(PlanSectionPlanMapModelImpl.ENTITY_CACHE_ENABLED,
            PlanSectionPlanMapModelImpl.FINDER_CACHE_ENABLED,
            PlanSectionPlanMapImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PlanSectionPlanMapModelImpl.ENTITY_CACHE_ENABLED,
            PlanSectionPlanMapModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PLANID = new FinderPath(PlanSectionPlanMapModelImpl.ENTITY_CACHE_ENABLED,
            PlanSectionPlanMapModelImpl.FINDER_CACHE_ENABLED,
            PlanSectionPlanMapImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPlanId",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PLANID =
        new FinderPath(PlanSectionPlanMapModelImpl.ENTITY_CACHE_ENABLED,
            PlanSectionPlanMapModelImpl.FINDER_CACHE_ENABLED,
            PlanSectionPlanMapImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPlanId",
            new String[] { Long.class.getName() },
            PlanSectionPlanMapModelImpl.RELATEDPLANID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_PLANID = new FinderPath(PlanSectionPlanMapModelImpl.ENTITY_CACHE_ENABLED,
            PlanSectionPlanMapModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPlanId",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_PLANID_RELATEDPLANID_2 = "planSectionPlanMap.id.relatedPlanId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SECTIONID =
        new FinderPath(PlanSectionPlanMapModelImpl.ENTITY_CACHE_ENABLED,
            PlanSectionPlanMapModelImpl.FINDER_CACHE_ENABLED,
            PlanSectionPlanMapImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBySectionId",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SECTIONID =
        new FinderPath(PlanSectionPlanMapModelImpl.ENTITY_CACHE_ENABLED,
            PlanSectionPlanMapModelImpl.FINDER_CACHE_ENABLED,
            PlanSectionPlanMapImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBySectionId",
            new String[] { Long.class.getName() },
            PlanSectionPlanMapModelImpl.SECTIONID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_SECTIONID = new FinderPath(PlanSectionPlanMapModelImpl.ENTITY_CACHE_ENABLED,
            PlanSectionPlanMapModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBySectionId",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_SECTIONID_SECTIONID_2 = "planSectionPlanMap.id.sectionId = ?";
    private static final String _SQL_SELECT_PLANSECTIONPLANMAP = "SELECT planSectionPlanMap FROM PlanSectionPlanMap planSectionPlanMap";
    private static final String _SQL_SELECT_PLANSECTIONPLANMAP_WHERE = "SELECT planSectionPlanMap FROM PlanSectionPlanMap planSectionPlanMap WHERE ";
    private static final String _SQL_COUNT_PLANSECTIONPLANMAP = "SELECT COUNT(planSectionPlanMap) FROM PlanSectionPlanMap planSectionPlanMap";
    private static final String _SQL_COUNT_PLANSECTIONPLANMAP_WHERE = "SELECT COUNT(planSectionPlanMap) FROM PlanSectionPlanMap planSectionPlanMap WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "planSectionPlanMap.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No PlanSectionPlanMap exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No PlanSectionPlanMap exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(PlanSectionPlanMapPersistenceImpl.class);
    private static PlanSectionPlanMap _nullPlanSectionPlanMap = new PlanSectionPlanMapImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<PlanSectionPlanMap> toCacheModel() {
                return _nullPlanSectionPlanMapCacheModel;
            }
        };

    private static CacheModel<PlanSectionPlanMap> _nullPlanSectionPlanMapCacheModel =
        new CacheModel<PlanSectionPlanMap>() {
            @Override
            public PlanSectionPlanMap toEntityModel() {
                return _nullPlanSectionPlanMap;
            }
        };

    public PlanSectionPlanMapPersistenceImpl() {
        setModelClass(PlanSectionPlanMap.class);
    }

    /**
     * Returns all the plan section plan maps where relatedPlanId = &#63;.
     *
     * @param relatedPlanId the related plan ID
     * @return the matching plan section plan maps
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<PlanSectionPlanMap> findByPlanId(long relatedPlanId)
        throws SystemException {
        return findByPlanId(relatedPlanId, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the plan section plan maps where relatedPlanId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ext.portlet.model.impl.PlanSectionPlanMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param relatedPlanId the related plan ID
     * @param start the lower bound of the range of plan section plan maps
     * @param end the upper bound of the range of plan section plan maps (not inclusive)
     * @return the range of matching plan section plan maps
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<PlanSectionPlanMap> findByPlanId(long relatedPlanId, int start,
        int end) throws SystemException {
        return findByPlanId(relatedPlanId, start, end, null);
    }

    /**
     * Returns an ordered range of all the plan section plan maps where relatedPlanId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ext.portlet.model.impl.PlanSectionPlanMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param relatedPlanId the related plan ID
     * @param start the lower bound of the range of plan section plan maps
     * @param end the upper bound of the range of plan section plan maps (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching plan section plan maps
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<PlanSectionPlanMap> findByPlanId(long relatedPlanId, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PLANID;
            finderArgs = new Object[] { relatedPlanId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PLANID;
            finderArgs = new Object[] {
                    relatedPlanId,
                    
                    start, end, orderByComparator
                };
        }

        List<PlanSectionPlanMap> list = (List<PlanSectionPlanMap>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (PlanSectionPlanMap planSectionPlanMap : list) {
                if ((relatedPlanId != planSectionPlanMap.getRelatedPlanId())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(3 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(3);
            }

            query.append(_SQL_SELECT_PLANSECTIONPLANMAP_WHERE);

            query.append(_FINDER_COLUMN_PLANID_RELATEDPLANID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(PlanSectionPlanMapModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(relatedPlanId);

                if (!pagination) {
                    list = (List<PlanSectionPlanMap>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<PlanSectionPlanMap>(list);
                } else {
                    list = (List<PlanSectionPlanMap>) QueryUtil.list(q,
                            getDialect(), start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Returns the first plan section plan map in the ordered set where relatedPlanId = &#63;.
     *
     * @param relatedPlanId the related plan ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching plan section plan map
     * @throws com.ext.portlet.NoSuchPlanSectionPlanMapException if a matching plan section plan map could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public PlanSectionPlanMap findByPlanId_First(long relatedPlanId,
        OrderByComparator orderByComparator)
        throws NoSuchPlanSectionPlanMapException, SystemException {
        PlanSectionPlanMap planSectionPlanMap = fetchByPlanId_First(relatedPlanId,
                orderByComparator);

        if (planSectionPlanMap != null) {
            return planSectionPlanMap;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("relatedPlanId=");
        msg.append(relatedPlanId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchPlanSectionPlanMapException(msg.toString());
    }

    /**
     * Returns the first plan section plan map in the ordered set where relatedPlanId = &#63;.
     *
     * @param relatedPlanId the related plan ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching plan section plan map, or <code>null</code> if a matching plan section plan map could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public PlanSectionPlanMap fetchByPlanId_First(long relatedPlanId,
        OrderByComparator orderByComparator) throws SystemException {
        List<PlanSectionPlanMap> list = findByPlanId(relatedPlanId, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last plan section plan map in the ordered set where relatedPlanId = &#63;.
     *
     * @param relatedPlanId the related plan ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching plan section plan map
     * @throws com.ext.portlet.NoSuchPlanSectionPlanMapException if a matching plan section plan map could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public PlanSectionPlanMap findByPlanId_Last(long relatedPlanId,
        OrderByComparator orderByComparator)
        throws NoSuchPlanSectionPlanMapException, SystemException {
        PlanSectionPlanMap planSectionPlanMap = fetchByPlanId_Last(relatedPlanId,
                orderByComparator);

        if (planSectionPlanMap != null) {
            return planSectionPlanMap;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("relatedPlanId=");
        msg.append(relatedPlanId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchPlanSectionPlanMapException(msg.toString());
    }

    /**
     * Returns the last plan section plan map in the ordered set where relatedPlanId = &#63;.
     *
     * @param relatedPlanId the related plan ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching plan section plan map, or <code>null</code> if a matching plan section plan map could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public PlanSectionPlanMap fetchByPlanId_Last(long relatedPlanId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByPlanId(relatedPlanId);

        if (count == 0) {
            return null;
        }

        List<PlanSectionPlanMap> list = findByPlanId(relatedPlanId, count - 1,
                count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the plan section plan maps before and after the current plan section plan map in the ordered set where relatedPlanId = &#63;.
     *
     * @param planSectionPlanMapPK the primary key of the current plan section plan map
     * @param relatedPlanId the related plan ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next plan section plan map
     * @throws com.ext.portlet.NoSuchPlanSectionPlanMapException if a plan section plan map with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public PlanSectionPlanMap[] findByPlanId_PrevAndNext(
        PlanSectionPlanMapPK planSectionPlanMapPK, long relatedPlanId,
        OrderByComparator orderByComparator)
        throws NoSuchPlanSectionPlanMapException, SystemException {
        PlanSectionPlanMap planSectionPlanMap = findByPrimaryKey(planSectionPlanMapPK);

        Session session = null;

        try {
            session = openSession();

            PlanSectionPlanMap[] array = new PlanSectionPlanMapImpl[3];

            array[0] = getByPlanId_PrevAndNext(session, planSectionPlanMap,
                    relatedPlanId, orderByComparator, true);

            array[1] = planSectionPlanMap;

            array[2] = getByPlanId_PrevAndNext(session, planSectionPlanMap,
                    relatedPlanId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected PlanSectionPlanMap getByPlanId_PrevAndNext(Session session,
        PlanSectionPlanMap planSectionPlanMap, long relatedPlanId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_PLANSECTIONPLANMAP_WHERE);

        query.append(_FINDER_COLUMN_PLANID_RELATEDPLANID_2);

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(PlanSectionPlanMapModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(relatedPlanId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(planSectionPlanMap);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<PlanSectionPlanMap> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the plan section plan maps where relatedPlanId = &#63; from the database.
     *
     * @param relatedPlanId the related plan ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByPlanId(long relatedPlanId) throws SystemException {
        for (PlanSectionPlanMap planSectionPlanMap : findByPlanId(
                relatedPlanId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(planSectionPlanMap);
        }
    }

    /**
     * Returns the number of plan section plan maps where relatedPlanId = &#63;.
     *
     * @param relatedPlanId the related plan ID
     * @return the number of matching plan section plan maps
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByPlanId(long relatedPlanId) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_PLANID;

        Object[] finderArgs = new Object[] { relatedPlanId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_PLANSECTIONPLANMAP_WHERE);

            query.append(_FINDER_COLUMN_PLANID_RELATEDPLANID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(relatedPlanId);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns all the plan section plan maps where sectionId = &#63;.
     *
     * @param sectionId the section ID
     * @return the matching plan section plan maps
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<PlanSectionPlanMap> findBySectionId(long sectionId)
        throws SystemException {
        return findBySectionId(sectionId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
            null);
    }

    /**
     * Returns a range of all the plan section plan maps where sectionId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ext.portlet.model.impl.PlanSectionPlanMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param sectionId the section ID
     * @param start the lower bound of the range of plan section plan maps
     * @param end the upper bound of the range of plan section plan maps (not inclusive)
     * @return the range of matching plan section plan maps
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<PlanSectionPlanMap> findBySectionId(long sectionId, int start,
        int end) throws SystemException {
        return findBySectionId(sectionId, start, end, null);
    }

    /**
     * Returns an ordered range of all the plan section plan maps where sectionId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ext.portlet.model.impl.PlanSectionPlanMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param sectionId the section ID
     * @param start the lower bound of the range of plan section plan maps
     * @param end the upper bound of the range of plan section plan maps (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching plan section plan maps
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<PlanSectionPlanMap> findBySectionId(long sectionId, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SECTIONID;
            finderArgs = new Object[] { sectionId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_SECTIONID;
            finderArgs = new Object[] { sectionId, start, end, orderByComparator };
        }

        List<PlanSectionPlanMap> list = (List<PlanSectionPlanMap>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (PlanSectionPlanMap planSectionPlanMap : list) {
                if ((sectionId != planSectionPlanMap.getSectionId())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(3 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(3);
            }

            query.append(_SQL_SELECT_PLANSECTIONPLANMAP_WHERE);

            query.append(_FINDER_COLUMN_SECTIONID_SECTIONID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(PlanSectionPlanMapModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(sectionId);

                if (!pagination) {
                    list = (List<PlanSectionPlanMap>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<PlanSectionPlanMap>(list);
                } else {
                    list = (List<PlanSectionPlanMap>) QueryUtil.list(q,
                            getDialect(), start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Returns the first plan section plan map in the ordered set where sectionId = &#63;.
     *
     * @param sectionId the section ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching plan section plan map
     * @throws com.ext.portlet.NoSuchPlanSectionPlanMapException if a matching plan section plan map could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public PlanSectionPlanMap findBySectionId_First(long sectionId,
        OrderByComparator orderByComparator)
        throws NoSuchPlanSectionPlanMapException, SystemException {
        PlanSectionPlanMap planSectionPlanMap = fetchBySectionId_First(sectionId,
                orderByComparator);

        if (planSectionPlanMap != null) {
            return planSectionPlanMap;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("sectionId=");
        msg.append(sectionId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchPlanSectionPlanMapException(msg.toString());
    }

    /**
     * Returns the first plan section plan map in the ordered set where sectionId = &#63;.
     *
     * @param sectionId the section ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching plan section plan map, or <code>null</code> if a matching plan section plan map could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public PlanSectionPlanMap fetchBySectionId_First(long sectionId,
        OrderByComparator orderByComparator) throws SystemException {
        List<PlanSectionPlanMap> list = findBySectionId(sectionId, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last plan section plan map in the ordered set where sectionId = &#63;.
     *
     * @param sectionId the section ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching plan section plan map
     * @throws com.ext.portlet.NoSuchPlanSectionPlanMapException if a matching plan section plan map could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public PlanSectionPlanMap findBySectionId_Last(long sectionId,
        OrderByComparator orderByComparator)
        throws NoSuchPlanSectionPlanMapException, SystemException {
        PlanSectionPlanMap planSectionPlanMap = fetchBySectionId_Last(sectionId,
                orderByComparator);

        if (planSectionPlanMap != null) {
            return planSectionPlanMap;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("sectionId=");
        msg.append(sectionId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchPlanSectionPlanMapException(msg.toString());
    }

    /**
     * Returns the last plan section plan map in the ordered set where sectionId = &#63;.
     *
     * @param sectionId the section ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching plan section plan map, or <code>null</code> if a matching plan section plan map could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public PlanSectionPlanMap fetchBySectionId_Last(long sectionId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countBySectionId(sectionId);

        if (count == 0) {
            return null;
        }

        List<PlanSectionPlanMap> list = findBySectionId(sectionId, count - 1,
                count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the plan section plan maps before and after the current plan section plan map in the ordered set where sectionId = &#63;.
     *
     * @param planSectionPlanMapPK the primary key of the current plan section plan map
     * @param sectionId the section ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next plan section plan map
     * @throws com.ext.portlet.NoSuchPlanSectionPlanMapException if a plan section plan map with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public PlanSectionPlanMap[] findBySectionId_PrevAndNext(
        PlanSectionPlanMapPK planSectionPlanMapPK, long sectionId,
        OrderByComparator orderByComparator)
        throws NoSuchPlanSectionPlanMapException, SystemException {
        PlanSectionPlanMap planSectionPlanMap = findByPrimaryKey(planSectionPlanMapPK);

        Session session = null;

        try {
            session = openSession();

            PlanSectionPlanMap[] array = new PlanSectionPlanMapImpl[3];

            array[0] = getBySectionId_PrevAndNext(session, planSectionPlanMap,
                    sectionId, orderByComparator, true);

            array[1] = planSectionPlanMap;

            array[2] = getBySectionId_PrevAndNext(session, planSectionPlanMap,
                    sectionId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected PlanSectionPlanMap getBySectionId_PrevAndNext(Session session,
        PlanSectionPlanMap planSectionPlanMap, long sectionId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_PLANSECTIONPLANMAP_WHERE);

        query.append(_FINDER_COLUMN_SECTIONID_SECTIONID_2);

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(PlanSectionPlanMapModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(sectionId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(planSectionPlanMap);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<PlanSectionPlanMap> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the plan section plan maps where sectionId = &#63; from the database.
     *
     * @param sectionId the section ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeBySectionId(long sectionId) throws SystemException {
        for (PlanSectionPlanMap planSectionPlanMap : findBySectionId(
                sectionId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(planSectionPlanMap);
        }
    }

    /**
     * Returns the number of plan section plan maps where sectionId = &#63;.
     *
     * @param sectionId the section ID
     * @return the number of matching plan section plan maps
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countBySectionId(long sectionId) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_SECTIONID;

        Object[] finderArgs = new Object[] { sectionId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_PLANSECTIONPLANMAP_WHERE);

            query.append(_FINDER_COLUMN_SECTIONID_SECTIONID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(sectionId);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Caches the plan section plan map in the entity cache if it is enabled.
     *
     * @param planSectionPlanMap the plan section plan map
     */
    @Override
    public void cacheResult(PlanSectionPlanMap planSectionPlanMap) {
        EntityCacheUtil.putResult(PlanSectionPlanMapModelImpl.ENTITY_CACHE_ENABLED,
            PlanSectionPlanMapImpl.class, planSectionPlanMap.getPrimaryKey(),
            planSectionPlanMap);

        planSectionPlanMap.resetOriginalValues();
    }

    /**
     * Caches the plan section plan maps in the entity cache if it is enabled.
     *
     * @param planSectionPlanMaps the plan section plan maps
     */
    @Override
    public void cacheResult(List<PlanSectionPlanMap> planSectionPlanMaps) {
        for (PlanSectionPlanMap planSectionPlanMap : planSectionPlanMaps) {
            if (EntityCacheUtil.getResult(
                        PlanSectionPlanMapModelImpl.ENTITY_CACHE_ENABLED,
                        PlanSectionPlanMapImpl.class,
                        planSectionPlanMap.getPrimaryKey()) == null) {
                cacheResult(planSectionPlanMap);
            } else {
                planSectionPlanMap.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all plan section plan maps.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(PlanSectionPlanMapImpl.class.getName());
        }

        EntityCacheUtil.clearCache(PlanSectionPlanMapImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the plan section plan map.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(PlanSectionPlanMap planSectionPlanMap) {
        EntityCacheUtil.removeResult(PlanSectionPlanMapModelImpl.ENTITY_CACHE_ENABLED,
            PlanSectionPlanMapImpl.class, planSectionPlanMap.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<PlanSectionPlanMap> planSectionPlanMaps) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (PlanSectionPlanMap planSectionPlanMap : planSectionPlanMaps) {
            EntityCacheUtil.removeResult(PlanSectionPlanMapModelImpl.ENTITY_CACHE_ENABLED,
                PlanSectionPlanMapImpl.class, planSectionPlanMap.getPrimaryKey());
        }
    }

    /**
     * Creates a new plan section plan map with the primary key. Does not add the plan section plan map to the database.
     *
     * @param planSectionPlanMapPK the primary key for the new plan section plan map
     * @return the new plan section plan map
     */
    @Override
    public PlanSectionPlanMap create(PlanSectionPlanMapPK planSectionPlanMapPK) {
        PlanSectionPlanMap planSectionPlanMap = new PlanSectionPlanMapImpl();

        planSectionPlanMap.setNew(true);
        planSectionPlanMap.setPrimaryKey(planSectionPlanMapPK);

        return planSectionPlanMap;
    }

    /**
     * Removes the plan section plan map with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param planSectionPlanMapPK the primary key of the plan section plan map
     * @return the plan section plan map that was removed
     * @throws com.ext.portlet.NoSuchPlanSectionPlanMapException if a plan section plan map with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public PlanSectionPlanMap remove(PlanSectionPlanMapPK planSectionPlanMapPK)
        throws NoSuchPlanSectionPlanMapException, SystemException {
        return remove((Serializable) planSectionPlanMapPK);
    }

    /**
     * Removes the plan section plan map with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the plan section plan map
     * @return the plan section plan map that was removed
     * @throws com.ext.portlet.NoSuchPlanSectionPlanMapException if a plan section plan map with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public PlanSectionPlanMap remove(Serializable primaryKey)
        throws NoSuchPlanSectionPlanMapException, SystemException {
        Session session = null;

        try {
            session = openSession();

            PlanSectionPlanMap planSectionPlanMap = (PlanSectionPlanMap) session.get(PlanSectionPlanMapImpl.class,
                    primaryKey);

            if (planSectionPlanMap == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchPlanSectionPlanMapException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(planSectionPlanMap);
        } catch (NoSuchPlanSectionPlanMapException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected PlanSectionPlanMap removeImpl(
        PlanSectionPlanMap planSectionPlanMap) throws SystemException {
        planSectionPlanMap = toUnwrappedModel(planSectionPlanMap);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(planSectionPlanMap)) {
                planSectionPlanMap = (PlanSectionPlanMap) session.get(PlanSectionPlanMapImpl.class,
                        planSectionPlanMap.getPrimaryKeyObj());
            }

            if (planSectionPlanMap != null) {
                session.delete(planSectionPlanMap);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (planSectionPlanMap != null) {
            clearCache(planSectionPlanMap);
        }

        return planSectionPlanMap;
    }

    @Override
    public PlanSectionPlanMap updateImpl(
        com.ext.portlet.model.PlanSectionPlanMap planSectionPlanMap)
        throws SystemException {
        planSectionPlanMap = toUnwrappedModel(planSectionPlanMap);

        boolean isNew = planSectionPlanMap.isNew();

        PlanSectionPlanMapModelImpl planSectionPlanMapModelImpl = (PlanSectionPlanMapModelImpl) planSectionPlanMap;

        Session session = null;

        try {
            session = openSession();

            if (planSectionPlanMap.isNew()) {
                session.save(planSectionPlanMap);

                planSectionPlanMap.setNew(false);
            } else {
                session.merge(planSectionPlanMap);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !PlanSectionPlanMapModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((planSectionPlanMapModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PLANID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        planSectionPlanMapModelImpl.getOriginalRelatedPlanId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PLANID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PLANID,
                    args);

                args = new Object[] {
                        planSectionPlanMapModelImpl.getRelatedPlanId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PLANID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PLANID,
                    args);
            }

            if ((planSectionPlanMapModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SECTIONID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        planSectionPlanMapModelImpl.getOriginalSectionId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SECTIONID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SECTIONID,
                    args);

                args = new Object[] { planSectionPlanMapModelImpl.getSectionId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SECTIONID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SECTIONID,
                    args);
            }
        }

        EntityCacheUtil.putResult(PlanSectionPlanMapModelImpl.ENTITY_CACHE_ENABLED,
            PlanSectionPlanMapImpl.class, planSectionPlanMap.getPrimaryKey(),
            planSectionPlanMap);

        return planSectionPlanMap;
    }

    protected PlanSectionPlanMap toUnwrappedModel(
        PlanSectionPlanMap planSectionPlanMap) {
        if (planSectionPlanMap instanceof PlanSectionPlanMapImpl) {
            return planSectionPlanMap;
        }

        PlanSectionPlanMapImpl planSectionPlanMapImpl = new PlanSectionPlanMapImpl();

        planSectionPlanMapImpl.setNew(planSectionPlanMap.isNew());
        planSectionPlanMapImpl.setPrimaryKey(planSectionPlanMap.getPrimaryKey());

        planSectionPlanMapImpl.setSectionId(planSectionPlanMap.getSectionId());
        planSectionPlanMapImpl.setRelatedPlanId(planSectionPlanMap.getRelatedPlanId());

        return planSectionPlanMapImpl;
    }

    /**
     * Returns the plan section plan map with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the plan section plan map
     * @return the plan section plan map
     * @throws com.ext.portlet.NoSuchPlanSectionPlanMapException if a plan section plan map with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public PlanSectionPlanMap findByPrimaryKey(Serializable primaryKey)
        throws NoSuchPlanSectionPlanMapException, SystemException {
        PlanSectionPlanMap planSectionPlanMap = fetchByPrimaryKey(primaryKey);

        if (planSectionPlanMap == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchPlanSectionPlanMapException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return planSectionPlanMap;
    }

    /**
     * Returns the plan section plan map with the primary key or throws a {@link com.ext.portlet.NoSuchPlanSectionPlanMapException} if it could not be found.
     *
     * @param planSectionPlanMapPK the primary key of the plan section plan map
     * @return the plan section plan map
     * @throws com.ext.portlet.NoSuchPlanSectionPlanMapException if a plan section plan map with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public PlanSectionPlanMap findByPrimaryKey(
        PlanSectionPlanMapPK planSectionPlanMapPK)
        throws NoSuchPlanSectionPlanMapException, SystemException {
        return findByPrimaryKey((Serializable) planSectionPlanMapPK);
    }

    /**
     * Returns the plan section plan map with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the plan section plan map
     * @return the plan section plan map, or <code>null</code> if a plan section plan map with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public PlanSectionPlanMap fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        PlanSectionPlanMap planSectionPlanMap = (PlanSectionPlanMap) EntityCacheUtil.getResult(PlanSectionPlanMapModelImpl.ENTITY_CACHE_ENABLED,
                PlanSectionPlanMapImpl.class, primaryKey);

        if (planSectionPlanMap == _nullPlanSectionPlanMap) {
            return null;
        }

        if (planSectionPlanMap == null) {
            Session session = null;

            try {
                session = openSession();

                planSectionPlanMap = (PlanSectionPlanMap) session.get(PlanSectionPlanMapImpl.class,
                        primaryKey);

                if (planSectionPlanMap != null) {
                    cacheResult(planSectionPlanMap);
                } else {
                    EntityCacheUtil.putResult(PlanSectionPlanMapModelImpl.ENTITY_CACHE_ENABLED,
                        PlanSectionPlanMapImpl.class, primaryKey,
                        _nullPlanSectionPlanMap);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(PlanSectionPlanMapModelImpl.ENTITY_CACHE_ENABLED,
                    PlanSectionPlanMapImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return planSectionPlanMap;
    }

    /**
     * Returns the plan section plan map with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param planSectionPlanMapPK the primary key of the plan section plan map
     * @return the plan section plan map, or <code>null</code> if a plan section plan map with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public PlanSectionPlanMap fetchByPrimaryKey(
        PlanSectionPlanMapPK planSectionPlanMapPK) throws SystemException {
        return fetchByPrimaryKey((Serializable) planSectionPlanMapPK);
    }

    /**
     * Returns all the plan section plan maps.
     *
     * @return the plan section plan maps
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<PlanSectionPlanMap> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the plan section plan maps.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ext.portlet.model.impl.PlanSectionPlanMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of plan section plan maps
     * @param end the upper bound of the range of plan section plan maps (not inclusive)
     * @return the range of plan section plan maps
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<PlanSectionPlanMap> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the plan section plan maps.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ext.portlet.model.impl.PlanSectionPlanMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of plan section plan maps
     * @param end the upper bound of the range of plan section plan maps (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of plan section plan maps
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<PlanSectionPlanMap> findAll(int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
            finderArgs = FINDER_ARGS_EMPTY;
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
            finderArgs = new Object[] { start, end, orderByComparator };
        }

        List<PlanSectionPlanMap> list = (List<PlanSectionPlanMap>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_PLANSECTIONPLANMAP);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_PLANSECTIONPLANMAP;

                if (pagination) {
                    sql = sql.concat(PlanSectionPlanMapModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<PlanSectionPlanMap>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<PlanSectionPlanMap>(list);
                } else {
                    list = (List<PlanSectionPlanMap>) QueryUtil.list(q,
                            getDialect(), start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Removes all the plan section plan maps from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (PlanSectionPlanMap planSectionPlanMap : findAll()) {
            remove(planSectionPlanMap);
        }
    }

    /**
     * Returns the number of plan section plan maps.
     *
     * @return the number of plan section plan maps
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_PLANSECTIONPLANMAP);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Initializes the plan section plan map persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.ext.portlet.model.PlanSectionPlanMap")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<PlanSectionPlanMap>> listenersList = new ArrayList<ModelListener<PlanSectionPlanMap>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<PlanSectionPlanMap>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(PlanSectionPlanMapImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
