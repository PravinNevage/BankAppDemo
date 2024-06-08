package com.bankDemo.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

	
//    private String URL="jdbc:mysql://localhost:3306/bank";
//    private String USER="root";
//    private String PASSWORD= "root";


	
	static Connection con;
	
  public static Connection connection()
  {  
	try 
	{
	Class.forName("com.mysql.cj.jdbc.Driver");	
    String URL="jdbc:mysql://localhost:3306/bank";
    String USER="root";
    String PASSWORD= "root";
		
    con=DriverManager.getConnection(URL, USER, PASSWORD);
    
    if (con != null) 
    {
        System.out.println("conn1 connected to the database!");
    } else 
    {
        System.out.println("Failed to make connection!");
    }
    
    
	} catch (Exception e) 
	{
	e.printStackTrace();
	}
	  
	  return con;
  }
    
    
    
    
}
