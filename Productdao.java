package niit.foodgro.dao;

import java.util.List;

import niit.foodgro.model.Product;

public interface Productdao {
	public boolean save(Product product);
	public boolean update(Product product);
	public void delete(String id );
	public Product get(String id);
	public List<Product> list();
	

}
