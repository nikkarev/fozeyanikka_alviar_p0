package service;

import dao.CustomerDao;
import dao.CustomerDaoDatabaseImpl;
import model.CustomerPojo;

public class CustomerServiceImpl implements CustomerService{
	
	CustomerDao customerDao;

	public CustomerServiceImpl() {
		customerDao = new CustomerDaoDatabaseImpl();
		
	}

	public CustomerDao getCustomerDao() {
		return customerDao;
	}

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	@Override
	public CustomerPojo createCustomer(CustomerPojo customerPojo) {
		return customerDao.createCustomer(customerPojo);
	}

	@Override
	public CustomerPojo updatePassword(CustomerPojo customerPojo) {
		return customerDao.updatePassword(customerPojo);
	}

	@Override
	public void deleteAccount(int customerId) {
		customerDao.deleteAccount(customerId);
	}

	@Override
	public CustomerPojo customerLogin(CustomerPojo customerPojo) {
		return customerDao.customerLogin(customerPojo);
	}
	
}
