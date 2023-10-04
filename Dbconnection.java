package com.database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbconnection 
{
   
   public static Connection connect()
   {
	   Connection cn=null;
	   try { 
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Driver loaded");
		   cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/todolist","root","");
		   System.out.println("connection established");
	} catch (ClassNotFoundException | SQLException e) {
		e.printStackTrace();
	}
	  
	   return cn;
   }
   
}
