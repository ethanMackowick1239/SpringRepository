package com.tcs.ecom;

import com.tcs.ecom.dao.ProductDAO;
import com.tcs.ecom.model.Product;

public class Main {
	public static void main(String[] args) {
		Product product = new Product();
		
		ProductDAO dao = ProductDaOImpl.getInstance();
		ProductDAO dao2 = ProductDaOImpl.getInstance();
		
		System.out.println(dao.hashCode());
		System.out.println(dao2.hashCode());
		System.out.println(dao.equals(dao2));
	}
}
