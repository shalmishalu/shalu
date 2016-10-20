package com.grostore.dao;
import java.util.List;
import com.grostore.model.Product;
public interface ProductDAO {
public List<Product> list();
public Product get(String id);
public void saveOrUpdate(Product product);
public boolean delete(String id);

	/*public MultipartFile getImage();*/
}
