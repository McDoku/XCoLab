package org.xcolab.portlets.proposals.wrappers;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.ext.portlet.NoSuchProposalAttributeException;
import com.ext.portlet.NoSuchProposalException;
import com.ext.portlet.PlanSectionTypeKeys;
import com.ext.portlet.model.FocusArea;
import com.ext.portlet.model.OntologyTerm;
import com.ext.portlet.model.PlanSectionDefinition;
import com.ext.portlet.model.Proposal;
import com.ext.portlet.model.ProposalAttribute;
import com.ext.portlet.service.FocusAreaLocalServiceUtil;
import com.ext.portlet.service.OntologyTermLocalServiceUtil;
import com.ext.portlet.service.ProposalLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

public class ProposalSectionWrapper {
    
    private PlanSectionDefinition definition;
    private Proposal proposal;
    private Integer version;
    
    public ProposalSectionWrapper(PlanSectionDefinition definition, Proposal proposal) {
        super();
        this.definition = definition;
        this.proposal = proposal;
    }
    
    public ProposalSectionWrapper(PlanSectionDefinition definition, Proposal proposal, int version) {
        super();
        this.definition = definition;
        this.proposal = proposal;
        this.version = version;
    }
    
    
    public String getTitle() {
        return definition.getTitle();
    }
    
    public String getContent() throws PortalException, SystemException {
        ProposalAttribute attr = getSectionAttribute();
        
        if (attr == null) return null;
        
        return attr.getStringValue().trim();
    }
    
    public PlanSectionTypeKeys getType() {
        if (StringUtils.isBlank(definition.getType())) {
            return PlanSectionTypeKeys.TEXT;
        }
        return PlanSectionTypeKeys.valueOf(definition.getType());
    }


    public Long getSectionDefinitionId() {
        return definition.getId();
    }

    public boolean isLocked() {
        return definition.getLocked();
    }
    
    public int getCharacterLimit() {
        return definition.getCharacterLimit();
    }
    
    public String getHelpText() {
        return definition.getHelpText();
    }
    
    public OntologyTerm getNumericValueAsOntologyTerm() throws SystemException, PortalException {
        ProposalAttribute attr = getSectionAttribute();
        if (attr == null || attr.getNumericValue() <= 0) {
            return null;
        }
        return OntologyTermLocalServiceUtil.getOntologyTerm(attr.getNumericValue());
    }
    
    public long getNumericValue() throws SystemException, PortalException {
        ProposalAttribute attr = getSectionAttribute();
        if (attr == null) {
            return 0;
        }
        return attr.getNumericValue();
        
    }
    
    public List<OntologyTerm> getFocusAreaTerms() throws PortalException, SystemException {
        if (definition.getFocusAreaId() <= 0) return null;
        
        FocusArea area = FocusAreaLocalServiceUtil.getFocusArea(definition.getFocusAreaId());
        
        return FocusAreaLocalServiceUtil.getTerms(area);
    }
    
    private ProposalAttribute getSectionAttribute() throws SystemException, PortalException {
        try {
            if (version != null && version > 0) {
                return ProposalLocalServiceUtil.getAttribute(proposal.getProposalId(), version, "SECTION", definition.getId());
            }
            else {
                return ProposalLocalServiceUtil.getAttribute(proposal.getProposalId(), "SECTION", definition.getId());
            }
        }
        catch (NoSuchProposalAttributeException e) {
            return null;
        }
        catch (NoSuchProposalException e) {
            return null;
        }
        
    }
}