package tn.esprit.spring.Services.Interfaces;

import java.util.List;

import tn.esprit.spring.entities.Transaction;


public interface TransactionServices {
	
	List<Transaction>retrieveAllTransaction();
	
	Transaction addTransaction(Transaction t);
	
	void deleteTransaction(Long id);
	
	Transaction updateTransaction(Transaction t);
	
	Transaction retrieveTransaction(Long id);
	
	List<Transaction> retrieveAllTransactionAsc();
	List<Transaction> retrieveAllTransactionDesc();
	List<Transaction> retrieveAllTransactionByType(String type);
	List<Transaction> retrieveAllTransactionByNature(String nature);
	
	
	/*
	List<Account> retrieveAccountsByAmount_Interface(@Param("amount, dateTrasaction") Amount amount, DateTransaction dateTrasaction);
	List<Account> retrieveAccountsBytransactionNumber_Interface(@Param("dateTrasaction")DateTransaction dateTrasaction);
	List<Account> retrieveAccountsByAmount_Interface(@Param("typeAccount, dateTrasaction") TypeAccount typeAccount, DateTransaction dateTrasaction); 
		 */
}
