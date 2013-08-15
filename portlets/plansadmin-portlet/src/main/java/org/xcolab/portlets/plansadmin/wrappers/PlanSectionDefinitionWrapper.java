package org.xcolab.portlets.plansadmin.wrappers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import org.apache.commons.lang.StringUtils;

import com.ext.portlet.PlanSectionDefinitionType;
import com.ext.portlet.model.Contest;
import com.ext.portlet.model.FocusArea;
import com.ext.portlet.model.PlanSectionDefinition;
import com.ext.portlet.service.ContestLocalServiceUtil;
import com.ext.portlet.service.FocusAreaLocalServiceUtil;
import com.ext.portlet.service.PlanSectionDefinitionLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

public class PlanSectionDefinitionWrapper implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PlanSectionDefinition definition;

    public PlanSectionDefinitionWrapper(PlanSectionDefinition definition) {
        this.definition = definition;
    }

    public void setDefinition(PlanSectionDefinition definition) {
        this.definition = definition;
    }

    public PlanSectionDefinition getDefinition() {
        return definition;
    }
    
    public String save() throws SystemException {
        PlanSectionDefinitionLocalServiceUtil.store(definition);
        
        return "backToIndex";
    }
    
    public void focusAreaChange(ValueChangeEvent e) throws NumberFormatException, PortalException, SystemException {
        FocusArea fa = FocusAreaLocalServiceUtil.getFocusArea(Long.parseLong(e.getNewValue().toString()));
        
        definition.setFocusAreaId(fa.getId());
        PlanSectionDefinitionLocalServiceUtil.store(definition);
    }
    
    public List<SelectItem> getAvailableFocusAreas() throws SystemException {
        List<SelectItem> ret = new ArrayList<SelectItem>();
        
        for (FocusArea fa: FocusAreaLocalServiceUtil.getFocusAreas(0, Integer.MAX_VALUE)) {
            ret.add(new SelectItem(fa.getId(), fa.getName()));
        }
        return ret;
    }
    
    public Long getFocusAreaId() {
        return definition.getFocusAreaId();
    }
    
    public void setFocusAreaId(Long focusAreaId) {
        definition.setFocusAreaId(focusAreaId);
    }
    
    public PlanSectionDefinitionType getSectionType() {
        if (StringUtils.isBlank(definition.getType())) 
            return PlanSectionDefinitionType.TEXT;
        return PlanSectionDefinitionType.valueOf(definition.getType());
    }
    
    public String getType() {
        return definition.getType();
    }
    
    public void setType(String type) throws SystemException {
        definition.setType(type);
        PlanSectionDefinitionLocalServiceUtil.store(definition);
    }
    
    public String getAdminTitle() {
        
        return definition.getAdminTitle();
    }
    
    public String getTitle() {
        return definition.getTitle();
    }
    
    public List<Contest> getContests() throws PortalException, SystemException {
        return PlanSectionDefinitionLocalServiceUtil.getContestsWithProposals(definition);
    }
    
    public List<SelectItem> getAllContestsForSelect() throws SystemException {
        List<SelectItem> ret = new ArrayList<>();
        
        for (Contest c: ContestLocalServiceUtil.getContests(0, Integer.MAX_VALUE)) {
            ret.add(new SelectItem(c.getContestPK(), c.getContestShortName()));
        }
        
        return ret;
    }
}
