package com.usecases;

import java.util.Scanner;

import com.dao.AdminDao;
import com.dao.AdminDaoImpl;

public class LoginAdmin {

	public static void loginAdmin() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("______________________");
		System.out.println("|                    |");
		System.out.println("|  Enter admin id:   |");
		System.out.println("|____________________|");
		int id = sc.nextInt();
		
		System.out.println("____________________________");
		System.out.println("|                          |");
		System.out.println("|  Enter admin password:   |");
		System.out.println("|__________________________|");
		String pass = sc.next();
		
		AdminDao dao = new AdminDaoImpl();
		if(dao.adminLogin(id, pass)) {
			
			System.out.println("____________________");
			System.out.println("|                  |");
			System.out.println("|  Welcome admin   |");
			System.out.println("|__________________|");
			
			AdminLoginInterface.adminLoginInterface();
		}else {
			
			System.out.println("____________________________");
			System.out.println("|                          |");
			System.out.println("|  Wrong id or password!   |");
			System.out.println("|__________________________|");
			
		}
		
		sc.close();
	}
}
