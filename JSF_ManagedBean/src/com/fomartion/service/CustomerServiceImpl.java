package com.fomartion.service;

import java.util.*;

import com.fomartion.domain.Customer;

public class CustomerServiceImpl implements CustomerService {
	private Map<String, Customer> customers;

	public CustomerServiceImpl() {
		customers = new HashMap<String, Customer>();
		addCustomer(new Customer("id001", "Jules", "Hacker", -3456.78));
		addCustomer(new Customer("id002", "Marc", "Coder", 1234.56));
		addCustomer(new Customer("id003", "Jean", "Programmer", 987654.32));
	}

	
	public Customer findCustomer(String id) {
		if (id != null) {
			return (customers.get(id.toLowerCase()));
		} else {
			return (null);
		}
	}

	private void addCustomer(Customer customer) {
		customers.put(customer.getId(), customer);
	}
}

