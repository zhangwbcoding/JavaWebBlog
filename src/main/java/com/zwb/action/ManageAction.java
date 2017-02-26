package com.zwb.action;

import com.opensymphony.xwork2.Action;
import com.zwb.beans.PageBean;
import com.zwb.serviceImpl.BlogServiceImpl;
import com.zwb.serviceImpl.CommentServiceImpl;
import com.zwb.serviceImpl.UserServiceImpl;

import net.sf.json.JSONObject;

public class ManageAction implements Action {

	private JSONObject json_userlist;
	private JSONObject json_bloglist;
	private JSONObject json_commentlist;
	private String tip;
	private String admin;
	private String commentid;
	private String blogid;
	private String userid;
	private int pageIndex;
	
	private BlogServiceImpl bs;
	private	UserServiceImpl us;
	private CommentServiceImpl cs;
	private PageBean pageBean;
	
	


	public PageBean getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public String getBlogid() {
		return blogid;
	}

	public void setBlogid(String blogid) {
		this.blogid = blogid;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getCommentid() {
		return commentid;
	}

	public void setCommentid(String commentid) {
		this.commentid = commentid;
	}

	public JSONObject getJson_commentlist() {
		return json_commentlist;
	}

	public void setJson_commentlist(JSONObject json_commentlist) {
		this.json_commentlist = json_commentlist;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public JSONObject getJson_bloglist() {
		return json_bloglist;
	}

	public void setJson_bloglist(JSONObject json_bloglist) {
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
	

	public JSONObject getJson_userlist() {
		return json_userlist;
	}

	public void setJson_userlist(JSONObject json_userlist) {
		this.json_userlist = json_userlist;
	}

	
	
	
	//=========action�߼�����==============
	
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return SUCCESS;
	}
	
	//��ò���list
	public String getAllBlogs() throws Exception {
		// TODO Auto-generated method stub	
		System.out.println("pageIndex:"+pageIndex);
		json_bloglist =JSONObject.fromObject(bs.getPageBean(pageIndex));
		return SUCCESS;
	}
	
	//����û�List
	public String getAllUsers() throws Exception{
		json_userlist =JSONObject.fromObject(us.getPageBean(pageIndex));
		return SUCCESS;
	}
	
	//�������list
	public String getAllComments() throws Exception{
		json_commentlist = JSONObject.fromObject(cs.getPageBean(pageIndex));
		return SUCCESS;
		
	}
	
	//ɾ������
	public String deleteComments() throws Exception{
		cs.deleteCommentById(commentid);
		tip = "ɾ���ɹ���";
		return SUCCESS;
		
	}	

	
	//ɾ����־������������
	public String deleteBlogs() throws Exception{	
		bs.deleteBlogById(blogid);
		tip = "ɾ���ɹ���";
		return SUCCESS;
		
	}

	//��ӹ���Ա���
	public String addAdmin() throws Exception{
		us.addAdmin(userid);
		admin = "1";
		return SUCCESS;
	}
	
	//ɾ������Ա���
	public String removeAdmin() throws Exception{
		us.removeAdmin(userid);
		admin = "0";
		return SUCCESS;
	}
}
