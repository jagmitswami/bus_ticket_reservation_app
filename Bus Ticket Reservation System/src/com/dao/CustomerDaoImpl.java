package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.exception.BusException;
import com.exception.CustomerException;
import com.exception.TicketException;
import com.model.Bus;
import com.model.Ticket;
import com.utility.DBUtil;

public class CustomerDaoImpl implements CustomerDao{

	@Override
	public String registerCustomer(String cname, String cpass, String contact_no) throws CustomerException {
		String res = "Not registered...";
		
		try (Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("insert into customers(cname,cpass,contact) values(?,?,?)");
			
			ps.setString(1, cname);
			ps.setString(2, cpass);
			ps.setString(3, contact_no);

			int x = ps.executeUpdate();
			if(x>0) res = "Registered successfully...";
		} catch (SQLException e) {
			throw new CustomerException(e.getMessage());
		}
		
		return res;
	}
	
	@Override
	public boolean logInCustomer(int cid, String cpass) throws CustomerException{
		// TODO Auto-generated method stub
		boolean res = false;
		
		try(Connection conn = DBUtil.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement("select cname from customers where cid=? and cpass=?");
			
			ps.setInt(1, cid);
			ps.setString(2, cpass);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				res = true;
			}
				
			
		} catch (Exception e) {
			throw new CustomerException(e.getMessage());
		}
		
		return res;
	}

	@Override
	public List<Ticket> viewMyTickets(int cid) throws TicketException {
		List<Ticket> list = new ArrayList<>();
		
		try (Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("select cname, cid, bid, seat_no, source, destination, contact from tickets where cid=?");
			ps.setInt(1, cid);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Ticket dto = new Ticket();
				dto.setName(rs.getString("cname"));
				dto.setContact_us(rs.getString("contact"));
				dto.setBid(rs.getInt("bid"));
				dto.setCid(rs.getInt("cid"));
				dto.setSeat_no(rs.getInt("seat_no"));
				dto.setSource(rs.getString("source"));
				dto.setDestination(rs.getString("destination"));
				list.add(dto);
			}
			
		} catch (Exception e) {

			throw new TicketException(e.getMessage());
		}
		
		return list;
	}

	@Override
	public String bookTicket(int bid, int cid) throws BusException{
		String res= "Can't book ticket at the moment...";
		
		try(Connection conn = DBUtil.provideConnection()) {
			System.out.println(bid);
			PreparedStatement ps1 = conn.prepareStatement("select available_seats from buses where bid=?");
			ps1.setInt(1, bid);
			ResultSet rs1= ps1.executeQuery();
			int s = 0;
			if(rs1.next()) {
				s = rs1.getInt("available_seats");
			}
			
			
			if(s>0) {
				Ticket dto = new Ticket();
				PreparedStatement ps2 =conn.prepareStatement("select source, destination, contact_us from buses where bid=?");
				ps2.setInt(1, bid);
				ResultSet rs2 = ps2.executeQuery();
				
				String source = "";
				String destination = "";
				String contact = "";
				if(rs2.next()) {
					source = rs2.getString("source");
					destination = rs2.getString("destination");
					contact = rs2.getString("contact_us");
				}
				
				PreparedStatement ps3 =conn.prepareStatement("select cname from customers where cid=?");
				ps3.setInt(1, cid);
				ResultSet rs3 = ps3.executeQuery();
				
				String cname ="";
				if(rs3.next()) {
					cname= rs3.getString("cname");
				}
				
				dto.setName(cname);
				dto.setBid(bid);
				dto.setCid(cid);
				dto.setSeat_no(s);
				dto.setSource(source);
				dto.setDestination(destination);
				dto.setContact_us(contact);
				
				PreparedStatement ps = conn.prepareStatement("insert into tickets(bid, cid, seat_no, contact, source, destination, cname) values(?,?,?,?,?,?,?)");
				ps.setInt(1, bid);
				ps.setInt(2, cid);
				ps.setInt(3, s);
				ps.setString(4, contact);
				ps.setString(5, source);
				ps.setString(6, destination);
				ps.setString(7, cname);
				int x = ps.executeUpdate();
				if(x>0) res = "Ticket booked successfully" + dto;
				
				
				PreparedStatement ps4 = conn.prepareStatement("update buses set available_seats=? where bid=?");
				ps4.setInt(1, s-1);
				ps4.setInt(2, bid);
				ps4.executeUpdate();
				
				
			}
				
			
		} catch (Exception e) {
			throw new BusException(e.getMessage());
		}
		return res;
		
	}

	@Override
	public String cancelTicket(int cid, int bid, int seat_no) throws TicketException {
		String res= "Can't cancel ticket at the moment...";
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps2 =conn.prepareStatement("delete from tickets where seat_no=? and bid=?");
			ps2.setInt(1, seat_no);
			ps2.setInt(2, bid);
			int y = ps2.executeUpdate();
				
			if(y>0) {
				PreparedStatement ps4 = conn.prepareStatement("update buses set available_seats=available_seats+1 where bid=?");
				ps4.setInt(1, bid);
				int x = ps4.executeUpdate();
				
				if(x>0) res = "Ticket cancelled successfully";
			}
			
		} catch (Exception e) {
			throw new TicketException(e.getMessage());
		}
		return res;
	}

	@Override
	public String changePassword(int cid, String current_pass, String new_password) throws CustomerException{
		String res = "Password can't be changed...";
		
		try (Connection conn = DBUtil.provideConnection()){

			PreparedStatement ps1 = conn.prepareStatement("select cpass from customers where cid=?");
			ps1.setInt(1, cid);

			ResultSet rs= ps1.executeQuery();
			String password = "";
			if(rs.next()) {
				password = rs.getString("cpass");
			}
			
			if(password.equals(current_pass)) {
				PreparedStatement ps = conn.prepareStatement("update customers set cpass=?");
				
				ps.setString(1, new_password);

				int x = ps.executeUpdate();
				if(x>0) res = "Password changed...";
			}
		} catch (SQLException e) {
			throw new CustomerException(e.getMessage());
		}
		
		return res;
	}

	@Override
	public List<Bus> showAllBusesOnDate(LocalDate date, String source, String destination) {
		List<Bus> list = new ArrayList<>();
		
		try(Connection conn = DBUtil.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement("select * from buses where ddate=? and source=? and destination=?");
			
			ps.setDate(1, java.sql.Date.valueOf(date));
			ps.setString(2, source);
			ps.setString(3, destination);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				LocalDate ddate = rs.getDate("ddate").toLocalDate();
				String bsource= rs.getString("source");
				String bdestination= rs.getString("destination");
				
				if(bdestination.contains(destination) && bsource.contains(source) && ddate.isEqual(date)) {
					Bus bus = new Bus();
					
					bus.setBid(rs.getInt("bid"));
					bus.setTypeString(rs.getString("type"));
					bus.setaTime(rs.getTime("atime").toLocalTime());
					bus.setaDate(rs.getDate("atime").toLocalDate());
					bus.setdTime(rs.getTime("dtime").toLocalTime());
					bus.setdDate(ddate);
					bus.setAvailable_seats(rs.getInt("available_seats"));
					bus.setTotal_seats(rs.getInt("total_seats"));
					bus.setSource(bsource);
					bus.setDestination(bdestination);
					bus.setContact(rs.getString("contact_us"));
					bus.setPrice(rs.getInt("price"));
					
					list.add(bus);
				}
			}
				
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	

	
}
