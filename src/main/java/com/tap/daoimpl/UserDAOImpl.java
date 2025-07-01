package com.tap.daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tap.DAO.UserDAO;
import com.tap.model.User;

public class UserDAOImpl implements UserDAO {
	
	private PreparedStatement pstmt;
	List<User> list;
	private Statement stmt;
	private ResultSet resultSet;
	private static Connection con;
	private static final String INSERT_USER = "insert into user(username,password,email,address,role) values(?,?,?,?,?)";
	private static final String FETCH_ALL = "select * from user";
	private static final String FETCH_SPECIFIC = "select * from user where userid=?";
	private static final String UPDATE_USER = "update user set address=? where userid=?";
	private static final String DELETE_USER = "delete from user where userid=?";
	private static final String FETCH_BY_EMAIL = "select * from user where email=?";
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinefoods","root","root");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public int insertUser(User user) {
		int x=-1;
		try {
			pstmt = con.prepareStatement(INSERT_USER);
			
			pstmt.setString(1, user.getUserName());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getEmail());
			pstmt.setString(4, user.getAddress());
			pstmt.setString(5, user.getRole());
			
			x = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return x;
	}

	@Override
	public List<User> getAllUsers() {
		try {
			list = new ArrayList<User>();
			stmt = con.createStatement();
			resultSet = stmt.executeQuery(FETCH_ALL);
			list = extractUserFromResultSet(resultSet,list);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public User getSpecificUser(int id) {
		User user = null;
		try {
			pstmt = con.prepareStatement(FETCH_SPECIFIC);
			pstmt.setInt(1, id);
			resultSet = pstmt.executeQuery();
			while(resultSet.next()) {
				user = new User(resultSet.getInt(1),
							resultSet.getString(2),
							resultSet.getString(3),
							resultSet.getString(4),
							resultSet.getString(5),
							resultSet.getString(6)
						);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	public User getUserByEmail(String email) {
		User user = null;
		try {
			pstmt = con.prepareStatement(FETCH_BY_EMAIL);
			pstmt.setString(1, email);
			resultSet = pstmt.executeQuery();
			while(resultSet.next()) {
				user = new User(resultSet.getInt(1),
						resultSet.getString(2),
						resultSet.getString(3),
						resultSet.getString(4),
						resultSet.getString(5),
						resultSet.getString(6)
						);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public int updateUser(int id, String address) {
		int x = -1;
		try {
			pstmt = con.prepareStatement(UPDATE_USER);
			pstmt.setInt(2,id);
			pstmt.setString(1, address);
			x = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return x;
	}

	@Override
	public int deleteUser(int id) {
		int x = -1;
		try {
			pstmt = con.prepareStatement(DELETE_USER);
			pstmt.setInt(1,id);
			x = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return x;
	}
	
	public List<User> extractUserFromResultSet(ResultSet resultSet,List<User> list) {
		try {
			while(resultSet.next()) {
				list.add(new User(resultSet.getInt(1),
							resultSet.getString(2),
							resultSet.getString(3),
							resultSet.getString(4),
							resultSet.getString(5),
							resultSet.getString(6)
						));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
