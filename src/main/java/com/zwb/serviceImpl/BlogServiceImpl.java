package com.zwb.serviceImpl;

import java.util.Calendar;
import java.util.List;

import com.zwb.beans.Blog;
import com.zwb.daoImpl.BlogDaoImpl;
import com.zwb.service.BlogService;

public class BlogServiceImpl implements BlogService {
	
	private BlogDaoImpl blogDao;
	
	

	public BlogDaoImpl getBlogDao() {
		return blogDao;
	}

	public void setBlogDao(BlogDaoImpl blogDao) {
		this.blogDao = blogDao;
	}

	public List<Blog> showBlogs() {
		// TODO Auto-generated method stub
		
		return blogDao.findAllBlog();
	}

	public void save(Blog blog) {
		// TODO Auto-generated method stub
		Calendar calendar =Calendar.getInstance();
		blog.setCreated_at(calendar.getTime().getTime());
		blogDao.save(blog);
	}

	public Blog showblog(String id) {
		// TODO Auto-generated method stub
		return blogDao.get(id);
		
	}

	public List<Blog> showUserBlogs(String userid) {
		// TODO Auto-generated method stub
		return blogDao.findAllBlogsByUserid(userid);
	}

	public void update(Blog blog) {
		// TODO Auto-generated method stub
		Calendar calendar =Calendar.getInstance();
		blog.setCreated_at(calendar.getTime().getTime());
		blogDao.update(blog);
	}

}
