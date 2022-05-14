package dao;

import java.util.List;

import model.CustomerPojo;

public interface CustomerDao {

	CustomerPojo createCustomer(CustomerPojo customerPojo); //CREATE

	CustomerPojo updateCustomer(CustomerPojo customerPojo); //UPDATE

	void deleteAccount(int customerId); //DELETE

	List<CustomerPojo> displayCustomer(); //READ

	CustomerPojo customerLogin(CustomerPojo customerPojo); 
	
}
