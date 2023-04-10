package com.Bankingsystem;
import java.util.*;

public class bankingMain {
	public static void main(String[] args)throws Exception{
		Scanner sc= new Scanner(System.in);
		bankingDAO dao= new bankingDAO();
		customer c1=new customer();
		System.out.println("\t\t\t**********Welcome to Java Banking***********");
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
		sc.close();
		
		
	}

}
