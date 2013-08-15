package com.ext.portlet.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * The utility for the plan section definition list item remote service. This utility wraps {@link com.ext.portlet.service.impl.PlanSectionDefinitionListItemServiceImpl} and is the primary access point for service operations in application layer code running on a remote server.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PlanSectionDefinitionListItemService
 * @see com.ext.portlet.service.base.PlanSectionDefinitionListItemServiceBaseImpl
 * @see com.ext.portlet.service.impl.PlanSectionDefinitionListItemServiceImpl
 * @generated
 */
public class PlanSectionDefinitionListItemServiceUtil {
    private static PlanSectionDefinitionListItemService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.ext.portlet.service.impl.PlanSectionDefinitionListItemServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */
    public static void clearService() {
        _service = null;
    }

    public static PlanSectionDefinitionListItemService getService() {
        if (_service == null) {
            Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    PlanSectionDefinitionListItemService.class.getName());
            ClassLoader portletClassLoader = (ClassLoader) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    "portletClassLoader");

            ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
                    PlanSectionDefinitionListItemService.class.getName(),
                    portletClassLoader);

            _service = new PlanSectionDefinitionListItemServiceClp(classLoaderProxy);

            ClpSerializer.setClassLoader(portletClassLoader);

            ReferenceRegistry.registerReference(PlanSectionDefinitionListItemServiceUtil.class,
                "_service");
            MethodCache.remove(PlanSectionDefinitionListItemService.class);
        }

        return _service;
    }

    public void setService(PlanSectionDefinitionListItemService service) {
        MethodCache.remove(PlanSectionDefinitionListItemService.class);

        _service = service;

        ReferenceRegistry.registerReference(PlanSectionDefinitionListItemServiceUtil.class,
            "_service");
        MethodCache.remove(PlanSectionDefinitionListItemService.class);
    }
}
