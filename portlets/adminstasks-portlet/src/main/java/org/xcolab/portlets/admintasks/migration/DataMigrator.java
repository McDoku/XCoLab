package org.xcolab.portlets.admintasks.migration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.ext.portlet.service.*;
import com.liferay.portal.model.User;
import org.xcolab.portlets.admintasks.migration.persistence.NewPersistenceCleaner;
import org.xcolab.portlets.admintasks.migration.persistence.NewPersistenceQueries;
import org.xcolab.portlets.admintasks.migration.persistence.OldPersistenceQueries;

import com.ext.portlet.ProposalAttributeKeys;
import com.ext.portlet.model.ContestPhaseRibbonType;
import com.ext.portlet.model.Plan2Proposal;
import com.ext.portlet.model.PlanAttribute;
import com.ext.portlet.model.PlanDescription;
import com.ext.portlet.model.PlanFan;
import com.ext.portlet.model.PlanItem;
import com.ext.portlet.model.PlanMeta;
import com.ext.portlet.model.PlanModelRun;
import com.ext.portlet.model.PlanSection;
import com.ext.portlet.model.PlanType;
import com.ext.portlet.model.PlanVote;
import com.ext.portlet.model.ContestPhase;
import com.ext.portlet.model.Proposal;
import com.ext.portlet.model.Proposal2Phase;
import com.ext.portlet.model.ProposalSupporter;
import com.ext.portlet.model.ProposalVote;
import com.ext.portlet.plans.PlanConstants;
import com.icesoft.faces.async.render.SessionRenderer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalThreadLocal;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.security.permission.PermissionCheckerFactoryUtil;
import com.liferay.portal.security.permission.PermissionThreadLocal;
import com.liferay.portal.service.UserLocalServiceUtil;

/**
 * Created with IntelliJ IDEA.
 * User: patrickhiesel
 * Date: 9/17/13
 * Time: 12:33 PM
 * To change this template use File | Settings | File Templates.
 */
public class DataMigrator implements Runnable {
    List<String> reference;
    private boolean TESTING = false;
    public boolean STOP = false;


    private final static String[] regionsDevelopedArr = {"United States", "European Union",
            "Russia/Former Soviet Union", "OECD Asia", "Canada"};
    private final static String[] regionsRapidlyDevelopingArr = {"China", "India", "Brazil", "South Africa", "Mexico",
            "Rapidly developing Asia",};
    private final static String[] regionsOtherDevelopingArr = {"Middle East", "Latin America", "Africa",
            "Other developing Asia"};
    private final static Set<String> regionsDeveloped = new HashSet<String>(Arrays.asList(regionsDevelopedArr));
    private final static Set<String> regionsRapidlyDeveloping = new HashSet<String>(
            Arrays.asList(regionsRapidlyDevelopingArr));
    private final static Set<String> regionsOtherDeveloping = new HashSet<String>(
            Arrays.asList(regionsOtherDevelopingArr));

    private int counter = 0;
    
    public DataMigrator(List<String> reference){
        this.reference = reference;
    }

    public void run() {
        setPermissions();

        if (!(new NewPersistenceCleaner(reference).deleteAllRecordsForNewEntities())) return;


        //--
        List<Pair<Long,List<PlanItem>>> plansWithoutGroups = getPlansWithoutGroups();
        pushAjaxUpdate("Creating new Proposals Without Groups");
        pushAjaxUpdate("0%");
        int counter = 0;

        for(Iterator<Pair<Long,List<PlanItem>>> i = plansWithoutGroups.iterator(); i.hasNext(); ) {
            if (STOP) break;
            if (++counter > 0 && (counter % (plansWithoutGroups.size() / 33)) == 0) updateLastAjaxUpdate((100 * counter / plansWithoutGroups.size()) + "%");
            Pair<Long,List<PlanItem>> pair = i.next();
            createNewPlan(pair.getLeft(),pair.getRight());
            if (counter > (plansWithoutGroups.size()/10) && TESTING) break;
        }
        //--

        //--
        List<Pair<Long,List<PlanItem>>> groupedPlans = getAllDistinctPlanGroupIds();
        pushAjaxUpdate("Creating new Proposals");
        pushAjaxUpdate("0%");
        counter = 0;

        boolean skippedFirstRecords = false;
        for(Iterator<Pair<Long,List<PlanItem>>> i = groupedPlans.iterator(); i.hasNext(); ) {
            if (STOP) break;

            // for testing skip first 100 plans
            if (TESTING && !skippedFirstRecords) {
                for (int z=0; z<100;z++) i.next();
                skippedFirstRecords = true;
            }

            if (++counter > 0 && (counter % (groupedPlans.size() / 33)) == 0) updateLastAjaxUpdate((100 * counter / groupedPlans.size()) + "%");
            Pair<Long,List<PlanItem>> pair = i.next();

            createNewPlan(pair.getLeft(),pair.getRight());
            if (counter > (groupedPlans.size()/10) && TESTING) break;
        }
        //--

        pushAjaxUpdate("-- APPLYING INCONSISTENCY FIXES --");
        promoteProposalsInOldContestByOnePhase(5);  // contest 2010
        fixMinorInconsistencies();
        pushAjaxUpdate("-- MIGRATION FINISHED --");

    }

    private void setPermissions(){
        PrincipalThreadLocal.setName(10144L);
        PermissionChecker permissionChecker;
        try {
            permissionChecker = PermissionCheckerFactoryUtil.create(UserLocalServiceUtil.getUser(10144L), true);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        PermissionThreadLocal.setPermissionChecker(permissionChecker);
    }

    private List<Pair<Long,List<PlanItem>>> getAllDistinctPlanGroupIds(){
        pushAjaxUpdate("Getting Distinct PlanGroupIDs");
        List<PlanItem> allPlans;
        List<Pair<Long,List<PlanItem>>> results = new LinkedList<Pair<Long,List<PlanItem>>>();
        try {
            allPlans = PlanItemLocalServiceUtil.getPlans();
        } catch (Exception e){
            pushAjaxUpdate("Error: " + e);
            return null;
        }
        pushAjaxUpdate("Got " + allPlans.size() + " Plans");
        pushAjaxUpdate("Grouping Plans");
        pushAjaxUpdate("0%");
        int counter=0;
        for(PlanItem plan :  allPlans) {
            if (++counter > 0 && (counter % (allPlans.size() / 3)) == 0)
                updateLastAjaxUpdate((100 * counter / allPlans.size() + 1) + "%");
            try{
                long groupID = PlanItemGroupLocalServiceUtil.getPlanItemGroup(plan.getPlanId()).getGroupId();
                boolean didFindGroupIdInSet = false;

                    for(Pair<Long,List<PlanItem>> pair : results) {
                        if (pair.getLeft().longValue() == groupID){
                            pair.getRight().add(0,plan);
                            didFindGroupIdInSet = true;
                            break;
                        }
                    }
                if (!didFindGroupIdInSet){
                    Pair<Long,List<PlanItem>> newPair = new Pair<Long,List<PlanItem>>(groupID,new LinkedList<PlanItem>());
                    newPair.getRight().add(plan);
                    results.add(newPair);
                }
            } catch (Exception e){
                System.out.println("No Group Found for ID " + plan.getPlanId());
            }
        }
        pushAjaxUpdate("Done Getting Distinct PlanGroupIDs (count: " + results.size() + ")");
        return results;
    }


    private List<Pair<Long,List<PlanItem>>> getPlansWithoutGroups(){
        List<Long> list = OldPersistenceQueries.getPlanItemsWithoutGroups();
        Collections.sort(list);
        List<Pair<Long, List<PlanItem>>> plans = new ArrayList<Pair<Long, List<PlanItem>>>();

        for (Long l : list) {
            try {
                PlanItem pi = PlanItemLocalServiceUtil.getPlan(l);
                String name = PlanDescriptionLocalServiceUtil.getCurrentForPlan(pi).getName();
                if (name.contains("Untitled Plan") || name.contains("Untitled Proposal")) continue;
                if (pi.getState().equalsIgnoreCase("DELETED")) continue;
                List<PlanItem> right = new ArrayList<PlanItem>();
                right.add(pi);
                plans.add(new Pair<Long, List<PlanItem>>(-1L, right));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
            return plans;
        }

    private void createNewPlan(long groupID, List<PlanItem> plans){

        // sort plans by create date
        Collections.sort(plans, new Comparator<PlanItem>() {

            public int compare(PlanItem o1, PlanItem o2) {
                return (int) (o1.getPlanId() - o2.getPlanId());
            }
            
        });




        PlanMeta currentPlanMeta = null;
        Proposal2Phase latestP2P = null;
        long currentContestPhase = 0;

        // get current plan meta for setting proposal entity attributes
        try{
            currentPlanMeta = PlanMetaLocalServiceUtil.getCurrentForPlan(plans.get(0));
        } catch (Exception e){
            pushAjaxUpdate("Error while getting PlanMetas " + plans.get(0).getId() + ": " + e);
            return;
        }

        long authorID = currentPlanMeta.getAuthorId();
        
        Proposal proposal = null;
        try {
            proposal = ProposalLocalServiceUtil.create(authorID,0,plans.get(plans.size()-1).getPlanId(),false);
        } catch (Exception e){
            pushAjaxUpdate("Error while creating Proposal " + groupID + ": " + e);
        }

        // set create date
        proposal.setCreateDate(plans.get(0).getUpdated());

        // set initial user group and discussion
        proposal.setGroupId(currentPlanMeta.getPlanGroupId());
        proposal.setDiscussionId(currentPlanMeta.getCategoryGroupId());

        // update proposal
        try {
            ProposalLocalServiceUtil.updateProposal(proposal);
        } catch (Exception e){
            pushAjaxUpdate("Error while updating Proposal " + groupID + ": " + e);
        }

        List<Long> planFans = new ArrayList<Long>();

        // Loop through all plans - each representing one contest phase
        boolean isFirstInGroup = true;
        for(PlanItem plan :  plans) {

            // get updated proposal
            try {
                proposal = ProposalLocalServiceUtil.getProposal(proposal.getProposalId());
            } catch (Exception e){
                pushAjaxUpdate("Error while updating Proposal " + groupID + ": " + e);
            }

            // add mapping to old DB schema
            createPlan2ProposalMapping(plan,proposal);

            // map proposal to contest phases
            latestP2P = createProposal2PhaseMapping(plan,proposal, latestP2P, currentContestPhase);
            currentContestPhase++;

            // plan entity represents a last version of a plan (for given planId) so we need to iterate over all of it's versions
            // to create respective attributes of a proposal
            if (isFirstInGroup) {
                // transfer regional attributes if they exist
                try {
                    PlanAttribute regionAttribute = PlanItemLocalServiceUtil.getPlanAttribute(plan, "REGION");
                    if (regionAttribute != null) {
                        String region = regionAttribute.getAttributeValue();
                        ProposalLocalServiceUtil.setAttribute(authorID, proposal.getProposalId(), ProposalAttributeKeys.REGION, 0L, region,0,0,dateFix(plan.getUpdated()),false);
                        String regionEconomy = "Other Developing";
                        
                        
                        if (regionsDeveloped.contains(region)) {
                            regionEconomy = "Developed";
                        } else if (regionsRapidlyDeveloping.contains(region)) {
                            regionEconomy = "Rapidly Developing";
                        }
                        
                        ProposalLocalServiceUtil.setAttribute(authorID, proposal.getProposalId(), ProposalAttributeKeys.REGION_ECONOMY, 0L,  regionEconomy,0,0,dateFix(plan.getUpdated()),false);
                    }
                    PlanAttribute subregionAttribute = PlanItemLocalServiceUtil.getPlanAttribute(plan, "SUBREGION");
                    if (subregionAttribute != null) {
                        ProposalLocalServiceUtil.setAttribute(authorID, proposal.getProposalId(), ProposalAttributeKeys.SUBREGION, 0L, subregionAttribute.getAttributeValue(),0,0,dateFix(plan.getUpdated()),false);
                    }
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }

            // migrate team name
            try {
                PlanAttribute teamAttribute = PlanItemLocalServiceUtil.getPlanAttribute(plan, "TEAM");
                if (teamAttribute != null) {
                    String teamName = teamAttribute.getAttributeValue();
                    ProposalLocalServiceUtil.setAttribute(authorID, proposal.getProposalId(), ProposalAttributeKeys.TEAM, 0L, teamName,0,0,dateFix(plan.getUpdated()),false);
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }

            createProposalAttributesFromPlan(plan,proposal);
            createVotesFromPlan(plan,proposal);
            // copy supporters (fans)
            createSupporters(plan,proposal,planFans);

            // create ribbons for this plan
            createRibbons(plan, proposal);

            // add supporters
            copySubscribers(plan,proposal);

            // refresh discussion id, group id, updated date
            copyMetaInfo(plan,proposal);

        }

        OldPersistenceQueries.updateSocialActivityClassPKToProposalId(groupID, plans);

    }

    private void createVotesFromPlan(PlanItem plan, Proposal proposal){
        List<PlanVote> planVotes = null;
        long contestPhase = 0;
        try{
            planVotes = PlanVoteLocalServiceUtil.getPlanVotes(plan.getPlanId());
            contestPhase = PlanItemLocalServiceUtil.getContestPhase(plan).getContestPhasePK();
        } catch (Exception e){
            pushAjaxUpdate("Error while getting Votes " + plan.getPlanId() + ": " + e);
            return;
        }

        for (PlanVote planVote : planVotes){
            ProposalVote vote = ProposalVoteLocalServiceUtil.create(contestPhase, planVote.getUserId());
            vote.setCreateDate(planVote.getCreateDate());
            vote.setProposalId(proposal.getProposalId());
            try{
                ProposalVoteLocalServiceUtil.addProposalVote(vote);
            } catch (Exception e){
                pushAjaxUpdate("Error while persisting Votes " + plan.getPlanId() + ": " + e);
                return;
            }
        }
    }



    private void createPlan2ProposalMapping(PlanItem plan, Proposal proposal){
        Plan2Proposal plan2Proposal = Plan2ProposalLocalServiceUtil.createPlan2Proposal(plan.getPlanId());
        plan2Proposal.setProposalId(proposal.getProposalId());

        try {
            Plan2ProposalLocalServiceUtil.addPlan2Proposal(plan2Proposal);
        } catch (SystemException e1) {
            pushAjaxUpdate("Error while creating mapping between plan " + plan.getPlanId() + " and proposal: " + proposal.getProposalId() + "\n" + e1);
        }
    }

    private Proposal2Phase createProposal2PhaseMapping(PlanItem plan, Proposal proposal, Proposal2Phase latestP2P, long currentContestPhase){
        // handle new Proposal2Contest Phase Mapping

        if (currentContestPhase > 0){
            // set VersionTo for old p2p mapping
            latestP2P.setVersionTo(proposal.getCurrentVersion());
            try{
                Proposal2PhaseLocalServiceUtil.updateProposal2Phase(latestP2P);
            }catch (SystemException e1) {
                pushAjaxUpdate("Error while storing Proposal2Phase mapping" + e1);
            }
        }
        // add new p2p record
        //System.out.println("Current Version:" + proposal.getCurrentVersion() + " ID: " + proposal.getProposalId() + " ContestPhase: " + currentContestPhase);
        PlanMeta matchingMeta = null;
        try {
            for (PlanMeta pm : PlanMetaLocalServiceUtil.getAllForPlan(plan)){
                if (pm.getPlanVersion() == 0){
                    matchingMeta = pm;
                }
            }
        } catch (SystemException e1) {
            pushAjaxUpdate("Error while creating mapping between plan " + plan.getPlanId() + " and proposal: " + proposal.getProposalId() + "\n" + e1);
        }

        if(matchingMeta != null){
            Proposal2Phase p2p = Proposal2PhaseLocalServiceUtil.create(proposal.getProposalId(),matchingMeta.getContestPhase());
            p2p.setSortWeight(1);
            p2p.setAutopromoteCandidate(false);
            p2p.setVersionFrom(proposal.getCurrentVersion());  /* TODO how should we increment the version set/get attr?*/
            p2p.setVersionTo(-1);

            try{
                Proposal2PhaseLocalServiceUtil.addProposal2Phase(p2p);
            }catch (SystemException e1) {
                pushAjaxUpdate("Error while storing Proposal2Phase mapping" + e1);
            }
            return p2p;
        } else{
            System.out.println("Not matching meta found: " + plan.getPlanId());
            return null;
        }
    }

    private void createProposalAttributesFromPlan(PlanItem plan, Proposal proposal){
        List<PlanItem> planVersions = OldPersistenceQueries.getAllVersionsForPlanASC(plan.getPlanId());

        for (PlanItem planVersion : planVersions) {
            if (planVersion.getUpdateType().equalsIgnoreCase("CREATED")){
                // ignore use just for transferring from one phase to another
                boolean oldContest = false; // old contests have inconsistencies, therefore migrate all attributes to assure proper migration
                try{
                    if(!ContestLocalServiceUtil.isActive(PlanItemLocalServiceUtil.getContest(plan)))
                    {
                        setAttributeRelatedToPlanDescription(planVersion,proposal,"ALL");
                    }
                } catch (Exception e) { e.printStackTrace(); }
            } else if (planVersion.getUpdateType().equalsIgnoreCase("MODEL_UPDATED")){
                // IGNORE because modelID is deprecated
            } else if (planVersion.getUpdateType().equalsIgnoreCase("SCENARIO_UPDATED")){
                // Get scenarioId from xcolab_PlanModelRun and use it to create attribute
                setAttributeRelatedToScenario(planVersion,proposal,"SCENARIO_UPDATED");
            } else if (planVersion.getUpdateType().equalsIgnoreCase("PLAN_POSITIONS_UPDATED")){
                // IGNORE
            } else if (planVersion.getUpdateType().equalsIgnoreCase("PLAN_DELETED")){
                // SET visibility = false
                proposal.setVisible(false);
            } else if (planVersion.getUpdateType().equalsIgnoreCase("DESCRIPTION_UPDATED")){
                // Get description from xcolab_PlanDescription and use setAttribute
                setAttributeRelatedToPlanDescription(planVersion,proposal,"DESCRIPTION");
            } else if (planVersion.getUpdateType().equalsIgnoreCase("NAME_UPDATED")){
                // Get name from xcolab_PlanDescription and use setAttribute
                setAttributeRelatedToPlanDescription(planVersion,proposal,"NAME");
            } else if (planVersion.getUpdateType().equalsIgnoreCase("PLAN_STATUS_UPDATED")){
                // IGNORE (connected to PlanMeta (col: Status)
            } else if (planVersion.getUpdateType().equalsIgnoreCase("PLAN_CLOSED")){
                // Get open from PlanMeta - anyone can edit (open), only team members can edit
                setAttributeRelatedToPlanMeta(planVersion,proposal,"PLAN_CLOSED");
            } else if (planVersion.getUpdateType().equalsIgnoreCase("PLAN_OPENED")){
                // Get open from PlanMeta - anyone can edit (open), only team members can edit
                setAttributeRelatedToPlanMeta(planVersion,proposal,"PLAN_OPENED");
            } else if (planVersion.getUpdateType().equalsIgnoreCase("PLAN_SECTION_UPDATED")){
                // Get PlanSection -> .setAttr. (col: additionalId = planSectionDef. and String = content (date from PlanITem)
                setAttributeRelatedToPlanSection(planVersion,proposal,"PLAN_SECTION_UPDATED");
            } else if (planVersion.getUpdateType().equalsIgnoreCase("PITCH_UPDATED")){
                // Get pitch from xcolab_PlanDescription and use setAttribute
                setAttributeRelatedToPlanDescription(planVersion,proposal,"PITCH");
            } else if (planVersion.getUpdateType().equalsIgnoreCase("IMAGE_UPDATED")){
                // Get image_id from xcolab_PlanDescription and use setAttribute
                setAttributeRelatedToPlanDescription(planVersion,proposal,"IMAGE_ID");
            } else if (planVersion.getUpdateType().equalsIgnoreCase("PLAN_REVERTED")){
                // IGNORE
            }
        }
    }

    private void setAttributeRelatedToScenario(PlanItem plan, Proposal p, String attribute){
        List<PlanModelRun> pmrs = null;
        try{
            pmrs = PlanModelRunLocalServiceUtil.getAllForPlan(plan);
        } catch(Exception e){
            pushAjaxUpdate("Error while getting ScenarioID " + plan.getPlanId() + ": " + e);
        }

        for(PlanModelRun pmr : pmrs) {
            if (pmr.getPlanVersion() == plan.getVersion()){
                try{
                    PlanType planType = PlanItemLocalServiceUtil.getPlanType(plan);
                    ProposalLocalServiceUtil.setAttribute(plan.getUpdateAuthorId(),p.getProposalId(),ProposalAttributeKeys.SCENARIO_ID,planType.getDefaultModelId(),null,pmr.getScenarioId(),0,dateFix(pmr.getCreated()),false);
                    Map<String, String> attributes = getAttributes(plan); 
                    
                    
                    Map<String, String> planAttributesToCopy = new HashMap<String, String>();
                    planAttributesToCopy.put(ProposalAttributeKeys.SCENARIO_CO2_CONCENTRATION, "CO2_CONCENTRATION");
                    planAttributesToCopy.put(ProposalAttributeKeys.SCENARIO_TEMP_CHANGE, "TEMP_CHANGE");
                    planAttributesToCopy.put(ProposalAttributeKeys.SCENARIO_MITIGATION_COST_NO_ERRORS, "MITIGATION_COST_NO_ERRORS");
                    planAttributesToCopy.put(ProposalAttributeKeys.SCENARIO_DAMAGE_COST, "DAMAGE_COST");
                    for (Map.Entry<String, String> attributeToCopy: planAttributesToCopy.entrySet()) {
                        if (attributes.containsKey(attributeToCopy.getValue())) {
                            ProposalLocalServiceUtil.setAttribute(plan.getUpdateAuthorId(),p.getProposalId(),attributeToCopy.getKey(),
                                    planType.getModelId(), attributes.get(attributeToCopy.getValue()),0, 0,dateFix(pmr.getCreated()),false);
                        }
                    }
                } catch(Exception e){
                    pushAjaxUpdate("Error while setting ScenarioID " + plan.getPlanId() + ": " + e);
                }
                break;
            }
        }
    }

    private void setAttributeRelatedToPlanMeta(PlanItem plan, Proposal p, String attribute){
        List<PlanMeta> planMetas = null;
        try{
            planMetas = PlanMetaLocalServiceUtil.getAllForPlan(plan);
        } catch(Exception e){
            pushAjaxUpdate("Error while getting description record " + plan.getPlanId() + ": " + e);
        }

        for(PlanMeta planMeta : planMetas) {
            if (planMeta.getPlanVersion() == plan.getVersion()){
                try{
                    if(attribute.equalsIgnoreCase("PLAN_OPENED") || attribute.equalsIgnoreCase("PLAN_CLOSED"))
                        ProposalLocalServiceUtil.setAttribute(plan.getUpdateAuthorId(),p.getProposalId(),ProposalAttributeKeys.OPEN,0,null,planMeta.getOpen() ? 1 : 0,0,dateFix(plan.getUpdated()),false);
                } catch(Exception e){
                    pushAjaxUpdate("Error while setting Attribute " + plan.getPlanId() + ": " + e);
                }
                break;
            }
        }
    }

    private void setAttributeRelatedToPlanSection(PlanItem plan, Proposal p, String attribute){

        List<PlanSection> planSections = OldPersistenceQueries.getPlanSectionsForPlan(plan);

        if (planSections == null) {
            pushAjaxUpdate("Error while getting PlanSections");
            return;
        }

        for(PlanSection planSection :  planSections) {
            try{
                ProposalLocalServiceUtil.setAttribute(plan.getUpdateAuthorId(),p.getProposalId(),ProposalAttributeKeys.SECTION,
                        planSection.getPlanSectionDefinitionId(),planSection.getContent(),0,0,dateFix(plan.getUpdated()),false);
            } catch (Exception e){
                pushAjaxUpdate("Error while setting Section " + plan.getPlanId() + ": " + e);
                e.printStackTrace();
            }
        }
    }

    private void setAttributeRelatedToPlanDescription(PlanItem plan, Proposal p, String attribute){


        List<PlanDescription> planDescriptions = null;
        try{
            planDescriptions = PlanDescriptionLocalServiceUtil.getAllForPlan(plan);
        } catch(Exception e){
            pushAjaxUpdate("Error while getting description record " + plan.getPlanId() + ": " + e);
        }

        boolean oldContest = false; // old contests have inconsistencies, therefore migrate all attributes to assure proper migration
        try{
            oldContest = !ContestLocalServiceUtil.isActive(PlanItemLocalServiceUtil.getContest(plan)) && (planDescriptions.size() == 1) || (PlanItemLocalServiceUtil.getContest(plan).getContestPK() == 3);
        } catch (Exception e) { e.printStackTrace(); }

        Collections.reverse(planDescriptions);
        int i = -1;
        for(PlanDescription planDescription : planDescriptions) {
            if (planDescription.getPlanVersion() == plan.getVersion() || planDescriptions.size() == 1 || oldContest){
                boolean nameChanged = (planDescription.getName() != null) && (i==-1 || (planDescription.getName().compareTo(planDescriptions.get(i).getName()) != 0));
                boolean descriptionChanged = (planDescription.getDescription() != null) && (i==-1 || (planDescription.getDescription().compareTo(planDescriptions.get(i).getDescription()) != 0));
                boolean pitchChanged = (planDescription.getPitch() != null) && (i==-1 || (planDescription.getPitch().compareTo(planDescriptions.get(i).getPitch()) != 0));
                boolean imageChanged = (planDescription.getImage() != 0) && (i==-1 || (planDescription.getImage() != planDescriptions.get(i).getImage()));

                try{
                    if(nameChanged || attribute.equalsIgnoreCase(ProposalAttributeKeys.NAME)){
                        ProposalLocalServiceUtil.setAttribute(plan.getUpdateAuthorId(),p.getProposalId(),ProposalAttributeKeys.NAME,0,planDescription.getName(),0,0,dateFix(planDescription.getCreated()),false);
                    }
                    if(descriptionChanged || attribute.equalsIgnoreCase(ProposalAttributeKeys.DESCRIPTION)){
                        ProposalLocalServiceUtil.setAttribute(plan.getUpdateAuthorId(),p.getProposalId(),ProposalAttributeKeys.DESCRIPTION,0,planDescription.getDescription(),0,0,dateFix(planDescription.getCreated()),false);
                    }
                    if(pitchChanged || attribute.equalsIgnoreCase(ProposalAttributeKeys.PITCH)){
                        ProposalLocalServiceUtil.setAttribute(plan.getUpdateAuthorId(),p.getProposalId(),ProposalAttributeKeys.PITCH,0,planDescription.getPitch(),0,0,dateFix(planDescription.getCreated()),false);
                    }
                    if(imageChanged || attribute.equalsIgnoreCase(ProposalAttributeKeys.IMAGE_ID)){
                        ProposalLocalServiceUtil.setAttribute(plan.getUpdateAuthorId(),p.getProposalId(),ProposalAttributeKeys.IMAGE_ID,0,null,planDescription.getImage(),0,dateFix(planDescription.getCreated()),false);
                    }
                } catch(Exception e){
                    pushAjaxUpdate("Error while setting Attribute " + plan.getPlanId() + ": " + e);
                }
                //break;
            }
            i++;
        }
    }

    private void copySubscribers(PlanItem plan, Proposal p){
        List<User> subscribers = null;
        try{
            subscribers = ActivitySubscriptionLocalServiceUtil.getSubscribedUsers(PlanItem.class,plan.getPlanId());
        } catch (Exception e){ e.printStackTrace(); }

        if (subscribers == null || subscribers.size() < 1) return;

        for (User u : subscribers){
            try{
                ProposalLocalServiceUtil.subscribe(p.getProposalId(),u.getUserId());
            } catch (Exception e){ e.printStackTrace(); }
        }
    }

    private void createSupporters(PlanItem plan, Proposal proposal, List<Long> proposalSupporter){
        List<PlanFan> planFans = null;
        long contestPhase = 0;
        try{
            planFans = PlanFanLocalServiceUtil.getPlanFansForPlan(plan.getPlanId());
        } catch (Exception e){
            pushAjaxUpdate("Error while getting Fans " + plan.getPlanId() + ": " + e);
            return;
        }

        for (PlanFan planFan : planFans){
            // add supporter if not already added
            if (!proposalSupporter.contains(planFan.getUserId()) && planFan.getDeleted() == null){
                ProposalSupporter supporter = ProposalSupporterLocalServiceUtil.create(proposal.getProposalId(),planFan.getUserId());
                supporter.setCreateDate(planFan.getCreated());
                try{
                    ProposalSupporterLocalServiceUtil.addProposalSupporter(supporter);
                } catch (Exception e){
                    pushAjaxUpdate("Error while persisting Supporters " + plan.getPlanId() + ": " + e);
                    return;
                }
                proposalSupporter.add(planFan.getUserId());
            }
        }
    }

    private void createRibbons(PlanItem plan, Proposal p){
        Pair<Long,String> ribbon = OldPersistenceQueries.getRibbonAndHoverTextForPlan(plan);

        if (ribbon == null) return;

        PlanMeta currentPlanMeta = null;
        // Get current plan meta for setting proposal entity attributes
        try{
            currentPlanMeta = PlanMetaLocalServiceUtil.getCurrentForPlan(plan);
        } catch (Exception e){
            pushAjaxUpdate("Error while getting PlanMetas " + plan.getId() + ": " + e);
            return;
        }

        long ribbonContestPhaseAttributeTypeId = NewPersistenceQueries
                .getContestPhaseRibbonTypeIdForRibbon(ribbon.getLeft().intValue(), ribbon.getRight());

        if (ribbonContestPhaseAttributeTypeId > 0){
            // Create new ContestPhaseAttribute
            NewPersistenceQueries.associateProposalWithRibbon(
                    p.getProposalId(), ribbonContestPhaseAttributeTypeId, currentPlanMeta.getContestPhase());
        } else {
            // Set up new ContestPhaseAttributeType
            ContestPhaseRibbonType ribbonType = NewPersistenceQueries
                    .createNewContestPhaseRibbonType(ribbon.getLeft() + "", ribbon.getRight());
            if (ribbonType == null){
                pushAjaxUpdate("Error while creating AttributeType");
                return;
            }
            // Create new ContestPhaseAttribute
            NewPersistenceQueries.associateProposalWithRibbon(
                    p.getProposalId(), ribbonType.getId(), currentPlanMeta.getContestPhase());
        }

    }

    // fix for promotion in old contests

    private void promoteProposalsInOldContestByOnePhase(long contestPhaseIdFrom){

        try{
            ContestPhase current = ContestPhaseLocalServiceUtil.getContestPhase(contestPhaseIdFrom);
            ContestPhase next =  ContestPhaseLocalServiceUtil.getNextContestPhase(current);

            List<Proposal> proposals = ProposalLocalServiceUtil.getProposalsInContestPhase(current.getContestPhasePK());
            for (Proposal p : proposals){
                Proposal2Phase currentp2p = Proposal2PhaseLocalServiceUtil.getByProposalIdContestPhaseId(p.getProposalId(),current.getContestPhasePK());
                currentp2p.setVersionTo(p.getCurrentVersion());
                Proposal2PhaseLocalServiceUtil.updateProposal2Phase(currentp2p);

                Proposal2Phase newp2p = Proposal2PhaseLocalServiceUtil.create(p.getProposalId(),next.getContestPhasePK());
                newp2p.setSortWeight(1);
                newp2p.setAutopromoteCandidate(false);
                newp2p.setVersionFrom(p.getCurrentVersion());
                newp2p.setVersionTo(-1);

                Proposal2PhaseLocalServiceUtil.updateProposal2Phase(newp2p);
            }

        } catch (Exception e){ e.printStackTrace(); }
    }

    private void fixMinorInconsistencies(){
        try{
            // delted and wrong version: this proposal "doesnt show up in production /web/guest/plans/-/plans/contestId/2/phaseId/3/planId/12201"
            PlanItem pi = PlanItemLocalServiceUtil.getPlanItem(33110);
            pi.setVersion(9);
            PlanItemLocalServiceUtil.updatePlanItem(pi);

        } catch (Exception e){
            e.printStackTrace();
        }
    }







    private void pushAjaxUpdate(String message){
        reference.add(message);
        SessionRenderer.render("migration");
    }

    private void updateLastAjaxUpdate(String message){
        reference.remove(reference.size()-1);
        reference.add((message));
        SessionRenderer.render("migration");
    }
    

    private Map<String, String> getAttributes(PlanItem plan) throws SystemException, PortalException {
        // if (planAttributes == null) {
        Map<String, String> planAttributes = new HashMap<String, String>();
        for (PlanAttribute attr : PlanItemLocalServiceUtil.getPlanAttributes(plan)) {
            planAttributes.put(attr.getAttributeName(), attr.getAttributeValue());
        }

        for (PlanConstants.Columns column : PlanConstants.Columns.values()) {
            planAttributes.put(column.name(), column.getValue(plan));
        }
        // }
        return planAttributes;

    }



    private void copyMetaInfo(PlanItem plan, Proposal p){
        // get updated proposal
        try {
            p = ProposalLocalServiceUtil.getProposal(p.getProposalId());
        } catch (Exception e){
            pushAjaxUpdate("Error while updating Proposal " + e);
        }
        PlanMeta currentPlanMeta = null;
        PlanItem currentPlanItem = null;
        // get current plan meta for setting proposal entity attributes
        try{
            currentPlanMeta = PlanMetaLocalServiceUtil.getCurrentForPlan(plan);
            currentPlanItem = PlanItemLocalServiceUtil.getAllVersions(plan).get(0);
        } catch (Exception e){
            pushAjaxUpdate("Error while getting PlanMeta " + plan.getId() + ": " + e);
            return;
        }
        if (currentPlanMeta != null) {
            p.setDiscussionId(currentPlanMeta.getCategoryGroupId());
            p.setGroupId(currentPlanMeta.getPlanGroupId());
        }
        if (currentPlanItem != null) p.setUpdatedDate(currentPlanItem.getUpdated());
        // update proposal
        try {
            ProposalLocalServiceUtil.updateProposal(p);
        } catch (Exception e){
            pushAjaxUpdate("Error while updating Proposal " + e);
        }

    }

    private Date dateFix(Date d){
        counter = (++counter) % 300;
        return new Date(d.getTime() + counter);
    }





}