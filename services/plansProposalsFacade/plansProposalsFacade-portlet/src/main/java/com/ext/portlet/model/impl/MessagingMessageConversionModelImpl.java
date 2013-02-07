package com.ext.portlet.model.impl;

import com.ext.portlet.model.MessagingMessageConversion;
import com.ext.portlet.model.MessagingMessageConversionModel;
import com.ext.portlet.model.MessagingMessageConversionSoap;

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
 * The base model implementation for the MessagingMessageConversion service. Represents a row in the &quot;xcolab_MessagingMessageConversion&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.ext.portlet.model.MessagingMessageConversionModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link MessagingMessageConversionImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MessagingMessageConversionImpl
 * @see com.ext.portlet.model.MessagingMessageConversion
 * @see com.ext.portlet.model.MessagingMessageConversionModel
 * @generated
 */
@JSON(strict = true)
public class MessagingMessageConversionModelImpl extends BaseModelImpl<MessagingMessageConversion>
    implements MessagingMessageConversionModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a messaging message conversion model instance should use the {@link com.ext.portlet.model.MessagingMessageConversion} interface instead.
     */
    public static final String TABLE_NAME = "xcolab_MessagingMessageConversion";
    public static final Object[][] TABLE_COLUMNS = {
            { "conversionId", Types.BIGINT },
            { "conversionTypeId", Types.BIGINT },
            { "messageId", Types.BIGINT },
            { "ipAddress", Types.VARCHAR },
            { "extraData", Types.VARCHAR },
            { "extraData2", Types.VARCHAR },
            { "createDate", Types.TIMESTAMP }
        };
    public static final String TABLE_SQL_CREATE = "create table xcolab_MessagingMessageConversion (conversionId LONG not null primary key,conversionTypeId LONG,messageId LONG,ipAddress VARCHAR(75) null,extraData VARCHAR(2048) null,extraData2 VARCHAR(2048) null,createDate DATE null)";
    public static final String TABLE_SQL_DROP = "drop table xcolab_MessagingMessageConversion";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.entity.cache.enabled.com.ext.portlet.model.MessagingMessageConversion"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.finder.cache.enabled.com.ext.portlet.model.MessagingMessageConversion"),
            true);
    public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.column.bitmask.enabled.com.ext.portlet.model.MessagingMessageConversion"),
            true);
    public static long CONVERSIONTYPEID_COLUMN_BITMASK = 1L;
    public static long MESSAGEID_COLUMN_BITMASK = 2L;
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
                "lock.expiration.time.com.ext.portlet.model.MessagingMessageConversion"));
    private static ClassLoader _classLoader = MessagingMessageConversion.class.getClassLoader();
    private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
            MessagingMessageConversion.class
        };
    private long _conversionId;
    private long _conversionTypeId;
    private long _originalConversionTypeId;
    private boolean _setOriginalConversionTypeId;
    private long _messageId;
    private long _originalMessageId;
    private boolean _setOriginalMessageId;
    private String _ipAddress;
    private String _extraData;
    private String _extraData2;
    private Date _createDate;
    private transient ExpandoBridge _expandoBridge;
    private long _columnBitmask;
    private MessagingMessageConversion _escapedModelProxy;

    public MessagingMessageConversionModelImpl() {
    }

    /**
     * Converts the soap model instance into a normal model instance.
     *
     * @param soapModel the soap model instance to convert
     * @return the normal model instance
     */
    public static MessagingMessageConversion toModel(
        MessagingMessageConversionSoap soapModel) {
        MessagingMessageConversion model = new MessagingMessageConversionImpl();

        model.setConversionId(soapModel.getConversionId());
        model.setConversionTypeId(soapModel.getConversionTypeId());
        model.setMessageId(soapModel.getMessageId());
        model.setIpAddress(soapModel.getIpAddress());
        model.setExtraData(soapModel.getExtraData());
        model.setExtraData2(soapModel.getExtraData2());
        model.setCreateDate(soapModel.getCreateDate());

        return model;
    }

    /**
     * Converts the soap model instances into normal model instances.
     *
     * @param soapModels the soap model instances to convert
     * @return the normal model instances
     */
    public static List<MessagingMessageConversion> toModels(
        MessagingMessageConversionSoap[] soapModels) {
        List<MessagingMessageConversion> models = new ArrayList<MessagingMessageConversion>(soapModels.length);

        for (MessagingMessageConversionSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public long getPrimaryKey() {
        return _conversionId;
    }

    public void setPrimaryKey(long primaryKey) {
        setConversionId(primaryKey);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_conversionId);
    }

    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    public Class<?> getModelClass() {
        return MessagingMessageConversion.class;
    }

    public String getModelClassName() {
        return MessagingMessageConversion.class.getName();
    }

    @JSON
    public long getConversionId() {
        return _conversionId;
    }

    public void setConversionId(long conversionId) {
        _conversionId = conversionId;
    }

    @JSON
    public long getConversionTypeId() {
        return _conversionTypeId;
    }

    public void setConversionTypeId(long conversionTypeId) {
        _columnBitmask |= CONVERSIONTYPEID_COLUMN_BITMASK;

        if (!_setOriginalConversionTypeId) {
            _setOriginalConversionTypeId = true;

            _originalConversionTypeId = _conversionTypeId;
        }

        _conversionTypeId = conversionTypeId;
    }

    public long getOriginalConversionTypeId() {
        return _originalConversionTypeId;
    }

    @JSON
    public long getMessageId() {
        return _messageId;
    }

    public void setMessageId(long messageId) {
        _columnBitmask |= MESSAGEID_COLUMN_BITMASK;

        if (!_setOriginalMessageId) {
            _setOriginalMessageId = true;

            _originalMessageId = _messageId;
        }

        _messageId = messageId;
    }

    public long getOriginalMessageId() {
        return _originalMessageId;
    }

    @JSON
    public String getIpAddress() {
        if (_ipAddress == null) {
            return StringPool.BLANK;
        } else {
            return _ipAddress;
        }
    }

    public void setIpAddress(String ipAddress) {
        _ipAddress = ipAddress;
    }

    @JSON
    public String getExtraData() {
        if (_extraData == null) {
            return StringPool.BLANK;
        } else {
            return _extraData;
        }
    }

    public void setExtraData(String extraData) {
        _extraData = extraData;
    }

    @JSON
    public String getExtraData2() {
        if (_extraData2 == null) {
            return StringPool.BLANK;
        } else {
            return _extraData2;
        }
    }

    public void setExtraData2(String extraData2) {
        _extraData2 = extraData2;
    }

    @JSON
    public Date getCreateDate() {
        return _createDate;
    }

    public void setCreateDate(Date createDate) {
        _createDate = createDate;
    }

    public long getColumnBitmask() {
        return _columnBitmask;
    }

    @Override
    public MessagingMessageConversion toEscapedModel() {
        if (_escapedModelProxy == null) {
            _escapedModelProxy = (MessagingMessageConversion) ProxyUtil.newProxyInstance(_classLoader,
                    _escapedModelProxyInterfaces,
                    new AutoEscapeBeanHandler(this));
        }

        return _escapedModelProxy;
    }

    @Override
    public ExpandoBridge getExpandoBridge() {
        if (_expandoBridge == null) {
            _expandoBridge = ExpandoBridgeFactoryUtil.getExpandoBridge(0,
                    MessagingMessageConversion.class.getName(), getPrimaryKey());
        }

        return _expandoBridge;
    }

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
        getExpandoBridge().setAttributes(serviceContext);
    }

    @Override
    public Object clone() {
        MessagingMessageConversionImpl messagingMessageConversionImpl = new MessagingMessageConversionImpl();

        messagingMessageConversionImpl.setConversionId(getConversionId());
        messagingMessageConversionImpl.setConversionTypeId(getConversionTypeId());
        messagingMessageConversionImpl.setMessageId(getMessageId());
        messagingMessageConversionImpl.setIpAddress(getIpAddress());
        messagingMessageConversionImpl.setExtraData(getExtraData());
        messagingMessageConversionImpl.setExtraData2(getExtraData2());
        messagingMessageConversionImpl.setCreateDate(getCreateDate());

        messagingMessageConversionImpl.resetOriginalValues();

        return messagingMessageConversionImpl;
    }

    public int compareTo(MessagingMessageConversion messagingMessageConversion) {
        long primaryKey = messagingMessageConversion.getPrimaryKey();

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

        MessagingMessageConversion messagingMessageConversion = null;

        try {
            messagingMessageConversion = (MessagingMessageConversion) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long primaryKey = messagingMessageConversion.getPrimaryKey();

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
        MessagingMessageConversionModelImpl messagingMessageConversionModelImpl = this;

        messagingMessageConversionModelImpl._originalConversionTypeId = messagingMessageConversionModelImpl._conversionTypeId;

        messagingMessageConversionModelImpl._setOriginalConversionTypeId = false;

        messagingMessageConversionModelImpl._originalMessageId = messagingMessageConversionModelImpl._messageId;

        messagingMessageConversionModelImpl._setOriginalMessageId = false;

        messagingMessageConversionModelImpl._columnBitmask = 0;
    }

    @Override
    public CacheModel<MessagingMessageConversion> toCacheModel() {
        MessagingMessageConversionCacheModel messagingMessageConversionCacheModel =
            new MessagingMessageConversionCacheModel();

        messagingMessageConversionCacheModel.conversionId = getConversionId();

        messagingMessageConversionCacheModel.conversionTypeId = getConversionTypeId();

        messagingMessageConversionCacheModel.messageId = getMessageId();

        messagingMessageConversionCacheModel.ipAddress = getIpAddress();

        String ipAddress = messagingMessageConversionCacheModel.ipAddress;

        if ((ipAddress != null) && (ipAddress.length() == 0)) {
            messagingMessageConversionCacheModel.ipAddress = null;
        }

        messagingMessageConversionCacheModel.extraData = getExtraData();

        String extraData = messagingMessageConversionCacheModel.extraData;

        if ((extraData != null) && (extraData.length() == 0)) {
            messagingMessageConversionCacheModel.extraData = null;
        }

        messagingMessageConversionCacheModel.extraData2 = getExtraData2();

        String extraData2 = messagingMessageConversionCacheModel.extraData2;

        if ((extraData2 != null) && (extraData2.length() == 0)) {
            messagingMessageConversionCacheModel.extraData2 = null;
        }

        Date createDate = getCreateDate();

        if (createDate != null) {
            messagingMessageConversionCacheModel.createDate = createDate.getTime();
        } else {
            messagingMessageConversionCacheModel.createDate = Long.MIN_VALUE;
        }

        return messagingMessageConversionCacheModel;
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(15);

        sb.append("{conversionId=");
        sb.append(getConversionId());
        sb.append(", conversionTypeId=");
        sb.append(getConversionTypeId());
        sb.append(", messageId=");
        sb.append(getMessageId());
        sb.append(", ipAddress=");
        sb.append(getIpAddress());
        sb.append(", extraData=");
        sb.append(getExtraData());
        sb.append(", extraData2=");
        sb.append(getExtraData2());
        sb.append(", createDate=");
        sb.append(getCreateDate());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBundler sb = new StringBundler(25);

        sb.append("<model><model-name>");
        sb.append("com.ext.portlet.model.MessagingMessageConversion");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>conversionId</column-name><column-value><![CDATA[");
        sb.append(getConversionId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>conversionTypeId</column-name><column-value><![CDATA[");
        sb.append(getConversionTypeId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>messageId</column-name><column-value><![CDATA[");
        sb.append(getMessageId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>ipAddress</column-name><column-value><![CDATA[");
        sb.append(getIpAddress());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>extraData</column-name><column-value><![CDATA[");
        sb.append(getExtraData());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>extraData2</column-name><column-value><![CDATA[");
        sb.append(getExtraData2());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>createDate</column-name><column-value><![CDATA[");
        sb.append(getCreateDate());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
