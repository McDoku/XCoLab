package com.ext.portlet.model.impl;

import com.ext.portlet.model.PlanItem;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing PlanItem in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see PlanItem
 * @generated
 */
public class PlanItemCacheModel implements CacheModel<PlanItem>, Externalizable {
    public long id;
    public long planId;
    public String state;
    public long updated;
    public long updateAuthorId;
    public String updateType;
    public long version;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(15);

        sb.append("{id=");
        sb.append(id);
        sb.append(", planId=");
        sb.append(planId);
        sb.append(", state=");
        sb.append(state);
        sb.append(", updated=");
        sb.append(updated);
        sb.append(", updateAuthorId=");
        sb.append(updateAuthorId);
        sb.append(", updateType=");
        sb.append(updateType);
        sb.append(", version=");
        sb.append(version);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public PlanItem toEntityModel() {
        PlanItemImpl planItemImpl = new PlanItemImpl();

        planItemImpl.setId(id);
        planItemImpl.setPlanId(planId);

        if (state == null) {
            planItemImpl.setState(StringPool.BLANK);
        } else {
            planItemImpl.setState(state);
        }

        if (updated == Long.MIN_VALUE) {
            planItemImpl.setUpdated(null);
        } else {
            planItemImpl.setUpdated(new Date(updated));
        }

        planItemImpl.setUpdateAuthorId(updateAuthorId);

        if (updateType == null) {
            planItemImpl.setUpdateType(StringPool.BLANK);
        } else {
            planItemImpl.setUpdateType(updateType);
        }

        planItemImpl.setVersion(version);

        planItemImpl.resetOriginalValues();

        return planItemImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        id = objectInput.readLong();
        planId = objectInput.readLong();
        state = objectInput.readUTF();
        updated = objectInput.readLong();
        updateAuthorId = objectInput.readLong();
        updateType = objectInput.readUTF();
        version = objectInput.readLong();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(id);
        objectOutput.writeLong(planId);

        if (state == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(state);
        }

        objectOutput.writeLong(updated);
        objectOutput.writeLong(updateAuthorId);

        if (updateType == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(updateType);
        }

        objectOutput.writeLong(version);
    }
}
