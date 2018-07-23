package com.capgemini.paymentWallet.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ClientUtil {
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = 	DriverManager.getConnection("jdbc:mysql://localhost:3306/parallel_project", "root", "Capgemini123");

		return conn;
		
	}

}
