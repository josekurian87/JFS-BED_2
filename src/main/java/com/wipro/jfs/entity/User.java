package com.wipro.jfs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "USER", uniqueConstraints = { @UniqueConstraint(columnNames = "EMAIL") })
public class User {

	@Column(name = "FIRST_NAME", nullable = false, length = 40)
	private String firstName;

	@Column(name = "LAST_NAME", nullable = false, length = 40)
	private String lastName;
	
	@Id
	@Column(name = "EMAIL", unique = true, nullable = false, length = 40)
	private String email;
	
	@Column(name = "PASSWORD", nullable = false, length = 80)
	private String password;

	@Column(name = "TYPE", nullable = false, length = 1)
	private String type;
	
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public User(String firstName, String lastName, String email, String password, String type) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.type = type;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
