package com.tcs.assignment12.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcs.assignment12.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	public Employee findByOrganizationId();

}
