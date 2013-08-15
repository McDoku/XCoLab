package com.ext.portlet.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.ext.portlet.service.http.PlanSectionDefinitionListItemServiceSoap}.
 *
 * @author    Brian Wing Shun Chan
 * @see       com.ext.portlet.service.http.PlanSectionDefinitionListItemServiceSoap
 * @generated
 */
public class PlanSectionDefinitionListItemSoap implements Serializable {
    private long _id;
    private long _sectionDefinitionId;
    private String _type;
    private long _referencedId;
    private String _data;

    public PlanSectionDefinitionListItemSoap() {
    }

    public static PlanSectionDefinitionListItemSoap toSoapModel(
        PlanSectionDefinitionListItem model) {
        PlanSectionDefinitionListItemSoap soapModel = new PlanSectionDefinitionListItemSoap();

        soapModel.setId(model.getId());
        soapModel.setSectionDefinitionId(model.getSectionDefinitionId());
        soapModel.setType(model.getType());
        soapModel.setReferencedId(model.getReferencedId());
        soapModel.setData(model.getData());

        return soapModel;
    }

    public static PlanSectionDefinitionListItemSoap[] toSoapModels(
        PlanSectionDefinitionListItem[] models) {
        PlanSectionDefinitionListItemSoap[] soapModels = new PlanSectionDefinitionListItemSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static PlanSectionDefinitionListItemSoap[][] toSoapModels(
        PlanSectionDefinitionListItem[][] models) {
        PlanSectionDefinitionListItemSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new PlanSectionDefinitionListItemSoap[models.length][models[0].length];
        } else {
            soapModels = new PlanSectionDefinitionListItemSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static PlanSectionDefinitionListItemSoap[] toSoapModels(
        List<PlanSectionDefinitionListItem> models) {
        List<PlanSectionDefinitionListItemSoap> soapModels = new ArrayList<PlanSectionDefinitionListItemSoap>(models.size());

        for (PlanSectionDefinitionListItem model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new PlanSectionDefinitionListItemSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _id;
    }

    public void setPrimaryKey(long pk) {
        setId(pk);
    }

    public long getId() {
        return _id;
    }

    public void setId(long id) {
        _id = id;
    }

    public long getSectionDefinitionId() {
        return _sectionDefinitionId;
    }

    public void setSectionDefinitionId(long sectionDefinitionId) {
        _sectionDefinitionId = sectionDefinitionId;
    }

    public String getType() {
        return _type;
    }

    public void setType(String type) {
        _type = type;
    }

    public long getReferencedId() {
        return _referencedId;
    }

    public void setReferencedId(long referencedId) {
        _referencedId = referencedId;
    }

    public String getData() {
        return _data;
    }

    public void setData(String data) {
        _data = data;
    }
}
