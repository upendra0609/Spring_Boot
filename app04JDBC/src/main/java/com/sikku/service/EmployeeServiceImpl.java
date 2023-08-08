package com.sikku.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sikku.document.Employee;
import com.sikku.repository.IEmployeeRepo;

@Service("employeeService")
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private IEmployeeRepo employeeRepo;

	@Override
	public String save(Employee emp) {
		return employeeRepo.save(emp);
	}

}
