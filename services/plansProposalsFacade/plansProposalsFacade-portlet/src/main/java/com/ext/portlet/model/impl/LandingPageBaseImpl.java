package com.ext.portlet.model.impl;

import com.ext.portlet.model.LandingPage;
import com.ext.portlet.service.LandingPageLocalServiceUtil;

import com.liferay.portal.kernel.exception.SystemException;

/**
 * The extended model base implementation for the LandingPage service. Represents a row in the &quot;xcolab_LandingPage&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link LandingPageImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LandingPageImpl
 * @see com.ext.portlet.model.LandingPage
 * @generated
 */
public abstract class LandingPageBaseImpl extends LandingPageModelImpl
    implements LandingPage {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a landing page model instance should use the {@link LandingPage} interface instead.
     */
    public void persist() throws SystemException {
        if (this.isNew()) {
            LandingPageLocalServiceUtil.addLandingPage(this);
        } else {
            LandingPageLocalServiceUtil.updateLandingPage(this);
        }
    }
}