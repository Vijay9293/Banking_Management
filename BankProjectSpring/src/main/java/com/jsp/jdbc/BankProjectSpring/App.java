 package com.jsp.jdbc.BankProjectSpring;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jsp.jdbc.Config.BankConfig;
import com.jsp.jdbc.Dao.BankDao;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       ApplicationContext context = new AnnotationConfigApplicationContext(BankConfig.class);
       BankDao bankDao =  context.getBean("bankdao",BankDao.class);
      // bankDao.debit("8309819413");
     
       
       Scanner sc = new Scanner(System.in);
       System.out.println("Enter 1 to withdraw or Debit the amount :-");
       System.out.println("Enter 2 to Credit the amount :-");
       System.out.println("Enter 3 to Check your balance :-");
       
       System.out.println("-----------------------------");
       System.out.print("Choose the Number :-");
       int value = sc.nextInt();
       switch (value) 
       {
	case 1:
		
		 System.out.print("Enter Mobile Number to Debit  :-");
		 String mobileNumber = sc.next();
		 bankDao.debit(mobileNumber);
		 
		break;
	case 2:
		
		 System.out.println("Enter MobileNumber to Credit :-");
		 String mobileNumber1 = sc.next();
		 bankDao.credit(mobileNumber1);
		 
		break;
		
	case 3:
		
		System.out.print("Enter MobileNumber to Check YourBalance :-");
		String mobileNumber2 = sc.next();
		bankDao.checkBalance(mobileNumber2);
		
		break;
	default:
		
		System.out.println("Invalid Number");
		break;
	}
       
    }
}
