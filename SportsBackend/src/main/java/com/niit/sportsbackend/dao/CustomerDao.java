package com.niit.sportsbackend.dao;

import java.util.List;

import com.niit.sportsbackend.model.Customer;



public interface CustomerDao {
	public boolean addCustomer(Customer customer);
	public boolean updateCustomer(Customer customer);
	public boolean deleteCustomer(int customerId);
	public List<Customer>getAllCustomer();
	public Customer getCustomerById(int customerId);

}
