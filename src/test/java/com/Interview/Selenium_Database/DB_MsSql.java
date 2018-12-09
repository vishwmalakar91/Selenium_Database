package com.Interview.Selenium_Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.testng.annotations.Test;

public class DB_MsSql 
{ 
	@Test
public static void DB_Test() throws Exception {
	// Object of Connection from the Database
	Connection conn = null; 	// Object of Statement. It is used to create a Statement to execute the query
	Statement stmt = null;	//Object of ResultSet => 'It maintains a cursor that points to the current row in the result set'
	ResultSet resultSet = null;
	
	Class.forName("com.mysql.jdbc.Driver");
	
	// Open a connection
	//	create table orders(customer_id int,order_id int,date date,primary key(customer_id));
	//	insert into orders values(100,121018,12/10/2018);
	//	select * from orders;
	conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ms", "root", "admin123");
	
	// Execute a query
	stmt = conn.createStatement();
	resultSet = stmt.executeQuery("select * from orders");
	while (resultSet .next()) {
		System.out.println(resultSet .getString(1) + "  " + resultSet.getString(2) + "  " + resultSet.getString(3));
	}
	
	if (resultSet != null) {
		try {
			resultSet.close();
		} catch (Exception e) {
		}
	}
	
	if (stmt != null) {
		try {
			stmt.close();
		} catch (Exception e) {
		}
	}
	
	if (conn != null) {
		try {
			conn.close();
		} catch (Exception e) {
		}
	}
}
}