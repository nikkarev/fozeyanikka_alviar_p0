package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import exception.LoginFailedException;
import exception.SystemException;
import model.CustomerPojo;

public class CustomerDaoDatabaseImpl implements CustomerDao{

	@Override
	public CustomerPojo createCustomer(CustomerPojo customerPojo) throws SystemException {
		Connection connection = null;

		try {
			ResultSet resultSet = null;

			connection = DBUtil.establishConnection();
			Statement statement = connection.createStatement();
			
			String query= "INSERT INTO customer_info(first_name, last_name, username, password) "
					+ "VALUES ('"+customerPojo.getCustomerFirstName()+"', "
							+ "'"+customerPojo.getCustomerLastName()+"', '"+customerPojo.getUsername()+"', "
									+ "'"+customerPojo.getPassword()+"' ) returning customer_id";
			
			resultSet = statement.executeQuery(query);
			resultSet.next();
			
			customerPojo.setCustomerId(resultSet.getInt(1));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SystemException();
		}
		return customerPojo;
	}
	
	@Override
	public void deleteAccount(int customerId) throws SystemException {
		Connection connection = null;
		
		try {
			connection = DBUtil.establishConnection();
			Statement statement = connection.createStatement();
			String query = "DELETE * FROM customer_info WHERE customer_id= " + customerId;
			int rowsAffected = statement.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SystemException();
		}
	}

	@Override
	public CustomerPojo customerLogin(CustomerPojo customerPojo) throws SystemException, LoginFailedException {
		Connection connection = null;
		
		try {
			connection = DBUtil.establishConnection();
			
			Statement statement = connection.createStatement();
			String query = "SELECT * FROM customer_info where username =" +customerPojo.getUsername()+ "and password = "+customerPojo.getPassword() ;
			
			ResultSet resultSet = statement.executeQuery(query);
			
			int counter = 0;
			while(resultSet.next()) {
				counter ++;
//				customerPojo.setCustomerId(resultSet.getInt(1));
				customerPojo.setCustomerFirstName(resultSet.getString(3));
				customerPojo.setCustomerLastName(resultSet.getString(4));
			}
			if(counter == 0) {
				throw new LoginFailedException();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SystemException();
		}
		return customerPojo;
	}
	
}
