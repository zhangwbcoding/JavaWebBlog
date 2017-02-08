package com.zwb.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.Action;
import com.zwb.beans.User;

import net.sf.json.JSONArray;

public class AjaxTestAction implements Action {


	private JSONArray resultTree;

	
	
	public JSONArray getResultTree() {
		return resultTree;
	}



	public void setResultTree(JSONArray resultTree) {
		this.resultTree = resultTree;
	}

	public String execute() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("=====>111");
		List<User> list = new ArrayList<User>();
		User u1 = new User();
		u1.setUserId("12345");
		u1.setUsername("zwb1");
		list.add(u1);
		JSONArray jsa = JSONArray.fromObject(list);
		resultTree = jsa;
		System.out.println("=====>");
		System.out.println(resultTree);
		return "success";
	}













}
