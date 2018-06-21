package com.bridgelabz.StatementTask;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class BatchWithPreparedStatement 
{
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost:3306/student?useSSL=false";
	static final String USER = "user01";
	static final String PASS = "abc1234";
	public static void main(String args[]) throws SQLException
	{
		String SQL = "INSERT INTO employees (id,age, first, last ) " +
        "VALUES(?, ?, ?, ?)";
		Connection conn=null;
		conn = DriverManager.getConnection( "jdbc:mysql://localhost:3306/student?noAccessToProcedureBodies=true&useSSL=false",USER,PASS);
		//Create PrepareStatement object
		PreparedStatement pstmt = conn.prepareStatement(SQL);

		//Set auto-commit to false
		conn.setAutoCommit(false);

		// Set the variables
		pstmt.setInt( 1, 400 );
		pstmt.setInt( 2, 33 );
		pstmt.setString( 3, "Singh" );
		pstmt.setString( 4, "Pappu" );
	
		// Add it to the batch
		pstmt.addBatch();

		// Set the variables
		pstmt.setInt( 1, 401 );
		pstmt.setInt( 2, 31 );
		pstmt.setString( 3, "Singh" );
		pstmt.setString( 4, "Pawan" );
		// Add it to the batch
		pstmt.addBatch();

		
		//Create an int[] to hold returned values
		int[] count = pstmt.executeBatch();

		//Explicitly commit statements to apply changes
		conn.commit();
	}
}

