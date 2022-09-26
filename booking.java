package com.bookingrequest.in;

public class booking {
	
	private int BookingID;  
	private int CustomerID; 
	private int HotelID;  
	private int RoomID;  
	String startDate; // YYYY-MM-DD format
	String endDate;
	
	public booking(int BookingID, int CustomerID, int HotelID, int RoomID, String startDate, String endDate ) {
		this.BookingID = BookingID;
		this.RoomID = RoomID;
		this.CustomerID = CustomerID;
		this.HotelID = HotelID;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public int getBookingID() {
		return BookingID;
	}

	public int getCustomerID() {
		return CustomerID;
	}

	public int getHotelID() {
		return HotelID;
	}

	public int getRoomID() {
		return RoomID;
	}

	public String getStartDate() {
		return startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void displayBookingDetails() {
		System.out.println("\n\n*************************\n");
		System.out.println("The Booking details of the Customer are as follows:");
		System.out.println("CustomerID             : "+CustomerID);
		System.out.println("BookingID              : "+this.BookingID);
		System.out.println("RoomID                 : "+this.RoomID);
		System.out.println("HotelID                : "+this.HotelID);
		System.out.println("Start Date             : "+this.startDate);
		System.out.println("End Date               : "+this.endDate);
		System.out.println("\n*************************\n\n");
	}
}
