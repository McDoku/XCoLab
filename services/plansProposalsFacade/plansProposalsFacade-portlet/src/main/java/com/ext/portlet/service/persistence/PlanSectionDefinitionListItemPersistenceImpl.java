package com.ext.portlet.service.persistence;

import com.ext.portlet.NoSuchPlanSectionDefinitionListItemException;
import com.ext.portlet.model.PlanSectionDefinitionListItem;
import com.ext.portlet.model.impl.PlanSectionDefinitionListItemImpl;
import com.ext.portlet.model.impl.PlanSectionDefinitionListItemModelImpl;
import com.ext.portlet.service.persistence.ActivitySubscriptionPersistence;
import com.ext.portlet.service.persistence.BalloonStatsEntryPersistence;
import com.ext.portlet.service.persistence.ContestDebatePersistence;
import com.ext.portlet.service.persistence.ContestPersistence;
import com.ext.portlet.service.persistence.ContestPhaseColumnPersistence;
import com.ext.portlet.service.persistence.ContestPhasePersistence;
import com.ext.portlet.service.persistence.ContestPhaseTypePersistence;
import com.ext.portlet.service.persistence.ContestTeamMemberPersistence;
import com.ext.portlet.service.persistence.DiscussionCategoryGroupPersistence;
import com.ext.portlet.service.persistence.DiscussionCategoryPersistence;
import com.ext.portlet.service.persistence.DiscussionMessageFlagPersistence;
import com.ext.portlet.service.persistence.DiscussionMessagePersistence;
import com.ext.portlet.service.persistence.EmailListPersistence;
import com.ext.portlet.service.persistence.FocusAreaOntologyTermPersistence;
import com.ext.portlet.service.persistence.FocusAreaPersistence;
import com.ext.portlet.service.persistence.LandingPagePersistence;
import com.ext.portlet.service.persistence.MessagePersistence;
import com.ext.portlet.service.persistence.MessageRecipientStatusPersistence;
import com.ext.portlet.service.persistence.MessagingIgnoredRecipientsPersistence;
import com.ext.portlet.service.persistence.MessagingMessageConversionPersistence;
import com.ext.portlet.service.persistence.MessagingMessageConversionTypePersistence;
import com.ext.portlet.service.persistence.MessagingMessagePersistence;
import com.ext.portlet.service.persistence.MessagingMessageRecipientPersistence;
import com.ext.portlet.service.persistence.MessagingRedirectLinkPersistence;
import com.ext.portlet.service.persistence.MessagingUserPreferencesPersistence;
import com.ext.portlet.service.persistence.ModelCategoryPersistence;
import com.ext.portlet.service.persistence.ModelDiscussionPersistence;
import com.ext.portlet.service.persistence.ModelGlobalPreferencePersistence;
import com.ext.portlet.service.persistence.ModelInputGroupPersistence;
import com.ext.portlet.service.persistence.ModelInputItemPersistence;
import com.ext.portlet.service.persistence.ModelOutputChartOrderPersistence;
import com.ext.portlet.service.persistence.ModelOutputItemPersistence;
import com.ext.portlet.service.persistence.ModelPositionPersistence;
import com.ext.portlet.service.persistence.OntologySpacePersistence;
import com.ext.portlet.service.persistence.OntologyTermEntityPersistence;
import com.ext.portlet.service.persistence.OntologyTermPersistence;
import com.ext.portlet.service.persistence.PlanAttributeFilterPersistence;
import com.ext.portlet.service.persistence.PlanAttributePersistence;
import com.ext.portlet.service.persistence.PlanColumnSettingsPersistence;
import com.ext.portlet.service.persistence.PlanDescriptionPersistence;
import com.ext.portlet.service.persistence.PlanFanPersistence;
import com.ext.portlet.service.persistence.PlanItemGroupPersistence;
import com.ext.portlet.service.persistence.PlanItemPersistence;
import com.ext.portlet.service.persistence.PlanMetaPersistence;
import com.ext.portlet.service.persistence.PlanModelRunPersistence;
import com.ext.portlet.service.persistence.PlanPositionItemPersistence;
import com.ext.portlet.service.persistence.PlanPositionPersistence;
import com.ext.portlet.service.persistence.PlanPositionsPersistence;
import com.ext.portlet.service.persistence.PlanPropertyFilterPersistence;
import com.ext.portlet.service.persistence.PlanRelatedPersistence;
import com.ext.portlet.service.persistence.PlanSectionDefinitionListItemPersistence;
import com.ext.portlet.service.persistence.PlanSectionDefinitionPersistence;
import com.ext.portlet.service.persistence.PlanSectionPersistence;
import com.ext.portlet.service.persistence.PlanSectionPlanMapPersistence;
import com.ext.portlet.service.persistence.PlanTeamHistoryPersistence;
import com.ext.portlet.service.persistence.PlanTemplatePersistence;
import com.ext.portlet.service.persistence.PlanTemplateSectionPersistence;
import com.ext.portlet.service.persistence.PlanTypeAttributePersistence;
import com.ext.portlet.service.persistence.PlanTypeColumnPersistence;
import com.ext.portlet.service.persistence.PlanTypePersistence;
import com.ext.portlet.service.persistence.PlanVotePersistence;
import com.ext.portlet.service.persistence.PlansFilterPersistence;
import com.ext.portlet.service.persistence.PlansFilterPositionPersistence;
import com.ext.portlet.service.persistence.PlansUserSettingsPersistence;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
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
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the plan section definition list item service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PlanSectionDefinitionListItemPersistence
 * @see PlanSectionDefinitionListItemUtil
 * @generated
 */
public class PlanSectionDefinitionListItemPersistenceImpl
    extends BasePersistenceImpl<PlanSectionDefinitionListItem>
    implements PlanSectionDefinitionListItemPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link PlanSectionDefinitionListItemUtil} to access the plan section definition list item persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = PlanSectionDefinitionListItemImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PLANSECTIONDEFINITIONIDTYPE =
        new FinderPath(PlanSectionDefinitionListItemModelImpl.ENTITY_CACHE_ENABLED,
            PlanSectionDefinitionListItemModelImpl.FINDER_CACHE_ENABLED,
            PlanSectionDefinitionListItemImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findByPlanSectionDefinitionIdType",
            new String[] {
                Long.class.getName(), String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PLANSECTIONDEFINITIONIDTYPE =
        new FinderPath(PlanSectionDefinitionListItemModelImpl.ENTITY_CACHE_ENABLED,
            PlanSectionDefinitionListItemModelImpl.FINDER_CACHE_ENABLED,
            PlanSectionDefinitionListItemImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "findByPlanSectionDefinitionIdType",
            new String[] { Long.class.getName(), String.class.getName() },
            PlanSectionDefinitionListItemModelImpl.SECTIONDEFINITIONID_COLUMN_BITMASK |
            PlanSectionDefinitionListItemModelImpl.TYPE_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_PLANSECTIONDEFINITIONIDTYPE =
        new FinderPath(PlanSectionDefinitionListItemModelImpl.ENTITY_CACHE_ENABLED,
            PlanSectionDefinitionListItemModelImpl.FINDER_CACHE_ENABLED,
            Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countByPlanSectionDefinitionIdType",
            new String[] { Long.class.getName(), String.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(PlanSectionDefinitionListItemModelImpl.ENTITY_CACHE_ENABLED,
            PlanSectionDefinitionListItemModelImpl.FINDER_CACHE_ENABLED,
            PlanSectionDefinitionListItemImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(PlanSectionDefinitionListItemModelImpl.ENTITY_CACHE_ENABLED,
            PlanSectionDefinitionListItemModelImpl.FINDER_CACHE_ENABLED,
            PlanSectionDefinitionListItemImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PlanSectionDefinitionListItemModelImpl.ENTITY_CACHE_ENABLED,
            PlanSectionDefinitionListItemModelImpl.FINDER_CACHE_ENABLED,
            Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
            new String[0]);
    private static final String _SQL_SELECT_PLANSECTIONDEFINITIONLISTITEM = "SELECT planSectionDefinitionListItem FROM PlanSectionDefinitionListItem planSectionDefinitionListItem";
    private static final String _SQL_SELECT_PLANSECTIONDEFINITIONLISTITEM_WHERE = "SELECT planSectionDefinitionListItem FROM PlanSectionDefinitionListItem planSectionDefinitionListItem WHERE ";
    private static final String _SQL_COUNT_PLANSECTIONDEFINITIONLISTITEM = "SELECT COUNT(planSectionDefinitionListItem) FROM PlanSectionDefinitionListItem planSectionDefinitionListItem";
    private static final String _SQL_COUNT_PLANSECTIONDEFINITIONLISTITEM_WHERE = "SELECT COUNT(planSectionDefinitionListItem) FROM PlanSectionDefinitionListItem planSectionDefinitionListItem WHERE ";
    private static final String _FINDER_COLUMN_PLANSECTIONDEFINITIONIDTYPE_SECTIONDEFINITIONID_2 =
        "planSectionDefinitionListItem.sectionDefinitionId = ? AND ";
    private static final String _FINDER_COLUMN_PLANSECTIONDEFINITIONIDTYPE_TYPE_1 =
        "planSectionDefinitionListItem.type IS NULL";
    private static final String _FINDER_COLUMN_PLANSECTIONDEFINITIONIDTYPE_TYPE_2 =
        "planSectionDefinitionListItem.type = ?";
    private static final String _FINDER_COLUMN_PLANSECTIONDEFINITIONIDTYPE_TYPE_3 =
        "(planSectionDefinitionListItem.type IS NULL OR planSectionDefinitionListItem.type = ?)";
    private static final String _ORDER_BY_ENTITY_ALIAS = "planSectionDefinitionListItem.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No PlanSectionDefinitionListItem exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No PlanSectionDefinitionListItem exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(PlanSectionDefinitionListItemPersistenceImpl.class);
    private static PlanSectionDefinitionListItem _nullPlanSectionDefinitionListItem =
        new PlanSectionDefinitionListItemImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<PlanSectionDefinitionListItem> toCacheModel() {
                return _nullPlanSectionDefinitionListItemCacheModel;
            }
        };

    private static CacheModel<PlanSectionDefinitionListItem> _nullPlanSectionDefinitionListItemCacheModel =
        new CacheModel<PlanSectionDefinitionListItem>() {
            public PlanSectionDefinitionListItem toEntityModel() {
                return _nullPlanSectionDefinitionListItem;
            }
        };

    @BeanReference(type = ActivitySubscriptionPersistence.class)
    protected ActivitySubscriptionPersistence activitySubscriptionPersistence;
    @BeanReference(type = BalloonStatsEntryPersistence.class)
    protected BalloonStatsEntryPersistence balloonStatsEntryPersistence;
    @BeanReference(type = ContestPersistence.class)
    protected ContestPersistence contestPersistence;
    @BeanReference(type = ContestDebatePersistence.class)
    protected ContestDebatePersistence contestDebatePersistence;
    @BeanReference(type = ContestPhasePersistence.class)
    protected ContestPhasePersistence contestPhasePersistence;
    @BeanReference(type = ContestPhaseColumnPersistence.class)
    protected ContestPhaseColumnPersistence contestPhaseColumnPersistence;
    @BeanReference(type = ContestPhaseTypePersistence.class)
    protected ContestPhaseTypePersistence contestPhaseTypePersistence;
    @BeanReference(type = ContestTeamMemberPersistence.class)
    protected ContestTeamMemberPersistence contestTeamMemberPersistence;
    @BeanReference(type = DiscussionCategoryPersistence.class)
    protected DiscussionCategoryPersistence discussionCategoryPersistence;
    @BeanReference(type = DiscussionCategoryGroupPersistence.class)
    protected DiscussionCategoryGroupPersistence discussionCategoryGroupPersistence;
    @BeanReference(type = DiscussionMessagePersistence.class)
    protected DiscussionMessagePersistence discussionMessagePersistence;
    @BeanReference(type = DiscussionMessageFlagPersistence.class)
    protected DiscussionMessageFlagPersistence discussionMessageFlagPersistence;
    @BeanReference(type = EmailListPersistence.class)
    protected EmailListPersistence emailListPersistence;
    @BeanReference(type = FocusAreaPersistence.class)
    protected FocusAreaPersistence focusAreaPersistence;
    @BeanReference(type = FocusAreaOntologyTermPersistence.class)
    protected FocusAreaOntologyTermPersistence focusAreaOntologyTermPersistence;
    @BeanReference(type = LandingPagePersistence.class)
    protected LandingPagePersistence landingPagePersistence;
    @BeanReference(type = MessagePersistence.class)
    protected MessagePersistence messagePersistence;
    @BeanReference(type = MessageRecipientStatusPersistence.class)
    protected MessageRecipientStatusPersistence messageRecipientStatusPersistence;
    @BeanReference(type = MessagingIgnoredRecipientsPersistence.class)
    protected MessagingIgnoredRecipientsPersistence messagingIgnoredRecipientsPersistence;
    @BeanReference(type = MessagingMessagePersistence.class)
    protected MessagingMessagePersistence messagingMessagePersistence;
    @BeanReference(type = MessagingMessageConversionPersistence.class)
    protected MessagingMessageConversionPersistence messagingMessageConversionPersistence;
    @BeanReference(type = MessagingMessageConversionTypePersistence.class)
    protected MessagingMessageConversionTypePersistence messagingMessageConversionTypePersistence;
    @BeanReference(type = MessagingMessageRecipientPersistence.class)
    protected MessagingMessageRecipientPersistence messagingMessageRecipientPersistence;
    @BeanReference(type = MessagingRedirectLinkPersistence.class)
    protected MessagingRedirectLinkPersistence messagingRedirectLinkPersistence;
    @BeanReference(type = MessagingUserPreferencesPersistence.class)
    protected MessagingUserPreferencesPersistence messagingUserPreferencesPersistence;
    @BeanReference(type = ModelCategoryPersistence.class)
    protected ModelCategoryPersistence modelCategoryPersistence;
    @BeanReference(type = ModelDiscussionPersistence.class)
    protected ModelDiscussionPersistence modelDiscussionPersistence;
    @BeanReference(type = ModelGlobalPreferencePersistence.class)
    protected ModelGlobalPreferencePersistence modelGlobalPreferencePersistence;
    @BeanReference(type = ModelInputGroupPersistence.class)
    protected ModelInputGroupPersistence modelInputGroupPersistence;
    @BeanReference(type = ModelInputItemPersistence.class)
    protected ModelInputItemPersistence modelInputItemPersistence;
    @BeanReference(type = ModelOutputChartOrderPersistence.class)
    protected ModelOutputChartOrderPersistence modelOutputChartOrderPersistence;
    @BeanReference(type = ModelOutputItemPersistence.class)
    protected ModelOutputItemPersistence modelOutputItemPersistence;
    @BeanReference(type = ModelPositionPersistence.class)
    protected ModelPositionPersistence modelPositionPersistence;
    @BeanReference(type = OntologySpacePersistence.class)
    protected OntologySpacePersistence ontologySpacePersistence;
    @BeanReference(type = OntologyTermPersistence.class)
    protected OntologyTermPersistence ontologyTermPersistence;
    @BeanReference(type = OntologyTermEntityPersistence.class)
    protected OntologyTermEntityPersistence ontologyTermEntityPersistence;
    @BeanReference(type = PlanAttributePersistence.class)
    protected PlanAttributePersistence planAttributePersistence;
    @BeanReference(type = PlanAttributeFilterPersistence.class)
    protected PlanAttributeFilterPersistence planAttributeFilterPersistence;
    @BeanReference(type = PlanColumnSettingsPersistence.class)
    protected PlanColumnSettingsPersistence planColumnSettingsPersistence;
    @BeanReference(type = PlanDescriptionPersistence.class)
    protected PlanDescriptionPersistence planDescriptionPersistence;
    @BeanReference(type = PlanFanPersistence.class)
    protected PlanFanPersistence planFanPersistence;
    @BeanReference(type = PlanItemPersistence.class)
    protected PlanItemPersistence planItemPersistence;
    @BeanReference(type = PlanItemGroupPersistence.class)
    protected PlanItemGroupPersistence planItemGroupPersistence;
    @BeanReference(type = PlanMetaPersistence.class)
    protected PlanMetaPersistence planMetaPersistence;
    @BeanReference(type = PlanModelRunPersistence.class)
    protected PlanModelRunPersistence planModelRunPersistence;
    @BeanReference(type = PlanPositionPersistence.class)
    protected PlanPositionPersistence planPositionPersistence;
    @BeanReference(type = PlanPositionItemPersistence.class)
    protected PlanPositionItemPersistence planPositionItemPersistence;
    @BeanReference(type = PlanPositionsPersistence.class)
    protected PlanPositionsPersistence planPositionsPersistence;
    @BeanReference(type = PlanPropertyFilterPersistence.class)
    protected PlanPropertyFilterPersistence planPropertyFilterPersistence;
    @BeanReference(type = PlanRelatedPersistence.class)
    protected PlanRelatedPersistence planRelatedPersistence;
    @BeanReference(type = PlanSectionPersistence.class)
    protected PlanSectionPersistence planSectionPersistence;
    @BeanReference(type = PlanSectionDefinitionPersistence.class)
    protected PlanSectionDefinitionPersistence planSectionDefinitionPersistence;
    @BeanReference(type = PlanSectionDefinitionListItemPersistence.class)
    protected PlanSectionDefinitionListItemPersistence planSectionDefinitionListItemPersistence;
    @BeanReference(type = PlanSectionPlanMapPersistence.class)
    protected PlanSectionPlanMapPersistence planSectionPlanMapPersistence;
    @BeanReference(type = PlansFilterPersistence.class)
    protected PlansFilterPersistence plansFilterPersistence;
    @BeanReference(type = PlansFilterPositionPersistence.class)
    protected PlansFilterPositionPersistence plansFilterPositionPersistence;
    @BeanReference(type = PlansUserSettingsPersistence.class)
    protected PlansUserSettingsPersistence plansUserSettingsPersistence;
    @BeanReference(type = PlanTeamHistoryPersistence.class)
    protected PlanTeamHistoryPersistence planTeamHistoryPersistence;
    @BeanReference(type = PlanTemplatePersistence.class)
    protected PlanTemplatePersistence planTemplatePersistence;
    @BeanReference(type = PlanTemplateSectionPersistence.class)
    protected PlanTemplateSectionPersistence planTemplateSectionPersistence;
    @BeanReference(type = PlanTypePersistence.class)
    protected PlanTypePersistence planTypePersistence;
    @BeanReference(type = PlanTypeAttributePersistence.class)
    protected PlanTypeAttributePersistence planTypeAttributePersistence;
    @BeanReference(type = PlanTypeColumnPersistence.class)
    protected PlanTypeColumnPersistence planTypeColumnPersistence;
    @BeanReference(type = PlanVotePersistence.class)
    protected PlanVotePersistence planVotePersistence;
    @BeanReference(type = ResourcePersistence.class)
    protected ResourcePersistence resourcePersistence;
    @BeanReference(type = UserPersistence.class)
    protected UserPersistence userPersistence;

    /**
     * Caches the plan section definition list item in the entity cache if it is enabled.
     *
     * @param planSectionDefinitionListItem the plan section definition list item
     */
    public void cacheResult(
        PlanSectionDefinitionListItem planSectionDefinitionListItem) {
        EntityCacheUtil.putResult(PlanSectionDefinitionListItemModelImpl.ENTITY_CACHE_ENABLED,
            PlanSectionDefinitionListItemImpl.class,
            planSectionDefinitionListItem.getPrimaryKey(),
            planSectionDefinitionListItem);

        planSectionDefinitionListItem.resetOriginalValues();
    }

    /**
     * Caches the plan section definition list items in the entity cache if it is enabled.
     *
     * @param planSectionDefinitionListItems the plan section definition list items
     */
    public void cacheResult(
        List<PlanSectionDefinitionListItem> planSectionDefinitionListItems) {
        for (PlanSectionDefinitionListItem planSectionDefinitionListItem : planSectionDefinitionListItems) {
            if (EntityCacheUtil.getResult(
                        PlanSectionDefinitionListItemModelImpl.ENTITY_CACHE_ENABLED,
                        PlanSectionDefinitionListItemImpl.class,
                        planSectionDefinitionListItem.getPrimaryKey()) == null) {
                cacheResult(planSectionDefinitionListItem);
            } else {
                planSectionDefinitionListItem.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all plan section definition list items.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(PlanSectionDefinitionListItemImpl.class.getName());
        }

        EntityCacheUtil.clearCache(PlanSectionDefinitionListItemImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the plan section definition list item.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(
        PlanSectionDefinitionListItem planSectionDefinitionListItem) {
        EntityCacheUtil.removeResult(PlanSectionDefinitionListItemModelImpl.ENTITY_CACHE_ENABLED,
            PlanSectionDefinitionListItemImpl.class,
            planSectionDefinitionListItem.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(
        List<PlanSectionDefinitionListItem> planSectionDefinitionListItems) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (PlanSectionDefinitionListItem planSectionDefinitionListItem : planSectionDefinitionListItems) {
            EntityCacheUtil.removeResult(PlanSectionDefinitionListItemModelImpl.ENTITY_CACHE_ENABLED,
                PlanSectionDefinitionListItemImpl.class,
                planSectionDefinitionListItem.getPrimaryKey());
        }
    }

    /**
     * Creates a new plan section definition list item with the primary key. Does not add the plan section definition list item to the database.
     *
     * @param id the primary key for the new plan section definition list item
     * @return the new plan section definition list item
     */
    public PlanSectionDefinitionListItem create(long id) {
        PlanSectionDefinitionListItem planSectionDefinitionListItem = new PlanSectionDefinitionListItemImpl();

        planSectionDefinitionListItem.setNew(true);
        planSectionDefinitionListItem.setPrimaryKey(id);

        return planSectionDefinitionListItem;
    }

    /**
     * Removes the plan section definition list item with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param id the primary key of the plan section definition list item
     * @return the plan section definition list item that was removed
     * @throws com.ext.portlet.NoSuchPlanSectionDefinitionListItemException if a plan section definition list item with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public PlanSectionDefinitionListItem remove(long id)
        throws NoSuchPlanSectionDefinitionListItemException, SystemException {
        return remove(Long.valueOf(id));
    }

    /**
     * Removes the plan section definition list item with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the plan section definition list item
     * @return the plan section definition list item that was removed
     * @throws com.ext.portlet.NoSuchPlanSectionDefinitionListItemException if a plan section definition list item with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public PlanSectionDefinitionListItem remove(Serializable primaryKey)
        throws NoSuchPlanSectionDefinitionListItemException, SystemException {
        Session session = null;

        try {
            session = openSession();

            PlanSectionDefinitionListItem planSectionDefinitionListItem = (PlanSectionDefinitionListItem) session.get(PlanSectionDefinitionListItemImpl.class,
                    primaryKey);

            if (planSectionDefinitionListItem == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchPlanSectionDefinitionListItemException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(planSectionDefinitionListItem);
        } catch (NoSuchPlanSectionDefinitionListItemException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected PlanSectionDefinitionListItem removeImpl(
        PlanSectionDefinitionListItem planSectionDefinitionListItem)
        throws SystemException {
        planSectionDefinitionListItem = toUnwrappedModel(planSectionDefinitionListItem);

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.delete(session, planSectionDefinitionListItem);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        clearCache(planSectionDefinitionListItem);

        return planSectionDefinitionListItem;
    }

    @Override
    public PlanSectionDefinitionListItem updateImpl(
        com.ext.portlet.model.PlanSectionDefinitionListItem planSectionDefinitionListItem,
        boolean merge) throws SystemException {
        planSectionDefinitionListItem = toUnwrappedModel(planSectionDefinitionListItem);

        boolean isNew = planSectionDefinitionListItem.isNew();

        PlanSectionDefinitionListItemModelImpl planSectionDefinitionListItemModelImpl =
            (PlanSectionDefinitionListItemModelImpl) planSectionDefinitionListItem;

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, planSectionDefinitionListItem,
                merge);

            planSectionDefinitionListItem.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew ||
                !PlanSectionDefinitionListItemModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((planSectionDefinitionListItemModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PLANSECTIONDEFINITIONIDTYPE.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        Long.valueOf(planSectionDefinitionListItemModelImpl.getOriginalSectionDefinitionId()),
                        
                        planSectionDefinitionListItemModelImpl.getOriginalType()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PLANSECTIONDEFINITIONIDTYPE,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PLANSECTIONDEFINITIONIDTYPE,
                    args);

                args = new Object[] {
                        Long.valueOf(planSectionDefinitionListItemModelImpl.getSectionDefinitionId()),
                        
                        planSectionDefinitionListItemModelImpl.getType()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PLANSECTIONDEFINITIONIDTYPE,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PLANSECTIONDEFINITIONIDTYPE,
                    args);
            }
        }

        EntityCacheUtil.putResult(PlanSectionDefinitionListItemModelImpl.ENTITY_CACHE_ENABLED,
            PlanSectionDefinitionListItemImpl.class,
            planSectionDefinitionListItem.getPrimaryKey(),
            planSectionDefinitionListItem);

        return planSectionDefinitionListItem;
    }

    protected PlanSectionDefinitionListItem toUnwrappedModel(
        PlanSectionDefinitionListItem planSectionDefinitionListItem) {
        if (planSectionDefinitionListItem instanceof PlanSectionDefinitionListItemImpl) {
            return planSectionDefinitionListItem;
        }

        PlanSectionDefinitionListItemImpl planSectionDefinitionListItemImpl = new PlanSectionDefinitionListItemImpl();

        planSectionDefinitionListItemImpl.setNew(planSectionDefinitionListItem.isNew());
        planSectionDefinitionListItemImpl.setPrimaryKey(planSectionDefinitionListItem.getPrimaryKey());

        planSectionDefinitionListItemImpl.setId(planSectionDefinitionListItem.getId());
        planSectionDefinitionListItemImpl.setSectionDefinitionId(planSectionDefinitionListItem.getSectionDefinitionId());
        planSectionDefinitionListItemImpl.setType(planSectionDefinitionListItem.getType());
        planSectionDefinitionListItemImpl.setReferencedId(planSectionDefinitionListItem.getReferencedId());
        planSectionDefinitionListItemImpl.setData(planSectionDefinitionListItem.getData());

        return planSectionDefinitionListItemImpl;
    }

    /**
     * Returns the plan section definition list item with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the plan section definition list item
     * @return the plan section definition list item
     * @throws com.liferay.portal.NoSuchModelException if a plan section definition list item with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public PlanSectionDefinitionListItem findByPrimaryKey(
        Serializable primaryKey) throws NoSuchModelException, SystemException {
        return findByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the plan section definition list item with the primary key or throws a {@link com.ext.portlet.NoSuchPlanSectionDefinitionListItemException} if it could not be found.
     *
     * @param id the primary key of the plan section definition list item
     * @return the plan section definition list item
     * @throws com.ext.portlet.NoSuchPlanSectionDefinitionListItemException if a plan section definition list item with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public PlanSectionDefinitionListItem findByPrimaryKey(long id)
        throws NoSuchPlanSectionDefinitionListItemException, SystemException {
        PlanSectionDefinitionListItem planSectionDefinitionListItem = fetchByPrimaryKey(id);

        if (planSectionDefinitionListItem == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
            }

            throw new NoSuchPlanSectionDefinitionListItemException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                id);
        }

        return planSectionDefinitionListItem;
    }

    /**
     * Returns the plan section definition list item with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the plan section definition list item
     * @return the plan section definition list item, or <code>null</code> if a plan section definition list item with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public PlanSectionDefinitionListItem fetchByPrimaryKey(
        Serializable primaryKey) throws SystemException {
        return fetchByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the plan section definition list item with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param id the primary key of the plan section definition list item
     * @return the plan section definition list item, or <code>null</code> if a plan section definition list item with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public PlanSectionDefinitionListItem fetchByPrimaryKey(long id)
        throws SystemException {
        PlanSectionDefinitionListItem planSectionDefinitionListItem = (PlanSectionDefinitionListItem) EntityCacheUtil.getResult(PlanSectionDefinitionListItemModelImpl.ENTITY_CACHE_ENABLED,
                PlanSectionDefinitionListItemImpl.class, id);

        if (planSectionDefinitionListItem == _nullPlanSectionDefinitionListItem) {
            return null;
        }

        if (planSectionDefinitionListItem == null) {
            Session session = null;

            boolean hasException = false;

            try {
                session = openSession();

                planSectionDefinitionListItem = (PlanSectionDefinitionListItem) session.get(PlanSectionDefinitionListItemImpl.class,
                        Long.valueOf(id));
            } catch (Exception e) {
                hasException = true;

                throw processException(e);
            } finally {
                if (planSectionDefinitionListItem != null) {
                    cacheResult(planSectionDefinitionListItem);
                } else if (!hasException) {
                    EntityCacheUtil.putResult(PlanSectionDefinitionListItemModelImpl.ENTITY_CACHE_ENABLED,
                        PlanSectionDefinitionListItemImpl.class, id,
                        _nullPlanSectionDefinitionListItem);
                }

                closeSession(session);
            }
        }

        return planSectionDefinitionListItem;
    }

    /**
     * Returns all the plan section definition list items where sectionDefinitionId = &#63; and type = &#63;.
     *
     * @param sectionDefinitionId the section definition ID
     * @param type the type
     * @return the matching plan section definition list items
     * @throws SystemException if a system exception occurred
     */
    public List<PlanSectionDefinitionListItem> findByPlanSectionDefinitionIdType(
        long sectionDefinitionId, String type) throws SystemException {
        return findByPlanSectionDefinitionIdType(sectionDefinitionId, type,
            QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
    public List<PlanSectionDefinitionListItem> findByPlanSectionDefinitionIdType(
        long sectionDefinitionId, String type, int start, int end)
        throws SystemException {
        return findByPlanSectionDefinitionIdType(sectionDefinitionId, type,
            start, end, null);
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
    public List<PlanSectionDefinitionListItem> findByPlanSectionDefinitionIdType(
        long sectionDefinitionId, String type, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PLANSECTIONDEFINITIONIDTYPE;
            finderArgs = new Object[] { sectionDefinitionId, type };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PLANSECTIONDEFINITIONIDTYPE;
            finderArgs = new Object[] {
                    sectionDefinitionId, type,
                    
                    start, end, orderByComparator
                };
        }

        List<PlanSectionDefinitionListItem> list = (List<PlanSectionDefinitionListItem>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(4 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(4);
            }

            query.append(_SQL_SELECT_PLANSECTIONDEFINITIONLISTITEM_WHERE);

            query.append(_FINDER_COLUMN_PLANSECTIONDEFINITIONIDTYPE_SECTIONDEFINITIONID_2);

            if (type == null) {
                query.append(_FINDER_COLUMN_PLANSECTIONDEFINITIONIDTYPE_TYPE_1);
            } else {
                if (type.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_PLANSECTIONDEFINITIONIDTYPE_TYPE_3);
                } else {
                    query.append(_FINDER_COLUMN_PLANSECTIONDEFINITIONIDTYPE_TYPE_2);
                }
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            }
            else {
                query.append(PlanSectionDefinitionListItemModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(sectionDefinitionId);

                if (type != null) {
                    qPos.add(type);
                }

                list = (List<PlanSectionDefinitionListItem>) QueryUtil.list(q,
                        getDialect(), start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    FinderCacheUtil.removeResult(finderPath, finderArgs);
                } else {
                    cacheResult(list);

                    FinderCacheUtil.putResult(finderPath, finderArgs, list);
                }

                closeSession(session);
            }
        }

        return list;
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
    public PlanSectionDefinitionListItem findByPlanSectionDefinitionIdType_First(
        long sectionDefinitionId, String type,
        OrderByComparator orderByComparator)
        throws NoSuchPlanSectionDefinitionListItemException, SystemException {
        List<PlanSectionDefinitionListItem> list = findByPlanSectionDefinitionIdType(sectionDefinitionId,
                type, 0, 1, orderByComparator);

        if (list.isEmpty()) {
            StringBundler msg = new StringBundler(6);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("sectionDefinitionId=");
            msg.append(sectionDefinitionId);

            msg.append(", type=");
            msg.append(type);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPlanSectionDefinitionListItemException(msg.toString());
        } else {
            return list.get(0);
        }
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
    public PlanSectionDefinitionListItem findByPlanSectionDefinitionIdType_Last(
        long sectionDefinitionId, String type,
        OrderByComparator orderByComparator)
        throws NoSuchPlanSectionDefinitionListItemException, SystemException {
        int count = countByPlanSectionDefinitionIdType(sectionDefinitionId, type);

        List<PlanSectionDefinitionListItem> list = findByPlanSectionDefinitionIdType(sectionDefinitionId,
                type, count - 1, count, orderByComparator);

        if (list.isEmpty()) {
            StringBundler msg = new StringBundler(6);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("sectionDefinitionId=");
            msg.append(sectionDefinitionId);

            msg.append(", type=");
            msg.append(type);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPlanSectionDefinitionListItemException(msg.toString());
        } else {
            return list.get(0);
        }
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
    public PlanSectionDefinitionListItem[] findByPlanSectionDefinitionIdType_PrevAndNext(
        long id, long sectionDefinitionId, String type,
        OrderByComparator orderByComparator)
        throws NoSuchPlanSectionDefinitionListItemException, SystemException {
        PlanSectionDefinitionListItem planSectionDefinitionListItem = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            PlanSectionDefinitionListItem[] array = new PlanSectionDefinitionListItemImpl[3];

            array[0] = getByPlanSectionDefinitionIdType_PrevAndNext(session,
                    planSectionDefinitionListItem, sectionDefinitionId, type,
                    orderByComparator, true);

            array[1] = planSectionDefinitionListItem;

            array[2] = getByPlanSectionDefinitionIdType_PrevAndNext(session,
                    planSectionDefinitionListItem, sectionDefinitionId, type,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected PlanSectionDefinitionListItem getByPlanSectionDefinitionIdType_PrevAndNext(
        Session session,
        PlanSectionDefinitionListItem planSectionDefinitionListItem,
        long sectionDefinitionId, String type,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_PLANSECTIONDEFINITIONLISTITEM_WHERE);

        query.append(_FINDER_COLUMN_PLANSECTIONDEFINITIONIDTYPE_SECTIONDEFINITIONID_2);

        if (type == null) {
            query.append(_FINDER_COLUMN_PLANSECTIONDEFINITIONIDTYPE_TYPE_1);
        } else {
            if (type.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_PLANSECTIONDEFINITIONIDTYPE_TYPE_3);
            } else {
                query.append(_FINDER_COLUMN_PLANSECTIONDEFINITIONIDTYPE_TYPE_2);
            }
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
        }
        else {
            query.append(PlanSectionDefinitionListItemModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(sectionDefinitionId);

        if (type != null) {
            qPos.add(type);
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(planSectionDefinitionListItem);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<PlanSectionDefinitionListItem> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the plan section definition list items.
     *
     * @return the plan section definition list items
     * @throws SystemException if a system exception occurred
     */
    public List<PlanSectionDefinitionListItem> findAll()
        throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
    public List<PlanSectionDefinitionListItem> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
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
    public List<PlanSectionDefinitionListItem> findAll(int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = new Object[] { start, end, orderByComparator };

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
            finderArgs = FINDER_ARGS_EMPTY;
        } else {
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
            finderArgs = new Object[] { start, end, orderByComparator };
        }

        List<PlanSectionDefinitionListItem> list = (List<PlanSectionDefinitionListItem>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_PLANSECTIONDEFINITIONLISTITEM);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_PLANSECTIONDEFINITIONLISTITEM.concat(PlanSectionDefinitionListItemModelImpl.ORDER_BY_JPQL);
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (orderByComparator == null) {
                    list = (List<PlanSectionDefinitionListItem>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<PlanSectionDefinitionListItem>) QueryUtil.list(q,
                            getDialect(), start, end);
                }
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    FinderCacheUtil.removeResult(finderPath, finderArgs);
                } else {
                    cacheResult(list);

                    FinderCacheUtil.putResult(finderPath, finderArgs, list);
                }

                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Removes all the plan section definition list items where sectionDefinitionId = &#63; and type = &#63; from the database.
     *
     * @param sectionDefinitionId the section definition ID
     * @param type the type
     * @throws SystemException if a system exception occurred
     */
    public void removeByPlanSectionDefinitionIdType(long sectionDefinitionId,
        String type) throws SystemException {
        for (PlanSectionDefinitionListItem planSectionDefinitionListItem : findByPlanSectionDefinitionIdType(
                sectionDefinitionId, type)) {
            remove(planSectionDefinitionListItem);
        }
    }

    /**
     * Removes all the plan section definition list items from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    public void removeAll() throws SystemException {
        for (PlanSectionDefinitionListItem planSectionDefinitionListItem : findAll()) {
            remove(planSectionDefinitionListItem);
        }
    }

    /**
     * Returns the number of plan section definition list items where sectionDefinitionId = &#63; and type = &#63;.
     *
     * @param sectionDefinitionId the section definition ID
     * @param type the type
     * @return the number of matching plan section definition list items
     * @throws SystemException if a system exception occurred
     */
    public int countByPlanSectionDefinitionIdType(long sectionDefinitionId,
        String type) throws SystemException {
        Object[] finderArgs = new Object[] { sectionDefinitionId, type };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_PLANSECTIONDEFINITIONIDTYPE,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_PLANSECTIONDEFINITIONLISTITEM_WHERE);

            query.append(_FINDER_COLUMN_PLANSECTIONDEFINITIONIDTYPE_SECTIONDEFINITIONID_2);

            if (type == null) {
                query.append(_FINDER_COLUMN_PLANSECTIONDEFINITIONIDTYPE_TYPE_1);
            } else {
                if (type.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_PLANSECTIONDEFINITIONIDTYPE_TYPE_3);
                } else {
                    query.append(_FINDER_COLUMN_PLANSECTIONDEFINITIONIDTYPE_TYPE_2);
                }
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(sectionDefinitionId);

                if (type != null) {
                    qPos.add(type);
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PLANSECTIONDEFINITIONIDTYPE,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of plan section definition list items.
     *
     * @return the number of plan section definition list items
     * @throws SystemException if a system exception occurred
     */
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_PLANSECTIONDEFINITIONLISTITEM);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Initializes the plan section definition list item persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.ext.portlet.model.PlanSectionDefinitionListItem")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<PlanSectionDefinitionListItem>> listenersList =
                    new ArrayList<ModelListener<PlanSectionDefinitionListItem>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<PlanSectionDefinitionListItem>) InstanceFactory.newInstance(
                            listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(PlanSectionDefinitionListItemImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
