package com.tcs.ecommerce.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.ecommerce.dao.ProductDAO;
import com.tcs.ecommerce.dao.ProductDAOImpl;
import com.tcs.ecommerce.model.Product;

@Service
public class ProductServiceImpl implements ProductService {
	
	
	@Autowired
	private ProductDAO productDao;
	
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
