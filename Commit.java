package com.bridgelabz.transaction;
import java.sql.*;

public class Commit 
{
	static final String jdbc_driver= "com.mysql.jdbc.Driver";  
	static final String dburl = "jdbc:mysql://localhost:3306/student?noAccessToProcedureBodies=true&useSSL=false"; 
	static final String user= "user01";
    static final String pass = "abc1234";
	    
	public static void main(String[] args)
	{
		 Connection con = null;
		 Statement stmt = null;	 
		 try 
		 {
		     //Step 1 : Connecting to server and database
		     con = DriverManager.getConnection(dburl, user, pass);
		     con.setAutoCommit(false);
		     //Step 2 : Initialize Statement
		     stmt=con.createStatement();
		     //Step 3 : SQL Query
		     String query1="INSERT INTO login(username,password) VALUES('Anushka','Pari@123')";
		     String query2="INSERT INTO login(username,password) VALUES('Priyanka','Quantico@1233')";
		     
		     stmt.executeUpdate(query1);
		     stmt.executeUpdate(query2);
		     //If you run this program without con.commit you will notice that there is no insert in table1 and table2
		     con.commit();
		     System.out.println("Row Inserted");		     
		 } 
		 
		 catch (SQLException e) 
		 {
		     System.err.println("Cannot connect ! ");
		     e.printStackTrace();
		 }
		 
		 finally 
		 {
			 if (stmt != null)
			 {
				try
				{
					stmt.close();
				} 
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			 }
		     System.out.println("Closing the connection.");
		     if (con != null) try 
		     {
		    	 con.close(); 
		     }
		     catch (SQLException ignore)
		     {
	    	 
		     }
		 }
	 }
}

