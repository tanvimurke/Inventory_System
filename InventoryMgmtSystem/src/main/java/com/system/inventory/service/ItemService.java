package com.system.inventory.service;

import java.util.ArrayList;
import java.util.Scanner;

import com.system.inventory.dao.ItemDAO;
import com.system.inventory.models.Item;

public class ItemService {

	static ItemDAO itemDao = new ItemDAO();
	static Scanner sc = new Scanner(System.in);
	
	public void addStockItem() {
		Item i = new Item();
		
		System.out.println("Enter Stock Item Number: ");
		i.setStockItemNumber(sc.nextInt());
		
		System.out.println("Enter Item Description: ");
		i.setItemDesc(sc.nextLine());
		
		System.out.println("Enter Item Price: ");
		i.setItemPrice(sc.nextDouble());
		
		System.out.println("Enter Stock Quantity: ");
		i.setStockQuantity(sc.nextInt());
		
		itemDao.addItem(i);
	}

	public void getAllStockItems() {
		ArrayList<Item> items = (ArrayList<Item>) itemDao.getAllItems();
		System.out.println("List of Stock Items :");
		int cnt=1;
		for (Item item : items) {
			System.out.println((cnt++) +". "+item);
		}
	}
}
