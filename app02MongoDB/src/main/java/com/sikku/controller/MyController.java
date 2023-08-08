package com.sikku.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sikku.document.Employee;
import com.sikku.service.EmployeeService;

@RestController
public class MyController {
	
	@Autowired
	private EmployeeService service;

	@RequestMapping(value="/wish",method = RequestMethod.GET)
	public String wish() {
		Employee emp = new Employee();
		emp.setEname("qwertyui");
		service.save(emp);
		return "STS";
	}
	
	@RequestMapping(value="/wish",method = RequestMethod.POST)
	public String hello() {
		Employee emp = new Employee();
//		emp.setEname("AAA");
		service.save(emp);
		return "HELLO";
	}
}
