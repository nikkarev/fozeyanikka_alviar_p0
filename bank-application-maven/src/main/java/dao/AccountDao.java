package dao;

import model.AccountPojo;

public interface AccountDao {

	AccountPojo createAccount(AccountPojo accountPojo); //CREATE

	AccountPojo deposit(AccountPojo accountPojo); //INSERT

	AccountPojo withdraw(AccountPojo accountPojo); 

	AccountPojo viewBalance(AccountPojo accountPojo); //READ


	//	AccountPojo updateAccount(AccountPojo accountPojo); //UPDATE -- NEEDED?
	//
	//	void deleteAccount(int accountNumber); //DELETE -- NEEDED?

	//	List<AccountPojo> transactionHistory();

}
