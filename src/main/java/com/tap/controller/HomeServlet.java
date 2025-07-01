package com.tap.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tap.daoimpl.RestaurantDAOImpl;
import com.tap.model.Restaurant;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RestaurantDAOImpl rdao = new RestaurantDAOImpl();
		List<Restaurant> restList = rdao.getAllRestaurants();
		req.getSession().setAttribute("restList", restList);
		resp.sendRedirect("home.jsp");
	}

}
