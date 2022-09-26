package com.bookingrequest.in;

public class customer {
	private int CustomerID;
	private String name;
	private String AadhaarCard;
	private String phoneNumber;
	private int NoOfBookings;
	
	public customer(int CustomerID, String name, String AadhaarCard, String phoneNumber) {
		this.CustomerID = CustomerID;
		this.name = name;
		this.AadhaarCard = AadhaarCard;
		this.phoneNumber = phoneNumber;
		this.NoOfBookings = 1;
	}
	
	public int getCustomerID() {
		return CustomerID;
	}
	
	public String getName() {
		return name;
	}

	public String getAadhaarCard() {
		return AadhaarCard;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public int getNoOfBookings() {
		return NoOfBookings;
	}
	public void setNoOfBookings() {
		this.NoOfBookings += 1;
	}
	
	public void customerDetails() {
		System.out.println("\n\n*************************\n");
		System.out.println("The customer details are as follows:");
		System.out.println("CustomerID             : "+CustomerID);
		System.out.println("Name                   : "+this.name);
		System.out.println("Aadhaar Card No.       : "+this.AadhaarCard);
		System.out.println("Phone Number           : "+this.phoneNumber);
		System.out.println("Total No. of bookings  : "+this.NoOfBookings);
		System.out.println("\n*************************\n\n");
	}
}
