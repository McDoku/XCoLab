package org.xcolab.portlets.plansadmin;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import org.xcolab.portlets.plansadmin.wrappers.PlanSectionDefinitionWrapper;

import com.ext.portlet.PlanSectionDefinitionType;
import com.ext.portlet.model.Contest;
import com.ext.portlet.model.PlanSectionDefinition;
import com.ext.portlet.service.ContestLocalServiceUtil;
import com.ext.portlet.service.PlanSectionDefinitionLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;

public class PlanSectionDefinitionsAdmin implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PlanSectionDefinitionWrapper edited;
    
    public List<PlanSectionDefinitionWrapper> getSectionDefinitions() throws SystemException {
        List<PlanSectionDefinitionWrapper> ret = new ArrayList<PlanSectionDefinitionWrapper>();
        
        for (PlanSectionDefinition def: PlanSectionDefinitionLocalServiceUtil.getPlanSectionDefinitions(0, Integer.MAX_VALUE)) {
            ret.add(new PlanSectionDefinitionWrapper(def));
        }
        
        return ret;
    }
    
    public void editDefinitionActionListener(ActionEvent e) {
        edited = (PlanSectionDefinitionWrapper) e.getComponent().getAttributes().get("definition");
    }
    
    public String createNew() {
        edited = new PlanSectionDefinitionWrapper(PlanSectionDefinitionLocalServiceUtil.createPlanSectionDefinition(0));
        
        return "editPlanSectionDefinition";
    }
    
    

    public void setEdited(PlanSectionDefinitionWrapper edited) {
        this.edited = edited;
    }

    public PlanSectionDefinitionWrapper getEdited() {
        return edited;
    }
    
    public List<SelectItem> getPlanSectionDefinitionTypes() {
        List<SelectItem> ret = new ArrayList<>();
        
        for (PlanSectionDefinitionType type: PlanSectionDefinitionType.values()) {
            ret.add(new SelectItem(type.name(), type.name()));
        }
        
        return ret;
    }
    
    
    public List<SelectItem> getAllContestsForSelect() throws SystemException {
        List<SelectItem> ret = new ArrayList<>();
        
        ret.add(new SelectItem("", "-- choose --"));
        for (Contest c: ContestLocalServiceUtil.getContests(0, Integer.MAX_VALUE)) {
            ret.add(new SelectItem(c.getContestPK(), c.getContestShortName()));
        }
        
        return ret;
    }
    

}
