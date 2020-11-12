package com.tcs.ecommerce.service;

import java.util.Optional;

import com.tcs.ecommerce.dao.ProductDAO;
import com.tcs.ecommerce.dao.ProductDAOImpl;
import com.tcs.ecommerce.model.Product;

public class ProductServiceImpl implements ProductService {
	
	private ProductServiceImpl() {
		
	}
	private static ProductService dao;
	public static ProductService getInstance() {
		if(dao==null) {
			dao = new ProductServiceImpl();
			System.out.println("inside the if condition");
			return dao;
		}
		return dao;
	}
	ProductDAO productDao = ProductDAOImpl.getInstance();
	
	@Override
	public String createProduct(Product product) {
		// TODO Auto-generated method stub
		return productDao.createProduct(product);
	}

	@Override
	public Optional<Product> getProductById(int id) {
		// TODO Auto-generated method stub
		return productDao.getProductById(id);
	}

}
