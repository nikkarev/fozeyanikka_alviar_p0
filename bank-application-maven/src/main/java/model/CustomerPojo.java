package model;

public class CustomerPojo {
	private int customerId;
	private int accountId;
	private String password;
	
	public CustomerPojo() {
		super();
	}

	public CustomerPojo(int customerId, int accountId, String password) {
		super();
		this.customerId = customerId;
		this.accountId = accountId;
		this.password = password;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "CustomerPojo [customerId=" + customerId + ", accountId=" + accountId + ", password=" + password
				+ "]";
	}
	
}
