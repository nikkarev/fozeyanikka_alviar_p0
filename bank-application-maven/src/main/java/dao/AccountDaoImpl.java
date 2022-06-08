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

public class AccountDaoImpl implements AccountDao{
	
	private static final Logger LOG = LogManager.getLogger(AccountDaoImpl.class);

	public AccountPojo createAccount(AccountPojo accountPojo, int customerId) throws SystemException {
		LOG.info("Entered into createAccount() in Dao Layer...");
		Connection connection = null;

		try {
			connection = DBUtil.establishConnection();
			Statement statement = connection.createStatement();

			String query = "INSERT INTO account(customer_id, balance)"
					+ "VALUES ("+customerId+" ,"+accountPojo.getBalance()+") returning account_id";
			
			ResultSet resultSet1 = statement.executeQuery(query);
			resultSet1.next();
			
			accountPojo.setAccountId(resultSet1.getInt(1));
			
		} catch (SQLException e) {
			throw new SystemException();
		}
		LOG.info("Entered into createAccount() in Dao Layer...");
		return accountPojo;
	}


	@Override
	public AccountPojo deposit(AccountPojo accountPojo) throws SystemException {
		LOG.info("Entered into deposit() in Dao Layer...");
		Connection connection = null;

		try {
			connection = DBUtil.establishConnection();
			Statement statement = connection.createStatement();

			String query = "UPDATE account SET balance=" +accountPojo.getBalance()+ "WHERE account_id=" + accountPojo.getAccountId();
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

			String query = "UPDATE account SET balance=" +accountPojo.getBalance()+ "WHERE account_id=" +accountPojo.getAccountId(); 
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

			String query = "SELECT balance FROM account where account_id=" +accountPojo.getAccountId();

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
