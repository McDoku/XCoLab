package com.ext.portlet.model.impl;

import com.ext.portlet.model.PlansFilter;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing PlansFilter in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see PlansFilter
 * @generated
 */
public class PlansFilterCacheModel implements CacheModel<PlansFilter>,
    Externalizable {
    public long userId;
    public long planTypeId;
    public String name;
    public String creator;
    public String description;
    public Double CO2From;
    public Double CO2To;
    public Double votesFrom;
    public Double votesTo;
    public Double damageFrom;
    public Double damageTo;
    public Double mitigationFrom;
    public Double mitigationTo;
    public long dateFrom;
    public long dateTo;
    public boolean filterPositionsAll;
    public boolean enabled;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(35);

        sb.append("{userId=");
        sb.append(userId);
        sb.append(", planTypeId=");
        sb.append(planTypeId);
        sb.append(", name=");
        sb.append(name);
        sb.append(", creator=");
        sb.append(creator);
        sb.append(", description=");
        sb.append(description);
        sb.append(", CO2From=");
        sb.append(CO2From);
        sb.append(", CO2To=");
        sb.append(CO2To);
        sb.append(", votesFrom=");
        sb.append(votesFrom);
        sb.append(", votesTo=");
        sb.append(votesTo);
        sb.append(", damageFrom=");
        sb.append(damageFrom);
        sb.append(", damageTo=");
        sb.append(damageTo);
        sb.append(", mitigationFrom=");
        sb.append(mitigationFrom);
        sb.append(", mitigationTo=");
        sb.append(mitigationTo);
        sb.append(", dateFrom=");
        sb.append(dateFrom);
        sb.append(", dateTo=");
        sb.append(dateTo);
        sb.append(", filterPositionsAll=");
        sb.append(filterPositionsAll);
        sb.append(", enabled=");
        sb.append(enabled);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public PlansFilter toEntityModel() {
        PlansFilterImpl plansFilterImpl = new PlansFilterImpl();

        plansFilterImpl.setUserId(userId);
        plansFilterImpl.setPlanTypeId(planTypeId);

        if (name == null) {
            plansFilterImpl.setName(StringPool.BLANK);
        } else {
            plansFilterImpl.setName(name);
        }

        if (creator == null) {
            plansFilterImpl.setCreator(StringPool.BLANK);
        } else {
            plansFilterImpl.setCreator(creator);
        }

        if (description == null) {
            plansFilterImpl.setDescription(StringPool.BLANK);
        } else {
            plansFilterImpl.setDescription(description);
        }

        plansFilterImpl.setCO2From(CO2From);
        plansFilterImpl.setCO2To(CO2To);
        plansFilterImpl.setVotesFrom(votesFrom);
        plansFilterImpl.setVotesTo(votesTo);
        plansFilterImpl.setDamageFrom(damageFrom);
        plansFilterImpl.setDamageTo(damageTo);
        plansFilterImpl.setMitigationFrom(mitigationFrom);
        plansFilterImpl.setMitigationTo(mitigationTo);

        if (dateFrom == Long.MIN_VALUE) {
            plansFilterImpl.setDateFrom(null);
        } else {
            plansFilterImpl.setDateFrom(new Date(dateFrom));
        }

        if (dateTo == Long.MIN_VALUE) {
            plansFilterImpl.setDateTo(null);
        } else {
            plansFilterImpl.setDateTo(new Date(dateTo));
        }

        plansFilterImpl.setFilterPositionsAll(filterPositionsAll);
        plansFilterImpl.setEnabled(enabled);

        plansFilterImpl.resetOriginalValues();

        return plansFilterImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        userId = objectInput.readLong();
        planTypeId = objectInput.readLong();
        name = objectInput.readUTF();
        creator = objectInput.readUTF();
        description = objectInput.readUTF();
        CO2From = objectInput.readDouble();
        CO2To = objectInput.readDouble();
        votesFrom = objectInput.readDouble();
        votesTo = objectInput.readDouble();
        damageFrom = objectInput.readDouble();
        damageTo = objectInput.readDouble();
        mitigationFrom = objectInput.readDouble();
        mitigationTo = objectInput.readDouble();
        dateFrom = objectInput.readLong();
        dateTo = objectInput.readLong();
        filterPositionsAll = objectInput.readBoolean();
        enabled = objectInput.readBoolean();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(userId);
        objectOutput.writeLong(planTypeId);

        if (name == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(name);
        }

        if (creator == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(creator);
        }

        if (description == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(description);
        }

        objectOutput.writeDouble(CO2From);
        objectOutput.writeDouble(CO2To);
        objectOutput.writeDouble(votesFrom);
        objectOutput.writeDouble(votesTo);
        objectOutput.writeDouble(damageFrom);
        objectOutput.writeDouble(damageTo);
        objectOutput.writeDouble(mitigationFrom);
        objectOutput.writeDouble(mitigationTo);
        objectOutput.writeLong(dateFrom);
        objectOutput.writeLong(dateTo);
        objectOutput.writeBoolean(filterPositionsAll);
        objectOutput.writeBoolean(enabled);
    }
}
