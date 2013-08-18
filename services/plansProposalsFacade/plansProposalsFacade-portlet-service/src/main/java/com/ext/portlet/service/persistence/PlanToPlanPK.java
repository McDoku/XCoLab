package com.ext.portlet.service.persistence;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;


public class PlanToPlanPK implements Comparable<PlanToPlanPK>, Serializable {
    public long fromPlanId;
    public long toPlanId;

    public PlanToPlanPK() {
    }

    public PlanToPlanPK(long fromPlanId, long toPlanId) {
        this.fromPlanId = fromPlanId;
        this.toPlanId = toPlanId;
    }

    public long getFromPlanId() {
        return fromPlanId;
    }

    public void setFromPlanId(long fromPlanId) {
        this.fromPlanId = fromPlanId;
    }

    public long getToPlanId() {
        return toPlanId;
    }

    public void setToPlanId(long toPlanId) {
        this.toPlanId = toPlanId;
    }

    public int compareTo(PlanToPlanPK pk) {
        if (pk == null) {
            return -1;
        }

        int value = 0;

        if (fromPlanId < pk.fromPlanId) {
            value = -1;
        } else if (fromPlanId > pk.fromPlanId) {
            value = 1;
        } else {
            value = 0;
        }

        if (value != 0) {
            return value;
        }

        if (toPlanId < pk.toPlanId) {
            value = -1;
        } else if (toPlanId > pk.toPlanId) {
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
        if (obj == null) {
            return false;
        }

        PlanToPlanPK pk = null;

        try {
            pk = (PlanToPlanPK) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        if ((fromPlanId == pk.fromPlanId) && (toPlanId == pk.toPlanId)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return (String.valueOf(fromPlanId) + String.valueOf(toPlanId)).hashCode();
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(10);

        sb.append(StringPool.OPEN_CURLY_BRACE);

        sb.append("fromPlanId");
        sb.append(StringPool.EQUAL);
        sb.append(fromPlanId);

        sb.append(StringPool.COMMA);
        sb.append(StringPool.SPACE);
        sb.append("toPlanId");
        sb.append(StringPool.EQUAL);
        sb.append(toPlanId);

        sb.append(StringPool.CLOSE_CURLY_BRACE);

        return sb.toString();
    }
}
