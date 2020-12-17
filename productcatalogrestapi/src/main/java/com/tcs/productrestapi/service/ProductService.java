package com.tcs.productrestapi.service;

import com.tcs.productrestapi.model.Product;
import java.util.List;
import java.util.Optional;

public interface ProductService {
	public Product createProduct(Product product);
	public Product updateProduct(Long productId, Product product);
	public String deleteProduct(Long productId);	
	public Optional<Product> getProductById(Long productId);
	public Optional<List<Product>> getAllProducts();
	public Optional<List<Product>> getProductByCategory(String category);
}
