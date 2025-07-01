package com.tap.daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.tap.DAO.OrderItemsDAO;
import com.tap.model.OrderItems;

public class OrderItemsDAOImpl implements OrderItemsDAO {
	
	private PreparedStatement pstmt;
	private static Connection con;
	
	private final String INSERT = "insert into orderItems(ordersId,menuId,quantity,subtotal) values(?,?,?,?)";
	private final String FETCH = "select * from orderItems where ordersId=?";
	private final String FETCH_MAX = "SELECT MAX(ordersid) AS last_ordersid FROM orders";
	private ResultSet resultSet;
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinefoods","root","root");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	@Override
	public int insertOrderItems(OrderItems oi) {
		int x=-1;
		try {
			pstmt = con.prepareStatement(INSERT);
			pstmt.setInt(1, oi.getOrderId());
			pstmt.setInt(2, oi.getMenuId());
			pstmt.setInt(3, oi.getQuantity());
			pstmt.setFloat(4, oi.getSubtotal());
			x = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return x;
	}

	@Override
	public List<OrderItems> fetchOrderItem(int orderid) {
		List<OrderItems> list = new ArrayList<OrderItems>();
		try {
			pstmt = con.prepareStatement(FETCH);
			pstmt.setInt(1, orderid);
			resultSet = pstmt.executeQuery();
			while(resultSet.next()) {
				list.add(new OrderItems(resultSet.getInt(1),resultSet.getInt(2),
						resultSet.getInt(3),resultSet.getInt(4),resultSet.getFloat(5)));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
