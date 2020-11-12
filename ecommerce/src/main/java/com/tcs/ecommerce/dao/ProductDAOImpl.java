package com.tcs.ecommerce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

import com.tcs.ecommerce.model.Product;
import com.tcs.ecommerce.utils.DBUtils;

public class ProductDAOImpl implements ProductDAO {

	
private ProductDAOImpl() {
	// TODO Auto-generated constructor stub
}

private static ProductDAO dao;

public static ProductDAO getInstance() {
	
	if(dao==null) {
		dao = new ProductDAOImpl();
		System.out.println("inside the if condition");
		return dao;
	}
	return dao;
	
	
}
	@Override
	public String createProduct(Product product) {
		// TODO Auto-generated method stub
		Connection connection = DBUtils.getConnection();
		PreparedStatement preparedStatement = null;
		int result = 0;
		String insertProduct = "insert into product (productid,productname,description,category,price) values(?,?,?,?,?)";
		try {
			 preparedStatement = connection.prepareStatement(insertProduct);
			 preparedStatement.setInt(1, product.getProductId());
			 preparedStatement.setString(2, product.getProductName());
			 preparedStatement.setString(3, product.getDescription());
			 preparedStatement.setString(4, product.getCategory());
			 preparedStatement.setFloat(5, product.getPrice());
			 
			 result = preparedStatement.executeUpdate();
			 
			 if(result>0)
			 {
				 connection.commit();
				 return "success";
				 
			 }
			 else {
				 return "fail";
			 }
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "fail";
		}
		finally {
			DBUtils.closeConnection(connection);
		}
		
	}

	@Override
	public Optional<Product> getProductById(int id) {
		Connection connection = DBUtils.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		Product product = null;
		
		String query = "SELECT * FROM Product where productId =?";
		
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			
			result = preparedStatement.executeQuery();
			
			if(result.next()) {
				product = new Product();
				product.setProductId(result.getInt("productId"));
				product.setProductName(result.getString("productName"));
				product.setDescription(result.getString("productDescription"));
				product.setCategory(result.getString("productCategory"));
				product.setPrice(result.getFloat("productPrice"));
			}
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Optional.empty();
		}
		
		finally {
			DBUtils.closeConnection(connection);
		}
		return Optional.of(product);
	}

	@Override
	public Optional<List<Product>> getProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String removeProduct(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Product> updateProduct(int id, Product product) {
		// TODO Auto-generated method stub
		return null;
	}

}
