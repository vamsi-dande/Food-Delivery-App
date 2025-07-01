package com.tap.model;

public class CartItem {
	private int itemId;
	private int restId;
	private String itemName;
	private int quantity;
	private double price;
	
	public CartItem(int itemId, int restId, String itemName, int quantity, double price) {
		super();
		this.itemId = itemId;
		this.restId = restId;
		this.itemName = itemName;
		this.quantity = quantity;
		this.price = price;
	}
	
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public int getRestId() {
		return restId;
	}
	public void setRestId(int restId) {
		this.restId = restId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "CartItem [itemId=" + itemId + ", restId=" + restId + ", itemName=" + itemName + ", quantity=" + quantity
				+ ", price=" + price + "]";
	}
	
}
