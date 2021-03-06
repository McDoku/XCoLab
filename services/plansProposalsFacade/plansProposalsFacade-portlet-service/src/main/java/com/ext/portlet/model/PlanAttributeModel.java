package com.ext.portlet.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the PlanAttribute service. Represents a row in the &quot;xcolab_PlanAttribute&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.ext.portlet.model.impl.PlanAttributeModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.ext.portlet.model.impl.PlanAttributeImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PlanAttribute
 * @see com.ext.portlet.model.impl.PlanAttributeImpl
 * @see com.ext.portlet.model.impl.PlanAttributeModelImpl
 * @generated
 */
public interface PlanAttributeModel extends BaseModel<PlanAttribute> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. All methods that expect a plan attribute model instance should use the {@link PlanAttribute} interface instead.
     */

    /**
     * Returns the primary key of this plan attribute.
     *
     * @return the primary key of this plan attribute
     */
    public long getPrimaryKey();

    /**
     * Sets the primary key of this plan attribute.
     *
     * @param primaryKey the primary key of this plan attribute
     */
    public void setPrimaryKey(long primaryKey);

    /**
     * Returns the attribute ID of this plan attribute.
     *
     * @return the attribute ID of this plan attribute
     */
    public long getAttributeId();

    /**
     * Sets the attribute ID of this plan attribute.
     *
     * @param attributeId the attribute ID of this plan attribute
     */
    public void setAttributeId(long attributeId);

    /**
     * Returns the plan ID of this plan attribute.
     *
     * @return the plan ID of this plan attribute
     */
    public long getPlanId();

    /**
     * Sets the plan ID of this plan attribute.
     *
     * @param planId the plan ID of this plan attribute
     */
    public void setPlanId(long planId);

    /**
     * Returns the attribute name of this plan attribute.
     *
     * @return the attribute name of this plan attribute
     */
    @AutoEscape
    public String getAttributeName();

    /**
     * Sets the attribute name of this plan attribute.
     *
     * @param attributeName the attribute name of this plan attribute
     */
    public void setAttributeName(String attributeName);

    /**
     * Returns the attribute value of this plan attribute.
     *
     * @return the attribute value of this plan attribute
     */
    @AutoEscape
    public String getAttributeValue();

    /**
     * Sets the attribute value of this plan attribute.
     *
     * @param attributeValue the attribute value of this plan attribute
     */
    public void setAttributeValue(String attributeValue);

    @Override
    public boolean isNew();

    @Override
    public void setNew(boolean n);

    @Override
    public boolean isCachedModel();

    @Override
    public void setCachedModel(boolean cachedModel);

    @Override
    public boolean isEscapedModel();

    @Override
    public Serializable getPrimaryKeyObj();

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj);

    @Override
    public ExpandoBridge getExpandoBridge();

    @Override
    public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

    @Override
    public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext);

    @Override
    public Object clone();

    @Override
    public int compareTo(PlanAttribute planAttribute);

    @Override
    public int hashCode();

    @Override
    public CacheModel<PlanAttribute> toCacheModel();

    @Override
    public PlanAttribute toEscapedModel();

    @Override
    public PlanAttribute toUnescapedModel();

    @Override
    public String toString();

    @Override
    public String toXmlString();
}
