package com.student.fhms.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name="purchase")
public class Purchase {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@OneToOne(fetch=FetchType.LAZY,cascade={CascadeType.DETACH,
											CascadeType.MERGE,
											CascadeType.PERSIST,
											CascadeType.REFRESH})
	@JoinColumn(name="customer_id")
	private Customer customer;
	@OneToMany(fetch=FetchType.LAZY,cascade={CascadeType.DETACH,
											 CascadeType.MERGE,
											 CascadeType.PERSIST,
											 CascadeType.REFRESH})
	@JoinColumn(name="purchase_id")
	private List<Cow> cows;
	@Column(name="purchase_date")
	private Date purchaseDate;
	@Column(name="price")
	private Double price;
	@Column(name="description")
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
	public void addCow(Cow cow){
		if(cows==null){
			cows=new ArrayList<>();
		}
		cows.add(cow);
	}
	
		
	
	
	
	

}
