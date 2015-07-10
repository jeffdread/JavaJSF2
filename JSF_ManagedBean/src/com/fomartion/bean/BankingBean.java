package com.fomartion.bean;

import javax.faces.bean.ManagedBean;

import com.fomartion.domain.Customer;
import com.fomartion.service.CustomerService;
import com.fomartion.service.CustomerServiceImpl;

@ManagedBean
public class BankingBean {
	private String customerId;
	private String password;
	private Customer customer;
	private static CustomerService lookupService = new CustomerServiceImpl();

	public String getCustomerId() {
		return (customerId);
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId.trim();
		if (this.customerId.isEmpty()) {
			this.customerId = "(none entered)";
		}
	}

	public String getPassword() {
		return (password);
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Customer getCustomer() {
		return (customer);
	}

	public String showBalance() {
		if (!password.equals("secret")) {
			return ("wrong-password");
		}
		customer = lookupService.findCustomer(customerId);
		if (customer == null) {
			return ("unknown-customer");
		} else if (customer.getBalance() < 0) {
			return ("negative-balance");
		} else if (customer.getBalance() < 10000) {
			return ("normal-balance");
		} else {
			return ("high-balance");
		}
	}
}
