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
			String dbpw= userDao.findByName(user.getUsername()).getPassword();  //���ݿⱣ���MD5��������
			String MD5pw = gui.string2MD5(user.getUsername()+":"+user.getPassword()); 	//"�˺ţ�����+SALT"����		
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
			String MD5pw = gui.string2MD5(user.getUsername()+":"+user.getPassword());   //"�˺ţ�����+SALT"����	
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

	public User getUser(String id) {          //ͨ��us.getUser()������õ�ʱ��ת����Ľ������
		// TODO Auto-generated method stub
		User user =  userDao.get(id);
		user.setCreated_at(gui.timeConvert(user.getCreated_at()));          //ת��ʱ���ʽ
		return user;
	}

	public User getUserByName(String name) {
		// TODO Auto-generated method stub

		User user =  userDao.findByName(name);
		user.setCreated_at(gui.timeConvert(user.getCreated_at()));
		return user;
	}

	//��������û�
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
	
	//�޸�admin�ֶ�Ϊ1
	@Override
	public void addAdmin(String id) {
		// TODO Auto-generated method stub
		User user = userDao.get(id);
		user.setAdmin(1);
		this.updateUser(user);
	}
	
	//�޸�admin�ֶ�Ϊ0
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
		int allRows = userDao.getUserNumber();   //�ܼ�¼��
		   System.out.println("allRow="+allRows);
		   final int length = 4;    //ÿҳ��¼��
		   int totalPages = PageBean.countTotalPage(length,allRows);    //��ҳ��
		   final int offset = PageBean.countOffset(length,pageIndex);    //��ǰҳ��ʼ��¼		   
		   final int currentPage = PageBean.countCurrentPage(pageIndex);   //��ǰҳ��(Ĭ��pageIndexΪ0ת��Ϊ1)
		   List<User> list = userDao.getUserByPage(offset, length);       //"һҳ"�ļ�¼
			for (User user : list){
				user.setCreated_at(gui.timeConvert(user.getCreated_at()));
			}
		   //�ѷ�ҳ��Ϣ���浽Bean��
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
