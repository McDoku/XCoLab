package com.ext.portlet.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the ModelInputGroup service. Represents a row in the &quot;xcolab_ModelInputGroup&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.ext.portlet.model.impl.ModelInputGroupModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.ext.portlet.model.impl.ModelInputGroupImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ModelInputGroup
 * @see com.ext.portlet.model.impl.ModelInputGroupImpl
 * @see com.ext.portlet.model.impl.ModelInputGroupModelImpl
 * @generated
 */
public interface ModelInputGroupModel extends BaseModel<ModelInputGroup> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. All methods that expect a model input group model instance should use the {@link ModelInputGroup} interface instead.
     */

    /**
     * Returns the primary key of this model input group.
     *
     * @return the primary key of this model input group
     */
    public long getPrimaryKey();

    /**
     * Sets the primary key of this model input group.
     *
     * @param primaryKey the primary key of this model input group
     */
    public void setPrimaryKey(long primaryKey);

    /**
     * Returns the model input group p k of this model input group.
     *
     * @return the model input group p k of this model input group
     */
    public long getModelInputGroupPK();

    /**
     * Sets the model input group p k of this model input group.
     *
     * @param modelInputGroupPK the model input group p k of this model input group
     */
    public void setModelInputGroupPK(long modelInputGroupPK);

    /**
     * Returns the model ID of this model input group.
     *
     * @return the model ID of this model input group
     */
    public long getModelId();

    /**
     * Sets the model ID of this model input group.
     *
     * @param modelId the model ID of this model input group
     */
    public void setModelId(long modelId);

    /**
     * Returns the name and description meta data ID of this model input group.
     *
     * @return the name and description meta data ID of this model input group
     */
    public long getNameAndDescriptionMetaDataId();

    /**
     * Sets the name and description meta data ID of this model input group.
     *
     * @param nameAndDescriptionMetaDataId the name and description meta data ID of this model input group
     */
    public void setNameAndDescriptionMetaDataId(
        long nameAndDescriptionMetaDataId);

    /**
     * Returns the name of this model input group.
     *
     * @return the name of this model input group
     */
    @AutoEscape
    public String getName();

    /**
     * Sets the name of this model input group.
     *
     * @param name the name of this model input group
     */
    public void setName(String name);

    /**
     * Returns the description of this model input group.
     *
     * @return the description of this model input group
     */
    @AutoEscape
    public String getDescription();

    /**
     * Sets the description of this model input group.
     *
     * @param description the description of this model input group
     */
    public void setDescription(String description);

    /**
     * Returns the display item order of this model input group.
     *
     * @return the display item order of this model input group
     */
    public int getDisplayItemOrder();

    /**
     * Sets the display item order of this model input group.
     *
     * @param displayItemOrder the display item order of this model input group
     */
    public void setDisplayItemOrder(int displayItemOrder);

    /**
     * Returns the group type of this model input group.
     *
     * @return the group type of this model input group
     */
    @AutoEscape
    public String getGroupType();

    /**
     * Sets the group type of this model input group.
     *
     * @param groupType the group type of this model input group
     */
    public void setGroupType(String groupType);

    /**
     * Returns the parent group p k of this model input group.
     *
     * @return the parent group p k of this model input group
     */
    public long getParentGroupPK();

    /**
     * Sets the parent group p k of this model input group.
     *
     * @param parentGroupPK the parent group p k of this model input group
     */
    public void setParentGroupPK(long parentGroupPK);

    public boolean isNew();

    public void setNew(boolean n);

    public boolean isCachedModel();

    public void setCachedModel(boolean cachedModel);

    public boolean isEscapedModel();

    public Serializable getPrimaryKeyObj();

    public void setPrimaryKeyObj(Serializable primaryKeyObj);

    public ExpandoBridge getExpandoBridge();

    public void setExpandoBridgeAttributes(ServiceContext serviceContext);

    public Object clone();

    public int compareTo(ModelInputGroup modelInputGroup);

    public int hashCode();

    public CacheModel<ModelInputGroup> toCacheModel();

    public ModelInputGroup toEscapedModel();

    public String toString();

    public String toXmlString();
}