package com.zwb.action;

import java.util.List;

import com.opensymphony.xwork2.Action;
import com.zwb.beans.User;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;



public class AjaxTestAction implements Action {



	private String param1;
	//private String param2;	


	








//	public String getParam2() {
//		return param2;
//	}
//
//
//
//
//
//
//	public void setParam2(String param2) {
//		this.param2 = param2;
//	}






	public String getParam1() {
		return param1;
	}






	public void setParam1(String param1) {
		this.param1 = param1;
	}






	public String execute() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("=====>111");
//		User userinfo = new User();
//		userinfo.setUserId("id123");
//		userinfo.setUsername("uzzzzz");
//		User userinfo2 = new User();
//		userinfo2.setUserId("id123");
//		userinfo2.setUsername("uzzzzz");
//		List<User> list = new ArrayList<User>();
//		list.add(userinfo);
//		list.add(userinfo2);
//		param2 = "test2";
		param1 = "test1";
		
		

		System.out.println("=====>");

		return "success";
	}


	public String test1() throws Exception {
		System.out.println("in test1");
		return "success";
	}

























}
