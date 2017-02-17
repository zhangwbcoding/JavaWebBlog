package com.zwb.action;

import java.io.Serializable;
import java.util.regex.Pattern;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.opensymphony.xwork2.ActionSupport;
import com.zwb.beans.User;
import com.zwb.serviceImpl.GeneralUtilsImpl;
import com.zwb.serviceImpl.UserServiceImpl;

public class LoginAction  extends ActionSupport implements Serializable{

	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */

		private User user;
		private String check_result;
		private UserServiceImpl us;
		private GeneralUtilsImpl gu;
		private String tip;
		private boolean autologin;


		
     	public String getCheck_result() {
			return check_result;
		}

		public void setCheck_result(String check_result) {
			this.check_result = check_result;
		}

		public UserServiceImpl getUs() {
			return us;
		}

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
		
		
		
		//注册表单验证
		public void validateRegister(){                        
			System.out.println("in validate");
			System.out.println(user.getUsername());
			Pattern unameReg = Pattern.compile("[a-zA-Z]{1}[a-zA-Z0-9_]{1,15}");
			Pattern pwReg = Pattern.compile("[a-zA-Z0-9]{1,16}");
			if (user.getUsername()==null||"".equals(user.getUsername())){
				addFieldError("username","用户名不能为空！");
			}
			if(!unameReg.matcher(user.getUsername()).matches()){
				addFieldError("username","用户名必须由字母数字下划线组成且开头必须是字母，不能超过16位！");
			}
			if(user.getPassword()==null||"".equals(user.getPassword()))
				addFieldError("password","密码不能为空！");
			if(!pwReg.matcher(user.getPassword()).matches()){
				addFieldError("password","密码由字母和数字构成，不能超过16位！");
			}
		}
 
		
		//登录action
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
	    
	    
	    //登出action
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
	    	
	    //注册action
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
		
		public String checkUsername() throws Exception{
			if( us.userExistOrNot(user)){
				 check_result = "该用户名已被注册！";
			}
			else{
				check_result = "该用户名可以使用！";
			}
			return "success";
		}





	    
	}





		

