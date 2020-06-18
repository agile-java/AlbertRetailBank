package com.mvc.bean;

public class CashierCustomerBean {
	
	private String customerId;
	private String ssnId;
	private String accountId;
	private String customerName;
	private double balance;
	private String accountType;
	
	public CashierCustomerBean() {
		super();
		
	}
	
	
	
	public CashierCustomerBean(String customerId,String ssnId,String accountId,String customerName, double balance,String accountType) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.ssnId = ssnId;
		this.accountId = accountId;
		this.customerName = customerName;
		this.balance = balance;
		this.accountType = accountType;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getSsnId() {
		return ssnId;
	}
	public void setSsnId(String ssnId) {
		this.ssnId = ssnId;
	}
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	
	
	
	
	}