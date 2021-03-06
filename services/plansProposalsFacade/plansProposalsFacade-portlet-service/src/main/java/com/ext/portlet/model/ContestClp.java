package com.ext.portlet.model;

import com.ext.portlet.service.ClpSerializer;
import com.ext.portlet.service.ContestLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class ContestClp extends BaseModelImpl<Contest> implements Contest {
    private long _ContestPK;
    private String _ContestName;
    private String _ContestShortName;
    private String _ContestDescription;
    private String _ContestModelDescription;
    private String _ContestPositionsDescription;
    private String _defaultPlanDescription;
    private long _PlanTypeId;
    private Date _created;
    private Date _updated;
    private long _authorId;
    private boolean _contestActive;
    private long _planTemplateId;
    private long _focusAreaId;
    private long _contestLogoId;
    private boolean _featured;
    private boolean _plansOpenByDefault;
    private long _sponsorLogoId;
    private String _sponsorText;
    private String _sponsorLink;
    private int _flag;
    private String _flagText;
    private String _flagTooltip;
    private long _groupId;
    private long _discussionGroupId;
    private int _weight;
    private String _resourcesUrl;
    private boolean _contestPrivate;
    private boolean _usePermissions;
    private BaseModel<?> _contestRemoteModel;

    public ContestClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return Contest.class;
    }

    @Override
    public String getModelClassName() {
        return Contest.class.getName();
    }

    @Override
    public long getPrimaryKey() {
        return _ContestPK;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setContestPK(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _ContestPK;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("ContestPK", getContestPK());
        attributes.put("ContestName", getContestName());
        attributes.put("ContestShortName", getContestShortName());
        attributes.put("ContestDescription", getContestDescription());
        attributes.put("ContestModelDescription", getContestModelDescription());
        attributes.put("ContestPositionsDescription",
            getContestPositionsDescription());
        attributes.put("defaultPlanDescription", getDefaultPlanDescription());
        attributes.put("PlanTypeId", getPlanTypeId());
        attributes.put("created", getCreated());
        attributes.put("updated", getUpdated());
        attributes.put("authorId", getAuthorId());
        attributes.put("contestActive", getContestActive());
        attributes.put("planTemplateId", getPlanTemplateId());
        attributes.put("focusAreaId", getFocusAreaId());
        attributes.put("contestLogoId", getContestLogoId());
        attributes.put("featured", getFeatured());
        attributes.put("plansOpenByDefault", getPlansOpenByDefault());
        attributes.put("sponsorLogoId", getSponsorLogoId());
        attributes.put("sponsorText", getSponsorText());
        attributes.put("sponsorLink", getSponsorLink());
        attributes.put("flag", getFlag());
        attributes.put("flagText", getFlagText());
        attributes.put("flagTooltip", getFlagTooltip());
        attributes.put("groupId", getGroupId());
        attributes.put("discussionGroupId", getDiscussionGroupId());
        attributes.put("weight", getWeight());
        attributes.put("resourcesUrl", getResourcesUrl());
        attributes.put("contestPrivate", getContestPrivate());
        attributes.put("usePermissions", getUsePermissions());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long ContestPK = (Long) attributes.get("ContestPK");

        if (ContestPK != null) {
            setContestPK(ContestPK);
        }

        String ContestName = (String) attributes.get("ContestName");

        if (ContestName != null) {
            setContestName(ContestName);
        }

        String ContestShortName = (String) attributes.get("ContestShortName");

        if (ContestShortName != null) {
            setContestShortName(ContestShortName);
        }

        String ContestDescription = (String) attributes.get(
                "ContestDescription");

        if (ContestDescription != null) {
            setContestDescription(ContestDescription);
        }

        String ContestModelDescription = (String) attributes.get(
                "ContestModelDescription");

        if (ContestModelDescription != null) {
            setContestModelDescription(ContestModelDescription);
        }

        String ContestPositionsDescription = (String) attributes.get(
                "ContestPositionsDescription");

        if (ContestPositionsDescription != null) {
            setContestPositionsDescription(ContestPositionsDescription);
        }

        String defaultPlanDescription = (String) attributes.get(
                "defaultPlanDescription");

        if (defaultPlanDescription != null) {
            setDefaultPlanDescription(defaultPlanDescription);
        }

        Long PlanTypeId = (Long) attributes.get("PlanTypeId");

        if (PlanTypeId != null) {
            setPlanTypeId(PlanTypeId);
        }

        Date created = (Date) attributes.get("created");

        if (created != null) {
            setCreated(created);
        }

        Date updated = (Date) attributes.get("updated");

        if (updated != null) {
            setUpdated(updated);
        }

        Long authorId = (Long) attributes.get("authorId");

        if (authorId != null) {
            setAuthorId(authorId);
        }

        Boolean contestActive = (Boolean) attributes.get("contestActive");

        if (contestActive != null) {
            setContestActive(contestActive);
        }

        Long planTemplateId = (Long) attributes.get("planTemplateId");

        if (planTemplateId != null) {
            setPlanTemplateId(planTemplateId);
        }

        Long focusAreaId = (Long) attributes.get("focusAreaId");

        if (focusAreaId != null) {
            setFocusAreaId(focusAreaId);
        }

        Long contestLogoId = (Long) attributes.get("contestLogoId");

        if (contestLogoId != null) {
            setContestLogoId(contestLogoId);
        }

        Boolean featured = (Boolean) attributes.get("featured");

        if (featured != null) {
            setFeatured(featured);
        }

        Boolean plansOpenByDefault = (Boolean) attributes.get(
                "plansOpenByDefault");

        if (plansOpenByDefault != null) {
            setPlansOpenByDefault(plansOpenByDefault);
        }

        Long sponsorLogoId = (Long) attributes.get("sponsorLogoId");

        if (sponsorLogoId != null) {
            setSponsorLogoId(sponsorLogoId);
        }

        String sponsorText = (String) attributes.get("sponsorText");

        if (sponsorText != null) {
            setSponsorText(sponsorText);
        }

        String sponsorLink = (String) attributes.get("sponsorLink");

        if (sponsorLink != null) {
            setSponsorLink(sponsorLink);
        }

        Integer flag = (Integer) attributes.get("flag");

        if (flag != null) {
            setFlag(flag);
        }

        String flagText = (String) attributes.get("flagText");

        if (flagText != null) {
            setFlagText(flagText);
        }

        String flagTooltip = (String) attributes.get("flagTooltip");

        if (flagTooltip != null) {
            setFlagTooltip(flagTooltip);
        }

        Long groupId = (Long) attributes.get("groupId");

        if (groupId != null) {
            setGroupId(groupId);
        }

        Long discussionGroupId = (Long) attributes.get("discussionGroupId");

        if (discussionGroupId != null) {
            setDiscussionGroupId(discussionGroupId);
        }

        Integer weight = (Integer) attributes.get("weight");

        if (weight != null) {
            setWeight(weight);
        }

        String resourcesUrl = (String) attributes.get("resourcesUrl");

        if (resourcesUrl != null) {
            setResourcesUrl(resourcesUrl);
        }

        Boolean contestPrivate = (Boolean) attributes.get("contestPrivate");

        if (contestPrivate != null) {
            setContestPrivate(contestPrivate);
        }

        Boolean usePermissions = (Boolean) attributes.get("usePermissions");

        if (usePermissions != null) {
            setUsePermissions(usePermissions);
        }
    }

    @Override
    public long getContestPK() {
        return _ContestPK;
    }

    @Override
    public void setContestPK(long ContestPK) {
        _ContestPK = ContestPK;

        if (_contestRemoteModel != null) {
            try {
                Class<?> clazz = _contestRemoteModel.getClass();

                Method method = clazz.getMethod("setContestPK", long.class);

                method.invoke(_contestRemoteModel, ContestPK);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getContestName() {
        return _ContestName;
    }

    @Override
    public void setContestName(String ContestName) {
        _ContestName = ContestName;

        if (_contestRemoteModel != null) {
            try {
                Class<?> clazz = _contestRemoteModel.getClass();

                Method method = clazz.getMethod("setContestName", String.class);

                method.invoke(_contestRemoteModel, ContestName);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getContestShortName() {
        return _ContestShortName;
    }

    @Override
    public void setContestShortName(String ContestShortName) {
        _ContestShortName = ContestShortName;

        if (_contestRemoteModel != null) {
            try {
                Class<?> clazz = _contestRemoteModel.getClass();

                Method method = clazz.getMethod("setContestShortName",
                        String.class);

                method.invoke(_contestRemoteModel, ContestShortName);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getContestDescription() {
        return _ContestDescription;
    }

    @Override
    public void setContestDescription(String ContestDescription) {
        _ContestDescription = ContestDescription;

        if (_contestRemoteModel != null) {
            try {
                Class<?> clazz = _contestRemoteModel.getClass();

                Method method = clazz.getMethod("setContestDescription",
                        String.class);

                method.invoke(_contestRemoteModel, ContestDescription);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getContestModelDescription() {
        return _ContestModelDescription;
    }

    @Override
    public void setContestModelDescription(String ContestModelDescription) {
        _ContestModelDescription = ContestModelDescription;

        if (_contestRemoteModel != null) {
            try {
                Class<?> clazz = _contestRemoteModel.getClass();

                Method method = clazz.getMethod("setContestModelDescription",
                        String.class);

                method.invoke(_contestRemoteModel, ContestModelDescription);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getContestPositionsDescription() {
        return _ContestPositionsDescription;
    }

    @Override
    public void setContestPositionsDescription(
        String ContestPositionsDescription) {
        _ContestPositionsDescription = ContestPositionsDescription;

        if (_contestRemoteModel != null) {
            try {
                Class<?> clazz = _contestRemoteModel.getClass();

                Method method = clazz.getMethod("setContestPositionsDescription",
                        String.class);

                method.invoke(_contestRemoteModel, ContestPositionsDescription);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getDefaultPlanDescription() {
        return _defaultPlanDescription;
    }

    @Override
    public void setDefaultPlanDescription(String defaultPlanDescription) {
        _defaultPlanDescription = defaultPlanDescription;

        if (_contestRemoteModel != null) {
            try {
                Class<?> clazz = _contestRemoteModel.getClass();

                Method method = clazz.getMethod("setDefaultPlanDescription",
                        String.class);

                method.invoke(_contestRemoteModel, defaultPlanDescription);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getPlanTypeId() {
        return _PlanTypeId;
    }

    @Override
    public void setPlanTypeId(long PlanTypeId) {
        _PlanTypeId = PlanTypeId;

        if (_contestRemoteModel != null) {
            try {
                Class<?> clazz = _contestRemoteModel.getClass();

                Method method = clazz.getMethod("setPlanTypeId", long.class);

                method.invoke(_contestRemoteModel, PlanTypeId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Date getCreated() {
        return _created;
    }

    @Override
    public void setCreated(Date created) {
        _created = created;

        if (_contestRemoteModel != null) {
            try {
                Class<?> clazz = _contestRemoteModel.getClass();

                Method method = clazz.getMethod("setCreated", Date.class);

                method.invoke(_contestRemoteModel, created);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Date getUpdated() {
        return _updated;
    }

    @Override
    public void setUpdated(Date updated) {
        _updated = updated;

        if (_contestRemoteModel != null) {
            try {
                Class<?> clazz = _contestRemoteModel.getClass();

                Method method = clazz.getMethod("setUpdated", Date.class);

                method.invoke(_contestRemoteModel, updated);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getAuthorId() {
        return _authorId;
    }

    @Override
    public void setAuthorId(long authorId) {
        _authorId = authorId;

        if (_contestRemoteModel != null) {
            try {
                Class<?> clazz = _contestRemoteModel.getClass();

                Method method = clazz.getMethod("setAuthorId", long.class);

                method.invoke(_contestRemoteModel, authorId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public boolean getContestActive() {
        return _contestActive;
    }

    @Override
    public boolean isContestActive() {
        return _contestActive;
    }

    @Override
    public void setContestActive(boolean contestActive) {
        _contestActive = contestActive;

        if (_contestRemoteModel != null) {
            try {
                Class<?> clazz = _contestRemoteModel.getClass();

                Method method = clazz.getMethod("setContestActive",
                        boolean.class);

                method.invoke(_contestRemoteModel, contestActive);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getPlanTemplateId() {
        return _planTemplateId;
    }

    @Override
    public void setPlanTemplateId(long planTemplateId) {
        _planTemplateId = planTemplateId;

        if (_contestRemoteModel != null) {
            try {
                Class<?> clazz = _contestRemoteModel.getClass();

                Method method = clazz.getMethod("setPlanTemplateId", long.class);

                method.invoke(_contestRemoteModel, planTemplateId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getFocusAreaId() {
        return _focusAreaId;
    }

    @Override
    public void setFocusAreaId(long focusAreaId) {
        _focusAreaId = focusAreaId;

        if (_contestRemoteModel != null) {
            try {
                Class<?> clazz = _contestRemoteModel.getClass();

                Method method = clazz.getMethod("setFocusAreaId", long.class);

                method.invoke(_contestRemoteModel, focusAreaId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getContestLogoId() {
        return _contestLogoId;
    }

    @Override
    public void setContestLogoId(long contestLogoId) {
        _contestLogoId = contestLogoId;

        if (_contestRemoteModel != null) {
            try {
                Class<?> clazz = _contestRemoteModel.getClass();

                Method method = clazz.getMethod("setContestLogoId", long.class);

                method.invoke(_contestRemoteModel, contestLogoId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public boolean getFeatured() {
        return _featured;
    }

    @Override
    public boolean isFeatured() {
        return _featured;
    }

    @Override
    public void setFeatured(boolean featured) {
        _featured = featured;

        if (_contestRemoteModel != null) {
            try {
                Class<?> clazz = _contestRemoteModel.getClass();

                Method method = clazz.getMethod("setFeatured", boolean.class);

                method.invoke(_contestRemoteModel, featured);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public boolean getPlansOpenByDefault() {
        return _plansOpenByDefault;
    }

    @Override
    public boolean isPlansOpenByDefault() {
        return _plansOpenByDefault;
    }

    @Override
    public void setPlansOpenByDefault(boolean plansOpenByDefault) {
        _plansOpenByDefault = plansOpenByDefault;

        if (_contestRemoteModel != null) {
            try {
                Class<?> clazz = _contestRemoteModel.getClass();

                Method method = clazz.getMethod("setPlansOpenByDefault",
                        boolean.class);

                method.invoke(_contestRemoteModel, plansOpenByDefault);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getSponsorLogoId() {
        return _sponsorLogoId;
    }

    @Override
    public void setSponsorLogoId(long sponsorLogoId) {
        _sponsorLogoId = sponsorLogoId;

        if (_contestRemoteModel != null) {
            try {
                Class<?> clazz = _contestRemoteModel.getClass();

                Method method = clazz.getMethod("setSponsorLogoId", long.class);

                method.invoke(_contestRemoteModel, sponsorLogoId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getSponsorText() {
        return _sponsorText;
    }

    @Override
    public void setSponsorText(String sponsorText) {
        _sponsorText = sponsorText;

        if (_contestRemoteModel != null) {
            try {
                Class<?> clazz = _contestRemoteModel.getClass();

                Method method = clazz.getMethod("setSponsorText", String.class);

                method.invoke(_contestRemoteModel, sponsorText);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getSponsorLink() {
        return _sponsorLink;
    }

    @Override
    public void setSponsorLink(String sponsorLink) {
        _sponsorLink = sponsorLink;

        if (_contestRemoteModel != null) {
            try {
                Class<?> clazz = _contestRemoteModel.getClass();

                Method method = clazz.getMethod("setSponsorLink", String.class);

                method.invoke(_contestRemoteModel, sponsorLink);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public int getFlag() {
        return _flag;
    }

    @Override
    public void setFlag(int flag) {
        _flag = flag;

        if (_contestRemoteModel != null) {
            try {
                Class<?> clazz = _contestRemoteModel.getClass();

                Method method = clazz.getMethod("setFlag", int.class);

                method.invoke(_contestRemoteModel, flag);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getFlagText() {
        return _flagText;
    }

    @Override
    public void setFlagText(String flagText) {
        _flagText = flagText;

        if (_contestRemoteModel != null) {
            try {
                Class<?> clazz = _contestRemoteModel.getClass();

                Method method = clazz.getMethod("setFlagText", String.class);

                method.invoke(_contestRemoteModel, flagText);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getFlagTooltip() {
        return _flagTooltip;
    }

    @Override
    public void setFlagTooltip(String flagTooltip) {
        _flagTooltip = flagTooltip;

        if (_contestRemoteModel != null) {
            try {
                Class<?> clazz = _contestRemoteModel.getClass();

                Method method = clazz.getMethod("setFlagTooltip", String.class);

                method.invoke(_contestRemoteModel, flagTooltip);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getGroupId() {
        return _groupId;
    }

    @Override
    public void setGroupId(long groupId) {
        _groupId = groupId;

        if (_contestRemoteModel != null) {
            try {
                Class<?> clazz = _contestRemoteModel.getClass();

                Method method = clazz.getMethod("setGroupId", long.class);

                method.invoke(_contestRemoteModel, groupId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getDiscussionGroupId() {
        return _discussionGroupId;
    }

    @Override
    public void setDiscussionGroupId(long discussionGroupId) {
        _discussionGroupId = discussionGroupId;

        if (_contestRemoteModel != null) {
            try {
                Class<?> clazz = _contestRemoteModel.getClass();

                Method method = clazz.getMethod("setDiscussionGroupId",
                        long.class);

                method.invoke(_contestRemoteModel, discussionGroupId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public int getWeight() {
        return _weight;
    }

    @Override
    public void setWeight(int weight) {
        _weight = weight;

        if (_contestRemoteModel != null) {
            try {
                Class<?> clazz = _contestRemoteModel.getClass();

                Method method = clazz.getMethod("setWeight", int.class);

                method.invoke(_contestRemoteModel, weight);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getResourcesUrl() {
        return _resourcesUrl;
    }

    @Override
    public void setResourcesUrl(String resourcesUrl) {
        _resourcesUrl = resourcesUrl;

        if (_contestRemoteModel != null) {
            try {
                Class<?> clazz = _contestRemoteModel.getClass();

                Method method = clazz.getMethod("setResourcesUrl", String.class);

                method.invoke(_contestRemoteModel, resourcesUrl);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public boolean getContestPrivate() {
        return _contestPrivate;
    }

    @Override
    public boolean isContestPrivate() {
        return _contestPrivate;
    }

    @Override
    public void setContestPrivate(boolean contestPrivate) {
        _contestPrivate = contestPrivate;

        if (_contestRemoteModel != null) {
            try {
                Class<?> clazz = _contestRemoteModel.getClass();

                Method method = clazz.getMethod("setContestPrivate",
                        boolean.class);

                method.invoke(_contestRemoteModel, contestPrivate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public boolean getUsePermissions() {
        return _usePermissions;
    }

    @Override
    public boolean isUsePermissions() {
        return _usePermissions;
    }

    @Override
    public void setUsePermissions(boolean usePermissions) {
        _usePermissions = usePermissions;

        if (_contestRemoteModel != null) {
            try {
                Class<?> clazz = _contestRemoteModel.getClass();

                Method method = clazz.getMethod("setUsePermissions",
                        boolean.class);

                method.invoke(_contestRemoteModel, usePermissions);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getContestRemoteModel() {
        return _contestRemoteModel;
    }

    public void setContestRemoteModel(BaseModel<?> contestRemoteModel) {
        _contestRemoteModel = contestRemoteModel;
    }

    public Object invokeOnRemoteModel(String methodName,
        Class<?>[] parameterTypes, Object[] parameterValues)
        throws Exception {
        Object[] remoteParameterValues = new Object[parameterValues.length];

        for (int i = 0; i < parameterValues.length; i++) {
            if (parameterValues[i] != null) {
                remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
            }
        }

        Class<?> remoteModelClass = _contestRemoteModel.getClass();

        ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

        Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

        for (int i = 0; i < parameterTypes.length; i++) {
            if (parameterTypes[i].isPrimitive()) {
                remoteParameterTypes[i] = parameterTypes[i];
            } else {
                String parameterTypeName = parameterTypes[i].getName();

                remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
            }
        }

        Method method = remoteModelClass.getMethod(methodName,
                remoteParameterTypes);

        Object returnValue = method.invoke(_contestRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            ContestLocalServiceUtil.addContest(this);
        } else {
            ContestLocalServiceUtil.updateContest(this);
        }
    }

    @Override
    public Contest toEscapedModel() {
        return (Contest) ProxyUtil.newProxyInstance(Contest.class.getClassLoader(),
            new Class[] { Contest.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        ContestClp clone = new ContestClp();

        clone.setContestPK(getContestPK());
        clone.setContestName(getContestName());
        clone.setContestShortName(getContestShortName());
        clone.setContestDescription(getContestDescription());
        clone.setContestModelDescription(getContestModelDescription());
        clone.setContestPositionsDescription(getContestPositionsDescription());
        clone.setDefaultPlanDescription(getDefaultPlanDescription());
        clone.setPlanTypeId(getPlanTypeId());
        clone.setCreated(getCreated());
        clone.setUpdated(getUpdated());
        clone.setAuthorId(getAuthorId());
        clone.setContestActive(getContestActive());
        clone.setPlanTemplateId(getPlanTemplateId());
        clone.setFocusAreaId(getFocusAreaId());
        clone.setContestLogoId(getContestLogoId());
        clone.setFeatured(getFeatured());
        clone.setPlansOpenByDefault(getPlansOpenByDefault());
        clone.setSponsorLogoId(getSponsorLogoId());
        clone.setSponsorText(getSponsorText());
        clone.setSponsorLink(getSponsorLink());
        clone.setFlag(getFlag());
        clone.setFlagText(getFlagText());
        clone.setFlagTooltip(getFlagTooltip());
        clone.setGroupId(getGroupId());
        clone.setDiscussionGroupId(getDiscussionGroupId());
        clone.setWeight(getWeight());
        clone.setResourcesUrl(getResourcesUrl());
        clone.setContestPrivate(getContestPrivate());
        clone.setUsePermissions(getUsePermissions());

        return clone;
    }

    @Override
    public int compareTo(Contest contest) {
        int value = 0;

        if (getWeight() < contest.getWeight()) {
            value = -1;
        } else if (getWeight() > contest.getWeight()) {
            value = 1;
        } else {
            value = 0;
        }

        if (value != 0) {
            return value;
        }

        value = DateUtil.compareTo(getCreated(), contest.getCreated());

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

        if (!(obj instanceof ContestClp)) {
            return false;
        }

        ContestClp contest = (ContestClp) obj;

        long primaryKey = contest.getPrimaryKey();

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
    public String toString() {
        StringBundler sb = new StringBundler(59);

        sb.append("{ContestPK=");
        sb.append(getContestPK());
        sb.append(", ContestName=");
        sb.append(getContestName());
        sb.append(", ContestShortName=");
        sb.append(getContestShortName());
        sb.append(", ContestDescription=");
        sb.append(getContestDescription());
        sb.append(", ContestModelDescription=");
        sb.append(getContestModelDescription());
        sb.append(", ContestPositionsDescription=");
        sb.append(getContestPositionsDescription());
        sb.append(", defaultPlanDescription=");
        sb.append(getDefaultPlanDescription());
        sb.append(", PlanTypeId=");
        sb.append(getPlanTypeId());
        sb.append(", created=");
        sb.append(getCreated());
        sb.append(", updated=");
        sb.append(getUpdated());
        sb.append(", authorId=");
        sb.append(getAuthorId());
        sb.append(", contestActive=");
        sb.append(getContestActive());
        sb.append(", planTemplateId=");
        sb.append(getPlanTemplateId());
        sb.append(", focusAreaId=");
        sb.append(getFocusAreaId());
        sb.append(", contestLogoId=");
        sb.append(getContestLogoId());
        sb.append(", featured=");
        sb.append(getFeatured());
        sb.append(", plansOpenByDefault=");
        sb.append(getPlansOpenByDefault());
        sb.append(", sponsorLogoId=");
        sb.append(getSponsorLogoId());
        sb.append(", sponsorText=");
        sb.append(getSponsorText());
        sb.append(", sponsorLink=");
        sb.append(getSponsorLink());
        sb.append(", flag=");
        sb.append(getFlag());
        sb.append(", flagText=");
        sb.append(getFlagText());
        sb.append(", flagTooltip=");
        sb.append(getFlagTooltip());
        sb.append(", groupId=");
        sb.append(getGroupId());
        sb.append(", discussionGroupId=");
        sb.append(getDiscussionGroupId());
        sb.append(", weight=");
        sb.append(getWeight());
        sb.append(", resourcesUrl=");
        sb.append(getResourcesUrl());
        sb.append(", contestPrivate=");
        sb.append(getContestPrivate());
        sb.append(", usePermissions=");
        sb.append(getUsePermissions());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(91);

        sb.append("<model><model-name>");
        sb.append("com.ext.portlet.model.Contest");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>ContestPK</column-name><column-value><![CDATA[");
        sb.append(getContestPK());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>ContestName</column-name><column-value><![CDATA[");
        sb.append(getContestName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>ContestShortName</column-name><column-value><![CDATA[");
        sb.append(getContestShortName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>ContestDescription</column-name><column-value><![CDATA[");
        sb.append(getContestDescription());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>ContestModelDescription</column-name><column-value><![CDATA[");
        sb.append(getContestModelDescription());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>ContestPositionsDescription</column-name><column-value><![CDATA[");
        sb.append(getContestPositionsDescription());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>defaultPlanDescription</column-name><column-value><![CDATA[");
        sb.append(getDefaultPlanDescription());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>PlanTypeId</column-name><column-value><![CDATA[");
        sb.append(getPlanTypeId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>created</column-name><column-value><![CDATA[");
        sb.append(getCreated());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>updated</column-name><column-value><![CDATA[");
        sb.append(getUpdated());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>authorId</column-name><column-value><![CDATA[");
        sb.append(getAuthorId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>contestActive</column-name><column-value><![CDATA[");
        sb.append(getContestActive());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>planTemplateId</column-name><column-value><![CDATA[");
        sb.append(getPlanTemplateId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>focusAreaId</column-name><column-value><![CDATA[");
        sb.append(getFocusAreaId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>contestLogoId</column-name><column-value><![CDATA[");
        sb.append(getContestLogoId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>featured</column-name><column-value><![CDATA[");
        sb.append(getFeatured());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>plansOpenByDefault</column-name><column-value><![CDATA[");
        sb.append(getPlansOpenByDefault());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>sponsorLogoId</column-name><column-value><![CDATA[");
        sb.append(getSponsorLogoId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>sponsorText</column-name><column-value><![CDATA[");
        sb.append(getSponsorText());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>sponsorLink</column-name><column-value><![CDATA[");
        sb.append(getSponsorLink());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>flag</column-name><column-value><![CDATA[");
        sb.append(getFlag());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>flagText</column-name><column-value><![CDATA[");
        sb.append(getFlagText());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>flagTooltip</column-name><column-value><![CDATA[");
        sb.append(getFlagTooltip());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>groupId</column-name><column-value><![CDATA[");
        sb.append(getGroupId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>discussionGroupId</column-name><column-value><![CDATA[");
        sb.append(getDiscussionGroupId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>weight</column-name><column-value><![CDATA[");
        sb.append(getWeight());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>resourcesUrl</column-name><column-value><![CDATA[");
        sb.append(getResourcesUrl());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>contestPrivate</column-name><column-value><![CDATA[");
        sb.append(getContestPrivate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>usePermissions</column-name><column-value><![CDATA[");
        sb.append(getUsePermissions());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
