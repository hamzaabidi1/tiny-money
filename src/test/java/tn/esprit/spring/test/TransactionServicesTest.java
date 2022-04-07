package tn.esprit.spring.test;

import java.util.Date;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tn.esprit.spring.Services.Interfaces.TransactionServices;
import tn.esprit.spring.entities.Account;
import tn.esprit.spring.entities.EStatus;
import tn.esprit.spring.entities.Transaction;
import tn.esprit.spring.entities.TransactionNature;
import tn.esprit.spring.entities.TypeTransaction;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TransactionServicesTest {
	@Autowired
	TransactionServices transactionServices;
	Transaction transaction;
	//please complete data for testing
	//please fill constructors of envoie and destinataire and attribut token 

	@Before
	public void init() {
		
		Account envoie=new Account();
		Account distinataire = new Account();
		String token ="";
		Date date =new Date();
		transaction=new Transaction(1,TypeTransaction.Transfer,TransactionNature.LoanPayment,date,(float) 18.0,envoie,distinataire,EStatus.denied,token);
		transactionServices.addTransaction(transaction);
	}
	
	@After
	public void teardown() {
	transactionServices.deleteTransaction((int) transaction.getIdTransaction());
	}
	
	@Test
	public void testvalidate() {
		Assert.assertEquals(transaction, transactionServices.validate(null, transaction));
		
	}
	
	@Test
	public void testupdateTransaction() {
		Assert.assertEquals(transaction, transactionServices.updateTransaction(transaction));
		
	}
	
	@Test
	public void testretrieveTransaction() {
		Assert.assertEquals(transaction, transactionServices.retrieveTransaction((int) transaction.getIdTransaction()));
		
	}
	
}
