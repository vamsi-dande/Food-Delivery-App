package com.tap.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tap.daoimpl.MenuDAOImpl;
import com.tap.model.Menu;

/**
 * Servlet implementation class MenuServlet
 */
@WebServlet("/MenuServlet")
public class MenuServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int restId = Integer.parseInt(req.getParameter("restId"));
		MenuDAOImpl mdao = new MenuDAOImpl();
		List<Menu> menuList = mdao.fetchByRestId(restId);
		req.getSession().setAttribute("menuList", menuList);
		resp.sendRedirect("menu.jsp");
	}

}
