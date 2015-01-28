/**
 * 
 */
package com.lftechnology.employee.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * This is the manager class to connect with the database with the configuration of database name, username and its password.
 * 
 * @author sanjib<sanjibmaharjan@lftechnology.com>
 * 
 */
public class ConnectionManager {
	private static final String database = "employee_test";
	private static final String userName = "root";
	private static final String password = "vampire";

	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + database, userName, password);
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}

}
