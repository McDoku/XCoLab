package com.ext.portlet.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the MessagingMessage service. Represents a row in the &quot;xcolab_MessagingMessage&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.ext.portlet.model.impl.MessagingMessageModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.ext.portlet.model.impl.MessagingMessageImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MessagingMessage
 * @see com.ext.portlet.model.impl.MessagingMessageImpl
 * @see com.ext.portlet.model.impl.MessagingMessageModelImpl
 * @generated
 */
public interface MessagingMessageModel extends BaseModel<MessagingMessage> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. All methods that expect a messaging message model instance should use the {@link MessagingMessage} interface instead.
     */

    /**
     * Returns the primary key of this messaging message.
     *
     * @return the primary key of this messaging message
     */
    public long getPrimaryKey();

    /**
     * Sets the primary key of this messaging message.
     *
     * @param primaryKey the primary key of this messaging message
     */
    public void setPrimaryKey(long primaryKey);

    /**
     * Returns the message ID of this messaging message.
     *
     * @return the message ID of this messaging message
     */
    public long getMessageId();

    /**
     * Sets the message ID of this messaging message.
     *
     * @param messageId the message ID of this messaging message
     */
    public void setMessageId(long messageId);

    /**
     * Returns the name of this messaging message.
     *
     * @return the name of this messaging message
     */
    @AutoEscape
    public String getName();

    /**
     * Sets the name of this messaging message.
     *
     * @param name the name of this messaging message
     */
    public void setName(String name);

    /**
     * Returns the description of this messaging message.
     *
     * @return the description of this messaging message
     */
    @AutoEscape
    public String getDescription();

    /**
     * Sets the description of this messaging message.
     *
     * @param description the description of this messaging message
     */
    public void setDescription(String description);

    /**
     * Returns the subject of this messaging message.
     *
     * @return the subject of this messaging message
     */
    @AutoEscape
    public String getSubject();

    /**
     * Sets the subject of this messaging message.
     *
     * @param subject the subject of this messaging message
     */
    public void setSubject(String subject);

    /**
     * Returns the body of this messaging message.
     *
     * @return the body of this messaging message
     */
    @AutoEscape
    public String getBody();

    /**
     * Sets the body of this messaging message.
     *
     * @param body the body of this messaging message
     */
    public void setBody(String body);

    /**
     * Returns the reply to of this messaging message.
     *
     * @return the reply to of this messaging message
     */
    @AutoEscape
    public String getReplyTo();

    /**
     * Sets the reply to of this messaging message.
     *
     * @param replyTo the reply to of this messaging message
     */
    public void setReplyTo(String replyTo);

    /**
     * Returns the send to all of this messaging message.
     *
     * @return the send to all of this messaging message
     */
    public boolean getSendToAll();

    /**
     * Returns <code>true</code> if this messaging message is send to all.
     *
     * @return <code>true</code> if this messaging message is send to all; <code>false</code> otherwise
     */
    public boolean isSendToAll();

    /**
     * Sets whether this messaging message is send to all.
     *
     * @param sendToAll the send to all of this messaging message
     */
    public void setSendToAll(boolean sendToAll);

    /**
     * Returns the conversion count of this messaging message.
     *
     * @return the conversion count of this messaging message
     */
    public long getConversionCount();

    /**
     * Sets the conversion count of this messaging message.
     *
     * @param conversionCount the conversion count of this messaging message
     */
    public void setConversionCount(long conversionCount);

    /**
     * Returns the redirect u r l of this messaging message.
     *
     * @return the redirect u r l of this messaging message
     */
    @AutoEscape
    public String getRedirectURL();

    /**
     * Sets the redirect u r l of this messaging message.
     *
     * @param redirectURL the redirect u r l of this messaging message
     */
    public void setRedirectURL(String redirectURL);

    /**
     * Returns the creator ID of this messaging message.
     *
     * @return the creator ID of this messaging message
     */
    public long getCreatorId();

    /**
     * Sets the creator ID of this messaging message.
     *
     * @param creatorId the creator ID of this messaging message
     */
    public void setCreatorId(long creatorId);

    /**
     * Returns the create date of this messaging message.
     *
     * @return the create date of this messaging message
     */
    public Date getCreateDate();

    /**
     * Sets the create date of this messaging message.
     *
     * @param createDate the create date of this messaging message
     */
    public void setCreateDate(Date createDate);

    /**
     * Returns the modified date of this messaging message.
     *
     * @return the modified date of this messaging message
     */
    public Date getModifiedDate();

    /**
     * Sets the modified date of this messaging message.
     *
     * @param modifiedDate the modified date of this messaging message
     */
    public void setModifiedDate(Date modifiedDate);

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
    public int compareTo(MessagingMessage messagingMessage);

    @Override
    public int hashCode();

    @Override
    public CacheModel<MessagingMessage> toCacheModel();

    @Override
    public MessagingMessage toEscapedModel();

    @Override
    public MessagingMessage toUnescapedModel();

    @Override
    public String toString();

    @Override
    public String toXmlString();
}
