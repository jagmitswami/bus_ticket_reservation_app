package com.dao;

import java.time.LocalDate;
import java.util.List;

import com.exception.BusException;
import com.exception.CustomerException;
import com.exception.TicketException;
import com.model.Bus;
import com.model.Ticket;

public interface CustomerDao {
	
	public String registerCustomer(String cname, String cpass, String contact_no) throws CustomerException;
	
	public boolean logInCustomer(int cid, String cpass) throws CustomerException;

	public List<Ticket> viewMyTickets(int cid) throws TicketException;
	
	public String cancelTicket(int cid, int bid,  int seat_no) throws TicketException;

	public String changePassword(int cid,  String current_pass, String new_password) throws CustomerException;
	
	public List<Bus> showAllBusesOnDate(LocalDate date, String source, String destination);

	public String bookTicket(int bid, int cid) throws BusException;
}
