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
	private double balance;
	private double amount;
	
	public AccountPojo() {
		super();
	}

	public AccountPojo(int accountNumber, String accountType, double balance, double amount) {
		super();
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.balance = balance;
		this.amount = amount;
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

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "AccountPojo [accountNumber=" + accountNumber + ", accountType=" + accountType + ", balance="
				+ balance + ", amount=" + amount + "]";
	}

	
	
}
