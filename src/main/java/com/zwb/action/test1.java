package com.zwb.action;

import com.opensymphony.xwork2.Action;

public class test1  implements Action {
	/**
	 * 
	 */

	private String username;
	private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

	
	public String execute() throws Exception{
		return SUCCESS;
	}
}
