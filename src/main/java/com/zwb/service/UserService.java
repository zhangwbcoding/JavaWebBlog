package com.zwb.service;

import com.zwb.beans.User;

public interface UserService {
	public boolean checkUser(User user);
	public void saveUser(User user);
	public boolean userExistOrNot(User user);
	public User getUser(String id);
	public User getUserByName(String name);
}
