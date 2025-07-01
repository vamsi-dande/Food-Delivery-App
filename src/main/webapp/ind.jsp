<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>My Website</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <header>
        <nav class="navbar">
            <div class="logo">MyWebsite</div>
            <div class="nav-links">
                <a href="#" class="nav-item">Home</a>
                <a href="#" class="nav-item">Orders</a>
                <a href="#" class="nav-item">Profile</a>
                <div class="username">
                    <% 
                        String username = "John Doe"; // This could come from your session
                        out.println(username);
                    %>
                </div>
            </div>
            <div class="hamburger">
                <span></span>
                <span></span>
                <span></span>
            </div>
        </nav>
    </header>

    <main>
        <div class="content">
            <h1>Welcome to My Website</h1>
            <p>This is the main content area of the website.</p>
        </div>
    </main>

    <footer>
        <p>&copy; 2024 My Website. All rights reserved.</p>
    </footer>

    <script src="script.js"></script>
</body>
</html> 