package com.tcs.ecom.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
	private int productId;
	private String productName;
	private String productDescription;
	private float price;
	private String category;
	
	

}
