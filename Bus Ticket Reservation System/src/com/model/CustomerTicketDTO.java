package com.model;

public class CustomerTicketDTO {

	private String cname;
	private String contact;
	
	private int bid;
	private int seat_no;
	
	private String source;
	private String destination;
	
	
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public int getSeat_no() {
		return seat_no;
	}
	public void setSeat_no(int seat_no) {
		this.seat_no = seat_no;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	@Override
	public String toString() {
		return "CustomerTicketDTO [cname=" + cname + ", contact=" + contact + ", bid=" + bid + ", seat_no=" + seat_no
				+ ", source=" + source + ", destination=" + destination + "]";
	}
	public CustomerTicketDTO(String cname, String contact, int bid, int seat_no, String source, String destination) {
		super();
		this.cname = cname;
		this.contact = contact;
		this.bid = bid;
		this.seat_no = seat_no;
		this.source = source;
		this.destination = destination;
	}
	public CustomerTicketDTO() {
		// TODO Auto-generated constructor stub
	}
	
	
}
