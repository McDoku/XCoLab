package com.ext.portlet.model.impl;

import com.ext.portlet.model.ActivitySubscription;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing ActivitySubscription in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see ActivitySubscription
 * @generated
 */
public class ActivitySubscriptionCacheModel implements CacheModel<ActivitySubscription>,
    Serializable {
    public long pk;
    public long classNameId;
    public long classPK;
    public int type;
    public String extraData;
    public long receiverId;
    public long createDate;
    public long modifiedDate;
    public boolean automatic;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(19);

        sb.append("{pk=");
        sb.append(pk);
        sb.append(", classNameId=");
        sb.append(classNameId);
        sb.append(", classPK=");
        sb.append(classPK);
        sb.append(", type=");
        sb.append(type);
        sb.append(", extraData=");
        sb.append(extraData);
        sb.append(", receiverId=");
        sb.append(receiverId);
        sb.append(", createDate=");
        sb.append(createDate);
        sb.append(", modifiedDate=");
        sb.append(modifiedDate);
        sb.append(", automatic=");
        sb.append(automatic);
        sb.append("}");

        return sb.toString();
    }

    public ActivitySubscription toEntityModel() {
        ActivitySubscriptionImpl activitySubscriptionImpl = new ActivitySubscriptionImpl();

        activitySubscriptionImpl.setPk(pk);
        activitySubscriptionImpl.setClassNameId(classNameId);
        activitySubscriptionImpl.setClassPK(classPK);
        activitySubscriptionImpl.setType(type);

        if (extraData == null) {
            activitySubscriptionImpl.setExtraData(StringPool.BLANK);
        } else {
            activitySubscriptionImpl.setExtraData(extraData);
        }

        activitySubscriptionImpl.setReceiverId(receiverId);

        if (createDate == Long.MIN_VALUE) {
            activitySubscriptionImpl.setCreateDate(null);
        } else {
            activitySubscriptionImpl.setCreateDate(new Date(createDate));
        }

        if (modifiedDate == Long.MIN_VALUE) {
            activitySubscriptionImpl.setModifiedDate(null);
        } else {
            activitySubscriptionImpl.setModifiedDate(new Date(modifiedDate));
        }

        activitySubscriptionImpl.setAutomatic(automatic);

        activitySubscriptionImpl.resetOriginalValues();

        return activitySubscriptionImpl;
    }
}
