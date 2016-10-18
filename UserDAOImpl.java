package com.grostore.dao;

import java.util.List;


import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.grostore.dao.UserDAO;
import com.grostore.model.UserDetails;



@Transactional
@EnableTransactionManagement
@Repository("userDAO")
public class UserDAOImpl implements UserDAO {
	private static final Logger log = LoggerFactory.getLogger(UserDAOImpl.class);
	@Autowired
	private SessionFactory sessionFactory;
	
	/*public UserDAOImpl() {
		super();
		
	}*/
	public UserDAOImpl(SessionFactory sessionFactory)
	{
	this.sessionFactory = sessionFactory;

	}
	@Transactional
	public List<UserDetails> list() {
		
		@SuppressWarnings("unchecked")
		List<UserDetails> listUserDetails = (List<UserDetails>) 
		          sessionFactory.getCurrentSession()
				.createCriteria(UserDetails.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return listUserDetails;
	}
@Transactional
	public boolean save(UserDetails userDetails)
	{
	try {
		log.debug("starting of save method");
		userDetails.setRole("ROLE_USER");
		sessionFactory.getCurrentSession().save(userDetails);
	
		log.debug("Ending of save method");
		return true;
	}
	catch(Exception e)
	{
		log.error("Exception occured in save" +e.getMessage());
		e.printStackTrace();
		return false;
	}
	}
@Transactional
	public boolean update(UserDetails userDetails)
	{
	try {
		log.debug("starting of update method");
		sessionFactory.getCurrentSession().update(userDetails);
		log.debug("starting of update method");
		return true;
	}
	catch(Exception e)
	{
		log.error("Exception occured in update" +e.getMessage());
		e.printStackTrace();
		return false;
	}
	}
@Transactional
	public boolean delete(UserDetails userDetails)
	{
	try {
		log.debug("starting of delete method");
		sessionFactory.getCurrentSession().delete(userDetails);
		log.debug("starting of delete method");
		return true;
	}
	catch(Exception e)
	{
		log.error("Exception occured in delete" +e.getMessage());
		e.printStackTrace();
		return false;
	}
	}
@Transactional
public UserDetails get(String username)
{
	String hql = "from UserDetails where username= "+" '" +username+ "'";
	Query query =sessionFactory.getCurrentSession().createQuery(hql);
	List<UserDetails> list = query.list();
	if(list == null || list.isEmpty())
	{
		return null;
	}
	else
	{
		return list.get(0);
	}
}

@Transactional
public UserDetails isValidUser(String username, String password) {
	System.out.println("dao impl");
	String hql ="from UserDetails where username= '" + username + "' and " + " password ='" + password + "'";
	Query query = sessionFactory.getCurrentSession().createQuery(hql);
	@SuppressWarnings("unchecked")
	List<UserDetails> list = (List<UserDetails>) query.list();
	if(list != null && !list.isEmpty())
	{
	
		return list.get(0);
	}
	
	return null;
	}
}