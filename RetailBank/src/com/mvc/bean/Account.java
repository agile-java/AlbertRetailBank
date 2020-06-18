package com.mvc.bean;

public class Account {
	
	private int accountid;
	private int customerid;
	private String Accounttype;
	private double balance;
	private String createdate;
	public Account(int accountid, int customerid, String accounttype, double balance, String createdate) {
		super();
		this.accountid = accountid;
		this.customerid = customerid;
		Accounttype = accounttype;
		this.balance = balance;
		this.createdate = createdate;
	}
	public Account() {
	}
	
	public int getAccountid() {
		return accountid;
	}
	public void setAccountid(int accountid) {
		this.accountid = accountid;
	}
	public int getCustomerid() {
		return customerid;
	}
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}
	public String getAccounttype() {
		return Accounttype;
	}
	public void setAccounttype(String accounttype) {
		Accounttype = accounttype;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getCreatedate() {
		return createdate;
	}
	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}

}
