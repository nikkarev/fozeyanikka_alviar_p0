package model;

public class TransactionPojo {

	private int transactionNumber;
	private double transactionAmount;
	private int transactionDate; //may remove
	
	public TransactionPojo() {
		super();
	}

	public TransactionPojo(int transactionNumber, double transactionAmount, int transactionDate) {
		super();
		this.transactionNumber = transactionNumber;
		this.transactionAmount = transactionAmount;
		this.transactionDate = transactionDate;
	}

	public int getTransactionNumber() {
		return transactionNumber;
	}

	public void setTransactionNumber(int transactionNumber) {
		this.transactionNumber = transactionNumber;
	}

	public double getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public int getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(int transactionDate) {
		this.transactionDate = transactionDate;
	}

	@Override
	public String toString() {
		return "TransactionPojo [transactionNumber=" + transactionNumber + ", transactionAmount=" + transactionAmount
				+ ", transactionDate=" + transactionDate + "]";
	}
	
}
