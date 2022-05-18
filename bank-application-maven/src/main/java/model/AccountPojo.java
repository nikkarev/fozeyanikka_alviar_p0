package model;

public class AccountPojo {
	private int accountNumber;
	private double balance = 0.0;
	
	public AccountPojo() {
		super();
	}

	public AccountPojo(int accountNumber, double balance) {
		super();
		this.accountNumber = accountNumber;
		this.balance = balance;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "AccountPojo [accountNumber=" + accountNumber + ", balance=" + balance + "]";
	}
}
