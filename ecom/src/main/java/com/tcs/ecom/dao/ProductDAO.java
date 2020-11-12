package com.tcs.ecom.dao;

import java.util.List;
import java.util.Optional;

import com.tcs.ecom.model.Product;

public interface ProductDAO {
	public String createProduct(Product product);
	public Optional <Product> getProductById(int id);
	public Optional <List<Product>> getProducts();
	public String removeProduct(int Id);
	public Optional <Product> updateProduct(int id, Product product);
}
