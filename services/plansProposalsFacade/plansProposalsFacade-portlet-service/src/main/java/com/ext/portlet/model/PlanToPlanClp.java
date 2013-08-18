package com.ext.portlet.model;

import com.ext.portlet.service.PlanToPlanLocalServiceUtil;
import com.ext.portlet.service.persistence.PlanToPlanPK;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;


public class PlanToPlanClp extends BaseModelImpl<PlanToPlan>
    implements PlanToPlan {
    private long _fromPlanId;
    private long _toPlanId;
    private int _referenceCount;

    public PlanToPlanClp() {
    }

    public Class<?> getModelClass() {
        return PlanToPlan.class;
    }

    public String getModelClassName() {
        return PlanToPlan.class.getName();
    }

    public PlanToPlanPK getPrimaryKey() {
        return new PlanToPlanPK(_fromPlanId, _toPlanId);
    }

    public void setPrimaryKey(PlanToPlanPK primaryKey) {
        setFromPlanId(primaryKey.fromPlanId);
        setToPlanId(primaryKey.toPlanId);
    }

    public Serializable getPrimaryKeyObj() {
        return new PlanToPlanPK(_fromPlanId, _toPlanId);
    }

    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey((PlanToPlanPK) primaryKeyObj);
    }

    public long getFromPlanId() {
        return _fromPlanId;
    }

    public void setFromPlanId(long fromPlanId) {
        _fromPlanId = fromPlanId;
    }

    public long getToPlanId() {
        return _toPlanId;
    }

    public void setToPlanId(long toPlanId) {
        _toPlanId = toPlanId;
    }

    public int getReferenceCount() {
        return _referenceCount;
    }

    public void setReferenceCount(int referenceCount) {
        _referenceCount = referenceCount;
    }

    public void persist() throws SystemException {
        if (this.isNew()) {
            PlanToPlanLocalServiceUtil.addPlanToPlan(this);
        } else {
            PlanToPlanLocalServiceUtil.updatePlanToPlan(this);
        }
    }

    @Override
    public PlanToPlan toEscapedModel() {
        return (PlanToPlan) Proxy.newProxyInstance(PlanToPlan.class.getClassLoader(),
            new Class[] { PlanToPlan.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        PlanToPlanClp clone = new PlanToPlanClp();

        clone.setFromPlanId(getFromPlanId());
        clone.setToPlanId(getToPlanId());
        clone.setReferenceCount(getReferenceCount());

        return clone;
    }

    public int compareTo(PlanToPlan planToPlan) {
        PlanToPlanPK primaryKey = planToPlan.getPrimaryKey();

        return getPrimaryKey().compareTo(primaryKey);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        PlanToPlanClp planToPlan = null;

        try {
            planToPlan = (PlanToPlanClp) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        PlanToPlanPK primaryKey = planToPlan.getPrimaryKey();

        if (getPrimaryKey().equals(primaryKey)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return getPrimaryKey().hashCode();
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(7);

        sb.append("{fromPlanId=");
        sb.append(getFromPlanId());
        sb.append(", toPlanId=");
        sb.append(getToPlanId());
        sb.append(", referenceCount=");
        sb.append(getReferenceCount());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBundler sb = new StringBundler(13);

        sb.append("<model><model-name>");
        sb.append("com.ext.portlet.model.PlanToPlan");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>fromPlanId</column-name><column-value><![CDATA[");
        sb.append(getFromPlanId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>toPlanId</column-name><column-value><![CDATA[");
        sb.append(getToPlanId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>referenceCount</column-name><column-value><![CDATA[");
        sb.append(getReferenceCount());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
