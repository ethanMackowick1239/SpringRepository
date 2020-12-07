package com.tcs.assignment12.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.assignment12.model.Employee;
import com.tcs.assignment12.service.EmployeeService;

@RestController
@RequestMapping("/api/v1/product")
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
	
	
	@GetMapping
	public List<Employee> getEmployee() {
		return employeeService.getEmployees().get();
	}
	
	@GetMapping("/{id}")
	public Employee getEmployeeById(@PathVariable("id")int employeeId ) {
		return employeeService.findById(employeeId).get();
	}
	//ALL THIS MAPPING REFERS TO THE NUMBER AT THE END OF THE URL EX. http://localhost/api/v1/product/1
	//will show product wiht id 1 when using GET. It will delete when using DELETE 
	
	@DeleteMapping("/{id}")
	public String deleteEmployeeById(@PathVariable("id")int employeeId) {
		employeeService.deleteEmployee(employeeId);
		return "success";
	}
	
	@PostMapping("/create")
	public String createEmployee(@RequestBody Employee employee) {
	
	  return 	employeeService.addEmployee(employee);
	}

}
