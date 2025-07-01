package com.tap.daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.tap.DAO.MenuDAO;
import com.tap.model.Menu;

public class MenuDAOImpl implements MenuDAO {
	
	private PreparedStatement pstmt;
	private ResultSet resultSet;
	private static Connection con;
	
	private final String UPDATE_MENU = "update menu set isAvailable=? where menuId=?";
	private final String DELETE_MENU = "delete from menu where menuId=?";
	private final String FETCH_BY_RESTID = "select * from menu where restaurantId=?";
	private final String FETCH_BY_MENUID = "select * from menu where menuId=?";
	private final String INSERT_MENU = "insert into menu(itemName,description,price,"
			+ "imagePath,restaurantId) values(?,?,?,?,?)";
	
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinefoods","root","root");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	@Override
	public int insertMenu(Menu m) {
		int x = -1;
		try {
			pstmt = con.prepareStatement(INSERT_MENU);
			pstmt.setString(1, m.getItemName());
			pstmt.setString(2, m.getDescription());
			pstmt.setFloat(3, m.getPrice());
			pstmt.setString(4, m.getImagePath());
			pstmt.setInt(5, m.getRestId());
			
			x = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return x;
	}

	@Override
	public Menu fetchByMenuId(int menuId) {
		Menu m = null;
		try {
			pstmt = con.prepareStatement(FETCH_BY_MENUID);
			pstmt.setInt(1, menuId);
			resultSet = pstmt.executeQuery();
			if(resultSet.next()) {
				m = new Menu(resultSet.getInt(1),
						resultSet.getString(2),
						resultSet.getString(3),
						resultSet.getFloat(4),
						resultSet.getBoolean(5),
						resultSet.getString(6),
						resultSet.getInt(7)
						);
			}else {
				System.out.println("Not found");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return m;
	}

	@Override
	public List<Menu> fetchByRestId(int restId) {
		List<Menu> list= new ArrayList<Menu>();
		try {
			pstmt = con.prepareStatement(FETCH_BY_RESTID);
			pstmt.setInt(1, restId);
			resultSet = pstmt.executeQuery();
			while(resultSet.next()) {
				list.add(new Menu(resultSet.getInt(1),
						resultSet.getString(2),
						resultSet.getString(3),
						resultSet.getFloat(4),
						resultSet.getBoolean(5),
						resultSet.getString(6),
						resultSet.getInt(7)
						));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int deleteByMenuId(int menuId) {
		int x=-1;
		try {
			pstmt = con.prepareStatement(DELETE_MENU);
			pstmt.setInt(1, menuId);
			x = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return x;
	}

	@Override
	public int updateAvailStatus(boolean isAvail, int menuId) {
		int x=-1;
		try {
			pstmt = con.prepareStatement(UPDATE_MENU);
			pstmt.setBoolean(1, isAvail);
			pstmt.setInt(2, menuId);
			x = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return x;
	}

}
