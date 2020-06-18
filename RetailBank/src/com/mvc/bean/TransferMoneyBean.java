package com.mvc.bean;

public class TransferMoneyBean 
{

	private String sourceCustomerId;
	private String targetCustomerId;
	private String sourceAccountId;
	private String targetAccountId;
	private String accountType;
	private double sourceAccountBalance;
	private double targetAccountBalance;
	private double transferMoney;
	
	public void setSourceCustomerId(String sourceCustomerId){
	 	this.sourceCustomerId=sourceCustomerId;
	 }
	
	 public String getSourceCustomerId(){
	 	return sourceCustomerId;
	 }
	
	 public void setTargetCustomerId(String targetCustomerId){
		 	this.targetCustomerId=targetCustomerId;
		 }
		
		 public String getTargetCustomerId(){
		 	return targetCustomerId;
		 }
		
	 
	 public void setSourceAccountId(String sourceAccountId){
	 	this.sourceAccountId=sourceAccountId;
	 }
	
	 public String getSourceAccountId(){
	 	return sourceAccountId;
	 }
	
	 public void setTargetAccountId(String targetAccountId){
		 	this.targetAccountId=targetAccountId;
		 }
		
		 public String getTargetAccountId(){
		 	return targetAccountId;
		 }
	 public void setAccountType(String accountType){
	 	this.accountType=accountType;
	 }
	
	 public String getAccountType(){
	 	return accountType;
	 }
	
	 public void setSourceAccountBalance(double sourceAccountBalance){
	 	this.sourceAccountBalance=sourceAccountBalance;
	 }
	
	 public double getSourceAccountBalance(){
	 	return sourceAccountBalance;
	 }
	 
	 public void setTargetAccountBalance(double targetAccountBalance){
		 	this.targetAccountBalance=targetAccountBalance;
		 }
		
		 public double getTargetAccountBalance(){
		 	return targetAccountBalance;
		 
		 	
		 	
		 }
		 public void setTransferMoney(double transferMoney){
			 	this.transferMoney=transferMoney;
			 }
			
			 public double getTransferMoney(){
			 	return transferMoney;
			 }
		 
	 
	 
	
}	
		 


