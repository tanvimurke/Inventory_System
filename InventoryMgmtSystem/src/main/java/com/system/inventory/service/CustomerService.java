package com.system.inventory.service;

import com.system.inventory.dao.CustomerDAO;
import com.system.inventory.models.Customer;

public class CustomerService {
	
	static CustomerDAO custDao = new CustomerDAO();
	
	public void addCustomer(Customer c)
	{
		custDao.addCustomer(c);
	}
	
	public void getCustomer(int id) {
		custDao.getCustomerById(id);
	}
	
	
	
	
}
