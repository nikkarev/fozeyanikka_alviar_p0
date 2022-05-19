package service;

import java.util.List;

import exception.FundNotEnoughException;
import exception.SystemException;
import model.AccountPojo;

public interface AccountService {
	
	AccountPojo createAccount(AccountPojo accountPojo) throws SystemException;

	AccountPojo deposit(AccountPojo accountPojo) throws SystemException; 

	AccountPojo withdraw(AccountPojo accountPojo, double amount) throws SystemException, FundNotEnoughException; 

	AccountPojo viewBalance(AccountPojo accountPojo) throws SystemException;
	
}
