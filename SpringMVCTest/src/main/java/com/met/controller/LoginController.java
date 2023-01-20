package com.met.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.met.model.Employee;
import com.met.service.EmployeeService;

@Controller
@RequestMapping("/login")

public class LoginController {

	@Autowired
	private EmployeeService service;
	
	@PostMapping
	public ModelAndView adding(@ModelAttribute Employee emp) {
		
		emp.setId(emp.getId());
		service.save(emp);
		int empId1=emp.getId();
		
		String name=emp.getName();
		
		ModelAndView modelAndView=new ModelAndView();
		
		Employee employee=new Employee();
		modelAndView.addObject("EmpId", empId1);
		modelAndView.addObject("emp", employee);
		
		modelAndView.addObject("userName",name);
		
		modelAndView.setViewName("login");
		return modelAndView;
		
	}
}
