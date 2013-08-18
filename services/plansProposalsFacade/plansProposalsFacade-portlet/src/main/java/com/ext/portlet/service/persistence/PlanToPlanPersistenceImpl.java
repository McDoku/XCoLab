package com.ext.portlet.service.persistence;

import com.ext.portlet.NoSuchPlanToPlanException;
import com.ext.portlet.model.PlanToPlan;
import com.ext.portlet.model.impl.PlanToPlanImpl;
import com.ext.portlet.model.impl.PlanToPlanModelImpl;
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
import com.ext.portlet.service.persistence.PlanToPlanPersistence;
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
 * The persistence implementation for the plan to plan service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PlanToPlanPersistence
 * @see PlanToPlanUtil
 * @generated
 */
public class PlanToPlanPersistenceImpl extends BasePersistenceImpl<PlanToPlan>
    implements PlanToPlanPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link PlanToPlanUtil} to access the plan to plan persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = PlanToPlanImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_FROMPLANID =
        new FinderPath(PlanToPlanModelImpl.ENTITY_CACHE_ENABLED,
            PlanToPlanModelImpl.FINDER_CACHE_ENABLED, PlanToPlanImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByFromPlanId",
            new String[] {
                Long.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FROMPLANID =
        new FinderPath(PlanToPlanModelImpl.ENTITY_CACHE_ENABLED,
            PlanToPlanModelImpl.FINDER_CACHE_ENABLED, PlanToPlanImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByFromPlanId",
            new String[] { Long.class.getName() },
            PlanToPlanModelImpl.FROMPLANID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_FROMPLANID = new FinderPath(PlanToPlanModelImpl.ENTITY_CACHE_ENABLED,
            PlanToPlanModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByFromPlanId",
            new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TOPLANID = new FinderPath(PlanToPlanModelImpl.ENTITY_CACHE_ENABLED,
            PlanToPlanModelImpl.FINDER_CACHE_ENABLED, PlanToPlanImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByToPlanId",
            new String[] {
                Long.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TOPLANID =
        new FinderPath(PlanToPlanModelImpl.ENTITY_CACHE_ENABLED,
            PlanToPlanModelImpl.FINDER_CACHE_ENABLED, PlanToPlanImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByToPlanId",
            new String[] { Long.class.getName() },
            PlanToPlanModelImpl.TOPLANID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_TOPLANID = new FinderPath(PlanToPlanModelImpl.ENTITY_CACHE_ENABLED,
            PlanToPlanModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByToPlanId",
            new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_FETCH_BY_FROMPLANIDTOPLANID = new FinderPath(PlanToPlanModelImpl.ENTITY_CACHE_ENABLED,
            PlanToPlanModelImpl.FINDER_CACHE_ENABLED, PlanToPlanImpl.class,
            FINDER_CLASS_NAME_ENTITY, "fetchByFromPlanIdToPlanId",
            new String[] { Long.class.getName(), Long.class.getName() },
            PlanToPlanModelImpl.FROMPLANID_COLUMN_BITMASK |
            PlanToPlanModelImpl.TOPLANID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_FROMPLANIDTOPLANID = new FinderPath(PlanToPlanModelImpl.ENTITY_CACHE_ENABLED,
            PlanToPlanModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countByFromPlanIdToPlanId",
            new String[] { Long.class.getName(), Long.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(PlanToPlanModelImpl.ENTITY_CACHE_ENABLED,
            PlanToPlanModelImpl.FINDER_CACHE_ENABLED, PlanToPlanImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(PlanToPlanModelImpl.ENTITY_CACHE_ENABLED,
            PlanToPlanModelImpl.FINDER_CACHE_ENABLED, PlanToPlanImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PlanToPlanModelImpl.ENTITY_CACHE_ENABLED,
            PlanToPlanModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    private static final String _SQL_SELECT_PLANTOPLAN = "SELECT planToPlan FROM PlanToPlan planToPlan";
    private static final String _SQL_SELECT_PLANTOPLAN_WHERE = "SELECT planToPlan FROM PlanToPlan planToPlan WHERE ";
    private static final String _SQL_COUNT_PLANTOPLAN = "SELECT COUNT(planToPlan) FROM PlanToPlan planToPlan";
    private static final String _SQL_COUNT_PLANTOPLAN_WHERE = "SELECT COUNT(planToPlan) FROM PlanToPlan planToPlan WHERE ";
    private static final String _FINDER_COLUMN_FROMPLANID_FROMPLANID_2 = "planToPlan.id.fromPlanId = ?";
    private static final String _FINDER_COLUMN_TOPLANID_TOPLANID_2 = "planToPlan.id.toPlanId = ?";
    private static final String _FINDER_COLUMN_FROMPLANIDTOPLANID_FROMPLANID_2 = "planToPlan.id.fromPlanId = ? AND ";
    private static final String _FINDER_COLUMN_FROMPLANIDTOPLANID_TOPLANID_2 = "planToPlan.id.toPlanId = ?";
    private static final String _ORDER_BY_ENTITY_ALIAS = "planToPlan.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No PlanToPlan exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No PlanToPlan exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(PlanToPlanPersistenceImpl.class);
    private static PlanToPlan _nullPlanToPlan = new PlanToPlanImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<PlanToPlan> toCacheModel() {
                return _nullPlanToPlanCacheModel;
            }
        };

    private static CacheModel<PlanToPlan> _nullPlanToPlanCacheModel = new CacheModel<PlanToPlan>() {
            public PlanToPlan toEntityModel() {
                return _nullPlanToPlan;
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
    @BeanReference(type = PlanToPlanPersistence.class)
    protected PlanToPlanPersistence planToPlanPersistence;
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
     * Caches the plan to plan in the entity cache if it is enabled.
     *
     * @param planToPlan the plan to plan
     */
    public void cacheResult(PlanToPlan planToPlan) {
        EntityCacheUtil.putResult(PlanToPlanModelImpl.ENTITY_CACHE_ENABLED,
            PlanToPlanImpl.class, planToPlan.getPrimaryKey(), planToPlan);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FROMPLANIDTOPLANID,
            new Object[] {
                Long.valueOf(planToPlan.getFromPlanId()),
                Long.valueOf(planToPlan.getToPlanId())
            }, planToPlan);

        planToPlan.resetOriginalValues();
    }

    /**
     * Caches the plan to plans in the entity cache if it is enabled.
     *
     * @param planToPlans the plan to plans
     */
    public void cacheResult(List<PlanToPlan> planToPlans) {
        for (PlanToPlan planToPlan : planToPlans) {
            if (EntityCacheUtil.getResult(
                        PlanToPlanModelImpl.ENTITY_CACHE_ENABLED,
                        PlanToPlanImpl.class, planToPlan.getPrimaryKey()) == null) {
                cacheResult(planToPlan);
            } else {
                planToPlan.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all plan to plans.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(PlanToPlanImpl.class.getName());
        }

        EntityCacheUtil.clearCache(PlanToPlanImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the plan to plan.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(PlanToPlan planToPlan) {
        EntityCacheUtil.removeResult(PlanToPlanModelImpl.ENTITY_CACHE_ENABLED,
            PlanToPlanImpl.class, planToPlan.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        clearUniqueFindersCache(planToPlan);
    }

    @Override
    public void clearCache(List<PlanToPlan> planToPlans) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (PlanToPlan planToPlan : planToPlans) {
            EntityCacheUtil.removeResult(PlanToPlanModelImpl.ENTITY_CACHE_ENABLED,
                PlanToPlanImpl.class, planToPlan.getPrimaryKey());

            clearUniqueFindersCache(planToPlan);
        }
    }

    protected void clearUniqueFindersCache(PlanToPlan planToPlan) {
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_FROMPLANIDTOPLANID,
            new Object[] {
                Long.valueOf(planToPlan.getFromPlanId()),
                Long.valueOf(planToPlan.getToPlanId())
            });
    }

    /**
     * Creates a new plan to plan with the primary key. Does not add the plan to plan to the database.
     *
     * @param planToPlanPK the primary key for the new plan to plan
     * @return the new plan to plan
     */
    public PlanToPlan create(PlanToPlanPK planToPlanPK) {
        PlanToPlan planToPlan = new PlanToPlanImpl();

        planToPlan.setNew(true);
        planToPlan.setPrimaryKey(planToPlanPK);

        return planToPlan;
    }

    /**
     * Removes the plan to plan with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param planToPlanPK the primary key of the plan to plan
     * @return the plan to plan that was removed
     * @throws com.ext.portlet.NoSuchPlanToPlanException if a plan to plan with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public PlanToPlan remove(PlanToPlanPK planToPlanPK)
        throws NoSuchPlanToPlanException, SystemException {
        return remove((Serializable) planToPlanPK);
    }

    /**
     * Removes the plan to plan with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the plan to plan
     * @return the plan to plan that was removed
     * @throws com.ext.portlet.NoSuchPlanToPlanException if a plan to plan with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public PlanToPlan remove(Serializable primaryKey)
        throws NoSuchPlanToPlanException, SystemException {
        Session session = null;

        try {
            session = openSession();

            PlanToPlan planToPlan = (PlanToPlan) session.get(PlanToPlanImpl.class,
                    primaryKey);

            if (planToPlan == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchPlanToPlanException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(planToPlan);
        } catch (NoSuchPlanToPlanException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected PlanToPlan removeImpl(PlanToPlan planToPlan)
        throws SystemException {
        planToPlan = toUnwrappedModel(planToPlan);

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.delete(session, planToPlan);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        clearCache(planToPlan);

        return planToPlan;
    }

    @Override
    public PlanToPlan updateImpl(com.ext.portlet.model.PlanToPlan planToPlan,
        boolean merge) throws SystemException {
        planToPlan = toUnwrappedModel(planToPlan);

        boolean isNew = planToPlan.isNew();

        PlanToPlanModelImpl planToPlanModelImpl = (PlanToPlanModelImpl) planToPlan;

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, planToPlan, merge);

            planToPlan.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !PlanToPlanModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((planToPlanModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FROMPLANID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        Long.valueOf(planToPlanModelImpl.getOriginalFromPlanId())
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FROMPLANID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FROMPLANID,
                    args);

                args = new Object[] {
                        Long.valueOf(planToPlanModelImpl.getFromPlanId())
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FROMPLANID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FROMPLANID,
                    args);
            }

            if ((planToPlanModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TOPLANID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        Long.valueOf(planToPlanModelImpl.getOriginalToPlanId())
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TOPLANID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TOPLANID,
                    args);

                args = new Object[] {
                        Long.valueOf(planToPlanModelImpl.getToPlanId())
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TOPLANID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TOPLANID,
                    args);
            }
        }

        EntityCacheUtil.putResult(PlanToPlanModelImpl.ENTITY_CACHE_ENABLED,
            PlanToPlanImpl.class, planToPlan.getPrimaryKey(), planToPlan);

        if (isNew) {
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FROMPLANIDTOPLANID,
                new Object[] {
                    Long.valueOf(planToPlan.getFromPlanId()),
                    Long.valueOf(planToPlan.getToPlanId())
                }, planToPlan);
        } else {
            if ((planToPlanModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_FROMPLANIDTOPLANID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        Long.valueOf(planToPlanModelImpl.getOriginalFromPlanId()),
                        Long.valueOf(planToPlanModelImpl.getOriginalToPlanId())
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FROMPLANIDTOPLANID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_FROMPLANIDTOPLANID,
                    args);

                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FROMPLANIDTOPLANID,
                    new Object[] {
                        Long.valueOf(planToPlan.getFromPlanId()),
                        Long.valueOf(planToPlan.getToPlanId())
                    }, planToPlan);
            }
        }

        return planToPlan;
    }

    protected PlanToPlan toUnwrappedModel(PlanToPlan planToPlan) {
        if (planToPlan instanceof PlanToPlanImpl) {
            return planToPlan;
        }

        PlanToPlanImpl planToPlanImpl = new PlanToPlanImpl();

        planToPlanImpl.setNew(planToPlan.isNew());
        planToPlanImpl.setPrimaryKey(planToPlan.getPrimaryKey());

        planToPlanImpl.setFromPlanId(planToPlan.getFromPlanId());
        planToPlanImpl.setToPlanId(planToPlan.getToPlanId());
        planToPlanImpl.setReferenceCount(planToPlan.getReferenceCount());

        return planToPlanImpl;
    }

    /**
     * Returns the plan to plan with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the plan to plan
     * @return the plan to plan
     * @throws com.liferay.portal.NoSuchModelException if a plan to plan with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public PlanToPlan findByPrimaryKey(Serializable primaryKey)
        throws NoSuchModelException, SystemException {
        return findByPrimaryKey((PlanToPlanPK) primaryKey);
    }

    /**
     * Returns the plan to plan with the primary key or throws a {@link com.ext.portlet.NoSuchPlanToPlanException} if it could not be found.
     *
     * @param planToPlanPK the primary key of the plan to plan
     * @return the plan to plan
     * @throws com.ext.portlet.NoSuchPlanToPlanException if a plan to plan with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public PlanToPlan findByPrimaryKey(PlanToPlanPK planToPlanPK)
        throws NoSuchPlanToPlanException, SystemException {
        PlanToPlan planToPlan = fetchByPrimaryKey(planToPlanPK);

        if (planToPlan == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + planToPlanPK);
            }

            throw new NoSuchPlanToPlanException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                planToPlanPK);
        }

        return planToPlan;
    }

    /**
     * Returns the plan to plan with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the plan to plan
     * @return the plan to plan, or <code>null</code> if a plan to plan with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public PlanToPlan fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        return fetchByPrimaryKey((PlanToPlanPK) primaryKey);
    }

    /**
     * Returns the plan to plan with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param planToPlanPK the primary key of the plan to plan
     * @return the plan to plan, or <code>null</code> if a plan to plan with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public PlanToPlan fetchByPrimaryKey(PlanToPlanPK planToPlanPK)
        throws SystemException {
        PlanToPlan planToPlan = (PlanToPlan) EntityCacheUtil.getResult(PlanToPlanModelImpl.ENTITY_CACHE_ENABLED,
                PlanToPlanImpl.class, planToPlanPK);

        if (planToPlan == _nullPlanToPlan) {
            return null;
        }

        if (planToPlan == null) {
            Session session = null;

            boolean hasException = false;

            try {
                session = openSession();

                planToPlan = (PlanToPlan) session.get(PlanToPlanImpl.class,
                        planToPlanPK);
            } catch (Exception e) {
                hasException = true;

                throw processException(e);
            } finally {
                if (planToPlan != null) {
                    cacheResult(planToPlan);
                } else if (!hasException) {
                    EntityCacheUtil.putResult(PlanToPlanModelImpl.ENTITY_CACHE_ENABLED,
                        PlanToPlanImpl.class, planToPlanPK, _nullPlanToPlan);
                }

                closeSession(session);
            }
        }

        return planToPlan;
    }

    /**
     * Returns all the plan to plans where fromPlanId = &#63;.
     *
     * @param fromPlanId the from plan ID
     * @return the matching plan to plans
     * @throws SystemException if a system exception occurred
     */
    public List<PlanToPlan> findByFromPlanId(long fromPlanId)
        throws SystemException {
        return findByFromPlanId(fromPlanId, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
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
    public List<PlanToPlan> findByFromPlanId(long fromPlanId, int start, int end)
        throws SystemException {
        return findByFromPlanId(fromPlanId, start, end, null);
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
    public List<PlanToPlan> findByFromPlanId(long fromPlanId, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FROMPLANID;
            finderArgs = new Object[] { fromPlanId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_FROMPLANID;
            finderArgs = new Object[] { fromPlanId, start, end, orderByComparator };
        }

        List<PlanToPlan> list = (List<PlanToPlan>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(3 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(2);
            }

            query.append(_SQL_SELECT_PLANTOPLAN_WHERE);

            query.append(_FINDER_COLUMN_FROMPLANID_FROMPLANID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(fromPlanId);

                list = (List<PlanToPlan>) QueryUtil.list(q, getDialect(),
                        start, end);
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
    public PlanToPlan findByFromPlanId_First(long fromPlanId,
        OrderByComparator orderByComparator)
        throws NoSuchPlanToPlanException, SystemException {
        List<PlanToPlan> list = findByFromPlanId(fromPlanId, 0, 1,
                orderByComparator);

        if (list.isEmpty()) {
            StringBundler msg = new StringBundler(4);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("fromPlanId=");
            msg.append(fromPlanId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPlanToPlanException(msg.toString());
        } else {
            return list.get(0);
        }
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
    public PlanToPlan findByFromPlanId_Last(long fromPlanId,
        OrderByComparator orderByComparator)
        throws NoSuchPlanToPlanException, SystemException {
        int count = countByFromPlanId(fromPlanId);

        List<PlanToPlan> list = findByFromPlanId(fromPlanId, count - 1, count,
                orderByComparator);

        if (list.isEmpty()) {
            StringBundler msg = new StringBundler(4);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("fromPlanId=");
            msg.append(fromPlanId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPlanToPlanException(msg.toString());
        } else {
            return list.get(0);
        }
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
    public PlanToPlan[] findByFromPlanId_PrevAndNext(
        PlanToPlanPK planToPlanPK, long fromPlanId,
        OrderByComparator orderByComparator)
        throws NoSuchPlanToPlanException, SystemException {
        PlanToPlan planToPlan = findByPrimaryKey(planToPlanPK);

        Session session = null;

        try {
            session = openSession();

            PlanToPlan[] array = new PlanToPlanImpl[3];

            array[0] = getByFromPlanId_PrevAndNext(session, planToPlan,
                    fromPlanId, orderByComparator, true);

            array[1] = planToPlan;

            array[2] = getByFromPlanId_PrevAndNext(session, planToPlan,
                    fromPlanId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected PlanToPlan getByFromPlanId_PrevAndNext(Session session,
        PlanToPlan planToPlan, long fromPlanId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_PLANTOPLAN_WHERE);

        query.append(_FINDER_COLUMN_FROMPLANID_FROMPLANID_2);

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

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(fromPlanId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(planToPlan);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<PlanToPlan> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the plan to plans where toPlanId = &#63;.
     *
     * @param toPlanId the to plan ID
     * @return the matching plan to plans
     * @throws SystemException if a system exception occurred
     */
    public List<PlanToPlan> findByToPlanId(long toPlanId)
        throws SystemException {
        return findByToPlanId(toPlanId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
            null);
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
    public List<PlanToPlan> findByToPlanId(long toPlanId, int start, int end)
        throws SystemException {
        return findByToPlanId(toPlanId, start, end, null);
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
    public List<PlanToPlan> findByToPlanId(long toPlanId, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TOPLANID;
            finderArgs = new Object[] { toPlanId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TOPLANID;
            finderArgs = new Object[] { toPlanId, start, end, orderByComparator };
        }

        List<PlanToPlan> list = (List<PlanToPlan>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(3 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(2);
            }

            query.append(_SQL_SELECT_PLANTOPLAN_WHERE);

            query.append(_FINDER_COLUMN_TOPLANID_TOPLANID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(toPlanId);

                list = (List<PlanToPlan>) QueryUtil.list(q, getDialect(),
                        start, end);
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
    public PlanToPlan findByToPlanId_First(long toPlanId,
        OrderByComparator orderByComparator)
        throws NoSuchPlanToPlanException, SystemException {
        List<PlanToPlan> list = findByToPlanId(toPlanId, 0, 1, orderByComparator);

        if (list.isEmpty()) {
            StringBundler msg = new StringBundler(4);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("toPlanId=");
            msg.append(toPlanId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPlanToPlanException(msg.toString());
        } else {
            return list.get(0);
        }
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
    public PlanToPlan findByToPlanId_Last(long toPlanId,
        OrderByComparator orderByComparator)
        throws NoSuchPlanToPlanException, SystemException {
        int count = countByToPlanId(toPlanId);

        List<PlanToPlan> list = findByToPlanId(toPlanId, count - 1, count,
                orderByComparator);

        if (list.isEmpty()) {
            StringBundler msg = new StringBundler(4);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("toPlanId=");
            msg.append(toPlanId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPlanToPlanException(msg.toString());
        } else {
            return list.get(0);
        }
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
    public PlanToPlan[] findByToPlanId_PrevAndNext(PlanToPlanPK planToPlanPK,
        long toPlanId, OrderByComparator orderByComparator)
        throws NoSuchPlanToPlanException, SystemException {
        PlanToPlan planToPlan = findByPrimaryKey(planToPlanPK);

        Session session = null;

        try {
            session = openSession();

            PlanToPlan[] array = new PlanToPlanImpl[3];

            array[0] = getByToPlanId_PrevAndNext(session, planToPlan, toPlanId,
                    orderByComparator, true);

            array[1] = planToPlan;

            array[2] = getByToPlanId_PrevAndNext(session, planToPlan, toPlanId,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected PlanToPlan getByToPlanId_PrevAndNext(Session session,
        PlanToPlan planToPlan, long toPlanId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_PLANTOPLAN_WHERE);

        query.append(_FINDER_COLUMN_TOPLANID_TOPLANID_2);

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

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(toPlanId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(planToPlan);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<PlanToPlan> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
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
    public PlanToPlan findByFromPlanIdToPlanId(long fromPlanId, long toPlanId)
        throws NoSuchPlanToPlanException, SystemException {
        PlanToPlan planToPlan = fetchByFromPlanIdToPlanId(fromPlanId, toPlanId);

        if (planToPlan == null) {
            StringBundler msg = new StringBundler(6);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("fromPlanId=");
            msg.append(fromPlanId);

            msg.append(", toPlanId=");
            msg.append(toPlanId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchPlanToPlanException(msg.toString());
        }

        return planToPlan;
    }

    /**
     * Returns the plan to plan where fromPlanId = &#63; and toPlanId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param fromPlanId the from plan ID
     * @param toPlanId the to plan ID
     * @return the matching plan to plan, or <code>null</code> if a matching plan to plan could not be found
     * @throws SystemException if a system exception occurred
     */
    public PlanToPlan fetchByFromPlanIdToPlanId(long fromPlanId, long toPlanId)
        throws SystemException {
        return fetchByFromPlanIdToPlanId(fromPlanId, toPlanId, true);
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
    public PlanToPlan fetchByFromPlanIdToPlanId(long fromPlanId, long toPlanId,
        boolean retrieveFromCache) throws SystemException {
        Object[] finderArgs = new Object[] { fromPlanId, toPlanId };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_FROMPLANIDTOPLANID,
                    finderArgs, this);
        }

        if (result == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_SELECT_PLANTOPLAN_WHERE);

            query.append(_FINDER_COLUMN_FROMPLANIDTOPLANID_FROMPLANID_2);

            query.append(_FINDER_COLUMN_FROMPLANIDTOPLANID_TOPLANID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(fromPlanId);

                qPos.add(toPlanId);

                List<PlanToPlan> list = q.list();

                result = list;

                PlanToPlan planToPlan = null;

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FROMPLANIDTOPLANID,
                        finderArgs, list);
                } else {
                    planToPlan = list.get(0);

                    cacheResult(planToPlan);

                    if ((planToPlan.getFromPlanId() != fromPlanId) ||
                            (planToPlan.getToPlanId() != toPlanId)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FROMPLANIDTOPLANID,
                            finderArgs, planToPlan);
                    }
                }

                return planToPlan;
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (result == null) {
                    FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_FROMPLANIDTOPLANID,
                        finderArgs);
                }

                closeSession(session);
            }
        } else {
            if (result instanceof List<?>) {
                return null;
            } else {
                return (PlanToPlan) result;
            }
        }
    }

    /**
     * Returns all the plan to plans.
     *
     * @return the plan to plans
     * @throws SystemException if a system exception occurred
     */
    public List<PlanToPlan> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
    public List<PlanToPlan> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
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
    public List<PlanToPlan> findAll(int start, int end,
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

        List<PlanToPlan> list = (List<PlanToPlan>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_PLANTOPLAN);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_PLANTOPLAN;
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (orderByComparator == null) {
                    list = (List<PlanToPlan>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<PlanToPlan>) QueryUtil.list(q, getDialect(),
                            start, end);
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
     * Removes all the plan to plans where fromPlanId = &#63; from the database.
     *
     * @param fromPlanId the from plan ID
     * @throws SystemException if a system exception occurred
     */
    public void removeByFromPlanId(long fromPlanId) throws SystemException {
        for (PlanToPlan planToPlan : findByFromPlanId(fromPlanId)) {
            remove(planToPlan);
        }
    }

    /**
     * Removes all the plan to plans where toPlanId = &#63; from the database.
     *
     * @param toPlanId the to plan ID
     * @throws SystemException if a system exception occurred
     */
    public void removeByToPlanId(long toPlanId) throws SystemException {
        for (PlanToPlan planToPlan : findByToPlanId(toPlanId)) {
            remove(planToPlan);
        }
    }

    /**
     * Removes the plan to plan where fromPlanId = &#63; and toPlanId = &#63; from the database.
     *
     * @param fromPlanId the from plan ID
     * @param toPlanId the to plan ID
     * @throws SystemException if a system exception occurred
     */
    public void removeByFromPlanIdToPlanId(long fromPlanId, long toPlanId)
        throws NoSuchPlanToPlanException, SystemException {
        PlanToPlan planToPlan = findByFromPlanIdToPlanId(fromPlanId, toPlanId);

        remove(planToPlan);
    }

    /**
     * Removes all the plan to plans from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    public void removeAll() throws SystemException {
        for (PlanToPlan planToPlan : findAll()) {
            remove(planToPlan);
        }
    }

    /**
     * Returns the number of plan to plans where fromPlanId = &#63;.
     *
     * @param fromPlanId the from plan ID
     * @return the number of matching plan to plans
     * @throws SystemException if a system exception occurred
     */
    public int countByFromPlanId(long fromPlanId) throws SystemException {
        Object[] finderArgs = new Object[] { fromPlanId };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_FROMPLANID,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_PLANTOPLAN_WHERE);

            query.append(_FINDER_COLUMN_FROMPLANID_FROMPLANID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(fromPlanId);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_FROMPLANID,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of plan to plans where toPlanId = &#63;.
     *
     * @param toPlanId the to plan ID
     * @return the number of matching plan to plans
     * @throws SystemException if a system exception occurred
     */
    public int countByToPlanId(long toPlanId) throws SystemException {
        Object[] finderArgs = new Object[] { toPlanId };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_TOPLANID,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_PLANTOPLAN_WHERE);

            query.append(_FINDER_COLUMN_TOPLANID_TOPLANID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(toPlanId);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TOPLANID,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of plan to plans where fromPlanId = &#63; and toPlanId = &#63;.
     *
     * @param fromPlanId the from plan ID
     * @param toPlanId the to plan ID
     * @return the number of matching plan to plans
     * @throws SystemException if a system exception occurred
     */
    public int countByFromPlanIdToPlanId(long fromPlanId, long toPlanId)
        throws SystemException {
        Object[] finderArgs = new Object[] { fromPlanId, toPlanId };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_FROMPLANIDTOPLANID,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_PLANTOPLAN_WHERE);

            query.append(_FINDER_COLUMN_FROMPLANIDTOPLANID_FROMPLANID_2);

            query.append(_FINDER_COLUMN_FROMPLANIDTOPLANID_TOPLANID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(fromPlanId);

                qPos.add(toPlanId);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_FROMPLANIDTOPLANID,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of plan to plans.
     *
     * @return the number of plan to plans
     * @throws SystemException if a system exception occurred
     */
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_PLANTOPLAN);

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
     * Initializes the plan to plan persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.ext.portlet.model.PlanToPlan")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<PlanToPlan>> listenersList = new ArrayList<ModelListener<PlanToPlan>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<PlanToPlan>) InstanceFactory.newInstance(
                            listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(PlanToPlanImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
