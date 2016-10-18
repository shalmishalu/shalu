package com.grostore.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.grostore.dao.UserDAO;
import com.grostore.model.UserDetails;



	@Controller
	public class HomeController {
		@Autowired
		UserDetails userDetails;
		@Autowired(required=true)
		UserDAO userDAO;
		
		
		
		@RequestMapping("/Contact")
		public String contact(){
			return "Contact";
		}
		@RequestMapping("/Aboutus")
		public String Aboutus(){
			return "Aboutus";
		}
		@RequestMapping("/Register")
		public ModelAndView registerhere()
		{
			ModelAndView mv = new ModelAndView("Register");
			mv.addObject("userDetails", userDetails);
		
			return mv;
		}
		@RequestMapping(value="Success",method = RequestMethod.POST)
		public ModelAndView registerUser(@ModelAttribute UserDetails userDetails)
		{
			ModelAndView mv;
			String msg;
			msg="Please log in to continue";
			userDAO.save(userDetails);
		  
			mv= new ModelAndView("/Success");
			mv.addObject("msg",msg);
			return mv;
	}
		
	}

