<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.tap.model.User, com.tap.model.Restaurant, com.tap.daoimpl.RestaurantDAOImpl" %>
<jsp:include page="header.jsp" />
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Food Delivery App</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="homestyle.css">
    
</head>
<body>
    

    <!-- Carousel -->
    <div id="demo" class="carousel slide" data-bs-ride="carousel">
        <!-- Indicators -->
        <div class="carousel-indicators">
            <button type="button" data-bs-target="#demo" data-bs-slide-to="0" class="active"></button>
            <button type="button" data-bs-target="#demo" data-bs-slide-to="1"></button>
            <button type="button" data-bs-target="#demo" data-bs-slide-to="2"></button>
            <button type="button" data-bs-target="#demo" data-bs-slide-to="3"></button>
        </div>

        <!-- Slides -->
        <div class="carousel-inner">
            <div class="carousel-item active">
                <img src="carousal1.jpg" alt="Range Rover" class="d-block w-100">
                <div class="carousel-caption">
                    <h3>Range Rover</h3>
                    <p>We had such a great time in LA!</p>
                </div>
            </div>
            <div class="carousel-item">
                <img src="carousal2.jpeg" alt="Maruti Swift" class="d-block w-100">
                <div class="carousel-caption">
                    <h3>Maruti Swift</h3>
                    <p>Thank you, Swift!</p>
                </div>
            </div>
            <div class="carousel-item">
                <img src="carousal3.jpg" alt="Innova" class="d-block w-100">
                <div class="carousel-caption">
                    <h3>Innova</h3>
                    <p>We love the ride!</p>
                </div>
            </div>
            <div class="carousel-item">
                <img src="carousal2.jpeg" alt="Vitara Brezza" class="d-block w-100">
                <div class="carousel-caption">
                    <h3>Vitara Brezza</h3>
                    <p>Make Your Own Ride</p>
                </div>
            </div>
        </div>

        <!-- Controls -->
        <button class="carousel-control-prev" type="button" data-bs-target="#demo" data-bs-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Previous</span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#demo" data-bs-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Next</span>
        </button>
    </div>

    <!-- Add any additional sections here -->
    <!-- Add this section below the Carousel in your existing code -->
    
    
<div class="container mt-5">
    <h2 class="mb-4 text-center">Our Restaurants</h2>
    <div class="row">
        <% 
            // Retrieve the list of restaurants from the DAO
            RestaurantDAOImpl rdao = new RestaurantDAOImpl();
            List<Restaurant> restaurants = rdao.getAllRestaurants();
            if (restaurants != null && !restaurants.isEmpty()) {
                for (Restaurant restaurant : restaurants) {
        %>
        <div class="col-md-4 col-sm-6 mb-4 d-flex align-items-stretch">
            <a href="MenuServlet?restId=<%= restaurant.getRestId() %>" class="card restaurant-card text-decoration-none">
                <img src="<%= restaurant.getImagePath() %>" class="card-img-top" alt="<%= restaurant.getRestName() %>">
                <div class="card-body">
                    <h5 class="card-title text-dark"><%= restaurant.getRestName() %></h5>
                    <p class="card-text text-dark"><%= restaurant.getCuisineType() %></p>
                </div>
            </a>
        </div>
        <% 
                }
            } else {
        %>
        <div class="col-12">
            <p class="text-center">No restaurants available at the moment.</p>
        </div>
        <% 
            } 
        %>
    </div>
</div>

    
	<jsp:include page="footer.jsp" />
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
