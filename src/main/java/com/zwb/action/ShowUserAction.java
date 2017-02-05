package com.zwb.action;

import java.util.List;

import com.opensymphony.xwork2.Action;
import com.zwb.beans.Blog;
import com.zwb.beans.User;
import com.zwb.serviceImpl.BlogServiceImpl;
import com.zwb.serviceImpl.UserServiceImpl;

public class ShowUserAction implements Action {
	private String userid;
	private User user;
	private UserServiceImpl us;
	private BlogServiceImpl bs;
	private List<Blog> bloglist;

	
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserServiceImpl getUs() {
		return us;
	}

	public void setUs(UserServiceImpl us) {
		this.us = us;
	}

	public BlogServiceImpl getBs() {
		return bs;
	}

	public void setBs(BlogServiceImpl bs) {
		this.bs = bs;
	}

	public List<Blog> getBloglist() {
		return bloglist;
	}

	public void setBloglist(List<Blog> bloglist) {
		this.bloglist = bloglist;
	}


	public String execute() throws Exception {
		// TODO Auto-generated method stub
		user = us.getUser(userid);
		bloglist = bs.showUserBlogs(userid);
		System.out.println(bloglist.size());
		if(user!=null){
			return SUCCESS;
		}
		else{
			return ERROR;
		}
	}



}
