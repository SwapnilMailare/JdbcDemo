package com.swapnil.first;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class InsertData {

	public static void main(String[] args) {
		
		// calling the jdbc
		
		InsertData data= new InsertData();
		//data.insertData();
		data.insertDataByPreparedStatement("Pratik", "Chavan", "Rajarampuri", "Kholapur");

	}
	
	public void insertData()
	{
		try {
			
			/*************************** This  Create Statement
			 It is generally used for general–purpose access to databases and is useful while using static SQL statements at runtime.
			
			*/
		    	//Step 1: Load the class loader
		        Class.forName("com.mysql.cj.jdbc.Driver");
		        
		      // Step 2: Establish the connection
		       Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","swapnil","Swapnil@1994");
		        
		      //Step 3: Prepare the Statement
		         Statement  statement= connection.createStatement();
		        
		        // Step4: Prepare The Query
		        String sqlQuery="Insert into user(LastName,FirstName,Address,City) "+"values ('mailare','Swapnil','pune','10000')";
		        String sqlQuery2= "select * from user";
		        
		        
		        // Step 4: submit the query
		    //  boolean execute = statement.execute(sqlQuery);
		      //   System.out.println(execute);
		        
		       //  System.out.println("Data Added sucessfully");
		   ResultSet resultSet = statement.executeQuery(sqlQuery2);
		   while(resultSet.next())
		   {
			   
			   System.out.println("LastName : "+resultSet.getNString("LastName"));
			   System.out.println("FirstName : "+resultSet.getNString("FirstName"));
			   System.out.println("Address : "+resultSet.getNString("Address"));
			   System.out.println("City : "+resultSet.getNString("City"));
		   }
		        
		         connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void insertDataByPreparedStatement(String lname,String fname,String add,String city )
	{
		
		try {
			// 1. Load the class loander
		     Class.forName("com.mysql.cj.jdbc.Driver");
		     
		     // 2.Establish the connection
		       Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","swapnil","Swapnil@1994");
		      
		     // 3  Prepare the statement
		      
		      PreparedStatement prepareStatement = connection.prepareStatement("insert into user(LastName,FirstName,Address,City) values(?,?,?,?)");
		      prepareStatement.setString(1, lname);
		      prepareStatement.setString(2, fname);
		      prepareStatement.setString(3, add);
		      prepareStatement.setString(4, city);
		     // PreparedStatement prepareStatement2 = connection.prepareStatement("delete from user where LastName=?");
		    //  prepareStatement2.setString(1, "Pratik");
		      //int executeUpdate = prepareStatement.executeUpdate();
		     // int executeUpdate1 = prepareStatement2.executeUpdate();
		      //System.out.println("Inserted the data using prepare statement");
		     // System.out.println("deleted the data using prepare statement");
		     // System.out.println(executeUpdate1);
		      
		      // ****************** Fetch data fro db ***********//
		      
		      PreparedStatement prepareStatement3 = connection.prepareStatement("select * from user");
		      ResultSet executeQuery = prepareStatement3.executeQuery();
		      while(executeQuery.next())
		      {
		    	  System.out.println("LastName : "+executeQuery.getString("LastName"));
		      }
		      
		      
		      
		      
		  //    System.out.println(executeUpdate);
		      
		      connection.close();
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		
	}
}
