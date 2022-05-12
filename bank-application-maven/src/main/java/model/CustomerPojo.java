package model;

public class CustomerPojo {
	private int customerId;
	private String customerName;
	private String password;
	
	public CustomerPojo() {
		super();
	}

	public CustomerPojo(int customerId, String customerName, String password) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.password = password;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "CustomerPojo [customerId=" + customerId + ", customerName=" + customerName + ", password=" + password
				+ "]";
	}
	
}
