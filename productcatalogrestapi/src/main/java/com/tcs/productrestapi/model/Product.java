package com.tcs.productrestapi.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product_tbl")

public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long productId;
	private String productName;
	private String category;
	private String description;
	private Date expiryDate;
	
}
