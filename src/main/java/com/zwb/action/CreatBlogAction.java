package com.zwb.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.zwb.beans.Blog;
import com.zwb.serviceImpl.BlogServiceImpl;

public class CreatBlogAction implements Action {
	
	private Blog blog;
	private BlogServiceImpl bs;
	
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
		try{
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession();
			String userid = (String) session.getAttribute("userid");
			String username = (String) session.getAttribute("username");
			System.out.println("userid in session :"+userid);
			blog.setUserid(userid);
			blog.setUsername(username);
			bs.save(blog);
			return SUCCESS;
		}
		catch(Exception e){
			return ERROR;
		}
	}



}
