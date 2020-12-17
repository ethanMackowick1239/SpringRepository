package com.tcs.productrestapi.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.productrestapi.model.Product;
import com.tcs.productrestapi.repository.ProductRepository;
import com.tcs.productrestapi.exception.ExpiryDateException;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;
	
	@Override
	public Product createProduct(Product product) {
		// TODO Auto-generated method stub
		Product product2 = null;
		try {
			if (isExpired(product)) {
				throw new ExpiryDateException("Product to be added is expired!");
			}
			product2 = productRepository.save(product);
			return product2;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
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

	@Override
	public Product updateProduct(Long productId, Product product) {
		Product product2 = null;
		try {
			if (isExpired(product)) {
				throw new ExpiryDateException("Product to be added is expired!");
			}
			product2 = productRepository.save(product);
			return product2;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public String deleteProduct(Long productId) {
		// TODO Auto-generated method stub
		try{
			productRepository.deleteById(productId);
			return "success";
		}
		catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
	}

	@Override
	public Optional<Product> getProductById(Long productId) {
		// TODO Auto-generated method stub
		try {
//			if(isExpired(productRepository.findById(productId).get())) {
//				throw new ExpiryDateException("The product you are trying to find is expired!");
//			}
//			else
				return productRepository.findById(productId);
				
		} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}

	@Override
	public Optional<List<Product>> getAllProducts() {
		// TODO Auto-generated method stub
		return Optional.ofNullable(productRepository.findAll());
	}

	@Override
	public Optional<List<Product>> getProductByCategory(String category) {
		// TODO Auto-generated method stub
		return Optional.ofNullable(productRepository.findByCategory(category));
	}

}
