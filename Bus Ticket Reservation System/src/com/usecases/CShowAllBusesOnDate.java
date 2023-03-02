package com.usecases;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import com.dao.CustomerDao;
import com.dao.CustomerDaoImpl;
import com.model.Bus;

public class CShowAllBusesOnDate {

	public static void showAllBusesOnDate(int cid){
		// TODO Auto-generated method stub

		try {
			Scanner sc = new Scanner(System.in);

			System.out.println("Enter departure date(dd-MM-yyyy) as follow ");
			String dateString = sc.next();
			
			LocalDate date = LocalDate.parse(dateString, DateTimeFormatter.ofPattern("dd-MM-yyyy"));

			System.out.println("Enter source: ");
			String source = sc.next();
			System.out.println("Enter destination: ");
			String destination = sc.next();
			
			CustomerDao dao = new CustomerDaoImpl();
			List<Bus> list = dao.showAllBusesOnDate(date, source, destination);
			
			if(list.size()==0) {
				
				System.out.println("______________________");
				System.out.println("|                    |");
				System.out.println("|  No bus(s) found   |");
				System.out.println("|____________________|");
			
			}
			else {

				System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++");
				list.forEach(b -> System.out.println(b));
				System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++");
			
			}
			
			System.out.println("==================================================");
						
			CustomerLoginInterface.customerLoginInterface(cid);
			sc.close();
		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
	}

}
