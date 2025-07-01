package com.tap.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tap.daoimpl.OrderHistoryDAOImpl;
import com.tap.daoimpl.OrdersDAOImpl;
import com.tap.daoimpl.RestaurantDAOImpl;
import com.tap.model.OrderHistory;
import com.tap.model.User;

/**
 * Servlet implementation class orderHistoryServlet
 */
@WebServlet("/OrderHistoryServlet")
public class OrderHistoryServlet extends HttpServlet {
	
	private HttpSession session;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		session = req.getSession();
		User user = (User)session.getAttribute("user");
		OrderHistoryDAOImpl ohdao = new OrderHistoryDAOImpl();
		OrdersDAOImpl odao = new OrdersDAOImpl();
		RestaurantDAOImpl rdao = new RestaurantDAOImpl();
		if(user!=null) {
			
			List<OrderHistory> ohList = ohdao.fetchOrderOnUserId(user.getUserId());
			session.setAttribute("ohList", ohList);
			
//			int restId = odao.fetchOnOrderId(24).getRestId();
//			String restName = rdao.getRestaurantById(restId).getRestName();
			
			req.getRequestDispatcher("orderHistory.jsp").forward(req, resp);
		}else {
			 resp.sendRedirect("login.jsp");
		}
	}

}
