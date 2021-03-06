package tn.esprit.spring.entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;


@Entity
public class Transaction implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id	
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long idTransaction;
	@Enumerated(EnumType.STRING)
	private TypeTransaction TypeTransaction;
	@Enumerated(EnumType.STRING)
	private TransactionNature TransactionNature;
	@Temporal(TemporalType.DATE)
	private Date DateTransaction;
	private float AmountTransaction;
	@ManyToOne
	private Account account;
	private Account accountdestinataire;
	private EStatus status;
	private String tokenValidation;
	
	
	
	public Transaction(long idTransaction, tn.esprit.spring.entities.TypeTransaction typeTransaction,
			tn.esprit.spring.entities.TransactionNature transactionNature, Date dateTransaction,
			float amountTransaction, Account account, Account accountdestinataire, EStatus status,
			String tokenValidation) {
		super();
		this.idTransaction = idTransaction;
		TypeTransaction = typeTransaction;
		TransactionNature = transactionNature;
		DateTransaction = dateTransaction;
		AmountTransaction = amountTransaction;
		this.account = account;
		this.accountdestinataire = accountdestinataire;
		this.status = status;
		this.tokenValidation = tokenValidation;
	}
	public Transaction(TypeTransaction typeTransaction,
			TransactionNature transactionNature, Date dateTransaction,
			float amountTransaction) {
		super();
		TypeTransaction = typeTransaction;
		TransactionNature = transactionNature;
		DateTransaction = dateTransaction;
		AmountTransaction = amountTransaction;
	}
	public Transaction() {

	}
	public long getIdTransaction() {
		return idTransaction;
	}
	public void setIdTransaction(long idTransaction) {
		this.idTransaction = idTransaction;
	}
	public TypeTransaction getTypeTransaction() {
		return TypeTransaction;
	}
	public void setTypeTransaction(TypeTransaction typeTransaction) {
		TypeTransaction = typeTransaction;
	}
	public TransactionNature getTransactionNature() {
		return TransactionNature;
	}
	public void setTransactionNature(TransactionNature transactionNature) {
		TransactionNature = transactionNature;
	}
	public Date getDateTransaction() {
		return DateTransaction;
	}
	public void setDateTransaction(Date dateTransaction) {
		DateTransaction = dateTransaction;
	}
	public float getAmountTransaction() {
		return AmountTransaction;
	}
	public void setAmountTransaction(float amountTransaction) {
		AmountTransaction = amountTransaction;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public Account getAccountdestinataire() {
		return accountdestinataire;
	}
	public void setAccountdestinataire(Account accountdestinataire) {
		this.accountdestinataire = accountdestinataire;
	}
	public EStatus getStatus() {
		return status;
	}
	public void setStatus(EStatus status) {
		this.status = status;
	}
	public String getTokenValidation() {
		return tokenValidation;
	}
	public void setTokenValidation(String tokenValidation) {
		this.tokenValidation = tokenValidation;
	}
	
	
	
	
	
}
