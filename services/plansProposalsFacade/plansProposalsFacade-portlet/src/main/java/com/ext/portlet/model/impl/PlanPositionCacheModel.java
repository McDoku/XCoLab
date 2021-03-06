package com.ext.portlet.model.impl;

import com.ext.portlet.model.PlanPosition;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing PlanPosition in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see PlanPosition
 * @generated
 */
public class PlanPositionCacheModel implements CacheModel<PlanPosition>,
    Externalizable {
    public long planId;
    public long positionId;
    public long userId;
    public String userName;
    public long createDate;
    public long modifiedDate;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(13);

        sb.append("{planId=");
        sb.append(planId);
        sb.append(", positionId=");
        sb.append(positionId);
        sb.append(", userId=");
        sb.append(userId);
        sb.append(", userName=");
        sb.append(userName);
        sb.append(", createDate=");
        sb.append(createDate);
        sb.append(", modifiedDate=");
        sb.append(modifiedDate);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public PlanPosition toEntityModel() {
        PlanPositionImpl planPositionImpl = new PlanPositionImpl();

        planPositionImpl.setPlanId(planId);
        planPositionImpl.setPositionId(positionId);
        planPositionImpl.setUserId(userId);

        if (userName == null) {
            planPositionImpl.setUserName(StringPool.BLANK);
        } else {
            planPositionImpl.setUserName(userName);
        }

        if (createDate == Long.MIN_VALUE) {
            planPositionImpl.setCreateDate(null);
        } else {
            planPositionImpl.setCreateDate(new Date(createDate));
        }

        if (modifiedDate == Long.MIN_VALUE) {
            planPositionImpl.setModifiedDate(null);
        } else {
            planPositionImpl.setModifiedDate(new Date(modifiedDate));
        }

        planPositionImpl.resetOriginalValues();

        return planPositionImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        planId = objectInput.readLong();
        positionId = objectInput.readLong();
        userId = objectInput.readLong();
        userName = objectInput.readUTF();
        createDate = objectInput.readLong();
        modifiedDate = objectInput.readLong();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(planId);
        objectOutput.writeLong(positionId);
        objectOutput.writeLong(userId);

        if (userName == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(userName);
        }

        objectOutput.writeLong(createDate);
        objectOutput.writeLong(modifiedDate);
    }
}
