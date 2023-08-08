package com.sikku.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sikku.document.Employee;

public interface IEmployeeRepo extends MongoRepository<Employee, String> {

}
