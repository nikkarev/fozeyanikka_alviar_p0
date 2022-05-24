package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import exception.LoginFailedException;
import exception.SystemException;
import model.AccountPojo;
import model.CustomerPojo;

public class CustomerDaoDatabaseImpl implements CustomerDao{

	@Override
	public CustomerPojo createCustomer(CustomerPojo customerPojo) throws SystemException {
		Connection connection = null;

		try {
			connection = DBUtil.establishConnection();
			Statement statement = connection.createStatement();
			
			String query = "INSERT INTO customer_info(password)"
					+ "VALUES ( '"+customerPojo.getPassword()+"' ) returning customer_id";
			
//			String query = "INSERT INTO customer_info(account_id, password) VALUES ("+customerPojo.getAccountId()+" , '"+customerPojo.getPassword()+"' ) returning customer_id ";
			
//			String query2 = "INSERT INTO customer_info(account_id) SELECT account_id FROM account_info ORDER BY account_id DESC LIMIT 1 returning customer_id";
			
//			String query2 = "UPDATE customer_info SET account_id SELECT account_id FROM account_info ORDER BY customer_id DESC LIMIT 1" ;
			
//			String query2 = "INSERT INTO customer_info(account_id) SELECT account_info.account_id FROM account_info INNER JOIN customer_info ON customer_info.account_id=account_info.account_id returning account_id";
			
			ResultSet resultSet = statement.executeQuery(query);
			resultSet.next();
			
//			ResultSet resultSet2 = statement.executeQuery(query2);
//			resultSet2.next();
			
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

			String query = "SELECT * FROM customer_info WHERE customer_id= " +customerPojo.getCustomerId() + "and password=" + "'"+customerPojo.getPassword()+"'" ;
			
			ResultSet resultSet = statement.executeQuery(query);
			
			int counter = 0;
			while(resultSet.next()) {
				counter ++;
				customerPojo.setCustomerId(resultSet.getInt(1));
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
