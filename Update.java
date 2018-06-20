package com.bridgelabz.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/****************************************************************************************
 * @author Ankita Kalgutkar
 *
 * 18-May-2018
 *
 *Purpose:Update the table.
 ******************************************************************************************/
public class Update 
{
	static final String JDBC_DRIVER="com.mysql.jdbc.Driver";
	static final String DB_URL="jdbc:mysql://localhost:3306/student?useSSL=false";
	static final String username="user01";
	static final String pass="abc1234";

	public static void main(String[] args)
	{
		String sql = "update employees set first='Aruna' where id=1";

		try (Connection conn = DriverManager.getConnection(DB_URL, username, pass); 
        Statement stmt = conn.createStatement();) 
		{
	      stmt.executeUpdate(sql);
	      System.out.println("Database updated successfully ");
		} 
	    catch (SQLException e) 
	    {
	      e.printStackTrace();
	    }
	}
}
