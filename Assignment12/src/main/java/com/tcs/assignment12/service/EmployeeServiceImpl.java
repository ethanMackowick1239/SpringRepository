package com.tcs.assignment12.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.assignment12.model.Employee;
import com.tcs.assignment12.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	public String addEmployee(Employee employee) {
		Employee employee2 = null;
		try {
			employee2 = employeeRepository.save(employee);
			return "success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "fail";
		}
	}


	public String deleteEmployee(long id) {
		
		employeeRepository.deleteById(id);
		return "success";
	}

	public String updateEmployee (long id, Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}

	public Optional<List<Employee>> getEmployees() {
		// TODO Auto-generated method stub
		return Optional.ofNullable(employeeRepository.findAll());
	}

	public Optional<List<Employee>> findByOrganization(long id) {
		// TODO Auto-generated method stub
		return employeeRepository.findByOrganization(id);
	}


	public Optional<Employee> findById(long id) {
		// TODO Auto-generated method stub
		return employeeRepository.findById(id);
	}

}
