package com.ext.portlet.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the PlanTypeColumn service. Represents a row in the &quot;xcolab_PlanTypeColumn&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.ext.portlet.model.impl.PlanTypeColumnModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.ext.portlet.model.impl.PlanTypeColumnImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PlanTypeColumn
 * @see com.ext.portlet.model.impl.PlanTypeColumnImpl
 * @see com.ext.portlet.model.impl.PlanTypeColumnModelImpl
 * @generated
 */
public interface PlanTypeColumnModel extends BaseModel<PlanTypeColumn> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. All methods that expect a plan type column model instance should use the {@link PlanTypeColumn} interface instead.
     */

    /**
     * Returns the primary key of this plan type column.
     *
     * @return the primary key of this plan type column
     */
    public long getPrimaryKey();

    /**
     * Sets the primary key of this plan type column.
     *
     * @param primaryKey the primary key of this plan type column
     */
    public void setPrimaryKey(long primaryKey);

    /**
     * Returns the plan type column ID of this plan type column.
     *
     * @return the plan type column ID of this plan type column
     */
    public long getPlanTypeColumnId();

    /**
     * Sets the plan type column ID of this plan type column.
     *
     * @param planTypeColumnId the plan type column ID of this plan type column
     */
    public void setPlanTypeColumnId(long planTypeColumnId);

    /**
     * Returns the plan type ID of this plan type column.
     *
     * @return the plan type ID of this plan type column
     */
    public long getPlanTypeId();

    /**
     * Sets the plan type ID of this plan type column.
     *
     * @param planTypeId the plan type ID of this plan type column
     */
    public void setPlanTypeId(long planTypeId);

    /**
     * Returns the weight of this plan type column.
     *
     * @return the weight of this plan type column
     */
    public int getWeight();

    /**
     * Sets the weight of this plan type column.
     *
     * @param weight the weight of this plan type column
     */
    public void setWeight(int weight);

    /**
     * Returns the column name of this plan type column.
     *
     * @return the column name of this plan type column
     */
    @AutoEscape
    public String getColumnName();

    /**
     * Sets the column name of this plan type column.
     *
     * @param columnName the column name of this plan type column
     */
    public void setColumnName(String columnName);

    /**
     * Returns the visible by default of this plan type column.
     *
     * @return the visible by default of this plan type column
     */
    public boolean getVisibleByDefault();

    /**
     * Returns <code>true</code> if this plan type column is visible by default.
     *
     * @return <code>true</code> if this plan type column is visible by default; <code>false</code> otherwise
     */
    public boolean isVisibleByDefault();

    /**
     * Sets whether this plan type column is visible by default.
     *
     * @param visibleByDefault the visible by default of this plan type column
     */
    public void setVisibleByDefault(boolean visibleByDefault);

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
    public int compareTo(PlanTypeColumn planTypeColumn);

    @Override
    public int hashCode();

    @Override
    public CacheModel<PlanTypeColumn> toCacheModel();

    @Override
    public PlanTypeColumn toEscapedModel();

    @Override
    public PlanTypeColumn toUnescapedModel();

    @Override
    public String toString();

    @Override
    public String toXmlString();
}
