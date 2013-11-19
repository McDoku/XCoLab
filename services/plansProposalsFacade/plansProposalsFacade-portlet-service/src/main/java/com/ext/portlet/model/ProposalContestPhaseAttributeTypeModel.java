package com.ext.portlet.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the ProposalContestPhaseAttributeType service. Represents a row in the &quot;xcolab_ProposalContestPhaseAttributeType&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.ext.portlet.model.impl.ProposalContestPhaseAttributeTypeModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.ext.portlet.model.impl.ProposalContestPhaseAttributeTypeImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProposalContestPhaseAttributeType
 * @see com.ext.portlet.model.impl.ProposalContestPhaseAttributeTypeImpl
 * @see com.ext.portlet.model.impl.ProposalContestPhaseAttributeTypeModelImpl
 * @generated
 */
public interface ProposalContestPhaseAttributeTypeModel extends BaseModel<ProposalContestPhaseAttributeType> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. All methods that expect a proposal contest phase attribute type model instance should use the {@link ProposalContestPhaseAttributeType} interface instead.
     */

    /**
     * Returns the primary key of this proposal contest phase attribute type.
     *
     * @return the primary key of this proposal contest phase attribute type
     */
    public String getPrimaryKey();

    /**
     * Sets the primary key of this proposal contest phase attribute type.
     *
     * @param primaryKey the primary key of this proposal contest phase attribute type
     */
    public void setPrimaryKey(String primaryKey);

    /**
     * Returns the name of this proposal contest phase attribute type.
     *
     * @return the name of this proposal contest phase attribute type
     */
    @AutoEscape
    public String getName();

    /**
     * Sets the name of this proposal contest phase attribute type.
     *
     * @param name the name of this proposal contest phase attribute type
     */
    public void setName(String name);

    /**
     * Returns the copy on promote of this proposal contest phase attribute type.
     *
     * @return the copy on promote of this proposal contest phase attribute type
     */
    public boolean getCopyOnPromote();

    /**
     * Returns <code>true</code> if this proposal contest phase attribute type is copy on promote.
     *
     * @return <code>true</code> if this proposal contest phase attribute type is copy on promote; <code>false</code> otherwise
     */
    public boolean isCopyOnPromote();

    /**
     * Sets whether this proposal contest phase attribute type is copy on promote.
     *
     * @param copyOnPromote the copy on promote of this proposal contest phase attribute type
     */
    public void setCopyOnPromote(boolean copyOnPromote);

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

    public int compareTo(
        ProposalContestPhaseAttributeType proposalContestPhaseAttributeType);

    public int hashCode();

    public CacheModel<ProposalContestPhaseAttributeType> toCacheModel();

    public ProposalContestPhaseAttributeType toEscapedModel();

    public String toString();

    public String toXmlString();
}