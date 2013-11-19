
package org.xcolab.portlets.proposals.view;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.ext.portlet.service.ContestPhaseLocalServiceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.xcolab.portlets.proposals.requests.UpdateProposalDetailsBean;
import org.xcolab.portlets.proposals.utils.ProposalsContext;
import org.xcolab.portlets.proposals.wrappers.ProposalWrapper;

import com.ext.portlet.model.Proposal;
import com.ext.portlet.service.ProposalLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;

@Controller
@RequestMapping("view")
public class CreateProposalController extends BaseProposalsController {
    
    @Autowired
    private ProposalsContext proposalsContext;

    @RequestMapping(params = "pageToDisplay=createProposal")
    public String showContestProposals(RenderRequest request, RenderResponse response, 
            @RequestParam Long contestId, Model model) 
            throws PortalException, SystemException {

        if(!proposalsContext.getPermissions(request).getCanCreate()) throw new IllegalAccessError("creation not allowed");

        ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
        
        Proposal proposal = ProposalLocalServiceUtil.createProposal(0);
        proposal.setVisible(true);
        proposal.setAuthorId(themeDisplay.getUserId());
        
        ProposalWrapper proposalWrapped = new ProposalWrapper(proposal, 0, proposalsContext.getContest(request), proposalsContext.getContestPhase(request), null);

        model.addAttribute("updateProposalSectionsBean", new UpdateProposalDetailsBean(proposalWrapped));
        
        model.addAttribute("proposal", proposalWrapped);

        setSeoTexts(request, "Create proposal in " + proposalsContext.getContest(request), null, null);
        
        return "proposalDetails_edit";
    }
}