<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.tap.model.Menu" %>
<jsp:include page="header.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Menu List</title>
<link rel="stylesheet" href="Menustyle.css">
</head>
<body>
    <h1>Menu List</h1>
    <div class="menu-container">
        <%
            List<Menu> menuList = (List<Menu>) session.getAttribute("menuList");
            if (menuList != null) {
                for (Menu menuItem : menuList) {
        %>
                    <div class="menu-card">
                        <img src="<%= menuItem.getImagePath() %>" alt="Image of <%= menuItem.getItemName() %>">
                        <h2><%= menuItem.getItemName() %></h2>
                        <p><strong>Description:</strong> <%= menuItem.getDescription() %></p>
                        <p class="price"><strong>Price:</strong> Rs.<%= menuItem.getPrice() %></p>
                        <p class="availability"><strong>Availability:</strong> 
                            <%= menuItem.isAvailable() ? "Available" : "Not Available" %>
                        </p>
                        <form action="CartServlet?itemId=<%= menuItem.getMenuId() %>" method="post">
                            <input type="hidden" name="itemId" value="<%= menuItem.getMenuId() %>">
                            <label for="quantity_<%= menuItem.getMenuId() %>"><strong>Quantity:</strong></label>
                            <input type="number" name="quantity" id="quantity_<%= menuItem.getMenuId() %>" min="1" value="1" required>
                            <button type="submit" class="add-to-cart-btn">Add to Cart</button>
                            <input type="hidden" name="action" value="add">
                        </form>
                    </div>
        <%
                }
            } else {
        %>
                <p>No menu items available.</p>
        <%
            }
        %>
    </div>
    <jsp:include page="footer.jsp" />
</body>
</html>
