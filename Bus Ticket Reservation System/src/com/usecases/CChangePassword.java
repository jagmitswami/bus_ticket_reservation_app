package com.usecases;

import java.util.Scanner;

import com.dao.CustomerDao;
import com.dao.CustomerDaoImpl;

public class CChangePassword {

	public static void changePassword(int cid) {
		// TODO Auto-generated method stub

		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter current password: ");
			String currpassString = sc.next();
			System.out.println("Enter new password: ");
			String newpassString = sc.next();
			
			CustomerDao dao = new CustomerDaoImpl();
			System.out.println(dao.changePassword(cid, currpassString, newpassString));
			
			System.out.println("=====================================");
			CustomerLoginInterface.customerLoginInterface(cid);
			sc.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

}
