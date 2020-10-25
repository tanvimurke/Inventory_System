package com.system.inventory.service;

import java.util.ArrayList;

import com.system.inventory.dao.ItemDAO;
import com.system.inventory.models.Item;

public class ItemService {

	static ItemDAO itemDao = new ItemDAO();
	
	public void addStockItem(Item i) {
		itemDao.addItem(i);
	}

	public void getAllStockItems() {
		ArrayList<Item> items = (ArrayList<Item>) itemDao.getAllItems();
		System.out.println("List of Stock Items :");
		for (Item item : items) {
			System.out.println(item);
		}
	}
}
