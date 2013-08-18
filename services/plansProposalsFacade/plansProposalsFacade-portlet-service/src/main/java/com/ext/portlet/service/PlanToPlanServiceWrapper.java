package com.ext.portlet.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link PlanToPlanService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       PlanToPlanService
 * @generated
 */
public class PlanToPlanServiceWrapper implements PlanToPlanService,
    ServiceWrapper<PlanToPlanService> {
    private PlanToPlanService _planToPlanService;

    public PlanToPlanServiceWrapper(PlanToPlanService planToPlanService) {
        _planToPlanService = planToPlanService;
    }

    /**
     * @deprecated Renamed to {@link #getWrappedService}
     */
    public PlanToPlanService getWrappedPlanToPlanService() {
        return _planToPlanService;
    }

    /**
     * @deprecated Renamed to {@link #setWrappedService}
     */
    public void setWrappedPlanToPlanService(PlanToPlanService planToPlanService) {
        _planToPlanService = planToPlanService;
    }

    public PlanToPlanService getWrappedService() {
        return _planToPlanService;
    }

    public void setWrappedService(PlanToPlanService planToPlanService) {
        _planToPlanService = planToPlanService;
    }
}
