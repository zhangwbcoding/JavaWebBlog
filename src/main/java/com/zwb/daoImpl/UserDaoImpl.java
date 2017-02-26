package com.zwb.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.zwb.beans.User;
import com.zwb.dao.UserDao;

public class UserDaoImpl  implements UserDao {

	private SessionFactory sessionFactory;
	private HibernateTemplate ht = null;
	
	
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}
	
	private HibernateTemplate getHibernateTemplate(){
		if(ht==null){
			System.out.println(sessionFactory);
			ht = new HibernateTemplate(sessionFactory);
		}
		return ht;
	} 
	private Session getSession(){
		return this.sessionFactory.openSession();
	}

	public void save(User user) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(user);
	}

	public User get(String id) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().get(User.class, id);

	}


	public void update(User user) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(user);
	}

	public void deleteById(String id) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(get(id));
	}

	public void delete(User user) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(user);
	}

	@SuppressWarnings("unchecked")
	public User findByName(String name) {
		// TODO Auto-generated method stub
		 List<User> userlist = getHibernateTemplate().find("from User u where u.username=?", name);
		 return userlist.get(0);
	}

	@SuppressWarnings("unchecked")
	public List<User> findAllUser() {
		// TODO Auto-generated method stub
		return (List<User>)getHibernateTemplate().find("from User");
	}

	public int getUserNumber() {
		// TODO Auto-generated method stub
		Long num =  (Long)getHibernateTemplate().find("select count(*) from User as u ").get(0);
		return num.intValue();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getUserByPage(int offset, int length) {
		// TODO Auto-generated method stub
		Query query=(Query) getSession().createQuery("FROM User");
		query.setFirstResult(offset).setMaxResults(length);
		return (List<User>)query.list();
	}

}
