package com.tcs.employee;

import java.util.Optional;

import com.tcs.employee.dao.EmployeeDAO;
import com.tcs.employee.dao.EmployeeDAOImpl;
import com.tcs.employee.model.Employee;
import com.tcs.employee.service.EmployeeService;
import com.tcs.employee.service.EmployeeServiceImpl;

public class Main {

	public static void main(String[] args) {
		
		Employee employee = new Employee(1l,1l , 1l, "Ethan", 25, "Big boy");
		
		EmployeeService employeeService =  EmployeeServiceImpl.getInstance();
		
		String result = employeeService.addEmployee(employee);
		
		
		if("success".equals(result)) {
			System.out.println("recored added successfully");
		}
		else {
			System.out.println("problem");
		}
		
		Optional<Employee> optional= employeeService.findById(2l);
		
		if(optional.isPresent()) {
			Employee product2 = optional.get();
			System.out.println(product2);
		}
		else {
			System.out.println("product is not available");
		}
		
	}
}
