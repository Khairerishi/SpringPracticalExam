package com.met.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Employeetbl")
public class Employee {

	@Id
	private int id;
	
	private String name;
	private String address;
	private String emailId;
	
	@Column(length = 10)
	private int mobile;
	
	
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	private String password;
	private String ConfirmPassword;
	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getConfirmPassword() {
		return ConfirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		ConfirmPassword = confirmPassword;
	}

	public int getId() {
		return id;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	public int getMobile() {
		return mobile;
	}
	public void setMobile(int mobile) {
		this.mobile = mobile;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", address=" + address + ", emailId=" + emailId + ", mobile="
				+ mobile + ", password=" + password + ", ConfirmPassword=" + ConfirmPassword + "]";
	}
	

}
