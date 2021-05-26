package com.cognizant.mstock.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cognizant.mstock.bean.Company;

public class CompanyRowMapper implements RowMapper<Company>{

	public Company mapRow(ResultSet rs,int rowNum) throws SQLException
	{
		Company company=new Company();
		company.setCompany_id(rs.getInt(1));
		company.setCompany_name(rs.getString(2));
		company.setCompany_des(rs.getString(3));
		company.setPrice_2019(rs.getInt(4));
		company.setPrice_2020(rs.getInt(5));
		company.setPrice_2021(rs.getInt(6));
		return company;
	}
}
