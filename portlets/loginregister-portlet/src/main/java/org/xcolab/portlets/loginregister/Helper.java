package org.xcolab.portlets.loginregister;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;

import javax.portlet.ActionRequest;

import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;

public class Helper {
    
    public static String removeParamFromRequestStr(String requestStr, String param) {
        return requestStr == null ? null : requestStr.replaceAll("&?" + param + "=[^&#]*", "");
    }
    
    public static String modifyRedirectUrl(String redirect, ActionRequest actionRequest, Map<String, String> parameters) 
    throws UnsupportedEncodingException {

        // add error messages to redirect url
        StringBuilder sb = new StringBuilder();
        // remove error info from url
        String[] locationAndHash = redirect.split("#");
        String[] locationAndQueryString = locationAndHash[0].split("\\?");
        
        sb.append(locationAndQueryString[0]);
        sb.append("?");
        

        if (locationAndQueryString.length > 1 && locationAndQueryString[1].length() > 0) {
            sb.append(locationAndQueryString[1]);
            sb.append("&");
        }
        
        
        Iterator<String> iter = SessionErrors.iterator(actionRequest);
        boolean appendAnd = false;
        
        while (iter.hasNext()) {
            if (appendAnd) {
                sb.append("&");
            }
            
            sb.append("signinRegError=");
            String exception = iter.next();
            sb.append(exception.substring(exception.lastIndexOf(".") + 1));
            
            appendAnd = true;
        }
        
        for (String key: parameters.keySet()) {
            if (appendAnd) {
                sb.append("&");
            }
            appendAnd = true;
            sb.append(key + "=" + URLEncoder.encode(parameters.get(key), "UTF-8"));
        }
        
        if (locationAndHash.length > 1) {
            sb.append("#");
            sb.append(locationAndHash[1]);
        }

        redirect = sb.toString();
        
        return redirect;
    }
}
