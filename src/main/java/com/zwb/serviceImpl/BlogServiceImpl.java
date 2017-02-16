package com.zwb.serviceImpl;

import java.util.Calendar;
import java.util.List;

import com.zwb.beans.Blog;
import com.zwb.daoImpl.BlogDaoImpl;
import com.zwb.service.BlogService;

public class BlogServiceImpl implements BlogService {
	
	private BlogDaoImpl blogDao;
	private GeneralUtilsImpl gui;
	

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

	public Blog showblog(String id) {
		// TODO Auto-generated method stub
		Blog blog = blogDao.get(id);
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

}
