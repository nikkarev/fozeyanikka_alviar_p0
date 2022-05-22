package model;

public class AccountPojo {
	private int accountId;
	private double balance = 0.0;
	
	public AccountPojo() {
		super();
	}

	public AccountPojo(int accountId, double balance) {
		super();
		this.accountId = accountId;
		this.balance = balance;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "AccountPojo [accountId=" + accountId + ", balance=" + balance + "]";
	}
}
