package com.cognizant.mstock.bean;

public class UserLogin {

	private String email_id;
	private String password;
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [email_id=" + email_id + ", password=" + password + "]";
	}
	
}
