package com.sikku.service;

import com.sikku.document.Employee;

public interface IEmployeeService {

	String save(Employee emp);
	Employee search(int eno);
	String update(Employee emp);
	String delete(int eno);
}
