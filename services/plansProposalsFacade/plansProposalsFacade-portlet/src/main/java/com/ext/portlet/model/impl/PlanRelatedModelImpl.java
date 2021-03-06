package com.ext.portlet.model.impl;

import com.ext.portlet.model.PlanRelated;
import com.ext.portlet.model.PlanRelatedModel;
import com.ext.portlet.model.PlanRelatedSoap;
import com.ext.portlet.service.persistence.PlanRelatedPK;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the PlanRelated service. Represents a row in the &quot;xcolab_PlanRelated&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.ext.portlet.model.PlanRelatedModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link PlanRelatedImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PlanRelatedImpl
 * @see com.ext.portlet.model.PlanRelated
 * @see com.ext.portlet.model.PlanRelatedModel
 * @generated
 */
@JSON(strict = true)
public class PlanRelatedModelImpl extends BaseModelImpl<PlanRelated>
    implements PlanRelatedModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a plan related model instance should use the {@link com.ext.portlet.model.PlanRelated} interface instead.
     */
    public static final String TABLE_NAME = "xcolab_PlanRelated";
    public static final Object[][] TABLE_COLUMNS = {
            { "sectionId", Types.BIGINT },
            { "relatedPlanId", Types.BIGINT }
        };
    public static final String TABLE_SQL_CREATE = "create table xcolab_PlanRelated (sectionId LONG not null,relatedPlanId LONG not null,primary key (sectionId, relatedPlanId))";
    public static final String TABLE_SQL_DROP = "drop table xcolab_PlanRelated";
    public static final String ORDER_BY_JPQL = " ORDER BY planRelated.id.sectionId ASC, planRelated.id.relatedPlanId ASC";
    public static final String ORDER_BY_SQL = " ORDER BY xcolab_PlanRelated.sectionId ASC, xcolab_PlanRelated.relatedPlanId ASC";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.entity.cache.enabled.com.ext.portlet.model.PlanRelated"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.finder.cache.enabled.com.ext.portlet.model.PlanRelated"),
            true);
    public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.column.bitmask.enabled.com.ext.portlet.model.PlanRelated"),
            true);
    public static long RELATEDPLANID_COLUMN_BITMASK = 1L;
    public static long SECTIONID_COLUMN_BITMASK = 2L;
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
                "lock.expiration.time.com.ext.portlet.model.PlanRelated"));
    private static ClassLoader _classLoader = PlanRelated.class.getClassLoader();
    private static Class<?>[] _escapedModelInterfaces = new Class[] {
            PlanRelated.class
        };
    private long _sectionId;
    private long _relatedPlanId;
    private long _originalRelatedPlanId;
    private boolean _setOriginalRelatedPlanId;
    private long _columnBitmask;
    private PlanRelated _escapedModel;

    public PlanRelatedModelImpl() {
    }

    /**
     * Converts the soap model instance into a normal model instance.
     *
     * @param soapModel the soap model instance to convert
     * @return the normal model instance
     */
    public static PlanRelated toModel(PlanRelatedSoap soapModel) {
        if (soapModel == null) {
            return null;
        }

        PlanRelated model = new PlanRelatedImpl();

        model.setSectionId(soapModel.getSectionId());
        model.setRelatedPlanId(soapModel.getRelatedPlanId());

        return model;
    }

    /**
     * Converts the soap model instances into normal model instances.
     *
     * @param soapModels the soap model instances to convert
     * @return the normal model instances
     */
    public static List<PlanRelated> toModels(PlanRelatedSoap[] soapModels) {
        if (soapModels == null) {
            return null;
        }

        List<PlanRelated> models = new ArrayList<PlanRelated>(soapModels.length);

        for (PlanRelatedSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    @Override
    public PlanRelatedPK getPrimaryKey() {
        return new PlanRelatedPK(_sectionId, _relatedPlanId);
    }

    @Override
    public void setPrimaryKey(PlanRelatedPK primaryKey) {
        setSectionId(primaryKey.sectionId);
        setRelatedPlanId(primaryKey.relatedPlanId);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return new PlanRelatedPK(_sectionId, _relatedPlanId);
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey((PlanRelatedPK) primaryKeyObj);
    }

    @Override
    public Class<?> getModelClass() {
        return PlanRelated.class;
    }

    @Override
    public String getModelClassName() {
        return PlanRelated.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("sectionId", getSectionId());
        attributes.put("relatedPlanId", getRelatedPlanId());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long sectionId = (Long) attributes.get("sectionId");

        if (sectionId != null) {
            setSectionId(sectionId);
        }

        Long relatedPlanId = (Long) attributes.get("relatedPlanId");

        if (relatedPlanId != null) {
            setRelatedPlanId(relatedPlanId);
        }
    }

    @JSON
    @Override
    public long getSectionId() {
        return _sectionId;
    }

    @Override
    public void setSectionId(long sectionId) {
        _sectionId = sectionId;
    }

    @JSON
    @Override
    public long getRelatedPlanId() {
        return _relatedPlanId;
    }

    @Override
    public void setRelatedPlanId(long relatedPlanId) {
        _columnBitmask |= RELATEDPLANID_COLUMN_BITMASK;

        if (!_setOriginalRelatedPlanId) {
            _setOriginalRelatedPlanId = true;

            _originalRelatedPlanId = _relatedPlanId;
        }

        _relatedPlanId = relatedPlanId;
    }

    public long getOriginalRelatedPlanId() {
        return _originalRelatedPlanId;
    }

    public long getColumnBitmask() {
        return _columnBitmask;
    }

    @Override
    public PlanRelated toEscapedModel() {
        if (_escapedModel == null) {
            _escapedModel = (PlanRelated) ProxyUtil.newProxyInstance(_classLoader,
                    _escapedModelInterfaces, new AutoEscapeBeanHandler(this));
        }

        return _escapedModel;
    }

    @Override
    public Object clone() {
        PlanRelatedImpl planRelatedImpl = new PlanRelatedImpl();

        planRelatedImpl.setSectionId(getSectionId());
        planRelatedImpl.setRelatedPlanId(getRelatedPlanId());

        planRelatedImpl.resetOriginalValues();

        return planRelatedImpl;
    }

    @Override
    public int compareTo(PlanRelated planRelated) {
        PlanRelatedPK primaryKey = planRelated.getPrimaryKey();

        return getPrimaryKey().compareTo(primaryKey);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof PlanRelated)) {
            return false;
        }

        PlanRelated planRelated = (PlanRelated) obj;

        PlanRelatedPK primaryKey = planRelated.getPrimaryKey();

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
        PlanRelatedModelImpl planRelatedModelImpl = this;

        planRelatedModelImpl._originalRelatedPlanId = planRelatedModelImpl._relatedPlanId;

        planRelatedModelImpl._setOriginalRelatedPlanId = false;

        planRelatedModelImpl._columnBitmask = 0;
    }

    @Override
    public CacheModel<PlanRelated> toCacheModel() {
        PlanRelatedCacheModel planRelatedCacheModel = new PlanRelatedCacheModel();

        planRelatedCacheModel.sectionId = getSectionId();

        planRelatedCacheModel.relatedPlanId = getRelatedPlanId();

        return planRelatedCacheModel;
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(5);

        sb.append("{sectionId=");
        sb.append(getSectionId());
        sb.append(", relatedPlanId=");
        sb.append(getRelatedPlanId());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(10);

        sb.append("<model><model-name>");
        sb.append("com.ext.portlet.model.PlanRelated");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>sectionId</column-name><column-value><![CDATA[");
        sb.append(getSectionId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>relatedPlanId</column-name><column-value><![CDATA[");
        sb.append(getRelatedPlanId());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
