package dao;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import exception.FundNotEnoughException;
import exception.SystemException;
import model.AccountPojo;
import model.CustomerPojo;

public class AccountDaoDatabaseImpl implements AccountDao{
	
	private static final Logger LOG = LogManager.getLogger(AccountDaoDatabaseImpl.class);

	public AccountPojo createAccount(AccountPojo accountPojo, CustomerPojo customerPojo) throws SystemException {
		
		Connection connection = null;

		try {
			connection = DBUtil.establishConnection();
			Statement statement = connection.createStatement();
			
//			String query= "INSERT INTO account_info VALUES ("+accountPojo.getBalance() + ") account_id = customer_id returning account_id";

			String query = "INSERT INTO account_info(balance)"
					+ "VALUES ("+accountPojo.getBalance()+") returning account_id";
			
//			String query2 = "INSERT INTO customer_info(account_id) VALUES ("+accountPojo.getAccountId()+") returning account_id ";
//			
			String query2 = "INSERT INTO customer_info(account_id) SELECT account_id FROM account_info WHERE account_id= "+accountPojo.getAccountId() + "ORDER BY customer_id DESC LIMIT 1" ;
			
			ResultSet resultSet1 = statement.executeQuery(query);
			resultSet1.next();
			
			ResultSet resultSet2 = statement.executeQuery(query2);
			resultSet2.next();
			
			accountPojo.setAccountId(resultSet1.getInt(1));
			customerPojo.setAccountId(resultSet2.getInt(1));
			
		} catch (SQLException e) {
			throw new SystemException();
		}
		return accountPojo;
	}


	@Override
	public AccountPojo deposit(AccountPojo accountPojo) throws SystemException {
		Connection connection = null;
		
		LOG.info("Entered into deposit() in Dao Layer...");

		try {
			connection = DBUtil.establishConnection();
			Statement statement = connection.createStatement();

			String query = "UPDATE account_info SET balance=" +accountPojo.getBalance()+ "WHERE account_id=" + accountPojo.getAccountId();
			int rowsAffected = statement.executeUpdate(query);

		} catch (SQLException e) {
			throw new SystemException();
		}
		
		LOG.info("Entered into deposit() in Dao Layer...");
		
		return accountPojo;
	}


	@Override
	public AccountPojo withdraw(AccountPojo accountPojo) throws SystemException, FundNotEnoughException {
		
		LOG.info("Entered into withdraw() in Dao Layer...");
		
		Connection connection = null;

		try {
			connection = DBUtil.establishConnection();
			Statement statement = connection.createStatement();

			String query = "UPDATE account_info SET balance=" +accountPojo.getBalance()+ "WHERE account_id=" +accountPojo.getAccountId(); 
			int rowsAffected = statement.executeUpdate(query);
			
		} catch (SQLException e) {
			throw new SystemException();
		}
		
		LOG.info("Entered into withdraw() in Dao Layer...");
		
		return accountPojo;
	}

	@Override
	public AccountPojo viewBalance(AccountPojo accountPojo) throws SystemException {
		
		LOG.info("Entered into viewBalance() in Dao Layer...");
		
		Connection connection = null;

		try {
			connection = DBUtil.establishConnection();
			Statement statement = connection.createStatement();

			String query = "SELECT balance FROM account_info where account_id=" +accountPojo.getAccountId();

			ResultSet resultSet = statement.executeQuery(query);

			while(resultSet.next()) {
				accountPojo.setBalance(resultSet.getDouble(1));
			}
		} catch (SQLException e) {
			throw new SystemException();
		}
		
		LOG.info("Entered into viewBalance() in Dao Layer...");
		
		return accountPojo;
	}
}
