package com.ext.portlet.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the PlanDescription service. Represents a row in the &quot;xcolab_PlanDescription&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.ext.portlet.model.impl.PlanDescriptionModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.ext.portlet.model.impl.PlanDescriptionImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PlanDescription
 * @see com.ext.portlet.model.impl.PlanDescriptionImpl
 * @see com.ext.portlet.model.impl.PlanDescriptionModelImpl
 * @generated
 */
public interface PlanDescriptionModel extends BaseModel<PlanDescription> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. All methods that expect a plan description model instance should use the {@link PlanDescription} interface instead.
     */

    /**
     * Returns the primary key of this plan description.
     *
     * @return the primary key of this plan description
     */
    public long getPrimaryKey();

    /**
     * Sets the primary key of this plan description.
     *
     * @param primaryKey the primary key of this plan description
     */
    public void setPrimaryKey(long primaryKey);

    /**
     * Returns the ID of this plan description.
     *
     * @return the ID of this plan description
     */
    public long getId();

    /**
     * Sets the ID of this plan description.
     *
     * @param id the ID of this plan description
     */
    public void setId(long id);

    /**
     * Returns the plan ID of this plan description.
     *
     * @return the plan ID of this plan description
     */
    public long getPlanId();

    /**
     * Sets the plan ID of this plan description.
     *
     * @param planId the plan ID of this plan description
     */
    public void setPlanId(long planId);

    /**
     * Returns the name of this plan description.
     *
     * @return the name of this plan description
     */
    @AutoEscape
    public String getName();

    /**
     * Sets the name of this plan description.
     *
     * @param name the name of this plan description
     */
    public void setName(String name);

    /**
     * Returns the description of this plan description.
     *
     * @return the description of this plan description
     */
    @AutoEscape
    public String getDescription();

    /**
     * Sets the description of this plan description.
     *
     * @param description the description of this plan description
     */
    public void setDescription(String description);

    /**
     * Returns the version of this plan description.
     *
     * @return the version of this plan description
     */
    public long getVersion();

    /**
     * Sets the version of this plan description.
     *
     * @param version the version of this plan description
     */
    public void setVersion(long version);

    /**
     * Returns the plan version of this plan description.
     *
     * @return the plan version of this plan description
     */
    public long getPlanVersion();

    /**
     * Sets the plan version of this plan description.
     *
     * @param planVersion the plan version of this plan description
     */
    public void setPlanVersion(long planVersion);

    /**
     * Returns the created of this plan description.
     *
     * @return the created of this plan description
     */
    public Date getCreated();

    /**
     * Sets the created of this plan description.
     *
     * @param created the created of this plan description
     */
    public void setCreated(Date created);

    /**
     * Returns the update author ID of this plan description.
     *
     * @return the update author ID of this plan description
     */
    public long getUpdateAuthorId();

    /**
     * Sets the update author ID of this plan description.
     *
     * @param updateAuthorId the update author ID of this plan description
     */
    public void setUpdateAuthorId(long updateAuthorId);

    /**
     * Returns the image of this plan description.
     *
     * @return the image of this plan description
     */
    public long getImage();

    /**
     * Sets the image of this plan description.
     *
     * @param image the image of this plan description
     */
    public void setImage(long image);

    /**
     * Returns the pitch of this plan description.
     *
     * @return the pitch of this plan description
     */
    @AutoEscape
    public String getPitch();

    /**
     * Sets the pitch of this plan description.
     *
     * @param pitch the pitch of this plan description
     */
    public void setPitch(String pitch);

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

    public int compareTo(PlanDescription planDescription);

    public int hashCode();

    public CacheModel<PlanDescription> toCacheModel();

    public PlanDescription toEscapedModel();

    public String toString();

    public String toXmlString();
}