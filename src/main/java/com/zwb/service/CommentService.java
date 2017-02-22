package com.zwb.service;

import java.util.List;

import com.zwb.beans.Comment;

public interface CommentService {
	public List<Comment> showComments();
	public void save(Comment comment);
	public List<Comment> showBlogComments(String blogid);
	public void deleteCommentById(String Commentid);
}
