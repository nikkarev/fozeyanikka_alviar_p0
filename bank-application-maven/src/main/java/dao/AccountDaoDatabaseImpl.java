package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.AccountPojo;

public class AccountDaoDatabaseImpl implements AccountDao{

	@Override
	public AccountPojo createAccount(AccountPojo accountPojo) {
		Connection connection = null;

		try {
			ResultSet resultSet = null;

			connection = DBUtil.establishConnection();
			Statement statement = connection.createStatement();
			
			String query= "INSERT INTO account_info(balance) VALUES ("+accountPojo.getBalance() + ") returning account_number";
			
			resultSet = statement.executeQuery(query);
			resultSet.next();
			accountPojo.setAccountNumber(resultSet.getInt(1)); // ??????????				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accountPojo;
	}

	@Override
	public AccountPojo deposit(int accountNumber, double amount) {
		Connection connection = null;
		AccountPojo accountPojo = null;

		try {
			connection = DBUtil.establishConnection();
			Statement statement = connection.createStatement();
			
			String query = " UPDATE account_info SET balance = balance " + accountPojo.getAmount() +  "WHERE accountNumber = " +accountPojo.getAccountNumber() + "returning account_number";
			
			int rowsAffected = statement.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accountPojo;
	}

	@Override
	public AccountPojo withdraw(int accountNumber, double amount) {
		Connection connection = null;
		AccountPojo accountPojo = null;

		try {
			connection = DBUtil.establishConnection();
			Statement statement = connection.createStatement();
			
			String query = "UPDATE account_info SET balance = " +accountPojo.getBalance()+ "WHERE account_number = " +accountPojo.getAccountNumber(); 
			
			int rowsAffected = statement.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accountPojo;
	}

	@Override
	public List<AccountPojo> viewBalance() {
		Connection connection = null;
		List<AccountPojo> allBalance = new ArrayList<AccountPojo>();
		
		try {
			connection = DBUtil.establishConnection();
			Statement statement = connection.createStatement();
			
			String query= " SELECT * FROM account_info";
			
			ResultSet resultSet = statement.executeQuery(query);
			
			while(resultSet.next()) {
				AccountPojo accountPojo = new AccountPojo(resultSet.getInt(1), resultSet.getDouble(2),  resultSet.getDouble(3) );
				allBalance.add(accountPojo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return allBalance;
	}

	@Override
	public AccountPojo getAccount(int accountNumber) {
		Connection connection = null;
		AccountPojo accountPojo = null;
		
		try {
			connection = DBUtil.establishConnection();
			Statement statement = connection.createStatement();
			String query = "SELECT * FROM account_info WHERE account_number= " + accountNumber;
			ResultSet resultSet = statement.executeQuery(query);
			if(resultSet.next()) {
				accountPojo = new AccountPojo(resultSet.getInt(1), resultSet.getDouble(2), resultSet.getDouble(3));
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return accountPojo;
	}

	@Override
	public void deleteAccount(int accountNumber) {
		Connection connection = null;
		
		try {
			connection = DBUtil.establishConnection();
			Statement statement = connection.createStatement();
			String query = "DELETE * FROM account_info WHERE account_number= " + accountNumber;
			int rowsAffected = statement.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	

}
