package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id	
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long idproduct;
	private String nomproduct;
	private String descriptionproduct;
	@Temporal(TemporalType.DATE)
	private Date dateproduct;
	@ManyToOne
	private User user;
	
	public long getIdproduct() {
		return idproduct;
	}
	public void setIdproduct(long idproduct) {
		this.idproduct = idproduct;
	}
	public String getNomproduct() {
		return nomproduct;
	}
	public void setNomproduct(String nomproduct) {
		this.nomproduct = nomproduct;
	}
	public String getDescriptionproduct() {
		return descriptionproduct;
	}
	public void setDescriptionproduct(String descriptionproduct) {
		this.descriptionproduct = descriptionproduct;
	}
	public Date getDateproduct() {
		return dateproduct;
	}
	public void setDateproduct(Date dateproduct) {
		this.dateproduct = dateproduct;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Product(String nomproduct, String descriptionproduct, Date dateproduct) {
		super();
		this.nomproduct = nomproduct;
		this.descriptionproduct = descriptionproduct;
		this.dateproduct = dateproduct;
	}
	public Product() {
		
	}
	
	
		
	
	
	
	

}
