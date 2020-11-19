package com.tcs.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.ecommerce.dao.ProductDAO;
import com.tcs.ecommerce.dao.ProductDAOImpl;
import com.tcs.ecommerce.model.Product;
import com.tcs.ecommerce.repository.ProductRepository;

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
	public Optional<List<Product>> getProductByCategory(String cat) {
		return Optional.ofNullable(productRepository.findByCategory(cat));
	}

	@Override
	public Optional<List<Product>> findByPriceGreaterThan(float price) {
		return Optional.ofNullable(productRepository.findByPriceGreaterThan(price));// TODO Auto-generated method stub
		
	}

	@Override
	public Optional<List<Product>> findByCategoryAndPriceLessThan(String cat, float price) {
		return Optional.ofNullable(productRepository.findByCategoryAndPriceLessThan(cat, price));// TODO Auto-generated method stub

	}

	@Override
	public Optional<List<Product>> findByProductNameLike(String name) {
		return Optional.ofNullable(productRepository.findByProductNameLike(name));

	}

}
