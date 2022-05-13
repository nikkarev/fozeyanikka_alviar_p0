package model;

public class TransactionPojo {

	private int transactionNumber;
	private double transactionAmount;
	
	public TransactionPojo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TransactionPojo(int transactionNumber, double transactionAmount) {
		super();
		this.transactionNumber = transactionNumber;
		this.transactionAmount = transactionAmount;
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

	@Override
	public String toString() {
		return "TransactionPojo [transactionNumber=" + transactionNumber + ", transactionAmount=" + transactionAmount
				+ "]";
	}
	
}
