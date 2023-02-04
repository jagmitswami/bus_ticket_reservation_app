package com.usecases;

import java.util.Scanner;

import com.dao.AdminDao;
import com.dao.AdminDaoImpl;

public class LoginAdmin {

	public static void loginAdmin() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter admin id: ");
		int id = sc.nextInt();
		System.out.println("Enter admin password: ");
		String pass = sc.next();
		
		AdminDao dao = new AdminDaoImpl();
		if(dao.adminLogin(id, pass)) {
			System.out.println("---Welcome admin---");
			AdminLoginInterface.adminLoginInterface();
		}else {
			System.out.println("Wrong id or password...");
		}
		
		sc.close();
	}
}
