package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.exception.BusException;
import com.exception.TicketException;
import com.model.Bus;
import com.model.CustomerTicketDTO;
import com.utility.DBUtil;

public class AdminDaoImpl implements AdminDao{

	@Override
	public String addNewBus(Bus bus) throws BusException{
		String res = "Bus not added";
		
		try (Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("insert into buses(type,dtime,ddate,atime,adate,available_seats,total_seats,source,destination,contact_us,price) values(?,?,?,?,?,?,?,?,?,?,?)");
			
			ps.setString(1, bus.getTypeString());
			ps.setTime(2, java.sql.Time.valueOf(bus.getdTime()));
			ps.setDate(3, java.sql.Date.valueOf(bus.getdDate()));
			ps.setTime(4, java.sql.Time.valueOf(bus.getaTime()));
			ps.setDate(5, java.sql.Date.valueOf(bus.getaDate()));
			ps.setInt(6, bus.getAvailable_seats());
			ps.setInt(7, bus.getTotal_seats());
			ps.setString(8, bus.getSource());
			ps.setString(9, bus.getDestination());
			ps.setString(10, bus.getContact());
			ps.setInt(11, bus.getPrice());

			int x = ps.executeUpdate();
			if(x>0) res = "Bus added successfully...";
		} catch (Exception e) {
			throw new BusException(e.getMessage());
		}
		
		return res;
	}

	

	@Override
	public Bus showBusDetails(int bid) throws BusException {
		Bus bus = new Bus();
		try (Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("select * from buses  where bid=?");
			ps.setInt(1, bid);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				bus.setBid(bid);
				bus.setTypeString(rs.getString("type"));
				bus.setaTime(rs.getTime("atime").toLocalTime());
				bus.setaDate(rs.getDate("atime").toLocalDate());
				bus.setdTime(rs.getTime("dtime").toLocalTime());
				bus.setdDate(rs.getDate("ddate").toLocalDate());
				bus.setAvailable_seats(rs.getInt("available_seats"));
				bus.setTotal_seats(rs.getInt("total_seats"));
				bus.setSource(rs.getString("source"));
				bus.setDestination(rs.getString("destination"));
				bus.setContact(rs.getString("contact_us"));
				bus.setPrice(rs.getInt("price"));
				
			}
			
		} catch (Exception e) {
			throw new BusException(e.getMessage());
		}
		return bus;
	}

	@Override
	public LocalDateTime showArrivalTimeofBus(int bid) throws BusException {
		// TODO Auto-generated method stub
		LocalDateTime arrival = null;
		try (Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("select atime, adate from buses  where bid=?");
			ps.setInt(1, bid);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				
				LocalTime time = rs.getTime("atime").toLocalTime();
				LocalDate date = rs.getDate("adate").toLocalDate();
				arrival = LocalDateTime.of(date, time);
				
			}
			
		} catch (Exception e) {
			throw new BusException(e.getMessage());
		}
		return arrival;
	}

	@Override
	public LocalDateTime showDepartureTimeofBus(int bid) throws BusException {
		LocalDateTime departure = null;
		try (Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("select dtime, ddate from buses  where bid=?");
			ps.setInt(1, bid);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				
				LocalTime time = rs.getTime("dtime").toLocalTime();
				LocalDate date = rs.getDate("ddate").toLocalDate();
				departure = LocalDateTime.of(date, time);
				
			}
			
		} catch (Exception e) {
			throw new BusException(e.getMessage());
		}
		return departure;
	}

	@Override
	public String showBusRoute(int bid) throws BusException {
		String route = null;
		try (Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("select source, destination from buses where bid=?");
			ps.setInt(1, bid);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				
				route = rs.getString("source") + " to " + rs.getString("destination");
				
			}
			
		} catch (Exception e) {
			throw new BusException(e.getMessage());
		}
		return route;
	}

	@Override
	public CustomerTicketDTO showTicketDetails(int seat_no, int bid) throws TicketException {
		CustomerTicketDTO dto = new CustomerTicketDTO();
		
		try (Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("select c.cname, c.contact, t.bid, t.seat_no, t.source, t.destination from customers c inner join tickets t on c.cid=t.cid and t.seat_no=? and t.bid=?");
			ps.setInt(1, seat_no);
			ps.setInt(2, bid);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				
				dto.setCname(rs.getString("c.cname"));
				dto.setContact(rs.getString("c.contact"));
				dto.setBid(bid);
				dto.setSeat_no(seat_no);
				dto.setSource(rs.getString("t.source"));
				dto.setDestination(rs.getString("t.destination"));
				
			}
			
		} catch (Exception e) {
			throw new TicketException(e.getMessage());
		}
		
		return dto;
	}

	@Override
	public List<CustomerTicketDTO> showCustomerDetailsInTheBus(int bid) throws BusException {
		List<CustomerTicketDTO> list = new ArrayList<>();
		
		
		
		try (Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("select c.cname, c.contact, t.bid, t.seat_no, t.source, t.destination from customers c inner join tickets t on c.cid=t.cid and t.bid=?");
			ps.setInt(1, bid);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				CustomerTicketDTO dto = new CustomerTicketDTO();
				dto.setCname(rs.getString("c.cname"));
				dto.setContact(rs.getString("c.contact"));
				dto.setBid(rs.getInt("t.bid"));
				dto.setSeat_no(rs.getInt("t.seat_no"));
				dto.setSource(rs.getString("t.source"));
				dto.setDestination(rs.getString("t.destination"));
				list.add(dto);
			}
			
		} catch (Exception e) {

			throw new BusException(e.getMessage());
		}
		
		return list;
	}

	@Override
	public int noOfSeatsAvailable(int bid) throws BusException{
		int seats = 0;
		
		try (Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("select available_seats from buses where bid=?");
			ps.setInt(1, bid);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				
				seats = rs.getInt("available_seats");
				
			}
			
		} catch (Exception e) {
			throw new BusException(e.getMessage());
		}
		
		return seats;
	}



	@Override
	public boolean adminLogin(int id, String pass) {
		boolean res = false;
		
		if(id == 1234 && pass.equals("@1234")) res = true;
		
		return res;
	}

}
