package com.zwb.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;


import com.zwb.beans.Comment;
import com.zwb.dao.CommentDao;

public class CommentDaoImpl implements CommentDao {
	
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
	public Comment get(String id) {
		// TODO Auto-generated method stub
		return (Comment)getHibernateTemplate().get(Comment.class, id);
	}

	public void save(Comment comment) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(comment);
	}

	public void update(Comment comment) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(comment);
	}

	public void deleteById(String id) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(get(id));
	}

	public void delete(Comment comment) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(comment);
	}

	@SuppressWarnings("unchecked")
	public List<Comment> findAllComment() {
		// TODO Auto-generated method stub
		return (List<Comment>)getHibernateTemplate().find("from Comment");
	}

	public int getCommentNumber() {
		// TODO Auto-generated method stub
		Long num = (Long)getHibernateTemplate().find("select count(*) from Comment as c ").get(0);
		return num.intValue();
	}

	@SuppressWarnings("unchecked")
	public List<Comment> findAllCommentByBlogid(String blogid) {
		// TODO Auto-generated method stub
		return (List<Comment>)getHibernateTemplate().find("from Comment c where c.blogid=?",blogid);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Comment> getCommentByPage(int offset, int length) {
		// TODO Auto-generated method stub
		Query query=(Query) getSession().createQuery("FROM Comment");
		query.setFirstResult(offset).setMaxResults(length);
		return (List<Comment>)query.list();
	}

}
