package com.usecases;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import com.dao.AdminDao;
import com.dao.AdminDaoImpl;
import com.model.Bus;

public class AAddNewBus {

	public static void addNewBus() {

		try {
			Bus bus = new Bus();
			
			Scanner sc = new Scanner(System.in);
			
			System.out.println("__________________________________________________");
			System.out.println("|                                                |");
			System.out.println("|  Select bus type |1.| for AC |2.| for non-AC:  |");
			System.out.println("|________________________________________________|");
			
			String typeString = "AC";
			
			while(true) {
				int input = sc.nextInt();
				if(input == 1 || input == 2) {
					if(input == 2) typeString = "non-AC";
					break;
				}
				else {
					System.out.println("__________________________________________________");
					System.out.println("|                                                |");
					System.out.println("|  Wrong Input try again!                        |");
					System.out.println("|  Select bus type |1.| for AC |2.| for non-AC:  |");
					System.out.println("|________________________________________________|");
				}
			}
			
			bus.setTypeString(typeString);
			
			System.out.println("_________________________________________________");
			System.out.println("|                                               |");
			System.out.println("|  Enter departure date(dd-MM-yyyy) as follow   |");
			System.out.println("|_______________________________________________|");
			String departureDate = sc.next();
			
			System.out.println("____________________________________________");
			System.out.println("|                                          |");
			System.out.println("|  Enter departure time(HH:mm) as follow   |");
			System.out.println("|__________________________________________|");
			String departureTime = sc.next();
			
			bus.setdTime(LocalTime.parse(departureTime, DateTimeFormatter.ofPattern("HH:mm")));
			bus.setdDate(LocalDate.parse(departureDate, DateTimeFormatter.ofPattern("dd-MM-yyyy")));
			
			
			System.out.println("_______________________________________________");
			System.out.println("|                                             |");
			System.out.println("|  Enter arrival date(dd-MM-yyyy) as follow   |");
			System.out.println("|_____________________________________________|");
			String arrivalDate = sc.next();
			
			System.out.println("__________________________________________");
			System.out.println("|                                        |");
			System.out.println("|  Enter arrival time(HH:mm) as follow   |");
			System.out.println("|________________________________________|");
			String arrivalTime = sc.next();
			
			bus.setaTime(LocalTime.parse(arrivalTime, DateTimeFormatter.ofPattern("HH:mm")));
			bus.setaDate(LocalDate.parse(arrivalDate, DateTimeFormatter.ofPattern("dd-MM-yyyy")));
			
			System.out.println("________________________________");
			System.out.println("|                              |");
			System.out.println("|  Enter number total seats:   |");
			System.out.println("|______________________________|");
			int tseats = sc.nextInt();
			bus.setTotal_seats(tseats);
			bus.setAvailable_seats(tseats);
			
			System.out.println("___________________________");
			System.out.println("|                         |");
			System.out.println("|  Enter source of bus:   |");
			System.out.println("|_________________________|");
			String source = sc.next();
			bus.setSource(source);
			
			System.out.println("________________________________");
			System.out.println("|                              |");
			System.out.println("|  Enter destination of bus:   |");
			System.out.println("|______________________________|");
			String destination = sc.next();
			bus.setDestination(destination);
			
			System.out.println("___________________________________");
			System.out.println("|                                 |");
			System.out.println("|  Enter contact no of the bus:   |");
			System.out.println("|_________________________________|");
			String contact = sc.next();
			bus.setContact(contact);
			
			System.out.println("________________________");
			System.out.println("|                      |");
			System.out.println("|  Enter fare price:   |");
			System.out.println("|______________________|");
			int price = sc.nextInt();
			bus.setPrice(price);
			
			
			AdminDao dao = new AdminDaoImpl();
			
			System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++");
			System.out.println(dao.addNewBus(bus));
			System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++");
			
			System.out.println("==================================================");
			AdminLoginInterface.adminLoginInterface();
			sc.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

}
