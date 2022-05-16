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
			
			String query= "INSERT INTO customer_info(first_name, last_name, username, password) "
					+ "VALUES ('"+customerPojo.getCustomerFirstName()+"', "
							+ "'"+customerPojo.getCustomerLastName()+"', '"+customerPojo.getUsername()+"', "
									+ "'"+customerPojo.getPassword()+"' ) returning customer_id";
			
			resultSet = statement.executeQuery(query);
			resultSet.next();
			
			//assign the retrieve customer id inside the customer pojo
			customerPojo.setCustomerId(resultSet.getInt(1));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customerPojo;
	}
	
	@Override
	public void deleteAccount(int customerId) {
		Connection connection = null;
		
		try {
			connection = DBUtil.establishConnection();
			Statement statement = connection.createStatement();
			String query = "DELETE * FROM customer_info WHERE customer_id= " + customerId;
			int rowsAffected = statement.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
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
