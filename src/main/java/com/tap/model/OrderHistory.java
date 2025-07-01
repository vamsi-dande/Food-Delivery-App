package com.tap.model;

public class OrderHistory {

	private int orderHistoryId;
	private int userId;
	private int orderId;
	private Float totalAmount;
	private String status;
	private String date;
	
	public OrderHistory(int orderHistoryId, int userId, int orderId, Float totalAmount, String date, String status) {
		super();
		this.orderHistoryId = orderHistoryId;
		this.userId = userId;
		this.orderId = orderId;
		this.totalAmount = totalAmount;
		this.status = status;
		this.date = date;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getOrderHistoryId() {
		return orderHistoryId;
	}
	public void setOrderHistoryId(int orderHistoryId) {
		this.orderHistoryId = orderHistoryId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public Float getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Float totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public OrderHistory(int orderHistoryId, int userId, int orderId, Float totalAmount, String status) {
		super();
		this.orderHistoryId = orderHistoryId;
		this.userId = userId;
		this.orderId = orderId;
		this.totalAmount = totalAmount;
		this.status = status;
	}
	public OrderHistory(int userId, int orderId, String status, float totalAmount) {
		super();
		this.userId = userId;
		this.orderId = orderId;
		this.totalAmount = totalAmount;
		this.status = status;
	}
	public OrderHistory() {
		super();
	}
	
	@Override
	public String toString() {
		return "OrderHistory [orderHistoryId=" + orderHistoryId + ", userId=" + userId + ", orderId=" + orderId
				+ ", totalAmount=" + totalAmount + ", status=" + status + "]";
	}
	
	public static void main(String[] args) {
		
//		new OrderHistory();
//		OrderHistoryDAOImpl odao = new OrderHistoryDAOImpl();
	}
	
}
