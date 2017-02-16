package com.zwb.action;

import java.util.ArrayList;


import com.opensymphony.xwork2.Action;



public class AjaxTestAction implements Action {


	private ArrayList<String> list;
	
	
	



	public ArrayList<String> getList() {
		return list;
	}






	public void setList(ArrayList<String> list) {
		this.list = list;
	}






	public String execute() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("=====>111");

		list.add("bbzzz");
		list.add("b");

		System.out.println(" ====>");
		System.out.println(list);
		return "success";
	}






















}
