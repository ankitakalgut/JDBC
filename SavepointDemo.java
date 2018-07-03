package com.bridgelabz.transaction;

import java.sql.Connection;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.Savepoint;
class SavepointDemo
{	
	static final String jdbc_driver = "com.mysql.jdbc.Driver";  
	static final String dburl = "jdbc:mysql://localhost:3306/student?noAccessToProcedureBodies=true&useSSL=false"; 
	static final String user= "user01";
	static final String pass = "abc1234";
	public static void main(String[] args) throws Exception
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection(dburl,user,pass);
		Statement stmt=con.createStatement();
		//disable auto commit
		con.setAutoCommit(false);
		DatabaseMetaData dbmd=con.getMetaData();
		if(dbmd.supportsSavepoints())
		{
			//savepoint is supported
		try
		{
			int i1=stmt.executeUpdate("insert into login values ('ardya','56rthyr')");
			Savepoint point1=con.setSavepoint("spoint1");
			try
			{
				int i2=stmt.executeUpdate("delete from login where username='priyanka'");
			}
			catch (Exception e1)
			{
				try
				{
					 con.rollback(point1);
				}
				catch (Exception ee)
				{
					ee.printStackTrace();
				}
			}
			con.commit();
			System.out.println("this driver is supported successfully");
			}
			//end of outer try
			catch ( Exception e2)
			{
				try
				{
					con.rollback();
				}
				catch ( Exception e3)
				{
					e3.printStackTrace();
				}
			}//end of catch
		 }//end of if
		
		else
		{
			System.out.println("this driver dosen't support savepoints");
		}//end of else	
	}
}