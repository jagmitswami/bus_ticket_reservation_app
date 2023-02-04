package com.usecases;

import java.util.Scanner;

import com.dao.CustomerDao;
import com.dao.CustomerDaoImpl;

public class CCancelTicket {

	public static void cancelTicket(int cid) {
		// TODO Auto-generated method stub

		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter bus id: ");
			int bid = sc.nextInt();
			System.out.println("Enter seat no: ");
			int seat_no = sc.nextInt();
			
			CustomerDao dao = new CustomerDaoImpl();
			System.out.println(dao.cancelTicket(cid, bid, seat_no));
			
			System.out.println("=====================================");
			CustomerLoginInterface.customerLoginInterface(cid);
			sc.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

}
