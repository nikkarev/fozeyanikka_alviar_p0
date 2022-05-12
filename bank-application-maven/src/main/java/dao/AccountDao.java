package dao;

import model.AccountPojo;

public interface AccountDao {
	
	AccountPojo createAccount(AccountPojo accountPojo); //CREATE

	AccountPojo updateAccount(AccountPojo accountPojo); //UPDATE

	void deleteAccount(int accountNumber); //DELETE

	AccountPojo displayAccount(AccountPojo accountPojo); //READ

}
