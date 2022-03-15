package tn.esprit.spring.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity

public class Loan implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id	
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idLoan")
	
	private long idLoan;
	private String NameLoan;
	private String TMM;
	private String DescriptionLoan;
	@Temporal(TemporalType.DATE)
	private Date DateTakeLoan;
	@Temporal(TemporalType.DATE)
	private Date DatePayLoan;
	
	@Enumerated(EnumType.STRING)
	private TypeLoan TypeLoan;
	
	@ManyToMany(mappedBy="loan")
	private Set<Account>account;
	
	@OneToOne
	private Insurance insurance;

	public Loan(String nameLoan, String tMM, String descriptionLoan, Date dateTakeLoan, Date datePayLoan,
			tn.esprit.spring.entities.TypeLoan typeLoan) {
		super();
		NameLoan = nameLoan;
		TMM = tMM;
		DescriptionLoan = descriptionLoan;
		DateTakeLoan = dateTakeLoan;
		DatePayLoan = datePayLoan;
		TypeLoan = typeLoan;
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
	
	
	
	
}
