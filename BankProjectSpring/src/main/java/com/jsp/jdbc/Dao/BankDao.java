package com.jsp.jdbc.Dao;

public interface BankDao
{
	public void debit(String mobileNumber);
	public void credit(String mobileNumber);
	public void checkBalance(String mobileNumber);
}
