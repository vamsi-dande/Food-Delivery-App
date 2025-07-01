package com.tap.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tap.daoimpl.OrderItemsDAOImpl;
import com.tap.model.OrderItems;

/**
 * Servlet implementation class OrderDetailsServlet
 */
@WebServlet("/OrderDetailsServlet")
public class OrderDetailsServlet extends HttpServlet {
	
	private HttpSession session;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		session = req.getSession();
		int orderId = Integer.parseInt(req.getParameter("orderId"));
		System.out.println(orderId);
		
		OrderItemsDAOImpl oidao = new OrderItemsDAOImpl();
		List<OrderItems> oItems = oidao.fetchOrderItem(orderId);
		if(oItems != null) {
//			System.out.println("List is not null");
			session.setAttribute("oItems", oItems);
		}
		else {
			System.out.println("List is null");
		}
		
		
		req.getRequestDispatcher("orderDetails.jsp").forward(req, resp);
	}

}

















