package com.bridgelabz.StatementTask;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchWithStatement 
{  
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost:3306/student?useSSL=false";
	static final String USER = "user01";
	static final String PASS = "abc1234";
	public static void main(String[] args) throws SQLException
	{
		Connection conn=DriverManager.getConnection(DB_URL,USER,PASS);
	
		Statement stmt = conn.createStatement();

		conn.setAutoCommit(false);

		String SQL = "INSERT INTO login values('radha','radha@123')";
		String SQL1 = "INSERT INTO login values('Amisha','Amisha@12345')";        
	
		stmt.addBatch(SQL);
		stmt.addBatch(SQL1);

		int[] count = stmt.executeBatch();
	
		conn.commit();
	}
}
