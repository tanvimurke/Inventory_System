package com.system.inventory.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.system.inventory.dbmanager.DBManager;
import com.system.inventory.models.OrderItem;
import com.system.inventory.models.PurchaseOrder;

public class OrderItemDAO {

	Connection con = DBManager.getConnection();

	public void addOrderItem(OrderItem order) {
		System.out.println("Inside OrderItemDAO");
		PreparedStatement ps;

		try {
			ps = con.prepareStatement("insert into orderItem values (?,?,?,?)");
			ps.setInt(1, order.getOrderItemNumber());
			ps.setInt(2, order.getNumberOfItems());
			ps.setInt(3, order.getStockItemNumber());
			ps.setInt(4, order.getPoNumber());

			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<OrderItem> getOrdersByPurchaseID(int id) {
		List<OrderItem> oList = new ArrayList<OrderItem>();
		ItemDAO itemDao = new ItemDAO();
		PreparedStatement ps;
		ResultSet rs;
		
		try {
			ps = con.prepareStatement("select * from orderItem where pno = ? ;");
			ps.setInt(1,id);
			rs = ps.executeQuery();
		
			while(rs.next()) {
				OrderItem order = new OrderItem();
				order.setOrderItemNumber(rs.getInt(1));
				order.setNumberOfItems(rs.getInt(2));
				order.setItem(itemDao.getItem(rs.getInt(3)));
				order.setStockItemNumber(rs.getInt(3));
				
				oList.add(order);
		
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return oList;
	}
	

}
