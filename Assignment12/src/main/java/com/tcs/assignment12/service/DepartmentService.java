package com.tcs.assignment12.service;

import java.util.List;
import java.util.Optional;

import com.tcs.assignment12.model.Department;


public interface DepartmentService {
	public String addDepartment(Department department);
	public Optional<Department> findById(long id);
	public String deleteDepartment(long id);
	public String updateDepartment(long id, Department department);
	public Optional<List<Department>> getDepartments();
}
