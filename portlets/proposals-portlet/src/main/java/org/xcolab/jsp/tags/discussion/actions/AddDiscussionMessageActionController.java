package org.xcolab.jsp.tags.discussion.actions;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.xcolab.analytics.AnalyticsUtil;
import org.xcolab.jsp.tags.discussion.DiscussionPermissions;
import org.xcolab.jsp.tags.discussion.exceptions.DiscussionsException;
import org.xcolab.jsp.tags.discussion.wrappers.NewMessageWrapper;

import com.ext.portlet.model.DiscussionCategoryGroup;
import com.ext.portlet.service.DiscussionCategoryGroupLocalServiceUtil;
import com.ext.portlet.service.ProposalLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;

@Controller
@RequestMapping("view")
public class AddDiscussionMessageActionController extends BaseDiscussionsActionController {
    
    private final static String COMMENT_ANALYTICS_KEY = "COMMENT_CONTEST_ENTRIES";
    private final static String COMMENT_ANALYTICS_CATEGORY = "User";
    private final static String COMMENT_ANALYTICS_ACTION = "Comment on contest entry";
    private final static String COMMENT_ANALYTICS_LABEL = "";

    @RequestMapping(params = "action=addDiscussionMessage")
    public void handleAction(ActionRequest request, ActionResponse response, NewMessageWrapper newMessage)
            throws IOException, PortalException, SystemException, DiscussionsException {

        ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
        DiscussionCategoryGroup dcg = DiscussionCategoryGroupLocalServiceUtil.getDiscussionCategoryGroup(newMessage.getDiscussionId());

        checkPermissions(request, "User isn't allowed to add comment", newMessage.getDiscussionId());
        long userId = themeDisplay.getUser().getUserId();
        
        DiscussionCategoryGroupLocalServiceUtil.addComment(dcg, newMessage.getTitle(), newMessage.getDescription(), themeDisplay.getUser());
        
        int analyticsValue = 0;
        int supportedCount = DiscussionCategoryGroupLocalServiceUtil.getUserMessages(userId);
        if (supportedCount > 0) {
        	if (supportedCount == 1) {
        		analyticsValue = 1;
        	}
        	else if ( supportedCount < 5) {
        		analyticsValue = 2;
        	}
        	else {
        		analyticsValue = 3;
        	}
    	AnalyticsUtil.publishEvent(request, userId, COMMENT_ANALYTICS_KEY + analyticsValue, 
    			COMMENT_ANALYTICS_CATEGORY, 
    			COMMENT_ANALYTICS_ACTION , 
    			COMMENT_ANALYTICS_LABEL, 
    			analyticsValue);
        }
        
        redirectToReferer(request, response);
        
    }

    @Override
    public boolean isUserAllowed(DiscussionPermissions permissions) {
        return permissions.getCanAddComment();
    }

}
