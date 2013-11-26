package com.ext.portlet.service.base;

import com.ext.portlet.service.PlanPositionItemLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class PlanPositionItemLocalServiceClpInvoker {
    private String _methodName0;
    private String[] _methodParameterTypes0;
    private String _methodName1;
    private String[] _methodParameterTypes1;
    private String _methodName2;
    private String[] _methodParameterTypes2;
    private String _methodName3;
    private String[] _methodParameterTypes3;
    private String _methodName4;
    private String[] _methodParameterTypes4;
    private String _methodName5;
    private String[] _methodParameterTypes5;
    private String _methodName6;
    private String[] _methodParameterTypes6;
    private String _methodName7;
    private String[] _methodParameterTypes7;
    private String _methodName8;
    private String[] _methodParameterTypes8;
    private String _methodName9;
    private String[] _methodParameterTypes9;
    private String _methodName10;
    private String[] _methodParameterTypes10;
    private String _methodName11;
    private String[] _methodParameterTypes11;
    private String _methodName12;
    private String[] _methodParameterTypes12;
    private String _methodName13;
    private String[] _methodParameterTypes13;
    private String _methodName14;
    private String[] _methodParameterTypes14;
    private String _methodName15;
    private String[] _methodParameterTypes15;
    private String _methodName478;
    private String[] _methodParameterTypes478;
    private String _methodName479;
    private String[] _methodParameterTypes479;
    private String _methodName484;
    private String[] _methodParameterTypes484;

    public PlanPositionItemLocalServiceClpInvoker() {
        _methodName0 = "addPlanPositionItem";

        _methodParameterTypes0 = new String[] {
                "com.ext.portlet.model.PlanPositionItem"
            };

        _methodName1 = "createPlanPositionItem";

        _methodParameterTypes1 = new String[] {
                "com.ext.portlet.service.persistence.PlanPositionItemPK"
            };

        _methodName2 = "deletePlanPositionItem";

        _methodParameterTypes2 = new String[] {
                "com.ext.portlet.service.persistence.PlanPositionItemPK"
            };

        _methodName3 = "deletePlanPositionItem";

        _methodParameterTypes3 = new String[] {
                "com.ext.portlet.model.PlanPositionItem"
            };

        _methodName4 = "dynamicQuery";

        _methodParameterTypes4 = new String[] {  };

        _methodName5 = "dynamicQuery";

        _methodParameterTypes5 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery"
            };

        _methodName6 = "dynamicQuery";

        _methodParameterTypes6 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int"
            };

        _methodName7 = "dynamicQuery";

        _methodParameterTypes7 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };

        _methodName8 = "dynamicQueryCount";

        _methodParameterTypes8 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery"
            };

        _methodName9 = "dynamicQueryCount";

        _methodParameterTypes9 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery",
                "com.liferay.portal.kernel.dao.orm.Projection"
            };

        _methodName10 = "fetchPlanPositionItem";

        _methodParameterTypes10 = new String[] {
                "com.ext.portlet.service.persistence.PlanPositionItemPK"
            };

        _methodName11 = "getPlanPositionItem";

        _methodParameterTypes11 = new String[] {
                "com.ext.portlet.service.persistence.PlanPositionItemPK"
            };

        _methodName12 = "getPersistedModel";

        _methodParameterTypes12 = new String[] { "java.io.Serializable" };

        _methodName13 = "getPlanPositionItems";

        _methodParameterTypes13 = new String[] { "int", "int" };

        _methodName14 = "getPlanPositionItemsCount";

        _methodParameterTypes14 = new String[] {  };

        _methodName15 = "updatePlanPositionItem";

        _methodParameterTypes15 = new String[] {
                "com.ext.portlet.model.PlanPositionItem"
            };

        _methodName478 = "getBeanIdentifier";

        _methodParameterTypes478 = new String[] {  };

        _methodName479 = "setBeanIdentifier";

        _methodParameterTypes479 = new String[] { "java.lang.String" };

        _methodName484 = "getAllIdsForPlanPositions";

        _methodParameterTypes484 = new String[] {
                "com.ext.portlet.model.PlanPositions"
            };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName0.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
            return PlanPositionItemLocalServiceUtil.addPlanPositionItem((com.ext.portlet.model.PlanPositionItem) arguments[0]);
        }

        if (_methodName1.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
            return PlanPositionItemLocalServiceUtil.createPlanPositionItem((com.ext.portlet.service.persistence.PlanPositionItemPK) arguments[0]);
        }

        if (_methodName2.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
            return PlanPositionItemLocalServiceUtil.deletePlanPositionItem((com.ext.portlet.service.persistence.PlanPositionItemPK) arguments[0]);
        }

        if (_methodName3.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
            return PlanPositionItemLocalServiceUtil.deletePlanPositionItem((com.ext.portlet.model.PlanPositionItem) arguments[0]);
        }

        if (_methodName4.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
            return PlanPositionItemLocalServiceUtil.dynamicQuery();
        }

        if (_methodName5.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
            return PlanPositionItemLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName6.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
            return PlanPositionItemLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue());
        }

        if (_methodName7.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
            return PlanPositionItemLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue(),
                (com.liferay.portal.kernel.util.OrderByComparator) arguments[3]);
        }

        if (_methodName8.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
            return PlanPositionItemLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName9.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
            return PlanPositionItemLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                (com.liferay.portal.kernel.dao.orm.Projection) arguments[1]);
        }

        if (_methodName10.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
            return PlanPositionItemLocalServiceUtil.fetchPlanPositionItem((com.ext.portlet.service.persistence.PlanPositionItemPK) arguments[0]);
        }

        if (_methodName11.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
            return PlanPositionItemLocalServiceUtil.getPlanPositionItem((com.ext.portlet.service.persistence.PlanPositionItemPK) arguments[0]);
        }

        if (_methodName12.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
            return PlanPositionItemLocalServiceUtil.getPersistedModel((java.io.Serializable) arguments[0]);
        }

        if (_methodName13.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
            return PlanPositionItemLocalServiceUtil.getPlanPositionItems(((Integer) arguments[0]).intValue(),
                ((Integer) arguments[1]).intValue());
        }

        if (_methodName14.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
            return PlanPositionItemLocalServiceUtil.getPlanPositionItemsCount();
        }

        if (_methodName15.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
            return PlanPositionItemLocalServiceUtil.updatePlanPositionItem((com.ext.portlet.model.PlanPositionItem) arguments[0]);
        }

        if (_methodName478.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes478, parameterTypes)) {
            return PlanPositionItemLocalServiceUtil.getBeanIdentifier();
        }

        if (_methodName479.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes479, parameterTypes)) {
            PlanPositionItemLocalServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName484.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes484, parameterTypes)) {
            return PlanPositionItemLocalServiceUtil.getAllIdsForPlanPositions((com.ext.portlet.model.PlanPositions) arguments[0]);
        }

        throw new UnsupportedOperationException();
    }
}