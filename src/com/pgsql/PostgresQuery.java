package com.pgsql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.DatabaseQuery;

public class PostgresQuery implements DatabaseQuery {
	
	private Connection conn;
	
	public PostgresQuery(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void query() throws SQLException{
		
		Statement stmt = this.conn.createStatement();
		
		String sql = "SELECT site_id, name FROM sites;";
		
		try(ResultSet rs = stmt.executeQuery(sql)){
			while(rs.next())
				System.out.println(rs.getString("site_id") + " " +rs.getString("name"));
		}
		
	}
	
	

}
