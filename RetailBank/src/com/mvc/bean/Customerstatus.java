package com.mvc.bean;

public class Customerstatus {
private int statusid;
private int ssnid;
private int customerid;
String status;
String message;
String lastdate;

public Customerstatus(int statusid, int ssnid, int customerid, String status, String message, String lastdate) {
	super();
	this.statusid = statusid;
	this.ssnid = ssnid;
	this.customerid = customerid;
	this.status = status;
	this.message = message;
	this.lastdate = lastdate;
}
public int getStatusid() {
	return statusid;
}
public void setStatusid(int statusid) {
	this.statusid = statusid;
}
public int getSsnid() {
	return ssnid;
}
public void setSsnid(int ssnid) {
	this.ssnid = ssnid;
}
public int getCustomerid() {
	return customerid;
}
public void setCustomerid(int customerid) {
	this.customerid = customerid;
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
public String getLastdate() {
	return lastdate;
}
public void setLastdate(String lastdate) {
	this.lastdate = lastdate;
}

}
