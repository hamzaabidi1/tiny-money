package tn.esprit.spring.Services.Implementation;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entities.Transaction;
import tn.esprit.spring.entities.Repository.AccountRepository;
import tn.esprit.spring.entities.Repository.TransactionRepository;
import tn.esprit.spring.Services.Interfaces.TransactionServices;

@Service
public class TransactionServicesImpl implements TransactionServices {
	private static final Logger LOGGER = LoggerFactory.getLogger(TransactionServicesImpl.class);

	@Autowired
	TransactionRepository TransactionRep;
	@Autowired
	public JavaMailSender emailSender;
	@Autowired
	AccountRepository accountRepository;

	@Override
	public List<Transaction> retrieveAllTransaction() {
		LOGGER.info("IN retrieve all transaction ");
		List<Transaction> transactions = (TransactionRep.findAll());
		// elle va retourner un objet iterable alors il faut faire le cast avec
		// (List<Transaction>)
		return transactions;
	}

	@Override
	public Transaction addTransaction(Transaction t) {

		LOGGER.info("IN Add transaction ");
		if (t.getAmountTransaction() > 100) {
			SimpleMailMessage message = new SimpleMailMessage();
			message.setTo(t.getAccount().getUser().getEmail());
			message.setSubject("Transaction");
			message.setText("your transaction amount is" + t.getAmountTransaction());
			this.emailSender.send(message);
		}
		Transaction tr = TransactionRep.save(t);
		t.getAccount().setTotalAccount(t.getAccount().getTotalAccount() - 3 + t.getAmountTransaction());
		accountRepository.save(t.getAccount());
		return tr;
	}

	@Override
	public void deleteTransaction(int id) {
		LOGGER.info("IN delete transaction ");
		TransactionRep.deleteById(id);
	}

	@Override
	public Transaction updateTransaction(Transaction t) {
		LOGGER.info("IN update transaction ");
		Transaction tr = TransactionRep.save(t);
		return tr;
	}

	@Override
	public Transaction retrieveTransaction(int id) {
		LOGGER.info("IN retrieve transaction ");
		return (Transaction) TransactionRep.findById(id).get();
	}

	@Override
	public List<Transaction> retrieveAllTransactionAsc() {
		LOGGER.info("IN retrieve all transaction en tri croissant ");
		List<Transaction> transactions = new ArrayList<Transaction>();
		transactions = TransactionRep.findAllOrderByAmountTransactionAsc();
		return transactions;
	}

	@Override
	public List<Transaction> retrieveAllTransactionDesc() {
		LOGGER.info("IN retrieve all transaction en tri decroissant ");
		List<Transaction> transactions = new ArrayList<Transaction>();
		transactions = TransactionRep.findAllOrderByAmountTransactionDesc();
		return transactions;
	}

	@Override
	public void heighestClient() {
		LOGGER.info("IN heighestClient ");
		List<String> emails = accountRepository.findAllAccountHight();
		for (int i = 0; i < emails.size(); i++) {
			SimpleMailMessage message = new SimpleMailMessage();
			message.setTo(emails.get(i));
			message.setSubject("Offer for You ");
			message.setText("you are one of our best client More benifits for You");
			this.emailSender.send(message);
		}

	}

	@Override
	public void mediumClient() {
		LOGGER.info("IN mediumClient ");
		List<String> emails = accountRepository.findAllAccountMedium();
		for (int i = 0; i < emails.size(); i++) {
			SimpleMailMessage message = new SimpleMailMessage();
			message.setTo(emails.get(i));
			message.setSubject("Offer for You ");
			message.setText("you can have More benifits for You");
			this.emailSender.send(message);
		}

	}

	@Override
	public void lowClient() {
		LOGGER.info("IN lowClient ");
		List<String> emails = accountRepository.findAllAccountLow();
		for (int i = 0; i < emails.size(); i++) {
			SimpleMailMessage message = new SimpleMailMessage();
			message.setTo(emails.get(i));
			message.setSubject("Offer for You ");
			message.setText("our good client why you are absent ");
			this.emailSender.send(message);
		}

	}

	@Override
	public List<Transaction> retrieveAllTransactionByType(String type) {
		LOGGER.info("IN retrieve All Transaction filtred By Type ");
		List<Transaction> transactions = new ArrayList<Transaction>();
		transactions = TransactionRep.findAllByTypeTransaction(type);
		return transactions;
	}

	@Override
	public List<Transaction> retrieveAllTransactionByNature(String nature) {
		LOGGER.info("IN retrieve All Transaction filtred By Nature ");
		List<Transaction> transactions = new ArrayList<Transaction>();
		transactions = TransactionRep.findAllByTransactionNature(nature);
		return transactions;
	}
}
