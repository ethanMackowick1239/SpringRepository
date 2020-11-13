package com.tcs.ecommerce.dao;

import java.security.ProtectionDomain;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mysql.cj.protocol.Resultset;
import com.tcs.ecommerce.model.Product;
import com.tcs.ecommerce.utils.DBUtils;

@Repository
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	DBUtils dbutils;

	@Override
	public String createProduct(Product product) {
		// TODO Auto-generated method stub
		Connection connection = dbutils.getConnection();
		PreparedStatement preparedStatement = null;
		int result = 0;
		String insertProduct = "insert into Product VALUES(?,?,?,?,?)";
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
			dbutils.closeConnection(connection);
		}
		
	}

	@Override
	public Optional<Product> getProductById(int id) {
		// TODO Auto-generated method stub
		Connection connection = dbutils.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		Product product = null;
		String query = "select * from Product where productid=?";
		try {
			 preparedStatement = connection.prepareStatement(query);
			 preparedStatement.setInt(1,id);
			
			resultSet =  preparedStatement.executeQuery();
			 
			if(resultSet.next()) {
				 product = new Product();
				product.setProductId(resultSet.getInt("productid"));
				product.setProductName(resultSet.getString("productname"));
				product.setDescription(resultSet.getString("productDescription"));
				product.setCategory(resultSet.getString("productCategory"));
				product.setPrice(resultSet.getFloat("productPrice"));
				
				 
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
			dbutils.closeConnection(connection);
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
