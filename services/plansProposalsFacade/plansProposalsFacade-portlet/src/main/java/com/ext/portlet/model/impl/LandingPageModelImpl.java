package com.ext.portlet.model.impl;

import com.ext.portlet.model.LandingPage;
import com.ext.portlet.model.LandingPageModel;
import com.ext.portlet.model.LandingPageSoap;

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
 * The base model implementation for the LandingPage service. Represents a row in the &quot;xcolab_LandingPage&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.ext.portlet.model.LandingPageModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link LandingPageImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LandingPageImpl
 * @see com.ext.portlet.model.LandingPage
 * @see com.ext.portlet.model.LandingPageModel
 * @generated
 */
@JSON(strict = true)
public class LandingPageModelImpl extends BaseModelImpl<LandingPage>
    implements LandingPageModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a landing page model instance should use the {@link com.ext.portlet.model.LandingPage} interface instead.
     */
    public static final String TABLE_NAME = "xcolab_LandingPage";
    public static final Object[][] TABLE_COLUMNS = {
            { "id_", Types.BIGINT },
            { "baseUrl", Types.VARCHAR },
            { "targetUrl", Types.VARCHAR },
            { "updated", Types.TIMESTAMP }
        };
    public static final String TABLE_SQL_CREATE = "create table xcolab_LandingPage (id_ LONG not null primary key,baseUrl VARCHAR(1024) null,targetUrl VARCHAR(1024) null,updated DATE null)";
    public static final String TABLE_SQL_DROP = "drop table xcolab_LandingPage";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.entity.cache.enabled.com.ext.portlet.model.LandingPage"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.finder.cache.enabled.com.ext.portlet.model.LandingPage"),
            true);
    public static final boolean COLUMN_BITMASK_ENABLED = false;
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
                "lock.expiration.time.com.ext.portlet.model.LandingPage"));
    private static ClassLoader _classLoader = LandingPage.class.getClassLoader();
    private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
            LandingPage.class
        };
    private long _id;
    private String _baseUrl;
    private String _targetUrl;
    private Date _updated;
    private transient ExpandoBridge _expandoBridge;
    private LandingPage _escapedModelProxy;

    public LandingPageModelImpl() {
    }

    /**
     * Converts the soap model instance into a normal model instance.
     *
     * @param soapModel the soap model instance to convert
     * @return the normal model instance
     */
    public static LandingPage toModel(LandingPageSoap soapModel) {
        LandingPage model = new LandingPageImpl();

        model.setId(soapModel.getId());
        model.setBaseUrl(soapModel.getBaseUrl());
        model.setTargetUrl(soapModel.getTargetUrl());
        model.setUpdated(soapModel.getUpdated());

        return model;
    }

    /**
     * Converts the soap model instances into normal model instances.
     *
     * @param soapModels the soap model instances to convert
     * @return the normal model instances
     */
    public static List<LandingPage> toModels(LandingPageSoap[] soapModels) {
        List<LandingPage> models = new ArrayList<LandingPage>(soapModels.length);

        for (LandingPageSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public long getPrimaryKey() {
        return _id;
    }

    public void setPrimaryKey(long primaryKey) {
        setId(primaryKey);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_id);
    }

    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    public Class<?> getModelClass() {
        return LandingPage.class;
    }

    public String getModelClassName() {
        return LandingPage.class.getName();
    }

    @JSON
    public long getId() {
        return _id;
    }

    public void setId(long id) {
        _id = id;
    }

    @JSON
    public String getBaseUrl() {
        if (_baseUrl == null) {
            return StringPool.BLANK;
        } else {
            return _baseUrl;
        }
    }

    public void setBaseUrl(String baseUrl) {
        _baseUrl = baseUrl;
    }

    @JSON
    public String getTargetUrl() {
        if (_targetUrl == null) {
            return StringPool.BLANK;
        } else {
            return _targetUrl;
        }
    }

    public void setTargetUrl(String targetUrl) {
        _targetUrl = targetUrl;
    }

    @JSON
    public Date getUpdated() {
        return _updated;
    }

    public void setUpdated(Date updated) {
        _updated = updated;
    }

    @Override
    public LandingPage toEscapedModel() {
        if (_escapedModelProxy == null) {
            _escapedModelProxy = (LandingPage) ProxyUtil.newProxyInstance(_classLoader,
                    _escapedModelProxyInterfaces,
                    new AutoEscapeBeanHandler(this));
        }

        return _escapedModelProxy;
    }

    @Override
    public ExpandoBridge getExpandoBridge() {
        if (_expandoBridge == null) {
            _expandoBridge = ExpandoBridgeFactoryUtil.getExpandoBridge(0,
                    LandingPage.class.getName(), getPrimaryKey());
        }

        return _expandoBridge;
    }

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
        getExpandoBridge().setAttributes(serviceContext);
    }

    @Override
    public Object clone() {
        LandingPageImpl landingPageImpl = new LandingPageImpl();

        landingPageImpl.setId(getId());
        landingPageImpl.setBaseUrl(getBaseUrl());
        landingPageImpl.setTargetUrl(getTargetUrl());
        landingPageImpl.setUpdated(getUpdated());

        landingPageImpl.resetOriginalValues();

        return landingPageImpl;
    }

    public int compareTo(LandingPage landingPage) {
        long primaryKey = landingPage.getPrimaryKey();

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

        LandingPage landingPage = null;

        try {
            landingPage = (LandingPage) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long primaryKey = landingPage.getPrimaryKey();

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
    public CacheModel<LandingPage> toCacheModel() {
        LandingPageCacheModel landingPageCacheModel = new LandingPageCacheModel();

        landingPageCacheModel.id = getId();

        landingPageCacheModel.baseUrl = getBaseUrl();

        String baseUrl = landingPageCacheModel.baseUrl;

        if ((baseUrl != null) && (baseUrl.length() == 0)) {
            landingPageCacheModel.baseUrl = null;
        }

        landingPageCacheModel.targetUrl = getTargetUrl();

        String targetUrl = landingPageCacheModel.targetUrl;

        if ((targetUrl != null) && (targetUrl.length() == 0)) {
            landingPageCacheModel.targetUrl = null;
        }

        Date updated = getUpdated();

        if (updated != null) {
            landingPageCacheModel.updated = updated.getTime();
        } else {
            landingPageCacheModel.updated = Long.MIN_VALUE;
        }

        return landingPageCacheModel;
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(9);

        sb.append("{id=");
        sb.append(getId());
        sb.append(", baseUrl=");
        sb.append(getBaseUrl());
        sb.append(", targetUrl=");
        sb.append(getTargetUrl());
        sb.append(", updated=");
        sb.append(getUpdated());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBundler sb = new StringBundler(16);

        sb.append("<model><model-name>");
        sb.append("com.ext.portlet.model.LandingPage");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>id</column-name><column-value><![CDATA[");
        sb.append(getId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>baseUrl</column-name><column-value><![CDATA[");
        sb.append(getBaseUrl());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>targetUrl</column-name><column-value><![CDATA[");
        sb.append(getTargetUrl());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>updated</column-name><column-value><![CDATA[");
        sb.append(getUpdated());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
