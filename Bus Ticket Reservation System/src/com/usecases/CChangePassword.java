package com.usecases;

import java.util.Scanner;

import com.dao.CustomerDao;
import com.dao.CustomerDaoImpl;

public class CChangePassword {

	public static void changePassword(int cid) {


		try {
			Scanner sc = new Scanner(System.in);
			
			System.out.println("______________________________");
			System.out.println("|                            |");
			System.out.println("|  Enter current password:   |");
			System.out.println("|____________________________|");
			String currpassString = sc.next();
			
			System.out.println("__________________________");
			System.out.println("|                        |");
			System.out.println("|  Enter new password:   |");
			System.out.println("|________________________|");
			String newpassString = sc.next();
			
			CustomerDao dao = new CustomerDaoImpl();

			System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++");
			System.out.println(dao.changePassword(cid, currpassString, newpassString));
			System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++");
			
			System.out.println("==================================================");
						
			CustomerLoginInterface.customerLoginInterface(cid);
			sc.close();
		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
	}

}
