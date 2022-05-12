package model;

/*
 * POJO has no references to any framework.
 * POJO has no naming convention for its properties and methods
 * POJO doesn't follow any real convention for constructing, 
 * accessing, or modifying the class's state.
 * POJO increases the readability & re-usability of a Java program.
 * 
 * POJO class contains variables and their Getters and Setters
 * 
 * POJO class are used to define the object entities
 */
public class AccountPojo {
	private int accountNumber;
	private String accountType;
	private double currentBalance;
	
	public AccountPojo() {
		super();
	}

	public AccountPojo(int accountNumber, String accountType, double currentBalance) {
		super();
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.currentBalance = currentBalance;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public double getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(double currentBalance) {
		this.currentBalance = currentBalance;
	}

	@Override
	public String toString() {
		return "AccountPojo [accountNumber=" + accountNumber + ", accountType=" + accountType + ", currentBalance="
				+ currentBalance + "]";
	}	
	
}
