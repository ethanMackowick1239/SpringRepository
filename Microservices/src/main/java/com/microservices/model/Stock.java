package com.microservices.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Stock {

	private long stockId;
	
	private long productId;
	
	private int quantity;
	
	private String location;
}
