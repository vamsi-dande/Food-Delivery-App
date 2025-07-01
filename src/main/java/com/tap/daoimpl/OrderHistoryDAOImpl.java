package com.tap.daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.tap.DAO.OrderHistoryDAO;
import com.tap.model.OrderHistory;

public class OrderHistoryDAOImpl implements OrderHistoryDAO {
	
	private PreparedStatement pstmt;
	private ResultSet resultSet;
	private static Connection con;
	
	private final String INSERT = "insert into orderhistory(userId,orderId,status,totalAmount)"
			+ "values(?,?,?,?)";
	private final String FETCH = "select * from orderhistory where userId=?";
	private final String UPDATE = "update orderhistory set status=? where orderHistoryId=?";
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinefoods","root","root");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public int insertOrderHistory(OrderHistory oh) {
		int x=-1;
		try {
			pstmt = con.prepareStatement(INSERT);
			pstmt.setInt(1, oh.getUserId());
			pstmt.setInt(2, oh.getOrderId());
			pstmt.setString(3, oh.getStatus());
			pstmt.setFloat(4, oh.getTotalAmount());
			
			x = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return x;
	}

	@Override
	public List<OrderHistory> fetchOrderOnUserId(int userId) {
		List<OrderHistory> list = new ArrayList<OrderHistory>();
		try {
			pstmt = con.prepareStatement(FETCH);
			pstmt.setInt(1, userId);
			resultSet = pstmt.executeQuery();
			while(resultSet.next()) {
				list.add(new OrderHistory(resultSet.getInt(1),
						resultSet.getInt(2),
						resultSet.getInt(3),
						resultSet.getFloat(6),
						resultSet.getString(4),
						resultSet.getString(5)
						));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int updateOrderHistory(int orderHistoryId, String status) {
		int x=-1;
		try {
			pstmt = con.prepareStatement(UPDATE);
			pstmt.setString(1, status);
			pstmt.setInt(2, orderHistoryId);
			x = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return x;
	}

	
}
