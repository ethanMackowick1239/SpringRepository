package com.tcs.productrestapi.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ManyToAny;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Page {
	@Id
	private long id;
	private int number;
	private String content;
	private String chapter;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="book_id")
	private Book book;
	

}
