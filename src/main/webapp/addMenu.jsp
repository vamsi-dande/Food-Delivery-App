<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Menu</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .form-container {
            max-width: 600px;
            margin: 50px auto;
            padding: 20px;
            border: 1px solid #ddd;
            border-radius: 8px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            background-color: #f9f9f9;
        }
        .form-container h2 {
            text-align: center;
            margin-bottom: 20px;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="form-container">
            <h2>Add Menu Item</h2>
            <form action="AddMenuServlet" method="post">
                <!-- Restaurant ID -->
                <div class="mb-3">
                    <label for="restaurantId" class="form-label">Restaurant ID</label>
                    <input type="number" class="form-control" id="restaurantId" name="restaurantId" placeholder="Enter associated restaurant ID" required>
                </div>

                <!-- Menu Name -->
                <div class="mb-3">
                    <label for="menuName" class="form-label">Menu Name</label>
                    <input type="text" class="form-control" id="menuName" name="menuName" placeholder="Enter menu name" required>
                </div>

                <!-- Price -->
                <div class="mb-3">
                    <label for="price" class="form-label">Price</label>
                    <input type="number" step="0.01" class="form-control" id="price" name="price" placeholder="Enter menu price" required>
                </div>

                <!-- Description -->
                <div class="mb-3">
                    <label for="description" class="form-label">Description</label>
                    <textarea class="form-control" id="description" name="description" rows="3" placeholder="Enter menu description" required></textarea>
                </div>

                <!-- Image Path -->
                <div class="mb-3">
                    <label for="imagePath" class="form-label">Image Path</label>
                    <input type="text" class="form-control" id="imagePath" name="imagePath" placeholder="Enter image URL or path" required>
                </div>

                <!-- Submit Button -->
                <div class="d-grid">
                    <button type="submit" class="btn btn-primary">Add Menu Item</button>
                </div>
            </form>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
