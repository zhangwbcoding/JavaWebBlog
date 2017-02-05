package com.zwb.service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import com.zwb.beans.User;

public interface GeneralUtils {
	public Cookie addCookie(User user);
	public Cookie getCookie(HttpServletRequest request,String cookiename);
	public Cookie deleteCookie(HttpServletRequest request,String cookiename);
	public void sessionSet(String attrName,Object arg);
	public Object sessionGet(String attrName);
	public void sessionRemove(String attrName);
	
}
