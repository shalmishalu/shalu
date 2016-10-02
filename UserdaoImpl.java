package niit.foodgro.dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import niit.foodgro.model.Register;
@Repository("userdao")
@Transactional
public class UserdaoImpl implements Userdao
{
@SuppressWarnings("unused")
@Autowired
 private Register register;
@Autowired
private SessionFactory sessionFactory;
UserdaoImpl()
{
}
public UserdaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
@Transactional
	public Register get(String id) {
	String hql ="from Register where id=" + "'"+ id + "'";
		return getRegister(hql);
	}
@Transactional
	public boolean update(Register register) {
	try
	{
	sessionFactory.getCurrentSession().update(register);
	}catch (Exception e)
	{
		e.printStackTrace();
		return false;
	}
	return true;	
	}
@Transactional
	public boolean delete(String id) {
	Register register = new Register();
		try
		{
			sessionFactory.getCurrentSession().delete(register);	
		}catch (Exception e)
		{
		e.printStackTrace();
		return false;
	}
		return true;
	}
@Transactional
	public Register isValidUser(String id, String password) {
	String hql ="from Register where id=" + "'"+ id + "'" + "and" 
	+ "password = " + "'" + password + "'";
		return getRegister(hql);
	}
	private Register getRegister(String hql)
	{
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Register> list = (List<Register>) query.list();
		if(list != null && !list.isEmpty())
		{
			return list.get(0);
		}
		return null;
	}
	@Transactional 
	public boolean save(Register register) {
		try
		{
			sessionFactory.getCurrentSession().save(register);
		}catch (Exception e)
		{
	   e.printStackTrace();
	   return false;
		}
		return true;
	}
	
	public java.util.List<Register> list() {
		// TODO Auto-generated method stub
		return null;
	}}
