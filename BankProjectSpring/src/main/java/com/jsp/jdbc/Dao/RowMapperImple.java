package com.jsp.jdbc.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.jsp.jdbc.userDetails.UserDetails;

public class RowMapperImple implements RowMapper<UserDetails>
{

	public UserDetails mapRow(ResultSet rs, int rowNum) throws SQLException 
	{
		UserDetails details = new UserDetails();
		details.setId(rs.getInt(1));
		details.setName(rs.getString(2));
		details.setAccountNumber(rs.getString(3));
		details.setMobileNum(rs.getString(4));
		details.setPin(rs.getInt(5));
		details.setAmount(rs.getDouble(6));
		return details;
	}

}
