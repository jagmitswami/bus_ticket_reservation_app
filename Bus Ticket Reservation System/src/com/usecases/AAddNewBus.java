package com.usecases;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

import com.dao.AdminDao;
import com.dao.AdminDaoImpl;
import com.model.Bus;

public class AAddNewBus {

	public static void addNewBus() {
		// TODO Auto-generated method stub

		try {
			Bus bus = new Bus();
			
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Select bus type |1.| for AC |2.| for non-AC: ");
			String typeString = "AC";
			
			while(true) {
				int input = sc.nextInt();
				if(input == 1 || input == 2) {
					if(input == 2) typeString = "non-AC";
					break;
				}
				else {
					System.out.println("Wrong Input try again...");
					System.out.println("Select bus type |1.| for AC |2.| for non-AC: ");
				}
			}
			
			bus.setTypeString(typeString);
			
			System.out.println("Enter departure date and time as follow ");
			System.out.println("year: ");
			int year = sc.nextInt();
			System.out.println("month: ");
			int month = sc.nextInt();
			System.out.println("day: ");
			int day = sc.nextInt();
			System.out.println("hour: ");
			int hour = sc.nextInt();
			System.out.println("minutes: ");
			int minutes = sc.nextInt();
			bus.setdTime(LocalTime.of(hour,minutes));
			bus.setdDate(LocalDate.of(year, month, day));
			
			System.out.println("Enter arrival date and time as follow ");
			System.out.println("year: ");
			int ayear = sc.nextInt();
			System.out.println("month: ");
			int amonth = sc.nextInt();
			System.out.println("day: ");
			int aday = sc.nextInt();
			System.out.println("hour: ");
			int ahour = sc.nextInt();
			System.out.println("minutes: ");
			int aminutes = sc.nextInt();
			bus.setaTime(LocalTime.of(ahour,aminutes));
			bus.setaDate(LocalDate.of(ayear, amonth, aday));
			
			System.out.println("Enter number available seats: ");
			int aseats = sc.nextInt();
			bus.setAvailable_seats(aseats);
			
			System.out.println("Enter number total seats: ");
			int tseats = sc.nextInt();
			bus.setAvailable_seats(tseats);
			
			System.out.println("Enter source of bus: ");
			String source = sc.next();
			bus.setSource(source);
			
			System.out.println("Enter destination of bus: ");
			String destination = sc.next();
			bus.setDestination(destination);
			
			System.out.println("Enter contact no of the bus: ");
			String contact = sc.next();
			bus.setContact(contact);
			
			System.out.println("Enter fare price: ");
			int price = sc.nextInt();
			bus.setPrice(price);
			
			
			AdminDao dao = new AdminDaoImpl();
			
			System.out.println(dao.addNewBus(bus));
			
			System.out.println("=================================");
			AdminLoginInterface.adminLoginInterface();
			sc.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

}
