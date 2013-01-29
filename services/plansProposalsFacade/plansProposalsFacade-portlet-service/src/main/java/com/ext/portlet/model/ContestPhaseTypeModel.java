package com.ext.portlet.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the ContestPhaseType service. Represents a row in the &quot;xcolab_ContestPhaseType&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.ext.portlet.model.impl.ContestPhaseTypeModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.ext.portlet.model.impl.ContestPhaseTypeImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ContestPhaseType
 * @see com.ext.portlet.model.impl.ContestPhaseTypeImpl
 * @see com.ext.portlet.model.impl.ContestPhaseTypeModelImpl
 * @generated
 */
public interface ContestPhaseTypeModel extends BaseModel<ContestPhaseType> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. All methods that expect a contest phase type model instance should use the {@link ContestPhaseType} interface instead.
     */

    /**
     * Returns the primary key of this contest phase type.
     *
     * @return the primary key of this contest phase type
     */
    public long getPrimaryKey();

    /**
     * Sets the primary key of this contest phase type.
     *
     * @param primaryKey the primary key of this contest phase type
     */
    public void setPrimaryKey(long primaryKey);

    /**
     * Returns the ID of this contest phase type.
     *
     * @return the ID of this contest phase type
     */
    public long getId();

    /**
     * Sets the ID of this contest phase type.
     *
     * @param id the ID of this contest phase type
     */
    public void setId(long id);

    /**
     * Returns the name of this contest phase type.
     *
     * @return the name of this contest phase type
     */
    @AutoEscape
    public String getName();

    /**
     * Sets the name of this contest phase type.
     *
     * @param name the name of this contest phase type
     */
    public void setName(String name);

    /**
     * Returns the description of this contest phase type.
     *
     * @return the description of this contest phase type
     */
    @AutoEscape
    public String getDescription();

    /**
     * Sets the description of this contest phase type.
     *
     * @param description the description of this contest phase type
     */
    public void setDescription(String description);

    /**
     * Returns the status of this contest phase type.
     *
     * @return the status of this contest phase type
     */
    @AutoEscape
    public String getStatus();

    /**
     * Sets the status of this contest phase type.
     *
     * @param status the status of this contest phase type
     */
    public void setStatus(String status);

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

    public int compareTo(ContestPhaseType contestPhaseType);

    public int hashCode();

    public CacheModel<ContestPhaseType> toCacheModel();

    public ContestPhaseType toEscapedModel();

    public String toString();

    public String toXmlString();
}