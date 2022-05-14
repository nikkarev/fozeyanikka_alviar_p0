package model;

public class CustomerPojo {
	private String customerFirstName;
	private String customerLastName;
	private String address;
	private int username;
	private String password;

	public CustomerPojo() {
		super();
	}

	public CustomerPojo(String customerFirstName, String customerLastName, String address, int username,
			String password) {
		super();
		this.customerFirstName = customerFirstName;
		this.customerLastName = customerLastName;
		this.address = address;
		this.username = username;
		this.password = password;
	}

	public String getCustomerFirstName() {
		return customerFirstName;
	}

	public void setCustomerFirstName(String customerFirstName) {
		this.customerFirstName = customerFirstName;
	}

	public String getCustomerLastName() {
		return customerLastName;
	}

	public void setCustomerLastName(String customerLastName) {
		this.customerLastName = customerLastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getUsername() {
		return username;
	}

	public void setUsername(int username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "CustomerPojo [customerFirstName=" + customerFirstName + ", customerLastName=" + customerLastName
				+ ", address=" + address + ", username=" + username + ", password=" + password + "]";
	}



}
