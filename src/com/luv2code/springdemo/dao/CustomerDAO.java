package com.luv2code.springdemo.dao;

import java.util.List;

import com.luv2code.springdemo.entity.Customer;

public interface CustomerDAO {
	
	
	public List<Customer> getCustomers();

	public void savecustomer(Customer thecustomer);

	public Customer getcustomer(int theid);

	public void deletecustomer(int theid);
	

	
	
}
