package model;

public class CustomerPojo {
	private int customerId;
	private int accountNumber;
	private String password;
	
	public CustomerPojo() {
		super();
	}

	public CustomerPojo(int customerId, int accountNumber, String password) {
		super();
		this.customerId = customerId;
		this.accountNumber = accountNumber;
		this.password = password;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "CustomerPojo [customerId=" + customerId + ", accountNumber=" + accountNumber + ", password=" + password
				+ "]";
	}
	
}
