<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.Map, com.tap.model.User" %>
<!DOCTYPE html>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="headerstyle.css">
</head>
<body>
    <header class="header">
        <!-- Navbar -->
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container-fluid">
                <a class="navbar-brand" href="#">Foodie<span>Delivery</span></a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav ms-auto">
                        <li class="nav-item"><a class="nav-link" href="home.jsp">Home</a></li>
                        <li class="nav-item"><a class="nav-link" href="OrderHistoryServlet">Order History</a></li>
                        <li class="nav-item"><a class="nav-link" href="cart.jsp">Cart</a></li>
                        <li class="nav-item"><a class="nav-link" href="LogOutServlet">Log Out</a></li>
                        <% 
                            User u = (User) session.getAttribute("user");
                            if (u != null) {
                        %>
                        <li class="nav-item"><span class="nav-link">Hey, <%= u.getUserName().toUpperCase() %></span></li>
                        <% } else { %>
                        <li class="nav-item"><a class="nav-link" href="login.jsp">Login</a></li>
                        <% } %>
                    </ul>
                </div>
            </div>
        </nav>
    </header>
</body>
</html>
