package com.zwb.serviceImpl;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.zwb.beans.User;
import com.zwb.service.GeneralUtils;

public class GeneralUtilsImpl implements GeneralUtils {

	public static final String USER_COOKIE = "user_cookie";
	private static final String SALT = "zwb_javablog";
	
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

	public String timeConvert(String rowTime) {
		// TODO Auto-generated method stub
		Calendar calendar =  Calendar.getInstance();
		Long now = calendar.getTime().getTime();
		Long time =  Long.parseLong(rowTime);
		Long delta = now-time;
		if (delta<=1000*60){
			return "1分钟前";
		}
		else if (delta<=1000*60*5){
			return "5分钟前";
		}
		else if (delta <= 1000*60*10){
			return "10分钟前";
		}
		else if (delta<=1000*60*15){
			return "15分钟前";
		}
		else if (delta<=1000*60*30){
			return "30分钟前";
		}
		else{
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日  HH:mm:ss");
			
			return sdf.format(new Date(time));
		}
	}


	private  String bytes2Hex(byte[] bts) {  
        StringBuffer des = new StringBuffer();  
        String tmp = null;  
        for (int i = 0; i < bts.length; i++) {  
            tmp = (Integer.toHexString(bts[i] & 0xFF));  
            if (tmp.length() == 1) {
                des.append("0");
            }  
            des.append(tmp);
        }  
        return des.toString();
    }
	
	@SuppressWarnings("finally")
	public String string2MD5(String strSrc) {
		// TODO Auto-generated method stub
		strSrc += SALT;
		String strDes = null;
		try{
			MessageDigest md = MessageDigest.getInstance("MD5"); 
	        byte[] bt = strSrc.getBytes();  
	        md.update(bt);  
	        strDes = bytes2Hex(md.digest()); // to HexString  
		}catch(NoSuchAlgorithmException ne){
			ne.printStackTrace();
		}finally{
			System.out.println("in string2MD5:" + strDes );
			return strDes;
		}
	}  
	

		



}
