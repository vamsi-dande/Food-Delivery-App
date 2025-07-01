<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.Map, com.tap.model.Cart" %>
<jsp:include page="header.jsp" />
<!DOCTYPE html>
<html>
<head>
    <title>Checkout</title>
    <link rel="stylesheet" href="checkoutstyle.css">
</head>
<body>
    <h1>Checkout</h1>
    <div class="checkout-container">
        <%
            Cart cart = (Cart) session.getAttribute("cart");
            double grandTotal = 0;
            if (cart != null && !cart.getItems().isEmpty()) {
                for (int entry : cart.getItems().keySet()) {
                    grandTotal += cart.getItems().get(entry).getPrice() * cart.getItems().get(entry).getQuantity();
                }
            } else {
        %>
                <p>Your cart is empty. Please add items to proceed with checkout.</p>
                <a href="menu.jsp" class="btn btn-primary">Go to Menu</a>
        <%
                return;
            }
        %>
        <p><strong>Total Amount: Rs. <%= grandTotal %></strong></p>

        <form action="CheckOut" method="post">
            <div class="form-group">
                <label for="address"><strong>Delivery Address:</strong></label><br>
                <textarea name="address" id="address" rows="4" cols="50" placeholder="Enter your delivery address here" required></textarea>
            </div>

            <div class="form-group">
                <label><strong>Mode of Payment:</strong></label><br>
                <input type="radio" id="cod" name="paymentMode" value="Cash on Delivery" required>
                <label for="cod">Cash on Delivery</label><br>
                <input type="radio" id="card" name="paymentMode" value="Credit/Debit Card" required>
                <label for="card">Credit/Debit Card</label><br>
                <input type="radio" id="upi" name="paymentMode" value="UPI" required>
                <label for="upi">UPI</label>
            </div>

            <div class="form-group">
                <button type="submit" class="btn btn-success">Place Order</button>
            </div>
        </form>
    </div>
    <jsp:include page="footer.jsp" />
</body>
</html>
