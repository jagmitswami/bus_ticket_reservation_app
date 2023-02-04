package com.usecases;

import java.time.LocalDate;
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

			System.out.println("year: ");
			int ayear = sc.nextInt();
			System.out.println("month: ");
			int amonth = sc.nextInt();
			System.out.println("day: ");
			int aday = sc.nextInt();
			LocalDate date = LocalDate.of(ayear, amonth, aday);

			System.out.println("Enter source: ");
			String source = sc.next();
			System.out.println("Enter destination: ");
			String destination = sc.next();
			
			CustomerDao dao = new CustomerDaoImpl();
			List<Bus> list = dao.showAllBusesOnDate(date, source, destination);
			
			if(list.size()==0) System.out.println("No bus found...");
			else list.forEach(b -> System.out.println(b));
			
			System.out.println("=====================================");
			CustomerLoginInterface.customerLoginInterface(cid);
			sc.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

}
