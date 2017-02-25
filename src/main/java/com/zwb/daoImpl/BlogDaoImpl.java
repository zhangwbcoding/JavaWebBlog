package com.zwb.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.zwb.beans.Blog;
import com.zwb.dao.BlogDao;

public class BlogDaoImpl implements BlogDao {

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
	
	
	public Blog get(String id) {
		// TODO Auto-generated method stub
		return (Blog)getHibernateTemplate().get(Blog.class, id);
	}

	public void save(Blog blog) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(blog);
	}

	public void update(Blog blog) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(blog);
	}

	public void deleteById(String id) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(get(id));
	}

	public void delete(Blog blog) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(blog);
	}


	@SuppressWarnings("unchecked")
	public List<Blog> findAllBlog() {
		// TODO Auto-generated method stub
		return (List<Blog>)getHibernateTemplate().find("from Blog");
	}

	public int getBlogNumber() {
		// TODO Auto-generated method stub
		Long num = (Long)getHibernateTemplate().find("select count(*) from Blog as b ").get(0);
		return num.intValue();
	}

	@SuppressWarnings("unchecked")
	public List<Blog> findAllBlogsByUserid(String userid) {
		// TODO Auto-generated method stub
		return (List<Blog>)getHibernateTemplate().find("from Blog b where b.userid=?",userid);
	}



	@SuppressWarnings("unchecked")
	@Override
	public List<Blog> getBlogByPage(int offset, int length) {
		// TODO Auto-generated method stub
		Query query=(Query) getSession().createQuery("FROM Blog");
		query.setFirstResult(offset).setMaxResults(length);
		return (List<Blog>)query.list();
	}

}
