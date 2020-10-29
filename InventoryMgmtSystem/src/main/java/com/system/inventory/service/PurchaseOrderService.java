package com.system.inventory.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import com.system.inventory.dao.PurchaseOrderDAO;
import com.system.inventory.models.Customer;
import com.system.inventory.models.PurchaseOrder;

public class PurchaseOrderService {

	static PurchaseOrderDAO purchaseOrdDao = new PurchaseOrderDAO();
	static CustomerService custService  = new CustomerService();
	static ItemService itemService = new ItemService();
	
	static Scanner sc = new Scanner(System.in);
	
	public void addPurchaseOrder() {
		System.out.println("Enter Customer Cell Phone(Customer ID): ");
		String custId = sc.nextLine();
		
		Customer cust = custService.getCustomer(Integer.parseInt(custId));
		
		PurchaseOrder p = new PurchaseOrder();
		p.setCustID(cust.getCustID());
		p.setOrderDate(new Date(new java.util.Date().getTime()));
		
		System.out.println("Enter the Shipping Date(dd/mm/yyyy)");
		String date[] = sc.nextLine().split("/");
 		Date shipDate = java.sql.Date.valueOf(LocalDate.of(Integer.parseInt(date[2]), Integer.parseInt(date[1]), Integer.parseInt(date[0]))); 
		p.setShipDate(shipDate);
		p.setShipped(true);
		
		// Add Item here!!

		
		
		purchaseOrdDao.addPurchaseOrder(p);
	}
	
	public void getOrdersByCustomer() {
		System.out.println("Enter Customer Name: ");
		String custName = sc.nextLine();
		
		ArrayList<PurchaseOrder> purchaseList =  (ArrayList<PurchaseOrder>) purchaseOrdDao.getOrderByCustomer(custName);
		for (PurchaseOrder purchaseOrder : purchaseList) {
			System.out.println(purchaseOrder);
		}
	}
	
	public void getOrderOnDate() {
		System.out.println("Enter Date(dd/mm/yyyy) : ");
		String date[] = sc.nextLine().split("/");
 		Date ondate = java.sql.Date.valueOf(LocalDate.of(Integer.parseInt(date[2]), Integer.parseInt(date[1]), Integer.parseInt(date[0]))); 
		purchaseOrdDao.getOrderOnDate(ondate);
		
	}
	
	public void getOrderBetweenDates() {
		System.out.println("Enter From Date(dd/mm/yyyy) : ");
		String fromdate[] = sc.nextLine().split("/");
 		Date from = java.sql.Date.valueOf(LocalDate.of(Integer.parseInt(fromdate[2]), Integer.parseInt(fromdate[1]), Integer.parseInt(fromdate[0]))); 
 		
 		System.out.println("Enter To Date(dd/mm/yyyy) : ");
		String todate[] = sc.nextLine().split("/");
 		Date to = java.sql.Date.valueOf(LocalDate.of(Integer.parseInt(todate[2]), Integer.parseInt(todate[1]), Integer.parseInt(todate[0]))); 		
		
		ArrayList<PurchaseOrder> purchaseList = (ArrayList<PurchaseOrder>) purchaseOrdDao.getOrderToFromDate(from , to);
		for (PurchaseOrder purchaseOrder : purchaseList) {
			System.out.println(purchaseOrder);
		} 
	}
	
	public void isOrderShipped() {
		System.out.println("Enter Customer Cell Phone(Customer ID): ");
		String custId = sc.nextLine();
		
		Customer cust = custService.getCustomer(Integer.parseInt(custId));
	
		purchaseOrdDao.updateStatusAndShipDate(true, new Date(new java.util.Date().getTime()), cust.getCustID());
	}
	
	public void totalOrdersShippedPerMonth() {
//		purchaseOrdDao.ordersShippedPerMonth();
	}
	
	public void fetchDelayedOrders() {
		ArrayList<PurchaseOrder> purchaseList = (ArrayList<PurchaseOrder>) purchaseOrdDao.getDelayedOrders();
		for (PurchaseOrder purchaseOrder : purchaseList) {
			System.out.println(purchaseOrder);
		}
	}
	
}
