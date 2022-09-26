package com.bookingrequest.in;

public class hotel {
	private int HotelID;
	private String HotelName;
	private String Location;
	private String Category; //e.g., bar and restraunt
	private int totalNoOfFloors;
	private int Rooms;
	private static int count = 0;
//	totalNoOfRooms available; put in psvm.
	
	hotel(int HotelID, String HotelName, String Location,String Category, int totalNoOfFloors, int Rooms){
	this.HotelID = HotelID;
	this.HotelName = HotelName;
	this.Location = Location;
	this.Category = Category;
	this.totalNoOfFloors = totalNoOfFloors;
	this.Rooms = Rooms;
}
	
	public void setHotelID(int hotelID) {
		HotelID = hotelID;
	}

	public void setHotelName(String hotelName) {
		HotelName = hotelName;
	}

	public void setLocation(String location) {
		Location = location;
	}

	public void setCategory(String category) {
		Category = category;
	}

	public void setTotalNoOfFloors(int totalNoOfFloors) {
		this.totalNoOfFloors = totalNoOfFloors;
	}

	public void setRooms(int rooms) {
		Rooms = rooms;
	}

	public int getHotelID() { //made change
//		System.out.println("from hotel class: "+this.Location);
		return HotelID;
	}

	public String getHotelName() {
		return HotelName;
	}

	public String getLocation() {  //made change
//		System.out.println("from hotel class: "+this.Location);
		return this.Location;
	}

	public String getCategory() {
		return Category;
	}

	public int getTotalNoOfFloors() {
		return totalNoOfFloors;
	}

	public int getRooms() {
		return Rooms;
	}
}
