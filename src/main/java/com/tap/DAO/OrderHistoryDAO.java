package com.tap.DAO;

import java.util.List;

import com.tap.model.OrderHistory;

public interface OrderHistoryDAO {

	int insertOrderHistory(OrderHistory oh);
	List<OrderHistory> fetchOrderOnUserId(int userId);
	int updateOrderHistory(int orderHistoryId, String status);
}
