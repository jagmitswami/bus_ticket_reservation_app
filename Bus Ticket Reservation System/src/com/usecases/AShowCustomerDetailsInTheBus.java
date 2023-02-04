package com.usecases;

import java.util.List;
import java.util.Scanner;

import com.dao.AdminDao;
import com.dao.AdminDaoImpl;
import com.model.CustomerTicketDTO;

public class AShowCustomerDetailsInTheBus {

	public static void showCustomerDetailsInTheBus() {
		// TODO Auto-generated method stub
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter bus id: ");
			int bid = sc.nextInt();
			AdminDao dao = new AdminDaoImpl();
			List<CustomerTicketDTO> dto= dao.showCustomerDetailsInTheBus(bid);
			
			if(dto.size()==0) System.out.println("No enteries found...");
			else dto.forEach(p -> System.out.println(p));


			System.out.println("=================================");
			AdminLoginInterface.adminLoginInterface();
			sc.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

}
