package com.pgsql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.DB;
import com.DatabaseQuery;
import com.mysql.MySQLQuery;

import tools.Config;
import tools.Config.DB_TYPES;

public class DBTest {
			
	public static void main (String[] args) throws SQLException {
		
		Config config = new Config(Config.DB_TYPES.POSTGRES);
	
		try(Connection conn = DriverManager.getConnection(config.getURL(),config.getUsername(),config.getPassword())){
						
			Statement stmt = conn.createStatement();
			String sel = null;
			DatabaseQuery query = null;
			if(config.getType() == DB_TYPES.MYSQL) {
				query = new MySQLQuery(conn);			}
			else
			{
				query = new PostgresQuery(conn);
			}			
			
			DB.doQuery(query);
		}
		 catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	

}
