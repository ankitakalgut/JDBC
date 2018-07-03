package com.bridgelabz.transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*************************************************************************************************************
 * @author Ankita Kalgutkar
 *
 * 18-May-2018
 *
 *Purpose:Savepoint Creation.
 *************************************************************************************************************/
public class Savepoint 
{
	final static String JDBC_DRIVER="com.mysql.jdbc.Driver";
	final static String DB_URL="jdbc:mysql://localhost:3306/student?useSSL=false";
	final static String username="user01";
	final static String password="abc1234";
	static String sql="insert into employees values(67,49,'Amruta','Mhalsekar')";
	static String sql1="select * from login";
	
	public static void main(String args[]) throws ClassNotFoundException, SQLException
	{
		Connection con=null;
		Statement stmt=null;
		
		try 
		{
			Class.forName(JDBC_DRIVER);
			con=DriverManager.getConnection(DB_URL,username,password);
			stmt=con.createStatement();
			stmt.executeUpdate(sql);
			@SuppressWarnings("unused")
			java.sql.Savepoint point1=con.setSavepoint("spoint1");
			PreparedStatement stmt4=con.prepareStatement(sql1);
			ResultSet rs=stmt4.executeQuery(sql1);
			while(rs.next())
			{
				String username=rs.getString("username");
				String password=rs.getString("password");
				System.out.println("username:  "+username+"\t"+"password:  "+password);	
			}	
		}
	    catch (SQLException e) 
	    {
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
			if (con != null) 
			{
				try 
				{
					con.close();
				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
		}
    }		
}
	
	

