<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="header.jsp" />
<!DOCTYPE html>
<html>
<head>
    <title>Order Confirmation</title>
    <link rel="stylesheet" href="successstyle.css">
</head>
<body>
    <div class="container">
        <h1>Thank You!</h1>
        <p>Your order has been successfully placed.</p>
        <p>We appreciate your business and will notify you once your order is on its way.</p>
        <div class="order-actions">
            <a href="OrderHistoryServlet" class="button">View Order History</a>
            <a href="menu.jsp" class="button">Order More</a>
        </div>
    </div>
    <p>Your order ID is <strong><%= session.getAttribute("orderId") %></strong>.</p>
    
    <jsp:include page="footer.jsp" />
</body>
</html>
