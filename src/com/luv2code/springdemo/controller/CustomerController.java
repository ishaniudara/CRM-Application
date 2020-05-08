package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	
	private CustomerService customerservice;
	@GetMapping("/list")
	public String listcustomer(Model themodel) {
		
		List<Customer> thecustomers=customerservice.getCustomers();
		
		themodel.addAttribute("customers",thecustomers);
		
	
		return "list-customer";
	}
 @GetMapping("/ShowFormForAdd")
 public String ShowFormForAdd(Model themodel ) {
	 Customer thecustomer=new Customer();
	 themodel.addAttribute("customer", thecustomer);
	 return "customer-form";
 }
 @PostMapping("/savecustomer")
 public String savecustomer(@ModelAttribute("customer") Customer thecustomer) {
	 customerservice.savecustomer(thecustomer);
	 
	 return "redirect:/customer/list";
	 
 }
 @GetMapping("/showformupdate")
 public String showformupdate(@RequestParam("customerid") int theid, Model themodel) {
	 Customer thecustomer=customerservice.getCustomer(theid);
	 themodel.addAttribute("customer", thecustomer);
	 return "customer-form";
	 
	 
 }
 @GetMapping("/delete")
 public String deletecustomer(@RequestParam("customerid") int theid) {
	 customerservice.deletecustomer(theid);
	 return "redirect:/customer/list";
	 
 }
}
