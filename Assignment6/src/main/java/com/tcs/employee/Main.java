package com.tcs.employee;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.tcs.employee.config.DBConfig;
import com.tcs.employee.model.Department;
import com.tcs.employee.model.Employee;
import com.tcs.employee.repository.DepartmentRepository;
import com.tcs.employee.repository.EmployeeRepository;


public class Main {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DBConfig.class);
		
		//DataSource dataSource = context.getBean("mySqlDataSource", DataSource.class);
		
		
		EmployeeRepository employeeRepository = context.getBean(EmployeeRepository.class);
		DepartmentRepository departmentRepository = context.getBean(DepartmentRepository.class);
		Department department = new Department(0l, 0l, "Marketing", null);
		departmentRepository.save(department);
		
		Employee employee = new Employee(1l, 1l, 1l, "Ethan", 23, "Big Boy", department);
		Employee employee2 = new Employee(2l,1l, 1l, "Bob", 23, "Big Boy", department);
		Employee employee3 = new Employee(3l,1l, 1l, "Bob", 23, "Big Boy", department);
		employeeRepository.save(employee);
		employeeRepository.save(employee2);
		employeeRepository.save(employee3);
//		
//		Optional<Employee> findById= employeeService.findById(1);
//		System.out.println(findById);
//		
//		String delete=employeeService.deleteEmployee(1);
//		System.out.println(delete);
//		
//		String update = employeeService.addEmployee(employee2);
//		System.out.println(update);
//		
//		Optional<List<Employee>> organization = employeeService.findByOrganization(1l);
//		System.out.println(organization);
//		
//		Optional<List<Employee>> allEmployees = employeeService.getEmployees();
//		System.out.println(allEmployees);
		
		
		//System.out.println(dataSource);
		context.close();
	}
}
