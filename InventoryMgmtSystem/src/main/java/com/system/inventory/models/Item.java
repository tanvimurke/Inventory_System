package com.system.inventory.models;

public class Item {
	
	private int stockItemNumber;
    private String itemDesc;
    private double itemPrice; 
    private Unit unit ;
    private int quantity;
    
    
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
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	} 
	
    
}
