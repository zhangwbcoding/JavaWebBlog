package com.zwb.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.zwb.beans.Blog;
import com.zwb.beans.Comment;
import com.zwb.beans.User;
import com.zwb.serviceImpl.BlogServiceImpl;
import com.zwb.serviceImpl.CommentServiceImpl;
import com.zwb.serviceImpl.UserServiceImpl;

public class ManageAction implements Action {
	private List<Blog> bloglist;
	private List<User> userlist;
	private List<Comment> commentlist;
	private BlogServiceImpl bs;
	private	UserServiceImpl us;
	private CommentServiceImpl cs;
	

	public List<Blog> getBloglist() {
		return bloglist;
	}

	public void setBloglist(List<Blog> bloglist) {
		this.bloglist = bloglist;
	}

	public List<User> getUserlist() {
		return userlist;
	}

	public void setUserlist(List<User> userlist) {
		this.userlist = userlist;
	}



	public List<Comment> getCommentlist() {
		return commentlist;
	}

	public void setCommentlist(List<Comment> commentlist) {
		this.commentlist = commentlist;
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

	public String execute() throws Exception {
		// TODO Auto-generated method stub
		bloglist = bs.showBlogs();
		return SUCCESS;
	}
	
	public String manageUsers() throws Exception{
		userlist = us.getUserDao().findAllUser();
		return SUCCESS;
	}
	
	public String manageComments() throws Exception{
		commentlist = cs.showComments();
		System.out.println(commentlist.size());
		return SUCCESS;
		
	}
	
	public String deleteComments() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		String commentid =  (String) request.getParameter("commentid");
		System.out.println("commentid:"+commentid);
		cs.getCommentDao().deleteById(commentid);
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
		return SUCCESS;
		
	}
}
