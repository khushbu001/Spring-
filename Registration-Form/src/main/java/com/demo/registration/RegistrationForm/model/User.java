package com.demo.registration.RegistrationForm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

/**
 * 
 * @author khushii "model class for data manipulation"
 *
 */

@Entity
@Table(name = "Users_Data")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;

	@Size(max = 50)
	@Column(name = "firstname")
	@NotNull
	private String firstName;

	@Size(max = 50)
	@Column(name = "lastname")
	@NotNull
	private String lastName;

	@Size(max = 50)
	@Column(name = "email")
	@NotNull
	@Email
	private String email;

	@Size(max = 50)
	@Column(name = "password")
	@NotNull
	private String password;

	@Column(name = "contact", unique = true)
	@Size(min = 10, max = 13)
	@NotNull
	private String contact;

	@Column(name = "amount")
	@Range(min = 1, max = 100000)
	@NotNull
	private Double amount;
	
	public User() {
		
	}


	public User(Integer userId, String firstName, String lastName, 
			String email, String password, String contact, Double amount) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.contact = contact;
		this.amount = amount;
		
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer id) {
		this.userId = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstname) {
		firstName = firstname;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", contact=" + contact + "]";
	}
}