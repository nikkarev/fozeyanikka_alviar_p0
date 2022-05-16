package service;

import model.CustomerPojo;

public interface CustomerService {
	
	CustomerPojo createCustomer(CustomerPojo customerPojo); //CREATE

	void deleteAccount(int customerId); //DELETE

	CustomerPojo customerLogin(CustomerPojo customerPojo); 
}
