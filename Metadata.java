package com.bridgelabz.jdbc;

import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.Statement;

/*******************************************************************************
 * @author Ankita Kalgutkar
 *
 * 18-May-2018
 *
 *Purpose:Meatdata describes the data.
 *********************************************************************************/
class Metadata
{   
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost:3306/student?useSSL=false";
	static final String USER = "user01";
	static final String PASS = "abc1234";

	public static void main(String args[])
	{  
		java.sql.Connection con=null;
		Statement s=null;
		try
		{  
			Class.forName("com.mysql.jdbc.Driver");   
		    con= DriverManager.getConnection(DB_URL, USER, PASS);
			DatabaseMetaData dbmd=con.getMetaData();  
			System.out.println("Driver Name: "+dbmd.getDriverName());  
			System.out.println("Driver Version: "+dbmd.getDriverVersion());  
			System.out.println("UserName: "+dbmd.getUserName());  
			System.out.println("Database Product Name: "+dbmd.getDatabaseProductName());  
			System.out.println("Database Product Version: "+dbmd.getDatabaseProductVersion());   
			con.close();  
		}
		catch(Exception e)
		{ 
			System.out.println(e);
		}  
	}  
} 