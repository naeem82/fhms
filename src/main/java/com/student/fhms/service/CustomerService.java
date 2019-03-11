package com.student.fhms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.student.fhms.entity.Customer;

public interface CustomerService {
	public List<Customer> getCustomers();
	public Customer getCustomer(int id);
	public void saveCustomer(Customer customer);
	public void deleteCustomer(int id);
	public List<Customer> searchCustomer(String theSearchName);

}
