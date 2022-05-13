package dao;

import model.TransactionPojo;

public interface TransactionDao {

	 TransactionPojo createTransaction(TransactionPojo transactionPojo); //CREATE

//	 TransactionPojo updateTransaction(TransactionPojo transactionPojo); //UPDATE -- NEEDED??

//	 TransactionPojo deleteTransaction(TransactionPojo transactionPojo); //DELETE -- NEEDED??

	 TransactionPojo displayTransaction(TransactionPojo transactionPojo); //READ
}
