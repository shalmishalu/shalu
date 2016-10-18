package com.grostore.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.grostore.dao.SupplierDAO;
import com.grostore.model.Supplier;


@Controller
public class SupplierController {

	@Autowired
	Supplier supplier;
	@Autowired
	SupplierDAO supplierDAO;
	
	@RequestMapping(value="/supplierList", method=RequestMethod.GET)
	public String listsupplier(Model model){
	model.addAttribute("supplier",supplier);
	model.addAttribute("supplierList",this.supplierDAO.list());
	return "supplier";
	}
	@RequestMapping(value="/supplier/add")
	public ModelAndView addsupplier(@ModelAttribute Supplier supplier){
		boolean flag=supplierDAO.save(supplier);
		ModelAndView mv = new ModelAndView("supplier");
		String msg= "added Successfully";
if(flag!=true)
{
	msg = "operation could not success";
}
mv.addObject("msg", msg);
return mv;

	}
	@RequestMapping("/supplier/remove/{id}")
	public ModelAndView deletesupplier(@PathVariable("id") String id)throws Exception{
		boolean flag = supplierDAO.delete(id);
		ModelAndView mv = new ModelAndView("supplier");
				String msg= " Deleted Successfully";
		if(flag!=true)
		{
			msg = "operation could not success";
		}
		mv.addObject("msg", msg);
		return mv;
	}
	@RequestMapping("/supplier/edit/{id}")
	public String editsupplier(@ModelAttribute("supplier")Supplier supplier){
		supplierDAO.update(supplier);
		return "supplier";
	}
	@RequestMapping("/supplier")
	public ModelAndView supplier(@ModelAttribute Supplier supplier){
		return new ModelAndView("supplier");
	}
}



