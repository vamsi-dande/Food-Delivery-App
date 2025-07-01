<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="header.jsp" />
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Restaurant</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="addRestaurantstyle.css">
</head>
<body>
    <div class="container">
        <div class="form-container">
            <h2>Add Restaurant</h2>
            <form action="AddRestaurantServlet" method="get">
                <!-- Restaurant Name -->
                <div class="mb-3">
                    <label for="name" class="form-label">Restaurant Name</label>
                    <input type="text" class="form-control" id="name" name="name" placeholder="Enter restaurant name" required>
                </div>

                <!-- Description -->
                <div class="mb-3">
                    <label for="description" class="form-label">Description</label>
                    <textarea class="form-control" id="description" name="description" rows="3" placeholder="Enter restaurant description" required></textarea>
                </div>

                <!-- Delivery Time -->
                <div class="mb-3">
                    <label for="deliveryTime" class="form-label">Delivery Time (in minutes)</label>
                    <input type="number" class="form-control" id="deliveryTime" name="deliveryTime" placeholder="Enter delivery time" required>
                </div>

                <!-- Image Path -->
                <div class="mb-3">
                    <label for="imagePath" class="form-label">Image Path</label>
                    <input type="text" class="form-control" id="imagePath" name="imagePath" placeholder="Enter image URL or path" required>
                </div>

                <!-- Submit Button -->
                <div class="d-grid">
                    <button type="submit" class="btn btn-primary">Add Restaurant</button>
                </div>
            </form>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
<jsp:include page="footer.jsp" />
</body>
</html>
