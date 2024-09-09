package com.evotingapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="login_info")
public class Login {
	
	
	private String name;
	@Id
	private Long mobileNumber;
	@Column(unique = true)
	private String email;
	private String password;
	private String role;
	private Boolean isvoted;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
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
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Boolean getIsvoted() {
		return isvoted;
	}
	public void setIsvoted(Boolean isvoted) {
		this.isvoted = isvoted;
	}
	public Login(String name, Long mobileNumber, String email, String password, String role, Boolean isvoted) {
		super();
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.password = password;
		this.role = role;
		this.isvoted = isvoted;
	}
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Login [name=" + name + ", mobileNumber=" + mobileNumber + ", email=" + email + ", password=" + password
				+ ", role=" + role + ", isvoted=" + isvoted + "]";
	}
	
	
	
}
