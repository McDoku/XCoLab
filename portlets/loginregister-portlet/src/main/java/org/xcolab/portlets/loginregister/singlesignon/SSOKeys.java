package org.xcolab.portlets.loginregister.singlesignon;

/**
 * Created with IntelliJ IDEA.
 * User: patrickhiesel
 * Date: 27/11/13
 * Time: 11:50
 * To change this template use File | Settings | File Templates.
 */
public class SSOKeys {

    public final static String GOOGLE_ENDPOINT = "https://www.google.com/accounts/o8/id";
    public final static String OPEN_ID_RESPONSE_URL = "/web/guest/loginregister/-/login/SSO/google/readresponse";

    // SESSION KEYS
    // Facebook Autologin
    public final static String FACEBOOK_USER_ID = "FACEBOOK_USER_ID";

    // OpenId Autologin
    public final static String OPEN_ID_LOGIN = "OPEN_ID_LOGIN";
    // SSO Credentials
    public final static String SSO_FIRST_NAME = "SSO_FIRST_NAME";
    public final static String SSO_LAST_NAME = "SSO_LAST_NAME";
    public final static String SSO_EMAIL = "SSO_EMAIL";
    public final static String SSO_OPENID_ID = "SSO_OPENID_ID";
    // other
    public final static String OPEN_ID_DISCO = "OPEN_ID_DISCO";
    public final static String SSO_SCREEN_NAME = "SSO_SCREEN_NAME";
    public final static String SSO_PROFILE_IMAGE_ID = "SSO_PROFILE_IMAGE_ID";
}
