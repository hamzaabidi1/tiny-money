package tn.esprit.spring.Services.Implementation;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Account;
import tn.esprit.spring.entities.Transaction;
import tn.esprit.spring.entities.TransactionNature;
import tn.esprit.spring.entities.TypeTransaction;
import tn.esprit.spring.entities.Repository.AccountRepository;
import tn.esprit.spring.entities.Repository.TransactionRepository;
import tn.esprit.spring.Services.Interfaces.AccountServices;
import tn.esprit.spring.Services.Interfaces.TransactionServices;


@Service
public class TransactionServicesImpl implements TransactionServices{

	@Autowired
	TransactionRepository TransactionRep;
	@Autowired
    public JavaMailSender emailSender;
	@Autowired
	AccountRepository accountRepository;
	
	@Override
	public List<Transaction> retrieveAllTransaction() {
		List<Transaction> transactions = (TransactionRep.findAll());
				//elle va retourner un objet iterable alors il faut faire le cast avec (List<Transaction>)
		return transactions;
	}

	@Override
	public Transaction addTransaction(Transaction t) {
		if (t.getAmountTransaction()>100)
		{
			  SimpleMailMessage message = new SimpleMailMessage();
		        message.setTo(t.getAccount().getUser().getEmail());
		        message.setSubject("Transaction");
		        message.setText("your transaction amount is"+t.getAmountTransaction());
		        this.emailSender.send(message);
		}
		Transaction tr = TransactionRep.save(t);
        t.getAccount().setTotalAccount(t.getAccount().getTotalAccount()-3+t.getAmountTransaction());
        accountRepository.save(t.getAccount());
		return tr;
	}

	@Override
	public void deleteTransaction(int id) {
		TransactionRep.deleteById(id);
	}

	@Override
	public Transaction updateTransaction(Transaction t) {		
		Transaction tr = TransactionRep.save(t);
		return tr;
	}

	@Override
	public Transaction retrieveTransaction(int id) {
				return (Transaction) TransactionRep.findById(id).get();
	}

	@Override
	public List<Transaction> retrieveAllTransactionAsc() {
		List<Transaction> transactions = new ArrayList<Transaction>();
		transactions = TransactionRep.findAllOrderByAmountTransactionAsc();
		return transactions;
	}

	@Override
	public List<Transaction> retrieveAllTransactionDesc() {
		List<Transaction> transactions = new ArrayList<Transaction>();
		transactions = TransactionRep.findAllOrderByAmountTransactionDesc();
		return transactions;
	}

	@Override
	public void heighestClient() {
		List<String> emails =accountRepository.findAllAccountHight();
		for (int i=0;i<emails.size();i++) {
			 SimpleMailMessage message = new SimpleMailMessage();
		        message.setTo(emails.get(i));
		        message.setSubject("Offer for You ");
		        message.setText("you are one of our best client More benifits for You");
		        this.emailSender.send(message);
		}
		
	}

	@Override
	public void mediumClient() {
		List<String> emails =accountRepository.findAllAccountMedium();
		for (int i=0;i<emails.size();i++) {
			 SimpleMailMessage message = new SimpleMailMessage();
		        message.setTo(emails.get(i));
		        message.setSubject("Offer for You ");
		        message.setText("you can have More benifits for You");
		        this.emailSender.send(message);
		}
		
		
	}

	@Override
	public void lowClient() {
		List<String> emails =accountRepository.findAllAccountLow();
		for (int i=0;i<emails.size();i++) {
			 SimpleMailMessage message = new SimpleMailMessage();
		        message.setTo(emails.get(i));
		        message.setSubject("Offer for You ");
		        message.setText("our good client why you are absent ");
		        this.emailSender.send(message);
		}
		
		
	}
	
	

	@Override
	public List<Transaction> retrieveAllTransactionByType(String type) {
		List<Transaction> transactions = new ArrayList<Transaction>();
		transactions = TransactionRep.findAllByTypeTransaction(type);
		return transactions;
	}

	@Override
	public List<Transaction> retrieveAllTransactionByNature(String nature) {
		List<Transaction> transactions = new ArrayList<Transaction>();
		transactions = TransactionRep.findAllByTransactionNature(nature);
		return transactions;
	}

	/*
	//------------------------------Commande de selection des clients a risque de non payement ------------------------

	
	//------------------------------Risque de blanchiment d'arrgent ---------------------------------------------------
	

	
	
	//-------Client potentiel (count(transaction) dont le mantant de transaction réçu dépasse les 100000)>3 dans un intervalle de temps de 3 mois )----------
	@Override
	public List<Account> retrieveAccountsByAmount(Amount amount, DateTransaction dateTrasaction)
	{
		List<Account> AccountAmount = (List<Account>)(AccountAmount.retrieveAccountsByAmount(amount, dateTransaction));
		return AccountAmount;
	}
	
	
	//-------Client fidèle (nbre de transaction récu > 5 pandant 1 moin)
	@Override
	public List<Account> retrieveAccountsBytransactionNumber(DateTransaction dateTrasaction)
	{
		List<Account> AccountTransactionNumber = (List<Account>)(AccountTransactionNumber.retrieveAccountsBytransactionNumber(dateTransaction));
		return AccountTransactionNumber;
	}	
	
	
	//-----Client a risque de quitter la banque (si le compte n'est pas épargnie et il n'a pas émis ou récu de transaction durant 1 mois) ------------------
	@Override
	public List<Account> retrieveAccountsByTypeAccount(TypeAccount typeAccount, DateTransaction dateTrasaction)
	{
		List<Account> acountType = (List<Account>)(AccountType.retrieveAccountsByTypeAccount(typeAccount, dateTransaction));
		return AccountType;
	}*/
}
