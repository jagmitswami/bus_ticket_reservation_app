package com.exception;

@SuppressWarnings("serial")
public class CustomerException extends Exception{

	public CustomerException() {
			
		}
		
	 public CustomerException(String msg){
			super(msg);
		}
}
