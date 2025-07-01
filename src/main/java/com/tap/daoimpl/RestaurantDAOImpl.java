package com.tap.daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tap.DAO.RestaurantDAO;
import com.tap.model.Restaurant;

public class RestaurantDAOImpl implements RestaurantDAO {
	
	private PreparedStatement pstmt;
	private Statement stmt;
	private ResultSet resultSet;
	private static Connection con;
	
	private final String INSERT = "insert into restaurant(RestaurantName,cuisineType,deliveryTime,"
			+ "imagePath) values(?,?,?,?)";
	private final String FETCH_ALL = "select * from restaurant";
	private final String FETCHBY_ID = "select * from restaurant where restaurantId=?";
	private final String UPDATE_STATUS = "update restaurant set isActive=? where restaurantId=?";
	private final String DELETE_REST = "delete from restaurant where restaurantId=?";
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinefoods","root","root");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	@Override
	public int insertRestaurant(Restaurant rest) {

		int x = -1;
		try {
			pstmt = con.prepareStatement(INSERT);
			
			pstmt.setString(1, rest.getRestName());
			pstmt.setString(2, rest.getCuisineType());
			pstmt.setInt(3, rest.getDeliveryTime());
			pstmt.setString(4, rest.getImagePath());
			
			x = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return x;
	}

	@Override
	public List<Restaurant> getAllRestaurants() {

		List<Restaurant> list = new ArrayList<Restaurant>();
		try {
			stmt = con.createStatement();
			resultSet = stmt.executeQuery(FETCH_ALL);
			while(resultSet.next()) {
				list.add(new Restaurant(resultSet.getInt(1),
						resultSet.getString(2),
						resultSet.getString(3),
						resultSet.getInt(4),
						resultSet.getBoolean(5),
						resultSet.getInt(6),
						resultSet.getString(7)
						));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Restaurant getRestaurantById(int restId) {

		Restaurant rest = null;
		try {
			pstmt = con.prepareStatement(FETCHBY_ID);
			pstmt.setInt(1, restId);
			resultSet = pstmt.executeQuery();
			if(resultSet.next()) {
				rest = new Restaurant(resultSet.getInt(1),
						resultSet.getString(2),
						resultSet.getString(3),
						resultSet.getInt(4),
						resultSet.getBoolean(5),
						resultSet.getInt(6),
						resultSet.getString(7));
			}else {
				System.out.println("Not found");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return rest;
	}

	@Override
	public int updateRestaurantStatus(int restId, boolean isActive) {
		int x=-1;
		try {
			pstmt = con.prepareStatement(UPDATE_STATUS);
			pstmt.setInt(2, restId);
			pstmt.setBoolean(1, isActive);
			
			x = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return x;
	}

	@Override
	public int deleteRestaurantById(int restId) {
		int x=-1;
		try {
			pstmt = con.prepareStatement(DELETE_REST);
			pstmt.setInt(1, restId);
			x = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return x;
	}

}
