package com.to_do.user.model;

import java.sql.Timestamp;

public class UserVO {
	private String id;
	private String pw;
	private String name;
	private String phoneNumber;
	private Timestamp birthdate;
	private String email;
	
	public UserVO() {
		
	}

	public UserVO(String id, String pw, String name, String phoneNumber, Timestamp birthdate, String email) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.birthdate = birthdate;
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Timestamp getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Timestamp birthdate) {
		this.birthdate = birthdate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	
	

}
