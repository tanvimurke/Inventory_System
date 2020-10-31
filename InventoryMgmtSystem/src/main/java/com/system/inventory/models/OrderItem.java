package com.system.inventory.models;

public class OrderItem {
	private int orderItemNumber;
	private int poNumber;
	private int stockItemNumber;
	private Item item;
	private int numberOfItems;

	public int getOrderItemNumber() {
		return orderItemNumber;
	}

	public void setOrderItemNumber(int orderItemNumber) {
		this.orderItemNumber = orderItemNumber;
	}

	public int getPoNumber() {
		return poNumber;
	}

	public void setPoNumber(int poNumber) {
		this.poNumber = poNumber;
	}

	public int getStockItemNumber() {
		return stockItemNumber;
	}

	public void setStockItemNumber(int stockItemNumber) {
		this.stockItemNumber = stockItemNumber;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public int getNumberOfItems() {
		return numberOfItems;
	}

	public void setNumberOfItems(int numberOfItems) {
		this.numberOfItems = numberOfItems;
	}

	@Override
	public String toString() {
		return "OrderItem [orderItemNumber=" + orderItemNumber + ", stockItemNumber="
				+ stockItemNumber + ", item=" + item + ", numberOfItems=" + numberOfItems + "]";
	}

	
	
}
