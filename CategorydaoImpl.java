package niit.foodgro.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import niit.foodgro.model.Category;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class CategorydaoImpl implements Categorydao {
	@Autowired
	private Category category;
	@Autowired
	private SessionFactory sessionFactory;
	public CategorydaoImpl(SessionFactory sessionFactory)
	{
	this.sessionFactory=sessionFactory;
	}
@Transactional
	public boolean save(Category category) {
		try {
			sessionFactory.getCurrentSession().save(category);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}
@Transactional
	public boolean update(Category category) {
		try {
			sessionFactory.getCurrentSession().update(category);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}
@Transactional
	public boolean delete(String id) {
	Category CategoryToDelete = new Category();
		CategoryToDelete.setId(id);
		sessionFactory.getCurrentSession().delete(CategoryToDelete);
	}
@Transactional
	public Category get(String id) {
		String hql = "from Category where id='" + id + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Category> list = (List<Category>) query;
		if (list != null || list.isEmpty()) {
			return null;
		}
		return list.get(0);
	}
@Transactional
	public List<Category> list() {
		return null;
	}
}
