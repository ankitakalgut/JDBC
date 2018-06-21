package com.bridgelabz.StatementTask;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class MultipleQueryUsingStatement 
{
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost:3306/student?useSSL=false";
    static final String USER = "user01";
    static final String PASS = "abc1234";
    static String sql = "CREATE TABLE BUILDINGS " +
            "(id INTEGER not NULL, " +
            " first VARCHAR(255), " + 
            " last VARCHAR(255), " + 
            " age INTEGER, " + 
            " PRIMARY KEY ( id ))"; 
	   
    static String sql2=  sql = "INSERT INTO employees VALUES (5,45,'Harsha','Patel')";

	static String sql3 = "update employees set first='Bharatha' where id=1";

	static String sql4 = "SELECT id, first, last, age FROM employees";
	   
	public static void main(String[] args) throws SQLException, ClassNotFoundException
	{
		 Connection conn = null;
		 Statement stmt = null;
		   //STEP 2: Register JDBC driver
	     Class.forName(JDBC_DRIVER );

	      //STEP 3: Open a connection
	     System.out.println("Connecting to a selected database...");
	     conn = DriverManager.getConnection(DB_URL, USER, PASS);
	     System.out.println("Connected database successfully...");
	      
	      //STEP 4: Execute a query
	      try 
	      {
			stmt = conn.createStatement();
	      } 
	      catch (SQLException e) 
	      {
			// TODO Auto-generated catch block
			e.printStackTrace();
	      }
	      
	      System.out.println("Enter 1 to create a table");
	      System.out.println("Enter 2 to insert values into table employees");
	      System.out.println("Enter 3 to update value in a table employees");
	      System.out.println("Enter 4 to view values from  a table employees");
	      System.out.println("Enter 5 to exit");
	      int choice;
	      do	  
	      {
	    	Scanner sc=new Scanner(System.in);
	    	System.out.println("Enter your choice");
	    	choice=sc.nextInt();
	    	switch(choice)
	    	{
		      	case 1:stmt.executeUpdate(sql);
		      		   break;
		      	
		      	case 2:stmt.executeUpdate(sql2);
		      		  break;
		      		  
		      	case 3:stmt.executeUpdate(sql3);
		      		  break;
		      		  
		      	case 4: ResultSet rs = stmt.executeQuery(sql4);
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
	     }

	     while(choice<6);
	      
	 }
}
	      
	     
	   
	  
	      
	     
	   
	   





	  
		  