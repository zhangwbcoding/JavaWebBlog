package com.zwb.action;

import java.util.List;

import com.opensymphony.xwork2.Action;
import com.zwb.beans.Blog;
import com.zwb.serviceImpl.BlogServiceImpl;

public class MainAction implements Action {
	

	private List<Blog> bloglist;
	private BlogServiceImpl bs;

	
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
		setBloglist(bs.showBlogs());
		//System.out.println(bloglist.toString());
		return SUCCESS;
	}








}
