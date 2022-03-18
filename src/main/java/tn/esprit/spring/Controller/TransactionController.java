package tn.esprit.spring.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Transaction;
import tn.esprit.spring.entities.TransactionNature;
import tn.esprit.spring.entities.TypeTransaction;
import tn.esprit.spring.Services.Interfaces.TransactionServices;

@RestController
public class TransactionController {
	

	@Autowired
	private TransactionServices tsi ;
	
	@GetMapping("getAllTransaction")
	public List<Transaction>getAllTransactions(){
		List<Transaction>transactions= tsi.retrieveAllTransaction();
		return transactions;
	}
	@PostMapping("/AddTransaction")
	public Transaction Addtransaction(@RequestBody Transaction t){
		Transaction tr= tsi.addTransaction(t);
		return tr;
	}
	@PutMapping("/PutTransaction")
	public Transaction Updatetransaction(@RequestBody Transaction t){
		Transaction tr=tsi.updateTransaction(t);
		return tr;
	}
	@DeleteMapping("/deletetransaction/{idTrans}")
	public void deletetransaction(@PathVariable("idTrans")int idTrans){
		tsi.deleteTransaction(idTrans);
		
	}
	@GetMapping("gettransaction/{idTrans}")
	public Transaction gettransactionbyid (@PathVariable("idTrans")int idTrans){
		return tsi.retrieveTransaction(idTrans);
	}
	
	@GetMapping("getAllTransactionAsc")
	public List<Transaction>getAllTransactionsAsc(){
		List<Transaction>transactions= tsi.retrieveAllTransactionAsc();
		return transactions;
	}
	@GetMapping("getAllTransactionDesc")
	public List<Transaction>getAllTransactionsDesc(){
		List<Transaction>transactions= tsi.retrieveAllTransactionDesc();
		return transactions;
	}
	
	@GetMapping("getAllTransactionWithType/{type}")
	public List<Transaction>getAllTransactionsType(@PathVariable("type")String type){
		List<Transaction>transactions= tsi.retrieveAllTransactionByType(type);
		return transactions;
	}
	
	@GetMapping("getAllTransactionWithType/{nature}")
	public List<Transaction>getAllTransactionsNature(@PathVariable("nature")String nature){
		List<Transaction>transactions= tsi.retrieveAllTransactionByNature(nature);
		return transactions;
	}
	
	
	//*********************************************************************//
/*
	
	@GetMapping("AcountsByAmount/{amount, dateTrasaction}") // car elle va seulement afficher 
	public List<Account> GetAllAccountsByAmount(@PathVariable TypeAccount typeAccount, DateTransaction dateTrasaction){
		return AccountServiceImpl.retrieveAccountsByAmount_Interface(amount, dateTrasaction);
	}
	
	@GetMapping("AccountsBytransactionNumber/{dateTrasaction}") // car elle va seulement afficher 
	public List<Account> GetAllAccountsByAmount(@PathVariable DateTransaction dateTrasaction){
		return AccountsServiceImpl.retrieveAccountsBytransactionNumber_Interface(amount, dateTrasaction);
	}
	
	@GetMapping("AccountsByAmount/{typeAccount, dateTrasaction}") // car elle va seulement afficher 
	public List<Account> GetAllAccountsByAmount(@PathVariable Amount amount, DateTransaction dateTrasaction){
		return AccountsServiceImpl.retrieveAccountsByAmount_Interface(typeAccount, dateTrasaction);
	}*/

}
