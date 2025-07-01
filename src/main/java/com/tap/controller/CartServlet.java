package com.tap.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tap.daoimpl.MenuDAOImpl;
import com.tap.model.Cart;
import com.tap.model.CartItem;
import com.tap.model.Menu;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private HttpSession session;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		session = req.getSession();
		Cart cart = (Cart)session.getAttribute("cart");
		
		if(cart==null) {
			cart = new Cart();
			session.setAttribute("cart", cart);
		}
		
		
		int currentRestId = getCurrentRestId(req);
		if(session.getAttribute("firstRestId")==null) {
			session.setAttribute("firstRestId", currentRestId);
		}
		
		String action = req.getParameter("action");
		if(action.equals("add")) {
			addItemToCart(req,cart,currentRestId);
		}else if(action.equals("update")) {
			updateCartItem(req,cart);
		}else if(action.equals("delete")){
			removeItemsFromCart(req,cart);
		}
		
		session.setAttribute("cart", cart);
		resp.sendRedirect("cart.jsp");
	}
	
	private void removeItemsFromCart(HttpServletRequest req, Cart cart) {
		
		int itemId = Integer.parseInt(req.getParameter("itemId"));
		cart.removeItem(itemId);
	}

	private void updateCartItem(HttpServletRequest req, Cart cart) {
		
		int quantity = Integer.parseInt(req.getParameter("quantity"));
		int itemId = Integer.parseInt(req.getParameter("itemId"));
		
		cart.updateItem(quantity, itemId);	
	}

	private void addItemToCart(HttpServletRequest req, Cart cart, int currentRestId) {
		if(currentRestId == (int)session.getAttribute("firstRestId")) {	
			int itemId = Integer.parseInt(req.getParameter("itemId"));
			int quantity = Integer.parseInt(req.getParameter("quantity"));
			
			MenuDAOImpl mdao = new MenuDAOImpl();
			Menu menuItem = mdao.fetchByMenuId(itemId);
			
			if(menuItem != null) {
				CartItem cartItem = new CartItem(
						menuItem.getMenuId(),
						menuItem.getRestId(),	
						menuItem.getItemName(),
						quantity,
						menuItem.getPrice());
					cart.addItem(cartItem);
			}
		}else {
			
		}
		
	}
	
	private int getCurrentRestId(HttpServletRequest req) {
		int itemId = Integer.parseInt(req.getParameter("itemId"));
		MenuDAOImpl mdao = new MenuDAOImpl();
		Menu menu = mdao.fetchByMenuId(itemId);
		return menu.getRestId();
	}
}

















