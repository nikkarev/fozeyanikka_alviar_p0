package dao;

import java.util.List;

import exception.LoginFailedException;
import exception.SystemException;
import model.CustomerPojo;

public interface CustomerDao {

	CustomerPojo createCustomer(CustomerPojo customerPojo) throws SystemException;

	void deleteAccount(int customerId) throws SystemException; 

	CustomerPojo customerLogin(CustomerPojo customerPojo) throws SystemException, LoginFailedException; 
	
}
