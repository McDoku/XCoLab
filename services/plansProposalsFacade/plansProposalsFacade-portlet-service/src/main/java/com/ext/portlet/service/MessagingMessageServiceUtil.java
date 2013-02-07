package com.ext.portlet.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * The utility for the messaging message remote service. This utility wraps {@link com.ext.portlet.service.impl.MessagingMessageServiceImpl} and is the primary access point for service operations in application layer code running on a remote server.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MessagingMessageService
 * @see com.ext.portlet.service.base.MessagingMessageServiceBaseImpl
 * @see com.ext.portlet.service.impl.MessagingMessageServiceImpl
 * @generated
 */
public class MessagingMessageServiceUtil {
    private static MessagingMessageService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.ext.portlet.service.impl.MessagingMessageServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */
    public static void clearService() {
        _service = null;
    }

    public static MessagingMessageService getService() {
        if (_service == null) {
            Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    MessagingMessageService.class.getName());
            ClassLoader portletClassLoader = (ClassLoader) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    "portletClassLoader");

            ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
                    MessagingMessageService.class.getName(), portletClassLoader);

            _service = new MessagingMessageServiceClp(classLoaderProxy);

            ClpSerializer.setClassLoader(portletClassLoader);

            ReferenceRegistry.registerReference(MessagingMessageServiceUtil.class,
                "_service");
            MethodCache.remove(MessagingMessageService.class);
        }

        return _service;
    }

    public void setService(MessagingMessageService service) {
        MethodCache.remove(MessagingMessageService.class);

        _service = service;

        ReferenceRegistry.registerReference(MessagingMessageServiceUtil.class,
            "_service");
        MethodCache.remove(MessagingMessageService.class);
    }
}
