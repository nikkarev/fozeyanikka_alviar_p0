package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import model.AccountPojo;

public class AccountDaoDatabaseImpl implements AccountDao{

	@Override
	public AccountPojo createAccount(AccountPojo accountPojo) {
		Connection connection = null;
		
		try {
			connection = DBUtil.establishConnection();
			Statement statement = connection.createStatement();
			String query = "INSERT INTO account_info(account_number, account_type, current_balance) VALUES (+accountPojo.getAccountNumber() + )"
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public AccountPojo deposit(AccountPojo accountPojo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AccountPojo withdraw(AccountPojo accountPojo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AccountPojo viewBalance(AccountPojo accountPojo) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
