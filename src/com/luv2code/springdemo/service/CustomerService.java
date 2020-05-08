package com.luv2code.springdemo.service;

import java.util.List;

import com.luv2code.springdemo.entity.Customer;

public interface CustomerService {
	
	
	public List<Customer> getCustomers();

	

	public void savecustomer(Customer thecustomer);
		// TODO Auto-generated method stub



	public Customer getCustomer(int theid);



	public void deletecustomer(int theid);
		
	


}
