package com.dao;

import java.time.LocalDateTime;
import java.util.List;

import com.exception.BusException;
import com.exception.TicketException;
import com.model.Bus;
import com.model.CustomerTicketDTO;

public interface AdminDao {
	
	public boolean adminLogin(int id, String pass);
	
	public String addNewBus(Bus bus) throws BusException;
	
	public Bus showBusDetails(int bid) throws BusException;
	
	public LocalDateTime showArrivalTimeofBus(int bid) throws BusException;

	public LocalDateTime showDepartureTimeofBus(int bid) throws BusException;
	
	public String showBusRoute(int bid) throws BusException;
	
	public CustomerTicketDTO showTicketDetails(int seat_no, int bid) throws TicketException;
	
	public List<CustomerTicketDTO> showCustomerDetailsInTheBus(int bid) throws BusException;

	public int noOfSeatsAvailable(int bid) throws BusException;
	
}
