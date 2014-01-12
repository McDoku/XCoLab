package com.ext.portlet.model.impl;

import com.ext.portlet.model.AnalyticsUserEvent;
import com.ext.portlet.model.AnalyticsUserEventModel;
import com.ext.portlet.model.AnalyticsUserEventSoap;
import com.ext.portlet.service.persistence.AnalyticsUserEventPK;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The base model implementation for the AnalyticsUserEvent service. Represents a row in the &quot;xcolab_AnalyticsUserEvent&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.ext.portlet.model.AnalyticsUserEventModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link AnalyticsUserEventImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AnalyticsUserEventImpl
 * @see com.ext.portlet.model.AnalyticsUserEvent
 * @see com.ext.portlet.model.AnalyticsUserEventModel
 * @generated
 */
@JSON(strict = true)
public class AnalyticsUserEventModelImpl extends BaseModelImpl<AnalyticsUserEvent>
    implements AnalyticsUserEventModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a analytics user event model instance should use the {@link com.ext.portlet.model.AnalyticsUserEvent} interface instead.
     */
    public static final String TABLE_NAME = "xcolab_AnalyticsUserEvent";
    public static final Object[][] TABLE_COLUMNS = {
            { "userId", Types.BIGINT },
            { "idString", Types.VARCHAR },
            { "category", Types.VARCHAR },
            { "action", Types.VARCHAR },
            { "label", Types.VARCHAR },
            { "value", Types.INTEGER },
            { "created", Types.TIMESTAMP }
        };
    public static final String TABLE_SQL_CREATE = "create table xcolab_AnalyticsUserEvent (userId LONG not null,idString VARCHAR(75) not null,category VARCHAR(75) null,action VARCHAR(75) null,label VARCHAR(75) null,value INTEGER,created DATE null,primary key (userId, idString))";
    public static final String TABLE_SQL_DROP = "drop table xcolab_AnalyticsUserEvent";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.entity.cache.enabled.com.ext.portlet.model.AnalyticsUserEvent"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.finder.cache.enabled.com.ext.portlet.model.AnalyticsUserEvent"),
            true);
    public static final boolean COLUMN_BITMASK_ENABLED = false;
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
                "lock.expiration.time.com.ext.portlet.model.AnalyticsUserEvent"));
    private static ClassLoader _classLoader = AnalyticsUserEvent.class.getClassLoader();
    private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
            AnalyticsUserEvent.class
        };
    private long _userId;
    private String _userUuid;
    private String _idString;
    private String _category;
    private String _action;
    private String _label;
    private int _value;
    private Date _created;
    private AnalyticsUserEvent _escapedModelProxy;

    public AnalyticsUserEventModelImpl() {
    }

    /**
     * Converts the soap model instance into a normal model instance.
     *
     * @param soapModel the soap model instance to convert
     * @return the normal model instance
     */
    public static AnalyticsUserEvent toModel(AnalyticsUserEventSoap soapModel) {
        AnalyticsUserEvent model = new AnalyticsUserEventImpl();

        model.setUserId(soapModel.getUserId());
        model.setIdString(soapModel.getIdString());
        model.setCategory(soapModel.getCategory());
        model.setAction(soapModel.getAction());
        model.setLabel(soapModel.getLabel());
        model.setValue(soapModel.getValue());
        model.setCreated(soapModel.getCreated());

        return model;
    }

    /**
     * Converts the soap model instances into normal model instances.
     *
     * @param soapModels the soap model instances to convert
     * @return the normal model instances
     */
    public static List<AnalyticsUserEvent> toModels(
        AnalyticsUserEventSoap[] soapModels) {
        List<AnalyticsUserEvent> models = new ArrayList<AnalyticsUserEvent>(soapModels.length);

        for (AnalyticsUserEventSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public AnalyticsUserEventPK getPrimaryKey() {
        return new AnalyticsUserEventPK(_userId, _idString);
    }

    public void setPrimaryKey(AnalyticsUserEventPK primaryKey) {
        setUserId(primaryKey.userId);
        setIdString(primaryKey.idString);
    }

    public Serializable getPrimaryKeyObj() {
        return new AnalyticsUserEventPK(_userId, _idString);
    }

    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey((AnalyticsUserEventPK) primaryKeyObj);
    }

    public Class<?> getModelClass() {
        return AnalyticsUserEvent.class;
    }

    public String getModelClassName() {
        return AnalyticsUserEvent.class.getName();
    }

    @JSON
    public long getUserId() {
        return _userId;
    }

    public void setUserId(long userId) {
        _userId = userId;
    }

    public String getUserUuid() throws SystemException {
        return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
    }

    public void setUserUuid(String userUuid) {
        _userUuid = userUuid;
    }

    @JSON
    public String getIdString() {
        if (_idString == null) {
            return StringPool.BLANK;
        } else {
            return _idString;
        }
    }

    public void setIdString(String idString) {
        _idString = idString;
    }

    @JSON
    public String getCategory() {
        if (_category == null) {
            return StringPool.BLANK;
        } else {
            return _category;
        }
    }

    public void setCategory(String category) {
        _category = category;
    }

    @JSON
    public String getAction() {
        if (_action == null) {
            return StringPool.BLANK;
        } else {
            return _action;
        }
    }

    public void setAction(String action) {
        _action = action;
    }

    @JSON
    public String getLabel() {
        if (_label == null) {
            return StringPool.BLANK;
        } else {
            return _label;
        }
    }

    public void setLabel(String label) {
        _label = label;
    }

    @JSON
    public int getValue() {
        return _value;
    }

    public void setValue(int value) {
        _value = value;
    }

    @JSON
    public Date getCreated() {
        return _created;
    }

    public void setCreated(Date created) {
        _created = created;
    }

    @Override
    public AnalyticsUserEvent toEscapedModel() {
        if (_escapedModelProxy == null) {
            _escapedModelProxy = (AnalyticsUserEvent) ProxyUtil.newProxyInstance(_classLoader,
                    _escapedModelProxyInterfaces,
                    new AutoEscapeBeanHandler(this));
        }

        return _escapedModelProxy;
    }

    @Override
    public Object clone() {
        AnalyticsUserEventImpl analyticsUserEventImpl = new AnalyticsUserEventImpl();

        analyticsUserEventImpl.setUserId(getUserId());
        analyticsUserEventImpl.setIdString(getIdString());
        analyticsUserEventImpl.setCategory(getCategory());
        analyticsUserEventImpl.setAction(getAction());
        analyticsUserEventImpl.setLabel(getLabel());
        analyticsUserEventImpl.setValue(getValue());
        analyticsUserEventImpl.setCreated(getCreated());

        analyticsUserEventImpl.resetOriginalValues();

        return analyticsUserEventImpl;
    }

    public int compareTo(AnalyticsUserEvent analyticsUserEvent) {
        AnalyticsUserEventPK primaryKey = analyticsUserEvent.getPrimaryKey();

        return getPrimaryKey().compareTo(primaryKey);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        AnalyticsUserEvent analyticsUserEvent = null;

        try {
            analyticsUserEvent = (AnalyticsUserEvent) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        AnalyticsUserEventPK primaryKey = analyticsUserEvent.getPrimaryKey();

        if (getPrimaryKey().equals(primaryKey)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return getPrimaryKey().hashCode();
    }

    @Override
    public void resetOriginalValues() {
    }

    @Override
    public CacheModel<AnalyticsUserEvent> toCacheModel() {
        AnalyticsUserEventCacheModel analyticsUserEventCacheModel = new AnalyticsUserEventCacheModel();

        analyticsUserEventCacheModel.userId = getUserId();

        analyticsUserEventCacheModel.idString = getIdString();

        String idString = analyticsUserEventCacheModel.idString;

        if ((idString != null) && (idString.length() == 0)) {
            analyticsUserEventCacheModel.idString = null;
        }

        analyticsUserEventCacheModel.category = getCategory();

        String category = analyticsUserEventCacheModel.category;

        if ((category != null) && (category.length() == 0)) {
            analyticsUserEventCacheModel.category = null;
        }

        analyticsUserEventCacheModel.action = getAction();

        String action = analyticsUserEventCacheModel.action;

        if ((action != null) && (action.length() == 0)) {
            analyticsUserEventCacheModel.action = null;
        }

        analyticsUserEventCacheModel.label = getLabel();

        String label = analyticsUserEventCacheModel.label;

        if ((label != null) && (label.length() == 0)) {
            analyticsUserEventCacheModel.label = null;
        }

        analyticsUserEventCacheModel.value = getValue();

        Date created = getCreated();

        if (created != null) {
            analyticsUserEventCacheModel.created = created.getTime();
        } else {
            analyticsUserEventCacheModel.created = Long.MIN_VALUE;
        }

        return analyticsUserEventCacheModel;
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(15);

        sb.append("{userId=");
        sb.append(getUserId());
        sb.append(", idString=");
        sb.append(getIdString());
        sb.append(", category=");
        sb.append(getCategory());
        sb.append(", action=");
        sb.append(getAction());
        sb.append(", label=");
        sb.append(getLabel());
        sb.append(", value=");
        sb.append(getValue());
        sb.append(", created=");
        sb.append(getCreated());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBundler sb = new StringBundler(25);

        sb.append("<model><model-name>");
        sb.append("com.ext.portlet.model.AnalyticsUserEvent");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>userId</column-name><column-value><![CDATA[");
        sb.append(getUserId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>idString</column-name><column-value><![CDATA[");
        sb.append(getIdString());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>category</column-name><column-value><![CDATA[");
        sb.append(getCategory());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>action</column-name><column-value><![CDATA[");
        sb.append(getAction());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>label</column-name><column-value><![CDATA[");
        sb.append(getLabel());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>value</column-name><column-value><![CDATA[");
        sb.append(getValue());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>created</column-name><column-value><![CDATA[");
        sb.append(getCreated());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}