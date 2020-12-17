package com.tcs.stock.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Stock")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Stock {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "stockId")
	private long stockId;
	
	private long productId;
	
	@Min(value = 0, message = "The value must be positive")
	private int quantity;
	
	private String location;
}
