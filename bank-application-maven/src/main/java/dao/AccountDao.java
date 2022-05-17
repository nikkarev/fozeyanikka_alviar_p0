package dao;

import java.util.List;

import exception.FundNotEnoughException;
import exception.SystemException;
import model.AccountPojo;

public interface AccountDao {

	AccountPojo createAccount(AccountPojo accountPojo) throws SystemException;

	AccountPojo deposit(int accountNumber, double amount) throws SystemException; 

	AccountPojo withdraw(int accountNumber, double amount) throws SystemException, FundNotEnoughException; 

	List<AccountPojo> viewBalance() throws SystemException;
	
	AccountPojo getAccount(int accountNumber) throws SystemException;
	
	public void deleteAccount(int accountNumber) throws SystemException;
}
