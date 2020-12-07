package com.tcs.assignment12.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.assignment12.model.Department;
import com.tcs.assignment12.model.Employee;
import com.tcs.assignment12.repository.DepartmentRepository;
import com.tcs.assignment12.repository.EmployeeRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	
	@Autowired
	DepartmentRepository departmentRepository;
	
	@Override
	public String addDepartment(Department department) {
		Department department2 = null;
		try {
			department2 = departmentRepository.save(department);
			return "success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "fail";
		}
	}

	@Override
	public Optional<Department> findById(long id) {
		// TODO Auto-generated method stub
		return departmentRepository.findById(id);
	}

	@Override
	public String deleteDepartment(long id) {
		// TODO Auto-generated method stub
		departmentRepository.deleteById(id);
		return "success";
	}

	@Override
	public String updateDepartment(long id, Department department) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<List<Department>> getDepartments() {
		// TODO Auto-generated method stub
		return Optional.ofNullable(departmentRepository.findAll());
	}

}
