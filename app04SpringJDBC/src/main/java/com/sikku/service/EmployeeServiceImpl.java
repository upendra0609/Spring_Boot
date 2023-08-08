package com.sikku.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sikku.document.Employee;
import com.sikku.repository.IEmployeeRepo;

@Service("employeeService")
@Transactional
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private IEmployeeRepo employeeRepo;

	@Override
	public String save(Employee emp) {
		String status = "";
		try {
			boolean existsById = employeeRepo.existsById(emp.getId());
			if (!existsById) {
				emp.isNew = true;
				Employee emp1 = employeeRepo.save(emp);
				status = emp1.getEno().equals(emp.getEno()) ? "Employee Inserted" : "Employee Not Inserted";
			} else {
				status = "Employee Already exist";

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}

	@Override
	public Employee search(int eno) {
		Employee emp;
		try {
			Optional<Employee> findById = employeeRepo.findById(eno);
			emp = findById.isEmpty() ? null : findById.get();

		} catch (Exception e) {
			emp = null;
			e.printStackTrace();
		}
		return emp;
	}

	@Override
	public String update(Employee emp) {
		String status = "";
		try {
			boolean existsById = employeeRepo.existsById(emp.getId());
			if (existsById) {
				Employee emp1 = new Employee();
				emp1.isNew = false;
				Employee save = employeeRepo.save(emp);
				status = save.getEno().equals(emp.getEno()) ? "Employee Updated" : "Employee not Updated";
			} else {
				status = "Employee Does Not Exist";

			}

		} catch (Exception e) {
			status = "Employee not Updated";
			e.printStackTrace();
		}

		return status;
	}

	@Override
	public String delete(int eno) {
		String status = "";
		try {
			boolean existsById = employeeRepo.existsById(eno);
			if (!existsById) {
				status = "Employee Does not Exist";
			} else {
				employeeRepo.deleteById(eno);
				status = "Employee Deleted";
			}

		} catch (Exception e) {
			status = "Employee not Deleted";
			e.printStackTrace();
		}

		return status;
	}

}
