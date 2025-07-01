package com.tap.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tap.DAO.UserDAO;
import com.tap.daoimpl.UserDAOImpl;
import com.tap.model.User;

/**
 * Servlet implementation class Register
 */
@WebServlet("/registerUser")
public class Register extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String password = request.getParameter("password");

		User u = new User(name,password,email,address);
		UserDAO udaoi = new UserDAOImpl();
		int x = udaoi.insertUser(u);
		if(x==0) {
			response.sendRedirect("register.jsp");
		}else {
			response.sendRedirect("home.jsp");
		}
	}
}
