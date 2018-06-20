package com.bridgelabz.jdbc;

import java.sql.*;

/***************************************************************************************************
 * @author Ankita Kalgutkar
 *
 * 18-May-2018
 *
 *Purpose:Insert values in the database.
 *
 *************************************************************************************************/
public class Insert 
{
   //JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost:3306/student?useSSL=false";
   //Database credentials
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
	      System.out.println("Inserting records into the table...");
	      stmt = conn.createStatement();  
	      String sql = "INSERT INTO employees VALUES (4,45,'Afsha','Khan')";
	      stmt.executeUpdate(sql);
	      sql = "INSERT INTO employees VALUES (5,45,'Pooja','Naik')";
	      stmt.executeUpdate(sql);
	      sql = "INSERT INTO employees VALUES (6,33,'Nisha','Harikantra')";
	      stmt.executeUpdate(sql);
	      sql = "INSERT INTO employees VALUES (7,45,'Priyanka','Talejkar')";
	      stmt.executeUpdate(sql);
	      System.out.println("Inserted records into the table...");
	   }
	   catch(Exception se)
	   {
	      //Handle errors for JDBC
	      se.printStackTrace();
	   }  
   }
}
