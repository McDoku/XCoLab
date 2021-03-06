package com.ext.portlet.service.persistence;

import com.ext.portlet.NoSuchPlanAttributeException;
import com.ext.portlet.model.PlanAttribute;
import com.ext.portlet.model.impl.PlanAttributeImpl;
import com.ext.portlet.model.impl.PlanAttributeModelImpl;
import com.ext.portlet.service.persistence.PlanAttributePersistence;

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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the plan attribute service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PlanAttributePersistence
 * @see PlanAttributeUtil
 * @generated
 */
public class PlanAttributePersistenceImpl extends BasePersistenceImpl<PlanAttribute>
    implements PlanAttributePersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link PlanAttributeUtil} to access the plan attribute persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = PlanAttributeImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(PlanAttributeModelImpl.ENTITY_CACHE_ENABLED,
            PlanAttributeModelImpl.FINDER_CACHE_ENABLED,
            PlanAttributeImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(PlanAttributeModelImpl.ENTITY_CACHE_ENABLED,
            PlanAttributeModelImpl.FINDER_CACHE_ENABLED,
            PlanAttributeImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PlanAttributeModelImpl.ENTITY_CACHE_ENABLED,
            PlanAttributeModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PLANATTRIBUTES =
        new FinderPath(PlanAttributeModelImpl.ENTITY_CACHE_ENABLED,
            PlanAttributeModelImpl.FINDER_CACHE_ENABLED,
            PlanAttributeImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findByplanAttributes",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PLANATTRIBUTES =
        new FinderPath(PlanAttributeModelImpl.ENTITY_CACHE_ENABLED,
            PlanAttributeModelImpl.FINDER_CACHE_ENABLED,
            PlanAttributeImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "findByplanAttributes", new String[] { Long.class.getName() },
            PlanAttributeModelImpl.PLANID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_PLANATTRIBUTES = new FinderPath(PlanAttributeModelImpl.ENTITY_CACHE_ENABLED,
            PlanAttributeModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByplanAttributes",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_PLANATTRIBUTES_PLANID_2 = "planAttribute.planId = ?";
    public static final FinderPath FINDER_PATH_FETCH_BY_ATTRIBUTEFORPLAN = new FinderPath(PlanAttributeModelImpl.ENTITY_CACHE_ENABLED,
            PlanAttributeModelImpl.FINDER_CACHE_ENABLED,
            PlanAttributeImpl.class, FINDER_CLASS_NAME_ENTITY,
            "fetchByattributeForPlan",
            new String[] { Long.class.getName(), String.class.getName() },
            PlanAttributeModelImpl.PLANID_COLUMN_BITMASK |
            PlanAttributeModelImpl.ATTRIBUTENAME_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_ATTRIBUTEFORPLAN = new FinderPath(PlanAttributeModelImpl.ENTITY_CACHE_ENABLED,
            PlanAttributeModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countByattributeForPlan",
            new String[] { Long.class.getName(), String.class.getName() });
    private static final String _FINDER_COLUMN_ATTRIBUTEFORPLAN_PLANID_2 = "planAttribute.planId = ? AND ";
    private static final String _FINDER_COLUMN_ATTRIBUTEFORPLAN_ATTRIBUTENAME_1 = "planAttribute.attributeName IS NULL";
    private static final String _FINDER_COLUMN_ATTRIBUTEFORPLAN_ATTRIBUTENAME_2 = "planAttribute.attributeName = ?";
    private static final String _FINDER_COLUMN_ATTRIBUTEFORPLAN_ATTRIBUTENAME_3 = "(planAttribute.attributeName IS NULL OR planAttribute.attributeName = '')";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ATTRIBUTEBYNAMEVALUE =
        new FinderPath(PlanAttributeModelImpl.ENTITY_CACHE_ENABLED,
            PlanAttributeModelImpl.FINDER_CACHE_ENABLED,
            PlanAttributeImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findByattributeByNameValue",
            new String[] {
                String.class.getName(), String.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ATTRIBUTEBYNAMEVALUE =
        new FinderPath(PlanAttributeModelImpl.ENTITY_CACHE_ENABLED,
            PlanAttributeModelImpl.FINDER_CACHE_ENABLED,
            PlanAttributeImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "findByattributeByNameValue",
            new String[] { String.class.getName(), String.class.getName() },
            PlanAttributeModelImpl.ATTRIBUTENAME_COLUMN_BITMASK |
            PlanAttributeModelImpl.ATTRIBUTEVALUE_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_ATTRIBUTEBYNAMEVALUE = new FinderPath(PlanAttributeModelImpl.ENTITY_CACHE_ENABLED,
            PlanAttributeModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countByattributeByNameValue",
            new String[] { String.class.getName(), String.class.getName() });
    private static final String _FINDER_COLUMN_ATTRIBUTEBYNAMEVALUE_ATTRIBUTENAME_1 =
        "planAttribute.attributeName IS NULL AND ";
    private static final String _FINDER_COLUMN_ATTRIBUTEBYNAMEVALUE_ATTRIBUTENAME_2 =
        "planAttribute.attributeName = ? AND ";
    private static final String _FINDER_COLUMN_ATTRIBUTEBYNAMEVALUE_ATTRIBUTENAME_3 =
        "(planAttribute.attributeName IS NULL OR planAttribute.attributeName = '') AND ";
    private static final String _FINDER_COLUMN_ATTRIBUTEBYNAMEVALUE_ATTRIBUTEVALUE_1 =
        "planAttribute.attributeValue IS NULL";
    private static final String _FINDER_COLUMN_ATTRIBUTEBYNAMEVALUE_ATTRIBUTEVALUE_2 =
        "planAttribute.attributeValue = ?";
    private static final String _FINDER_COLUMN_ATTRIBUTEBYNAMEVALUE_ATTRIBUTEVALUE_3 =
        "(planAttribute.attributeValue IS NULL OR planAttribute.attributeValue = '')";
    private static final String _SQL_SELECT_PLANATTRIBUTE = "SELECT planAttribute FROM PlanAttribute planAttribute";
    private static final String _SQL_SELECT_PLANATTRIBUTE_WHERE = "SELECT planAttribute FROM PlanAttribute planAttribute WHERE ";
    private static final String _SQL_COUNT_PLANATTRIBUTE = "SELECT COUNT(planAttribute) FROM PlanAttribute planAttribute";
    private static final String _SQL_COUNT_PLANATTRIBUTE_WHERE = "SELECT COUNT(planAttribute) FROM PlanAttribute planAttribute WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "planAttribute.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No PlanAttribute exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No PlanAttribute exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(PlanAttributePersistenceImpl.class);
    private static PlanAttribute _nullPlanAttribute = new PlanAttributeImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<PlanAttribute> toCacheModel() {
                return _nullPlanAttributeCacheModel;
            }
        };

    private static CacheModel<PlanAttribute> _nullPlanAttributeCacheModel = new CacheModel<PlanAttribute>() {
            @Override
            public PlanAttribute toEntityModel() {
                return _nullPlanAttribute;
            }
        };

    public PlanAttributePersistenceImpl() {
        setModelClass(PlanAttribute.class);
    }

    /**
     * Returns all the plan attributes where planId = &#63;.
     *
     * @param planId the plan ID
     * @return the matching plan attributes
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<PlanAttribute> findByplanAttributes(long planId)
        throws SystemException {
        return findByplanAttributes(planId, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the plan attributes where planId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ext.portlet.model.impl.PlanAttributeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param planId the plan ID
     * @param start the lower bound of the range of plan attributes
     * @param end the upper bound of the range of plan attributes (not inclusive)
     * @return the range of matching plan attributes
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<PlanAttribute> findByplanAttributes(long planId, int start,
        int end) throws SystemException {
        return findByplanAttributes(planId, start, end, null);
    }

    /**
     * Returns an ordered range of all the plan attributes where planId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ext.portlet.model.impl.PlanAttributeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param planId the plan ID
     * @param start the lower bound of the range of plan attributes
     * @param end the upper bound of the range of plan attributes (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching plan attributes
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<PlanAttribute> findByplanAttributes(long planId, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PLANATTRIBUTES;
            finderArgs = new Object[] { planId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PLANATTRIBUTES;
            finderArgs = new Object[] { planId, start, end, orderByComparator };
        }

        List<PlanAttribute> list = (List<PlanAttribute>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (PlanAttribute planAttribute : list) {
                if ((planId != planAttribute.getPlanId())) {
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

            query.append(_SQL_SELECT_PLANATTRIBUTE_WHERE);

            query.append(_FINDER_COLUMN_PLANATTRIBUTES_PLANID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(PlanAttributeModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(planId);

                if (!pagination) {
                    list = (List<PlanAttribute>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<PlanAttribute>(list);
                } else {
                    list = (List<PlanAttribute>) QueryUtil.list(q,
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
     * Returns the first plan attribute in the ordered set where planId = &#63;.
     *
     * @param planId the plan ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching plan attribute
     * @throws com.ext.portlet.NoSuchPlanAttributeException if a matching plan attribute could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public PlanAttribute findByplanAttributes_First(long planId,
        OrderByComparator orderByComparator)
        throws NoSuchPlanAttributeException, SystemException {
        PlanAttribute planAttribute = fetchByplanAttributes_First(planId,
                orderByComparator);

        if (planAttribute != null) {
            return planAttribute;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("planId=");
        msg.append(planId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchPlanAttributeException(msg.toString());
    }

    /**
     * Returns the first plan attribute in the ordered set where planId = &#63;.
     *
     * @param planId the plan ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching plan attribute, or <code>null</code> if a matching plan attribute could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public PlanAttribute fetchByplanAttributes_First(long planId,
        OrderByComparator orderByComparator) throws SystemException {
        List<PlanAttribute> list = findByplanAttributes(planId, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last plan attribute in the ordered set where planId = &#63;.
     *
     * @param planId the plan ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching plan attribute
     * @throws com.ext.portlet.NoSuchPlanAttributeException if a matching plan attribute could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public PlanAttribute findByplanAttributes_Last(long planId,
        OrderByComparator orderByComparator)
        throws NoSuchPlanAttributeException, SystemException {
        PlanAttribute planAttribute = fetchByplanAttributes_Last(planId,
                orderByComparator);

        if (planAttribute != null) {
            return planAttribute;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("planId=");
        msg.append(planId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchPlanAttributeException(msg.toString());
    }

    /**
     * Returns the last plan attribute in the ordered set where planId = &#63;.
     *
     * @param planId the plan ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching plan attribute, or <code>null</code> if a matching plan attribute could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public PlanAttribute fetchByplanAttributes_Last(long planId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByplanAttributes(planId);

        if (count == 0) {
            return null;
        }

        List<PlanAttribute> list = findByplanAttributes(planId, count - 1,
                count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the plan attributes before and after the current plan attribute in the ordered set where planId = &#63;.
     *
     * @param attributeId the primary key of the current plan attribute
     * @param planId the plan ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next plan attribute
     * @throws com.ext.portlet.NoSuchPlanAttributeException if a plan attribute with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public PlanAttribute[] findByplanAttributes_PrevAndNext(long attributeId,
        long planId, OrderByComparator orderByComparator)
        throws NoSuchPlanAttributeException, SystemException {
        PlanAttribute planAttribute = findByPrimaryKey(attributeId);

        Session session = null;

        try {
            session = openSession();

            PlanAttribute[] array = new PlanAttributeImpl[3];

            array[0] = getByplanAttributes_PrevAndNext(session, planAttribute,
                    planId, orderByComparator, true);

            array[1] = planAttribute;

            array[2] = getByplanAttributes_PrevAndNext(session, planAttribute,
                    planId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected PlanAttribute getByplanAttributes_PrevAndNext(Session session,
        PlanAttribute planAttribute, long planId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_PLANATTRIBUTE_WHERE);

        query.append(_FINDER_COLUMN_PLANATTRIBUTES_PLANID_2);

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
            query.append(PlanAttributeModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(planId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(planAttribute);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<PlanAttribute> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the plan attributes where planId = &#63; from the database.
     *
     * @param planId the plan ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByplanAttributes(long planId) throws SystemException {
        for (PlanAttribute planAttribute : findByplanAttributes(planId,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(planAttribute);
        }
    }

    /**
     * Returns the number of plan attributes where planId = &#63;.
     *
     * @param planId the plan ID
     * @return the number of matching plan attributes
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByplanAttributes(long planId) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_PLANATTRIBUTES;

        Object[] finderArgs = new Object[] { planId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_PLANATTRIBUTE_WHERE);

            query.append(_FINDER_COLUMN_PLANATTRIBUTES_PLANID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(planId);

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
     * Returns the plan attribute where planId = &#63; and attributeName = &#63; or throws a {@link com.ext.portlet.NoSuchPlanAttributeException} if it could not be found.
     *
     * @param planId the plan ID
     * @param attributeName the attribute name
     * @return the matching plan attribute
     * @throws com.ext.portlet.NoSuchPlanAttributeException if a matching plan attribute could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public PlanAttribute findByattributeForPlan(long planId,
        String attributeName)
        throws NoSuchPlanAttributeException, SystemException {
        PlanAttribute planAttribute = fetchByattributeForPlan(planId,
                attributeName);

        if (planAttribute == null) {
            StringBundler msg = new StringBundler(6);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("planId=");
            msg.append(planId);

            msg.append(", attributeName=");
            msg.append(attributeName);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchPlanAttributeException(msg.toString());
        }

        return planAttribute;
    }

    /**
     * Returns the plan attribute where planId = &#63; and attributeName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param planId the plan ID
     * @param attributeName the attribute name
     * @return the matching plan attribute, or <code>null</code> if a matching plan attribute could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public PlanAttribute fetchByattributeForPlan(long planId,
        String attributeName) throws SystemException {
        return fetchByattributeForPlan(planId, attributeName, true);
    }

    /**
     * Returns the plan attribute where planId = &#63; and attributeName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param planId the plan ID
     * @param attributeName the attribute name
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching plan attribute, or <code>null</code> if a matching plan attribute could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public PlanAttribute fetchByattributeForPlan(long planId,
        String attributeName, boolean retrieveFromCache)
        throws SystemException {
        Object[] finderArgs = new Object[] { planId, attributeName };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_ATTRIBUTEFORPLAN,
                    finderArgs, this);
        }

        if (result instanceof PlanAttribute) {
            PlanAttribute planAttribute = (PlanAttribute) result;

            if ((planId != planAttribute.getPlanId()) ||
                    !Validator.equals(attributeName,
                        planAttribute.getAttributeName())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(4);

            query.append(_SQL_SELECT_PLANATTRIBUTE_WHERE);

            query.append(_FINDER_COLUMN_ATTRIBUTEFORPLAN_PLANID_2);

            boolean bindAttributeName = false;

            if (attributeName == null) {
                query.append(_FINDER_COLUMN_ATTRIBUTEFORPLAN_ATTRIBUTENAME_1);
            } else if (attributeName.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_ATTRIBUTEFORPLAN_ATTRIBUTENAME_3);
            } else {
                bindAttributeName = true;

                query.append(_FINDER_COLUMN_ATTRIBUTEFORPLAN_ATTRIBUTENAME_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(planId);

                if (bindAttributeName) {
                    qPos.add(attributeName);
                }

                List<PlanAttribute> list = q.list();

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ATTRIBUTEFORPLAN,
                        finderArgs, list);
                } else {
                    if ((list.size() > 1) && _log.isWarnEnabled()) {
                        _log.warn(
                            "PlanAttributePersistenceImpl.fetchByattributeForPlan(long, String, boolean) with parameters (" +
                            StringUtil.merge(finderArgs) +
                            ") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
                    }

                    PlanAttribute planAttribute = list.get(0);

                    result = planAttribute;

                    cacheResult(planAttribute);

                    if ((planAttribute.getPlanId() != planId) ||
                            (planAttribute.getAttributeName() == null) ||
                            !planAttribute.getAttributeName()
                                              .equals(attributeName)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ATTRIBUTEFORPLAN,
                            finderArgs, planAttribute);
                    }
                }
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ATTRIBUTEFORPLAN,
                    finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        if (result instanceof List<?>) {
            return null;
        } else {
            return (PlanAttribute) result;
        }
    }

    /**
     * Removes the plan attribute where planId = &#63; and attributeName = &#63; from the database.
     *
     * @param planId the plan ID
     * @param attributeName the attribute name
     * @return the plan attribute that was removed
     * @throws SystemException if a system exception occurred
     */
    @Override
    public PlanAttribute removeByattributeForPlan(long planId,
        String attributeName)
        throws NoSuchPlanAttributeException, SystemException {
        PlanAttribute planAttribute = findByattributeForPlan(planId,
                attributeName);

        return remove(planAttribute);
    }

    /**
     * Returns the number of plan attributes where planId = &#63; and attributeName = &#63;.
     *
     * @param planId the plan ID
     * @param attributeName the attribute name
     * @return the number of matching plan attributes
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByattributeForPlan(long planId, String attributeName)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_ATTRIBUTEFORPLAN;

        Object[] finderArgs = new Object[] { planId, attributeName };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_PLANATTRIBUTE_WHERE);

            query.append(_FINDER_COLUMN_ATTRIBUTEFORPLAN_PLANID_2);

            boolean bindAttributeName = false;

            if (attributeName == null) {
                query.append(_FINDER_COLUMN_ATTRIBUTEFORPLAN_ATTRIBUTENAME_1);
            } else if (attributeName.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_ATTRIBUTEFORPLAN_ATTRIBUTENAME_3);
            } else {
                bindAttributeName = true;

                query.append(_FINDER_COLUMN_ATTRIBUTEFORPLAN_ATTRIBUTENAME_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(planId);

                if (bindAttributeName) {
                    qPos.add(attributeName);
                }

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
     * Returns all the plan attributes where attributeName = &#63; and attributeValue = &#63;.
     *
     * @param attributeName the attribute name
     * @param attributeValue the attribute value
     * @return the matching plan attributes
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<PlanAttribute> findByattributeByNameValue(
        String attributeName, String attributeValue) throws SystemException {
        return findByattributeByNameValue(attributeName, attributeValue,
            QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the plan attributes where attributeName = &#63; and attributeValue = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ext.portlet.model.impl.PlanAttributeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param attributeName the attribute name
     * @param attributeValue the attribute value
     * @param start the lower bound of the range of plan attributes
     * @param end the upper bound of the range of plan attributes (not inclusive)
     * @return the range of matching plan attributes
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<PlanAttribute> findByattributeByNameValue(
        String attributeName, String attributeValue, int start, int end)
        throws SystemException {
        return findByattributeByNameValue(attributeName, attributeValue, start,
            end, null);
    }

    /**
     * Returns an ordered range of all the plan attributes where attributeName = &#63; and attributeValue = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ext.portlet.model.impl.PlanAttributeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param attributeName the attribute name
     * @param attributeValue the attribute value
     * @param start the lower bound of the range of plan attributes
     * @param end the upper bound of the range of plan attributes (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching plan attributes
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<PlanAttribute> findByattributeByNameValue(
        String attributeName, String attributeValue, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ATTRIBUTEBYNAMEVALUE;
            finderArgs = new Object[] { attributeName, attributeValue };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ATTRIBUTEBYNAMEVALUE;
            finderArgs = new Object[] {
                    attributeName, attributeValue,
                    
                    start, end, orderByComparator
                };
        }

        List<PlanAttribute> list = (List<PlanAttribute>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (PlanAttribute planAttribute : list) {
                if (!Validator.equals(attributeName,
                            planAttribute.getAttributeName()) ||
                        !Validator.equals(attributeValue,
                            planAttribute.getAttributeValue())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(4 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(4);
            }

            query.append(_SQL_SELECT_PLANATTRIBUTE_WHERE);

            boolean bindAttributeName = false;

            if (attributeName == null) {
                query.append(_FINDER_COLUMN_ATTRIBUTEBYNAMEVALUE_ATTRIBUTENAME_1);
            } else if (attributeName.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_ATTRIBUTEBYNAMEVALUE_ATTRIBUTENAME_3);
            } else {
                bindAttributeName = true;

                query.append(_FINDER_COLUMN_ATTRIBUTEBYNAMEVALUE_ATTRIBUTENAME_2);
            }

            boolean bindAttributeValue = false;

            if (attributeValue == null) {
                query.append(_FINDER_COLUMN_ATTRIBUTEBYNAMEVALUE_ATTRIBUTEVALUE_1);
            } else if (attributeValue.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_ATTRIBUTEBYNAMEVALUE_ATTRIBUTEVALUE_3);
            } else {
                bindAttributeValue = true;

                query.append(_FINDER_COLUMN_ATTRIBUTEBYNAMEVALUE_ATTRIBUTEVALUE_2);
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(PlanAttributeModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindAttributeName) {
                    qPos.add(attributeName);
                }

                if (bindAttributeValue) {
                    qPos.add(attributeValue);
                }

                if (!pagination) {
                    list = (List<PlanAttribute>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<PlanAttribute>(list);
                } else {
                    list = (List<PlanAttribute>) QueryUtil.list(q,
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
     * Returns the first plan attribute in the ordered set where attributeName = &#63; and attributeValue = &#63;.
     *
     * @param attributeName the attribute name
     * @param attributeValue the attribute value
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching plan attribute
     * @throws com.ext.portlet.NoSuchPlanAttributeException if a matching plan attribute could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public PlanAttribute findByattributeByNameValue_First(
        String attributeName, String attributeValue,
        OrderByComparator orderByComparator)
        throws NoSuchPlanAttributeException, SystemException {
        PlanAttribute planAttribute = fetchByattributeByNameValue_First(attributeName,
                attributeValue, orderByComparator);

        if (planAttribute != null) {
            return planAttribute;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("attributeName=");
        msg.append(attributeName);

        msg.append(", attributeValue=");
        msg.append(attributeValue);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchPlanAttributeException(msg.toString());
    }

    /**
     * Returns the first plan attribute in the ordered set where attributeName = &#63; and attributeValue = &#63;.
     *
     * @param attributeName the attribute name
     * @param attributeValue the attribute value
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching plan attribute, or <code>null</code> if a matching plan attribute could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public PlanAttribute fetchByattributeByNameValue_First(
        String attributeName, String attributeValue,
        OrderByComparator orderByComparator) throws SystemException {
        List<PlanAttribute> list = findByattributeByNameValue(attributeName,
                attributeValue, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last plan attribute in the ordered set where attributeName = &#63; and attributeValue = &#63;.
     *
     * @param attributeName the attribute name
     * @param attributeValue the attribute value
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching plan attribute
     * @throws com.ext.portlet.NoSuchPlanAttributeException if a matching plan attribute could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public PlanAttribute findByattributeByNameValue_Last(String attributeName,
        String attributeValue, OrderByComparator orderByComparator)
        throws NoSuchPlanAttributeException, SystemException {
        PlanAttribute planAttribute = fetchByattributeByNameValue_Last(attributeName,
                attributeValue, orderByComparator);

        if (planAttribute != null) {
            return planAttribute;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("attributeName=");
        msg.append(attributeName);

        msg.append(", attributeValue=");
        msg.append(attributeValue);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchPlanAttributeException(msg.toString());
    }

    /**
     * Returns the last plan attribute in the ordered set where attributeName = &#63; and attributeValue = &#63;.
     *
     * @param attributeName the attribute name
     * @param attributeValue the attribute value
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching plan attribute, or <code>null</code> if a matching plan attribute could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public PlanAttribute fetchByattributeByNameValue_Last(
        String attributeName, String attributeValue,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByattributeByNameValue(attributeName, attributeValue);

        if (count == 0) {
            return null;
        }

        List<PlanAttribute> list = findByattributeByNameValue(attributeName,
                attributeValue, count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the plan attributes before and after the current plan attribute in the ordered set where attributeName = &#63; and attributeValue = &#63;.
     *
     * @param attributeId the primary key of the current plan attribute
     * @param attributeName the attribute name
     * @param attributeValue the attribute value
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next plan attribute
     * @throws com.ext.portlet.NoSuchPlanAttributeException if a plan attribute with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public PlanAttribute[] findByattributeByNameValue_PrevAndNext(
        long attributeId, String attributeName, String attributeValue,
        OrderByComparator orderByComparator)
        throws NoSuchPlanAttributeException, SystemException {
        PlanAttribute planAttribute = findByPrimaryKey(attributeId);

        Session session = null;

        try {
            session = openSession();

            PlanAttribute[] array = new PlanAttributeImpl[3];

            array[0] = getByattributeByNameValue_PrevAndNext(session,
                    planAttribute, attributeName, attributeValue,
                    orderByComparator, true);

            array[1] = planAttribute;

            array[2] = getByattributeByNameValue_PrevAndNext(session,
                    planAttribute, attributeName, attributeValue,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected PlanAttribute getByattributeByNameValue_PrevAndNext(
        Session session, PlanAttribute planAttribute, String attributeName,
        String attributeValue, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_PLANATTRIBUTE_WHERE);

        boolean bindAttributeName = false;

        if (attributeName == null) {
            query.append(_FINDER_COLUMN_ATTRIBUTEBYNAMEVALUE_ATTRIBUTENAME_1);
        } else if (attributeName.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_ATTRIBUTEBYNAMEVALUE_ATTRIBUTENAME_3);
        } else {
            bindAttributeName = true;

            query.append(_FINDER_COLUMN_ATTRIBUTEBYNAMEVALUE_ATTRIBUTENAME_2);
        }

        boolean bindAttributeValue = false;

        if (attributeValue == null) {
            query.append(_FINDER_COLUMN_ATTRIBUTEBYNAMEVALUE_ATTRIBUTEVALUE_1);
        } else if (attributeValue.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_ATTRIBUTEBYNAMEVALUE_ATTRIBUTEVALUE_3);
        } else {
            bindAttributeValue = true;

            query.append(_FINDER_COLUMN_ATTRIBUTEBYNAMEVALUE_ATTRIBUTEVALUE_2);
        }

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
            query.append(PlanAttributeModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (bindAttributeName) {
            qPos.add(attributeName);
        }

        if (bindAttributeValue) {
            qPos.add(attributeValue);
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(planAttribute);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<PlanAttribute> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the plan attributes where attributeName = &#63; and attributeValue = &#63; from the database.
     *
     * @param attributeName the attribute name
     * @param attributeValue the attribute value
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByattributeByNameValue(String attributeName,
        String attributeValue) throws SystemException {
        for (PlanAttribute planAttribute : findByattributeByNameValue(
                attributeName, attributeValue, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(planAttribute);
        }
    }

    /**
     * Returns the number of plan attributes where attributeName = &#63; and attributeValue = &#63;.
     *
     * @param attributeName the attribute name
     * @param attributeValue the attribute value
     * @return the number of matching plan attributes
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByattributeByNameValue(String attributeName,
        String attributeValue) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_ATTRIBUTEBYNAMEVALUE;

        Object[] finderArgs = new Object[] { attributeName, attributeValue };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_PLANATTRIBUTE_WHERE);

            boolean bindAttributeName = false;

            if (attributeName == null) {
                query.append(_FINDER_COLUMN_ATTRIBUTEBYNAMEVALUE_ATTRIBUTENAME_1);
            } else if (attributeName.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_ATTRIBUTEBYNAMEVALUE_ATTRIBUTENAME_3);
            } else {
                bindAttributeName = true;

                query.append(_FINDER_COLUMN_ATTRIBUTEBYNAMEVALUE_ATTRIBUTENAME_2);
            }

            boolean bindAttributeValue = false;

            if (attributeValue == null) {
                query.append(_FINDER_COLUMN_ATTRIBUTEBYNAMEVALUE_ATTRIBUTEVALUE_1);
            } else if (attributeValue.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_ATTRIBUTEBYNAMEVALUE_ATTRIBUTEVALUE_3);
            } else {
                bindAttributeValue = true;

                query.append(_FINDER_COLUMN_ATTRIBUTEBYNAMEVALUE_ATTRIBUTEVALUE_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindAttributeName) {
                    qPos.add(attributeName);
                }

                if (bindAttributeValue) {
                    qPos.add(attributeValue);
                }

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
     * Caches the plan attribute in the entity cache if it is enabled.
     *
     * @param planAttribute the plan attribute
     */
    @Override
    public void cacheResult(PlanAttribute planAttribute) {
        EntityCacheUtil.putResult(PlanAttributeModelImpl.ENTITY_CACHE_ENABLED,
            PlanAttributeImpl.class, planAttribute.getPrimaryKey(),
            planAttribute);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ATTRIBUTEFORPLAN,
            new Object[] {
                planAttribute.getPlanId(), planAttribute.getAttributeName()
            }, planAttribute);

        planAttribute.resetOriginalValues();
    }

    /**
     * Caches the plan attributes in the entity cache if it is enabled.
     *
     * @param planAttributes the plan attributes
     */
    @Override
    public void cacheResult(List<PlanAttribute> planAttributes) {
        for (PlanAttribute planAttribute : planAttributes) {
            if (EntityCacheUtil.getResult(
                        PlanAttributeModelImpl.ENTITY_CACHE_ENABLED,
                        PlanAttributeImpl.class, planAttribute.getPrimaryKey()) == null) {
                cacheResult(planAttribute);
            } else {
                planAttribute.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all plan attributes.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(PlanAttributeImpl.class.getName());
        }

        EntityCacheUtil.clearCache(PlanAttributeImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the plan attribute.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(PlanAttribute planAttribute) {
        EntityCacheUtil.removeResult(PlanAttributeModelImpl.ENTITY_CACHE_ENABLED,
            PlanAttributeImpl.class, planAttribute.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        clearUniqueFindersCache(planAttribute);
    }

    @Override
    public void clearCache(List<PlanAttribute> planAttributes) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (PlanAttribute planAttribute : planAttributes) {
            EntityCacheUtil.removeResult(PlanAttributeModelImpl.ENTITY_CACHE_ENABLED,
                PlanAttributeImpl.class, planAttribute.getPrimaryKey());

            clearUniqueFindersCache(planAttribute);
        }
    }

    protected void cacheUniqueFindersCache(PlanAttribute planAttribute) {
        if (planAttribute.isNew()) {
            Object[] args = new Object[] {
                    planAttribute.getPlanId(), planAttribute.getAttributeName()
                };

            FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ATTRIBUTEFORPLAN,
                args, Long.valueOf(1));
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ATTRIBUTEFORPLAN,
                args, planAttribute);
        } else {
            PlanAttributeModelImpl planAttributeModelImpl = (PlanAttributeModelImpl) planAttribute;

            if ((planAttributeModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_ATTRIBUTEFORPLAN.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        planAttribute.getPlanId(),
                        planAttribute.getAttributeName()
                    };

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ATTRIBUTEFORPLAN,
                    args, Long.valueOf(1));
                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ATTRIBUTEFORPLAN,
                    args, planAttribute);
            }
        }
    }

    protected void clearUniqueFindersCache(PlanAttribute planAttribute) {
        PlanAttributeModelImpl planAttributeModelImpl = (PlanAttributeModelImpl) planAttribute;

        Object[] args = new Object[] {
                planAttribute.getPlanId(), planAttribute.getAttributeName()
            };

        FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ATTRIBUTEFORPLAN, args);
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ATTRIBUTEFORPLAN, args);

        if ((planAttributeModelImpl.getColumnBitmask() &
                FINDER_PATH_FETCH_BY_ATTRIBUTEFORPLAN.getColumnBitmask()) != 0) {
            args = new Object[] {
                    planAttributeModelImpl.getOriginalPlanId(),
                    planAttributeModelImpl.getOriginalAttributeName()
                };

            FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ATTRIBUTEFORPLAN,
                args);
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ATTRIBUTEFORPLAN,
                args);
        }
    }

    /**
     * Creates a new plan attribute with the primary key. Does not add the plan attribute to the database.
     *
     * @param attributeId the primary key for the new plan attribute
     * @return the new plan attribute
     */
    @Override
    public PlanAttribute create(long attributeId) {
        PlanAttribute planAttribute = new PlanAttributeImpl();

        planAttribute.setNew(true);
        planAttribute.setPrimaryKey(attributeId);

        return planAttribute;
    }

    /**
     * Removes the plan attribute with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param attributeId the primary key of the plan attribute
     * @return the plan attribute that was removed
     * @throws com.ext.portlet.NoSuchPlanAttributeException if a plan attribute with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public PlanAttribute remove(long attributeId)
        throws NoSuchPlanAttributeException, SystemException {
        return remove((Serializable) attributeId);
    }

    /**
     * Removes the plan attribute with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the plan attribute
     * @return the plan attribute that was removed
     * @throws com.ext.portlet.NoSuchPlanAttributeException if a plan attribute with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public PlanAttribute remove(Serializable primaryKey)
        throws NoSuchPlanAttributeException, SystemException {
        Session session = null;

        try {
            session = openSession();

            PlanAttribute planAttribute = (PlanAttribute) session.get(PlanAttributeImpl.class,
                    primaryKey);

            if (planAttribute == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchPlanAttributeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(planAttribute);
        } catch (NoSuchPlanAttributeException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected PlanAttribute removeImpl(PlanAttribute planAttribute)
        throws SystemException {
        planAttribute = toUnwrappedModel(planAttribute);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(planAttribute)) {
                planAttribute = (PlanAttribute) session.get(PlanAttributeImpl.class,
                        planAttribute.getPrimaryKeyObj());
            }

            if (planAttribute != null) {
                session.delete(planAttribute);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (planAttribute != null) {
            clearCache(planAttribute);
        }

        return planAttribute;
    }

    @Override
    public PlanAttribute updateImpl(
        com.ext.portlet.model.PlanAttribute planAttribute)
        throws SystemException {
        planAttribute = toUnwrappedModel(planAttribute);

        boolean isNew = planAttribute.isNew();

        PlanAttributeModelImpl planAttributeModelImpl = (PlanAttributeModelImpl) planAttribute;

        Session session = null;

        try {
            session = openSession();

            if (planAttribute.isNew()) {
                session.save(planAttribute);

                planAttribute.setNew(false);
            } else {
                session.merge(planAttribute);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !PlanAttributeModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((planAttributeModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PLANATTRIBUTES.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        planAttributeModelImpl.getOriginalPlanId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PLANATTRIBUTES,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PLANATTRIBUTES,
                    args);

                args = new Object[] { planAttributeModelImpl.getPlanId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PLANATTRIBUTES,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PLANATTRIBUTES,
                    args);
            }

            if ((planAttributeModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ATTRIBUTEBYNAMEVALUE.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        planAttributeModelImpl.getOriginalAttributeName(),
                        planAttributeModelImpl.getOriginalAttributeValue()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ATTRIBUTEBYNAMEVALUE,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ATTRIBUTEBYNAMEVALUE,
                    args);

                args = new Object[] {
                        planAttributeModelImpl.getAttributeName(),
                        planAttributeModelImpl.getAttributeValue()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ATTRIBUTEBYNAMEVALUE,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ATTRIBUTEBYNAMEVALUE,
                    args);
            }
        }

        EntityCacheUtil.putResult(PlanAttributeModelImpl.ENTITY_CACHE_ENABLED,
            PlanAttributeImpl.class, planAttribute.getPrimaryKey(),
            planAttribute);

        clearUniqueFindersCache(planAttribute);
        cacheUniqueFindersCache(planAttribute);

        return planAttribute;
    }

    protected PlanAttribute toUnwrappedModel(PlanAttribute planAttribute) {
        if (planAttribute instanceof PlanAttributeImpl) {
            return planAttribute;
        }

        PlanAttributeImpl planAttributeImpl = new PlanAttributeImpl();

        planAttributeImpl.setNew(planAttribute.isNew());
        planAttributeImpl.setPrimaryKey(planAttribute.getPrimaryKey());

        planAttributeImpl.setAttributeId(planAttribute.getAttributeId());
        planAttributeImpl.setPlanId(planAttribute.getPlanId());
        planAttributeImpl.setAttributeName(planAttribute.getAttributeName());
        planAttributeImpl.setAttributeValue(planAttribute.getAttributeValue());

        return planAttributeImpl;
    }

    /**
     * Returns the plan attribute with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the plan attribute
     * @return the plan attribute
     * @throws com.ext.portlet.NoSuchPlanAttributeException if a plan attribute with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public PlanAttribute findByPrimaryKey(Serializable primaryKey)
        throws NoSuchPlanAttributeException, SystemException {
        PlanAttribute planAttribute = fetchByPrimaryKey(primaryKey);

        if (planAttribute == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchPlanAttributeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return planAttribute;
    }

    /**
     * Returns the plan attribute with the primary key or throws a {@link com.ext.portlet.NoSuchPlanAttributeException} if it could not be found.
     *
     * @param attributeId the primary key of the plan attribute
     * @return the plan attribute
     * @throws com.ext.portlet.NoSuchPlanAttributeException if a plan attribute with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public PlanAttribute findByPrimaryKey(long attributeId)
        throws NoSuchPlanAttributeException, SystemException {
        return findByPrimaryKey((Serializable) attributeId);
    }

    /**
     * Returns the plan attribute with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the plan attribute
     * @return the plan attribute, or <code>null</code> if a plan attribute with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public PlanAttribute fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        PlanAttribute planAttribute = (PlanAttribute) EntityCacheUtil.getResult(PlanAttributeModelImpl.ENTITY_CACHE_ENABLED,
                PlanAttributeImpl.class, primaryKey);

        if (planAttribute == _nullPlanAttribute) {
            return null;
        }

        if (planAttribute == null) {
            Session session = null;

            try {
                session = openSession();

                planAttribute = (PlanAttribute) session.get(PlanAttributeImpl.class,
                        primaryKey);

                if (planAttribute != null) {
                    cacheResult(planAttribute);
                } else {
                    EntityCacheUtil.putResult(PlanAttributeModelImpl.ENTITY_CACHE_ENABLED,
                        PlanAttributeImpl.class, primaryKey, _nullPlanAttribute);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(PlanAttributeModelImpl.ENTITY_CACHE_ENABLED,
                    PlanAttributeImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return planAttribute;
    }

    /**
     * Returns the plan attribute with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param attributeId the primary key of the plan attribute
     * @return the plan attribute, or <code>null</code> if a plan attribute with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public PlanAttribute fetchByPrimaryKey(long attributeId)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) attributeId);
    }

    /**
     * Returns all the plan attributes.
     *
     * @return the plan attributes
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<PlanAttribute> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the plan attributes.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ext.portlet.model.impl.PlanAttributeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of plan attributes
     * @param end the upper bound of the range of plan attributes (not inclusive)
     * @return the range of plan attributes
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<PlanAttribute> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the plan attributes.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ext.portlet.model.impl.PlanAttributeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of plan attributes
     * @param end the upper bound of the range of plan attributes (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of plan attributes
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<PlanAttribute> findAll(int start, int end,
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

        List<PlanAttribute> list = (List<PlanAttribute>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_PLANATTRIBUTE);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_PLANATTRIBUTE;

                if (pagination) {
                    sql = sql.concat(PlanAttributeModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<PlanAttribute>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<PlanAttribute>(list);
                } else {
                    list = (List<PlanAttribute>) QueryUtil.list(q,
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
     * Removes all the plan attributes from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (PlanAttribute planAttribute : findAll()) {
            remove(planAttribute);
        }
    }

    /**
     * Returns the number of plan attributes.
     *
     * @return the number of plan attributes
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

                Query q = session.createQuery(_SQL_COUNT_PLANATTRIBUTE);

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
     * Initializes the plan attribute persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.ext.portlet.model.PlanAttribute")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<PlanAttribute>> listenersList = new ArrayList<ModelListener<PlanAttribute>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<PlanAttribute>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(PlanAttributeImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
