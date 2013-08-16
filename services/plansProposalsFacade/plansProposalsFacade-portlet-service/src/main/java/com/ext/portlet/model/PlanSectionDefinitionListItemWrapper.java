package com.ext.portlet.model;

import com.liferay.portal.model.ModelWrapper;

/**
 * <p>
 * This class is a wrapper for {@link PlanSectionDefinitionListItem}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       PlanSectionDefinitionListItem
 * @generated
 */
public class PlanSectionDefinitionListItemWrapper
    implements PlanSectionDefinitionListItem,
        ModelWrapper<PlanSectionDefinitionListItem> {
    private PlanSectionDefinitionListItem _planSectionDefinitionListItem;

    public PlanSectionDefinitionListItemWrapper(
        PlanSectionDefinitionListItem planSectionDefinitionListItem) {
        _planSectionDefinitionListItem = planSectionDefinitionListItem;
    }

    public Class<?> getModelClass() {
        return PlanSectionDefinitionListItem.class;
    }

    public String getModelClassName() {
        return PlanSectionDefinitionListItem.class.getName();
    }

    /**
    * Returns the primary key of this plan section definition list item.
    *
    * @return the primary key of this plan section definition list item
    */
    public long getPrimaryKey() {
        return _planSectionDefinitionListItem.getPrimaryKey();
    }

    /**
    * Sets the primary key of this plan section definition list item.
    *
    * @param primaryKey the primary key of this plan section definition list item
    */
    public void setPrimaryKey(long primaryKey) {
        _planSectionDefinitionListItem.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the ID of this plan section definition list item.
    *
    * @return the ID of this plan section definition list item
    */
    public long getId() {
        return _planSectionDefinitionListItem.getId();
    }

    /**
    * Sets the ID of this plan section definition list item.
    *
    * @param id the ID of this plan section definition list item
    */
    public void setId(long id) {
        _planSectionDefinitionListItem.setId(id);
    }

    /**
    * Returns the section definition ID of this plan section definition list item.
    *
    * @return the section definition ID of this plan section definition list item
    */
    public long getSectionDefinitionId() {
        return _planSectionDefinitionListItem.getSectionDefinitionId();
    }

    /**
    * Sets the section definition ID of this plan section definition list item.
    *
    * @param sectionDefinitionId the section definition ID of this plan section definition list item
    */
    public void setSectionDefinitionId(long sectionDefinitionId) {
        _planSectionDefinitionListItem.setSectionDefinitionId(sectionDefinitionId);
    }

    /**
    * Returns the type of this plan section definition list item.
    *
    * @return the type of this plan section definition list item
    */
    public java.lang.String getType() {
        return _planSectionDefinitionListItem.getType();
    }

    /**
    * Sets the type of this plan section definition list item.
    *
    * @param type the type of this plan section definition list item
    */
    public void setType(java.lang.String type) {
        _planSectionDefinitionListItem.setType(type);
    }

    /**
    * Returns the referenced ID of this plan section definition list item.
    *
    * @return the referenced ID of this plan section definition list item
    */
    public long getReferencedId() {
        return _planSectionDefinitionListItem.getReferencedId();
    }

    /**
    * Sets the referenced ID of this plan section definition list item.
    *
    * @param referencedId the referenced ID of this plan section definition list item
    */
    public void setReferencedId(long referencedId) {
        _planSectionDefinitionListItem.setReferencedId(referencedId);
    }

    /**
    * Returns the data of this plan section definition list item.
    *
    * @return the data of this plan section definition list item
    */
    public java.lang.String getData() {
        return _planSectionDefinitionListItem.getData();
    }

    /**
    * Sets the data of this plan section definition list item.
    *
    * @param data the data of this plan section definition list item
    */
    public void setData(java.lang.String data) {
        _planSectionDefinitionListItem.setData(data);
    }

    public boolean isNew() {
        return _planSectionDefinitionListItem.isNew();
    }

    public void setNew(boolean n) {
        _planSectionDefinitionListItem.setNew(n);
    }

    public boolean isCachedModel() {
        return _planSectionDefinitionListItem.isCachedModel();
    }

    public void setCachedModel(boolean cachedModel) {
        _planSectionDefinitionListItem.setCachedModel(cachedModel);
    }

    public boolean isEscapedModel() {
        return _planSectionDefinitionListItem.isEscapedModel();
    }

    public java.io.Serializable getPrimaryKeyObj() {
        return _planSectionDefinitionListItem.getPrimaryKeyObj();
    }

    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _planSectionDefinitionListItem.setPrimaryKeyObj(primaryKeyObj);
    }

    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _planSectionDefinitionListItem.getExpandoBridge();
    }

    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _planSectionDefinitionListItem.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new PlanSectionDefinitionListItemWrapper((PlanSectionDefinitionListItem) _planSectionDefinitionListItem.clone());
    }

    public int compareTo(
        PlanSectionDefinitionListItem planSectionDefinitionListItem) {
        return _planSectionDefinitionListItem.compareTo(planSectionDefinitionListItem);
    }

    @Override
    public int hashCode() {
        return _planSectionDefinitionListItem.hashCode();
    }

    public com.liferay.portal.model.CacheModel<PlanSectionDefinitionListItem> toCacheModel() {
        return _planSectionDefinitionListItem.toCacheModel();
    }

    public PlanSectionDefinitionListItem toEscapedModel() {
        return new PlanSectionDefinitionListItemWrapper(_planSectionDefinitionListItem.toEscapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _planSectionDefinitionListItem.toString();
    }

    public java.lang.String toXmlString() {
        return _planSectionDefinitionListItem.toXmlString();
    }

    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _planSectionDefinitionListItem.persist();
    }

    /**
     * @deprecated Renamed to {@link #getWrappedModel}
     */
    public PlanSectionDefinitionListItem getWrappedPlanSectionDefinitionListItem() {
        return _planSectionDefinitionListItem;
    }

    public PlanSectionDefinitionListItem getWrappedModel() {
        return _planSectionDefinitionListItem;
    }

    public void resetOriginalValues() {
        _planSectionDefinitionListItem.resetOriginalValues();
    }
}
