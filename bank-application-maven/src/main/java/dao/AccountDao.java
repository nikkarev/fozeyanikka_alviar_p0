package dao;

import java.util.List;

import exception.FundNotEnoughException;
import exception.SystemException;
import model.AccountPojo;
import model.CustomerPojo;

public interface AccountDao {

	AccountPojo createAccount(AccountPojo accountPojo, CustomerPojo customerPojo) throws SystemException;

	AccountPojo deposit(AccountPojo accountPojo) throws SystemException; 

	AccountPojo withdraw(AccountPojo accountPojo) throws SystemException, FundNotEnoughException; 

	AccountPojo viewBalance(AccountPojo accountPojo) throws SystemException;
}
