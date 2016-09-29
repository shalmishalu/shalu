package niit.foodgro.dao;


import niit.foodgro.model.Supplier;

public interface Supplierdao {
	public boolean save(Supplier supplier);
	public boolean update(Supplier supplier);
	public void delete(String id);

}
