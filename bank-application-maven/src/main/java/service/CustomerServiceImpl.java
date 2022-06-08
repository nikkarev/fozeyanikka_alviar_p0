package service;

import dao.AccountDao;
import dao.CustomerDao;
import dao.CustomerDaoImpl;
import exception.LoginFailedException;
import exception.SystemException;
import model.CustomerPojo;

public class CustomerServiceImpl implements CustomerService {
	
	CustomerDao customerDao;

	public CustomerServiceImpl() {
		customerDao = new CustomerDaoImpl();
	}

	public CustomerDao getCustomerDao() {
		return customerDao;
	}
	
	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	@Override
	public CustomerPojo createCustomer(CustomerPojo customerPojo) throws SystemException {
		return customerDao.createCustomer(customerPojo);
	}

	@Override
	public void deleteAccount(int customerId) throws SystemException {
		customerDao.deleteAccount(customerId);
	}

	@Override
	public CustomerPojo customerLogin(CustomerPojo customerPojo) throws SystemException, LoginFailedException {
		return customerDao.customerLogin(customerPojo);
	}

	
}
