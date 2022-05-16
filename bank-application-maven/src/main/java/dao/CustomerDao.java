package dao;

import java.util.List;

import model.CustomerPojo;

public interface CustomerDao {

	CustomerPojo createCustomer(CustomerPojo customerPojo); //CREATE

	void deleteAccount(int customerId); //DELETE

	CustomerPojo customerLogin(CustomerPojo customerPojo); 
	
}
