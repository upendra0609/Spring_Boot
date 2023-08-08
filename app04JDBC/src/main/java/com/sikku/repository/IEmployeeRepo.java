package com.sikku.repository;

import org.springframework.stereotype.Repository;

import com.sikku.document.Employee;


public interface IEmployeeRepo {
	public String save(Employee emp);

}
