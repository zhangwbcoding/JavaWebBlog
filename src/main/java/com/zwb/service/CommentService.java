package com.zwb.service;

import java.util.List;

import com.zwb.beans.Comment;
import com.zwb.beans.PageBean;

public interface CommentService {
	public List<Comment> showComments();
	public void save(Comment comment);
	public List<Comment> showBlogComments(String blogid);
	public void deleteCommentById(String Commentid);
	public PageBean getPageBean(int pageIndex);
}
