package Hotelreserveproject;

import java.sql.*;

public class DBconnection {
	private static String url="jdbc:mysql://localhost:3306/hotelreservation";
	private static String username="root";
	private static String password="manoj2603";
	
	public static Connection getconnection()throws SQLException{
		return DriverManager.getConnection(url,username,password);
	}
}
