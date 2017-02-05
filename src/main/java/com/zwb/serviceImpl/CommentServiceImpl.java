package com.zwb.serviceImpl;

import java.util.Calendar;
import java.util.List;

import com.zwb.beans.Comment;
import com.zwb.daoImpl.CommentDaoImpl;
import com.zwb.service.CommentService;

public class CommentServiceImpl implements CommentService {
	
	private CommentDaoImpl commentDao;

	public CommentDaoImpl getCommentDao() {
		return commentDao;
	}

	public void setCommentDao(CommentDaoImpl commentDao) {
		this.commentDao = commentDao;
	}

	
	
	public List<Comment> showComments() {
		// TODO Auto-generated method stub		
		return commentDao.findAllComment();
	}

	public void save(Comment comment) {
		// TODO Auto-generated method stub
		Calendar calendar =Calendar.getInstance();
		comment.setCreated_at(calendar.getTime().getTime());
		commentDao.save(comment);
	}

	public List<Comment> showBlogComments(String blogid) {
		// TODO Auto-generated method stub
		return commentDao.findAllCommentByBlogid(blogid);
	}

}
