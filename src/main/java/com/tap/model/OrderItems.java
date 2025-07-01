package com.tap.model;

public class OrderItems {

	private int orderItemsId;
	private int orderId;
	private int menuId;
	private int quantity;
	private float subtotal;
	
	public int getOrderItemsId() {
		return orderItemsId;
	}
	public void setOrderItemsId(int orderItemsId) {
		this.orderItemsId = orderItemsId;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getMenuId() {
		return menuId;
	}
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(int subtotal) {
		this.subtotal = subtotal;
	}
	
	public OrderItems(int orderItemsId, int orderId, int menuId, int quantity, float subtotal) {
		super();
		this.orderItemsId = orderItemsId;
		this.orderId = orderId;
		this.menuId = menuId;
		this.quantity = quantity;
		this.subtotal = subtotal;
	}
	public OrderItems(int orderId, int menuId, int quantity, float subtotal) {
		super();
		this.orderId = orderId;
		this.menuId = menuId;
		this.quantity = quantity;
		this.subtotal = subtotal;
	}
	public OrderItems() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "OrderItems [orderItemsId=" + orderItemsId + ", orderId=" + orderId + ", menuId=" + menuId
				+ ", quantity=" + quantity + ", subtotal=" + subtotal + "]";
	}
	
	
}
