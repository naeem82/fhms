package com.student.fhms.dto;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import com.student.fhms.entity.Customer;
import com.student.fhms.entity.Purchase;
import com.student.fhms.entity.Sale;

public class SaleDTO {

	private int saleId;
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
	@NotNull(message="Select Sale Date")
	@Past(message="Select Correct Date")
	private Date saleDate;
	@NotNull(message="Enter Sale Price")
	private Double salePrice;
	private String description;

	public SaleDTO() {

	}

	public int getSaleId() {
		return saleId;
	}

	public void setSaleId(int saleId) {
		this.saleId = saleId;
	}

	public Date getSaleDate() {
		return saleDate;
	}

	public void setSaleDate(Date saleDate) {
		this.saleDate = saleDate;
	}

	public Double getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(Double salePrice) {
		this.salePrice = salePrice;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public Sale getSale() {
		Sale sale = new Sale();

		sale.setId(saleId);
		
//		Date sDate = null;
//		try {
//			DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//			sDate = formatter.parse(saleDate);
//
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		sale.setSaleDate(sDate);
		sale.setSaleDate(saleDate);
		sale.setDescription(description);
		sale.setSalePrice(salePrice);

		return sale;

	}

	public void fill(Sale sale, Customer customer, int cowId) {

		setCowId(cowId);
		// Set Customer in DTO
		setCustomerId(customer.getId());
		setNic(customer.getNic());
		setFirstName(customer.getFirstName());
		setLastName(customer.getLastName());
		setAddress(customer.getAddress());

		// Set Purchase in DTO
		setSaleId(sale.getId());
		setSaleDate(sale.getSaleDate());
		
		// SimpleDateFormat("dd-MM-yyyy").format(purchase.getPurchaseDate()));
		
		// SimpleDateFormat("yyyy-MM-dd").format(purchase.getPurchaseDate()));

		setSalePrice(sale.getSalePrice());
		setDescription(sale.getDescription());

	}

}
