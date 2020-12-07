package com.tcs.assignment12.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcs.assignment12.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
