package com.usecases;

import java.util.Scanner;

import com.dao.CustomerDao;
import com.dao.CustomerDaoImpl;

public class CBookTicket {

	public static void bookTicket(int cid) {
		// TODO Auto-generated method stub

		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter bus id: ");
			int bid = sc.nextInt();
			
			CustomerDao dao = new CustomerDaoImpl();
			System.out.println(dao.bookTicket(bid, cid));
			System.out.println("=====================================");
			CustomerLoginInterface.customerLoginInterface(cid);
			sc.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

}
