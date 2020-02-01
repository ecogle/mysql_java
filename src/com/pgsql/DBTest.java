package com.pgsql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBTest {
	//static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	//static final String JDBC_DRIVER = "org.postgresql.Driver";  
	static final String DB_URL = "jdbc:postgresql://localhost:5432/TestDB";
	
	static final String USER = "ecogle";
	static final String PASS = "F22R@ptor";
	
	public static void main (String[] args) throws SQLException {
	
		try(Connection conn = DriverManager.getConnection(DB_URL,USER,PASS)){
			//Class .forName("com.mysql.jdbc.Driver");
			
			Statement stmt = conn.createStatement();
			//String sel = "SELECT id, first_name,last_name,age FROM Person";
			String sel = "SELECT site_id, name FROM sites";
			
			try(ResultSet rs = stmt.executeQuery(sel)){
				while(rs.next()) {
					System.out.println(rs.getString("site_id") + " " + rs.getString("name"));
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
