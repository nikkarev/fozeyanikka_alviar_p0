package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import exception.FundNotEnoughException;
import exception.SystemException;
import model.AccountPojo;

public class AccountDaoDatabaseImpl implements AccountDao{

	@Override
	public AccountPojo createAccount(AccountPojo accountPojo) throws SystemException {
		Connection connection = null;

		try {
			ResultSet resultSet = null;

			connection = DBUtil.establishConnection();
			Statement statement = connection.createStatement();
			
			String query= "INSERT INTO account_info(balance) VALUES ("+accountPojo.getBalance() + ") returning account_number";
			
			resultSet = statement.executeQuery(query);
			resultSet.next();
			accountPojo.setAccountNumber(resultSet.getInt(1));
		} catch (SQLException e) {
			throw new SystemException();
		}
		return accountPojo;
	}

	@Override
	public AccountPojo deposit(AccountPojo accountPojo, double amount) throws SystemException {
		Connection connection = null;
		
		try {
			connection = DBUtil.establishConnection();
			Statement statement = connection.createStatement();
			
			String query1 = "SELECT balance FROM account_info WHERE accountNumber = " + accountPojo.getAccountNumber() + "returning account_number";
			
			ResultSet resultSet = statement.executeQuery(query1);
			
			while(resultSet.next()) {
				double newBalance = resultSet.getDouble(1) + amount;
				accountPojo.setBalance(newBalance);
				
				String query2 = "UPDATE account_info SET balance=" +accountPojo.getBalance()+ "WHERE accountNumber = " + accountPojo.getAccountNumber() ;
				int rowsAffected = statement.executeUpdate(query2);
			}
		} catch (SQLException e) {
			throw new SystemException();
		}
		return accountPojo;
	}

	@Override
	public AccountPojo withdraw(AccountPojo accountPojo, double amount) throws SystemException, FundNotEnoughException {
		Connection connection = null;

		try {
			connection = DBUtil.establishConnection();
			Statement statement = connection.createStatement();
			
			String query1 = "SELECT balance FROM account_info WHERE account_number = " + accountPojo.getAccountNumber();
			
			ResultSet resultSet = statement.executeQuery(query1);
			
			while(resultSet.next()) {
				double currentBalance = resultSet.getDouble(1);
				if(amount > currentBalance) {
					throw new FundNotEnoughException();
				} 
				else {
					double newBalance = currentBalance - amount ;
					accountPojo.setBalance(newBalance);
					
					String query2 = "UPDATE account_info SET balance = balance" +accountPojo.getBalance()+ "WHERE account_number = " +accountPojo.getAccountNumber(); 

					int rowsAffected = statement.executeUpdate(query2);
				}
			}
		} catch (SQLException e) {
			throw new SystemException();
		}
		return accountPojo;
	}
	
	@Override
	public AccountPojo viewBalance(AccountPojo accountPojo) throws SystemException {
		Connection connection = null;
		
		try {
			connection = DBUtil.establishConnection();
			Statement statement = connection.createStatement();
			
			String query = " SELECT balance FROM account_info where account_number = " +accountPojo.getAccountNumber();
			
			ResultSet resultSet = statement.executeQuery(query);
			
			while(resultSet.next()) {
				accountPojo.setBalance(resultSet.getDouble(1));
			}
		} catch (SQLException e) {
			throw new SystemException();
		}
		return accountPojo;
	}
}
