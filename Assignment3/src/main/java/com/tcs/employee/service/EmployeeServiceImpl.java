package com.tcs.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.employee.dao.EmployeeDAO;
import com.tcs.employee.dao.EmployeeDAOImpl;
import com.tcs.employee.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDAO employeeDao;
	
	public String addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeDao.addEmployee(employee);
	}


	public String deleteEmployee(long id) {
		// TODO Auto-generated method stub
		return employeeDao.deleteEmployee(id);
	}

	public String updateEmployee (long id, Employee employee) {
		// TODO Auto-generated method stub
		return employeeDao.updateEmployee(id, employee);
	}

	public Optional<List<Employee>> getEmployees() {
		// TODO Auto-generated method stub
		return employeeDao.getEmployees();
	}

	public Optional<List<Employee>> findByOrganization(long id) {
		// TODO Auto-generated method stub
		return employeeDao.findByOrganization(id);
	}


	public Optional<Employee> findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
