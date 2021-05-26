package com.cognizant.mstock.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cognizant.mstock.bean.Company;
import com.cognizant.mstock.bean.UserLogin;
import com.cognizant.mstock.bean.Watchlist;
import com.cognizant.mstock.exception.UserException;

@Repository
public class UserDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<Company> displayCompany()
	{
		String sql="select * from company";
		return jdbcTemplate.query(sql,new CompanyRowMapper());
	}
	public boolean verifyLogin(UserLogin user)throws UserException
	{
		String sql="select email_id,password from userlogin where email_id=? and password=?";
		try
		{
			List<UserLogin> user1=jdbcTemplate.query(sql,new UserRowMapper(),user.getEmail_id(),user.getPassword());
			System.out.println(user1);
			if(user1.isEmpty())
			  throw new UserException("Invalid User Credentails");
			else
				return true;
		}
		catch(DataAccessException e)
		{
			throw new UserException("Required to fill Email_id or password");
		}
	}
	public boolean addCompany(Watchlist watchlist) throws UserException
	{
		try
		{
		String sql="insert into watchlist values(?,?)";
		System.out.println(watchlist.getEmail_id()+" "+watchlist.getCompany());
		return jdbcTemplate.update(sql,watchlist.getEmail_id(),watchlist.getCompany())>0;
		}
		catch(DataAccessException e)
		{
			throw new UserException("Company is already added"+e);
		}
		
	}
	public boolean deleteCompany(String email_id,String company_id)throws UserException
	{
      
		String sql="delete from watchlist where company_id=? and email_id=?";
		if(jdbcTemplate.update(sql,company_id,email_id)>0)
		return true;
		else
			throw new UserException("Company is already deleted"); 
	}
	public List<Company> displayWatchlist(String email_id)throws UserException
	{
		String sql="select * from company where company_id in (select company_id from watchlist where email_id=?)";
		try
		{
			return jdbcTemplate.query(sql,new CompanyRowMapper(),email_id);
		}
		catch(DataAccessException e)
		{
			throw new UserException("email_id is wrong "+e);
		}
	}
	public List<Company> performanceCheck(String company_name1,String company_name2)throws UserException
	{
		
			String sql="select * from company where company_name in (?,?)";
            List<Company> company=jdbcTemplate.query(sql,new CompanyRowMapper(),company_name1,company_name2);
            if(company.size()==1)
            {
            	throw new UserException("You have selected only one company");
            }
            else if(company.isEmpty())
            {
            	throw new UserException("You have not selected any company");
            }
            else
            	return company;

	}
}
