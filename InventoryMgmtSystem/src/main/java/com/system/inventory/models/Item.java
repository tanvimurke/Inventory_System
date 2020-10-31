package com.system.inventory.models;

public class Item {

	private int stockItemNumber;
	private String itemDesc;
	private double itemPrice;
	private Unit unit;
	private int stockQuantity;

	public Item(int stockItemNumber, String itemDesc, double itemPrice) {
		// TODO Auto-generated constructor stub
		this.stockItemNumber = stockItemNumber;
		this.itemDesc = itemDesc;
		this.itemPrice = itemPrice;
	}

	public Item() {
		// TODO Auto-generated constructor stub
	}

	public int getStockItemNumber() {
		return stockItemNumber;
	}

	public void setStockItemNumber(int stockItemNumber) {
		this.stockItemNumber = stockItemNumber;
	}

	public String getItemDesc() {
		return itemDesc;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}

	public double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}

	public Unit getUnit() {
		return unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}

	public int getStockQuantity() {
		return stockQuantity;
	}

	public void setStockQuantity(int quantity) {
		this.stockQuantity = quantity;
	}

	@Override
	public String toString() {
		return "Item [itemDesc=" + itemDesc + ", itemPrice=" + itemPrice + "]";
	}
}
