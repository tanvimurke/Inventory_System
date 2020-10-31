package com.system.inventory.application;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.system.inventory.service.CustomerService;
import com.system.inventory.service.ItemService;
import com.system.inventory.service.PurchaseOrderService;

public class Application {

	public static void main(String[] args) {
		// OUR Application RUNs here
		CustomerService custService = new CustomerService();
		PurchaseOrderService purchaseService = new PurchaseOrderService();
		ItemService itemService = new ItemService();
		Scanner sc = new Scanner(System.in);
		
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
		    
		    choice = sc.nextInt();
		    sc.nextLine();
		    try {
		    	switch(choice) {
		    	case 1:
		    		custService.addCustomer();
		    		break;
		    		
		    	case 2:
		    		purchaseService.addPurchaseOrder();
		    		break;
		    		
		    	case 3:
		    		itemService.addStockItem();
		    		break;
		    	
		    	case 4:
		    		System.out.println("Enter Customer Id(Cell Phone) : ");
		    		System.out.println(custService.getCustomer(sc.nextLong()));
		    		break;	
		    		
		    	case 5:
		    		purchaseService.getOrdersByCustomer();
		    		break;	
		    		
		    	case 6:
		    		purchaseService.getOrderBetweenDates();
		    		break;	
		    		
		    	case 7:
		    		purchaseService.getOrderOnDate();
		    		break;	
		    		
		    	case 8:
		    		purchaseService.isOrderShipped();
		    		break;
		    		
		    	case 9:
		    		purchaseService.fetchDelayedOrders();
		    		break;	
		    	
		    	case 10:
		    		itemService.getAllStockItems();
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



	
	
}
