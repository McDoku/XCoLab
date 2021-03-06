package org.xcolab.portlets.proposals.activity.generators;

import org.xcolab.portlets.proposals.activity.ProposalActivityFeedEntryGenerator;
import org.xcolab.portlets.proposals.utils.ProposalsURLGenerator;
import org.xcolab.portlets.proposals.wrappers.ProposalWrapper;

import com.ext.portlet.model.Proposal;
import com.ext.portlet.service.ProposalLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portlet.social.model.SocialActivity;

public abstract class BaseProposalsFeedEntryGenerator implements ProposalActivityFeedEntryGenerator {

    private final static String hyperlink = "<a href=\"%s\">%s</a>";
    
    
    public Proposal getProposal(SocialActivity activity) throws PortalException, SystemException {
        return ProposalLocalServiceUtil.getProposal(activity.getClassPK());
    }
    
    public String getProposalLink(Proposal proposal) throws PortalException, SystemException {
        ProposalWrapper wrapper = new ProposalWrapper(proposal);
        return String.format(hyperlink,ProposalsURLGenerator.getProposalURL(proposal), wrapper.getName()); 
    }
    
    public String getUserLink(long userId) throws PortalException, SystemException {
        if (userId <= 0) return StringPool.BLANK;
        User u = UserLocalServiceUtil.getUserById(userId);
        String url = "<a href='" + ProposalsURLGenerator.getUserURL(userId)+ "'>" + u.getScreenName()+ "</a>";
        return url;
    }

}
