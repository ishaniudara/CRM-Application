package com.luv2code.springdemo.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.entity.Customer;
@Repository
public class CutomerDAOImpl implements CustomerDAO {
	@Autowired
	private SessionFactory sesssionFactory;
 
	@Override
	public List<Customer> getCustomers() {
		
		// TODO Auto-generated method stub
	
		Session currentsession= sesssionFactory.getCurrentSession();
		
		Query<Customer> thequery=currentsession.createQuery("from Customer order by lastName", Customer.class);
		List<Customer> customers=thequery.getResultList();
		
		
		return customers;
	}

	@Override
	public void savecustomer(Customer thecustomer) {
		Session currentsession=sesssionFactory.getCurrentSession();
		currentsession.saveOrUpdate(thecustomer);
		// TODO Auto-generated method stub
		
	}

	@Override
	public Customer getcustomer(int theid) {
	
		Session currentsession=sesssionFactory.getCurrentSession();
		Customer thecustomer=currentsession.get(Customer.class, theid);
		return thecustomer;
	}

	@Override
	public void deletecustomer(int theid) {
 
		Session currentsession=sesssionFactory.getCurrentSession();
		Query thequery=currentsession.createQuery("delete from Customer where id=:customerid");
	    thequery.setParameter("customerid", theid);
		thequery.executeUpdate();
		
	}

}
