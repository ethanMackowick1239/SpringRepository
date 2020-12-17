package com.microservices.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Review {

	private long id;
	private String comment;
	private int rating;
	private long productId;
	private String username;
	 
}
