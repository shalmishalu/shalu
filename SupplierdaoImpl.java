package niit.foodgro.dao;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import niit.foodgro.model.Supplier;

  @Repository
public class SupplierdaoImpl implements Supplierdao {
	@Autowired
	private Supplier supplier;
	@Autowired
	private SessionFactory sessionFactory;
	public SupplierdaoImpl(SessionFactory sessionFactory)
	{
	this.sessionFactory=sessionFactory;
	}

	public boolean save(Supplier supplier) {
		try {
			sessionFactory.getCurrentSession().save(supplier);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	public boolean update(Supplier supplier) {
		try {
			sessionFactory.getCurrentSession().update(supplier);
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

	private Object get(String id) {
		// TODO Auto-generated method stub
		return null;
	}
}

	
