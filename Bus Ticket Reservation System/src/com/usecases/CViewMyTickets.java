package com.usecases;

import java.util.List;

import com.dao.CustomerDao;
import com.dao.CustomerDaoImpl;
import com.model.Ticket;

public class CViewMyTickets {

	public static void viewMyTickets(int cid) {


		try {
			
			CustomerDao dao = new CustomerDaoImpl();
			List<Ticket> list= dao.viewMyTickets(cid);
			if(list.size() == 0) {
				
				System.out.println("______________________");
				System.out.println("|                    |");
				System.out.println("|  No bookings yet   |");
				System.out.println("|____________________|");
			}else {

				System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++");
				list.forEach(t -> System.out.println(t));
				System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++");
				
			}
			
			System.out.println("==================================================");
						
			CustomerLoginInterface.customerLoginInterface(cid);
			
		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
	}

}
