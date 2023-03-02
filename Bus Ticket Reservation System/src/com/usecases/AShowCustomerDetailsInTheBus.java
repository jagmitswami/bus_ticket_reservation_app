package com.usecases;

import java.util.List;
import java.util.Scanner;

import com.dao.AdminDao;
import com.dao.AdminDaoImpl;
import com.model.CustomerTicketDTO;

public class AShowCustomerDetailsInTheBus {

	public static void showCustomerDetailsInTheBus() {

		try {
			Scanner sc = new Scanner(System.in);
			
			System.out.println("____________________");
			System.out.println("|                  |");
			System.out.println("|  Enter bus id:   |");
			System.out.println("|__________________|");
			int bid = sc.nextInt();
			AdminDao dao = new AdminDaoImpl();
			List<CustomerTicketDTO> dto= dao.showCustomerDetailsInTheBus(bid);
			
			if(dto.size()==0) {
				
				System.out.println("________________________");
				System.out.println("|                      |");
				System.out.println("|  No enteries found   |");
				System.out.println("|______________________|");
			
			}else {
				
				System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++");
				dto.forEach(p -> System.out.println(p));
				System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++");
			}


			System.out.println("==================================================");
						
			AdminLoginInterface.adminLoginInterface();
			sc.close();
		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
	}

}
