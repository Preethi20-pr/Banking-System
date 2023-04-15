package com.Bankingsystem;
import java.util.*;

public class bankingMain {
	public static void main(String[] args)throws Exception{
		Scanner sc= new Scanner(System.in);
		bankingDAO dao= new bankingDAO();
		customer c1=new customer();
		System.out.println("\t\t\t**********Welcome to JDBC Banking***********");
		
		System.out.println("Press 1 for Registration \n Press 2 for Login");
		int op=sc.nextInt();
		switch(op){
		
			case 1->{
		System.out.println("Enter customer ID");
		int cid=sc.nextInt();
		System.out.println("Enter customer Name");
		sc.nextLine();
		String cname=sc.nextLine();
		System.out.println("Enter customer Pin");
		int cpin=sc.nextInt();
		System.out.println("Enter customer Account Balance");
		int cbal=sc.nextInt();
		 
		c1.cusid=cid;
		c1.cusname=cname;
		c1.cuspin=cpin;
		c1.cusamount=cbal;
		
		//getting connection to db
		dao.dbconnection();
		int res=dao.registercustomer(c1);
		
		//if register is success response=1 otherwise 0
		if(res==1)
		{
			System.out.println("Account creation is successfull\n Thank You for Registering!");
		}
		else {
			System.out.println("Somthing went wrong");
		}
	}
			case 2->{
				System.out.println("*******welcome to Login page********");
				
				//reading username and password for login
				System.out.println("Enter Username");
				sc.nextLine();
				String uname=sc.nextLine();
				System.out.println("Enter password");
				int pwd=sc.nextInt();
				
				//connection to db
				dao.dbconnection();
				
				//login method
				int res=dao.login(uname, pwd);
				
				//handling the response
				if(res==0) {
					System.out.println("Username or Password is Invalid");
				}
				else if(res==-1) {
					System.out.println("Unable to find details");
				}
				else {
					System.out.println("Login Successfull");
					System.out.println("Press 1 for deposit\n Press 2 for withdraw\n Press 3 for change password\n Press 4 for account delete");
				    int ops=sc.nextInt();
				    
				    switch(ops) {
				    
				    case 1->{
				    	System.out.println("Enter amount for deposit");
				    	int amount=sc.nextInt();
				    	int bal=dao.deposit(amount,res);
				    	System.out.println("Deposit Successfull\n Available amount is:"+bal);	
				    
				    }
				   
				    case 2->{
						System.out.println("Enter amount to Withdraw");
						int amount=sc.nextInt();
						System.out.println("Confirm your Password");
						int confmpwd=sc.nextInt();
						int availamount=dao.withdraw(amount, confmpwd,res);
						
						if(availamount==-1) {
							System.out.println("Low Balance");
						}
						else if(availamount==0) {
							System.out.println("Incorrect password");
						}
						else {
							System.out.println("Withdraw Successful \n Available Amount is :"+availamount);
						}
				}
				
				    case 3->{
					
						System.out.println("Enter current password");
						int currentpwd=sc.nextInt();
						System.out.println("Enter new password");
						int newpwd=sc.nextInt();
						
						int status=dao.changepwd(currentpwd, newpwd, res);
						if(status==1) {
							System.out.println(" Your Password is Changed...");
						}
						else {
							System.out.println("Something went wrong");
						}
						
				}
				
				    case 4->{
				    	
						System.out.println("Enter Password to delete");
						int pass=sc.nextInt();
						int status=dao.deleteAccount(pass, res);
						if(status==1) {
							System.out.println("Your account is deleted\n Good Bye!....");
						}
						else {
							System.out.println("Something went wrong");
						}
						
						
						
						
						
				}
				
				    }
				    
				}
			}
				
			}
			
		sc.close();
		
		
	}

}
