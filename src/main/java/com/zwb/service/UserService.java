package com.zwb.service;

import java.util.List;

import com.zwb.beans.User;

public interface UserService {
	public boolean checkUser(User user);
	public void saveUser(User user);
	public boolean userExistOrNot(User user);
	public User getUser(String id);
	public User getUserByName(String name);
	public List<User> showUsers();
	public void updateUser(User user);
	public void addAdmin(String id);
	public void removeAdmin(String id);
}
