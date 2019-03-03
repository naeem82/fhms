package com.student.fhms.entity;

import javax.persistence.Entity;

@Entity
public class Customer {
	private int id;
	private String firstName;
	private String lastName;
	private String nic;
	private String address;
	public Customer(){
		
	}
	public Customer(String firstName, String lastName, String nic, String address) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.nic = nic;
		this.address = address;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getNic() {
		return nic;
	}
	public void setNic(String nic) {
		this.nic = nic;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", nic=" + nic
				+ ", address=" + address + "]";
	}
	
	

}
