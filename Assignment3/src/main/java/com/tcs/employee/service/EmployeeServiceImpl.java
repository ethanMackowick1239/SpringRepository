package com.tcs.employee.service;

import java.util.Optional;

import com.tcs.employee.dao.EmployeeDAO;
import com.tcs.employee.dao.EmployeeDAOImpl;
import com.tcs.employee.model.Employee;

public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeServiceImpl() {
		
	}
	private static EmployeeService dao;
	public static EmployeeService getInstance() {
		if(dao==null) {
			dao = new EmployeeServiceImpl();
			System.out.println("inside the if condition");
			return dao;
		}
		return dao;
	}
	EmployeeDAO employeeDao = EmployeeDAOImpl.getInstance();
	
	public String addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeDao.addEmployee(employee);
	}

	public Optional<Employee> findById(Long id) {
		// TODO Auto-generated method stub
		return employeeDao.findById(id);
	}

}
