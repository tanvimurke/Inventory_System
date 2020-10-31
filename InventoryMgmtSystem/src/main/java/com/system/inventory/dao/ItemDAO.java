package com.system.inventory.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.system.inventory.dbmanager.DBManager;
import com.system.inventory.models.Item;

public class ItemDAO {

	Connection con = DBManager.getConnection();

	public void addItem(Item i) {
		PreparedStatement ps;
		
		try {
			ps = con.prepareStatement("insert into item values (?,?,?)");
			ps.setInt(1, i.getStockItemNumber());
			ps.setString(2, i.getItemDesc());
			ps.setDouble(3, i.getItemPrice());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Item> getAllItems(){
		List<Item> itemList = new ArrayList<Item>();
		
		PreparedStatement ps;
		ResultSet rs;
		
		try {
			ps = con.prepareStatement("select * from item;");
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt(1);
				String desc = rs.getString(2);
				Double price = rs.getDouble(3);
				
				Item i = new Item(id, desc, price);
				itemList.add(i);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return itemList;
	}
	
	public Item getItem(int id) {
		Item item = new Item();
		PreparedStatement ps;
		ResultSet rs;
		
		try {
			ps = con.prepareStatement("select * from item where iId = ?;");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				item.setItemDesc(rs.getString(2));
				item.setItemPrice(rs.getDouble(3));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
		return item;
	}
	
	
	/*
	public static void main(String[] args) {
		Item i = new Item();
		i.setStockItemNumber(1);
		i.setItemDesc("bread");
		i.setItemPrice(25);
		
		Item i1 = new Item();
		i1.setStockItemNumber(2);
		i1.setItemDesc("eggs");
		i1.setItemPrice(25.25);
		
		Item i2 = new Item();
		i2.setStockItemNumber(3);
		i2.setItemDesc("milk");
		i2.setItemPrice(25.75);
		
		ItemDAO obj = new ItemDAO();
		//obj.addItem(i);
		//obj.addItem(i1);
		//obj.addItem(i2);
		
		List<Item> itemList = obj.getAllItems();
		for (Item item : itemList) {
			System.out.println(item.getStockItemNumber() + " " + item.getItemDesc() + " " + item.getItemPrice());
		}
		
	}
	*/
}
