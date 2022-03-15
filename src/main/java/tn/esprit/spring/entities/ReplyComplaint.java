package tn.esprit.spring.entities;

import java.io.Serializable;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity

public class ReplyComplaint implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id	
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	
	
	private long idReplyComplaint;
	private String DescriptionReplyComplaint;
	@OneToOne(mappedBy="replycomplaint")
	private Complaint complaint;
	public ReplyComplaint(String descriptionReplyComplaint) {
		super();
		DescriptionReplyComplaint = descriptionReplyComplaint;
	}
	public long getIdReplyComplaint() {
		return idReplyComplaint;
	}
	public void setIdReplyComplaint(long idReplyComplaint) {
		this.idReplyComplaint = idReplyComplaint;
	}
	public String getDescriptionReplyComplaint() {
		return DescriptionReplyComplaint;
	}
	public void setDescriptionReplyComplaint(String descriptionReplyComplaint) {
		DescriptionReplyComplaint = descriptionReplyComplaint;
	}
	public ReplyComplaint() {
		
	}
	
}
