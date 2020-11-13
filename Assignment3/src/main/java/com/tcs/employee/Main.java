package com.tcs.employee;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.tcs.employee.config.DBConfig;
import com.tcs.employee.dao.EmployeeDAO;
import com.tcs.employee.dao.EmployeeDAOImpl;
import com.tcs.employee.model.Employee;
import com.tcs.employee.service.EmployeeService;
import com.tcs.employee.service.EmployeeServiceImpl;

public class Main {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DBConfig.class);
		
		//DataSource dataSource = context.getBean("mySqlDataSource", DataSource.class);
		
		EmployeeService employeeService = context.getBean(EmployeeService.class);
		Employee employee = new Employee(2l, 1l, 1l, "Ethan", 23, "Big Boy");
		Employee employee2 = new Employee(2l,1l, 1l, "Bob", 23, "Big Boy");
		
		String add = employeeService.addEmployee(employee);
		System.out.println(add);
		
		Optional<Employee> findById= employeeService.findById(1);
		System.out.println(findById);
		
		String delete=employeeService.deleteEmployee(1);
		System.out.println(delete);
		
		String update = employeeService.addEmployee(employee2);
		System.out.println(update);
		
		Optional<List<Employee>> organization = employeeService.findByOrganization(1l);
		System.out.println(organization);
		
		Optional<List<Employee>> allEmployees = employeeService.getEmployees();
		System.out.println(allEmployees);
		
		
		//System.out.println(dataSource);
		System.out.println(employeeService);
		context.close();
	}
}
