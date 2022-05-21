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

public class AccountDaoDatabaseImpl implements AccountDao{
	
	private static final Logger LOG = LogManager.getLogger(AccountDaoDatabaseImpl.class);

	@Override
	public AccountPojo createAccount(AccountPojo accountPojo) throws SystemException {
		
		LOG.info("Entered into createAccount() in Dao Layer...");
		
		Connection connection = null;

		try {
			ResultSet resultSet = null;

			connection = DBUtil.establishConnection();
			Statement statement = connection.createStatement();
			
//			String query= "INSERT INTO account_info VALUES ("+accountPojo.getBalance() + ") account_number = customer_id returning account_number";

			String query = "INSERT INTO account_info(balance)"
					+ "VALUES ("+accountPojo.getBalance() +" ) returning account_number";
			
			resultSet = statement.executeQuery(query);
			resultSet.next();
			accountPojo.setAccountNumber(resultSet.getInt(1));
		} catch (SQLException e) {
			throw new SystemException();
		}
		
		LOG.info("Exited createAccount() in Dao...");
		
		return accountPojo;
	}


	@Override
	public AccountPojo deposit(AccountPojo accountPojo) throws SystemException {
		Connection connection = null;
		
		LOG.info("Entered into deposit() in Dao Layer...");

		try {
			connection = DBUtil.establishConnection();
			Statement statement = connection.createStatement();

			String query = "UPDATE account_info SET balance=" +accountPojo.getBalance()+ "WHERE account_number=" + accountPojo.getAccountNumber();
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

			String query = "UPDATE account_info SET balance=" +accountPojo.getBalance()+ "WHERE account_number=" +accountPojo.getAccountNumber(); 
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

			String query = "SELECT balance FROM account_info where account_number=" +accountPojo.getAccountNumber();

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
