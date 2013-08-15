package com.ext.portlet.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;


public class PlanSectionDefinitionListItemClp extends BaseModelImpl<PlanSectionDefinitionListItem>
    implements PlanSectionDefinitionListItem {
    private long _id;
    private long _sectionDefinitionId;
    private String _type;
    private long _referencedId;
    private String _data;

    public PlanSectionDefinitionListItemClp() {
    }

    public Class<?> getModelClass() {
        return PlanSectionDefinitionListItem.class;
    }

    public String getModelClassName() {
        return PlanSectionDefinitionListItem.class.getName();
    }

    public long getPrimaryKey() {
        return _id;
    }

    public void setPrimaryKey(long primaryKey) {
        setId(primaryKey);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_id);
    }

    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
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

    @Override
    public PlanSectionDefinitionListItem toEscapedModel() {
        return (PlanSectionDefinitionListItem) Proxy.newProxyInstance(PlanSectionDefinitionListItem.class.getClassLoader(),
            new Class[] { PlanSectionDefinitionListItem.class },
            new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        PlanSectionDefinitionListItemClp clone = new PlanSectionDefinitionListItemClp();

        clone.setId(getId());
        clone.setSectionDefinitionId(getSectionDefinitionId());
        clone.setType(getType());
        clone.setReferencedId(getReferencedId());
        clone.setData(getData());

        return clone;
    }

    public int compareTo(
        PlanSectionDefinitionListItem planSectionDefinitionListItem) {
        int value = 0;

        if (getId() < planSectionDefinitionListItem.getId()) {
            value = -1;
        } else if (getId() > planSectionDefinitionListItem.getId()) {
            value = 1;
        } else {
            value = 0;
        }

        value = value * -1;

        if (value != 0) {
            return value;
        }

        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        PlanSectionDefinitionListItemClp planSectionDefinitionListItem = null;

        try {
            planSectionDefinitionListItem = (PlanSectionDefinitionListItemClp) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long primaryKey = planSectionDefinitionListItem.getPrimaryKey();

        if (getPrimaryKey() == primaryKey) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return (int) getPrimaryKey();
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(11);

        sb.append("{id=");
        sb.append(getId());
        sb.append(", sectionDefinitionId=");
        sb.append(getSectionDefinitionId());
        sb.append(", type=");
        sb.append(getType());
        sb.append(", referencedId=");
        sb.append(getReferencedId());
        sb.append(", data=");
        sb.append(getData());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBundler sb = new StringBundler(19);

        sb.append("<model><model-name>");
        sb.append("com.ext.portlet.model.PlanSectionDefinitionListItem");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>id</column-name><column-value><![CDATA[");
        sb.append(getId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>sectionDefinitionId</column-name><column-value><![CDATA[");
        sb.append(getSectionDefinitionId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>type</column-name><column-value><![CDATA[");
        sb.append(getType());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>referencedId</column-name><column-value><![CDATA[");
        sb.append(getReferencedId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>data</column-name><column-value><![CDATA[");
        sb.append(getData());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
