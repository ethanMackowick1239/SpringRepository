package com.tcs.springbootdemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.springbootdemo.model.Product;
import com.tcs.springbootdemo.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
// applying singleton 
	// task for u
	
	
	@Autowired
	ProductRepository productRepository;
	
	@Override
	public String createProduct(Product product) {
		// TODO Auto-generated method stub
		Product product2 = null;
		try {
			product2 = productRepository.save(product);
			return "success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "fail";
		}
	}

	@Override
	public Optional<Product> getProductById(int id) {
		// TODO Auto-generated method stub
		
		
		return productRepository.findById(id);
	}

	@Override
	public void deleteProduct(int id) {
		// TODO Auto-generated method stub
		productRepository.deleteById(id);
	}

	@Override
	public Optional<List<Product>> getProducts() {
		// TODO Auto-generated method stub
		return Optional.ofNullable(productRepository.findAll());
	}

	@Override
	public Optional<List<Product>> getProductsByCategory(String catName) {
		// TODO Auto-generated method stub
		return Optional.ofNullable(productRepository.findByCategory(catName));
		//return null;
	}

}
