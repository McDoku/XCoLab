package com.ext.portlet.service;

import com.liferay.portal.kernel.util.ClassLoaderProxy;


public class PlanSectionDefinitionListItemServiceClp
    implements PlanSectionDefinitionListItemService {
    private ClassLoaderProxy _classLoaderProxy;

    public PlanSectionDefinitionListItemServiceClp(
        ClassLoaderProxy classLoaderProxy) {
        _classLoaderProxy = classLoaderProxy;
    }

    public ClassLoaderProxy getClassLoaderProxy() {
        return _classLoaderProxy;
    }
}
