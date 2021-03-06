package org.xcolab.portlets.messaging;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.faces.event.ActionEvent;
import javax.mail.internet.AddressException;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.model.Role;
import com.liferay.portal.service.RoleLocalServiceUtil;
import org.xcolab.enums.MemberRole;

import com.ext.portlet.messaging.MessageUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.util.mail.MailEngineException;
import org.xcolab.utils.MessageLimitManager;
import org.xcolab.utils.SendMessagePermissionChecker;

public class SendMessageBean implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<User> users;
    private String receipients;
    private String subject;
    private String content;
    private MessagingBean messagingBean;
    private MessageBean replyMessage;
    private SendMessagePermissionChecker permissionChecker;
    
    
    public SendMessageBean() throws SystemException {
        users = UserLocalServiceUtil.getUsers(0, Integer.MAX_VALUE);

        permissionChecker = new SendMessagePermissionChecker(Helper.getLiferayUser());
        List<MemberRole> blacklist = permissionChecker.getBlacklistedMemberRoles();
        List<Long> blacklistedUsers = new ArrayList<>();

        // Get all the userIds which are not accessible for the current user
        for (MemberRole mr : blacklist) {
            for (String name : mr.getRoleNames()) {
                try {
                    Role role = RoleLocalServiceUtil.getRole(GetterUtil.getLong(Helper.getLiferayCompanyId()), name);
                    List<User> users = UserLocalServiceUtil.getRoleUsers(role.getRoleId());
                    for (User user : users) {
                        blacklistedUsers.add(user.getUserId());
                    }
                } catch (PortalException | SystemException e) {
                    // Ignore the role if it cannot get resolved
                }
            }
        }

        DynamicQuery userQuery = DynamicQueryFactoryUtil.forClass(User.class, PortalClassLoaderUtil.getClassLoader());
        if (blacklistedUsers.size() > 0) {
            userQuery.add(RestrictionsFactoryUtil.not(RestrictionsFactoryUtil.in("userId", blacklistedUsers)));
        }
        users = UserLocalServiceUtil.dynamicQuery(userQuery);

        Collections.sort(new ArrayList(users), new Comparator<User>() {

            @Override
            public int compare(User o1, User o2) {
                return o1.getScreenName().compareTo(o2.getScreenName());
            }
        });
    }
    
    public List<User> getUsersList() {
        return users;
    }
    
    public void send(ActionEvent e) throws AddressException, SystemException, PortalException, MailEngineException {
        
        Map<Long, User> usersMap = new HashMap<Long, User>();
        List<Long> recipientIds = new ArrayList<Long>();
        Long userId = Helper.getLiferayUser().getUserId();
        Long mutex = MessageLimitManager.getMutex(userId);
        synchronized (mutex) {
			// Send a validation problem mail to patrick if the daily limit is reached for a user
            if (!MessageLimitManager.canSendMessages(recipientIds.size(), Helper.getLiferayUser())) {
                System.err.println("OBSERVED VALIDATION PROBLEM AGAIN. "+userId);

				// Only send the email once in 24h!
				if (MessageLimitManager.shouldSendValidationErrorMessage(Helper.getLiferayUser())) {
					recipientIds.clear();
					recipientIds.add(1011659L); //patrick
					MessageUtil.sendMessage("VALIDATION PROBLEM  "+subject, "VALIDATION PROBLEM  "+content, userId,
							Helper.getLiferayUser().getUserId(), recipientIds, null);
				}

                return;
            }
        
            for (String recipientId: receipients.split(",")) {
                if (! recipientId.trim().equals("")) {
                    if (permissionChecker.canSendToUser(UserLocalServiceUtil.getUserById(Long.parseLong(recipientId)))) {
                        recipientIds.add(Long.parseLong(recipientId));
                    }
                }
            }
            MessageUtil.sendMessage(subject, content, userId, 
                    Helper.getLiferayUser().getUserId(), recipientIds, null);
        
            messagingBean.messageSent();
        }
        
    }
    
    public void cancel(ActionEvent e) throws PortalException, SystemException {
        messagingBean.toggleSendMessage((MessageBean) null);
    }
    
    public void testAction(ActionEvent e) {
        System.out.println("test");
    }
    
    public void init() {
        content = "";
        subject = "";
        receipients = "";
    }
    
    public void init(MessageBean replyMessage) throws PortalException, SystemException {
        receipients = String.valueOf(replyMessage.getFrom().getUserId());
        
        subject = "RE: " + replyMessage.getSubject();
        content = "\n\n-- original message begin --\n\n" + replyMessage.getContent() + "\n\n-- original message end --\n";
        this.replyMessage = replyMessage;
    }

    public void setReceipients(String receipients) {
        this.receipients = receipients;
    }

    public String getReceipients() {
        return receipients;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setMessagingBean(MessagingBean messagingBean) throws PortalException, SystemException {
        this.messagingBean = messagingBean;
        messagingBean.setSendMessageBean(this);
    }

    public MessagingBean getMessagingBean() {
        return messagingBean;
    }
    
    public MessageBean getReplyMessage() {
        return replyMessage;
    }
    
    // to force screen unblocking
    public int getUnblockScreen() {
        return new Random().nextInt();
    }

}
