package com.grostore.controller;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.grostore.dao.CategoryDAO;
import com.grostore.dao.SupplierDAO;
import com.grostore.dao.UserDAO;
import com.grostore.model.Category;
import com.grostore.model.Supplier;
import com.grostore.model.UserDetails;
	
	/*import com.niit.shopcart.dao.CategoryDAO;
	import com.niit.shopcart.dao.ProductDAO;
	import com.niit.shopcart.dao.SupplierDAO;
	import com.niit.shopcart.model.Category;
	import com.niit.shopcart.model.Product;
	import com.niit.shopcart.model.Supplier;
	*/
	

	@Controller
	public class LoginController {
		@Autowired
		UserDetails userDetails;
		@Autowired(required=true)
		UserDAO userDAO;
		@Autowired
		Category category;
		@Autowired
		CategoryDAO categoryDAO;
		@Autowired
		Supplier supplier;
		@Autowired
		SupplierDAO supplierDAO;
		/*@Autowired
		Product product;
		@Autowired
		ProductDAO productDAO;*/
		
		
		
		
		@RequestMapping("/Login")
		public ModelAndView loginHere()
		{
			System.out.println("login page");
			ModelAndView mv = new ModelAndView("Login");
			mv.addObject("userDetails", userDetails);
			return mv;
		}
		
		/*@RequestMapping("/isValidUser")
		public ModelAndView showMessage(@RequestParam(value = "username") String username,
				@RequestParam(value = "password") String password) {
			System.out.println("in controller");

			String message;
			ModelAndView mv ;
			if (userDAO.isValidUser(username,password)) 
			{
				message = "Successfully Logged in";
				 mv = new ModelAndView("user");
			} else{
				message="Please enter a valid username and password";
				mv=new ModelAndView("Login");
			}

			mv.addObject("message", message);
			mv.addObject("username", username);
			return mv;
		}
	*/	
		@RequestMapping(value="/isValidUser")
		public ModelAndView login(@RequestParam(value="username") String username,
				@RequestParam(value="password") String password,HttpSession session){
			System.out.println("login controller");
			userDetails = userDAO.isValidUser(username, password);
			ModelAndView mv = null;
			if(userDetails == null){
	        mv = new ModelAndView ("Login");
			mv.addObject("message", "please try again");
		} else {
			if (userDetails.getRole().equals("ROLE_ADMIN")){
				mv = new ModelAndView("Admin");
			session.setAttribute("categoryList", categoryDAO.list());
			session.setAttribute("supplierList", supplierDAO.list());
			/*session.setAttribute("productList", productDao.list());
			
			session.setAttribute("category", category);
			session.setAttribute("supplier", supplier);
			session.setAttribute("product", product);*/
		
				}
		else if (userDetails.getRole().equals("ROLE_USER")){
				mv = new ModelAndView("categories");
			session.setAttribute("username", userDetails.getUsername());
		}
		}
		return mv;	
		}
	}



	

