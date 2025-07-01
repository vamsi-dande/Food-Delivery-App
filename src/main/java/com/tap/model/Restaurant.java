package com.tap.model;

import com.tap.daoimpl.RestaurantDAOImpl;

public class Restaurant {

	private int restId;
	private String restName;
	private String cuisineType;
	private boolean isActive;
	private int ratings;
	private String imagePath;
	private int deliveryTime;
	
	public int getRestId() {
		return restId;
	}
	public void setRestId(int restId) {
		this.restId = restId;
	}
	public String getRestName() {
		return restName;
	}
	public void setRestName(String restName) {
		this.restName = restName;
	}
	public String getCuisineType() {
		return cuisineType;
	}
	public void setCuisineType(String cuisineType) {
		this.cuisineType = cuisineType;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public int getRatings() {
		return ratings;
	}
	public void setRatings(int ratings) {
		this.ratings = ratings;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public int getDeliveryTime() {
		return deliveryTime;
	}
	public void setDeliveryTime(int deliveryTime) {
		this.deliveryTime = deliveryTime;
	}
	
	public Restaurant(int restId, String restName, String cuisineType,int deliveryTime, boolean isActive, int ratings, 
			String imagePath) {
		super();
		this.restId = restId;
		this.restName = restName;
		this.cuisineType = cuisineType;
		this.isActive = isActive;
		this.ratings = ratings;
		this.imagePath = imagePath;
		this.deliveryTime = deliveryTime;
	}
	public Restaurant( String restName, String cuisineType,int deliveryTime, 
			String imagePath) {
		super();
		this.restName = restName;
		this.cuisineType = cuisineType;
		this.imagePath = imagePath;
		this.deliveryTime = deliveryTime;
	}
	public Restaurant() {
		super();
	}
	
	@Override
	public String toString() {
		return "Restaurant [restId=" + restId + ", restName=" + restName + ", cuisineType=" + cuisineType
				+ ", isActive=" + isActive + ", ratings=" + ratings + ", imagePath=" + imagePath + ", deliveryTime="
				+ deliveryTime + "]";
	}
	
	public static void main(String[] args) {
		
		Restaurant rest = new Restaurant("Balaji Tiffins","Andhra style",30,"balaji.jpg");
		
		RestaurantDAOImpl rdao = new RestaurantDAOImpl();
		System.out.println(rdao.insertRestaurant(rest));
//		List<Restaurant> list = new ArrayList<Restaurant>();
//		list = rdao.getAllRestaurants();
//		for(Restaurant l : list) {
//			System.out.println(l);
//		}
//		System.out.println(rdao.getRestaurantById(2));
//		System.out.println(rdao.updateRestaurantStatus(2, true));
//		System.out.println(rdao.deleteRestaurantById(2));
	}
}

















