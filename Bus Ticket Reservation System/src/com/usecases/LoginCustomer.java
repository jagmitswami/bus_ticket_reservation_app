package com.usecases;

import java.util.Scanner;

import com.dao.CustomerDao;
import com.dao.CustomerDaoImpl;

public class LoginCustomer {

	public static void loginCustomer() {
		// TODO Auto-generated method stub

		try {
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Enter id: ");
			int cid = sc.nextInt();
			
			System.out.println("Enter password: ");
			String cpass = sc.next();
			
			
			CustomerDao dao = new CustomerDaoImpl();
			boolean res = dao.logInCustomer(cid, cpass);
			
			if(res) {
				CustomerLoginInterface.customerLoginInterface(cid);
			}else {
				System.out.println("wrong id or password...");
			}
			
			sc.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

}
