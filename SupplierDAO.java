package com.grostore.dao;
import java.util.List;

import com.grostore.model.Supplier;
public interface SupplierDAO {
	public boolean save(Supplier supplier);
	public boolean update(Supplier supplier);
	public List<Supplier> list();
	public Supplier get(String id);
	public boolean delete(String id);
	}