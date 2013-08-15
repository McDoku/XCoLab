package com.ext.portlet.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link PlanSectionDefinitionListItemService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       PlanSectionDefinitionListItemService
 * @generated
 */
public class PlanSectionDefinitionListItemServiceWrapper
    implements PlanSectionDefinitionListItemService,
        ServiceWrapper<PlanSectionDefinitionListItemService> {
    private PlanSectionDefinitionListItemService _planSectionDefinitionListItemService;

    public PlanSectionDefinitionListItemServiceWrapper(
        PlanSectionDefinitionListItemService planSectionDefinitionListItemService) {
        _planSectionDefinitionListItemService = planSectionDefinitionListItemService;
    }

    /**
     * @deprecated Renamed to {@link #getWrappedService}
     */
    public PlanSectionDefinitionListItemService getWrappedPlanSectionDefinitionListItemService() {
        return _planSectionDefinitionListItemService;
    }

    /**
     * @deprecated Renamed to {@link #setWrappedService}
     */
    public void setWrappedPlanSectionDefinitionListItemService(
        PlanSectionDefinitionListItemService planSectionDefinitionListItemService) {
        _planSectionDefinitionListItemService = planSectionDefinitionListItemService;
    }

    public PlanSectionDefinitionListItemService getWrappedService() {
        return _planSectionDefinitionListItemService;
    }

    public void setWrappedService(
        PlanSectionDefinitionListItemService planSectionDefinitionListItemService) {
        _planSectionDefinitionListItemService = planSectionDefinitionListItemService;
    }
}
