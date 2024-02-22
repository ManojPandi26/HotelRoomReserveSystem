package Hotelreserveproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.Date;
import java.util.Random;

public class InteractionGUI {
	public static String viewRooms() throws SQLException {
		StringBuilder result = new StringBuilder();
		try (Connection con = DBconnection.getconnection(); Statement st = con.createStatement()) {

			String query1 = "select roomnumber, roomtype, price from rooms where reserved = 0;";
			ResultSet rs = st.executeQuery(query1);

			while (rs.next()) {
				result.append("Room Number: ").append(rs.getInt(1)).append("  ");
				result.append("Room Type: ").append(rs.getString(2)).append("  ");
				result.append("Price: ").append(rs.getInt(3)).append("\n");
			}
		} catch (SQLException e) {
			// Handle exception properly
			throw e;
		}
		return result.toString();
	}

	static boolean makeReservationsGui(String name, Date checkInDate, int rnum) throws SQLException, ParseException {
		if (BookingDAO.isAvailable(rnum)) {

			Random random = new Random();
			int id = 1000 + random.nextInt(4001);
			String insertReservationQuery = "INSERT INTO reservations  VALUES (?,?,?)";
			String updateRoomQuery = "UPDATE rooms SET reserved = 1 WHERE roomnumber = ?";
			try (Connection connection = DBconnection.getconnection();
					PreparedStatement insertReservationStatement = connection.prepareStatement(insertReservationQuery);
					PreparedStatement updateRoomStatement = connection.prepareStatement(updateRoomQuery)) {
				insertReservationStatement.setInt(1, id);
				insertReservationStatement.setString(2, name);
				insertReservationStatement.setDate(3, new java.sql.Date(checkInDate.getTime()));
				insertReservationStatement.executeUpdate();

				updateRoomStatement.setInt(1, rnum);
				updateRoomStatement.executeUpdate();
				return true;
			}
		}
		return false;
	}

	public static String viewReservations() throws SQLException {
		StringBuilder reservations = new StringBuilder();
		// Fetch reservations details from the database
		String q1 = "SELECT * FROM reservations;";
		try (Connection c1 = DBconnection.getconnection();
				Statement st = c1.createStatement();
				ResultSet rs = st.executeQuery(q1)) {

			// Append reservations details to the StringBuilder
			reservations.append("Reservations Details:\n\n");
			while (rs.next()) {
				reservations.append("ReservationId: ").append(rs.getInt(1)).append("\n");
				reservations.append("GuestName: ").append(rs.getString(2)).append("\n");
				reservations.append("CheckInDate (yyyy-mm-dd): ").append(rs.getDate(3)).append("\n\n");
			}
		}
		return reservations.toString();
	}

}
