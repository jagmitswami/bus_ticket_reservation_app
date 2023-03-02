package com.usecases;

import java.util.Scanner;

import com.dao.CustomerDao;
import com.dao.CustomerDaoImpl;

public class CBookTicket {

	public static void bookTicket(int cid) {


		try {
			Scanner sc = new Scanner(System.in);
			
			System.out.println("____________________");
			System.out.println("|                  |");
			System.out.println("|  Enter bus id:   |");
			System.out.println("|__________________|");
			int bid = sc.nextInt();
			
			CustomerDao dao = new CustomerDaoImpl();

			System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++");
			System.out.println(dao.bookTicket(bid, cid));
			System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++");
			
			System.out.println("==================================================");
						
			CustomerLoginInterface.customerLoginInterface(cid);
			sc.close();
		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
	}

}
