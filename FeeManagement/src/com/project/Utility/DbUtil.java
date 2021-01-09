package com.project.Utility;

//When ever we need this function then we can call it in that class

import java.sql.Connection;
import java.sql.DriverManager;

public class DbUtil {

	public static Connection getMysqlDbConnection() {
		String driverClassName = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/fee_project";
		String dbUsername = "root";
		String dbPassword = "Mysql30";
		Connection con = null;
		try {
			Class.forName(driverClassName);
			con = DriverManager.getConnection(url, dbUsername, dbPassword);
		}
		catch(Exception e) {
			System.out.println("Exception Occured : "+e);
		}
		return con;
	}
}
