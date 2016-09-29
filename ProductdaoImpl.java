package niit.foodgro.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import niit.foodgro.model.Category;
import niit.foodgro.model.Product;

@Repository
@Transactional
public class ProductdaoImpl implements Productdao {
	@Autowired
	private Product product;
	@Autowired
	private SessionFactory sessionFactory;
	ProductdaoImpl()
	{
	}

	public ProductdaoImpl(SessionFactory sessionFactory)
	{
	this.sessionFactory=sessionFactory;
	}
@Transactional
	public boolean save(Product product) {
		try {
			sessionFactory.getCurrentSession().save(product);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}
@Transactional
	public boolean update(Product product) {
		try {
			sessionFactory.getCurrentSession().update(product);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}
@Transactional
	public void delete(String id) {
Product	ProductToDelete = new Product();
	ProductToDelete.setId(id);
	sessionFactory.getCurrentSession().delete(ProductToDelete);
}
		
@Transactional
	public Product get(String id) {
		String hql = "from Category where id='" + id + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Product> list = (List<Product>) query;
		if (list != null || list.isEmpty()) {
			return null;
		}
		return list.get(0);
	}

@Transactional
	public List<Product> list() {
		return null;
	}
}


