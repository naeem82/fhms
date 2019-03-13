package com.student.fhms.dto;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.student.fhms.entity.Customer;
import com.student.fhms.entity.Purchase;
import com.student.fhms.entity.Sale;

public class SaleDTO {
	
	
	private int saleId;
	private int cowId;
	private int customerId;
	private String nic;
	private String firstName;
	private String lastName;
	private String address;
	private String saleDate;
	private double salePrice;
	private String description;
	public SaleDTO() {
		
	}
	
	
	public int getSaleId() {
		return saleId;
	}


	public void setSaleId(int saleId) {
		this.saleId = saleId;
	}


	public String getSaleDate() {
		return saleDate;
	}


	public void setSaleDate(String saleDate) {
		this.saleDate = saleDate;
	}


	public double getSalePrice() {
		return salePrice;
	}


	public void setSalePrice(double salePrice) {
		this.salePrice = salePrice;
	}


	public void setAddress(String address) {
		this.address = address;
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
	public Sale getSale(){
		Sale sale=new Sale();
		
		
		sale.setId(saleId);
		DateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
		Date sDate=null;
		try {
			 sDate=formatter.parse(saleDate);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sale.setSaleDate(sDate);
		sale.setDescription(description);
		sale.setSalePrice(salePrice);
		
		
		return sale;
		
	}
	

}
