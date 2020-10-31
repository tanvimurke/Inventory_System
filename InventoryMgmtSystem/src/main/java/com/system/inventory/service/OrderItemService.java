package com.system.inventory.service;

import com.system.inventory.dao.OrderItemDAO;
import com.system.inventory.models.OrderItem;

public class OrderItemService {

	static OrderItemDAO orderDAO = new OrderItemDAO();
	
	public void addOrder(OrderItem order) {
		orderDAO.addOrderItem(order);
	}
	
}
