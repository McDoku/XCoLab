package com.ext.portlet.model.impl;

import com.ext.portlet.model.PlanSectionDefinitionListItem;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

/**
 * The cache model class for representing PlanSectionDefinitionListItem in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see PlanSectionDefinitionListItem
 * @generated
 */
public class PlanSectionDefinitionListItemCacheModel implements CacheModel<PlanSectionDefinitionListItem>,
    Serializable {
    public long id;
    public long sectionDefinitionId;
    public String type;
    public long referencedId;
    public String data;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(11);

        sb.append("{id=");
        sb.append(id);
        sb.append(", sectionDefinitionId=");
        sb.append(sectionDefinitionId);
        sb.append(", type=");
        sb.append(type);
        sb.append(", referencedId=");
        sb.append(referencedId);
        sb.append(", data=");
        sb.append(data);
        sb.append("}");

        return sb.toString();
    }

    public PlanSectionDefinitionListItem toEntityModel() {
        PlanSectionDefinitionListItemImpl planSectionDefinitionListItemImpl = new PlanSectionDefinitionListItemImpl();

        planSectionDefinitionListItemImpl.setId(id);
        planSectionDefinitionListItemImpl.setSectionDefinitionId(sectionDefinitionId);

        if (type == null) {
            planSectionDefinitionListItemImpl.setType(StringPool.BLANK);
        } else {
            planSectionDefinitionListItemImpl.setType(type);
        }

        planSectionDefinitionListItemImpl.setReferencedId(referencedId);

        if (data == null) {
            planSectionDefinitionListItemImpl.setData(StringPool.BLANK);
        } else {
            planSectionDefinitionListItemImpl.setData(data);
        }

        planSectionDefinitionListItemImpl.resetOriginalValues();

        return planSectionDefinitionListItemImpl;
    }
}
