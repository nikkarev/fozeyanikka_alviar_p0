package model;

public class LoginPojo {

	private int customer_id;
	private String password;
	
	public LoginPojo() {
		super();
	}

	public LoginPojo(int customer_id, String password) {
		super();
		this.customer_id = customer_id;
		this.password = password;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginPojo [customer_id=" + customer_id + ", password=" + password + "]";
	}

}
