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
	public AccountPojo deposit(int accountNumber, double amount) throws SystemException {
		return accountDao.deposit(accountNumber, amount);
	}

	@Override
	public AccountPojo withdraw(int accountNumber, double amount) throws SystemException, FundNotEnoughException{
		return accountDao.withdraw(accountNumber, amount);

	}

	@Override
	public List<AccountPojo> viewBalance() throws SystemException {
		return accountDao.viewBalance();
	}
	
	@Override
	public AccountPojo getAccount(int accountNumber) throws SystemException {
		return accountDao.getAccount(accountNumber);
	}

	@Override
	public void deleteAccount(int accountNumber) throws SystemException {
		accountDao.deleteAccount(accountNumber);
		
	}	

}
