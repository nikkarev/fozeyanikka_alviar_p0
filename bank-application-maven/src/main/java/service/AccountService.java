package service;

import java.util.List;

import model.AccountPojo;

public interface AccountService {
	
	AccountPojo createAccount(AccountPojo accountPojo);

	AccountPojo deposit(int accountNumber, double amount); 

	void withdraw(int accountNumber, double amount); 

	List<AccountPojo> viewBalance();
}
