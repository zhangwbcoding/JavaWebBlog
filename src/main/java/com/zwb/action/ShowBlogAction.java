package com.zwb.action;

import java.util.List;

import com.opensymphony.xwork2.Action;
import com.zwb.beans.Blog;
import com.zwb.beans.Comment;
import com.zwb.serviceImpl.BlogServiceImpl;
import com.zwb.serviceImpl.CommentServiceImpl;

public class ShowBlogAction implements Action {
	private String blogid;
	private Blog blog;
	private CommentServiceImpl cs;
	private BlogServiceImpl bs;
	private List<Comment> commentlist;
	
	
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		blog = bs.showblog(blogid);
		commentlist=cs.showBlogComments(blogid);
		if(blog!=null){
			return SUCCESS;
		}
		else{
			return ERROR;
		}
	}


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

	public CommentServiceImpl getCs() {
		return cs;
	}


	public void setCs(CommentServiceImpl cs) {
		this.cs = cs;
	}


	public List<Comment> getCommentlist() {
		return commentlist;
	}


	public void setCommentlist(List<Comment> commentlist) {
		this.commentlist = commentlist;
	}

}
