package com.student.fhms.entity;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="sale")
public class Sale {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@OneToOne(fetch=FetchType.EAGER,cascade={CascadeType.DETACH,
											 CascadeType.MERGE,
											 CascadeType.PERSIST,
											 CascadeType.REFRESH})
	@JoinColumn(name="customer_id")	
	private Customer customer;
	
	@OneToMany(fetch=FetchType.LAZY,cascade={CascadeType.DETACH,
											 CascadeType.MERGE,
											 CascadeType.PERSIST,
											 CascadeType.REFRESH})
	@JoinColumn(name="sale_id")
	private List<Cow> cows;
	@Temporal(TemporalType.DATE)
	@Column(name="sale_date")
	private Date saleDate;
	@Column(name="sale_price")
	private double salePrice;
	@Column(name="description")
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
	public void addCow(Cow cow){
		if(cows==null){
			cows=new LinkedList<>();
		}
		cows.add(cow);
	}
	
	

}
