package com.bookingrequest.in;


public class room {
	
	public enum Occupancy{
		SingleOccupancy, DoubleOccupancy, TripleOccupancy;
	}
	private int RoomID; // 201 means 2nd floor
	private int floorNo; 
	private int HotelID;
	private Occupancy occupancy;
	private boolean acNonAc;
	private boolean roomStatus;
	
	public room(int RoomID, int floorNo, int HotelID, Occupancy occupancy, boolean acNonAc, boolean roomStatus) {
	this.RoomID = RoomID;
	this.floorNo = floorNo;
	this.HotelID = HotelID;
	this.occupancy = occupancy;
	this.acNonAc = acNonAc; //ac=1, non-ac=0;
	this.roomStatus = roomStatus;
}
	
	public int getRoomID() { 
		return RoomID;
	}

	public int getFloorNo() {
		return floorNo;
	}

	public int getHotelID() {
		return HotelID;
	}

	public boolean isOccupancy(int choice) {
		if(choice == 1 && this.occupancy == Occupancy.SingleOccupancy) {
			return true;
		}
		else if(choice == 2 && this.occupancy == Occupancy.DoubleOccupancy) {
			return true;
		}
		else if(choice == 3 && this.occupancy == Occupancy.TripleOccupancy) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean isAcNonAc(int choiceAC) {
		if(this.acNonAc == true && choiceAC == 1)
		return true;
		else if(this.acNonAc == false && choiceAC == 2) return true;
		else return false;
	}
	public void setAcNonAc(boolean acNonAc) {
		this.acNonAc = acNonAc;
	}
	public boolean isRoomStatus() {
		return roomStatus;
	}
	public void setRoomStatus(boolean roomStatus) {
		this.roomStatus = roomStatus;
	}
	
	public int Pricing() {
		int totalPrice = 0;
		if(Occupancy.SingleOccupancy == this.occupancy) {
			totalPrice += 2000;
		}
		else if(Occupancy.DoubleOccupancy == this.occupancy){
			totalPrice += 3000;
		}
		else if(Occupancy.TripleOccupancy ==this.occupancy) {
			totalPrice += 4000;
		}
		if(this.acNonAc == true) {
			totalPrice += 1000;
		}
		return totalPrice;
	}	
	
	public void display() {
		System.out.println(this.RoomID +"\t"+this.floorNo+"\t\t"+this.HotelID+"\t\t"+this.occupancy+"\t\t"+this.acNonAc+"\t\t"+this.roomStatus);
	}
}
