package com.ext.portlet.model.impl;

import com.ext.portlet.model.MessagingRedirectLink;
import com.ext.portlet.model.MessagingRedirectLinkModel;
import com.ext.portlet.model.MessagingRedirectLinkSoap;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The base model implementation for the MessagingRedirectLink service. Represents a row in the &quot;xcolab_MessagingRedirectLink&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.ext.portlet.model.MessagingRedirectLinkModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link MessagingRedirectLinkImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MessagingRedirectLinkImpl
 * @see com.ext.portlet.model.MessagingRedirectLink
 * @see com.ext.portlet.model.MessagingRedirectLinkModel
 * @generated
 */
@JSON(strict = true)
public class MessagingRedirectLinkModelImpl extends BaseModelImpl<MessagingRedirectLink>
    implements MessagingRedirectLinkModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a messaging redirect link model instance should use the {@link com.ext.portlet.model.MessagingRedirectLink} interface instead.
     */
    public static final String TABLE_NAME = "xcolab_MessagingRedirectLink";
    public static final Object[][] TABLE_COLUMNS = {
            { "redirectId", Types.BIGINT },
            { "link", Types.VARCHAR },
            { "messageId", Types.BIGINT },
            { "createDate", Types.TIMESTAMP }
        };
    public static final String TABLE_SQL_CREATE = "create table xcolab_MessagingRedirectLink (redirectId LONG not null primary key,link VARCHAR(1024) null,messageId LONG,createDate DATE null)";
    public static final String TABLE_SQL_DROP = "drop table xcolab_MessagingRedirectLink";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.entity.cache.enabled.com.ext.portlet.model.MessagingRedirectLink"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.finder.cache.enabled.com.ext.portlet.model.MessagingRedirectLink"),
            true);
    public static final boolean COLUMN_BITMASK_ENABLED = false;
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
                "lock.expiration.time.com.ext.portlet.model.MessagingRedirectLink"));
    private static ClassLoader _classLoader = MessagingRedirectLink.class.getClassLoader();
    private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
            MessagingRedirectLink.class
        };
    private long _redirectId;
    private String _link;
    private long _messageId;
    private Date _createDate;
    private transient ExpandoBridge _expandoBridge;
    private MessagingRedirectLink _escapedModelProxy;

    public MessagingRedirectLinkModelImpl() {
    }

    /**
     * Converts the soap model instance into a normal model instance.
     *
     * @param soapModel the soap model instance to convert
     * @return the normal model instance
     */
    public static MessagingRedirectLink toModel(
        MessagingRedirectLinkSoap soapModel) {
        MessagingRedirectLink model = new MessagingRedirectLinkImpl();

        model.setRedirectId(soapModel.getRedirectId());
        model.setLink(soapModel.getLink());
        model.setMessageId(soapModel.getMessageId());
        model.setCreateDate(soapModel.getCreateDate());

        return model;
    }

    /**
     * Converts the soap model instances into normal model instances.
     *
     * @param soapModels the soap model instances to convert
     * @return the normal model instances
     */
    public static List<MessagingRedirectLink> toModels(
        MessagingRedirectLinkSoap[] soapModels) {
        List<MessagingRedirectLink> models = new ArrayList<MessagingRedirectLink>(soapModels.length);

        for (MessagingRedirectLinkSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public long getPrimaryKey() {
        return _redirectId;
    }

    public void setPrimaryKey(long primaryKey) {
        setRedirectId(primaryKey);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_redirectId);
    }

    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    public Class<?> getModelClass() {
        return MessagingRedirectLink.class;
    }

    public String getModelClassName() {
        return MessagingRedirectLink.class.getName();
    }

    @JSON
    public long getRedirectId() {
        return _redirectId;
    }

    public void setRedirectId(long redirectId) {
        _redirectId = redirectId;
    }

    @JSON
    public String getLink() {
        if (_link == null) {
            return StringPool.BLANK;
        } else {
            return _link;
        }
    }

    public void setLink(String link) {
        _link = link;
    }

    @JSON
    public long getMessageId() {
        return _messageId;
    }

    public void setMessageId(long messageId) {
        _messageId = messageId;
    }

    @JSON
    public Date getCreateDate() {
        return _createDate;
    }

    public void setCreateDate(Date createDate) {
        _createDate = createDate;
    }

    @Override
    public MessagingRedirectLink toEscapedModel() {
        if (_escapedModelProxy == null) {
            _escapedModelProxy = (MessagingRedirectLink) ProxyUtil.newProxyInstance(_classLoader,
                    _escapedModelProxyInterfaces,
                    new AutoEscapeBeanHandler(this));
        }

        return _escapedModelProxy;
    }

    @Override
    public ExpandoBridge getExpandoBridge() {
        if (_expandoBridge == null) {
            _expandoBridge = ExpandoBridgeFactoryUtil.getExpandoBridge(0,
                    MessagingRedirectLink.class.getName(), getPrimaryKey());
        }

        return _expandoBridge;
    }

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
        getExpandoBridge().setAttributes(serviceContext);
    }

    @Override
    public Object clone() {
        MessagingRedirectLinkImpl messagingRedirectLinkImpl = new MessagingRedirectLinkImpl();

        messagingRedirectLinkImpl.setRedirectId(getRedirectId());
        messagingRedirectLinkImpl.setLink(getLink());
        messagingRedirectLinkImpl.setMessageId(getMessageId());
        messagingRedirectLinkImpl.setCreateDate(getCreateDate());

        messagingRedirectLinkImpl.resetOriginalValues();

        return messagingRedirectLinkImpl;
    }

    public int compareTo(MessagingRedirectLink messagingRedirectLink) {
        long primaryKey = messagingRedirectLink.getPrimaryKey();

        if (getPrimaryKey() < primaryKey) {
            return -1;
        } else if (getPrimaryKey() > primaryKey) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        MessagingRedirectLink messagingRedirectLink = null;

        try {
            messagingRedirectLink = (MessagingRedirectLink) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long primaryKey = messagingRedirectLink.getPrimaryKey();

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
    public void resetOriginalValues() {
    }

    @Override
    public CacheModel<MessagingRedirectLink> toCacheModel() {
        MessagingRedirectLinkCacheModel messagingRedirectLinkCacheModel = new MessagingRedirectLinkCacheModel();

        messagingRedirectLinkCacheModel.redirectId = getRedirectId();

        messagingRedirectLinkCacheModel.link = getLink();

        String link = messagingRedirectLinkCacheModel.link;

        if ((link != null) && (link.length() == 0)) {
            messagingRedirectLinkCacheModel.link = null;
        }

        messagingRedirectLinkCacheModel.messageId = getMessageId();

        Date createDate = getCreateDate();

        if (createDate != null) {
            messagingRedirectLinkCacheModel.createDate = createDate.getTime();
        } else {
            messagingRedirectLinkCacheModel.createDate = Long.MIN_VALUE;
        }

        return messagingRedirectLinkCacheModel;
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(9);

        sb.append("{redirectId=");
        sb.append(getRedirectId());
        sb.append(", link=");
        sb.append(getLink());
        sb.append(", messageId=");
        sb.append(getMessageId());
        sb.append(", createDate=");
        sb.append(getCreateDate());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBundler sb = new StringBundler(16);

        sb.append("<model><model-name>");
        sb.append("com.ext.portlet.model.MessagingRedirectLink");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>redirectId</column-name><column-value><![CDATA[");
        sb.append(getRedirectId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>link</column-name><column-value><![CDATA[");
        sb.append(getLink());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>messageId</column-name><column-value><![CDATA[");
        sb.append(getMessageId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>createDate</column-name><column-value><![CDATA[");
        sb.append(getCreateDate());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
