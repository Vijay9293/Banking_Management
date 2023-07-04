package com.jsp.jdbc.Config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@ComponentScan(basePackages = "com.jsp.jdbc")
@Configuration
public class BankConfig 
{
	@Bean
	public JdbcTemplate getJdbcTempleteObject()
	{
		JdbcTemplate jdbcTemplate = new JdbcTemplate(getUrl());
		return jdbcTemplate;
	}
	
	public DataSource getUrl()
	{
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/bank?");
		dataSource.setUsername("root");
		dataSource.setPassword("12345");
		return dataSource;
	}
}
