package com.zwb.serviceImpl;

import java.util.Calendar;
import java.util.List;

import com.zwb.beans.User;
import com.zwb.daoImpl.UserDaoImpl;
import com.zwb.service.UserService;

public class UserServiceImpl implements UserService {
	private UserDaoImpl userDao;
	
	
	
	public UserDaoImpl getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDaoImpl userDao) {
		this.userDao = userDao;
	}

	public boolean checkUser(User user) {
		// TODO Auto-generated method stub
		if(!userExistOrNot(user)){
			return false;
		}
		else{
			String password= userDao.findByName(user.getUsername()).getPassword();
			if(user.getPassword().equals(password)){
				return true;
			}
			else{
				return false;
			}
		} 	

	}
	
	public void saveUser(User user){
			Calendar calendar =Calendar.getInstance();
			user.setCreated_at(calendar.getTime().getTime());
			user.setAdmin(0);
			userDao.save(user);
	}
	
	public boolean userExistOrNot(User user){
		List<User> existedUser = userDao.findAllUser();
		if(existedUser!=null){
			for(User u:existedUser){
				if (u.getUsername().equals(user.getUsername())){
					return true;
				}
			}
		}
		return false;
	}

	public User getUser(String id) {
		// TODO Auto-generated method stub
		return userDao.get(id);
	}

	public User getUserByName(String name) {
		// TODO Auto-generated method stub
		return userDao.findByName(name);
	}


}
