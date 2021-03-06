package org.climatecollaboratorium.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Serializable;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import com.ext.portlet.model.DiscussionCategoryGroup;
import com.ext.portlet.model.DiscussionMessage;
import com.ext.portlet.model.ModelGlobalPreference;
import com.ext.portlet.model.ModelInputGroup;
import com.ext.portlet.model.ModelInputItem;
import com.ext.portlet.model.ModelOutputChartOrder;
import com.ext.portlet.model.ModelOutputItem;
import com.ext.portlet.model.PlanMeta;
import com.ext.portlet.model.PlanModelRun;
import com.ext.portlet.model.PlanType;
import com.ext.portlet.service.DiscussionCategoryGroupLocalServiceUtil;
import com.ext.portlet.service.DiscussionMessageLocalServiceUtil;
import com.ext.portlet.service.ModelGlobalPreferenceLocalServiceUtil;
import com.ext.portlet.service.ModelInputGroupLocalServiceUtil;
import com.ext.portlet.service.ModelInputItemLocalServiceUtil;
import com.ext.portlet.service.ModelOutputChartOrderLocalServiceUtil;
import com.ext.portlet.service.ModelOutputItemLocalServiceUtil;
import com.ext.portlet.service.PlanMetaLocalServiceUtil;
import com.ext.portlet.service.PlanModelRunLocalServiceUtil;
import com.ext.portlet.service.PlanTypeLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class MigrationTool implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String scenarioMapping;
    private String simulationMapping;
    private String variableMapping;
    private final static Log _log = LogFactoryUtil.getLog(MigrationTool.class);
    
    
    public void removeQuestionFromLabels(ActionEvent e) throws SystemException {
        Pattern questionIconPattern = Pattern.compile("<img[^>]*qustion_icon\\.png[^>]*>");
        Pattern popupInfoBoxStart = Pattern.compile("<div[^>]*popup-info-box[^>]*>");
        Pattern popupInfoBoxEnd = Pattern.compile("</div>");
        
        for (ModelOutputItem item: ModelOutputItemLocalServiceUtil.getModelOutputItems(0, Integer.MAX_VALUE)) {
            
            String itemLabelFormat = item.getModelItemLabelFormat();
            String newLabelFormat = itemLabelFormat;
            // remove question marks
            Matcher questionMark = questionIconPattern.matcher(newLabelFormat);
            if (questionMark.find()) {
                newLabelFormat = itemLabelFormat.substring(0, questionMark.start()) + itemLabelFormat.substring(questionMark.end());
            }
            
            // replace popup info boxes with proper notifications
            Matcher popupInfoBoxStartMatcher = popupInfoBoxStart.matcher(newLabelFormat);
            
            if (popupInfoBoxStartMatcher.find()) {
                newLabelFormat = newLabelFormat.substring(0, popupInfoBoxStartMatcher.start()) + 
                    "<div class=\"act_tooltip_label\" style=\"display: none;\"><div class=\"act_tt-wrap_label\"><div class=\"act_tt-txt_label\">" + 
                    newLabelFormat.substring(popupInfoBoxStartMatcher.end());
                

                // replace popup info boxes with proper notifications
                Matcher popupInfoBoxEndMatcher = popupInfoBoxEnd.matcher(newLabelFormat);
                if (popupInfoBoxEndMatcher.find()) {
                    newLabelFormat = newLabelFormat.substring(0, popupInfoBoxEndMatcher.start()) +
                    "</div></div><div class=\"act_tt-bot_label\"></div></div>" + 
                    newLabelFormat.substring(popupInfoBoxEndMatcher.end());
                }
            }
            if (! itemLabelFormat.equals(newLabelFormat)) {
                item.setModelItemLabelFormat(newLabelFormat);
                ModelOutputItemLocalServiceUtil.updateModelOutputItem(item);
            }
            
            
        }
        FacesContext.getCurrentInstance().addMessage("Label updated", getMsg("Labels updated"));
    }
    
    private FacesMessage getMsg(String msg) {
        return new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null);
    }
    
    public void updateDiscussionCommentsTitles(ActionEvent e) throws SystemException, PortalException {
        for (DiscussionCategoryGroup dcg: DiscussionCategoryGroupLocalServiceUtil.getDiscussionCategoryGroups(0, Integer.MAX_VALUE)) {
            DiscussionMessage msg = DiscussionCategoryGroupLocalServiceUtil.getCommentThread(dcg);
            if (msg == null) {
                continue;
            }
            msg.setSubject(dcg.getDescription() + " comment " + 1);
            DiscussionMessageLocalServiceUtil.store(msg);
            int i = 2;
            for (DiscussionMessage comment: DiscussionMessageLocalServiceUtil.getThreadMessages(msg)) {
                comment.setSubject(dcg.getDescription() + " comment " + i++);
                DiscussionMessageLocalServiceUtil.store(comment);
            } 
        }
        FacesContext.getCurrentInstance().addMessage("Messages updated", getMsg("Messages updated"));
    }

    public String getScenarioMapping() {
        return scenarioMapping;
    }

    public void setScenarioMapping(String scenarioMapping) {
        this.scenarioMapping = scenarioMapping;
    }

    public String getSimulationMapping() {
        return simulationMapping;
    }

    public void setSimulationMapping(String simulationMapping) {
        this.simulationMapping = simulationMapping;
    }

    public void setVariableMapping(String variableMapping) {
        this.variableMapping = variableMapping;
    }

    public String getVariableMapping() {
        return variableMapping;
    }
    
    public List<String> simulationMigrationMessages;
    
    public void migrateSimulations(ActionEvent e) throws IOException, SystemException, MigrationException {
        simulationMigrationMessages = new ArrayList<String>();
        
        try {
            performSimulationMigration(false, simulationMigrationMessages);
        }
        catch (MigrationException ex) {
            _log.error(ex);
            simulationMigrationMessages.add(ex.getMessage());
            return;
        }
        simulationMigrationMessages = new ArrayList<String>();
        // if there were no migration exceptions, continue 
        performSimulationMigration(true, simulationMigrationMessages);
    }
    
    
    private void performSimulationMigration(boolean update, List<String> messages) throws SystemException, IOException, MigrationException {
        _log.info("Migration requested, with update: " + update);
        Map<Long, Long> simulationMapping = readMapping(this.simulationMapping);
        Map<Long, Long> scenarioMapping = readMapping(this.scenarioMapping);
        Map<Long, Long> variableMapping = readMapping(this.variableMapping);
        
        /* model global preferences */
        for (ModelGlobalPreference mgp: ModelGlobalPreferenceLocalServiceUtil.getModelGlobalPreferences(0, Integer.MAX_VALUE)) {
            if (simulationMapping.containsKey(mgp.getModelId())) {
                if (update) {
                    mgp.setModelId(simulationMapping.get(mgp.getModelId()));
                    ModelGlobalPreferenceLocalServiceUtil.updateModelGlobalPreference(mgp);
                    
                    _log.info("ModelGlobalPreference " + mgp.getModelGlobalPreferencePK() + " migrated");
                }
            }
        }
        
        /* model input group */
        for (ModelInputGroup mig: ModelInputGroupLocalServiceUtil.getModelInputGroups(0, Integer.MAX_VALUE)) {
            if (simulationMapping.containsKey(mig.getModelId())) {
                if (mig.getNameAndDescriptionMetaDataId() >= 0 && ! variableMapping.containsKey(mig.getNameAndDescriptionMetaDataId())) {
                    throw new MigrationException("There is setting for input group for input " + 
                            mig.getNameAndDescriptionMetaDataId() + " but no mapping has been defined");
                }
                if (update) {
                    mig.setModelId(simulationMapping.get(mig.getModelId()));
                    mig.setNameAndDescriptionMetaDataId(variableMapping.get(mig.getNameAndDescriptionMetaDataId()));
                    ModelInputGroupLocalServiceUtil.updateModelInputGroup(mig);
                    _log.info("ModelInputGroup " + mig.getModelInputGroupPK() + " migrated");
                }
            }
        }
        
        /* model input item */
        for (ModelInputItem mii: ModelInputItemLocalServiceUtil.getModelInputItems(0, Integer.MAX_VALUE)) {
            if (simulationMapping.containsKey(mii.getModelId())) {
                if (! variableMapping.containsKey(mii.getModelInputItemID())) {
                    throw new MigrationException("There is setting for input item for input " + 
                            mii.getModelInputItemID() + " but no mapping has been defined");
                    
                }
                if (update) {
                    mii.setModelId(simulationMapping.get(mii.getModelId()));
                    mii.setModelInputItemID(variableMapping.get(mii.getModelInputItemID()));
                    ModelInputItemLocalServiceUtil.updateModelInputItem(mii);
                    
                    _log.info("ModelInputItem " + mii.getModelInputItemPK() + " migrated");
                }
            }
        }
        
        /* Model output chart order */
        for (ModelOutputChartOrder moco: ModelOutputChartOrderLocalServiceUtil.getModelOutputChartOrders(0, Integer.MAX_VALUE)) {
            if (simulationMapping.containsKey(moco.getModelId())) {
                if (update) {
                    moco.setModelId(simulationMapping.get(moco.getModelId()));
                    ModelOutputChartOrderLocalServiceUtil.updateModelOutputChartOrder(moco);
                    
                    _log.info("ModelOutputChartOrder " + moco.getModelOutputChartOrderPK() + " migrated");
                }
            }
        }
        
        /* Model output item*/
        for (ModelOutputItem moi: ModelOutputItemLocalServiceUtil.getModelOutputItems(0, Integer.MAX_VALUE)) {
            if (simulationMapping.containsKey(moi.getModelId())) {
                if (update) {
                    
                    if (! variableMapping.containsKey(moi.getModelOutputItemId())) {
                         throw new MigrationException("There is setting for input item for input " + 
                                 moi.getModelOutputItemId() + " but no mapping has been defined");
                    }
                    if (moi.getRelatedOutputItem() >= 0 && ! variableMapping.containsKey(moi.getRelatedOutputItem())) {
                        throw new MigrationException("There is setting for input item for input " + 
                                moi.getRelatedOutputItem() + " but no mapping has been defined");
                        
                    }
                    
                    if (update) {
                        moi.setModelId(simulationMapping.get(moi.getModelId()));
                        moi.setModelOutputItemId(variableMapping.get(moi.getModelOutputItemId()));
                        
                        if (moi.getRelatedOutputItem() >= 0) {
                            moi.setRelatedOutputItem(variableMapping.get(moi.getRelatedOutputItem()));
                        }
                        
                        ModelOutputItemLocalServiceUtil.updateModelOutputItem(moi);   
                        
                        _log.info("ModelOutputItem " + moi.getModelOutputItemModifierPK() + " migrated");
                    }
                }
            }
        }
        
        /* Plan meta */
        for (PlanMeta pm: PlanMetaLocalServiceUtil.getPlanMetas(0, Integer.MAX_VALUE)) {
            if (simulationMapping.containsKey(pm.getModelId())) {
                if (update) {
                    pm.setModelId(simulationMapping.get(pm.getModelId()));
                    
                    PlanMetaLocalServiceUtil.store(pm);
                    
                    _log.info("PlanMeta " + pm.getId() + " migrated");
                }
                
            }
            else {
                messages.add("Can't find mapping for model " + pm.getModelId());
                _log.warn("Can't find mapping for model " + pm.getModelId());
            }
        }
        
        /* Plan model run */
        for (PlanModelRun pmr: PlanModelRunLocalServiceUtil.getPlanModelRuns(0, Integer.MAX_VALUE)) {
            if (pmr.getScenarioId() != 0L) {
                if (scenarioMapping.containsKey(pmr.getScenarioId())) {
                    if (update) {
                        pmr.setScenarioId(scenarioMapping.get(pmr.getScenarioId()));
                        PlanModelRunLocalServiceUtil.store(pmr);

                        _log.info("PlanModelRun " + pmr.getId() + " migrated");
                    }
                }
                else {
                    messages.add("Can't find mapping for scenario " + scenarioMapping.get(pmr.getScenarioId()));
                    _log.warn("Can't find mapping for scenario " + scenarioMapping.get(pmr.getScenarioId()));
                }
            }
        }
        
        /* Plan type */
        for(PlanType pt: PlanTypeLocalServiceUtil.getPlanTypes(0, Integer.MAX_VALUE)) {
            if (simulationMapping.containsKey(pt.getModelId())) {
                
                if (update) {
                    pt.setModelId(simulationMapping.get(pt.getModelId()));
                    PlanTypeLocalServiceUtil.updatePlanType(pt);
                    
                    _log.info("PlanType " + pt.getPlanTypeId() + " migrated");
                }
            }
            if (simulationMapping.containsKey(pt.getDefaultModelId())) {
                if (update) {
                    pt.setDefaultModelId(simulationMapping.get(pt.getDefaultModelId()));
                    PlanTypeLocalServiceUtil.updatePlanType(pt);
                    
                    _log.info("PlanType " + pt.getPlanTypeId() + " migrated");
                }
            }
            else {
                messages.add("Can't find mapping for model in plan type " + pt.getModelId());
                _log.warn("Can't find mapping for model in plan type " + pt.getModelId());
            }
        }
        
    }
    
    
    
    private Map<Long, Long> readMapping(String mappingStr) throws IOException {
        Map<Long, Long> mapping = new HashMap<Long, Long>();
        BufferedReader reader = new BufferedReader(new StringReader(mappingStr));
        
        String line = reader.readLine();
        while (line != null) {
            String[] ids = line.split(",");
            
            mapping.put(Long.parseLong(ids[1]), Long.parseLong(ids[0]));
            line = reader.readLine();
        }
        
        return mapping;
    }

    public List<String> getSimulationMigrationMessages() {
        return simulationMigrationMessages;
    }

    public void setSimulationMigrationMessages(List<String> simulationMigrationMessages) {
        this.simulationMigrationMessages = simulationMigrationMessages;
    }


}
