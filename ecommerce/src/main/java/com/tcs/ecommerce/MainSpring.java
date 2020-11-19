package com.tcs.ecommerce;

import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.tcs.ecommerce.config.DBConfig;
import com.tcs.ecommerce.model.Product;
import com.tcs.ecommerce.service.ProductService;

public class MainSpring {
	
	public static void main(String[] args) {
		System.out.println("Before object creating");
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DBConfig.class);
		System.out.println("after context creation");
		ProductService productService = context.getBean(ProductService.class);
		ProductService productService2 = context.getBean(ProductService.class);
		Product product = new Product(9, "baptop", "i5 1oth gen",90.0f, "baby");
		String result = productService.createProduct(product);
		System.out.println(result);
//		System.out.println(productService.equals(productService2));
//		System.out.println(productService == productService2);
		
//		Optional <List<Product>> optional = productService.getProductByCategory("baby");
//		if(optional.isPresent()) {
//			List<Product> listP = optional.get();
//			listP.forEach(p -> {
//				System.out.println(p);
//			});
//			System.out.println("success");
//
//		}
//		else {
//			System.out.println("nah");
//		}
		
//		Optional <List<Product>> optional = productService.findByPriceGreaterThan(100.0f);
//		if(optional.isPresent()) {
//			List<Product> listP = optional.get();
//			listP.forEach(p -> {
//				System.out.println(p);
//			});
//			System.out.println("success");
//
//		}
//		else {
//			System.out.println("nah");
//		}
		
//		Optional <List<Product>> optional = productService.findByCategoryAndPriceLessThan("baby",100.0f);
//		if(optional.isPresent()) {
//			List<Product> listP = optional.get();
//			listP.forEach(p -> {
//				System.out.println(p);
//			});
//			System.out.println("success");
//
//		}
//		else {
//			System.out.println("nah");
//		}
		Optional <List<Product>> optional = productService.findByProductNameLike("l");
		if(optional.isPresent()) {
			List<Product> listP = optional.get();
			listP.forEach(p -> {
				System.out.println(p);
			});
			System.out.println("success");

		}
		else {
			System.out.println("nah");
		}
		
//		if(productService.getProductById(5).isPresent()) {
//			System.out.println("product exists");
//		}
//		else {
//			System.out.println("fail");
//		}
		context.close();
	}

}
