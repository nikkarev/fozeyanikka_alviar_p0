package service;

import exception.LoginFailedException;
import exception.SystemException;
import model.CustomerPojo;

public interface CustomerService {
	
	CustomerPojo createCustomer(CustomerPojo customerPojo) throws SystemException; //CREATE

	void deleteAccount(int customerId) throws SystemException; //DELETE

	CustomerPojo customerLogin(CustomerPojo customerPojo) throws SystemException, LoginFailedException; 
}
