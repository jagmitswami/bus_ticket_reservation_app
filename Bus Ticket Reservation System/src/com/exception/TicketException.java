package com.exception;

@SuppressWarnings("serial")
public class TicketException extends Exception{

	public TicketException() {
		
	}
	
	public TicketException(String msg){
		super(msg);
	}
}
