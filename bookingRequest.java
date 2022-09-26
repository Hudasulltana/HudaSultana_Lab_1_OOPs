package com.bookingrequest.in;
import java.time.LocalDate;
import java.util.*;

import com.bookingrequest.in.room.Occupancy;

public class bookingRequest {
	//create list for all the classes and store values. 
	static List<hotel> hotels;
	static List<room> rooms; 
	static List<customer> customers = new ArrayList<>(); 
	static List<booking> bookings = new ArrayList<>();
//	static List<Payment> payment = new ArrayList<>();
//	static List<customerReviews> customerReviews = new ArrayList<>();
	
//	static block is created to record the already existing rooms and hotels
//	according to the availability. Hence, the option to add rooms in the main method
//	is not allowed. Hence, the new rooms and hotel are be added in the static block!
	static{
		hotels = Arrays.asList(
				new hotel(1101, "Oberoi Bengaluru", "Bengaluru", "Hotel", 5, 160),
				new hotel(2102,"La Niebla Farm","Ooty","Resorts", 2, 16)
				);
		rooms = Arrays.asList(
				new room(101, 1, 1101, Occupancy.SingleOccupancy, true, false),
				new room(102, 1, 1101, Occupancy.DoubleOccupancy, true, false),
				new room(103, 1, 1101, Occupancy.DoubleOccupancy, false, false),
				
				new room(201, 2, 1101, Occupancy.SingleOccupancy, true, false),
				new room(202, 2, 1101, Occupancy.SingleOccupancy, false, false),
				new room(203, 2, 2102, Occupancy.DoubleOccupancy, true, false)
				);
	}
	
	public static int roomAllocation() {
		boolean roomAvailabilityflag = false;
		String choosenHotellocation ="";
		int choosenHotelID = 0;
		int choosenRoomID = -1;
		int choosenfloorID = -1;
		Scanner sc = new Scanner(System.in);
		System.out.println("The follwing hotels have booking open for you. Choose one from the below options.");
		System.out.println("1.Bengaluru\t2.Ooty");
		int choiceHotel = sc.nextInt();
		if(choiceHotel == 1) {
			choosenHotellocation += "Bengaluru";
		}
		else {
			choosenHotellocation += "Ooty";
		}
		//**********Put this content in a seperate method and run it.
		System.out.println("Enter the Occupancy, you  would like...");
		System.out.println("Enter you choice:\n1.Single Occupancy\t2.Double Occupancy\t3.Triple Occupancy");
		int choiceOccupancy = sc.nextInt();
		System.out.println("Would you prefer A/C or a Non A/C room?");
		System.out.println("Enter you choice:\n1.A/C\t2.Non A/C");
		int choiceAC = sc.nextInt();
		System.out.println("Would you like a floor of choice?");
		System.out.println("Enter a 'y' for Yes and 'n' for No");
		char floorChoice = sc.next().charAt(0);
		if(floorChoice == 'y') {
			System.out.println("Enter the floor number of your choice.");
			choosenfloorID = sc.nextInt();
		}
		System.out.println("Choosen hotel: "+choosenHotellocation);
		for(hotel h: hotels) {
//			System.out.println(h.getLocation()+"\t"+choosenHotellocation);
			String location = h.getLocation();
			if(location.equals(choosenHotellocation) == true) {
				choosenHotelID = h.getHotelID();
				System.out.println(choosenHotelID);
			}
		}
		System.out.println("The choosen hotelID value is: "+choosenHotelID);
		System.out.println("RoomID\tFloorNo.\tHotelID\t\tOccupancy\t\tAC/NonAC\tRoom Status");
		for(room r: rooms) {
			if(r.getHotelID() == choosenHotelID && r.isOccupancy(choiceOccupancy) == true && r.isAcNonAc(choiceAC) == true && r.isRoomStatus() == false) {
				if(choosenfloorID != -1 && r.getFloorNo() == choosenfloorID) {
					roomAvailabilityflag = true;
				}
				else if(choosenfloorID == -1) {
					roomAvailabilityflag = true;
				}
			}
			if(roomAvailabilityflag == true) {
				choosenRoomID = r.getRoomID();
				r.setRoomStatus(true);
				r.display();
				break;
			}
		}
		if(roomAvailabilityflag == false) {
			System.out.println("Sorry! Room not available!!!");
			//go for the next customerID or the same customerID
		}
		return choosenRoomID;
	}
	
	public static void main(String[] args) {
		int globalCustomerID = 1; //keep incrementing it as you keep adding the customers
		int globalBookingID = 1;
		int globalPaymentID = 1;
		float Price = 0.0f;
		boolean customerAlreadyExists = false;
		int chosenHotelID = 0;
		int allocatedRoomID = -1;
		int chosenFloorID = 1;
		int chosenCustomerID = 0;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("\n\n*******************************************");
		System.out.println("Welcome to the Hotel Booking Managemeant!!!");
		System.out.println("*******************************************\n");
//		checkRoomAvailability();
		for(;;) {
			allocatedRoomID = roomAllocation();
			if(allocatedRoomID != -1) {
						System.out.println("Enter the details of the Customer in the following format:");
						System.out.println("1.Name:");
						String givenName = sc.next();
						System.out.println("2.Aadhaar Card Number:");
						String givenAadhaarCard = sc.next();
						System.out.println("Phone Number:");
						String givenPhoneNumber = sc.next();
						//search to find whether the customer already exists
						for(customer c: customers) {
							if(c.getAadhaarCard().equals(givenAadhaarCard)) {
								customerAlreadyExists = true;
								chosenCustomerID = c.getCustomerID();
								c.setNoOfBookings();
								c.customerDetails();
							}
						}
						if(customerAlreadyExists == false) {
							customer c = new customer(globalCustomerID++, givenName, givenAadhaarCard, givenPhoneNumber);
							customers.add(c);
							chosenCustomerID = globalCustomerID - 1;
							c.customerDetails();
						}		
						//bookings and total amount
						System.out.println("Enter start date and end date in format: YYYY-MM-DD");
						String startDate = sc.next();
						String endDate = sc.next();
						for(room r: rooms) {
							if(allocatedRoomID == r.getRoomID()) {
								chosenHotelID = r.getHotelID();
							}
						}
						booking book = new booking(globalBookingID++, chosenCustomerID, chosenHotelID, allocatedRoomID, startDate, endDate);
						bookings.add(book);
						book.displayBookingDetails();
						for(room r: rooms) {
							if(allocatedRoomID == r.getRoomID()) {
								Price = r.Pricing();
							}
						}
						System.out.println("The total amount for the booking\nHotelID: "+chosenHotelID+"\nRoomID: "+allocatedRoomID+"\nis: "+Price);
						//payment details
						
//						for(customer c: customers) {
//							if(book.getEndDate() == LocalDate.now().toString()) {
//								customerReviews custReview = new customerReviews();
//							}
//						}
			}
			
			System.out.println("\n\nWould you like to consider another booking?\nEnter y/n as per your choice!\n");
			char choiceAnotherBooking = sc.next().charAt(0);
			if(choiceAnotherBooking == 'n') {
				System.exit(0);
			}
		}
		
	}

}
