package service;

import java.util.List;

import dao.AccountDao;
import dao.AccountDaoDatabaseImpl;
import exception.FundNotEnoughException;
import exception.SystemException;
import model.AccountPojo;

public class AccountServiceImpl implements AccountService{

	AccountDao accountDao;

	public AccountServiceImpl() {
		accountDao = new AccountDaoDatabaseImpl();
	}	

	public AccountDao getAccountDao() {
		return accountDao;
	}

	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	@Override
	public AccountPojo createAccount(AccountPojo accountPojo) throws SystemException {
		return accountDao.createAccount(accountPojo);
	}

	
	@Override
	public AccountPojo deposit(AccountPojo accountPojo, double amount) throws SystemException {
		return accountDao.deposit(accountPojo, amount);
	}

	@Override
	public AccountPojo withdraw(AccountPojo accountPojo, double amount) throws SystemException, FundNotEnoughException {
		return accountDao.withdraw(accountPojo, amount);
	}

	@Override
	public AccountPojo viewBalance(AccountPojo accountPojo) throws SystemException {
		return accountDao.viewBalance(accountPojo);
	}

}
