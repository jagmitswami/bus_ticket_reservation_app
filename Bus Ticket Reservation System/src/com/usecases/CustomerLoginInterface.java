package com.usecases;

import java.util.Scanner;

public class CustomerLoginInterface {

	public static void customerLoginInterface(int cid) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("---Welcom---");
		
		System.out.println("1. view My Tickets");
		System.out.println("2. cancel Ticket");
		System.out.println("3. change Password");
		System.out.println("4. show All Buses On Date");
		System.out.println("5. book Ticket");
		System.out.println("Any other key to log out and exit!");
		
		int input = sc.nextInt();
		
		if(input==1) CViewMyTickets.viewMyTickets(cid);
		else if(input==2) CCancelTicket.cancelTicket(cid);
		else if(input==3) CChangePassword.changePassword(cid);
		else if(input==4) CShowAllBusesOnDate.showAllBusesOnDate(cid);
		else if(input==5) CBookTicket.bookTicket(cid);
		else System.out.println("logged out and exited...");
		sc.close();
	}

}
