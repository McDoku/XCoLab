package org.xcolab.portlets.proposals.view.action;

import com.ext.portlet.NoSuchContestPhaseRibbonTypeException;
import com.ext.portlet.proposal.ProposalContestPhaseAttributeKeys;
import com.ext.portlet.service.ContestPhaseLocalServiceUtil;
import com.ext.portlet.service.ContestPhaseRibbonTypeLocalServiceUtil;
import com.ext.portlet.service.ProposalContestPhaseAttributeLocalServiceUtil;
import com.ext.portlet.service.ProposalLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.util.mail.MailEngineException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.xcolab.portlets.proposals.exceptions.ProposalsAuthorizationException;
import org.xcolab.portlets.proposals.utils.ProposalsContext;

import javax.mail.internet.AddressException;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

@Controller
@RequestMapping("view")
public class ForceJudgingOnProposalActionController {

    @Autowired
    private ProposalsContext proposalsContext;
    
    @RequestMapping(params = {"action=forceJudgingExecution"})
    public void handleAction(ActionRequest request, Model model, ActionResponse response)
                    throws PortalException, SystemException, ProposalsAuthorizationException {
        
        if (proposalsContext.getPermissions(request).getCanForceJudgingExecution()) {
            long proposalId = proposalsContext.getProposal(request).getProposalId();
            long contestPhaseId = proposalsContext.getContestPhase(request).getContestPhasePK();

            try {
                ContestPhaseLocalServiceUtil.performJudgeOperation(proposalId, contestPhaseId);
            } catch (Throwable e) {
                e.printStackTrace();
            }
        }
        else {
            throw new ProposalsAuthorizationException("User not allowed to force judging execution");
        }
    }

}