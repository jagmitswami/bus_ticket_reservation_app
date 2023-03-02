package com.usecases;

import java.util.Scanner;

import com.dao.CustomerDao;
import com.dao.CustomerDaoImpl;

public class LoginCustomer {

	public static void loginCustomer() {
		// TODO Auto-generated method stub

		try {
			Scanner sc = new Scanner(System.in);
			
			System.out.println("_________________________");
			System.out.println("|                       |");
			System.out.println("|  Enter customer id:   |");
			System.out.println("|_______________________|");
			int cid = sc.nextInt();
			
			System.out.println("_______________________________");
			System.out.println("|                             |");
			System.out.println("|  Enter customer password:   |");
			System.out.println("|_____________________________|");
			String cpass = sc.next();
			
			
			CustomerDao dao = new CustomerDaoImpl();
			boolean res = dao.logInCustomer(cid, cpass);
			
			if(res) {
				CustomerLoginInterface.customerLoginInterface(cid);
			}else {

				System.out.println("____________________________");
				System.out.println("|                          |");
				System.out.println("|  Wrong id or password!   |");
				System.out.println("|__________________________|");

			}
			
			sc.close();
		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
	}

}
