package service;

import model.CustomerPojo;

public interface CustomerService {
	
	CustomerPojo createCustomer(CustomerPojo customerPojo); //CREATE

	CustomerPojo updatePassword(CustomerPojo customerPojo); //UPDATE

	void deleteAccount(int customerId); //DELETE

//	List<CustomerPojo> displayCustomer(); //READ

	CustomerPojo customerLogin(CustomerPojo customerPojo); 
}
