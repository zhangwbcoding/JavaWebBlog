package com.zwb.dao;

import java.util.List;

import com.zwb.beans.Comment;

public interface CommentDao {
	public Comment get(String id);
	public void save(Comment comment);
	public void update(Comment comment);
	public void deleteById(String id);
	public void delete(Comment comment);
	public List<Comment> findAllComment();
	public List<Comment> findAllCommentByBlogid(String blogid);
	public long getCommentNumber();
	
}
