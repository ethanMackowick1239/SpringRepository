package com.tcs.employee.model;

import java.util.ArrayList;
import java.util.List;

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
@Table(name = "organization_table")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Organization {
	
	@Id
	@Column(name = "organization_id")
	private Long id; 
	private String name; 
	private String address; 
	
	
	@OneToMany(mappedBy = "organization",fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	private List<Employee> employees = new ArrayList<>(); 



}
