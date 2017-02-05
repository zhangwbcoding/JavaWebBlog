package com.zwb.dao;

import java.util.List;

import com.zwb.beans.Blog;


public interface BlogDao {
	public Blog get(String id);
	public void save(Blog blog);
	public void update(Blog blog);
	public void deleteById(String id);
	public void delete(Blog blog);
	public List<Blog> findAllBlog();
	public long getBlogNumber();
	public List<Blog> findAllBlogsByUserid(String userid);
}
