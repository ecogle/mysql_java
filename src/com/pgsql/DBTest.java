package com.pgsql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import tools.Config;

public class DBTest {
			
	public static void main (String[] args) throws SQLException {
		
		Config config = new Config(Config.DB_TYPES.POSTGRES);
	
		try(Connection conn = DriverManager.getConnection(config.getURL(),config.getUsername(),config.getPassword())){
						
			Statement stmt = conn.createStatement();
			
			String sel = "SELECT site_id, name FROM sites";
			
			try(ResultSet rs = stmt.executeQuery(sel)){
				while(rs.next()) {
					System.out.println(rs.getString("site_id") + " " + rs.getString("name"));
				}
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	

}
