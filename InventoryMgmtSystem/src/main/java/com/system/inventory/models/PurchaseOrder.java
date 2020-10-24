package com.system.inventory.models;

import java.sql.Date;

public class PurchaseOrder {
	private int poNumber;
    private int custID;
    private Date shipDate;
    private Date orderDate;
    private boolean isShipped;
    private OrderItem[] orderItem;
    
    
	public int getPoNumber() {
		return poNumber;
	}
	public void setPoNumber(int poNumber) {
		this.poNumber = poNumber;
	}
	public int getCustID() {
		return custID;
	}
	public void setCustID(int custID) {
		this.custID = custID;
	}
	public Date getShipDate() {
		return shipDate;
	}
	public void setShipDate(Date shipDate) {
		this.shipDate = shipDate;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public boolean isShipped() {
		return isShipped;
	}
	public void setShipped(boolean isShipped) {
		this.isShipped = isShipped;
	}
	public OrderItem[] getOrderItem() {
		return orderItem;
	}
	public void setOrderItem(OrderItem[] orderItem) {
		this.orderItem = orderItem;
	}

    
    
    
}
