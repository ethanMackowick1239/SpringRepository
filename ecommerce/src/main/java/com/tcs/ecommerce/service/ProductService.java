package com.tcs.ecommerce.service;

import java.util.List;
import java.util.Optional;

import com.tcs.ecommerce.model.Product;

public interface ProductService {
	
	public String createProduct(Product product);
	public Optional<Product> getProductById(int id);
	public void deleteProduct(int id);
	public Optional <java.util.List<Product>> getProducts();
	public Optional <java.util.List<Product>> getProductByCategory(String cat);
	public Optional <java.util.List<Product>> findByPriceGreaterThan(float price);
	public Optional <java.util.List<Product>> findByCategoryAndPriceLessThan(String cat, float price);
	public Optional <java.util.List<Product>> findByProductNameLike(String name);

}
