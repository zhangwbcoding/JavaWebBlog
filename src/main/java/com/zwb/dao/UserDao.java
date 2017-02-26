package com.zwb.dao;

import java.util.List;

import com.zwb.beans.User;

public interface UserDao {

	public User get(String id);
	public void save(User user);
	public void update(User user);
	public void deleteById(String id);
	public void delete(User user);
	public User findByName(String name);
	public List<User> findAllUser();
	public int getUserNumber();
	public List<User> getUserByPage(int offset,int length);
	
	
}
