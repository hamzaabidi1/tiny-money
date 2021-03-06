package tn.esprit.spring.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

@Entity

public class Loan implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id	
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idLoan")
	
	private long idLoan;
	private String NameLoan;
	private String TMM;
	private Long montant;
	private String DescriptionLoan;
	@Temporal(TemporalType.DATE)
	private Date DateTakeLoan;
	@Temporal(TemporalType.DATE)
	private Date DatePayLoan;
	
	@Enumerated(EnumType.STRING)
	private TypeLoan TypeLoan;
	
	@ManyToOne
	private Account account;
	
	@OneToOne
	private Insurance insurance;

	public Loan(String nameLoan, String tMM, String descriptionLoan, Date dateTakeLoan, Date datePayLoan,
			TypeLoan typeLoan,Long montant) {
		super();
		NameLoan = nameLoan;
		TMM = tMM;
		DescriptionLoan = descriptionLoan;
		DateTakeLoan = dateTakeLoan;
		DatePayLoan = datePayLoan;
		TypeLoan = typeLoan;
		this.montant=montant;
	}

	public Loan() {
	
	}

	public long getIdLoan() {
		return idLoan;
	}

	public void setIdLoan(long idLoan) {
		this.idLoan = idLoan;
	}

	public String getNameLoan() {
		return NameLoan;
	}

	public void setNameLoan(String nameLoan) {
		NameLoan = nameLoan;
	}

	public String getTMM() {
		return TMM;
	}

	public void setTMM(String tMM) {
		TMM = tMM;
	}

	public String getDescriptionLoan() {
		return DescriptionLoan;
	}

	public void setDescriptionLoan(String descriptionLoan) {
		DescriptionLoan = descriptionLoan;
	}

	public Date getDateTakeLoan() {
		return DateTakeLoan;
	}

	public void setDateTakeLoan(Date dateTakeLoan) {
		DateTakeLoan = dateTakeLoan;
	}

	public Date getDatePayLoan() {
		return DatePayLoan;
	}

	public void setDatePayLoan(Date datePayLoan) {
		DatePayLoan = datePayLoan;
	}

	public TypeLoan getTypeLoan() {
		return TypeLoan;
	}

	public void setTypeLoan(TypeLoan typeLoan) {
		TypeLoan = typeLoan;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Long getMontant() {
		return montant;
	}

	public void setMontant(Long montant) {
		this.montant = montant;
	}

	
	
	
	
	
	
	
}
