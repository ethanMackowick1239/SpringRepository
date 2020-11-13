package com.tcs.employee.dao;

import java.security.ProtectionDomain;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mysql.cj.protocol.Resultset;
import com.tcs.employee.model.Employee;
import com.tcs.employee.utils.DBUtils;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
	
	@Autowired
	DBUtils dbutils;

	

	public String addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		Connection connection = dbutils.getConnection();
		PreparedStatement preparedStatement = null;
		int result = 0;
		String insertProduct = "insert into Employee VALUES(?,?,?,?,?,?)";
		try {
			 preparedStatement = connection.prepareStatement(insertProduct);
			 preparedStatement.setLong(1, employee.getId());
			 preparedStatement.setLong(2, employee.getOrganizationId());
			 preparedStatement.setLong(3, employee.getDepartmentId());
			 preparedStatement.setString(4, employee.getName());
			 preparedStatement.setInt(5, employee.getAge());
			 preparedStatement.setString(6, employee.getPosition());
			 
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

	public Optional<Employee> findById(long id) {
		// TODO Auto-generated method stub
		Connection connection = dbutils.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		Employee employee = null;
		String query = "select * from Employee where id=?";
		try {
			 preparedStatement = connection.prepareStatement(query);
			 preparedStatement.setLong(1,id);
			
			resultSet =  preparedStatement.executeQuery();
			 
			if(resultSet.next()) {
				employee = new Employee();
				employee.setId(resultSet.getLong("id"));
				employee.setOrganizationId(resultSet.getLong("organizationId"));
				employee.setDepartmentId(resultSet.getLong("departmentId"));
				employee.setName(resultSet.getString("name"));
				employee.setAge(resultSet.getInt("age"));
				employee.setPosition(resultSet.getString("position"));
						 
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
		return Optional.of(employee);
	}

	
	public String updateEmployee(long id, Employee employee) {
		// TODO Auto-generated method stub
		Connection connection = dbutils.getConnection();
		PreparedStatement preparedStatement = null;
		int result = 0;
		String updateEmployee = "UPDATE Employee SET organizationId=?, departmentId=?, name=?,age=?, position=? WHERE id =?";
		try {
			 preparedStatement = connection.prepareStatement(updateEmployee);
			
			 preparedStatement.setLong(1, employee.getOrganizationId());
			 preparedStatement.setLong(2, employee.getDepartmentId());
			 preparedStatement.setString(3, employee.getName());
			 preparedStatement.setInt(4, employee.getAge());
			 preparedStatement.setString(5, employee.getPosition());
			 preparedStatement.setLong(6, id);
			 
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
	public String deleteEmployee(long id) {
		Connection connection = dbutils.getConnection();
		PreparedStatement preparedStatement = null;
		int result = 0;
		String deleteEmployee = "DELETE FROM Employee WHERE id =?";
		try {
			 preparedStatement = connection.prepareStatement(deleteEmployee);
			 preparedStatement.setLong(1, id);
			 
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
	
	
	public Optional<List<Employee>> getEmployees() {
		Connection connection = dbutils.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Employee> employeeList = null;
		
		Employee employee = null;
		String query = "select * from Employee";
		try {
			 preparedStatement = connection.prepareStatement(query);
			
			
			resultSet =  preparedStatement.executeQuery();
			employeeList= new ArrayList();
			 
			if(resultSet.next()) {
				employee = new Employee();
				employee.setId(resultSet.getLong("id"));
				employee.setOrganizationId(resultSet.getLong("organizationId"));
				employee.setDepartmentId(resultSet.getLong("departmentId"));
				employee.setName(resultSet.getString("name"));
				employee.setAge(resultSet.getInt("age"));
				employee.setPosition(resultSet.getString("position"));
				employeeList.add(employee);
						 
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
		return Optional.of(employeeList);
	}
	public Optional<List<Employee>> findByOrganization(long id) {
		Connection connection = dbutils.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Employee> employeeList = null;
		
		Employee employee = null;
		String query = "select * from Employee WHERE organizationId= " + id;
		try {
			 preparedStatement = connection.prepareStatement(query);
			
			
			resultSet =  preparedStatement.executeQuery();
			employeeList= new ArrayList();
			 
			if(resultSet.next()) {
				employee = new Employee();
				employee.setId(resultSet.getLong("id"));
				employee.setOrganizationId(resultSet.getLong("organizationId"));
				employee.setDepartmentId(resultSet.getLong("departmentId"));
				employee.setName(resultSet.getString("name"));
				employee.setAge(resultSet.getInt("age"));
				employee.setPosition(resultSet.getString("position"));
				employeeList.add(employee);
						 
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
		return Optional.of(employeeList);
	}

}
