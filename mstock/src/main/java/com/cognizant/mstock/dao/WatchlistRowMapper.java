package com.cognizant.mstock.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cognizant.mstock.bean.Watchlist;

public class WatchlistRowMapper implements RowMapper<Watchlist>{
	
	public Watchlist mapRow(ResultSet rs,int rowNum) throws SQLException
	{
		Watchlist watchlist=new Watchlist();
		watchlist.setEmail_id(rs.getString(1));
		watchlist.setCompany(rs.getInt(2));
		return watchlist;
	}

}
