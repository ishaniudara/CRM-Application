package com.luv2code.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;
@Service
public class CustomerServiceImpl implements CustomerService {
@Autowired
private CustomerDAO customerDAO;
@Override
	@Transactional
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		return customerDAO.getCustomers();
		
		
		
	}
@Override
	@Transactional
	public void savecustomer(Customer thecustomer) {
		customerDAO.savecustomer(thecustomer);
		
		
		
	}
@Override
@Transactional
public Customer getCustomer(int theid) {
	 return customerDAO.getcustomer(theid);
	
	// TODO Auto-generated method stub

}
@Override
@Transactional
public void deletecustomer(int theid) {
	  customerDAO.deletecustomer(theid);
	
	
}
}
