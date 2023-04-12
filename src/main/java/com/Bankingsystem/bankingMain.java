package com.Bankingsystem;
import java.util.*;

public class bankingMain {
	public static void main(String[] args)throws Exception{
		Scanner sc= new Scanner(System.in);
		bankingDAO dao= new bankingDAO();
		customer c1=new customer();
		System.out.println("\t\t\t**********Welcome to Java Banking***********");
		
		System.out.println("Press 1 for registration \n Press 2 for login");
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
			System.out.println("Account creation is successfull");
		}
		else {
			System.out.println("Somthing went wrong");
		}
	}
			case 2->{
				System.out.println("welcome to Login page");
				
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
				    }
				    
				}
			}
				
			}
			
		sc.close();
		
		
	}

}
