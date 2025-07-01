package com.tap.model;

public class Orders {

	private int orderId;
	private int userId;
	private int restId;
	private float totalAmount;
	private String date;
	private String status;
	private String paymentOption;
	
	public Orders(int userId, int restId, float totalAmount, String status, String paymentOption) {
		super();
		this.userId = userId;
		this.restId = restId;
		this.totalAmount = totalAmount;
		this.status = status;
		this.paymentOption = paymentOption;
	}
	public Orders(int orderId, int userId, int restId, int totalAmount, String status, String paymentOption) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.restId = restId;
		this.totalAmount = totalAmount;
		this.status = status;
		this.paymentOption = paymentOption;
	}
	public Orders(int orderId, int userId, int restId, float totalAmount, String date, String status,
			String paymentOption) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.restId = restId;
		this.totalAmount = totalAmount;
		this.date = date;
		this.status = status;
		this.paymentOption = paymentOption;
	}
	public Orders() {
		super();
	}

	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getRestId() {
		return restId;
	}
	public void setRestId(int restId) {
		this.restId = restId;
	}
	public float getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPaymentOption() {
		return paymentOption;
	}
	public void setPaymentOption(String paymentOption) {
		this.paymentOption = paymentOption;
	}
	
	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", userId=" + userId + ", restId=" + restId + ", totalAmount="
				+ totalAmount + ", status=" + status + ", paymentOption=" + paymentOption + "]";
	}
	
}
