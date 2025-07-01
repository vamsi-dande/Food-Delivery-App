package com.tap.DAO;

import java.util.List;

import com.tap.model.Restaurant;

public interface RestaurantDAO {

	int insertRestaurant(Restaurant rest);
	List<Restaurant> getAllRestaurants();
	Restaurant getRestaurantById(int restId);
	int updateRestaurantStatus(int restId, boolean isActive);
	int deleteRestaurantById(int restId);
}
