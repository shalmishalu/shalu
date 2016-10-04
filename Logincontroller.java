package com.grobuz.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.grobuz.dao.Categorydao;
import com.grobuz.dao.Productdao;
import com.grobuz.dao.Supplierdao;
import com.grobuz.dao.Userdao;
import com.grobuz.model.Category;
import com.grobuz.model.Product;
import com.grobuz.model.Register;
import com.grobuz.model.Supplier;

@Controller
public class Logincontroller {
	@Autowired
	private Categorydao categorydao;
	@Autowired
	private Category category;
	@Autowired
	private Productdao productdao;
	@Autowired
	private Product product;
	@Autowired
	private Supplierdao supplierdao;
	@Autowired
	private Supplier supplier;
	@Autowired
	private Userdao userdao;
	@Autowired
	Register register;
	@Autowired
	private HttpSession session;
	@RequestMapping("/login")
	public ModelAndView login(@RequestParam(value="name") String username,
			@RequestParam(value="password") String password)
	{
	register= userdao.isValidUser(username,password);
	ModelAndView mv=null;
	if(register==null){
	mv=new ModelAndView("Home");
	mv.addObject("errormessage","Invalid credentials..please try again");
	}
	else
	{
		if(register.getRole().equals("ROLE_ADMIN"))
		{
			mv=new ModelAndView("admin");
			session.setAttribute("categoryList", categorydao.list());
			session.setAttribute("supplierList", supplierdao.list());
			session.setAttribute("productList", productdao.list());
	session.setAttribute("category", category);
	session.setAttribute("supplier", supplier);
	session.setAttribute("product", product);
		}
		else if(register.getRole().equals("ROLE_USER"))
			mv=new ModelAndView("home");
		session.setAttribute("Username", register.getUsername());
		session.setAttribute("Username", register.getUsername());
	}
	return mv;
	}
}
	

