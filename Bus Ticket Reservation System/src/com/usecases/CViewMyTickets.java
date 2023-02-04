package com.usecases;

import java.util.List;

import com.dao.CustomerDao;
import com.dao.CustomerDaoImpl;
import com.model.Ticket;

public class CViewMyTickets {

	public static void viewMyTickets(int cid) {
		// TODO Auto-generated method stub

		try {
			
			CustomerDao dao = new CustomerDaoImpl();
			List<Ticket> list= dao.viewMyTickets(cid);
			if(list.size() == 0) {
				System.out.println("No bookings yet...");
			}else {
				list.forEach(t -> System.out.println(t));
			}
			System.out.println("=============================");
			CustomerLoginInterface.customerLoginInterface(cid);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

}
