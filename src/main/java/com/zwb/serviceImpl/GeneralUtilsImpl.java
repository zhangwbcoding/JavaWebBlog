package com.zwb.serviceImpl;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.zwb.beans.User;
import com.zwb.service.GeneralUtils;

public class GeneralUtilsImpl implements GeneralUtils {

	public static final String USER_COOKIE = "user_cookie";
	
	public Cookie addCookie(User user) {
		// TODO Auto-generated method stub
		 Cookie cookie = new Cookie(USER_COOKIE, user.getUsername() + "&"  
	                + user.getUserId());  
	        System.out.println("添加cookie");  
	        cookie.setMaxAge(86400*2);// cookie保存两周  
	        return cookie;  

	}

	public Cookie getCookie(HttpServletRequest request,String cookiename) {
		// TODO Auto-generated method stub
		 Cookie[] cookies = request.getCookies();  
	        System.out.println("cookies: " + cookies);  
	        if (cookies != null) {  
	            for (Cookie cookie : cookies) {  
	                System.out.println("cookie: " + cookie.getName());  
	                if (cookiename.equals(cookie.getName())) {  
	                    	String value = cookie.getValue();    
	                    	if(value!=null){
	                    		return cookie;
	                    	}
  
	                    }  
	                }  
	            }  
	         
	        return null;  
	}

	public Cookie deleteCookie(HttpServletRequest request,String cookiename) {
		// TODO Auto-generated method stub
		Cookie[] cookies = request.getCookies();  
        if (cookies != null) {  
            for (Cookie cookie : cookies) {  
                if (cookiename.equals(cookie.getName())) {  
                    cookie.setValue(null);  
                    cookie.setMaxAge(0);  
                    return cookie;  
                }  
            }  
        }  
        return null;  
    }

	public HttpServletResponse getResponse() {
		// TODO Auto-generated method stub
		return ServletActionContext.getResponse();
	}

	public HttpServletRequest getRequest() {
		// TODO Auto-generated method stub
		return ServletActionContext.getRequest();
	}

	public HttpSession getSession() {
		// TODO Auto-generated method stub
		return getRequest().getSession();
	}

	public void sessionSet(String attrName, Object arg) {
		// TODO Auto-generated method stub
		getSession().setAttribute(attrName, arg);
	}

	public Object sessionGet(String attrName) {
		// TODO Auto-generated method stub
		return getSession().getAttribute(attrName);
	}

	public void sessionRemove(String attrName) {
		// TODO Auto-generated method stub
		getSession().removeAttribute(attrName);
	}  
	
	

		



}
