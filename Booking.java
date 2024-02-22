package Hotelreserveproject;

import java.sql.SQLException;
import java.text.*;
import java.util.*;

public class Booking {
	 int id;
	 int roomnum;
	 String name;
	 Date checkin;
	
Booking( String name, Date checkInDate, int roomNumber){
	super();
	
	this.roomnum = roomNumber;
	this.name = name;
	this.checkin = checkInDate;
}


}
