package com.ext.portlet.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ProposalAttributeTypeService}.
 *
 * @author Brian Wing Shun Chan
 * @see ProposalAttributeTypeService
 * @generated
 */
public class ProposalAttributeTypeServiceWrapper
    implements ProposalAttributeTypeService,
        ServiceWrapper<ProposalAttributeTypeService> {
    private ProposalAttributeTypeService _proposalAttributeTypeService;

    public ProposalAttributeTypeServiceWrapper(
        ProposalAttributeTypeService proposalAttributeTypeService) {
        _proposalAttributeTypeService = proposalAttributeTypeService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _proposalAttributeTypeService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _proposalAttributeTypeService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _proposalAttributeTypeService.invokeMethod(name, parameterTypes,
            arguments);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public ProposalAttributeTypeService getWrappedProposalAttributeTypeService() {
        return _proposalAttributeTypeService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedProposalAttributeTypeService(
        ProposalAttributeTypeService proposalAttributeTypeService) {
        _proposalAttributeTypeService = proposalAttributeTypeService;
    }

    @Override
    public ProposalAttributeTypeService getWrappedService() {
        return _proposalAttributeTypeService;
    }

    @Override
    public void setWrappedService(
        ProposalAttributeTypeService proposalAttributeTypeService) {
        _proposalAttributeTypeService = proposalAttributeTypeService;
    }
}
