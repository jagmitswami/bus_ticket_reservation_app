package com.usecases;

import java.util.Scanner;

import com.dao.CustomerDao;
import com.dao.CustomerDaoImpl;

public class CCancelTicket {

	public static void cancelTicket(int cid) {


		try {
			Scanner sc = new Scanner(System.in);
			
			System.out.println("_____________________");
			System.out.println("|                   |");
			System.out.println("|  Enter seat no:   |");
			System.out.println("|___________________|");
			int seat_no = sc.nextInt();
			
			System.out.println("____________________");
			System.out.println("|                  |");
			System.out.println("|  Enter bus id:   |");
			System.out.println("|__________________|");
			int bid = sc.nextInt();
			
			CustomerDao dao = new CustomerDaoImpl();

			System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++");
			System.out.println(dao.cancelTicket(cid, bid, seat_no));
			System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++");
			
			System.out.println("==================================================");
						
			CustomerLoginInterface.customerLoginInterface(cid);
			sc.close();
		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
	}

}
