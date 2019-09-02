package com.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBTest {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost:3306/testDB";
	
	static final String USER = "ecogle";
	static final String PASS = "F22R@ptor";
	
	public static void main (String[] args) throws SQLException {
	
		try(Connection conn = DriverManager.getConnection(DB_URL,USER,PASS)){
			//Class .forName("com.mysql.jdbc.Driver");
			
			Statement stmt = conn.createStatement();
			String sel = "SELECT id, first_name,last_name,age FROM Person";
			
			try(ResultSet rs = stmt.executeQuery(sel)){
				while(rs.next()) {
					System.out.println(rs.getString("id") + " " + rs.getString("first_name"));
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
