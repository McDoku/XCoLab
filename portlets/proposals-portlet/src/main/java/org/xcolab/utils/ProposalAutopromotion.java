package org.xcolab.utils;


import com.ext.portlet.model.Contest;
import com.ext.portlet.service.ActivitySubscriptionLocalServiceUtil;
import com.ext.portlet.service.ContestLocalServiceUtil;
import com.ext.portlet.service.ContestPhaseLocalServiceUtil;
import com.ext.portlet.service.ProposalLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.messaging.MessageListenerException;

import java.util.List;

public class ProposalAutopromotion implements MessageListener {

    @Override
    public void receive(Message message) throws MessageListenerException {
        try {
            ContestPhaseLocalServiceUtil.autoPromoteProposals();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
