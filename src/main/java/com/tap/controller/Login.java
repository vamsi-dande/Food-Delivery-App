package com.tap.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tap.daoimpl.UserDAOImpl;
import com.tap.model.User;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		UserDAOImpl udaoi = new UserDAOImpl();
		
		User u = udaoi.getUserByEmail(email);
		if(u != null) {
			if(u.getPassword().equals(password)) {
				
				HttpSession session = req.getSession();
				session.setAttribute("user", u);
				
				resp.sendRedirect("home.jsp");
			}else {
				resp.sendRedirect("register.jsp");
			}
		}else {
			resp.sendRedirect("faliure.html");
		}
	}
}
