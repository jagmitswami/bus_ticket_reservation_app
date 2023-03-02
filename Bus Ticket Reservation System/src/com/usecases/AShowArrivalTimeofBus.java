package com.usecases;

import java.util.Scanner;

import com.dao.AdminDao;
import com.dao.AdminDaoImpl;

public class AShowArrivalTimeofBus {

	public static void showArrivalTimeofBus() {
		
		try {
			Scanner sc = new Scanner(System.in);
			
			System.out.println("____________________");
			System.out.println("|                  |");
			System.out.println("|  Enter bus id:   |");
			System.out.println("|__________________|");
			int bid = sc.nextInt();
			
			AdminDao dao = new AdminDaoImpl();
			
			System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++");
			System.out.println(dao.showArrivalTimeofBus(bid));
			System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++");
			
			System.out.println("==================================================");
			
			AdminLoginInterface.adminLoginInterface();
			sc.close();
		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
	}

}
