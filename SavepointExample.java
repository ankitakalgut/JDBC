package com.bridgelabz.transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Savepoint;

/*****************************************************************************************
 * @author Ankita Kalgutkar
 *
 * 18-May-2018
 *
 *Purpose:Savepoint Creation
 *******************************************************************************************/
public class SavepointExample 
{
	 public static void main(String[] args) throws Exception 
	 { 
		 Statement stmt=null;
		 Connection con=null;
		 try 
		 { 
			 Class.forName("com.mysql.jdbc.Driver");
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student?useSSL=false","user01","abc1234");
			 stmt = con.createStatement();
			 String query1 = "insert into login values('Ashfara','Shaikh')";
			 String query2 = "select * from login";
			 
			 con.setAutoCommit(false);
			 Savepoint spt1 = con.setSavepoint("svpt1");
			 //Execute Query1
			 stmt.execute(query1);
			 
			 //Execute Query2
			 ResultSet rs = stmt.executeQuery(query2);
			 int no_of_rows = 0;
			 while (rs.next())
			 {
			     no_of_rows++;
			 }
			 System.out.println("rows before rollback statement = " + no_of_rows);
			 con.commit();
			 con.rollback(spt1);
			 no_of_rows = 0;
			 rs = stmt.executeQuery(query2); 
			 while (rs.next())
			 {
			      no_of_rows++;
			 }
			 System.out.println("rows after rollback statement = " + no_of_rows);
		 }
		 catch(Exception e)
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

