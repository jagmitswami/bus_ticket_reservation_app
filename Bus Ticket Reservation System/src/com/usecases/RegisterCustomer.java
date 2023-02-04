package com.usecases;

import java.util.Scanner;

import com.dao.CustomerDao;
import com.dao.CustomerDaoImpl;
import com.exception.CustomerException;

public class RegisterCustomer {

	public static void registerCustomer() {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter name: ");
		String cname = sc.next();
		
		System.out.println("Enter password: ");
		String cpass = sc.next();
		
		System.out.println("Enter contact number: ");
		String contact = sc.next();
		
		CustomerDao dao = new CustomerDaoImpl();
		try {
			String res = dao.registerCustomer(cname, cpass, contact);
			System.out.println(res);
		} catch (CustomerException e) {
			System.out.println(e.getMessage());
		}
		
		sc.close();
	}

}
