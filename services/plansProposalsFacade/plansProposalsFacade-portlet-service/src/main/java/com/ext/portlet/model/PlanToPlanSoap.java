package com.ext.portlet.model;

import com.ext.portlet.service.persistence.PlanToPlanPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.ext.portlet.service.http.PlanToPlanServiceSoap}.
 *
 * @author    Brian Wing Shun Chan
 * @see       com.ext.portlet.service.http.PlanToPlanServiceSoap
 * @generated
 */
public class PlanToPlanSoap implements Serializable {
    private long _fromPlanId;
    private long _toPlanId;
    private int _referenceCount;

    public PlanToPlanSoap() {
    }

    public static PlanToPlanSoap toSoapModel(PlanToPlan model) {
        PlanToPlanSoap soapModel = new PlanToPlanSoap();

        soapModel.setFromPlanId(model.getFromPlanId());
        soapModel.setToPlanId(model.getToPlanId());
        soapModel.setReferenceCount(model.getReferenceCount());

        return soapModel;
    }

    public static PlanToPlanSoap[] toSoapModels(PlanToPlan[] models) {
        PlanToPlanSoap[] soapModels = new PlanToPlanSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static PlanToPlanSoap[][] toSoapModels(PlanToPlan[][] models) {
        PlanToPlanSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new PlanToPlanSoap[models.length][models[0].length];
        } else {
            soapModels = new PlanToPlanSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static PlanToPlanSoap[] toSoapModels(List<PlanToPlan> models) {
        List<PlanToPlanSoap> soapModels = new ArrayList<PlanToPlanSoap>(models.size());

        for (PlanToPlan model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new PlanToPlanSoap[soapModels.size()]);
    }

    public PlanToPlanPK getPrimaryKey() {
        return new PlanToPlanPK(_fromPlanId, _toPlanId);
    }

    public void setPrimaryKey(PlanToPlanPK pk) {
        setFromPlanId(pk.fromPlanId);
        setToPlanId(pk.toPlanId);
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
}
