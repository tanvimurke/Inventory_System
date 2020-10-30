package com.system.inventory.dbmanager;

import java.sql.Connection;
import java.sql.DriverManager;



public class DBManager {

	static Connection con = null;
	
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory","root","nilesh@8101998");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}  
		
		
		return con;
	}
	
}
