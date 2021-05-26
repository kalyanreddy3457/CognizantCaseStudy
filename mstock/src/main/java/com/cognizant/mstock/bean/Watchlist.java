package com.cognizant.mstock.bean;

public class Watchlist {

	private String email_id;
	private int company;
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public int getCompany() {
		return company;
	}
	public void setCompany(int company) {
		this.company = company;
	}
	@Override
	public String toString() {
		return "Watchlist [email_id=" + email_id + ", company=" + company + "]";
	}
	
}
