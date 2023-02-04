package com.model;

public class Customer {

	private int cid;
	private transient String cpass;
	private String cname;
	private String contact;
	
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCpass() {
		return cpass;
	}
	public void setCpass(String cpass) {
		this.cpass = cpass;
	}
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
	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", cname=" + cname + ", contact=" + contact + "]";
	}
	public Customer(int cid, String cpass, String cname, String contact) {
		super();
		this.cid = cid;
		this.cpass = cpass;
		this.cname = cname;
		this.contact = contact;
	}
	public Customer() {
		// TODO Auto-generated constructor stub
	}
	
	
}
