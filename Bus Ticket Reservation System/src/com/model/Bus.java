package com.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Bus {

	private int bid;
	private String typeString;
	private LocalTime dTime;
	private LocalDate dDate;
	private LocalTime aTime;
	private LocalDate aDate;
	private int available_seats;
	private int total_seats;
	private String source;
	private String destination;
	private String contact;
	private int price;
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getTypeString() {
		return typeString;
	}
	public void setTypeString(String typeString) {
		this.typeString = typeString;
	}
	public LocalTime getdTime() {
		return dTime;
	}
	public void setdTime(LocalTime dTime) {
		this.dTime = dTime;
	}
	public LocalDate getdDate() {
		return dDate;
	}
	public void setdDate(LocalDate dDate) {
		this.dDate = dDate;
	}
	public LocalTime getaTime() {
		return aTime;
	}
	public void setaTime(LocalTime aTime) {
		this.aTime = aTime;
	}
	public LocalDate getaDate() {
		return aDate;
	}
	public void setaDate(LocalDate aDate) {
		this.aDate = aDate;
	}
	public int getAvailable_seats() {
		return available_seats;
	}
	public void setAvailable_seats(int available_seats) {
		this.available_seats = available_seats;
	}
	public int getTotal_seats() {
		return total_seats;
	}
	public void setTotal_seats(int total_seats) {
		this.total_seats = total_seats;
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
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Bus [bid=" + bid + ", typeString=" + typeString + ", dTime=" + dTime + ", dDate=" + dDate + ", aTime="
				+ aTime + ", aDate=" + aDate + ", available_seats=" + available_seats + ", total_seats=" + total_seats
				+ ", source=" + source + ", destination=" + destination + ", contact=" + contact + ", price=" + price
				+ "]";
	}
	public Bus(int bid, String typeString, LocalTime dTime, LocalDate dDate, LocalTime aTime, LocalDate aDate,
			int available_seats, int total_seats, String source, String destination, String contact, int price) {
		super();
		this.bid = bid;
		this.typeString = typeString;
		this.dTime = dTime;
		this.dDate = dDate;
		this.aTime = aTime;
		this.aDate = aDate;
		this.available_seats = available_seats;
		this.total_seats = total_seats;
		this.source = source;
		this.destination = destination;
		this.contact = contact;
		this.price = price;
	}
	public Bus() {
		// TODO Auto-generated constructor stub
	}
	
	
	
}
