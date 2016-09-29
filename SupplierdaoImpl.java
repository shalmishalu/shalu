package niit.foodgro.dao;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import niit.foodgro.model.Category;
import niit.foodgro.model.Supplier;

  @Repository
  @Transactional
 public class SupplierdaoImpl implements Supplierdao {
	@Autowired
	private Supplier supplier;
	@Autowired
	private SessionFactory sessionFactory;
	SupplierdaoImpl()
	{
	}
	
	public SupplierdaoImpl(SessionFactory sessionFactory)
	{
	this.sessionFactory=sessionFactory;
	}
@Transactional
	public boolean save(Supplier supplier) {
		try {
			sessionFactory.getCurrentSession().save(supplier);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}
@Transactional
	public boolean update(Supplier supplier) {
		try {
			sessionFactory.getCurrentSession().update(supplier);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}
@Transactional
	public void delete(String id) {
	Supplier SupplierToDelete = new Supplier();
	SupplierToDelete.setId(id);
	sessionFactory.getCurrentSession().delete(SupplierToDelete);
}
  }
		

	
