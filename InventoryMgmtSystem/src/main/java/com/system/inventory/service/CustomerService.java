package com.system.inventory.service;

import java.util.Scanner;

import com.system.inventory.dao.CustomerDAO;
import com.system.inventory.models.Customer;

public class CustomerService {
	
	static CustomerDAO custDao = new CustomerDAO();
	static Scanner sc = new Scanner(System.in);
	
	public void addCustomer()
	{
		Customer c = new Customer();
		System.out.println("Enter Customer Name : ");
		c.setCustName(sc.nextLine());
		
		System.out.println("Enter Home Phone : ");
		c.setHomePhone(sc.nextLine());
		
		System.out.println("Enter Work Phone : ");
		c.setWorkPhone(sc.nextLine());
		
		System.out.println("Enter Cell Phone : ");
		c.setCellPhone(sc.nextLine());
		
		System.out.println("Enter Street : ");
		c.setStreet(sc.nextLine());
		
		System.out.println("Enter City : ");
		c.setCity(sc.nextLine());
		
		System.out.println("Enter Zip Code : ");
		c.setZip(sc.nextLine());
		
		c.setState("Maharashtra");
		c.setCustID(Integer.parseInt(c.getCellPhone()));
		
		custDao.addCustomer(c);
	}
	
	public Customer getCustomer(int id) {
		return custDao.getCustomerById(id);
	}
	

}
