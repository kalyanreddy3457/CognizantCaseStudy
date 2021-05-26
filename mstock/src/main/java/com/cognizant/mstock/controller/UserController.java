package com.cognizant.mstock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.mstock.bean.Company;
import com.cognizant.mstock.bean.UserLogin;
import com.cognizant.mstock.bean.Watchlist;
import com.cognizant.mstock.exception.UserException;
import com.cognizant.mstock.service.UserService;

@CrossOrigin
@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/displayCompany",method=RequestMethod.GET)
	public ResponseEntity<List<Company>> displayCompany()
	{
		return new ResponseEntity<List<Company>>(userService.displayCompany(),HttpStatus.OK);
	}
    @RequestMapping(value="/login",method=RequestMethod.POST)
    public ResponseEntity<String> verifyLogin(@RequestBody UserLogin user)throws UserException
    {
    	if(userService.verifyLogin(user))
    	{
    	return new ResponseEntity<String>("User is Valid",HttpStatus.OK);
    	}
    	else
    	{
    		return new ResponseEntity<String>("InValid User",HttpStatus.NOT_FOUND);
    	}
    }
    @RequestMapping(value="/addCompany",method=RequestMethod.POST)
    public ResponseEntity<String> addCompany(@RequestBody Watchlist watchlist)throws UserException
    {
    	if(userService.addCompany(watchlist))
    	{
    		return new ResponseEntity<String>("company is added",HttpStatus.OK);
    	}
    	else
    	{
    		return new ResponseEntity<String>("company is not added",HttpStatus.NOT_FOUND);
    	}
    }
    @RequestMapping(value="/deleteCompany/{email_id}/{company_id}",method=RequestMethod.DELETE)
    public ResponseEntity<String> deleteCompany(@PathVariable String email_id,@PathVariable String company_id)throws UserException
    {
    	if(userService.deleteCompany(email_id,company_id))
    	{
    		return new ResponseEntity<String>("company is deleted",HttpStatus.OK);
    	}
    	else
    	{
    		return new ResponseEntity<String>("company is not deleted",HttpStatus.NOT_FOUND);
    	}
    }
    @RequestMapping(value="/displayWatchlist/{email_id}",method=RequestMethod.GET)
    public ResponseEntity<List<Company>> displayWatchlist(@PathVariable String email_id)throws UserException
    {
    	System.out.println(email_id);
    	return new ResponseEntity<List<Company>>(userService.displayWatchlist(email_id),HttpStatus.OK);
    }
    @RequestMapping(value="/performanceCheck/{name1}/{name2}",method=RequestMethod.GET)
    public ResponseEntity<List<Company>> performanceCheck(@PathVariable String name1,@PathVariable String name2)throws UserException
    {
    	System.out.println(name1+" "+name2);
    	return new ResponseEntity<List<Company>>(userService.performanceCheck(name1,name2),HttpStatus.OK);
    }
    @ExceptionHandler(UserException.class)
	public ResponseEntity<Object> Exception(Exception ex)
	{
		System.out.println(ex);
		return new ResponseEntity<Object>(ex.getMessage(),HttpStatus.NOT_FOUND);
	}
}
