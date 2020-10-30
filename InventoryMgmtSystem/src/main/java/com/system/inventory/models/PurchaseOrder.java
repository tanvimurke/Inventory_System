package com.system.inventory.models;

import java.sql.Date;

public class PurchaseOrder {
	private int poNumber;
    private long custID;
    private Date shipDate;
    private Date orderDate;
    private boolean isShipped;
    private OrderItem[] orderItem;
    
    public PurchaseOrder() {
		// TODO Auto-generated constructor stub
	}
    
    
    public PurchaseOrder(int poNumber, Date orderDate, Date shipDate, boolean isShipped, int custId) {
    	this.poNumber=poNumber;
    	this.orderDate=orderDate;
    	this.shipDate=shipDate;
    	this.isShipped=isShipped;
    	this.custID=custId;
    }
    
	public int getPoNumber() {
		return poNumber;
	}
	public void setPoNumber(int poNumber) {
		this.poNumber = poNumber;
	}
	public long getCustID() {
		return custID;
	}
	public void setCustID(long l) {
		this.custID = l;
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
