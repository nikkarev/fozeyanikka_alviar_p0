package service;

import exception.LoginFailedException;
import exception.SystemException;
import model.CustomerPojo;

public interface CustomerService {

	CustomerPojo createCustomer(CustomerPojo customerPojo) throws SystemException;

	public void deleteAccount(int customerId) throws SystemException;

	public CustomerPojo customerLogin(CustomerPojo customerPojo) throws SystemException, LoginFailedException;

}
