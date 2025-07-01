package com.tap.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tap.daoimpl.OrderHistoryDAOImpl;
import com.tap.daoimpl.OrderItemsDAOImpl;
import com.tap.daoimpl.OrdersDAOImpl;
import com.tap.model.Cart;
import com.tap.model.CartItem;
import com.tap.model.OrderHistory;
import com.tap.model.OrderItems;
import com.tap.model.Orders;
import com.tap.model.User;

/**
 * Servlet implementation class CheckOut
 */
@WebServlet("/CheckOut")
public class CheckOut extends HttpServlet {
	
	private HttpSession session;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		session = req.getSession();
		
		String paymentOption = req.getParameter("paymentMode");
		float totalAmount = (float)session.getAttribute("totalAmount");
		User user = (User)session.getAttribute("user");
		int userId = user.getUserId();
		int restId = (int)session.getAttribute("firstRestId");
		
		Orders os = new Orders(userId,restId,totalAmount,"Success",paymentOption);
		OrdersDAOImpl odao = new OrdersDAOImpl();
		int x = odao.insertOrder(os);
		
		Cart cart = (Cart)session.getAttribute("cart");
		if(x==-1) {
			resp.sendRedirect("failure.jsp");
		}else {
			
			session.removeAttribute("firstRestId");
		
			int orderId = odao.getMaxOrderId();
			
			Map<Integer, CartItem> items = cart.getItems();
			for(int itemid : items.keySet()) {
				CartItem cItem = items.get(itemid);
				int quantity = cItem.getQuantity();
				double price = cItem.getPrice();
				float subTotal = (float) (quantity*price);
				
				OrderItems oit = new OrderItems(orderId,itemid,quantity,subTotal);
				
				OrderItemsDAOImpl oidao = new OrderItemsDAOImpl();
				int a = oidao.insertOrderItems(oit);
//				System.out.println(a);
				
//				System.out.println(orderId);
			}
			
			OrderHistory oh = new OrderHistory(userId,orderId,os.getStatus(),totalAmount);
			OrderHistoryDAOImpl ohdao = new OrderHistoryDAOImpl();
			ohdao.insertOrderHistory(oh);
			
			cart.clear();
			resp.sendRedirect("success.jsp");
		}
		

	}

}
