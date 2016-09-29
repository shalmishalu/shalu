package niit.foodgro.dao;
import java.util.List;
import niit.foodgro.model.Category;

public interface Categorydao {
	public boolean save(Category category);
	public boolean update(Category category);
	public void delete(String id);
	public Category get(String id);
	public List<Category> list();

}


