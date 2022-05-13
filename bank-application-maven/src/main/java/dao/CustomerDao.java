package dao;

import model.CustomerPojo;

public interface CustomerDao {

	CustomerPojo createCustomer(CustomerPojo customerPojo); //CREATE
	
	CustomerPojo updateCustomer(CustomerPojo customerPojo); //UPDATE
	
	void deleteAccount(int customerId); //DELETE
	
	CustomerPojo displayCustomer(CustomerPojo customerPojo); //READ
	
	CustomerPojo customerLogin(CustomerPojo customerPojo); 
	
	
}
