package com.tap.DAO;

import java.util.List;

import com.tap.model.OrderItems;

public interface OrderItemsDAO {

	int insertOrderItems(OrderItems oi);
	List<OrderItems> fetchOrderItem(int orderid);
	
}
