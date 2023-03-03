package com.usecases;

import java.util.Scanner;

public class AdminLoginInterface {

	public static void adminLoginInterface() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("______________________________________________");
		System.out.println("|                                            |");
		System.out.println("|  1. Add new bus                            |");
		System.out.println("|  2. Show bus details by bus id             |");
		System.out.println("|  3. Show arraival time of the bus          |");
		System.out.println("|  4. Show departure time of the bus         |");
		System.out.println("|  5. Show bus route by bus id               |");
		System.out.println("|  6. Show ticket details by seat no         |");
		System.out.println("|  7. Show list of passengers inside bus     |");
		System.out.println("|  8. Show no of seats available inside bus  |");
		System.out.println("|  Any other key to log out and exit!        |");
		System.out.println("|____________________________________________|");
		int input = sc.nextInt();
		
		if(input==1) AAddNewBus.addNewBus();
		else if(input==2) AShowBusDetailsByBusId.showBusDetailsByBusId();
		else if(input==3) AShowArrivalTimeofBus.showArrivalTimeofBus();
		else if(input==4) AShowDepartureTimeofBus.showDepartureTimeofBus();
		else if(input==5) AShowBusRoute.showBusRoute();
		else if(input==6) AShowTicketDetails.showTicketDetails();
		else if(input==7) AShowCustomerDetailsInTheBus.showCustomerDetailsInTheBus();
		else if(input==8) AShowNoOfSeatsAvailable.showNoOfSeatsAvailable();
		else {
			System.out.println("____________________________");
			System.out.println("|                          |");
			System.out.println("|  Logged out and exited   |");
			System.out.println("|__________________________|");
		}
		sc.close();
	}

}
