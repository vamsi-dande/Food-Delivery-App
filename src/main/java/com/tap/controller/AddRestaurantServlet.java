package com.tap.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tap.daoimpl.RestaurantDAOImpl;
import com.tap.model.Restaurant;

/**
 * Servlet implementation class AddRestaurantServlet
 */
@WebServlet("/AddRestaurantServlet")
public class AddRestaurantServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String description = req.getParameter("description");
		int deliveryTime = Integer.parseInt(req.getParameter("deliveryTime"));
		String imagePath = req.getParameter("imagePath");

		Restaurant restaurant = new Restaurant(name, description, deliveryTime, imagePath);
		RestaurantDAOImpl rdao = new RestaurantDAOImpl();
		rdao.insertRestaurant(restaurant);

		resp.sendRedirect("success2.jsp"); // Redirect to a success page or restaurant listing
	}
}



