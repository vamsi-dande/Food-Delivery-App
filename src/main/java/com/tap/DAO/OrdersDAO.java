package com.tap.DAO;

import com.tap.model.Orders;

public interface OrdersDAO {

	int insertOrder(Orders os);
	Orders fetchOnOrderId(int orderId);
	int updateOrder(int orderId, String stats);
}
