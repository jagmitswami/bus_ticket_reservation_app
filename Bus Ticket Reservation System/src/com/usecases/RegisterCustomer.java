package com.usecases;

import java.util.Scanner;

import com.dao.CustomerDao;
import com.dao.CustomerDaoImpl;
import com.exception.CustomerException;

public class RegisterCustomer {

	public static void registerCustomer() {


		Scanner sc = new Scanner(System.in);
		
		System.out.println("__________________");
		System.out.println("|                |");
		System.out.println("|  Enter name:   |");
		System.out.println("|________________|");
		String cname = sc.next();
		
		System.out.println("______________________");
		System.out.println("|                    |");
		System.out.println("|  Enter password:   |");
		System.out.println("|____________________|");
		String cpass = sc.next();
		
		System.out.println("____________________________");
		System.out.println("|                          |");
		System.out.println("|  Enter contact number:   |");
		System.out.println("|__________________________|");
		String contact = sc.next();
		
		CustomerDao dao = new CustomerDaoImpl();
		try {
			String res = dao.registerCustomer(cname, cpass, contact);
			
			System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++");
			System.out.println(res);
			System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++");
			
		} catch (CustomerException e) {
			System.out.println(e.getMessage());
		}
		
		sc.close();
	}

}
