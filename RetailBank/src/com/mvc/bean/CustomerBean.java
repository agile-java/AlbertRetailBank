package com.mvc.bean;

public class CustomerBean {
	private int customerid;
	private int ssnid;
	private String customername;
	private int age;
	private String address;
	private String state; 
	private String city;
	
	
	
	public CustomerBean(int customerid, int ssnid, String customername, int age, String address, String state,
			String city) {
		super();
		this.customerid = customerid;
		this.ssnid = ssnid;
		this.customername = customername;
		this.age = age;
		this.address = address;
		this.state = state;
		this.city = city;
	}
	public CustomerBean() {
		super();
		
	}
	public int getCustomerid() {
		return customerid;
	}
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}
	
	
	public int getSsnid() {
		return ssnid;
	}
	public void setSsnid(int ssnid) {
		this.ssnid = ssnid;
	}
	public String getCustomername() {
		return customername;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	

}
