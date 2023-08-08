package com.sikku.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sikku.document.Employee;

@Repository
public interface IEmployeeRepo extends CrudRepository<Employee, Integer> {

}
