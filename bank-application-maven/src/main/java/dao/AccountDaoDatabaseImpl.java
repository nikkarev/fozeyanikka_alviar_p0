package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import exception.SystemException;
import model.AccountPojo;
import model.ProductPojo;

public class AccountDaoDatabaseImpl implements AccountDao{

	@Override
	public AccountPojo createAccount(AccountPojo accountPojo) {
		Connection connection = null;

		try {
			ResultSet resultSet = null;

			connection = DBUtil.establishConnection();
//			Statement statement = connection.createStatement();
			
//			String query= "INSERT INTO account_info(account_number, account_type, current_balance) VALUES ("+accountPojo.getAccountNumber()+", ' "+accountPojo.getAccountType()+" ',  "+accountPojo.getAmount()+")";

			String query= "INSERT INTO account_info(account_number, current_balance) VALUES (?, ?,?)";
			
			PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setInt(1, accountPojo.getAccountNumber());
			preparedStatement.setDouble(2, accountPojo.getBalance());
			
			resultSet = preparedStatement.getGeneratedKeys();
			resultSet = preparedStatement.executeQuery(query);
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
			String query = " UPDATE account_info SET balance=" + accountPojo.getBalance() + accountPojo.getAmount() +  "WHERE accountNumber=" +accountPojo.getAccountNumber() ;
							
//			PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
//			preparedStatement.setDouble(1, accountPojo.getAmount());
//			preparedStatement.setInt(2, accountPojo.getAccountNumber());
			
			int rowsAffected = statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
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
			
			String query= " UPDATE account_info SET current_balance=current_balance - ? WHERE accountNumber=? ";
							
			// Fetch the automated primary key for accountNumber
//			PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
//			preparedStatement.setDouble(1, accountPojo.getAmount());
//			preparedStatement.setInt(2, accountPojo.getAccountNumber());
			
			int rowsAffected = statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
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
			ResultSet resultSet = null;

			connection = DBUtil.establishConnection();
//			Statement statement = connection.createStatement();
			
			String query= " SELECT * FROM account_info";
							
			// Fetch the automated primary key for accountNumber
			PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			
			resultSet = preparedStatement.getGeneratedKeys();
			resultSet = preparedStatement.executeQuery(query);
			
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
			String query = "SELECT * FROM account_info WHERE = " + accountNumber;
			ResultSet resultSet = statement.executeQuery(query);
			if(resultSet.next()) {
				accountPojo = new AccountPojo(resultSet.getInt(1), resultSet.getDouble(2), resultSet.getDouble(3));
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return accountPojo;
	}
	
	

}
