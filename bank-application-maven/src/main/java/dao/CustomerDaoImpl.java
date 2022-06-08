package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import exception.LoginFailedException;
import exception.SystemException;
import model.AccountPojo;
import model.CustomerPojo;

public class CustomerDaoImpl implements CustomerDao{
	
	private static final Logger LOG = LogManager.getLogger(AccountDaoImpl.class);

	@Override
	public CustomerPojo createCustomer(CustomerPojo customerPojo) throws SystemException {
		LOG.info("Entered into createCustomer() in Dao Layer...");
		Connection connection = null;

		try {
			connection = DBUtil.establishConnection();
			Statement statement = connection.createStatement();
			
			String query = "INSERT INTO customer(first_name, last_name, username, password)"
					+ "VALUES ('"+customerPojo.getFirstName()+"', '"+customerPojo.getLastName()+"' , '"+customerPojo.getUsername()+"' , '"+customerPojo.getPassword()+"' ) returning customer_id";

			ResultSet resultSet = statement.executeQuery(query);
			resultSet.next();
			
			customerPojo.setCustomerId(resultSet.getInt(1));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SystemException();
		}
		LOG.info("Entered into createCustomer() in Dao Layer...");
		return customerPojo;
	}
	
	@Override
	public void deleteAccount(int customerId) throws SystemException {
		LOG.info("Entered into deleteAccount() in Dao Layer...");
		Connection connection = null;
		
		try {
			connection = DBUtil.establishConnection();
			Statement statement = connection.createStatement();
			String query = "DELETE * FROM customer WHERE customer_id= " + customerId;
			int rowsAffected = statement.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SystemException();
		}
		LOG.info("Entered into deleteAccount() in Dao Layer...");
	}

	@Override
	public CustomerPojo customerLogin(CustomerPojo customerPojo) throws SystemException, LoginFailedException {
		LOG.info("Entered into customerLogin() in Dao Layer...");
		Connection connection = null;
		
		try {
			connection = DBUtil.establishConnection();
			
			Statement statement = connection.createStatement();

			String query = "SELECT * FROM customer WHERE username= "+ "'"+customerPojo.getUsername()+"'" + "and password=" + "'"+customerPojo.getPassword()+"'" ;
			
			ResultSet resultSet = statement.executeQuery(query);
			
			if(resultSet.next()) {
				customerPojo.setCustomerId(resultSet.getInt(1));
				customerPojo.setFirstName(resultSet.getString(2));
				customerPojo.setLastName(resultSet.getString(3));
				customerPojo.setUsername(resultSet.getString(4));
			}
			else {
				throw new LoginFailedException();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SystemException();
		}
		LOG.info("Entered into customerLogin() in Dao Layer...");
		return customerPojo;
	}
	
}
