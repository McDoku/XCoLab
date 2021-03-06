package com.ext.portlet.model.impl;

import com.ext.portlet.model.PlanFan;
import com.ext.portlet.model.PlanFanModel;
import com.ext.portlet.model.PlanFanSoap;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the PlanFan service. Represents a row in the &quot;xcolab_PlanFan&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.ext.portlet.model.PlanFanModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link PlanFanImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PlanFanImpl
 * @see com.ext.portlet.model.PlanFan
 * @see com.ext.portlet.model.PlanFanModel
 * @generated
 */
@JSON(strict = true)
public class PlanFanModelImpl extends BaseModelImpl<PlanFan>
    implements PlanFanModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a plan fan model instance should use the {@link com.ext.portlet.model.PlanFan} interface instead.
     */
    public static final String TABLE_NAME = "xcolab_PlanFan";
    public static final Object[][] TABLE_COLUMNS = {
            { "id_", Types.BIGINT },
            { "userId", Types.BIGINT },
            { "planId", Types.BIGINT },
            { "created", Types.TIMESTAMP },
            { "deleted", Types.TIMESTAMP }
        };
    public static final String TABLE_SQL_CREATE = "create table xcolab_PlanFan (id_ LONG not null primary key,userId LONG,planId LONG,created DATE null,deleted DATE null)";
    public static final String TABLE_SQL_DROP = "drop table xcolab_PlanFan";
    public static final String ORDER_BY_JPQL = " ORDER BY planFan.id ASC";
    public static final String ORDER_BY_SQL = " ORDER BY xcolab_PlanFan.id_ ASC";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.entity.cache.enabled.com.ext.portlet.model.PlanFan"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.finder.cache.enabled.com.ext.portlet.model.PlanFan"),
            true);
    public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.column.bitmask.enabled.com.ext.portlet.model.PlanFan"),
            true);
    public static long PLANID_COLUMN_BITMASK = 1L;
    public static long USERID_COLUMN_BITMASK = 2L;
    public static long ID_COLUMN_BITMASK = 4L;
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
                "lock.expiration.time.com.ext.portlet.model.PlanFan"));
    private static ClassLoader _classLoader = PlanFan.class.getClassLoader();
    private static Class<?>[] _escapedModelInterfaces = new Class[] {
            PlanFan.class
        };
    private long _id;
    private long _userId;
    private String _userUuid;
    private long _originalUserId;
    private boolean _setOriginalUserId;
    private long _planId;
    private long _originalPlanId;
    private boolean _setOriginalPlanId;
    private Date _created;
    private Date _deleted;
    private long _columnBitmask;
    private PlanFan _escapedModel;

    public PlanFanModelImpl() {
    }

    /**
     * Converts the soap model instance into a normal model instance.
     *
     * @param soapModel the soap model instance to convert
     * @return the normal model instance
     */
    public static PlanFan toModel(PlanFanSoap soapModel) {
        if (soapModel == null) {
            return null;
        }

        PlanFan model = new PlanFanImpl();

        model.setId(soapModel.getId());
        model.setUserId(soapModel.getUserId());
        model.setPlanId(soapModel.getPlanId());
        model.setCreated(soapModel.getCreated());
        model.setDeleted(soapModel.getDeleted());

        return model;
    }

    /**
     * Converts the soap model instances into normal model instances.
     *
     * @param soapModels the soap model instances to convert
     * @return the normal model instances
     */
    public static List<PlanFan> toModels(PlanFanSoap[] soapModels) {
        if (soapModels == null) {
            return null;
        }

        List<PlanFan> models = new ArrayList<PlanFan>(soapModels.length);

        for (PlanFanSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    @Override
    public long getPrimaryKey() {
        return _id;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _id;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Class<?> getModelClass() {
        return PlanFan.class;
    }

    @Override
    public String getModelClassName() {
        return PlanFan.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("id", getId());
        attributes.put("userId", getUserId());
        attributes.put("planId", getPlanId());
        attributes.put("created", getCreated());
        attributes.put("deleted", getDeleted());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        Long userId = (Long) attributes.get("userId");

        if (userId != null) {
            setUserId(userId);
        }

        Long planId = (Long) attributes.get("planId");

        if (planId != null) {
            setPlanId(planId);
        }

        Date created = (Date) attributes.get("created");

        if (created != null) {
            setCreated(created);
        }

        Date deleted = (Date) attributes.get("deleted");

        if (deleted != null) {
            setDeleted(deleted);
        }
    }

    @JSON
    @Override
    public long getId() {
        return _id;
    }

    @Override
    public void setId(long id) {
        _columnBitmask = -1L;

        _id = id;
    }

    @JSON
    @Override
    public long getUserId() {
        return _userId;
    }

    @Override
    public void setUserId(long userId) {
        _columnBitmask |= USERID_COLUMN_BITMASK;

        if (!_setOriginalUserId) {
            _setOriginalUserId = true;

            _originalUserId = _userId;
        }

        _userId = userId;
    }

    @Override
    public String getUserUuid() throws SystemException {
        return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
    }

    @Override
    public void setUserUuid(String userUuid) {
        _userUuid = userUuid;
    }

    public long getOriginalUserId() {
        return _originalUserId;
    }

    @JSON
    @Override
    public long getPlanId() {
        return _planId;
    }

    @Override
    public void setPlanId(long planId) {
        _columnBitmask |= PLANID_COLUMN_BITMASK;

        if (!_setOriginalPlanId) {
            _setOriginalPlanId = true;

            _originalPlanId = _planId;
        }

        _planId = planId;
    }

    public long getOriginalPlanId() {
        return _originalPlanId;
    }

    @JSON
    @Override
    public Date getCreated() {
        return _created;
    }

    @Override
    public void setCreated(Date created) {
        _created = created;
    }

    @JSON
    @Override
    public Date getDeleted() {
        return _deleted;
    }

    @Override
    public void setDeleted(Date deleted) {
        _deleted = deleted;
    }

    public long getColumnBitmask() {
        return _columnBitmask;
    }

    @Override
    public ExpandoBridge getExpandoBridge() {
        return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
            PlanFan.class.getName(), getPrimaryKey());
    }

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
        ExpandoBridge expandoBridge = getExpandoBridge();

        expandoBridge.setAttributes(serviceContext);
    }

    @Override
    public PlanFan toEscapedModel() {
        if (_escapedModel == null) {
            _escapedModel = (PlanFan) ProxyUtil.newProxyInstance(_classLoader,
                    _escapedModelInterfaces, new AutoEscapeBeanHandler(this));
        }

        return _escapedModel;
    }

    @Override
    public Object clone() {
        PlanFanImpl planFanImpl = new PlanFanImpl();

        planFanImpl.setId(getId());
        planFanImpl.setUserId(getUserId());
        planFanImpl.setPlanId(getPlanId());
        planFanImpl.setCreated(getCreated());
        planFanImpl.setDeleted(getDeleted());

        planFanImpl.resetOriginalValues();

        return planFanImpl;
    }

    @Override
    public int compareTo(PlanFan planFan) {
        int value = 0;

        if (getId() < planFan.getId()) {
            value = -1;
        } else if (getId() > planFan.getId()) {
            value = 1;
        } else {
            value = 0;
        }

        if (value != 0) {
            return value;
        }

        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof PlanFan)) {
            return false;
        }

        PlanFan planFan = (PlanFan) obj;

        long primaryKey = planFan.getPrimaryKey();

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
        PlanFanModelImpl planFanModelImpl = this;

        planFanModelImpl._originalUserId = planFanModelImpl._userId;

        planFanModelImpl._setOriginalUserId = false;

        planFanModelImpl._originalPlanId = planFanModelImpl._planId;

        planFanModelImpl._setOriginalPlanId = false;

        planFanModelImpl._columnBitmask = 0;
    }

    @Override
    public CacheModel<PlanFan> toCacheModel() {
        PlanFanCacheModel planFanCacheModel = new PlanFanCacheModel();

        planFanCacheModel.id = getId();

        planFanCacheModel.userId = getUserId();

        planFanCacheModel.planId = getPlanId();

        Date created = getCreated();

        if (created != null) {
            planFanCacheModel.created = created.getTime();
        } else {
            planFanCacheModel.created = Long.MIN_VALUE;
        }

        Date deleted = getDeleted();

        if (deleted != null) {
            planFanCacheModel.deleted = deleted.getTime();
        } else {
            planFanCacheModel.deleted = Long.MIN_VALUE;
        }

        return planFanCacheModel;
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(11);

        sb.append("{id=");
        sb.append(getId());
        sb.append(", userId=");
        sb.append(getUserId());
        sb.append(", planId=");
        sb.append(getPlanId());
        sb.append(", created=");
        sb.append(getCreated());
        sb.append(", deleted=");
        sb.append(getDeleted());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(19);

        sb.append("<model><model-name>");
        sb.append("com.ext.portlet.model.PlanFan");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>id</column-name><column-value><![CDATA[");
        sb.append(getId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>userId</column-name><column-value><![CDATA[");
        sb.append(getUserId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>planId</column-name><column-value><![CDATA[");
        sb.append(getPlanId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>created</column-name><column-value><![CDATA[");
        sb.append(getCreated());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>deleted</column-name><column-value><![CDATA[");
        sb.append(getDeleted());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
