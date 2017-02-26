package com.zwb.serviceImpl;

import java.util.Calendar;
import java.util.List;

import com.zwb.beans.Comment;
import com.zwb.beans.PageBean;
import com.zwb.daoImpl.CommentDaoImpl;
import com.zwb.service.CommentService;

public class CommentServiceImpl implements CommentService {
	
	private CommentDaoImpl commentDao;
	private GeneralUtilsImpl gui;
	
	
	public GeneralUtilsImpl getGui() {
		return gui;
	}

	public void setGui(GeneralUtilsImpl gui) {
		this.gui = gui;
	}

	public CommentDaoImpl getCommentDao() {
		return commentDao;
	}

	public void setCommentDao(CommentDaoImpl commentDao) {
		this.commentDao = commentDao;
	}

	
	
	public List<Comment> showComments() {
		// TODO Auto-generated method stub		
		List<Comment> commentlist =  commentDao.findAllComment();
		for (Comment comment : commentlist){
				comment.setCreated_at(gui.timeConvert(comment.getCreated_at()));
		}
		return commentlist;

	}

	public void save(Comment comment) {
		// TODO Auto-generated method stub
		Calendar calendar =Calendar.getInstance();
		comment.setCreated_at(calendar.getTime().getTime()+"");
		commentDao.save(comment);
	}

	public List<Comment> showBlogComments(String blogid) {
		// TODO Auto-generated method stub
		List<Comment> commentlist  = commentDao.findAllCommentByBlogid(blogid);
		for (Comment comment : commentlist){
			comment.setCreated_at(gui.timeConvert(comment.getCreated_at()));
		}
	return commentlist;		
	}

	@Override
	public void deleteCommentById(String Commentid) {
		// TODO Auto-generated method stub
		commentDao.deleteById(Commentid);
	}

	@Override
	public PageBean getPageBean(int pageIndex) {
		// TODO Auto-generated method stub
		   int allRows = commentDao.getCommentNumber();   //总记录数
		   System.out.println("allRow="+allRows);
		   final int length = 4;    //每页记录数
		   int totalPages = PageBean.countTotalPage(length,allRows);    //总页数
		   final int offset = PageBean.countOffset(length,pageIndex);    //当前页开始记录		   
		   final int currentPage = PageBean.countCurrentPage(pageIndex);   //当前页码(默认pageIndex为0转化为1)
		   List<Comment> list = commentDao.getCommentByPage(offset, length);       //"一页"的记录
		   //设置时间格式
		   for (Comment comment : list){
				comment.setCreated_at(gui.timeConvert(comment.getCreated_at()));
			}
		   //把分页信息保存到Bean中
		   PageBean pageBean = new PageBean();
		   pageBean.setPageSize(6);    
		   pageBean.setCurrentPage(currentPage);
		   pageBean.setAllRows(allRows);
		   pageBean.setAllPages(totalPages);
		   pageBean.setList(list);
		   pageBean.init();
		   return pageBean;
	}

}
