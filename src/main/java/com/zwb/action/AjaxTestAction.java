package com.zwb.action;

import com.opensymphony.xwork2.Action;
import com.zwb.beans.User;

import net.sf.json.JSONObject;

public class AjaxTestAction implements Action {

	private User user;
	private String jsonString;
	
	public String getJsonString() {
		return jsonString;
	}



	public void setJsonString(String jsonString) {
		this.jsonString = jsonString;
	}



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}

	public String execute() throws Exception {
		// TODO Auto-generated method stub
		System.out.println(user.getUsername());
		JSONObject userjson = JSONObject.fromObject(user);
		System.out.println(userjson);
		jsonString = userjson.toString();
		return "postuser";
	}









}
