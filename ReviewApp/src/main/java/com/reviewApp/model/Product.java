package com.reviewApp.model;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {


	private int productId;
	private String productName;
	private String description;
	private float price;
	private String category;
	// if we are not provideing any annotation like @column then 
	// it will take field name as a column name & will have default size 
	
}
