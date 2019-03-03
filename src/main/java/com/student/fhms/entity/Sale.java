package com.student.fhms.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;

@Entity
public class Sale {
	private int id;
	private Customer customer;
	private List<Cow> cows;
	private Date saleDate;
	private double salePrice;
	private String description;
	public Sale(){
		
	}
	public Sale(Customer customer, List<Cow> cows, Date saleDate, double salePrice, String description) {
		this.customer = customer;
		this.cows = cows;
		this.saleDate = saleDate;
		this.salePrice = salePrice;
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
	public Date getSaleDate() {
		return saleDate;
	}
	public void setSaleDate(Date saleDate) {
		this.saleDate = saleDate;
	}
	public double getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(double salePrice) {
		this.salePrice = salePrice;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Sale [id=" + id + ", customer=" + customer + ", cows=" + cows + ", saleDate=" + saleDate
				+ ", salePrice=" + salePrice + ", description=" + description + "]";
	}
	
	

}
