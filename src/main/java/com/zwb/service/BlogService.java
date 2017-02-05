package com.zwb.service;

import java.util.List;

import com.zwb.beans.Blog;

public interface BlogService {
	public List<Blog> showBlogs();
	public void save(Blog blog);
	public Blog showblog(String id);
	public List<Blog> showUserBlogs(String userid);
	public void update(Blog blog);
}
