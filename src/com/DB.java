package com;

import java.sql.SQLException;

public class DB {
	
	private DB() {
		
	}
	
	public static void doQuery(DatabaseQuery query) throws SQLException {
		query.query();
	}

}
