package com.tcs.priceservice.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "price_tbl")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Price {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="price_id")
	//@Size(max=20, min =3 ,message = "price ID is not valid")
	private long priceId; 
	@Column(name = "product_id")
//	@Size(max=20, min =3 ,message = "product ID is not valid")
	private long productId;
	@Column(name = "priceValue")
	@Min(value =0 ,message = "price value is not valid")
	private float priceValue;
	

}
