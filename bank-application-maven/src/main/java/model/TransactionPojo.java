package model;

public class TransactionPojo {

	private int transactionNumber;
	private double amount;
	
	public TransactionPojo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TransactionPojo(int transactionNumber, double amount) {
		super();
		this.transactionNumber = transactionNumber;
		this.amount = amount;
	}

	public int getTransactionNumber() {
		return transactionNumber;
	}

	public void setTransactionNumber(int transactionNumber) {
		this.transactionNumber = transactionNumber;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "TransactionPojo [transactionNumber=" + transactionNumber + ", amount=" + amount + "]";
	}

	
	
}
