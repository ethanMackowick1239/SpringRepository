package com.tcs.ecom.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import com.tcs.ecom.model.Product;
import com.tcs.ecom.utils.DBUtils;

public class ProductDAOImpl implements ProductDAO {
	
	private ProductDAOImpl() {}
	   
    private static ProductDAO dao;
   
    public static ProductDAO getInstance() {
        if(dao == null) {
            dao = new ProductDAOImpl();
            return dao;
        }
        return dao;
    }

	@Override
	public String createProduct(Product product) {
		Connection connection = DBUtils.getConnection();
		int result = 0;
		String insertProduct = "INSERT into Product (productId, productName, productDescription, productCategory, productPrice) VALUES (?,?,?,?, ?)";
		try {
			PreparedStatement prepared = connection.prepareStatement(insertProduct);
			prepared.setInt(1, product.getProductId());
			prepared.setString(2, product.getProductName());
			prepared.setString(3,  product.getProductDescription());
			prepared.setString(4, product.getCategory());
			prepared.setFloat(5,  product.getPrice());
			result = prepared.executeUpdate();
			if(result>0) {
				connection.commit();
				return "success";
			}
			else {
				return "failure";
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
			return "exception";
		}
		finally{
			DBUtils.closeConnection(connection);
		}
		
	}

	@Override
	public Optional<Product> getProductById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<List<Product>> getProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String removeProduct(int Id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Product> updateProduct(int id, Product product) {
		// TODO Auto-generated method stub
		return null;
	}

}
