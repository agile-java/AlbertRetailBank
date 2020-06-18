package com.mvc.bean;

public class TransactionBean 
{

	private String accountId;
	private String customerId;
	private String transactionType;
	private double amount;
	
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
	
	 public void setTransactionType(String transactionType){
		 	this.transactionType=transactionType;
		 }
		
		 public String getTransactionType(){
		 	return transactionType;
		 }
	 public void setAmount(double depositAmount){
	 	this.amount=depositAmount;
	 }
	
	 public double getAmount(){
	 	return amount;
	 }
	
}	
		 


