package com.model;

public class Ticket {

	private int bid;
	private int cid;
	private String name;
	private int seat_no;
	private String contact_us;
	private String source;
	private String destination;
	
	@Override
	public String toString() {
		return "Ticket [bid=" + bid + ", cid=" + cid + ", name=" + name + ", seat_no=" + seat_no + ", contact_us="
				+ contact_us + ", source=" + source + ", destination=" + destination + "]";
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSeat_no() {
		return seat_no;
	}
	public void setSeat_no(int seat_no) {
		this.seat_no = seat_no;
	}
	public String getContact_us() {
		return contact_us;
	}
	public void setContact_us(String contact_us) {
		this.contact_us = contact_us;
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
	
	
	
	
}
