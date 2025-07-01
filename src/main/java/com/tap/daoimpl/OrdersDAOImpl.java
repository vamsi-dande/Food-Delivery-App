package com.tap.daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tap.DAO.OrdersDAO;
import com.tap.model.Orders;

public class OrdersDAOImpl implements OrdersDAO {
	
	private PreparedStatement pstmt;
	private ResultSet resultSet;
	private static Connection con;
	
	private final String INSERT = "insert into orders(usersId,restId,totalAmount,status,paymentOption)"
			+ "values(?,?,?,?,?)";
	private final String FETCH = "select * from orders where orderId=?";
	private final String UPDATE = "update orders set status=? where orderId=?";
	private final String FETCH_MAX = "SELECT MAX(orderId)  FROM orders";
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinefoods","root","root");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int getMaxOrderId() {
		int maxOrderId = 0;
		try {
			pstmt = con.prepareStatement(FETCH_MAX);
			resultSet = pstmt.executeQuery();
			if(resultSet.next()) {
				maxOrderId = resultSet.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return maxOrderId;
		
	}

	@Override
	public int insertOrder(Orders os) {
		int x=-1;
		try {
			pstmt = con.prepareStatement(INSERT);
			pstmt.setInt(1, os.getUserId());
			pstmt.setInt(2, os.getRestId());
			pstmt.setFloat(3, os.getTotalAmount());
			pstmt.setString(4, os.getStatus());
			pstmt.setString(5, os.getPaymentOption());
			
			x = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return x;
	}

	@Override
	public Orders fetchOnOrderId(int orderId) {
		Orders order = null;
		try {
			pstmt = con.prepareStatement(FETCH);
			pstmt.setInt(1, orderId);
			resultSet = pstmt.executeQuery();
			while(resultSet.next()) {
				order = new Orders(resultSet.getInt(1),
								resultSet.getInt(2),
								resultSet.getInt(3),
								resultSet.getFloat(4),
								resultSet.getString(5),
								resultSet.getString(6),
								resultSet.getString(7));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return order;
	}

	@Override
	public int updateOrder(int orderId, String status) {
		int x=-1;
		try {
			pstmt = con.prepareStatement(UPDATE);
			pstmt.setString(1, status);
			pstmt.setInt(2, orderId);
			x = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return x;
	}

}
