package com.mvc.bean;

public class AccountstatusBean {

	private int statusid;
	private int customerid;
	private int account_id;
	private String accounttype;
	private String status;
	private String message;
	private String last_update;
	
	public AccountstatusBean(int statusid, int customerid, int account_id, String accounttype, String status,
			String message, String last_update) {
		super();
		this.statusid = statusid;
		this.customerid = customerid;
		this.account_id = account_id;
		this.accounttype = accounttype;
		this.status = status;
		this.message = message;
		this.last_update = last_update;
	}
	public AccountstatusBean() {
		
	}
	public int getStatusid() {
		return statusid;
	}
	public void setStatusid(int statusid) {
		this.statusid = statusid;
	}
	public int getCustomerid() {
		return customerid;
	}
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}
	public int getAccount_id() {
		return account_id;
	}
	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}
	public String getAccounttype() {
		return accounttype;
	}
	public void setAccounttype(String accounttype) {
		this.accounttype = accounttype;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getLast_update() {
		return last_update;
	}
	public void setLast_update(String last_update) {
		this.last_update = last_update;
	}
	
	
}
