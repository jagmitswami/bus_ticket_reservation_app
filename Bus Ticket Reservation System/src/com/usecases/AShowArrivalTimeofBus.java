package com.usecases;

import java.util.Scanner;

import com.dao.AdminDao;
import com.dao.AdminDaoImpl;

public class AShowArrivalTimeofBus {

	public static void showArrivalTimeofBus() {
		
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter bus id: ");
			int bid = sc.nextInt();
			
			AdminDao dao = new AdminDaoImpl();
			System.out.println(dao.showArrivalTimeofBus(bid));
			
			System.out.println("=================================");
			AdminLoginInterface.adminLoginInterface();
			sc.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

}
