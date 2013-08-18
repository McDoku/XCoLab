package com.ext.portlet.model.impl;

import com.ext.portlet.model.PlanToPlan;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

/**
 * The cache model class for representing PlanToPlan in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see PlanToPlan
 * @generated
 */
public class PlanToPlanCacheModel implements CacheModel<PlanToPlan>,
    Serializable {
    public long fromPlanId;
    public long toPlanId;
    public int referenceCount;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(7);

        sb.append("{fromPlanId=");
        sb.append(fromPlanId);
        sb.append(", toPlanId=");
        sb.append(toPlanId);
        sb.append(", referenceCount=");
        sb.append(referenceCount);
        sb.append("}");

        return sb.toString();
    }

    public PlanToPlan toEntityModel() {
        PlanToPlanImpl planToPlanImpl = new PlanToPlanImpl();

        planToPlanImpl.setFromPlanId(fromPlanId);
        planToPlanImpl.setToPlanId(toPlanId);
        planToPlanImpl.setReferenceCount(referenceCount);

        planToPlanImpl.resetOriginalValues();

        return planToPlanImpl;
    }
}
