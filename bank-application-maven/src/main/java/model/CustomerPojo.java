package model;

public class CustomerPojo {
	private int customerId;
	private String password;
	
	public CustomerPojo() {
		super();
	}
	public CustomerPojo(int customerId, String password) {
		super();
		this.customerId = customerId;
		this.password = password;
	}
	
	public int getCustomerId() {
		return customerId;
	}
	
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "CustomerPojo [customerId=" + customerId + ", password=" + password + "]";
	}
}
