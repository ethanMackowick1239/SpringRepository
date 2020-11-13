package com.tcs.ecommerce;

import javax.sql.DataSource;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.tcs.ecommerce.config.DBConfig;
import com.tcs.ecommerce.model.Product;
import com.tcs.ecommerce.service.ProductService;

public class MainSpring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DBConfig.class);
			
			//DataSource dataSource = context.getBean("mySqlDataSource", DataSource.class);
			
			ProductService productService = context.getBean(ProductService.class);
			Product product = new Product(6, "laptop", "i5 1oth gen", 123.0f, "laptop");
			String result = productService.createProduct(product);
			System.out.println(result);
			
			//System.out.println(dataSource);
			System.out.println(productService);
			context.close();
	}

}
