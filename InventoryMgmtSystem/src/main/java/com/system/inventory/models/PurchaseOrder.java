package com.system.inventory.models;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

public class PurchaseOrder {
	private int poNumber;
    private long custID;
    private Date shipDate;
    private Date orderDate;
    private boolean isShipped;
    private List<OrderItem> orderItem;
    
    public PurchaseOrder() {
		// TODO Auto-generated constructor stub
	}
    
    
    public PurchaseOrder(int poNumber, Date orderDate, Date shipDate, boolean isShipped, long custId) {
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
	public List<OrderItem> getOrderItem() {
		return orderItem;
	}
	public void setOrderItem(List<OrderItem> orderItem) {
		this.orderItem = orderItem;
	}


	@Override
	public String toString() {
		return "PurchaseOrder [poNumber=" + poNumber + ", custID=" + custID + ", shipDate=" + shipDate + ", orderDate="
				+ orderDate + ", isShipped=" + isShipped + ", orderItem=" + orderItem + "]";
	}


	

    
    
    
}
