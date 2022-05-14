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
			
//			String query= "INSERT INTO customer_info(account_number, account_type, current_balance) VALUES (?, ?,?)";
			
						
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customerPojo;
	}

	@Override
	public CustomerPojo updateCustomer(CustomerPojo customerPojo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAccount(int customerId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<CustomerPojo> displayCustomer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerPojo customerLogin(CustomerPojo customerPojo) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
