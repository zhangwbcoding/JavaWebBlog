package com.zwb.action;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.opensymphony.xwork2.Action;
import com.zwb.beans.User;
import com.zwb.serviceImpl.GeneralUtilsImpl;
import com.zwb.serviceImpl.UserServiceImpl;

public class LoginAction implements Action {

	 private User user;
     private UserServiceImpl us;
     private GeneralUtilsImpl gu;
     private String tip;
     private boolean autologin;


     	public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}
		public void setUs(UserServiceImpl us){
			this.us=us;
		}
		public String getTip() {
			return tip;
		}

		public void setTip(String tip) {
			this.tip = tip;
		}
		public boolean getAutologin() {
			return autologin;
		}

		public void setAutologin(boolean autologin) {
			this.autologin = autologin;
		}
		public GeneralUtilsImpl getGu() {
			return gu;
		}

		public void setGu(GeneralUtilsImpl gu) {
			this.gu = gu;
		}


 
	    public String execute() throws Exception {  
	        // TODO Auto-generated method stub
	      if (us.checkUser(user)){
	    	  System.out.println("用户检测通过");
	    	  setUser(us.getUserByName(user.getUsername()));
	    	  HttpServletResponse response = gu.getResponse();
	    	  gu.sessionSet("username", user.getUsername());
	    	  gu.sessionSet("userid", user.getUserId());
	    	  if(getAutologin()){
		    	 Cookie cookie = gu.addCookie(user);
		    	 if(cookie!=null){
		    		 response.addCookie(cookie);
		    	 }
		    	 
	    	  }
	    	  return SUCCESS;
	      }
	      else{
	    	  return "login";
	      }
	  }
	    
	    public String loginout() throws Exception{
			if((String)gu.sessionGet("username")!=null){
				System.out.println("移除seesion记录 cookie");
				HttpServletRequest request = gu.getRequest();
				gu.sessionRemove("username");
				gu.sessionRemove("userid");
				Cookie user_cookie = gu.getCookie(request, GeneralUtilsImpl.USER_COOKIE);
				if (user_cookie!=null){
					Cookie c = gu.deleteCookie(request, GeneralUtilsImpl.USER_COOKIE);
					gu.getResponse().addCookie(c);
				}
				
			}
			return SUCCESS;
		}
	    	
		public String register() throws Exception {
			// TODO Auto-generated method stub
			if(!us.userExistOrNot(user)){
				us.saveUser(user);
				return SUCCESS;
			}
			else{
				tip="用户已存在！注册失败！";
				return ERROR;
			}
		}





	    
	}





		

