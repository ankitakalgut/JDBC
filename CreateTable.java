package com.bridgelabz.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/***********************************************************************************************
 * @author Ankita Kalgutkar
 *
 * 19-Jun-2018
 * 
 * Purpose:CreateTable Query execution.
********************************************************************************************* */
public class CreateTable
{
	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost:3306/student?useSSL=false";
	   static final String USER = "user01";
	   static final String PASS = "abc1234";
	
	   public static void main(String[] args)
	   {
		   Connection conn = null;
		   Statement stmt = null;
	   try
	   { 
		   //STEP 2: Register JDBC driver
	      Class.forName(JDBC_DRIVER );

	      //STEP 3: Open a connection
	      System.out.println("Connecting to a selected database...");
	      conn = DriverManager.getConnection(DB_URL, USER, PASS);
	      System.out.println("Connected database successfully...");
	      
	      //STEP 4: Execute a query
	      System.out.println("Creating table in given database...");
	      stmt = conn.createStatement();
	      
	      String sql = "CREATE TABLE ANIMAL " +
	                   "(id INTEGER not NULL, " +
	                   " first VARCHAR(255), " + 
	                   " last VARCHAR(255), " + 
	                   " age INTEGER, " + 
	                   " PRIMARY KEY ( id ))"; 

	      	stmt.executeUpdate(sql);
	        stmt.close();
	        conn.close();
	    }
	    catch(Exception se)
	    {
	         //Handle errors for JDBC
	         se.printStackTrace();
	    }
	}
}