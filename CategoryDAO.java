package com.grostore.dao;
import java.util.List;
import com.grostore.model.Category;
public interface CategoryDAO {
	public boolean saveOrupdate(Category category);
	public boolean delete(String id);
	public Category get(String id);
	public List<Category> list();
}

