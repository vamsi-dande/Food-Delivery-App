<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.tap.model.OrderItems, com.tap.daoimpl.MenuDAOImpl, com.tap.model.Menu" %>
<jsp:include page="header.jsp" />
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Order Details</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="orderDetailsstyle.css">
</head>
<body>
    <div class="container">
        <h1 class="my-4">Ordered Items</h1>
        <div class="row">
            <%
                List<OrderItems> oItems = (List<OrderItems>)session.getAttribute("oItems");
                if (oItems != null && !oItems.isEmpty()) {
                    MenuDAOImpl menuDAO = new MenuDAOImpl();
                    for (OrderItems item : oItems) {
                        int menuId = item.getMenuId();
                        Menu menu = menuDAO.fetchByMenuId(menuId);
                        String itemName = menu.getItemName();
                        String description = menu.getDescription();
                        String imagePath = menu.getImagePath();
                        int quantity = item.getQuantity();
                        double subtotal = item.getSubtotal();
            %>
            <div class="col-md-4">
                <div class="card">
                    <img src="<%= imagePath %>" class="card-img-top" alt="<%= itemName %>">
                    <div class="card-body">
                        <h5 class="card-title"><%= itemName %></h5>
                        <p class="card-text"><%= description %></p>
                        <p class="card-text"><strong>Quantity:</strong> <%= quantity %></p>
                        <p class="card-text"><strong>Subtotal:</strong> Rs.<%= subtotal %></p>
                    </div>
                </div>
            </div>
            <%
                    }
                } else {
            %>
            <p>No items found for this order.</p>
            <%
                }
            %>
        </div>
    </div>
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
 <jsp:include page="footer.jsp" />
</body>
</html>
