package com.bridgelabz.StatementTask;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;

public class PreparedStatement 
{
	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost:3306/student?useSSL=false";
	   static final String USER = "user01";
	   static final String PASS = "abc1234";
	  
	   static String sql1 = "CREATE TABLE PARK " +"(id INTEGER not NULL, " + " first VARCHAR(255), " + 
			   				" last VARCHAR(255), " + " age INTEGER, " + " PRIMARY KEY ( id ))"; 
	   static String sql2= "INSERT INTO employees VALUES (5,47,'Harsh','Patel')";
	   static String sql3 = "update employees set first='Bharathi' where id=1";
	   static String sql4 = "SELECT id, first, last, age FROM employees";
	   
	   public static void main(String[] args)
	   {
		   Connection conn = null;
		   try
		   { 
			  //STEP 2: Register JDBC driver
		      Class.forName(JDBC_DRIVER );
	
		      //STEP 3: Open a connection
		      System.out.println("Connecting to a selected database...");
		      conn = DriverManager.getConnection(DB_URL, USER, PASS);
		      System.out.println("Connected database successfully...");
			     
		      //STEP 4: Execute a query 
		      System.out.println("Enter 1 to create a table");
		      System.out.println("Enter 2 to insert values into table employees");
		      System.out.println("Enter 3 to update value in a table employees");
		      System.out.println("Enter 4 to view values from  a table employees");
		      System.out.println("Enter 5 to exit");
		      Scanner sc=new Scanner(System.in);
		      System.out.println("Enter your choice");
		      int choice=sc.nextInt();
		      
		      switch(choice)
		      {
		      	case 1:java.sql.PreparedStatement stmt=conn.prepareStatement(sql1);  
		      		  stmt.executeUpdate(sql1);
	
		      		   break;
		      	
		      	case 2: java.sql.PreparedStatement stmt1=conn.prepareStatement(sql2);  
	    		  		stmt1.executeUpdate(sql2);
		      		
		      		  break;
	      		  
		      	case 3: java.sql.PreparedStatement stmt2=conn.prepareStatement(sql3);  
	    		  		stmt2.executeUpdate(sql3);
		      		  break;
		      		  
		      	case 4:java.sql.PreparedStatement stmt4=conn.prepareStatement(sql4);  
		      			ResultSet rs=stmt4.executeQuery();  
		      			while(rs.next())
		      			{
				        //Retrieve by column name
				         int id  = rs.getInt("id");
				         int age = rs.getInt("age");
				         String first = rs.getString("first");
				         String last = rs.getString("last");
				         //Display values
				         System.out.print("ID: " + id);
				         System.out.print(", Age: " + age);
				         System.out.print(", First: " + first);
				         System.out.println(", Last: " + last);
	      			}
		      			break;
		      	case 5:System.exit(0);
		      		
		      	default:  System.out.println("You have entered an invalid choice");  			         
		      }
		     
		      conn.close();
		   }
		   catch(Exception se)
		   {
		       //Handle errors for JDBC
		       se.printStackTrace();
		   }
	  }
}


