package com.Bankingsystem;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class AppTest{
	//
	 bankingDAO b1=new bankingDAO();
	 
	 //+ve test case for login
	 @Test
	 public void testLogin()throws Exception{
		 b1.dbconnection();
		 int exp=101;
		 int res=b1.login("Preethi", 2203);//actual value from login in db
		 assertEquals(exp,res);
	 }
	 
	
	 @Test
	 public void testLogin3()throws Exception{
	 b1.dbconnection();
	 int exp=101;
	 int res=b1.login("preethi", 2203);//actual value from login in db
     assertEquals(exp,res);
	 }
	
	 //-ve test case wrong pwd
	// @Test
	// public void testLogin4()throws Exception{
//	 b1.dbconnection();
//		 int exp=101;
//		 int res=b1.login("Preethi", 2201);//actual value from login in db
//	 assertEquals(exp,res);
//	 }
//	
	 //test case for deposit
	 @Test
	 public void testDeposit()throws Exception{
		 b1.dbconnection();
		 int exp=76055;
	 int res=b1.deposit(2000,102);//actual value from login in db
 	 assertEquals(exp,res);
 }
	 
	 
	 //+ve test case for withdraw
	 @Test
	 public void testwithdraw()throws Exception{
		 b1.dbconnection();
		 int exp=44000;
		 int res=b1.withdraw(950,4408,103);//actual value from login in db
		 assertEquals(exp,res);
	 }
	 
//	 //-ve test case for withdraw
//	 @Test
//	 public void testwithdraw2()throws Exception{
//		 b1.dbconnection();
//		 int exp=-1;
//		 int res=b1.withdraw(44001,4408,103);//actual value from login in db
//		 assertEquals(exp,res);
//	 }
	 
	 //test case for change pwd
	 @Test
	 public void testpwd()throws Exception{
		 b1.dbconnection();
		 int exp=1;
		 int res=b1.changepwd(7709,5508,104);//actual value from login in db
		 assertEquals(exp,res);
	 }
	
	 //test case for delete account
	 @Test
  public void testdelete()throws Exception{
		 b1.dbconnection();
		 int exp=1;
		 int resl=b1.deleteAccount(8809,105);//actual value from login in db
		 assertEquals(exp,resl);
	 }
	 //test case for registering 
	 @Test
	 public void testregister()throws Exception{
		 customer c1=new customer();
		
	 c1.cusid=105;
	 c1.cusname="Reshma";
		 c1.cuspin=8809;
		 c1.cusamount=56000;
		 int exp=1;
		 b1.dbconnection();
		 int res=b1.registercustomer(c1);
	 assertEquals(exp,res);
	 }
	
	
 }
 

 
