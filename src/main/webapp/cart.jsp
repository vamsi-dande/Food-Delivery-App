<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.Map, com.tap.model.Cart, com.tap.model.CartItem, com.tap.model.User" %>
<jsp:include page="header.jsp" />
<!DOCTYPE html>
<html>
<head>
    <title>Shopping Cart</title>
    <script src="js/popUpScript.js"></script>
    <link rel="stylesheet" href="cartstyle.css">
</head>
<body>
    <h1>Your Cart</h1>
    <%
        Cart cart = (Cart) session.getAttribute("cart");
        User user = (User) session.getAttribute("user"); // Check if user is logged in
        if (cart != null && !cart.getItems().isEmpty()) {
            float grandTotal = 0;
    %>
        <table>
            <thead>
                <tr>
                    <th>Item Name</th>
                    <th>Price</th>
                    <th>Quantity</th>
                    <th>Sub-total</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <%
                    for (int entry : cart.getItems().keySet()) {
                        CartItem cartItem = cart.getItems().get(entry);
                        String itemName = cartItem.getItemName();
                        double price = cartItem.getPrice();
                        int quantity = cartItem.getQuantity();
                        double subtotal = price * quantity;
                        grandTotal += subtotal;
                %>
                    <tr>
                        <td><%= itemName %></td>
                        <td>Rs.<%= price %></td>
                        <td>
                            <form action="CartServlet?itemId=<%= cartItem.getItemId() %>" method="post" style="display: inline;">
                                <input type="hidden" name="itemId" value="<%= entry %>">
                                <input type="number" name="quantity" min="1" value="<%= quantity %>" required>
                                <button type="submit" class="update-btn">Update</button>
                                <input type="hidden" name="action" value="update">
                            </form>
                        </td>
                        <td>Rs.<%= subtotal %></td>
                        <td class="action-buttons">
                            <form action="CartServlet?itemId=<%= cartItem.getItemId() %>" method="post" style="display: inline;">
                                <input type="hidden" name="itemId" value="<%= entry %>">
                                <button type="submit" class="delete-btn">Delete</button>
                                <input type="hidden" name="action" value="delete">
                            </form>
                        </td>
                    </tr>
                <%
                    }
                %>
            </tbody>
            <tfoot>
                <tr>
                    <td colspan="3" style="text-align: right;"><strong>Grand Total:</strong></td>
                    <td colspan="2">Rs.<%= grandTotal %></td>
                </tr>
            </tfoot>
        </table>
        <!-- Proceed to Checkout Button -->
        <div class="checkout-container" style="text-align: right; margin-top: 20px;">
            <%
            	session.setAttribute("totalAmount",grandTotal);
                if (user != null) { // User is logged in
            %>
                <form action="checkout.jsp" method="get">
                    <button type="submit" class="checkout-btn">Proceed to Checkout</button>
                </form>
            <%
                } else { // User is not logged in
            %>
                <p style="color: red; text-align: center;">Please <a href="login.jsp">log in</a> to proceed to checkout.</p>
            <%
                }
            %>
        </div>
    <%
        } else {
    %>
        <p>Your cart is empty.</p>
    <%
        }
    %>
    <jsp:include page="footer.jsp" />
</body>
</html>
