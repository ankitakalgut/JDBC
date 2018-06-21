package com.bridgelabz.StatementTask;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.swing.text.html.CSS;

public class CallableStatement 
{   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver"; 
	static final String DB_URL = "jdbc:mysql://localhost:3306/student?noAccessToProcedureBodies=true&useSSL=false";
	static final String USER = "user01";
	static final String PASS = "abc1234";
		Connection connection = null;

	public CallableStatement() 
	{
		try 
		{
			// Loading the driver
			Class.forName("com.mysql.jdbc.Driver");
		} 
		catch (Exception e)
		{
			System.out.println(e.toString());
		}
	}

	// Creating a function to get a connection
	public Connection createConnection() 
	{
		Connection con = null;
		// checking connection
		if (connection != null) 
		{
			System.out.println("Can't creaate a connection");
			return connection;
		} 
		else 
		{
			try 
			{
				// Getting connection
			   con = DriverManager.getConnection(DB_URL,USER,PASS);
			} 
			catch (Exception e) 
			{
				System.out.println(e.toString());
			}
		}
		return con;
	}

	public static void main(String[] args) 
	{
		CallableStatement calllableStatement = new CallableStatement();
		Connection connection = calllableStatement.createConnection();
		try 
		{
			// Creating Callable Statement
			//String query = "getusername()";
			java.sql.CallableStatement cs = connection.prepareCall("call getusername()");
			ResultSet rs = cs.executeQuery();
			while(rs.next())
			{
				System.out.println(rs.getString(1)+"\t"+rs.getString(2));
			}
		} 
		catch (Exception e) 
		{
			System.out.println(e.toString());
		}
	}
}
