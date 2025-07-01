<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.tap.model.User, com.tap.model.OrderHistory, com.tap.daoimpl.OrderHistoryDAOImpl" %>
<%@ page import="com.tap.daoimpl.RestaurantDAOImpl, com.tap.daoimpl.OrdersDAOImpl"%>
<jsp:include page="header.jsp" />
<!DOCTYPE html>
<html>
<head>
    <title>Order History</title>
    <link rel="stylesheet" href="orderHistorystyle.css">
</head>
<body>
    <div class="container">
        <h1>Order History</h1>
        <%
            // Get the current user from the session
            User user = (User) session.getAttribute("user");

            if (user != null) {
                OrdersDAOImpl odao = new OrdersDAOImpl();
                RestaurantDAOImpl rdao = new RestaurantDAOImpl();
                List<OrderHistory> orders = (List<OrderHistory>)session.getAttribute("ohList");

                if (orders != null && !orders.isEmpty()) {
        %>
                    <table class="order-history-table">
                        <thead>
                            <tr>
                                <th>Order ID</th>
                                <th>Date</th>
                                <th>Restaurant</th>
                                <th>Items</th>
                                <th>Total Amount</th>
                                <th>Status</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                for (OrderHistory order : orders) {
                        		int restId = odao.fetchOnOrderId(order.getOrderId()).getRestId();
                        		String restName = rdao.getRestaurantById(restId).getRestName();
                            %>
                            <tr>
                                <td><%= order.getOrderId() %></td>
                                <td><%= order.getDate() %></td>
                                <td><%= restName %></td>
                                <td>
                                    <form action="OrderDetailsServlet?orderId=<%= order.getOrderId() %>" method="get">
                                        <input type="hidden" name="orderId" value="<%= order.getOrderId() %>">
                                        <button type="submit" class="view-details-btn">View Details</button>
                                    </form>
                                </td>
                                <td>Rs.<%= order.getTotalAmount() %></td>
                                <td><%= order.getStatus() %></td>
                            </tr>
                            <%
                                }
                            %>
                        </tbody>
                    </table>
        <%
                } else {
        %>
                    <p>You have no past orders.</p>
        <%
                }
            } else {
        %>
            <p>Please <a href="login.jsp">log in</a> to view your order history.</p>
        <%
            }
        %>
    </div>
    <jsp:include page="footer.jsp" />
</body>
</html>
