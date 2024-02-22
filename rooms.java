package Hotelreserveproject;

public class rooms {
	private int roomnum;
	private String roomtype;
	private int price;

	rooms(int num, String type, int val) {
		this.roomnum = num;
		this.roomtype = type;
		this.price = val;
	}

	public int getRoomnum() {
		return roomnum;
	}

	public void setRoomnum(int roomnum) {
		this.roomnum = roomnum;
	}

	public String getRoomtype() {
		return roomtype;
	}

	public void setRoomtype(String roomtype) {
		this.roomtype = roomtype;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
