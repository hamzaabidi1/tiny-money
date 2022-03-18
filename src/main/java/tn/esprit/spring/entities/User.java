package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Set;


import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id	
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long idUser; 
	private String firstName;
	private String lastName;
	private String password;
private String address;
	
	@Enumerated(EnumType.STRING)
	private UserRole UserRole;
	private String email;
	private String job;
	private String picture;
	private long numtel;
	@OneToOne
	private Account account;	
	@ManyToMany
	private Set<Complaint>complaint;	
	@OneToMany(mappedBy="user")
	private Set<Product>product;
	@ManyToMany
	private Set<Agency>agency;
	public User() {
	
	}

	public User(String firstName, String lastName, String password, String address,
			tn.esprit.spring.entities.UserRole userRole, String email, String job, String picture, long numtel,
			Account account, Set<Complaint> complaint, Set<Product> product, Set<Agency> agency) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.address = address;
		UserRole = userRole;
		this.email = email;
		this.job = job;
		this.picture = picture;
		this.numtel = numtel;
		this.account = account;
		this.complaint = complaint;
		this.product = product;
		this.agency = agency;
	}

	

	public User(String firstName, String lastName, String password, String address,
			tn.esprit.spring.entities.UserRole userRole, String email, String job, String picture, long numtel
			) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.address = address;
		UserRole = userRole;
		this.email = email;
		this.job = job;
		this.picture = picture;
		this.numtel = numtel;
		
	}

	public long getIdUser() {
		return idUser;
	}

	public void setIdUser(long idUser) {
		this.idUser = idUser;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public UserRole getUserRole() {
		return UserRole;
	}

	public void setUserRole(UserRole userRole) {
		UserRole = userRole;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public long getNumtel() {
		return numtel;
	}

	public void setNumtel(long numtel) {
		this.numtel = numtel;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Set<Product> getProduct() {
		return product;
	}

	public void setProduct(Set<Product> product) {
		this.product = product;
	}

	public Set<Complaint> getComplaint() {
		return complaint;
	}

	public void setComplaint(Set<Complaint> complaint) {
		this.complaint = complaint;
	}

	public Set<Agency> getAgency() {
		return agency;
	}

	public void setAgency(Set<Agency> agency) {
		this.agency = agency;
	}
	
}