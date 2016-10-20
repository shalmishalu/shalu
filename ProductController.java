package com.grostore.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.grostore.dao.CategoryDAO;
import com.grostore.dao.ProductDAO;
import com.grostore.dao.SupplierDAO;
import com.grostore.model.Category;
import com.grostore.model.Product;
import com.grostore.model.Supplier;
import com.grostore.util.Util;

@Controller
public class ProductController {

	@Autowired(required=true)
	private ProductDAO productDAO;
	
	@Autowired(required=true)
	private CategoryDAO categoryDAO;
	
	@Autowired(required=true)
	private SupplierDAO supplierDAO;
	
	/*private String path=";
	*/
	@RequestMapping(value="/product")
	public String listProduct(Model model)
	{
		model.addAttribute("product", new Product());
		model.addAttribute("supplier", new Supplier());
		model.addAttribute("category",new Category());
		model.addAttribute("productList",this.productDAO.list());
		model.addAttribute("categoryList",this.categoryDAO.list());
		model.addAttribute("supplierList",this.supplierDAO.list());
		return "product";
	}
	
	@RequestMapping(value="/addproduct")
public String addProduct(@ModelAttribute("product")Product product,Model model)
{
		String newID=	Util.removeComma(product.getId());
		product.setId(newID);
		Category category = categoryDAO.getByName(product.getCategory().getName());
		categoryDAO.saveOrUpdate(category);
		Supplier supplier = supplierDAO.getByName(product.getSupplier().getName());
		supplierDAO.saveOrUpdate(supplier);
		
		product.setCategory(category);
		product.setSupplier(supplier);
		
		product.setCategory_id(category.getId());
		product.setSupplier_id(supplier.getId());
		
		productDAO.saveOrUpdate(product);
	/*	
		MultipartFile image= product.getImage();
		FileUtil.upload(path, image, product.getId()+".jpg");*/
		
		model.addAttribute("productList",this.productDAO.list());
	  return "product";
}
	
@RequestMapping("removeproduct/{id}")
public String deleteProduct(@PathVariable("id")String id ,ModelMap model)throws Exception{
try{
	productDAO.delete(id);
	model.addAttribute("msg", "successfully added");
}
catch (Exception e)
{
	model.addAttribute("msg", e.getMessage());
	e.printStackTrace();
}
		return "redirect:/product";
	}

@RequestMapping("editproduct/{id}")
public String editProduct(@PathVariable("id")String id, Model model) 
{
	System.out.println("editproduct");
	model.addAttribute("product", this.productDAO.get(id));
	model.addAttribute("ProductList", this.productDAO.list());
	model.addAttribute("categoryList",this.categoryDAO.list());
	model.addAttribute("supplierList",this.supplierDAO.list());
	

	return "product";
}

@RequestMapping("product/get/{id}")
public String getSelectedproduct(@PathVariable("id") String id, Model model ,RedirectAttributes redirectAttributes) 
{
	System.out.println("getSelectedproduct");
	redirectAttributes.addFlashAttribute("selectedproduct", this.productDAO.get(id));
model.addAttribute("categoryList", this.categoryDAO.list());
	return "redirect:/index";
	}

}




