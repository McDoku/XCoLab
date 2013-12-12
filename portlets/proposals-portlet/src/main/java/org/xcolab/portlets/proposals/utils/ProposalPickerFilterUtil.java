package org.xcolab.portlets.proposals.utils;

import com.ext.portlet.NoSuchProposalContestPhaseAttributeException;
import com.ext.portlet.ProposalAttributeKeys;
import com.ext.portlet.model.FocusArea;
import com.ext.portlet.model.OntologyTerm;
import com.ext.portlet.service.*;


import java.util.ArrayList;


import org.apache.commons.lang3.StringUtils;
import com.ext.portlet.model.Proposal;
import org.apache.commons.lang3.tuple.Pair;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: patrickhiesel
 * Date: 04/12/13
 * Time: 10:25
 * To change this template use File | Settings | File Templates.
 */
public enum ProposalPickerFilterUtil {

    // why are lamdba expressions not supported here?
    ACCEPTALL(new ProposalPickerFilter() {
        @Override
        public void filter(List<Pair<Proposal,Date>> proposals, Object additionalFilterCriterion) {
            // do not modify the list
        }
    }),
    TEXTBASED(new ProposalPickerFilter() {
        @Override
        public void filter(List<Pair<Proposal,Date>> proposals, Object additionalFilterCriterion) {
            if (!(additionalFilterCriterion instanceof String)) return;
            String searchCriterion = (String) additionalFilterCriterion;
            for (Iterator<Pair<Proposal,Date>> i = proposals.iterator(); i.hasNext();){
                Proposal p = i.next().getLeft();
                 try{
                     // PROPOSAL NAME
                     String proposalName = ProposalLocalServiceUtil.getAttribute(p.getProposalId(), ProposalAttributeKeys.NAME,0l).getStringValue();
                     if (StringUtils.containsIgnoreCase(proposalName,searchCriterion)){
                         continue;
                     }
                     // CONTEST NAME
                     String contestName = Proposal2PhaseLocalServiceUtil.getCurrentContestForProposal(p.getProposalId()).getContestName();
                     if (StringUtils.containsIgnoreCase(contestName,searchCriterion)){
                         continue;
                     }
                     // Remove element if it does not match any criterion
                     i.remove();
                 } catch (Exception e){ /* LR EXCEPTIONS */e.printStackTrace(); }
            }

        }
    }),
    WINNERSONLY(new ProposalPickerFilter() {
        @Override
        public void filter(List<Pair<Proposal, Date>> proposals, Object additionalFilterCriterion) {
            for (Iterator<Pair<Proposal,Date>> i = proposals.iterator(); i.hasNext();){
                Proposal p = i.next().getLeft();
                try{
                    List<Long> phases = Proposal2PhaseLocalServiceUtil.getContestPhasesForProposal(p.getProposalId());
                    boolean winner = false;
                    for (long phase : phases){
                        try{
                            ProposalContestPhaseAttributeLocalServiceUtil.getProposalContestPhaseAttribute(p.getProposalId(),phase,"RIBBON");
                            winner = true;
                        }catch (NoSuchProposalContestPhaseAttributeException nspcpae){ /* NO WINNER */ }
                    }
                    if (!winner) i.remove();
                } catch (Exception e){ /* LR EXCEPTIONS */e.printStackTrace(); }
            }
        }
    }),
    ONTOLOGY(new ProposalPickerFilter() {
        @Override
        public void filter(List<Pair<Proposal, Date>> proposals, Object additionalFilterCriterion) {
            long sectionId = (Long) additionalFilterCriterion;
            /*
            try{
                // section definition Id
                long definitionId = PlanSectionLocalServiceUtil.getPlanSection(sectionId).getPlanSectionDefinitionId();
                // FocusArea
                FocusArea fa = PlanSectionDefinitionLocalServiceUtil.getFocusArea(PlanSectionDefinitionLocalServiceUtil.getPlanSectionDefinition(definitionId));
                // List of terms in this area
                List<OntologyTerm> terms = FocusAreaLocalServiceUtil.getTerms(fa);
                // get all children
                for (OntologyTerm ot : terms){
                    List<OntologyTerm> childTerms = OntologyTermLocalServiceUtil.getChildTerms(ot);
                    for (OntologyTerm child : terms){
                        // now what?
                    }
                }
            } catch (Exception e){

            }
        */
        }
    });

    private final ProposalPickerFilter proposalPickerFilter;

    private ProposalPickerFilterUtil(ProposalPickerFilter proposalPickerFilter) {
        this.proposalPickerFilter = proposalPickerFilter;
    }

    public ProposalPickerFilter getProposalPickerFilter() {
        return proposalPickerFilter;
    }

    // CONVENIENCE METHODS
    public void filter(List<Pair<Proposal,Date>> proposals){
        this.getProposalPickerFilter().filter(proposals, null);
    }

    public void filter(List<Pair<Proposal,Date>> proposals, Object additionalFilterCriterion){
        this.getProposalPickerFilter().filter(proposals, additionalFilterCriterion);
    }

    // PARSE FILTER FROM FRONT END PARAMETER
    public static ProposalPickerFilterUtil getFilterByParameter(String filterKey) {
        if (filterKey == null) return ACCEPTALL;
        if (filterKey.equalsIgnoreCase("WINNERSONLY")) return WINNERSONLY;
        return ACCEPTALL;
    }

}
