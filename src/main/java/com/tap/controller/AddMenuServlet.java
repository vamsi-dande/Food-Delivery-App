package com.tap.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tap.daoimpl.MenuDAOImpl;
import com.tap.model.Menu;

/**
 * Servlet implementation class AddMenuServlet
 */
@WebServlet("/AddMenuServlet")
public class AddMenuServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int restaurantId = Integer.parseInt(request.getParameter("restaurantId"));
        String menuName = request.getParameter("menuName");
        double price = Double.parseDouble(request.getParameter("price"));
        String description = request.getParameter("description");
        String imagePath = request.getParameter("imagePath");

//        Menu menu = new Menu(restaurantId, menuName, price, description, imagePath);
//        MenuDAOImpl dao = new MenuDAOImpl();
//        dao.addMenu(menu);

        response.sendRedirect("success.jsp"); // Redirect to a success page or menu listing
    }

}
