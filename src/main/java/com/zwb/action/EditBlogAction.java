package com.zwb.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.zwb.beans.Blog;
import com.zwb.serviceImpl.BlogServiceImpl;

public class EditBlogAction implements Action {

	private Blog blog;
	private String blogid;
	private BlogServiceImpl bs;
	
	
	
	public String getBlogid() {
		return blogid;
	}



	public void setBlogid(String blogid) {
		this.blogid = blogid;
	}



	public Blog getBlog() {
		return blog;
	}



	public void setBlog(Blog blog) {
		this.blog = blog;
	}



	public BlogServiceImpl getBs() {
		return bs;
	}



	public void setBs(BlogServiceImpl bs) {
		this.bs = bs;
	}



	public String execute() throws Exception {
		// TODO Auto-generated method stub
		blog = bs.showblog(blogid);
		return SUCCESS;
	}
	
	public String update() throws Exception{

		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		blog.setUserid((String)session.getAttribute("userid"));
		blog.setUsername((String)session.getAttribute("username"));
		bs.update(blog);
		return SUCCESS;
	}

}
