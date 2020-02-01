package com.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.DatabaseQuery;

public class MySQLQuery implements DatabaseQuery {
	private Connection conn;
	public MySQLQuery(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void query() throws SQLException {
		Statement stmt = this.conn.createStatement();
		
		String sql = "SELECT first_name, last_name from Person";
		try(ResultSet rs = stmt.executeQuery(sql)){
			while(rs.next()) {
				System.out.println(rs.getString("first_name") + " " + rs.getString("last_name"));
			}
		}
		
		
	}

}
