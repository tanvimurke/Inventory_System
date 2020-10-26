package com.system.inventory.application;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
		// OUR Application RUNs here
		int choice;
		
		do {
			System.out.println("-----------------------------------------------------------------------------------------------");
			System.out.println("WELCOME TO OUR INVENTORY SYSTEM");
			System.out.println("1. Add New Customer");
			System.out.println("2. Add new Purchase Order");
			System.out.println("3. Add new Stock Item");
			System.out.println("4. Fetch customer based on id");
			System.out.println("5. Fetch Orders placed by specific customers");
			System.out.println("6. Fetch all orders placed between from and to date inclusive of both date");
			System.out.println("7. Fetch all the orders placed for given date");
			System.out.println("8. Update order status to ship and update ship date based on order id");
			System.out.println("9. Fetch delayed orders ");
		    System.out.println("10. Fetch all stock Items");
		    System.out.println("11. Find month-wise total orders shipped");
		    System.out.println("12. Find the total amount collected based on months");
		    System.out.println("13. Find the customer who has made maximum orders");
		    System.out.println("14. Generate bill for customer for specific order");
		    System.out.println("15. Exit");
		    System.out.println("THANK YOU FOR SHOPPING WITH  US!");
		    System.out.println("-----------------------------------------------------------------------------------------------");
		    System.out.println("Please choose an option: ");
		    Scanner sc = new Scanner(System.in);
		    choice = sc.nextInt();
		    
		    try {
		    	switch(choice) {
		    	case 1:
		    		addCustomer();
		    		break;
		    		
		    	case 2:
		    		addPurchaseOrder();
		    		break;
		    		
		    	case 3:
		    		addStockItem();
		    		break;
		    	
		    	case 4:
		    		getCustomerInfo();
		    		break;	
		    		
		    	case 5:
		    		getCustomerOrder();
		    		break;	
		    		
		    	case 6:
		    		getOrdersToFromDate();
		    		break;	
		    		
		    	case 7:
		    		getOrdersOnDate();
		    		break;	
		    		
		    	case 8:
		    		updateOrderStatus();
		    		break;
		    		
		    	case 9:
		    		getDelayedOrders();
		    		break;	
		    	
		    	case 10:
		    		getAllStockItems();
		    		break;	
		    		
		    	case 11:
		    		getMonthOrders();
		    		break;	
		    	
		    	case 12:
		    		getMonthlyAmount();
		    		break;	
		    		
		    	case 13:
		    		getMaxOrder();
		    		break;	
		    		
		    	case 14:
		    		getBill();
		    		break;		
		    		
		    	case 15:
		    		System.out.println("Exiting...");
		    		break;
		    		
		        default:
		        	System.out.println("Please enter correct option!!");
		    		
		    	}
		    	
		    }catch(InputMismatchException e) {
		    	e.printStackTrace();
		    }
		
		}while(choice!=15); 
		

	}

	private static void getBill() {
		// TODO Auto-generated method stub
		
	}

	private static void getMaxOrder() {
		// TODO Auto-generated method stub
		
	}

	private static void getMonthlyAmount() {
		// TODO Auto-generated method stub
		
	}

	private static void getMonthOrders() {
		// TODO Auto-generated method stub
		
	}

	private static void getAllStockItems() {
		// TODO Auto-generated method stub
		
	}

	private static void getDelayedOrders() {
		// TODO Auto-generated method stub
		
	}

	private static void updateOrderStatus() {
		// TODO Auto-generated method stub
		
	}

	private static void getOrdersOnDate() {
		// TODO Auto-generated method stub
		
	}

	private static void getOrdersToFromDate() {
		// TODO Auto-generated method stub
		
	}

	private static void getCustomerOrder() {
		// TODO Auto-generated method stub
		
	}

	private static void getCustomerInfo() {
		// TODO Auto-generated method stub
		
	}

	private static void addStockItem() {
		// TODO Auto-generated method stub
		
	}

	private static void addPurchaseOrder() {
		// TODO Auto-generated method stub
		
	}

	private static void addCustomer() {
		// TODO Auto-generated method stub
		
	}

	
	
}
