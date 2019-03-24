package com.student.fhms.dto;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import com.student.fhms.entity.Customer;
import com.student.fhms.entity.Purchase;

public class PurchaseDTO {
	private int purchaseId;
	@NotNull(message="Select Cow")
	private Integer cowId;
	private int customerId;
	@NotNull(message="Enter NIC Card")
	private String nic;
	@NotNull(message="Enter First Name")
	@Pattern(regexp="[a-zA-Z]+",message="Enter Correct First Name")
	private String firstName;
	@NotNull(message="Enter Last Name")
	@Pattern(regexp="[a-zA-Z]+",message="Enter Correct Last Name")
	private String lastName;
	private String address;
	@NotNull(message="Select Purchase Date")
	@Past(message="Select Correct Date")
	private Date purchaseDate;
	@NotNull(message="Enter Purchase Price")
	private Double price;
	private String description;

	public PurchaseDTO() {

	}

	public int getPurchaseId() {
		return purchaseId;
	}

	public void setPurchaseId(int purchaseId) {
		this.purchaseId = purchaseId;
	}

	public Integer getCowId() {
		return cowId;
	}

	public void setCowId(Integer cowId) {
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

	public Customer getCustomer() {
		Customer customer = new Customer();
		customer.setId(customerId);
		customer.setFirstName(firstName);
		customer.setLastName(lastName);
		customer.setNic(nic);
		customer.setAddress(address);

		return customer;
	}

	public Purchase getPurchase() {
		Purchase purchase = new Purchase();

		purchase.setId(purchaseId);
		
//		Date pDate = null;
//		try {
//			DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//			pDate = formatter.parse(purchaseDate);
//
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		purchase.setPurchaseDate(pDate);
		purchase.setPurchaseDate(purchaseDate);
		purchase.setDescription(description);
		purchase.setPrice(price);

		return purchase;

	}

	public void fillDTO(Purchase purchase,Customer customer,int cowId){
		
		setCowId(cowId);
		// Set Customer in DTO
		 setCustomerId(customer.getId());
		 setNic(customer.getNic());
		 setFirstName(customer.getFirstName());
		 setLastName(customer.getLastName());
		 setAddress(customer.getAddress());
		 
		 // Set Purchase in DTO
		 setPurchaseId(purchase.getId());
		 setPurchaseDate(purchase.getPurchaseDate());
		 // to remove 00:00:00 from date used two extra steps
		 // Added this annotation to remove these two lines @Temporal(TemporalType.DATE)in purchase entity
		 //setPurchaseDate(new SimpleDateFormat("dd-MM-yyyy").format(purchase.getPurchaseDate()));
		 //setPurchaseDate(new SimpleDateFormat("yyyy-MM-dd").format(purchase.getPurchaseDate()));
		// System.out.println("-------------->---fillDTO----------------"+purchaseDate);
		 setPrice(purchase.getPrice());
		 setDescription(purchase.getDescription());
		
	}

}
