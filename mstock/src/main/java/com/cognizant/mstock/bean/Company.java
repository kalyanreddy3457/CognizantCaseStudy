package com.cognizant.mstock.bean;

public class Company {

	private int company_id;
	private String company_name;
	private String company_des;
	private int price_2019;
	private int price_2020;
	private int price_2021;
	public int getCompany_id() {
		return company_id;
	}
	public void setCompany_id(int company_id) {
		this.company_id = company_id;
	}
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	public String getCompany_des() {
		return company_des;
	}
	public void setCompany_des(String comapany_des) {
		this.company_des = comapany_des;
	}
	public int getPrice_2019() {
		return price_2019;
	}
	public void setPrice_2019(int price_2019) {
		this.price_2019 = price_2019;
	}
	public int getPrice_2020() {
		return price_2020;
	}
	public void setPrice_2020(int price_2020) {
		this.price_2020 = price_2020;
	}
	public int getPrice_2021() {
		return price_2021;
	}
	public void setPrice_2021(int price_2021) {
		this.price_2021 = price_2021;
	}
	@Override
	public String toString() {
		return "Company [company_id=" + company_id + ", company_name=" + company_name + ", comapany_des=" + company_des
				+ ", price_2019=" + price_2019 + ", price_2020=" + price_2020 + ", price_2021=" + price_2021 + "]";
	}
	
}
