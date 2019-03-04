package com.student.fhms.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;

@Entity
public class Purchase {
	private int id;
	private Customer customer;
	private List<Cow> cows;
	private Date purchaseDate;
	private Double price;
	private String description;
	public Purchase() {
		
	}
	public Purchase(Customer customer, List<Cow> cows, Date purchaseDate, Double price, String description) {
		this.customer = customer;
		this.cows = cows;
		this.purchaseDate = purchaseDate;
		this.price = price;
		this.description = description;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public List<Cow> getCows() {
		return cows;
	}
	public void setCows(List<Cow> cows) {
		this.cows = cows;
	}
	public Date getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Purchase [id=" + id + ", customer=" + customer + ", cows=" + cows + ", purchaseDate=" + purchaseDate
				+ ", price=" + price + ", description=" + description + "]";
	}
	
	
	

}
