package com.ext.portlet.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * The utility for the analytics user event remote service. This utility wraps {@link com.ext.portlet.service.impl.AnalyticsUserEventServiceImpl} and is the primary access point for service operations in application layer code running on a remote server.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AnalyticsUserEventService
 * @see com.ext.portlet.service.base.AnalyticsUserEventServiceBaseImpl
 * @see com.ext.portlet.service.impl.AnalyticsUserEventServiceImpl
 * @generated
 */
public class AnalyticsUserEventServiceUtil {
    private static AnalyticsUserEventService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.ext.portlet.service.impl.AnalyticsUserEventServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */
    public static void clearService() {
        _service = null;
    }

    public static AnalyticsUserEventService getService() {
        if (_service == null) {
            Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    AnalyticsUserEventService.class.getName());
            ClassLoader portletClassLoader = (ClassLoader) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    "portletClassLoader");

            ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
                    AnalyticsUserEventService.class.getName(),
                    portletClassLoader);

            _service = new AnalyticsUserEventServiceClp(classLoaderProxy);

            ClpSerializer.setClassLoader(portletClassLoader);

            ReferenceRegistry.registerReference(AnalyticsUserEventServiceUtil.class,
                "_service");
            MethodCache.remove(AnalyticsUserEventService.class);
        }

        return _service;
    }

    public void setService(AnalyticsUserEventService service) {
        MethodCache.remove(AnalyticsUserEventService.class);

        _service = service;

        ReferenceRegistry.registerReference(AnalyticsUserEventServiceUtil.class,
            "_service");
        MethodCache.remove(AnalyticsUserEventService.class);
    }
}