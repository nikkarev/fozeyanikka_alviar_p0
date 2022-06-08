package service;

import java.util.List;

import dao.AccountDao;
import dao.AccountDaoImpl;
import exception.FundNotEnoughException;
import exception.SystemException;
import model.AccountPojo;
import model.CustomerPojo;

public class AccountServiceImpl implements AccountService{

	AccountDao accountDao;

	public AccountServiceImpl() {
		accountDao = new AccountDaoImpl();
	}	

	public AccountDao getAccountDao() {
		return accountDao;
	}

	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	@Override
	public AccountPojo createAccount(AccountPojo accountPojo, int customerId) throws SystemException {
		return accountDao.createAccount(accountPojo, customerId);
	}

	@Override
	public AccountPojo deposit(AccountPojo accountPojo) throws SystemException {
		return accountDao.deposit(accountPojo);
	}

	@Override
	public AccountPojo withdraw(AccountPojo accountPojo) throws SystemException, FundNotEnoughException {
		return accountDao.withdraw(accountPojo);
	}

	@Override
	public AccountPojo viewBalance(AccountPojo accountPojo) throws SystemException {
		return accountDao.viewBalance(accountPojo);
	}

}
