package com.tcs.employee.service;

import java.util.List;
import java.util.Optional;

import com.tcs.employee.model.Employee;

public interface EmployeeService {
	
	public String addEmployee(Employee Employee);
	public Optional<Employee> findById(long id);
	public String deleteEmployee(long id);
	public String updateEmployee(long id, Employee employee);
	public Optional<List<Employee>> getEmployees();
	public Optional<List<Employee>> findByOrganization(long id);
	

}
