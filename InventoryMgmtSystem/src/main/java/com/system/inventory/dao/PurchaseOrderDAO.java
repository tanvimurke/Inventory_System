package com.system.inventory.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.system.inventory.dbmanager.DBManager;
import com.system.inventory.models.PurchaseOrder;

public class PurchaseOrderDAO {

	Connection con = DBManager.getConnection();
	static OrderItemDAO oIDao = new OrderItemDAO();
	
	public void addPurchaseOrder(PurchaseOrder p) {
		PreparedStatement ps;
		
		try {
			ps = con.prepareStatement("insert into purchaseOrder values (?,?,?,?,?)");
			ps.setInt(1, p.getPoNumber());
			ps.setDate(2, p.getOrderDate());
			ps.setDate(3, p.getShipDate());
			ps.setBoolean(4, p.isShipped());
			ps.setLong(5, p.getCustID());
			
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
	
	public List<PurchaseOrder> getOrderByCustomer(String name) {
		System.out.println(name);
		List<PurchaseOrder> pList = new ArrayList<PurchaseOrder>();
		PreparedStatement ps;
		ResultSet rs;
		
		try {
			ps = con.prepareStatement("select * from purchaseOrder where custId=(select custId from customer where cname=?);");
			ps.setString(1, name);
			rs = ps.executeQuery();
		
			while(rs.next()) {
				int id = rs.getInt(1);
				Date orderDate = rs.getDate(2);
				Date shipDate = rs.getDate(3);
				boolean status = rs.getBoolean(4);
				long custId = rs.getLong(5);
				
				PurchaseOrder p = new  PurchaseOrder(id, orderDate, shipDate, status, custId);
				p.setOrderItem(oIDao.getOrdersByPurchaseID(p.getPoNumber()));
				
				
				pList.add(p);
		
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return pList;
	}
	
	public List<PurchaseOrder> getOrderToFromDate(Date start, Date end){
		// date format eg : 2020-05-17 (yyyy-mm-dd)
		
		List<PurchaseOrder> pList = new ArrayList<PurchaseOrder>();
		PreparedStatement ps;
		ResultSet rs;
		
		try {
			ps = con.prepareStatement("select * from purchaseOrder  where orderDate between cast(? as date) and cast(? as date);");
			ps.setDate(1, start);
			ps.setDate(2, end);
			rs = ps.executeQuery();
		
			while(rs.next()) {
				int id = rs.getInt(1);
				Date orderDate = rs.getDate(2);
				Date shipDate = rs.getDate(3);
				boolean status = rs.getBoolean(4);
				long custId = rs.getLong(5);
				
				PurchaseOrder p = new  PurchaseOrder(id, orderDate, shipDate, status, custId);
				p.setOrderItem(oIDao.getOrdersByPurchaseID(p.getPoNumber()));
				
				pList.add(p);
		
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return pList;
	}
	
	
	
	public List<PurchaseOrder> getOrderOnDate(Date date){
		// date format eg : 2020-05-17 (yyyy-mm-dd)
		List<PurchaseOrder> pList = new ArrayList<PurchaseOrder>();
		PreparedStatement ps;
		ResultSet rs;
		
		try {
			ps = con.prepareStatement("select * from purchaseOrder  where orderDate= cast(? as date);");
			ps.setDate(1, date);
			rs = ps.executeQuery();
		
			while(rs.next()) {
				int id = rs.getInt(1);
				Date orderDate = rs.getDate(2);
				Date shipDate = rs.getDate(3);
				boolean status = rs.getBoolean(4);
				long custId = rs.getLong(5);
				
				PurchaseOrder p = new  PurchaseOrder(id, orderDate, shipDate, status, custId);
				p.setOrderItem(oIDao.getOrdersByPurchaseID(p.getPoNumber()));
				pList.add(p);
		
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return pList;
	}
	
	
	public PurchaseOrder updateStatusAndShipDate(boolean status, Date shipDate, long CustId) {
		PurchaseOrder p = new PurchaseOrder();
		PreparedStatement ps;
		
		// date format eg : 2020-05-17 (yyyy-mm-dd)

		
		try {
			ps = con.prepareStatement("update purchaseOrder set status=?, shipDate=cast(? as date) where custId=?;");
			ps.setBoolean(1, status);
			ps.setDate(2, shipDate);
			ps.setLong(3, CustId);
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return p;
	}
	
	
	public List<PurchaseOrder> getDelayedOrders(){
		List<PurchaseOrder> pList = new ArrayList<PurchaseOrder>();

		PreparedStatement ps;
		ResultSet rs;
		
		try {
			ps = con.prepareStatement("select * from purchaseOrder where datediff(shipDate,orderDate)>4;");
			rs = ps.executeQuery();
		
			while(rs.next()) {
				int id = rs.getInt(1);
				Date orderDate = rs.getDate(2);
				Date shipDate = rs.getDate(3);
				boolean status = rs.getBoolean(4);
				long custId = rs.getLong(5);
				
				PurchaseOrder p = new  PurchaseOrder(id, orderDate, shipDate, status, custId);
				p.setOrderItem(oIDao.getOrdersByPurchaseID(p.getPoNumber()));
				pList.add(p);
		
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		
		return pList;
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
