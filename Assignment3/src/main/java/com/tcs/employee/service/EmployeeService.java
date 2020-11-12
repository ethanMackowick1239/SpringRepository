package com.tcs.employee.service;

import java.util.Optional;

import com.tcs.employee.model.Employee;

public interface EmployeeService {
	
	public String addEmployee(Employee Employee);
	public Optional<Employee> findById(Long id);

}
