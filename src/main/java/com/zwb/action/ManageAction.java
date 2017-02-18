package com.zwb.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.zwb.beans.Comment;
import com.zwb.beans.User;
import com.zwb.serviceImpl.BlogServiceImpl;
import com.zwb.serviceImpl.CommentServiceImpl;
import com.zwb.serviceImpl.UserServiceImpl;

import net.sf.json.JSONArray;

public class ManageAction implements Action {

	private JSONArray json_userlist;
	private JSONArray json_bloglist;
	private JSONArray json_commentlist;
	private String tip;
	private String admin;
	private BlogServiceImpl bs;
	private	UserServiceImpl us;
	private CommentServiceImpl cs;

	
	


	public JSONArray getJson_commentlist() {
		return json_commentlist;
	}

	public void setJson_commentlist(JSONArray json_commentlist) {
		this.json_commentlist = json_commentlist;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public JSONArray getJson_bloglist() {
		return json_bloglist;
	}

	public void setJson_bloglist(JSONArray json_bloglist) {
		this.json_bloglist = json_bloglist;
	}

	public String getAdmin() {
		return admin;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}

	public BlogServiceImpl getBs() {
		return bs;
	}

	public void setBs(BlogServiceImpl bs) {
		this.bs = bs;
	}



	public UserServiceImpl getUs() {
		return us;
	}

	public void setUs(UserServiceImpl us) {
		this.us = us;
	}

	public CommentServiceImpl getCs() {
		return cs;
	}

	public void setCs(CommentServiceImpl cs) {
		this.cs = cs;
	}
	
	
	
	
	
	
	public JSONArray getJson_userlist() {
		return json_userlist;
	}

	public void setJson_userlist(JSONArray json_userlist) {
		this.json_userlist = json_userlist;
	}

	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return SUCCESS;
	}
	
	
	public String blogs() throws Exception {
		return SUCCESS;
		
	}
	
	public String comments() throws Exception {
		return SUCCESS;
		
	}

	public String getAllBlogs() throws Exception {
		// TODO Auto-generated method stub
		json_bloglist =JSONArray.fromObject( bs.showBlogs());
		return SUCCESS;
	}
	
	public String getAllUsers() throws Exception{
		json_userlist =JSONArray.fromObject( us.showUsers());
		return SUCCESS;
	}
	
	public String getAllComments() throws Exception{
		json_commentlist = JSONArray.fromObject(cs.showComments());
		return SUCCESS;
		
	}
	
	public String deleteComments() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		String commentid =  (String) request.getParameter("commentid");
		System.out.println("commentid:"+commentid);
		cs.getCommentDao().deleteById(commentid);
		tip = "删除成功！";
		return SUCCESS;
		
	}	

	public String deleteBlogs() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		String blogid =  (String) request.getParameter("blogid");
		List<Comment> cl = cs.showBlogComments(blogid);
		if(cl!=null){
			for(Comment c : cl){
				cs.getCommentDao().delete(c);
			}
		}
		bs.getBlogDao().deleteById(blogid);
		tip = "删除成功！";
		return SUCCESS;
		
	}

	public String addAdmin() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		String userid =  (String) request.getParameter("userid");
		User user = us.getUserDao().get(userid);
		System.out.println(user.getCreated_at());
		user.setAdmin(1);
		us.updateUser(user);
		admin = "1";
		return SUCCESS;
	}
	
	public String removeAdmin() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		String userid =  (String) request.getParameter("userid");
		System.out.println("========>"+userid);
		User user = us.getUserDao().get(userid);
		System.out.println(user.getCreated_at());
		user.setAdmin(0);
		us.updateUser(user);
		admin = "0";
		return SUCCESS;
	}
}
