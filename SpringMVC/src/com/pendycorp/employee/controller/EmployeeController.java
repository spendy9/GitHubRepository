package com.pendycorp.employee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pendycorp.employee.model.Employee;



@Controller
public class EmployeeController {

	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcomePage(Model model){
		model.addAttribute("employee", new Employee());
		return "index";
	}
	
	
	@RequestMapping(value="/index", method= RequestMethod.GET)
	public ModelAndView enterEmployee(){
		return new ModelAndView("index", "employee", new Employee());
	}
	
	@RequestMapping(value="/addEmployee", method = RequestMethod.POST)
	public String submit(@ModelAttribute("employee")Employee employee, BindingResult result, ModelMap model){
		model.addAttribute("name", employee.getName());
		model.addAttribute("id", employee.getId());
		model.addAttribute("contactNumber",employee.getContactNumber());
		return "employeeDetails";
	}
	
}
