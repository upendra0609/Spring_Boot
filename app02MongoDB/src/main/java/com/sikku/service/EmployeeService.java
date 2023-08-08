package com.sikku.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sikku.document.Employee;
import com.sikku.repository.IEmployeeRepo;

@Service("service")
public class EmployeeService {

	@Autowired
	private IEmployeeRepo repo;

	public String save(Employee employee) {
		return repo.insert(employee).getEname();

	}

}
