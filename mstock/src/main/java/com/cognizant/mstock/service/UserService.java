package com.cognizant.mstock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.mstock.bean.Company;
import com.cognizant.mstock.bean.UserLogin;
import com.cognizant.mstock.bean.Watchlist;
import com.cognizant.mstock.dao.UserDAO;
import com.cognizant.mstock.exception.UserException;

@Service
public class UserService {

	@Autowired
	UserDAO userDAO;
	
	public List<Company> displayCompany()
	{
		return userDAO.displayCompany();
	}
	public boolean verifyLogin(UserLogin user)throws UserException
	{
		return userDAO.verifyLogin(user);
	}
	public boolean addCompany(Watchlist watchlist)throws UserException
	{
		return userDAO.addCompany(watchlist);
	}
	public boolean deleteCompany(String email_id,String company_id)throws UserException
	{
		return userDAO.deleteCompany(email_id,company_id);
	}
	public List<Company> displayWatchlist(String email_id)throws UserException
	{
		return userDAO.displayWatchlist(email_id);
	}
	public List<Company> performanceCheck(String name1,String name2)throws UserException
	{
		return userDAO.performanceCheck(name1,name2);
	}
}
