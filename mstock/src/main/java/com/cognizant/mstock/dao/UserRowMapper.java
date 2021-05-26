package com.cognizant.mstock.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cognizant.mstock.bean.UserLogin;

public class UserRowMapper implements RowMapper<UserLogin> {

	public UserLogin mapRow(ResultSet rs,int rowNum)throws SQLException
	{
		UserLogin user=new UserLogin();
		user.setEmail_id(rs.getString(1));
		user.setPassword(rs.getString(2));
		return user;
	}
}
