package com.tcs.productrestapi.exception;

import java.util.Date;

import com.tcs.productrestapi.model.Product;

public class ExpiryDateException extends Exception {
	public ExpiryDateException(String msg) {
		// TODO Auto-generated constructor stub
		super(msg);
	}
	
	private boolean isExpired(Product product) {
		
		Date curDate =java.util.Calendar.getInstance().getTime();
		Date expiryDate = new java.util.Date(product.getExpiryDate().getTime());
		if (expiryDate.compareTo(curDate) < 0) {
			return true;
		}
		else
			return false;
	}
}
