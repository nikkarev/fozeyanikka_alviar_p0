package dao;

import java.util.List;

import model.AccountPojo;

public interface AccountDao {

	AccountPojo createAccount(AccountPojo accountPojo);

	AccountPojo deposit(int accountNumber, double amount); 

	AccountPojo withdraw(int accountNumber, double amount); 

	List<AccountPojo> viewBalance();
	
	AccountPojo getAccount(int accountNumber);
}
