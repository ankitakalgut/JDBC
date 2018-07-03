package com.bridgelabz.transaction;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

/***************************************************************************************
 * @author Ankita Kalgutkar
 *
 * 18-May-2018
 *
 *Purpose:transaction RollBack and AutoCommit
 ****************************************************************************************/
public class RollBackAutoCommit
{
	 static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	 static final String dburl = "jdbc:mysql://localhost:3306/student?noAccessToProcedureBodies=true&useSSL=false"; 
	 static final String USER= "user01";
	 static final String PASS = "abc1234";		
	 public static void main(String[] args) 
	 {	  
		Connection connection = null;
		try 
		{
			// Load the Oracle JDBC driver
			Class.forName( JDBC_DRIVER );
			// Create a connection to the database
			connection = DriverManager.getConnection(dburl,USER, PASS);
			System.out.println("Successfully Connected to the database!");
	    }
		
		catch (ClassNotFoundException e) 
		{
			System.out.println("Could not find the database driver " + e.getMessage());

	    } 
		
		catch (SQLException e) 
		{
			System.out.println("Could not connect to the database " + e.getMessage());
	    }
		
	    try 
	    {
	    	// Disable auto commit
	    	connection.setAutoCommit(false);
	    	// Do SQL updates...
	    	// Commit updates
	    	connection.commit();
	    	System.out.println("Successfully commited changes to the database!");

	    } 
	    catch (SQLException e) 
	    {
	     try 
	     {
	    	 // Rollback update
	    	 connection.rollback();
	    	 System.out.println("Successfully rolled back changes from the database!");

	     } 
	     catch (SQLException e1) 
	     {
	    	 System.out.println("Could not rollback updates " + e1.getMessage());
	     }
	     finally 
			{
				if (connection != null) 
				{
					try 
					{
						connection.close();
					} 
					catch (SQLException e2) 
					{
						e.printStackTrace();
					}
				}
			}
	    }
    }
}

