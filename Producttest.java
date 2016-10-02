package niit.foodgro.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import niit.foodgro.dao.Productdao;
import niit.foodgro.model.Product;
public class Producttest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext Context = new AnnotationConfigApplicationContext();
		
		Context.scan("niit.foodgro");
		Context.refresh();
	    Productdao productdao = (Productdao) Context.getBean("productdao");
		Product product = (Product) Context.getBean("product");
		product.setId("32");
	   product.setName("granola");
		product.setPrice("345");
		product.setCategory_id("18");
		product.setSupplier_id("hai");
		productdao.save(product);
		System.out.println("Products are inserted successfully");
	}

}


