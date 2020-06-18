package com.mvc.bean;

public class WithdrawlMoneyBean 
{

	private String customerId;	
	private String accountId;
	private String accountType;
	private double balance;
	
	public void setCustomerId(String customerId){
	 	this.customerId=customerId;
	 }
	
	 public String getCustomerId(){
	 	return customerId;
	 }
	
	 public void setAccountId(String accountId){
	 	this.accountId=accountId;
	 }
	
	 public String getAccountId(){
	 	return accountId;
	 }
	
	 public void setAccountType(String accountType){
	 	this.accountType=accountType;
	 }
	
	 public String getAccountType(){
	 	return accountType;
	 }
	
	 public void setBalance(double balance){
	 	this.balance=balance;
	 }
	
	 public double getBalance(){
	 	return balance;
	 }
	
}	
		 


