package com.student.fhms.dao;

import java.util.List;


import com.student.fhms.entity.Customer;

public interface CustomerDAO {
	
	public List<Customer> getCustomers();
	public Customer getCustomer(int id);
	public void saveCustomer(Customer customer);
	public void deleteCustomer(int id);
	public List<Customer> searchCustomer(String theSearchName);

}
