package com.system.inventory.service;

import java.sql.Date;

import com.system.inventory.dao.PurchaseOrderDAO;
import com.system.inventory.models.PurchaseOrder;

public class PurchaseOrderService {

	static PurchaseOrderDAO purchaseOrdDao = new PurchaseOrderDAO();
	
	public void addPurchaseOrder(PurchaseOrder p) {
		purchaseOrdDao.addPurchaseOrder(p);
	}
	
	public void getOrdersByCustomer(String custName) {
		//purchaseOrdDao.getOrderByCustomer(custName);
	}
	
	public void getOrderOn(Date d) {
//		purchaseOrdDao.getOrderOn(d);
	}
	
	public void getOrderBetween(Date from , Date to) {
//		purchaseOrdDao.getOrderBetween(from,to);
	}
	
	public void isOrderShipped(boolean isShipped, int id) {
//		purchaseOrdDao.isOrderShipped(isShipped,id);
	}
	
	public void totalOrdersShippedPerMonth() {
//		purchaseOrdDao.ordersShippedPerMonth();
	}
	
	
}
