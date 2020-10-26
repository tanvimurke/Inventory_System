package com.system.inventory.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.system.inventory.dbmanager.DBManager;
import com.system.inventory.models.PurchaseOrder;

public class PurchaseOrderDAO {

	Connection con = DBManager.getConnection();
	
	public void addPurchaseOrder(PurchaseOrder p) {
		PreparedStatement ps;
		
		try {
			ps = con.prepareStatement("insert into purchaseOrder values (?,?,?,?,?)");
			ps.setInt(1, p.getPoNumber());
			ps.setDate(2, p.getOrderDate());
			ps.setDate(3, p.getShipDate());
			ps.setBoolean(4, p.isShipped());
			ps.setInt(5, p.getCustID());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public PurchaseOrder getOrderById(int id) {
		PurchaseOrder p = new PurchaseOrder();
		PreparedStatement ps;
		ResultSet rs;
		
		try {
			ps = con.prepareStatement("select * from purchaseOrder where custId=?");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				p.setPoNumber(rs.getInt(1));
				p.setOrderDate(rs.getDate(2));
				p.setShipDate(rs.getDate(3));
				p.isShipped();
				p.setCustID(rs.getInt(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return p;
	}
	
	/*
	public static void main(String[] args) {
		PurchaseOrder p1 = new PurchaseOrder();
		p1.setPoNumber(1);
		p1.setOrderDate(Date.valueOf("2020-5-17"));
		p1.setShipDate(Date.valueOf("2020-5-20"));
		p1.setShipped(true);
		p1.setCustID(1);
		
		PurchaseOrderDAO obj = new PurchaseOrderDAO();
		//obj.addPurchaseOrder(p1);
		
		PurchaseOrder p2 = obj.getOrderById(1);
		System.out.println("order date : " + p2.getOrderDate());
	}
	*/
}
