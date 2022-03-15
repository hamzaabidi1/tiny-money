package tn.esprit.spring.entities;


import javax.persistence.Entity;
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

public class Complaint implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id	
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	
	
	private long idComplaint;
	@Temporal(TemporalType.DATE)
	private Date DateComplaint;
	private String ComplaintDescription;
	@OneToOne
	private ReplyComplaint replycomplaint;
	@ManyToMany (mappedBy="complaint")
	private Set<User>user;
	
	public Complaint(Date dateComplaint, String complaintDescription) {
		super();
		DateComplaint = dateComplaint;
		ComplaintDescription = complaintDescription;
	}

	public Complaint() {
		
	}

	public long getIdComplaint() {
		return idComplaint;
	}

	public void setIdComplaint(long idComplaint) {
		this.idComplaint = idComplaint;
	}

	public Date getDateComplaint() {
		return DateComplaint;
	}

	public void setDateComplaint(Date dateComplaint) {
		DateComplaint = dateComplaint;
	}

	public String getComplaintDescription() {
		return ComplaintDescription;
	}

	public void setComplaintDescription(String complaintDescription) {
		ComplaintDescription = complaintDescription;
	}
	
}
