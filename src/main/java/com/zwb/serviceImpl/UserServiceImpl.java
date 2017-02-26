package com.zwb.serviceImpl;

import java.util.Calendar;
import java.util.List;

import com.zwb.beans.PageBean;
import com.zwb.beans.User;
import com.zwb.daoImpl.UserDaoImpl;
import com.zwb.service.UserService;

public class UserServiceImpl implements UserService {
	private UserDaoImpl userDao;
	private GeneralUtilsImpl gui;

	
	public GeneralUtilsImpl getGui() {
		return gui;
	}

	public void setGui(GeneralUtilsImpl gui) {
		this.gui = gui;
	}

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
			String dbpw= userDao.findByName(user.getUsername()).getPassword();  //数据库保存的MD5密文密码
			String MD5pw = gui.string2MD5(user.getUsername()+":"+user.getPassword()); 	//"账号：密码+SALT"加密		
			if(MD5pw.equals(dbpw)){
				return true;
			}
			else{
				return false;
			}
		} 	

	}
	
	public void saveUser(User user){
			Calendar calendar =Calendar.getInstance();
			user.setCreated_at(calendar.getTime().getTime()+"");
			user.setAdmin(0);
			String MD5pw = gui.string2MD5(user.getUsername()+":"+user.getPassword());   //"账号：密码+SALT"加密	
			user.setPassword(MD5pw);
			System.out.println("in saveUser()");
			System.out.println("md5 PW: " + user.getPassword());
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

	public User getUser(String id) {          //通过us.getUser()方法获得的时间转换后的结果！！
		// TODO Auto-generated method stub
		User user =  userDao.get(id);
		user.setCreated_at(gui.timeConvert(user.getCreated_at()));          //转换时间格式
		return user;
	}

	public User getUserByName(String name) {
		// TODO Auto-generated method stub

		User user =  userDao.findByName(name);
		user.setCreated_at(gui.timeConvert(user.getCreated_at()));
		return user;
	}

	//获得所有用户
	public List<User> showUsers() {
		// TODO Auto-generated method stub
		List<User> userlist = userDao.findAllUser();
		for (User user : userlist){
			user.setCreated_at(gui.timeConvert(user.getCreated_at()));
		}
		return userlist;
	}

	public void updateUser(User user) {
		// TODO Auto-generated method stub
		userDao.update(user);
	}
	
	//修改admin字段为1
	@Override
	public void addAdmin(String id) {
		// TODO Auto-generated method stub
		User user = userDao.get(id);
		user.setAdmin(1);
		this.updateUser(user);
	}
	
	//修改admin字段为0
	@Override
	public void removeAdmin(String id) {
		// TODO Auto-generated method stub
		User user = userDao.get(id);
		user.setAdmin(0);
		this.updateUser(user);
	}

	@Override
	public PageBean getPageBean(int pageIndex) {
		// TODO Auto-generated method stub
		int allRows = userDao.getUserNumber();   //总记录数
		   System.out.println("allRow="+allRows);
		   final int length = 4;    //每页记录数
		   int totalPages = PageBean.countTotalPage(length,allRows);    //总页数
		   final int offset = PageBean.countOffset(length,pageIndex);    //当前页开始记录		   
		   final int currentPage = PageBean.countCurrentPage(pageIndex);   //当前页码(默认pageIndex为0转化为1)
		   List<User> list = userDao.getUserByPage(offset, length);       //"一页"的记录
			for (User user : list){
				user.setCreated_at(gui.timeConvert(user.getCreated_at()));
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
