package service;

import java.util.List;

import dao.AccountDao;
import dao.AccountDaoDatabaseImpl;
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
	public AccountPojo createAccount(AccountPojo accountPojo) {
		return accountDao.createAccount(accountPojo);
	}

	@Override
	public AccountPojo deposit(int accountNumber, double amount) {
		return accountDao.deposit(accountNumber, amount);
	}

	@Override
	public AccountPojo withdraw(int accountNumber, double amount) {
		return accountDao.withdraw(accountNumber, amount);

	}

	@Override
	public List<AccountPojo> viewBalance() {
		return accountDao.viewBalance();
	}
	
	@Override
	public AccountPojo getAccount(int accountNumber) {
		return accountDao.getAccount(accountNumber);
	}	

}
