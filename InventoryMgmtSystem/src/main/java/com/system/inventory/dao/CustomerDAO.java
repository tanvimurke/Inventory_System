package com.system.inventory.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.system.inventory.dbmanager.DBManager;
import com.system.inventory.models.Customer;

public class CustomerDAO {

	Connection con = DBManager.getConnection();
	
	public void addCustomer(Customer c) {
		PreparedStatement ps;
		
		try {
			ps = con.prepareStatement("insert into customer values (?,?,?)");
			ps.setInt(1, c.getCustID());
			ps.setString(2, c.getCustName());
			String addr = c.getStreet() + " " + c.getCity() + " " + c.getState();
			ps.setString(3, addr);
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public Customer getCustomerById(int id) {
		Customer c = new Customer();
		PreparedStatement ps;
		ResultSet rs;
		
		try {
			ps = con.prepareStatement("select * from customer where cid=?");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				c.setCustID(rs.getInt(1));
				c.setCustName(rs.getString(2));
				String a = rs.getString(3);
				
				String addr[] = a.split(" ");
				c.setStreet(addr[0]);
				c.setCity(addr[1]);
				c.setState(addr[2]);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return c;
	}
	
	/*
	public static void main(String[] args) {
		Customer c = new Customer();
		c.setCustID(1);
		c.setCustName("radhika");
		c.setStreet("street");
		c.setCity("pune");
		c.setState("mh");
		
		CustomerDAO obj = new CustomerDAO();
		//obj.addCustomer(c);
		
		
		Customer c1 = obj.getCustomerById(1);
		System.out.println("id : " + c1.getCustID());
		System.out.println("name : " + c1.getCustName());
		System.out.println("street : " + c1.getStreet());
		System.out.println("city : " + c1.getCity());
		System.out.println("state : " + c1.getState());
	}
	*/
}
