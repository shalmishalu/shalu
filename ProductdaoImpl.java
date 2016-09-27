package niit.foodgro.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import niit.foodgro.model.Product;

@Repository
public class ProductdaoImpl implements Productdao {
	@Autowired
	private Product product;
	@Autowired
	private SessionFactory sessionFactory;
	public ProductdaoImpl(SessionFactory sessionFactory)
	{
	this.sessionFactory=sessionFactory;
	}

	public boolean save(Product product) {
		try {
			sessionFactory.getCurrentSession().save(product);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	public boolean update(Product product) {
		try {
			sessionFactory.getCurrentSession().update(product);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	public boolean delete(String id) {
		try {
			sessionFactory.getCurrentSession().delete(get(id));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	public Product get(String id) {
		String hql = "from Category where id='" + id + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Product> list = (List<Product>) query;
		if (list != null || list.isEmpty()) {
			return null;
		}
		return list.get(0);
	}

	public List<Product> list() {
		return null;
	}
}


