package com.grostore.dao;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.grostore.model.Category;


@Transactional
@EnableTransactionManagement
@Repository("categoryDAO")
public class CategoryDAOImpl  implements CategoryDAO{
	@Autowired
	private SessionFactory sessionFactory;
    public CategoryDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
	public boolean saveOrupdate(Category category) {
		try
		{
			sessionFactory.getCurrentSession().saveOrUpdate(category);
		}catch (Exception e)
		{
	   e.printStackTrace();
	   return false;
		}
		return true;
	}

public boolean delete(String id) {
		Category category = new Category();
		category.setId(id);
		try
		{
			sessionFactory.getCurrentSession().delete(category);	
		}catch (Exception e)
		{
		e.printStackTrace();
		return false;
	}
		return true;
	}
	
	public Category get(String id) {
		String hql = "from Category where id =" + "'" + id + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Category> list = (List<Category>) query.list();
		if(list != null && !list.isEmpty())
		{
			return list.get(0);
		}
		return null;
	}
	
	public List<Category> list() {
		@SuppressWarnings("unchecked")
		List<Category> list = (List<Category>) 
		          sessionFactory.getCurrentSession()
				.createCriteria(Category.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return list;
	}

}

