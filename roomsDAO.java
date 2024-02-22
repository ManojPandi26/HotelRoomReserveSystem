package Hotelreserveproject;

import java.sql.*;

public class roomsDAO {
	
	public static void AddRooms(int rnum,String rtype,int val) throws SQLException {
		Connection c1 = DBconnection.getconnection();

		String q1 = "insert into rooms values(?,?,?);";
		PreparedStatement p1 = c1.prepareStatement(q1);
		p1.setInt(1, rnum);
		p1.setString(2, rtype);
		p1.setInt(3, val);
		p1.executeUpdate();
		c1.close();
	}
	
}
