package com.sikku.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sikku.document.Employee;
import com.sikku.service.IEmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private IEmployeeService employeeService;
	
	@RequestMapping(value = "/save", method = RequestMethod.GET)
	public String save() {
		Employee emp = new Employee();
		emp.setEno(12345);
		emp.setEname("asdfg");
		emp.setEsal(1234.56f);
		emp.setEaddr("Delhi");
		String save = employeeService.save(emp);
		
		return save;
	}
}
