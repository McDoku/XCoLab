package org.xcolab.portlets.loginregister.activity;

import com.ext.portlet.community.CommunityUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.User;
import com.liferay.portlet.social.model.SocialActivity;

public enum LoginRegisterActivityKeys {
    USER_REGISTERED(1, "New account created", "%s joined ClimateColab community");
    private static Log _log = LogFactoryUtil.getLog(LoginRegisterActivityKeys.class);

    private final int type;
    private final String title;
    private final String body;

    private LoginRegisterActivityKeys(int type, String title, String body) {
        this.type = type;
        this.title = title;
        this.body = body;
    }

    public static LoginRegisterActivityKeys getForType(int type) {
        for (LoginRegisterActivityKeys key : LoginRegisterActivityKeys.values()) {
            if (key.type == type)
                return key;
        }
        return null;
    }

    public int getType() {
        return type;
    }

    public String getTitle(User user) {
        return String.format(title, getUserLink(user));
    }

    public String getBody(User user) {
        return String.format(body, getUserLink(user));
    }

    private String getUserLink(User user) {
        String result = "<user removed>";
        try {
            return CommunityUtil.generateUserURL(user.getUserId());
        } catch (PortalException e) {
            _log.info(e.getMessage());
        } catch (SystemException e) {
            _log.info(e.getMessage());
        }
        return result;
    }
}
