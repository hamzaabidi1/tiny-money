package tn.esprit.spring.entities;


import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;




import java.io.Serializable;
import java.util.Date;
import java.util.Set;
@Entity
public class Account implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id	
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	
	
	private long idAccount;
	@Enumerated(EnumType.STRING)
	private TypeAccount TypeAccount;
	private long CIN;
	private long RIB;
	@Temporal(TemporalType.DATE)
	private Date DateCreation;
	private float TotalAccount;
	private Date dateLastFinancialInterest =DateCreation;
	
	@OneToOne
	private User user;
	@OneToMany(mappedBy="account")
	private Set<Loan>loan;
	
	@OneToMany(mappedBy="account")
	private Set<Transaction>transaction;
	
	public Account(TypeAccount typeAccount, long cIN, long rIB, Date dateCreation,
			float totalAccount) {
		super();
		TypeAccount = typeAccount;
		CIN = cIN;
		RIB = rIB;
		DateCreation = dateCreation;
		TotalAccount = totalAccount;
	}
	public Account() {
	
	}
	
	public Account(long idAccount, tn.esprit.spring.entities.TypeAccount typeAccount, long cIN, long rIB,
			Date dateCreation, float totalAccount, Date dateLastFinancialInterest, User user, Set<Loan> loan,
			Set<Transaction> transaction) {
		super();
		this.idAccount = idAccount;
		TypeAccount = typeAccount;
		CIN = cIN;
		RIB = rIB;
		DateCreation = dateCreation;
		TotalAccount = totalAccount;
		this.dateLastFinancialInterest = dateLastFinancialInterest;
		this.user = user;
		this.loan = loan;
		this.transaction = transaction;
	}
	public long getIdAccount() {
		return idAccount;
	}
	public void setIdAccount(long idAccount) {
		this.idAccount = idAccount;
	}
	public TypeAccount getTypeAccount() {
		return TypeAccount;
	}
	public void setTypeAccount(tn.esprit.spring.entities.TypeAccount typeAccount) {
		TypeAccount = typeAccount;
	}
	public long getCIN() {
		return CIN;
	}
	public void setCIN(long cIN) {
		CIN = cIN;
	}
	public long getRIB() {
		return RIB;
	}
	public void setRIB(long rIB) {
		RIB = rIB;
	}
	public Date getDateCreation() {
		return DateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		DateCreation = dateCreation;
	}
	public float getTotalAccount() {
		return TotalAccount;
	}
	public void setTotalAccount(float totalAccount) {
		TotalAccount = totalAccount;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Set<Loan> getLoan() {
		return loan;
	}
	public void setLoan(Set<Loan> loan) {
		this.loan = loan;
	}
	public Date getDateLastFinancialInterest() {
		return dateLastFinancialInterest;
	}
	public void setDateLastFinancialInterest(Date dateLastFinancialInterest) {
		this.dateLastFinancialInterest = dateLastFinancialInterest;
	}
	
	

	
	
	
	
	
}
