package service;

import java.util.List;

import exception.FundNotEnoughException;
import exception.SystemException;
import model.AccountPojo;

public interface AccountService {
	
	AccountPojo createAccount(AccountPojo accountPojo) throws SystemException;

	AccountPojo deposit(int accountNumber, double amount) throws SystemException; 

	AccountPojo withdraw(int accountNumber, double amount) throws SystemException, FundNotEnoughException; 

	List<AccountPojo> viewBalance() throws SystemException;
	
	AccountPojo getAccount(int accountNumber) throws SystemException;
	
	void deleteAccount(int accountNumber) throws SystemException;
}
