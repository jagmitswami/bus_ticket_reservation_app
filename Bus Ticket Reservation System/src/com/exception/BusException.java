package com.exception;

@SuppressWarnings("serial")
public class BusException extends Exception{

	public BusException() {
		
	}
	
	public BusException(String msg){
		super(msg);
	}
}
