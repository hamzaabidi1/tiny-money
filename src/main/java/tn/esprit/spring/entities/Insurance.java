package tn.esprit.spring.entities;

import java.io.Serializable;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity

public class Insurance implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id	
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	
	
	private long idInsurance;
	
	private String DescriptionInsurance;
	private String GuarantFullName;
	private String GuarantJob;
	private String GuarantSalary;
	private String GuarantEmail; 
	private long GuarantTel;
	@OneToOne(mappedBy="insurance")
	private Loan loan;
	public Insurance(String descriptionInsurance, String guarantFullName, String guarantJob, String guarantSalary,
			String guarantEmail, long guarantTel) {
		super();
		DescriptionInsurance = descriptionInsurance;
		GuarantFullName = guarantFullName;
		GuarantJob = guarantJob;
		GuarantSalary = guarantSalary;
		GuarantEmail = guarantEmail;
		GuarantTel = guarantTel;
	}
	
	public Insurance() {
		
	}
	public long getIdInsurance() {
		return idInsurance;
	}
	public void setIdInsurance(long idInsurance) {
		this.idInsurance = idInsurance;
	}
	public String getDescriptionInsurance() {
		return DescriptionInsurance;
	}
	public void setDescriptionInsurance(String descriptionInsurance) {
		DescriptionInsurance = descriptionInsurance;
	}
	public String getGuarantFullName() {
		return GuarantFullName;
	}
	public void setGuarantFullName(String guarantFullName) {
		GuarantFullName = guarantFullName;
	}
	public String getGuarantJob() {
		return GuarantJob;
	}
	public void setGuarantJob(String guarantJob) {
		GuarantJob = guarantJob;
	}
	public String getGuarantSalary() {
		return GuarantSalary;
	}
	public void setGuarantSalary(String guarantSalary) {
		GuarantSalary = guarantSalary;
	}
	public String getGuarantEmail() {
		return GuarantEmail;
	}
	public void setGuarantEmail(String guarantEmail) {
		GuarantEmail = guarantEmail;
	}
	public long getGuarantTel() {
		return GuarantTel;
	}
	public void setGuarantTel(long guarantTel) {
		GuarantTel = guarantTel;
	}
	
	
}
