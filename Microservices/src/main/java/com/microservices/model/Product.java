package com.microservices.model;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Product {
	private Long productId;
	private String productName;
	private String category;
	private String description;
	private Date expiryDate;
}
