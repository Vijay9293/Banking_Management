package com.jsp.jdbc.Dao;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.jsp.jdbc.userDetails.UserDetails;

@Component("bankdao")
public class BankDaoImplementation implements BankDao
{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	Scanner sc = new Scanner(System.in);
	
	//To Withdraw or To Debit the Amount
	public void debit(String mobileNumber) 
	{
		String debit = "select * from bank where mobileNumber=? ";
	    RowMapper<UserDetails> rowMapper = new RowMapperImple();
	    UserDetails details =	jdbcTemplate.queryForObject(debit, rowMapper, mobileNumber);
	    if(details!=null)
	    {
	    	Random rm = new Random();
	    	int otp = rm.nextInt(10000);
	    	if(otp<1000)
	    	{
	    		otp+=1000;
	    	}
	    	System.out.print("Generated otp :- "+otp);
	    	System.out.println();
	    	System.out.print("Please enter otp :-");
	    	
	    	int uOtp = sc.nextInt();
	    	if(otp==uOtp)
	    	{
	    		System.out.print("Enter the amount :-");
	    		double uAmount = sc.nextDouble();
	    		
	    		double dAmount = details.getAmount();
	    		if(uAmount>0 && uAmount<=dAmount)
	    		{
	    			double balance = dAmount-uAmount;
	    			String update = "update bank  set amount=? where mobileNumber=?";
	    			int num =jdbcTemplate.update(update, balance,mobileNumber);
	    			if(num!=0)
	    			{
	    				System.out.println("Amount Updated...");
	    			}
	    			else
	    			{
	    				System.err.println("Amount not Updated");
	    			}
	    		}
	    		else
	    		{
	    			System.err.println("Invalid Amount");
	    		}
	    	}
	    	else
	    	{
	    		System.err.println("Invalid OTP....!");
	    	}
	    }
	    else
	    {
	    	System.err.println("Invalid MobileNumber");
	    }
	   
	}
	
    //To Credit The Amount into Account
	public void credit(String mobileNumber)
	{
		
		String credit = "select * from bank where mobileNumber=? ";
	    RowMapper<UserDetails> rowMapper = new RowMapperImple();
	    UserDetails details =	jdbcTemplate.queryForObject(credit, rowMapper, mobileNumber);
	    if(details!=null)
	    {
	    	boolean status = true;
	    	while(status)
	    	{
	    	Random rm = new Random();
	    	int otp = rm.nextInt(10000);
	    	if(otp<1000)
	    	{
	    		otp+=1000;
	    	}
	    	System.out.print("Generated otp :- "+otp);
	    	System.out.println();
	    	System.out.print("Please enter otp :-");
	    	Scanner sc = new Scanner(System.in);
	    	int uOtp = sc.nextInt();
	    	if(otp==uOtp)
	    	{
	    		status=false;
	    		System.out.print("Enter the amount :-");
	    		double cAmount = sc.nextDouble();
	    		
	    		double dAmount = details.getAmount();
	    		if(cAmount>0 )
	    		{
	    			double balance = dAmount+cAmount;
	    			String update = "update bank  set amount=? where mobileNumber=?";
	    			int num =jdbcTemplate.update(update, balance,mobileNumber);
	    			if(num!=0)
	    			{
	    				System.out.println("Amount Credited...");
	    			}
	    			else
	    			{
	    				System.err.println("Amount not Credited");
	    			}
	    		}
	    		else
	    		{
	    			System.err.println("Invalid Amount");
	    		}
	    	}
	    	else
	    	{
	    		System.err.println("Invalid OTP....!");
	    	}
	    	
	      }
	    }
	    
	    
	}
	
    //To check balance 
	public void checkBalance(String mobileNumber)
	{
		String credit = "select * from bank where mobileNumber=? ";
	    RowMapper<UserDetails> rowMapper = new RowMapperImple();
	    UserDetails details =	jdbcTemplate.queryForObject(credit, rowMapper, mobileNumber);
	    if(details!=null)
	    {
	    	boolean status = true;
	    	while(status)
	    	{
		    	Random rm = new Random();
		    	int otp = rm.nextInt(10000);
		    	if(otp<1000)
		    	{
		    		otp+=1000;
		    	}
		    	System.out.print("Generated otp :- "+otp);
		    	System.out.println();
		    	System.out.print("Please enter otp :-");
		    	Scanner sc = new Scanner(System.in);
		    	int uOtp = sc.nextInt();
		    	if(otp==uOtp)
		    	{
		    		System.out.println(details.getAmount());
		    	}
		    	else
		    	{
		    		System.err.println("Enter Valid OTP..!");
		    	}
	        }
	    
	    }
	    else
	    {
	    	System.err.println("Enter Valid Mobile Number");
	    }
		
	}
	
	
}
