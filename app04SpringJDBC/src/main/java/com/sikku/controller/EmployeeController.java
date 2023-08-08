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
		String status = "";

		Employee emp = new Employee();
		emp.setEno(300);
		emp.setEname("AAA");
		emp.setEsal(12500.5f);
		emp.setEaddr("satna");
		status = employeeService.save(emp);

		return status;
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String search() {
		String status = "";
		Employee search = employeeService.search(300);
		status = search.toString();

		return status;
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update() {
		String status = "";

		Employee emp = new Employee();
		emp.setEno(300);
		emp.setEname("BBB");
		emp.setEsal(2500.5f);
		emp.setEaddr("rewa");
		status = employeeService.update(emp);

		return status;
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete() {
		String status = "";

		status = employeeService.delete(100);

		return status;
	}
}
