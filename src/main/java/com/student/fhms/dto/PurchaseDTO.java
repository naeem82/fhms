package com.student.fhms.dto;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.student.fhms.entity.Customer;
import com.student.fhms.entity.Purchase;

public class PurchaseDTO {
	private int purchaseId;
	private int cowId;
	private int customerId;
	private String nic;
	private String firstName;
	private String lastName;
	private String address;
	private String purchaseDate;
	private double price;
	private String description;
	public PurchaseDTO() {
		
	}
	public int getPurchaseId() {
		return purchaseId;
	}
	public void setPurchaseId(int purchaseId) {
		this.purchaseId = purchaseId;
	}
	public int getCowId() {
		return cowId;
	}
	public void setCowId(int cowId) {
		this.cowId = cowId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getNic() {
		return nic;
	}
	public void setNic(String nic) {
		this.nic = nic;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Customer getCustomer(){
		Customer customer=new Customer();
		customer.setId(customerId);
		customer.setFirstName(firstName);
		customer.setLastName(lastName);
		customer.setNic(nic);
		customer.setAddress(address);
		
		return customer;
	}
	public Purchase getPurchase(){
		Purchase purchase=new Purchase();
		
		
		purchase.setId(purchaseId);
		DateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
		Date pDate=null;
		try {
			 pDate=formatter.parse(purchaseDate);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		purchase.setPurchaseDate(pDate);
		purchase.setDescription(description);
		purchase.setPrice(price);
		
		
		return purchase;
		
	}
	

}
