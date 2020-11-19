package com.tcs.employee.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "department_table")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department {
	
	@Id
	@Column(name = "department_id")
	private Long id; 
	private Long organizationId; 
	private String name;  
	
	@OneToMany(mappedBy = "department",fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	private Set<Employee> employee = new HashSet<>();
}
