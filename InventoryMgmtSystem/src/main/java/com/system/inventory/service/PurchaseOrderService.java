package com.system.inventory.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.system.inventory.dao.PurchaseOrderDAO;
import com.system.inventory.models.Customer;
import com.system.inventory.models.Item;
import com.system.inventory.models.OrderItem;
import com.system.inventory.models.PurchaseOrder;

public class PurchaseOrderService {

	static PurchaseOrderDAO purchaseOrdDao = new PurchaseOrderDAO();
	static CustomerService custService  = new CustomerService();
	static ItemService itemService = new ItemService();
	static OrderItemService orderService = new OrderItemService();
	
	static Scanner sc = new Scanner(System.in);
	
	public void addPurchaseOrder() {
		System.out.println("Enter Customer Cell Phone(Customer ID): ");
		String custId = sc.nextLine();
		
		Customer cust = custService.getCustomer(Long.parseLong(custId));
		
		PurchaseOrder p = new PurchaseOrder();
		
		System.out.println("Enter Purchase Order Number: ");
		p.setPoNumber(sc.nextInt());
		sc.nextLine();
		
		p.setCustID(cust.getCustID());
		
		p.setOrderDate(new Date(new java.util.Date().getTime()));
		
		System.out.println("Enter the Shipping Date(dd/mm/yyyy)");
		String date[] = sc.nextLine().split("/");
 		Date shipDate = java.sql.Date.valueOf(LocalDate.of(Integer.parseInt(date[2]), Integer.parseInt(date[1]), Integer.parseInt(date[0]))); 
		p.setShipDate(shipDate);
		p.setShipped(true);
		
		purchaseOrdDao.addPurchaseOrder(p);
		// Add Item here!!
			while(true) {
				itemService.getAllStockItems();
				System.out.println("0. Exit");
				System.out.println("Enter Item number to add : ");
				int ch = sc.nextInt();
				if(ch ==0 )
					break;
				else {
					Item item = itemService.getItem(ch);
					sc.nextLine();
					
					OrderItem order = new OrderItem();
					order.setItem(item);
					
					order.setStockItemNumber(ch);
					
					System.out.println("Enter Order Number: ");
					order.setOrderItemNumber(sc.nextInt());
					sc.nextLine();
					
					System.out.println("Enter quantity: ");
					order.setNumberOfItems(sc.nextInt()); 
					sc.nextLine();
					
					order.setPoNumber(p.getPoNumber());
					
					System.out.println(p.getPoNumber());
					orderService.addOrder(order);
				}
				
			}
		
		
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
		ArrayList<PurchaseOrder> pOList = (ArrayList<PurchaseOrder>) purchaseOrdDao.getOrderOnDate(ondate);
		for (PurchaseOrder purchaseOrder : pOList) {
			System.out.println(purchaseOrder);
		}
		
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
		
		Customer cust = custService.getCustomer(Long.parseLong(custId));
	
		PurchaseOrder p = purchaseOrdDao.updateStatusAndShipDate(true, new Date(new java.util.Date().getTime()), cust.getCustID());
		System.out.println(p);
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
