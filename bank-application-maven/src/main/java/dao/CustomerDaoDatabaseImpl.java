package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import model.CustomerPojo;

public class CustomerDaoDatabaseImpl implements CustomerDao{

	@Override
	public CustomerPojo createCustomer(CustomerPojo customerPojo) {
		Connection connection = null;

		try {
			ResultSet resultSet = null;

			connection = DBUtil.establishConnection();
			Statement statement = connection.createStatement();
			
			String query= "INSERT INTO customer_info(customer_id, first_name, last_name, username, password) "
					+ "VALUES (?, ?, ?, ?, ?, ?)";
			
			PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setInt(1,  customerPojo.getCustomerId());
			preparedStatement.setString(2,  customerPojo.getCustomerFirstName());
			preparedStatement.setString(3, customerPojo.getCustomerLastName());
			preparedStatement.setString(4, customerPojo.getUsername());
			preparedStatement.setString(5, customerPojo.getPassword());
			
			resultSet = preparedStatement.getGeneratedKeys();
			resultSet = preparedStatement.executeQuery(query);
			resultSet.next();
			
			//assign the retrieve customer id inside the customer pojo
			customerPojo.setCustomerId(resultSet.getInt(1));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customerPojo;
	}

	@Override
	public CustomerPojo updatePassword(CustomerPojo customerPojo) {
		Connection connection = null;
		
		try {
			connection = DBUtil.establishConnection();
			Statement statement = connection.createStatement();
			String query = "UPDATE customer_info password= " +customerPojo.getPassword() 
				+ "WHERE customer_id= " +customerPojo.getCustomerId();
			int rowsAffected = statement.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customerPojo;
	}

	@Override
	public void deleteAccount(int customerId) {
		
	}

	@Override
	public CustomerPojo customerLogin(CustomerPojo customerPojo) {
		Connection connection = null;
		
		try {
			Statement statement = connection.createStatement();
			String query = "select * from user_details where username="+customerPojo.getUsername()+
					"and password= '"+customerPojo.getPassword() ;
			
			ResultSet resultSet = statement.executeQuery(query);
			if(resultSet.next()) {
				customerPojo.setCustomerFirstName(resultSet.getString(3));
				customerPojo.setCustomerLastName(resultSet.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customerPojo;
	}
	
}
