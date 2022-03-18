package tn.esprit.spring.Services.Interfaces;

import java.util.List;

import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Transaction;
import tn.esprit.spring.entities.TransactionNature;
import tn.esprit.spring.entities.TypeTransaction;


public interface TransactionServices {
	List<Transaction>retrieveAllTransaction();
	Transaction addTransaction(Transaction t);
	void deleteTransaction(int id);
	Transaction updateTransaction(Transaction t);
	Transaction retrieveTransaction(int id);
	void heighestClient();
	void mediumClient();
	void lowClient();
	List<Transaction> retrieveAllTransactionAsc();
	List<Transaction> retrieveAllTransactionDesc();
	List<Transaction> retrieveAllTransactionByType(String type);
	List<Transaction> retrieveAllTransactionByNature(String nature);
	
}
