package com.zwb.serviceImpl;

import java.util.Calendar;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.zwb.beans.Blog;
import com.zwb.beans.Comment;
import com.zwb.beans.PageBean;
import com.zwb.daoImpl.BlogDaoImpl;
import com.zwb.daoImpl.CommentDaoImpl;
import com.zwb.service.BlogService;

public class BlogServiceImpl implements BlogService {
	
	private BlogDaoImpl blogDao;
	private GeneralUtilsImpl gui;
	private CommentDaoImpl commentDao;
	

	public CommentDaoImpl getCommentDao() {
		return commentDao;
	}

	public void setCommentDao(CommentDaoImpl commentDao) {
		this.commentDao = commentDao;
	}

	public GeneralUtilsImpl getGui() {
		return gui;
	}

	public void setGui(GeneralUtilsImpl gui) {
		this.gui = gui;
	}

	public BlogDaoImpl getBlogDao() {
		return blogDao;
	}

	public void setBlogDao(BlogDaoImpl blogDao) {
		this.blogDao = blogDao;
	}

	public List<Blog> showBlogs() {
		// TODO Auto-generated method stub
		
		List<Blog> bloglist = blogDao.findAllBlog();
		for (Blog blog : bloglist){
			blog.setCreated_at(gui.timeConvert(blog.getCreated_at()));
		}
		return bloglist;
	}

	public void save(Blog blog) {
		// TODO Auto-generated method stub
		Calendar calendar =Calendar.getInstance();
		blog.setCreated_at(calendar.getTime().getTime()+"");
		blogDao.save(blog);
	
	}

	public Blog showblog(String blogid) {
		// TODO Auto-generated method stub
		Blog blog = blogDao.get(blogid);
		blog.setCreated_at(gui.timeConvert(blog.getCreated_at()));
		return blog;
		
	}

	public List<Blog> showUserBlogs(String userid) {
		// TODO Auto-generated method stub
		List<Blog> bloglist = blogDao.findAllBlogsByUserid(userid);
		for (Blog blog : bloglist){
			blog.setCreated_at(gui.timeConvert(blog.getCreated_at()));
		}
		return bloglist;
	}

	public void update(Blog blog) {
		// TODO Auto-generated method stub
		Calendar calendar =Calendar.getInstance();
		blog.setCreated_at(calendar.getTime().getTime()+"");
		blogDao.update(blog);
	}

	public void deleteBlogById(String blogid) {
		// TODO Auto-generated method stub
		List<Comment> cl = commentDao.findAllCommentByBlogid(blogid);
		if(cl!=null){
			for(Comment c : cl){
				commentDao.delete(c);
			}
		}
		blogDao.deleteById(blogid);
	}

		
	@Override
	@Transactional
	public PageBean getPageBean(int pageIndex) {
		// TODO Auto-generated method stub
		   int allRows = blogDao.getBlogNumber();   //总记录数
		   System.out.println("allRow="+allRows);
		   final int length = 4;    //每页记录数
		   int totalPages = PageBean.countTotalPage(length,allRows);    //总页数
		   final int offset = PageBean.countOffset(length,pageIndex);    //当前页开始记录		   
		   final int currentPage = PageBean.countCurrentPage(pageIndex);   //当前页码(默认pageIndex为0转化为1)
		   List<Blog> list = blogDao.getBlogByPage(offset, length);       //"一页"的记录
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
