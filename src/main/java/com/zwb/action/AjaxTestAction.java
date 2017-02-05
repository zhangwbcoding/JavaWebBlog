package com.zwb.action;

import java.util.HashMap;
import java.util.Map;

import com.opensymphony.xwork2.Action;

import net.sf.json.JSONObject;

public class AjaxTestAction implements Action {
	private String result;
	private String name;
	private String age;
	
	
	
	public String getResult() {
		return result;
	}



	public void setResult(String result) {
		this.result = result;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getAge() {
		return age;
	}



	public void setAge(String age) {
		this.age = age;
	}



	public String execute() throws Exception {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("name", "zwb");
		map.put("age", "22");
		JSONObject json = JSONObject.fromObject(map);
		result = json.toString();
		//System.out.println(result);
		return SUCCESS;
	}


}
